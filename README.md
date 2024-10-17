# POSFusion-POS-Spring-API

## Introduction
A POS RESTful API built with Spring Framework, handling Customer, Item, Order, and OrderDetail management. It supports CRUD operations and transaction management, using Hibernate for ORM and JPA for repository handling.

## Technologies Used
- **Java 17**
- **Spring Framework**
- **Hibernate ORM**
- **Spring Data JPA**
- **ModelMapper**
- **Logback**
- **MySQL**

## Features
- **Customer Management (Create, Read, Update, Delete)**
- **Item Management (Create, Read, Update, Delete)**
- **Order and Transaction Processing**
- **Exception Handling and Validation using Hibernate Validator**
- **JSON Response formatting**

## Validation

Validation is implemented using Hibernate Validator annotations in the DTO classes to ensure data integrity and correctness.

## Logging

Logging is configured using Logback. Logs are written to both the console and a file.

## Postman Documentation

For detailed API documentation and testing, please refer to the [Postman API Documentation](https://documenter.getpostman.com/view/37565373/2sAXxV6pte).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Getting Started

### Prerequisites
To run this project, ensure you have the following installed:
- **Java Development Kit (JDK) 17 or higher**
- **Apache Tomcat (10.1.24)**
- **MySQL**
- **Maven**

### Running the Application
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yasith-chathuranga/posfusion-pos-spring-api.git

3. Update the MySQL database configuration in `WebAppRootConfig.java`:
    ```java
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/posfusion?createDatabaseIfNotExist=true");
        dmds.setUsername("root");
        dmds.setPassword("your_password");
        return dmds;
    }


##
<div align="center">
<a href="https://github.com/yasith-chathuranga" target="_blank"><img src = "https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></a>
<a href="https://git-scm.com/" target="_blank"><img src = "https://img.shields.io/badge/Git-100000?style=for-the-badge&logo=git&logoColor=white"></a>
<a href="https://spring.io/projects/spring-framework" target="_blank"><img src = "https://img.shields.io/badge/Spring_Framework-100000?style=for-the-badge&logo=spring&logoColor=white"></a>
<a href="https://spring.io/projects/spring-data-jpa" target="_blank"><img src = "https://img.shields.io/badge/Spring_Data_JPA-100000?style=for-the-badge&logo=spring&logoColor=white"></a>
<a href="https://hibernate.org/orm/" target="_blank"><img src = "https://img.shields.io/badge/Hibernate-100000?style=for-the-badge&logo=Hibernate&logoColor=white"></a>
<a href="https://tomcat.apache.org/" target="_blank"><img src = "https://img.shields.io/badge/Tomcat-100000?style=for-the-badge&logo=apachetomcat&logoColor=white"></a>
<a href="https://logback.qos.ch/documentation.html" target="_blank"><img src = "https://img.shields.io/badge/Logback-100000?style=for-the-badge&logo=ko-fi&logoColor=white"></a>
<a href="https://maven.apache.org/download.cgi" target="_blank"><img src = "https://img.shields.io/badge/Maven-100000?style=for-the-badge&logo=apachemaven&logoColor=white"></a>
<a href="https://www.mysql.com/downloads/" target="_blank"><img src = "https://img.shields.io/badge/Mysql-100000?style=for-the-badge&logo=mysql&logoColor=white"></a>
<a href="https://www.postman.com/downloads/" target="_blank"><img src = "https://img.shields.io/badge/Postman-100000?style=for-the-badge&logo=Postman&logoColor=white"></a>
</div> <br>
<p align="center">
  &copy; 2024 Yasith Chathuranga
</p>