# Philly Transit using Kernel Regression

The purpose of this project is to **pinpoint Philly Bus Arrival Times** at their stops. Currently, the Septa API only updates every few minutes, leading to inaccuracy in bus arrival times. We are modeling the data shown in this [Conference Paper](https://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=6338767).

## Installation
* [Java JDK v1.8+](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Gradle v4.10+](https://gradle.org/install/)

## Running the microservices
```console
$  git clone https://github.com/jimmychung98/learnSEPTA-backend.git
$  cd learnSEPTA-backend
$  gradle clean build
$  cd name_of_microservice
$  gradle run
```
To be more Specific...
```console
$  git clone https://github.com/jimmychung98/learnSEPTA-backend.git
$  cd learnSEPTA-backend
$  gradle clean build
$  cd septa-data-server
$  gradle run
```


## Philly Transit Microservices
+ **septa-data** - is a ***crud*** service that grabs data from the Septa API. Ideally, it should grab all the bus locations for a specific route and it should calculate the arrival times for each bus parallel from each other. It should store the data in a databse via a different microservice.
+ **microservice-name** - format for future reference.

## Planned Roadmap
* [ ] Create a microservice to store and grab data from a database
* [ ] Design the database and need to pick if we are using a relational or nonrelational database
* [ ] Need to calculate the total distance a bus takes in its route
* [ ] What variables do we need for the Kernel Regression?