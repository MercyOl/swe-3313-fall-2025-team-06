# README.md

## Introduction
This application is a web-based storefront created for academic purposes. It allows users to browse a fictional inventory of products, add items to a shopping cart, and complete a simulated checkout process. 

## Disclaimer
Some portions of this project such as parts of the README documentation and parts of the HTML/CSS code, were edited and/or refined with assistance from ChatGPT for efficiancy and to maintain presentation. 

## 1. Environment Setup

To run this project, you will need:

* **Java 23* installed and added to your PATH
* **Maven** (comes with IntelliJ. It can also be installed if IntelliJ behaves strangely)
* **IntelliJ IDEA** (Community Edition is sufficient)

### Steps to run:

1. Clone the repository into your local machine.
2. Open IntelliJ → *Open Project* → select the project folder.
3. Wait for IntelliJ to load Maven dependencies.
4. Ensure the Java SDK is set (File → Project Structure → SDK).
5. The project should build automatically once dependencies resolve.

---

## 2. Database Setup

This project loads data from JSON files. i.e.:

```
src/main/resources/static/data/items.json
```

This file contains all available products in the store.
When the application starts, Spring Boot reads this JSON file and converts each entry into an `Item` object that is displayed on the application.

To update inventory, edit **items.json**.

---

## 3. How to Start Application and Login

### 3.1 Starting the Application

You can start the application in two ways:

### **1. Using IntelliJ**

* Open the project
* Locate `Application.java`
* Click **Run**

### **2. Using Maven**

Open a terminal inside the project folder:

```
mvn spring-boot:run
```

### 3.2 Login Instructions

The application supports two types of users: regular users and admins.

### **Regular Users**

Anyone can create a standard user account through the self registration process and use the full application.

### **Admin Users**

Admin access is restricted using a simple internal login.

### **Admin Credentials**

* **Username:** `SchmenAdmin`
* **Password:** `Schmendrick1234`

These credentials allow access to internal admin-only functions, such as the sales report.

Note: Inventory is still managed manually through the JSON file. The UI to update inventory will be implemented in V2.

---

## 4. Troubleshooting

### **Common Issues and Fixes**

#### **1. Server won't start (port 8080 already in use)**

Another application is using port 8080.
Fix:

```
change server.port in application.properties
or
close the other program
```

#### **2. Build fails due to missing dependencies**

Try:

```
mvn clean install
```

Or reload Maven in IntelliJ.

### **3. Incorrect version of Java**

Fix:

install Java 23 [here](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html?utm_source=chatgpt.com)

