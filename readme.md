## Hello Candidate

Welcome to the "zoo", please help to complete the coding in this project according to the following 
requirements within 45 minutes.

## Project Structure

This is a Spring Boot application for managing a zoo. The project follows a standard Maven structure with layered architecture.

### Directory Layout

```
zoo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/qima/test/zoo/
│   │   │       ├── Starter.java              # Spring Boot application entry point
│   │   │       ├── bean/                      # Domain models and DTOs
│   │   │       │   ├── Animal.java            # Animal entity model
│   │   │       │   ├── AnimalCategory.java    # Enum for animal categories
│   │   │       │   ├── ReportVO.java          # Value object for digest report
│   │   │       │   └── Status.java            # Enum for animal status
│   │   │       ├── controller/                # REST API controllers
│   │   │       │   └── ZooController.java     # Main controller for zoo operations
│   │   │       ├── dao/                       # Data access layer
│   │   │       │   └── ZooClient.java         # Client for animal data queries
│   │   │       └── service/                   # Business logic layer
│   │   │           └── ZooService.java        # Service for zoo operations
│   │   └── resources/
│   │       └── application.yml                # Application configuration and animal data
│   └── test/
│       └── java/
│           └── com/qima/test/zoo/
│               ├── StarterTests.java          # Application startup tests
│               └── controller/
│                   └── ZooControllerTests.java # Controller unit tests
├── pom.xml                                    # Maven project configuration
└── readme.md                                  # This file
```

### Technology Stack

- **Framework**: Spring Boot 2.5.1
- **Java Version**: 11
- **Build Tool**: Maven
- **Key Dependencies**:
  - Spring Boot Starter Web
  - Lombok (for reducing boilerplate code)
  - Spring Boot DevTools
  - Spring Boot Test

### Application Architecture

The application follows a **three-tier architecture**:

1. **Controller Layer** (`controller/`): Handles HTTP requests and responses
   - `ZooController`: Exposes REST APIs for animal operations
   
2. **Service Layer** (`service/`): Contains business logic
   - `ZooService`: Implements zoo management logic and report generation
   
3. **Data Access Layer** (`dao/`): Manages data retrieval
   - `ZooClient`: Provides methods to query animal data

### Configuration

- **Server Port**: 8010 (configured in `application.yml`)
- **Animal Data**: Pre-configured in `application.yml` under `data.animals`
- **Access Logging**: Enabled for Tomcat

### Building and Running

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Or run the JAR file
java -jar target/zoo-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8010`

### Available Endpoints

- `GET /zoo/animals` - Retrieve all animals
- `GET /zoo/report` - Get digest report of zoo statistics

### Task A: Digest Report

Managing a zoo is never an easy job, so we have created a profile for each of the animals in the zoo like below, you can call `GET /zoo/animals` to get all raw data.
```JSON
{
   "id": "a000001",
   "name": "Lulu",
   "category": "MOUSE",
   "height": 0.05,
   "weight": 0.5,
   "sourceCountry": "China",
   "birthTime": 1623919916000,
   "statue": "ALIVE"
}
```
Now, we want you to aggregate these raw data and convert to a digest report like below, and provide an API in the `ZooController` to return the result.
```JSON
{
   "overall": {
      "aliveCount": 3,
      "deadCount": 1,
      "lightestOne": "AaAa",
      "shortestOne": "BbBb",
      "oldestOne": "CcCc"
   },
   "size": {
      "Small animal count": 1,
      "Medium animal count": 1,
      "Large animal count": 1
   },
   "sourceCountry": {
      "China": 1,
      "Mexico": 1,
      "...": 1
   },
   "category": {
      "Mouse": 1,
      "Ox": 1,
      "...": 1
   }
}
```

#### Notes

+ We already had provided methods in ZooClient under dao folder to query all animals, you can use them to get the raw data you need
+ In `Size`, `sourceCountry`, `category` these three sections in the JSON body, we only count alive animals.
In other words, the summation of all items under each of them should equal the value of `overall.aliveCount`.
+ In `Size` section, animal size definition matrix as below:  
   | Size category | weight |
   | -- | -- |
   | Small animal | 30 < |
   | Medium animal | 30 <= && < 150 |
   | Large animal | 150 <= |
+ The sequence under sourceCountry should be natural ordering.
+ The sequence under category should according to the index value of `AnimalCategory` in ASC.
+ Please make the code clean, elegant, efficient as possible as you can.

### Task B: Animal talent show

To keep the zoo consistently running, we need to let these animals play some talent show to earn money. However, different animals have different performances, so please work out an API to response different value according to the different AnimalCategory in request params. 

#### Notes

+ Please use factory design pattern to implement the API.
+ Please make sure the API can meet following 2 cases, no need to extends to other cases.
Request: `GET /zoo/show?cagetory=DOG`  ->  Response: `Bark bark!` 
Request: `GET /zoo/show?cagetory=MONKEY`  ->  Response: `Tell a joke!` 
  

### Task C: RESTful API for animal management

To better manage the animals, we need a series of RESTful APIs to add/delete/update/query the animals in the zoo. Please help to provide these APIs in the `ZooController`, ***just declare them, no implement***.
