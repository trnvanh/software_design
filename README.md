# Software Design - AeroSky
A Java-based application developed as part of a Software Design course project. This app fetches and displays weather and air quality data for user-specified cities. Users can also save their favorite cities for quick access. Data is visualized in interactive graphs, and near forecast data is displayed as cards.
# Key Features
The app takes city name as input and displays:
-	Current view: current data of weather and air quality of the input city.
-	Data view: near weekly weather forecast and visualization of weather and air quality data daily, weekly or monthly. Displayed parameters can be adjusted dynamically with buttons
-	Favorites: lists of saved cities as cards. Users can save their frequently checked cities and quickly see current temperature and weather situation of cities.
-   History: search history as table. User can look up their search history based on period of search, or city name. Results are displayed with search ID, city name, date of search and temperature.
-   Account: account information stored in the database. User can see account information, username and password. They can also modify username and password to log in to the app.

# Technology
- Java SDK 17: Core language for backend logic.
- JavaFXML: For frontend UI
- FxWeaver: Integrate JavaFXML with Spring Framework
- Spring Frameworks: Backend 
- Lombok: Reduce boilerplate code in Java classes 
- APIs: OpenWeather API and AirVisual API
- Maven: For dependency management

# Design Patterns and Principles
- Singleton pattern: ensures that there’s only one instance of the DataTransferController class across the application.
- Façade pattern: provides simplified interface for complex subsystems. 
- Single Responsibility Principle (SRP): Each class is designed with a single responsibility, so it is easier to test and maintain. 
- Dependency Injection (DI): DI is applied to manage dependencies and enhance flexibility.
- Open/Closed Principle: A class should be open for extension but closed for modification. 
- Interface Segregation Principle: interfaces should be specific to the needs of the implementing classes rather than being too broad or general
- Template Design Pattern: a behavioral design pattern used to define the structure of an algorithm in a superclass while allowing subclasses to override specific steps of the algorithm without changing its overall structure.
- Builder Pattern: a creational design pattern that helps construct complex objects step by step in a systematic and flexible way. This pattern is particularly useful when objects require many configurations or optional parameters.
- Model-View-Control (MVC): Separates the application's data handling (Model), user interface (View), and control flow (Controller) to make it easier to manage and extend each part independently.

# Installation Guide
**Prerequisites**
- Java SDK 17: Ensure JDK 17+ is installed: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Maven
- Docker
- Download IntelliJ community edition IDE : https://www.jetbrains.com/idea/download/

**Clone the repository**
- clone repository either using the IDE or terminal 
- repository url: https://course-gitlab.tuni.fi/compse110-fall2024/kirsi-group
- git clone https://course-gitlab.tuni.fi/compse110-fall2024/kirsi-group
- cd kirsi-group/WeatherApp/WeatherApp

**Install database**
- docker-compose up -d

**Build project**
- mvn clean install

**Run app**
- Run WeatherSystemApplication.java
- Test-username: user1 
- Test-password: 123456

# Usage
1. Log in/ log out
2. Search for current data of a city: give input and click Search button
3. View data for the input city, including interactive graphs, near weather forecasts 
4. Save cities in the favorite list
5. Look up for search history within a time range
6. Modify username, password, account information

# Project Structure
The application is structured following a modular and layered architecture approach. 

Dividing code files into smaller sub-parts and layers by separating and isolating them from each other makes the project more manageable.

There are interfaces for services, façade implementation to retrieve data from APIs, and interfaces for Repository – the database. We used façade design pattern to improve the accessibility of users to services. Controllers can access to services through the interfaces, retrieve data and update UI. Similarly, services access database through the interfaces.

# Future Improvements
Some future implementations and enhancements in the future.
- Finalizing data visualization part to display the data more meaningfully.
- Extending new features such as Alerts and Notifications to give users alerts about air quality dangerous classification, severe weather conditions and give advice for activities outdoor or indoor.
- Improving graphical user interface (GUI) for more aesthetic UI and intuitive user-friendly user experience (UX).
- Basic features can be broadened If the paid versions of both APIs can be accessed, the data of air quality forecast as well as history can be fetched to display graph of air quality forecast in Data view as well as commercial level air pollution information.
