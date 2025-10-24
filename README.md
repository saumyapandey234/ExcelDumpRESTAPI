# Excel to MySQL REST API (Spring Boot)

# Project Overview
This project is a **Spring Boot REST API** that uploads an Excel file and automatically **dumps (inserts)** its data into a **MySQL database**.  
It is built to simplify bulk data import operations where users can send Excel files via API, and the server will parse and store the data efficiently.

# Features
- Upload Excel files through REST API
- Automatically convert Excel rows into Java objects (Entity)
- Save all Excel(xls/xlsx) data directly into MySQL
- API tested successfully using **Postman**
- Proper error handling for invalid files and data formats

# Technologies Used
- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **MySQL Database**
- **Apache POI**(for reading Excel files)
- **Postman** (for testing the API)
  
# Project Structure
ExcelToSql/
├── src/main/java/DumpExcelToSql/
│ ├── Controller/
│ │ └── ProductController.java
│ ├── Service/
│ │ └── ProductService.java
│ ├── Repositories/
│ │ └── PdtRepo.java
│ ├── entity/
│ │ └── Product.java
│ └── ExcelToSqlApplication.java
├── resources/
│ └── application.properties
└── pom.xml

## How It Works
1. **Upload Excel File via Postman**
   Endpoint:POST/upload
   Form-Data Key: `file`
   Value: Choose your Excel file(e.g.`products.xlsx`)

2. **Process**
   - The Excel file is parsed using **Apache POI**.
   - Data is converted into a list of `Product` entities.
   - All data is saved into the MySQL table.

3. **Retrieve Data**
   - Endpoint:GET/product

# Testing with Postman

# Upload Excel File
- Method: **POST**
- URL: `http://localhost:8080/upload`
- Body → form-data → Key: `file` → Type: **File**
- Choose your Excel file.
- Expected Response:
- json
  {
    "message": "File uploaded successfully and data saved to database!"
  }
# Fetch All Products
Method: GET
URL: http://localhost:8080/product
Expected Response:
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 45000.0,
    "quantity": 10
  }
]
# how to run??
*Clone the repository:
git clone https://github.com/your-username/ExcelToSql.git
*Open the project in your IDE (e.g. IntelliJ / Eclipse)
*Update your MySQL credentials in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
* run the application using
* mvn spring-boot:run

# Author

Saumya Pandey
Email: saumya1617pandey@gmail.com 





