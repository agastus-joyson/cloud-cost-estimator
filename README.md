# Cloud Cost Estimator

A full-stack web application to **estimate cloud resource costs** based on selected **resource types**, **resource names
**, **regions**, and **usage units**.  
Built with **Spring Boot** (Java) and **React + Tailwind CSS**.

---

## 📜 Description

The Cloud Cost Estimator allows users to:

1. Select resource types (e.g., Compute, Storage).
2. View available resources for the selected type.
3. View available regions for the selected resource.
4. Enter usage units for multiple resources.
5. Submit the request and receive:
    - **Total estimated cost**
    - **Detailed cost breakdown per resource**
6. Retrieve previously submitted estimates with all associated details.

The backend stores resource pricing in a database and calculates costs dynamically.

---

## 🛠 Tech Stack

### **Frontend**

- **React** (JavaScript)
- **Tailwind CSS** for styling
- **Recharts** for visualization
- **Axios** for API calls

### **Backend**

- **Java 17** with **Spring Boot**
- **Spring Data JPA** for database access
- **PostgreSQL** as the database
- **Lombok** for reducing boilerplate
- **Maven** for build and dependency management

---

## ⚙️ Setup Instructions

### 1️⃣ **Clone the repository**

```bash
git clone https://github.com/your-username/cloud-cost-estimator.git
cd cloud-cost-estimator
```

### 2️⃣ **Configure Database**

Edit src/main/resources/application.properties (or application.yml) to set your PostgreSQL credentials:

```bash
spring.datasource.url=your_db_url
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
```

### 3️⃣ **Run the application**

```bash
mvn spring-boot:run
```

The backend will start at http://localhost:8080.