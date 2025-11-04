package org.example.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Item;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDAO {
    private final List<Item> itemsData;
    private final Gson gson = new Gson();

    private static final String JSON_FILE_PATH = "/recursos/items.json";

    public ItemDAO() {
        this.itemsData = loadItemsFromJSON();
    }

    private List<Item> loadItemsFromJSON() {
        try {
            InputStreamReader reader = null;
            if (getClass().getResourceAsStream(JSON_FILE_PATH) != null) {
                reader = new InputStreamReader(getClass().getResourceAsStream(JSON_FILE_PATH));
            } else {
                System.err.println("No se encontró el archivo JSON en la ruta: " + JSON_FILE_PATH);
                return new ArrayList<>();
            }

            Type itemListType = new TypeToken<ArrayList<Item>>() {}.getType();
            List<Item> items = gson.fromJson(reader, itemListType);

            if (items == null) items = new ArrayList<>(); // si JSON estaba vacío
            System.out.println("Se cargaron " + items.size() + " items del JSON.");

            return items;
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo JSON: " + JSON_FILE_PATH);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Item> getItemsByPriceRange(Double minPrice, Double maxPrice) {
        return itemsData.stream()
                .filter(item -> (minPrice == null || item.getPrice() >= minPrice) &&
                        (maxPrice == null || item.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }

    public List<Item> getAllItems() {
        return itemsData;
    }

    public Item getItemById(String id) {
        return itemsData.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public boolean addItem(Item item) {
        if (getItemById(item.getId()) != null) return false;
        itemsData.add(item);
        return true;
    }

    public boolean updateItem(String id, Item item) {
        Item existingItem = getItemById(id);
        if (existingItem == null) return false;

        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setPrice(item.getPrice());

        return true;
    }

    public boolean deleteItem(String id) {
        return itemsData.removeIf(item -> item.getId().equals(id));
    }

    public boolean itemExists(String id) {
        return getItemById(id) != null;
    }
}