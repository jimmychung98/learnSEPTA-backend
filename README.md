# learnSEPTA using Kernel Regression

The purpose of this project is to use machine learning non-parametric algorithms to **better predict SEPTA bus arrival times**. We are modeling the data shown in this [Conference Paper](https://ieeexplore.ieee.org/stamp/stamp.jsp?arnumber=6338767).

## Installation
* [Java JDK v1.8+](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Gradle v4.10+](https://gradle.org/install/)
* [Python v3.6+](https://www.python.org/download/releases/3.0/)
* [Postgres 9.6+](https://www.postgresql.org/download/)

## Database Setup
* Download [Postgres 9.6+](https://www.postgresql.org/download/)
* Go to PostGres Console and enter the following commands
```console
postgres=# CREATE DATABASE learnsepta_db;
postgres=# CREATE USER learnsepta WITH LOGIN PASSWORD 'learnsepta';
postgres=# ALTER USER learnsepta SUPERUSER CREATEDB CREATEROLE;
postgres=# ALTER DATABASE learnsepta_db OWNER TO learnsepta; 
```
* Make sure the port is on port 5433

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
$  cd septa-data
$  gradle run
```

## Editing the Kernel Regression Components
```console
$  cd learn
$  source venv/bin/activate          # activate the venv for your specific OS
$  pip freeze > requirements.txt     # make sure the requirements.txt are updated
$  pip install -r requirements.txt   # make sure all of the packages are installed
```

## Philly Transit Microservices
+ **septa-data** - is a ***CRUD*** service that grabs data from the Septa API. Ideally, it should grab all the bus locations for a specific route and it should calculate the arrival times for each bus parallel from each other. It should store the data in a databse via a different microservice.
+ **data-repository** - connects to a PostGres Database. This microservice is mainly used by other microservices to store and retrieve data in the repository. Database must be setup first before you can use this microservice.
+ **microservice-name** - format for future reference.

## Planned Roadmap
* [ ] Create a microservice to store and grab data from a database
* [ ] Design the database and need to pick if we are using a relational or nonrelational database
* [X] Need to calculate the total distance a bus takes in its route
* [ ] Need to calculate the arrival times of a given bus at a given stop
* [ ] What variables do we need for the Kernel Regression?

## Communication
* [Slack Link](https://join.slack.com/t/learnsepta/shared_invite/enQtNDY5MjU0MzIzMjIxLTE1MTY3ZmQ0MzI3MjhiYmM2M2Y1ZTA2OGU4ZjFjMjQ1ZDQyYzEzMzY0YzE2MWI3NzZlZTcwNjY5NTYyY2ZhMzM)
