This project is a web application built using the **Spark Java Framework (v2.9.4)**.  
It allows users to manage **items, users, and offers**, with **real-time price updates** powered by **WebSockets**.

Users can:
- Browse a list of items.
- View detailed information for each item.
- Create and view offers.
- Receive **instant price updates** without refreshing the page.

---

## ⚙️ Technologies Used

| Technology / Library | Description |
|----------------------|-------------|
| **Java 17** | Main programming language. |
| **Spark Java (2.9.4)** | Lightweight web framework for HTTP routing and server handling. |
| **Mustache Templates (2.7.1)** | Template engine for rendering dynamic HTML pages. |
| **Gson (2.10.1)** | JSON serialization and deserialization for Java objects. |
| **Jetty WebSocket (9.4.50.v20221201)** | Enables real-time, two-way communication between server and client. |
| **MySQL Connector (9.4.0)** | Connects the app to a MySQL database. |
| **Logback + SLF4J** | Logging and debugging system. |
| **TailwindCSS (via CDN)** | CSS framework used for responsive UI styling. |



<img width="388" height="664" alt="image" src="https://github.com/user-attachments/assets/474c6998-4f39-4375-916b-17118f8c1b4f" />

<img width="382" height="422" alt="image" src="https://github.com/user-attachments/assets/0d58a37e-d2b2-4cb2-a52f-89f634c677ad" />


| **Resource** | **URL** | **Description** |
|---------------|----------|----------------|
|  **Item list** | [`http://localhost:4567/items`](http://localhost:4567/items) | Displays all available items. |
|  **Item detail** | [`http://localhost:4567/items/{id}`](http://localhost:4567/items/1) | Shows detailed information about a specific item, including live price updates. |
|  **Offer list** | [`http://localhost:4567/offers`](http://localhost:4567/offers) | Lists all submitted offers. |
|  **New offer form** | [`http://localhost:4567/offers/new`](http://localhost:4567/offers/new) | Allows users to create a new offer. |
|  **User list** | [`http://localhost:4567/users`](http://localhost:4567/users) | Displays all registered users. |
| **WebSocket endpoint** | `ws://localhost:4567/ws` | Real-time WebSocket channel for live price updates. |

---

## WebSocket Functionality

The **`PriceWebSocket.java`** class enables live communication between the server and clients so that any price changes are instantly reflected on the web interface.

