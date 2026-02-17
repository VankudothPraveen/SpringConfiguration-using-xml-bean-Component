# 📦 JDBC CRUD Management System (Person, Product, Phone)

This project is a **Java JDBC-based console application** that demonstrates CRUD operations using a **layered architecture (Entity → DAO → Implementation → UI)** with a MySQL database.

The project contains three modules:

- 👤 Person Management
- 🛍 Product Management
- 📱 Phone Management

It is designed to practice:

- JDBC Connectivity
- DAO Design Pattern
- MySQL Database Operations
- Java Collections & Streams
- Clean Architecture

---

# 🚀 Technologies Used

- Java (JDK 8+)
- JDBC
- MySQL
- IntelliJ IDEA 
- Maven 

---

# 📂 Project Structure

---
<img width="497" height="352" alt="image" src="https://github.com/user-attachments/assets/cb88bd1a-8b20-4624-a668-51a6069c1947" />

---
## 👤 Person Module Methods

### 1️⃣ addPerson(Person person)
Adds a new person record into the database.

---

<img width="536" height="250" alt="image" src="https://github.com/user-attachments/assets/bd2a59cb-eaf5-4b0f-b713-bd06ec917023" />


---

### 2️⃣ findAll()
Retrieves all person records from the database and returns them as a list.

---

<img width="793" height="273" alt="image" src="https://github.com/user-attachments/assets/4b2d22c9-03df-4233-85e4-ee28d5a83c38" />

---

### 3️⃣ deleteById(int id)
Deletes a person from the database based on the given ID.

---

<img width="657" height="220" alt="image" src="https://github.com/user-attachments/assets/cf09d970-a199-4860-9daa-4f7a5f02f626" />


---

### 4️⃣ findById(int id)
Fetches a single person record using the provided ID.  
Returns `null` if the person is not found.
---

<img width="645" height="223" alt="image" src="https://github.com/user-attachments/assets/931b15d0-12a2-4eaf-8c3b-59000a726ac3" />


---

### 5️⃣ findByFnameContaining(String name)
Searches for persons whose first name contains the given keyword using a partial match.

Example:
If input is `"ra"` → matches `"Praveen"`, `"Ramesh"`.
---

<img width="632" height="138" alt="image" src="https://github.com/user-attachments/assets/1b63ebf9-289f-4c11-8b0f-b188fcea27db" />


---

### 6️⃣ findSortedByFname()
Retrieves all persons sorted alphabetically by first name.
---

<img width="675" height="289" alt="image" src="https://github.com/user-attachments/assets/abc9dcb7-43f4-43a4-8678-e1e86a44e78a" />

---

### 7️⃣ existId(int id)
Checks whether a person with the given ID exists in the database.

Returns:
- `true` → if exists  
- `false` → if not exists
  ---

<img width="685" height="218" alt="image" src="https://github.com/user-attachments/assets/143d1687-cb82-44cf-b719-d633f64733d1" />

---

## 🛍 Product Module Methods

### 1️⃣ addProduct(Product product)
Adds a new product record into the database with details like name, cost, brand, category, rating, and discount percentage.

---

<img width="903" height="294" alt="image" src="https://github.com/user-attachments/assets/2cd7b3a7-68ab-4e9e-919b-fa90ce6ad72e" />
<img width="619" height="264" alt="image" src="https://github.com/user-attachments/assets/a89bf076-bb19-46e7-8877-b3623479bac8" />

---

### 2️⃣ findAll()
Retrieves all product records from the database and returns them as a list.

---

<img width="847" height="392" alt="image" src="https://github.com/user-attachments/assets/fd8bea70-9195-407d-ad3d-11c99e0946fe" />


---

### 3️⃣ sortByCostAscending()
Fetches all products sorted by cost in ascending order (lowest price to highest).
---

<img width="846" height="392" alt="image" src="https://github.com/user-attachments/assets/b37075af-598e-4221-a4d0-112932bf5985" />


---

### 4️⃣ sortByCostDescending()
Fetches all products sorted by cost in descending order (highest price to lowest).
---

<img width="884" height="407" alt="image" src="https://github.com/user-attachments/assets/39f88916-eca9-4a17-a507-792050cb87da" />


---

### 5️⃣ sortByDiscountAscending()
Retrieves products sorted by discount percentage in ascending order.
---

<img width="869" height="396" alt="image" src="https://github.com/user-attachments/assets/9a746bd5-bb16-463b-bbf8-a8c93fa738f5" />


---

### 6️⃣ sortByDiscountDescending()
Retrieves products sorted by discount percentage in descending order.
---

<img width="861" height="389" alt="image" src="https://github.com/user-attachments/assets/201f7129-57c6-484b-9f85-5511af1129df" />


---

### 7️⃣ sortByRating()
Fetches products sorted by rating (usually highest rated products first).
---

<img width="854" height="392" alt="image" src="https://github.com/user-attachments/assets/b479de78-0091-40a7-a31f-e6d48ed0adee" />


---

### 8️⃣ filterByName(String name)
Searches for products whose names contain the given keyword using partial matching.

Example:
If input is `"phone"` → matches `"iPhone"`, `"OnePlus Phone"`.
---

<img width="825" height="336" alt="image" src="https://github.com/user-attachments/assets/94b4ad0b-411e-405c-9384-b9115ff1093e" />


---

### 9️⃣ filterByBrand(String brand)
Retrieves all products belonging to a specific brand.

Example:
Input `"Samsung"` → returns all Samsung products.
---

<img width="809" height="295" alt="image" src="https://github.com/user-attachments/assets/5bf40a60-0fc2-4dff-aa3d-17486d1f74ae" />


---

### 🔟 filterByCategory(String category)
Fetches products that belong to a specific category.

Example:
Input `"Electronics"` → returns all electronic products.
---

<img width="874" height="346" alt="image" src="https://github.com/user-attachments/assets/1b335ff5-40e3-458c-aede-5dd734f947f1" />


---

### 1️⃣1️⃣ filterByMinCost(double minCost)
Retrieves products whose cost is greater than the given minimum value.
---

<img width="861" height="408" alt="image" src="https://github.com/user-attachments/assets/0f7517fd-e53e-40ee-8a9a-4ea709279ee6" />


---

### 1️⃣2️⃣ filterByMaxCost(double maxCost)
Retrieves products whose cost is less than the given maximum value.
---

<img width="810" height="270" alt="image" src="https://github.com/user-attachments/assets/c917295d-1d05-42ac-a0ef-ec575deeef4b" />


---




