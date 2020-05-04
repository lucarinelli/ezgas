# Design Document 


Authors: Luca Rinelli, Ignacio López-Perea, Alberto Canta, Dario Licastro

Date: 03/05/2020

Version: 0


# Contents

- [High level design](#package-diagram)
- [Low level design](#class-diagram)
- [Verification traceability matrix](#verification-traceability-matrix)
- [Verification sequence diagrams](#verification-sequence-diagrams)

# Instructions

The design must satisfy the Official Requirements document (see EZGas Official Requirements.md ). <br>
The design must comply with interfaces defined in package it.polito.ezgas.service (see folder ServicePackage ) <br>
UML diagrams **MUST** be written using plantuml notation.

# High level design 

The style selected is client - server. Clients can be smartphones, tablets, PCs.
The choice is to avoid any development client side. The clients will access the server using only a browser. 

The server has two components: the frontend, which is developed with web technologies (JavaScript, HTML, Css) and is in charge of collecting user inputs to send requests to the backend; the backend, which is developed using the Spring Framework and exposes API to the front-end.
Together, they implement a layered style: Presentation layer (front end), Application logic and data layer (back end). 
Together, they implement also an MVC pattern, with the V on the front end and the MC on the back end.



```plantuml
@startuml
package "Backend" {

}

package "Frontend" {

}


Frontend -> Backend
@enduml


```


## Front End

The Frontend component is made of: 

Views: the package contains the .html pages that are rendered on the browser and that provide the GUI to the user. 

Styles: the package contains .css style sheets that are used to render the GUI.

Controller: the package contains the JavaScript files that catch the user's inputs. Based on the user's inputs and on the status of the GUI widgets, the JavaScript controller creates REST API calls that are sent to the Java Controller implemented in the back-end.


```plantuml
@startuml
package "Frontend" {

    package "it.polito.ezgas.resources.views" {

    }


package "it.polito.ezgas.resources.controller" {

    }


package "it.polito.ezgas.resources.styles" {

    }



it.polito.ezgas.resources.styles -down-> it.polito.ezgas.resources.views

it.polito.ezgas.resources.views -right-> it.polito.ezgas.resources.controller


}
@enduml

```

## Back End

The backend  uses a MC style, combined with a layered style (application logic, data). 
The back end is implemented using the Spring framework for developing Java Entrerprise applications.

Spring was selected for its popularity and relative simplicity: persistency (M and data layer) and interactions are pre-implemented, the programmer needs only to add the specific parts.

See in the package diagram below the project structure of Spring.

For more information about the Spring design guidelines and naming conventions:  https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3



```plantuml
@startuml
package "Backend" {

package "it.polito.ezgas.service"  as ps {
   interface "GasStationService"
   interface "UserService"
} 


package "it.polito.ezgas.controller" {

}

package "it.polito.ezgas.converter" {

}

package "it.polito.ezgas.dto" {

}

package "it.polito.ezgas.entity" {

}

package "it.polito.ezgas.repository" {

}

    
}
note "see folder ServicePackage" as n
n -- ps
```



The Spring framework implements the MC of the MVC pattern. The M is implemented in the packages Entity and Repository. The C is implemented in the packages Service, ServiceImpl and Controller. The packages DTO and Converter contain classes for translation services.



**Entity Package**

Each Model class should have a corresponding class in this package. Model classes contain the data that the application must handle.
The various models of the application are organised under the model package, their DTOs(data transfer objects) are present under the dto package.

In the Entity package all the Entities of the system are provided. Entities classes provide the model of the application, and represent all the data that the application must handle.




**Repository Package**

This package implements persistency for each Model class using an internal database. 

For each Entity class, a Repository class is created (in a 1:1 mapping) to allow the management of the database where the objects are stored. For Spring to be able to map the association at runtime, the Repository class associated to class "XClass" has to be exactly named "XClassRepository".

Extending class JpaRepository provides a lot of CRUD operations by inheritance. The programmer can also overload or modify them. 



**DTO package**

The DTO package contains all the DTO classes. DTO classes are used to transfer only the data that we need to share with the user interface and not the entire model object that we may have aggregated using several sub-objects and persisted in the database.

For each Entity class, a DTO class is created (in a 1:1 mapping).  For Spring the Dto class associated to class "XClass" must be called "XClassDto".  This allows Spring to find automatically the DTO class having the corresponding Entity class, and viceversa. 




**Converter Package**

The Converter Package contains all the Converter classes of the project.

For each Entity class, a Converter class is created (in a 1:1 mapping) to allow conversion from Entity class to DTO class and viceversa.

For Spring to be able to map the association at runtime, the Converter class associated to class "XClass" has to be exactly named "XClassConverter".




**Controller Package**

The controller package is in charge of handling the calls to the REST API that are generated by the user's interaction with the GUI. The Controller package contains methods in 1:1 correspondance to the REST API calls. Each Controller can be wired to a Service (related to a specific entity) and call its methods.
Services are in packages Service (interfaces of services) and ServiceImpl (classes that implement the interfaces)

The controller layer interacts with the service layer (packages Service and ServieImpl) 
 to get a job done whenever it receives a request from the view or api layer, when it does it should not have access to the model objects and should always exchange neutral DTOs.

The service layer never accepts a model as input and never ever returns one either. This is another best practice that Spring enforces to implement  a layered architecture.



**Service Package**


The service package provides interfaces, that collect the calls related to the management of a specific entity in the project.
The Java interfaces are already defined (see file ServicePackage.zip) and the low level design must comply with these interfaces.


**ServiceImpl Package**

Contains Service classes that implement the Service Interfaces in the Service package.


# Low level design

<!--Based on the official requirements and on the Spring Boot design guidelines, define the required classes (UML class diagram) of the back-end in the proper packages described in the high-level design section.
-->
```plantuml
@startuml
package "it.polito.ezgas.controller" {
        class GasStationController{
            -gasStationService : GasStationService
            +getGasStationById(gasStationId : Integer) : GasStationDto
            +getAllGasStations() : List<GasStationDto>
            +saveGasStation(gasStationDto : GasStationDto) : void
            +deleteGasStation(gasStationId : Integer) : void
            +getGasStationsByGasolineType(gasolinetype : String) : List<GasStationDto>
            +getGasStationsByProximity(myLat : Double, myLon : Double) : List<GasStationDto>
            +getGasStationsWithCoordinates(myLat : Double, myLon : Double, gasolineType : String, carSharing : String) : List<GasStationDto>
            +setGasStationReport(gasStationId : Integer, dieselPrice : double, superPrice : double, superPlusPrice : double, gasPrice : double, methanePrice : double, userId : Integer ) : void
        }
        class UserController{
            -userService : UserService
            +getUserById(userId : Integer) : UserDto
            +getAllUsers() : List<UserDto>
            +saveUser(userDto : UserDto) : UserDto
            +deleteUser(userId : Integer) : Boolean
            +increaseUserReputation(userId : Integer) : Integer
            +decreaseUserReputation(userId : Integer) : Integer
            +login(credentials : IdPw) : LoginDto
        }
        class HomeController{
            +admin() : String
            +index() : String
            +map() : String
            +login() : String
            +update() : String
            +singup() : String
            
        }
    }
@enduml
```

```plantuml
@startuml
package "it.polito.ezgas.service" {
        interface GasStationService {
            +getGasStationById(gasStationId : Integer) : GasStationDto
            +saveGasStation( gasStationDto : GasStationDto) : GasStationDto
            +getAllGasStations() : List<GasStationDto>
            +deleteGasStation(gasStationId : Integer) : Boolean
            +getGasStationsByGasolineType(gasolinetype : String) : List<GasStationDto>
            +getGasStationsByProximity(lat : double, lon : double ) : List<GasStationDto>
            +getGasStationsWithCoordinates(lat : double, lon : double, gasolinetype : String, carsharing : String) : List<GasStationDto>
            +getGasStationsWithoutCoordinates(gasolinetype : String, carsharing : String) : List<GasStationDto>
            +setReport(gasStationId : Integer, dieselPrice : double, superPrice : double, superPlusPrice : double, gasPrice : double, methanePrice : double, userId : Integer, gasolinetype : String) : void
            +getGasStationByCarSharing(carSharing : String) : List<GasStationDto>
        }
        
        interface UserService {
            +getUserById() : UserDto
            +saveUser() : UserDto
            +getAllUsers() : List<UserDto>
            +deleteUser() : Boolean
            +login() : LoginDto
            +increaseUserReputation() : Integer
            +decreaseUserReputation() : Integer
        }
        
        package "impl"{
        class GasStationServiceImpl{
            -gasStationRepository : GasStationRepository
            -priceReportRepository : PriceReportRepository
            -carSharingCompanyRepository : CarSharingRepository
        }
        
        class UserServiceImpl{
            -userRepository : UserRepository
            -priceReportRepository : PriceReportRepository
        }
        }
    }

UserService <|-- UserServiceImpl
GasStationService <|-- GasStationServiceImpl
@enduml
```

```plantuml
@startuml
package "it.polito.ezgas.dto" {
        class GasStationDto{
            -gasStationId : Integer
            -gasStationName : String
            -gasStationAddress : String
            -hasDiesel : Boolean
            -hasSuperl : Boolean
            -hasSuperPlus : Boolean
            -hasGas : Boolean
            -hasMethane : Boolean
            -carSharing : private String
            -lat : double
            -lon : double
            -dieselPrice : double
            -superPrice : double
            -superPlusPrice : double
            -gasPrice : double
            -methanePrice : double
            -reportUser : Integer
            -UserDto : UserDto
            -reportTimeStamp : String
            -reportDependability : double
            +GasStationDto() : GasStationDto
            +GasStationDto(...) : GasStationDto
            + ... Getters()
            + ... Setters()
        }
        class UserDto{
            -userId : Integer
            -userName : String
            -userPassword : String
            -email : String
            -reputation : Integer
            -admin : Boolean
            +UserDto() : UserDto
            +UserDto(...) : UserDto
            + ... Getters()
            + ... Setters()
        }
        class LoginDto{
            -userId : Integer
            -userName : String
            -token : String
            -email : String
            -reputation : Integer
            -admin : Boolean
            +LoginDto (userId : Integer, userName : String, token : String, email : String, reputation : Integer) : LoginDto
            +LoginDto() : LoginDto
            +getUserId() : Integer
            +setUserId(userId : Integer)
            +getUserName() : String
            +setUserName (userName : String)
            +getToken() : String
            +setToken(token : String)
            +getEmail() : String
            +setEmail(email : String)
            +getReputation() : Integer
            +setReputation(reputation : Integer)
            +getAdmin() : Boolean
            +setAdmin(admin : Boolean)
        }
        class PriceReportDto{
            -priceReportId : Integer
            -user : User
            -dieselPrice : double
            -superPrice : double
            -superPlusPrice: double
            -gasPrice : double
            -methanePrice : double
            +PriceReportDto() : PriceReportDto
            +PriceReportDto(...) : PriceReportDto
            + ... Getters()
            + ... Setters()
        }
        class IdPw{
            -user : String
            -pw : String
            +IdPw() : IdPw
            +IdPw (id : String, pw : String) : IdPw
        }
    }

GasStationDto "1" --> "1..*" PriceReportDto
GasStationDto --> UserDto
@enduml
```

```plantuml
@startuml
package "it.polito.ezgas.entity" {

        class User {
            -userId : Integer
            -userName : String
            -password : String
            -email : String
            -reputation : Integer
            -admin : Boolean
            +User() : User
            +User(...) : User
            +Getters()
            +Setters()
        }
        class GasStation {
            -gasStationId : Integer
            -gasStationName : String
            -gasStationAddress : String
            -hasDiesel : Boolean
            -hasSuperl : Boolean
            -hasSuperPlus : Boolean
            -hasGas : Boolean
            -hasMethane : Boolean
            -carSharing : private String
            -lat : double
            -lon : double
            -dieselPrice : double
            -superPrice : double
            -superPlusPrice : double
            -gasPrice : double
            -methanePrice : double
            -reportUser : Integer
            -reportTimeStamp : String
            -reportDependability : private double
            -user : private User
            +GasStation() : GasStation
            +GasStation(...) : GasStation
            +Getters()
            +Setters()
        }
        class PriceReport {
            -priceReportId : Integer
            -user : User
            -dieselPrice : double
            -superPrice : double
            -superPlusPrice : double
            -gasPrice : double
            -methanePrice : double
            -trust_level : Integer
            -gasStation : GasStation
            -user : User
            +PriceReport() : PriceReport
            +PriceReport(...) : PriceReport
            +Getters()
            +Setters()
        }
    }

GasStation "1..*" --> "0..1" User
PriceReport "1..*" --> "0..1" User
@enduml
```

```plantuml
@startuml
package "it.polito.ezgas.converter" {
        class GasStationConverter{
            +toGasStationDto(GasStation) : GasStationDto
        }
        class UserConverter{
            +toUserDto(User) : UserDto
        }
        class PriceReportConverter{
            +toPriceReportDto(PriceReport) : PriceReportDto
        }
    }
@enduml
```

```plantuml
@startuml
package "it.polito.ezgas.repository" {
        class UserRepository{
            findByUserId(Integer) : Iterable<User>
        }
        
        class GasStationRepository{
            findByGasolineTypeAndCarSharingAndLatBetweenAndLonBetween(...) : Iterable<GasStation>
        }
        
        class PriceReportRepository{
            findByUser(User) : Iterable<PriceReport>
        }
        
    }

interface PagingAndSortingRepository{
        +count() : long
        +delete(T entity) : void
        +deleteAll() : void
        +deleteAll(Iterable<? extends T> entities) : void
        +deleteById(ID id) : void
        +existsById(ID id) : boolean
        +findAll() : Iterable<T>
        +findAllById(Iterable<ID> ids) : Iterable<T> 
        +findById(ID id) : Optional<T>
        +save(S entity) : S
        +saveAll(Iterable<S > entities) : Iterable<S>
        +findAll(Sort sort) : Iterable<T> 
        +findAll(Pageable pageable) : Page<T>
    }

PagingAndSortingRepository <|-- UserRepository
PagingAndSortingRepository <|-- GasStationRepository
PagingAndSortingRepository <|-- PriceReportRepository
@enduml
```



```plantuml
@startuml

package "Backend" {

    class BootEZGasApplication{
        +main(args : String[1..*])
        +setupDbWithData()
    }
    
    interface PagingAndSortingRepository{

    }

    package "it.polito.ezgas.service"  as ps {
        interface GasStationService {

        }
        
        interface UserService {

        }
        
        class GasStationServiceImpl{

        }
        
        class UserServiceImpl{

        }
    } 
    
    
    package "it.polito.ezgas.controller" {
        class GasStationController{

        }
        class UserController{

        }
        class HomeController{

        }
    }
    
    package "it.polito.ezgas.converter" {
        class GasStationConverter{

        }
        class UserConverter{

        }
        class PriceReportConverter{
            
        }
    }
    
    package "it.polito.ezgas.dto" {
        class GasStationDto{

        }
        class UserDto{

        }
        class LoginDto{

        }
        class PriceReportDto{

        }
        class IdPw{
        }
    }
    
    package "it.polito.ezgas.entity" {

        class User {
        }
        class GasStation {
        }
        class PriceReport {
        }
    }
    
    package "it.polito.ezgas.repository" {
        class UserRepository{
            
        }
        
        class GasStationRepository{
        }
        
        class PriceReportRepository{
        }
        
    }

    
}

PagingAndSortingRepository <|-- UserRepository
PagingAndSortingRepository <|-- GasStationRepository
PagingAndSortingRepository <|-- PriceReportRepository


UserService <|-- UserServiceImpl
GasStationService <|-- GasStationServiceImpl
GasStationController o-- GasStationService
GasStationController o-- UserService
UserController o-- UserService
UserServiceImpl o-- UserRepository
UserServiceImpl o-- PriceReportRepository
GasStationServiceImpl o-- GasStationRepository
GasStationServiceImpl o-- PriceReportRepository

UserConverter o-- UserDto
UserConverter o-- User

GasStationConverter o-- GasStationDto
GasStationConverter o-- GasStation

UserService o-- UserDto
UserServiceImpl o-- UserDto
UserService o-- LoginDto
UserServiceImpl o-- LoginDto
UserServiceImpl o-- User
UserRepository o-- User
UserServiceImpl o-- IdPw
UserService o-- IdPw

GasStationService o-- GasStationDto
GasStationServiceImpl o-- GasStationDto
GasStationServiceImpl o-- GasStation
GasStationRepository o-- GasStation

PriceReportRepository o-- PriceReport
```

# Verification traceability matrix

<!--\<for each functional requirement from the requirement document, list which classes concur to implement it>
-->
|                                                                                                      | GasStationController | HomeController | UserController | GasStationServiceImpl | UserServiceImpl | GasStationConverter | PriceReportConverter | UserConverter | LoginDto | IdPw | PriceReportDto | GasStationDto | UserDto | PriceReportRepository | GasStationRepository | UserRepository | User | GasStation | PriceReport |
|------------------------------------------------------------------------------------------------------|----------------------|----------------|----------------|-----------------------|-----------------|---------------------|----------------------|---------------|----------|------|----------------|---------------|---------|-----------------------|----------------------|----------------|------|------------|-------------|
| FR1 : Manage users                                                                                   |                      | X              | X              |                       | X               |                     |                      | X             | X        | X    |                |               | X       |                       |                      | X              | X    |            |             |
| FR1.1 : Define   a new user, or modify an existing user                                              |                      | X              | X              |                       | X               |                     |                      | X             | X        | X    |                |               | X       |                       |                      | X              | X    |            |             |
| FR1.2 : Delete a user                                                                                |                      | X              | X              |                       | X               |                     |                      | X             | X        | X    |                |               | X       |                       |                      | X              | X    |            |             |
| FR1.3 : List   all users                                                                             |                      | X              | X              |                       | X               |                     |                      | X             | X        | X    |                |               | X       |                       |                      | X              | X    |            |             |
| FR1.4 : Search   a user                                                                              |                      | X              | X              |                       | X               |                     |                      | X             | X        | X    |                |               | X       |                       |                      | X              | X    |            |             |
| FR2 : Manage   rights. Authorize access to functions to specific actors according to access   rights |                      | X              | X              |                       | X               |                     |                      | X             | X        | X    |                |               |         |                       |                      | X              | X    |            |             |
| FR3 : Manage   gas stations                                                                          | X                    | X              |                | X                     |                 | X                   |                      |               | X        | X    |                | X             |         |                       | X                    |                |      | X          |             |
| FR3.1 : Define   a new gas station, or modify an existing gas station                                | X                    | X              |                | X                     |                 | X                   |                      |               | X        | X    |                | X             |         |                       | X                    |                |      | X          |             |
| FR3.2 : Delete   a gas station                                                                       | X                    | X              |                | X                     |                 | X                   |                      |               | X        | X    |                | X             |         |                       | X                    |                |      | X          |             |
| FR3.3 : List   all gas stations                                                                      | X                    | X              |                | X                     |                 | X                   |                      |               | X        | X    |                | X             |         |                       | X                    |                |      | X          |             |
| FR4 : Search   gas stations                                                                          | X                    |                |                | X                     |                 | X                   |                      |               |          |      |                | X             |         |                       | X                    |                |      | X          |             |
| FR4.1 :   Retrieve gas stations within radius r of a given geo point                                 | X                    |                |                | X                     |                 | X                   |                      |               |          |      |                | X             |         |                       | X                    |                |      | X          |             |
| FR4.2 :   Retrieve gas stations within radius r of a given address                                   | X                    |                |                | X                     |                 | X                   |                      |               |          |      |                | X             |         |                       | X                    |                |      | X          |             |
| FR4.3 : Show   given set of gas stations, and their fuel prices on a given map                       | X                    |                |                | X                     |                 | X                   |                      |               |          |      |                | X             |         |                       | X                    |                |      | X          |             |
| FR4.4 : Sort   given set of gas stations according to fuel type price                                | X                    |                |                | X                     |                 | X                   |                      |               |          |      |                | X             |         |                       | X                    |                |      | X          |             |
| FR4.5 : Filter   out given set of gas stations according to fuel type and or car sharing   option    | X                    |                |                | X                     |                 | X                   |                      |               |          |      |                | X             |         |                       | X                    |                |      | X          |             |
| FR5 : Manage   fuel prices and trust                                                                 | X                    | X              |                | X                     | X               | X                   | X                    |               | X        | X    | X              | X             |         | X                     | X                    |                |      | X          | X           |
| FR5.1 : Create   a price list, attach it to user and gas station                                     | X                    | X              |                | X                     | X               | X                   | X                    |               | X        | X    | X              | X             |         | X                     | X                    |                |      | X          | X           |
| FR5.2 : Update   trust level of a price list for a gas station                                       | X                    | X              |                | X                     | X               | X                   | X                    |               | X        | X    | X              | X             |         | X                     | X                    |                |      | X          | X           |
| FR5.3 :   Evaluate  price list for a gas station                                                     | X                    | X              |                | X                     | X               | X                   | X                    |               | X        | X    | X              | X             |         | X                     | X                    |                |      | X          | X           |





# Verification sequence diagrams 
<!--\<select key scenarios from the requirement document. For each of them define a sequence diagram showing that the scenario can be implemented by the classes and methods in the design>
-->
## Use case 1, UC1 - Create User Account
```plantuml
@startuml

actor "Anonyous User" as au
participant HomeController as hc
au -> hc : signup() GET "/signup"
activate hc
hc --> au: Response
deactivate hc

participant UserController as uc
au -> uc : saveUser() POST "/saveUser"
activate uc
participant UserDto as ud
uc -> ud ** : UserDto(...)
ud --> uc : UserDto
participant UserServiceImpl as usi
uc -> usi : saveUser(UserDto userDto)
activate usi

participant User as u
usi -> u ** : User(...)
u --> usi : User
participant UserRepository as ur
usi -> ur : save(User newUser)
activate ur

ur --> usi : User
deactivate ur

participant UserConverter as ucv
usi -> ucv : toUserDto(newUser)
activate ucv
ucv --> usi : UserDto
deactivate ucv

usi --> uc : UserDto
deactivate usi

uc --> au : Response
deactivate uc

@enduml
```
The user is created and added to the DataBase via UserRepository. Lastly, a confirmation is shown by the UserDto.

## Use case 8, UC8 - Obtain price of fuel for gas stations in a certain geographic area
```plantuml
@startuml
actor "Anonymous User" as au

participant GasStationController as gc
au -> gc : getGasStationsWithCoordenates()\nPOST "/getGasStationsWithCoordinates/{myLat}/{myLon}/{gasolineType}/{carSharing}"
activate gc
participant GasStationServiceImpl as gsi
gc -> gsi : getGasStationsWithCoordinates()
activate gsi
participant GasStationServiceRepository as gsr
gsi -> gsr : findByGasolineTypeAndCarSharingAndLatBetweenAndLonBetween(...)
activate gsr
gsr --> gsi : List<GasStation>
deactivate gsr

participant GasStationConverter as gsc
loop "over gasStationsFound"
gsi -> gsc : toGasStationDto(gasStation)
activate gsc
gsc --> gsi : GasStationDto
deactivate gsc
end


gsi --> gc : List<GasStationDto>
deactivate gsi


gc --> au : List<GasStationDto>
deactivate gc
@enduml
```


## Use case 10, UC10 - Evaluate price
```plantuml
@startuml

actor "User" as ua

note left of ua
User has selected a gas station
and is visualizing the corresponding
price report.
The user wants to evaluate the price 
marking it as correct.
Pressing a specific button triggers
this request.
end note

participant UserController as uc
ua -> uc : increaseUserReputation(userId)
activate uc



participant UserServiceImpl as usi
uc -> usi : increaseUserReputation(userId)
activate usi

participant UserRepository as ur
entity user as u_i

usi -> ur : findByUserId(userId)
activate ur
ur --> u_i **
u_i --> usi
deactivate ur


usi -> u_i : getReputation()
u_i --> usi : reputation
usi -> u_i : serReputation(newReputation)

usi -> ur : save(user)
activate ur
ur --> usi : User
deactivate ur

participant PriceReportRepository as prr
collections priceReports as prs

usi -> prr : findByUser(user)
activate prr
prr --> prs
prs --> usi
deactivate prr

loop

usi -> prs : getTimeTag()
prs --> usi : timeTag
usi -> prs : setTrustLevel(trustLevel)

end

activate prr
usi -> prr : saveAll(priceReports)
prr --> usi : priceReports
deactivate prr

usi --> uc : reputation
destroy u_i
destroy prs
deactivate usi

uc --> ua : reputation
deactivate uc

@enduml
```
User evaluates the price report for a GasStation. The prices are correct so the system increase by 1 the trust level of the user who reported the prices.
