# Projet Spring Hibernate

This is a project for the J2ee lesson of the TSI courses at [Ecole Nationale des Sciences Géographiques](www.ensg.eu).

The aim was to implement an MVC application with SpringBoot and Hibernate which had to manage events and their participants by at least:
* Listing events
* Listing participants
* Adding participant to event

---

## The application

### Model

* A event has a list of participants.
* A participant can take part in only one event
    * **NB:** A user of the application would have to create a participant profile for each event he wants to attend.


### Functionnalities

#### Event
* List all events
* Create a new event
* See event information
* Modify event information
* Delete an event (and thus its participants)
* List participant for a particular event
* Add participant to a particular event

#### Participant
* List all participants
* List participants for a particular event
* Add participant to a particular event (and thus create the participant)
* See participant information
* Modify participant information
* Delete a participant


## Installation

The project requires a mysql database and an IDE, such as Eclipse or NetBean, to run a Maven project.

### MySQL and database

1. Install mysql:
    ```
    $ sudo apt install mysql
    $ sudo apt install mysql-client
    ```
1. Create a new database:
    1. Access mysql shell:
        ```
        $ sudo mysql
        ```
    1. Create the empty database with the name _fvignolles\_ensg_:
        ```
        mysql> create database fvignolles_ensg;
        Query OK, 1 row affected (0.02 sec)
        ```
    1. Create a user for the project named _springuser_:
        ```
        mysql> create user 'springuser'@'%' identified by 'ThePassword';
        ```
    1. Gives  all privileges to the _springuser_ on the database:
        ```
        mysql> grant all on fvignolles_ensg.* to 'springuser'@'%';
        ```
**Note:** If you want to start with a database not empty, you can restore the database sample [db_sample.sql](db_sample.sql) from the root of this project:
    ```
    $ mysql -u springuser -pThePassword fvignolles_ensg < db_sample.sql
    ```

## Run the project

In an IDE:
1. Build the project with Maven (to download the dependencies).
2. Run the project
3. The application is displayed at http://localhost:8080


---

## Author:
Fanny Vignolles:
* GitHub: [fvgls](https://github.com/fvgls)
* GitLab: [fvgls](https://gitlab.com/fvgls)
