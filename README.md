# Covid Vaccination Directory

## What is Covid Vaccination Directory/Portal?
Covid Vaccination Portal is a Database web application that maintains the record of current vaccination data across US and individual user data about his vaccination records.

Designed in a way that the codebase can be easily extended and additional features such as analytics can be added.

## Stack
- Java
- SQL database
- JDBC
- Tomcat Apache server

<!-- ## Features
- Dashboard 
- Authentication and Administration (Login and Authorizartion)
- Patient record entry form
- Eligibility Screening form
- RESTFul API Endpoints
- Zipcode Analytics -->

## Description

A user is signed into the portal and has a unique ID like (SSN), name, location and a phone number.
Each county or a district has different vaccination centers each of which has a unique ID, which records the track of people vaccinated, the dose of the vaccine and the stock of vaccination left.
A person can get the vaccine from any center but has to get the same 2 doses of vaccine.
Each vaccine has a unique number which can be used to track the person who has received the vaccine and the date they got the vaccine.
There is also information about the type of vaccine and the possible side effects caused by the vaccine in each dose. Finally the user can see  the states or the counties which have the highest vaccinations received.

## ER Diagram
![Screenshot 2021-07-06 at 10 39 32](https://user-images.githubusercontent.com/35519401/124619430-a6a76f80-de46-11eb-8630-79ea3dd5927a.png)


<!-- ## How to build it?
1. Clone this repository in your local machine.
2. Install dependencies.
  ```
  pip install requirements.txt
  npm install
  ```
3. Make migrations and migrate the tables by running the following command:
  ```
  python core\manage.py migrate
  ```
4. Start the server by running the following command:
  ```
  python core\manange.py runserver
  ```
5. Open https://localhost:8000/ in browser to start using the Covid-Directory.
  

<!-- ![](https://komarev.com/ghpvc/?username=diamalab-cs480---course-project-covid19_vaccination&style=flat-square&color=blueviolet&label=Views) -->

