# **CitizenConnect Service Management**

**CitizenConnect Service Management** is a microservices-based application designed to handle citizen-related data and vaccination center information. The project leverages **Eureka** for service discovery, **Spring Cloud Gateway** for API Gateway implementation, and microservices for individual functionalities.

---

## **Project Overview**
CitizenConnect is a distributed system that provides modular services for managing citizens and vaccination centers. By decoupling these functionalities into distinct microservices, it ensures **scalability**, **reliability**, and **high maintainability**.

### **Microservices**
1. **Citizen Service**: Manages citizen details and associates citizens with vaccination centers.
2. **Vaccination Center Service**: Manages details about vaccination centers and their resources.
3. **API Gateway**: Centralized routing layer to manage communication between clients and microservices.
4. **Eureka Server**: Service registry for dynamic service discovery.

---

## **Key Features**
- **Eureka Client Discovery**: Dynamic discovery and registration of services with Eureka Server.
- **Spring Cloud Gateway**: Route and load-balance API requests.
- **Circuit Breaker**: Graceful fallback for Vaccination Center Service when Citizen Service is unavailable.
- **Microservices Architecture**: Modular design for scalability.
- **RestTemplate Integration**: Service-to-service communication.

---

## **Technologies Used**
- **Spring Boot**: Microservice implementation.
- **Spring Cloud Gateway**: API Gateway for centralized routing.
- **Spring Data JPA**: Persistence layer for database interactions.
- **Eureka**: Service discovery and registration.
- **MySQL**: Data persistence for microservices.

---

## **Endpoints and Features**

### **Citizen Service**
| HTTP Method | Endpoint             | Description                                 |
|-------------|----------------------|---------------------------------------------|
| GET         | `/citizen/test`      | Test the service.                          |
| GET         | `/citizen/id/{id}`   | Fetch all citizens in a specific center.   |
| POST        | `/citizen/add`       | Add a new citizen to the database.         |

---

### **Vaccination Center Service**
| HTTP Method | Endpoint                       | Description                                           |
|-------------|--------------------------------|-------------------------------------------------------|
| POST        | `/vaccination-center/add`      | Add a new vaccination center.                        |
| GET         | `/vaccination-center/id/{id}`  | Fetch center details and associated citizens.         |

---

### **Eureka Server**
- Access Eureka Dashboard: `http://localhost:8761`

---

### **API Gateway**
- **Centralized Routing**: Uses **Spring Cloud Gateway** for routing and load balancing.
- **Examples**:
  - `/citizen/**` routes to **Citizen Service**.
  - `/vaccination-center/**` routes to **Vaccination Center Service**.

---

## **Getting Started**

### **Prerequisites**
- Java 11+
- Maven
- MySQL/PostgreSQL
- Eureka Server and Spring Cloud Gateway dependencies

### **How to Run the Project**
1. Clone the repository:
   git clone <repository-url>
   cd CitizenConnect

2. Start Eureka Server:

  cd EurekaServer
  mvn spring-boot:run

3. Start Citizen Service:
  cd CitizenService
  mvn spring-boot:run

4. Start Vaccination Center Service:
  cd VaccinationCenter
  mvn spring-boot:run

5. Start API Gateway:
  cd api-gateway
  mvn spring-boot:run

6.Access the services via the following URLs:
  Eureka Server: http://localhost:8761
  API Gateway: http://localhost:8084

