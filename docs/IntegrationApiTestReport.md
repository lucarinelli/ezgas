# Integration and API Test Documentation

Authors: Luca Rinelli

Date: 26/05/20

Version: 0

# Contents

- [Dependency graph](#dependency-graph)

- [Integration approach](#Integration-approach)
   + [Tests](#tests)
   + [Mock ups](#Integration-approach-(Mock-ups))
   + [Tests (Mock ups)](#tests-(Mock-ups))

- [Scenarios](#scenarios)

- [Coverage of scenarios and FR](#scenario-coverage)
- [Coverage of non-functional requirements](#nfr-coverage)



# Dependency graph 

     <report the here the dependency graph of the classes in it/polito/Ezgas, using plantuml>

```plantuml
@startuml
class BootEZGasApplication

class GasStationController

class UserController

class HomeController

package step3 <<Rectangle>> {
class GasStationServiceimpl

class UserServiceimpl
}

class GasStationRepository

class UserRepository

package step2 <<Rectangle>> {
class GasStationConverter

class UserConverter

class LoginConverter
}

package step1 <<Rectangle>> {
class User

class GasStation

class UserDto

class GasStationDto

class LoginDto
}

BootEZGasApplication --> GasStationController
BootEZGasApplication --> UserController
BootEZGasApplication --> HomeController
GasStationController --> GasStationServiceimpl
UserController --> UserServiceimpl
GasStationServiceimpl --> GasStationRepository
GasStationServiceimpl --> UserRepository
GasStationServiceimpl --> UserConverter
GasStationServiceimpl --> GasStationConverter
GasStationServiceimpl --> GasStation
GasStationServiceimpl --> GasStationDto
GasStationConverter --> GasStation
GasStationConverter --> GasStationDto
GasStationRepository --> GasStation
UserServiceimpl --> UserRepository
UserServiceimpl --> UserConverter
UserConverter --> User
UserConverter --> UserDto
UserRepository --> User
UserServiceimpl --> User
UserServiceimpl --> UserDto
LoginConverter --> LoginDto
@enduml
```
     
# Integration approach

    <Write here the integration sequence you adopted, in general terms (top down, bottom up, mixed) and as sequence
    (ex: step1: class A, step 2: class A+B, step 3: class A+B+C, etc)> 
    <The last integration step corresponds to API testing at level of Service package>
    <Tests at level of Controller package will be done later>

A bottom up approach has been used for integration test. Step 1 is about Unit Testing.

 - **Step 1**: User, GasStation, UserDto, GasStationDto
 - **Step 2**: GasStationConverter+GasStation+GasStationDto, UserConverter+User+UserDto
 - **Step 3**: GasStationServiceimpl+GasStationConverter+GasStation+GasStationDto+UserConverter+User+UserDto, UserServiceimpl+UserConverter+User+UserDto

#  Tests

   <define below a table for each integration step. For each integration step report the group of classes under test, and the names of
     JUnit test cases applied to them>

## Step 1
| Classes  | JUnit test cases |
|--|--|
|||


## Step 2
| Classes  | JUnit test cases |
|--|--|
|GasStationConverter|testtoGasStationDto()|
||testtoGasStation()|
|UserConverter|testtoUserDto()|
||testtoUser()|
|LoginConverter|testtoLoginDto()|


## Step 3 API Tests

   <The last integration step  should correspond to API testing, or tests applied to all classes implementing the APIs defined in the Service package>

| Classes  | JUnit test cases |
|--|--|
| GasStationServiceimpl | testGetAllGasStations() |
|  | testGetGasStationsByGasolineType() |
|  | testGetGasStationsByGasolineTypeAbsent() |
|  | testGetGasStationsByGasolineTypeInvalid() |
|  | testGetGasStationsByProximity() |
|  | testGetGasStationsByProximityBoundaryIn() |
|  | testGetGasStationsByProximityAbsent() |
|  | testGetGasStationsByProximityEgual() |
|  | testGetGasStationById() |
|  | testGetGasStationById1() |
|  | testGetGasStationById2() |
|  | testGetGasStationById3() |
|  | testSaveGasStation() |
|  | testDeleteGasStation() |
|  | testDeleteGasStation2() |
|  | testGetGasStationsByCarSharing() |
|  | testGetGasStationsByCarSharingAbsent() |
|  | testGetGasStationsWithCoordinates() |
|  | testGetGasStationsWithCoordinatesOnlyCoordinates() |
|  | testGetGasStationsWithoutCoordinates() |
|  | testGetGasStationsWithoutCoordinates1() |
|  | testGetGasStationsWithoutCoordinates2() |
|  | testGetGasStationsWithoutCoordinates3() |
|  | testGetGasStationsWithoutCoordinates4() |
|  | testGetGasStationsWithoutCoordinates5() |
|  | testSetReport() |
|  | testSetReport1() |
|  | testSetReport2() |
|  | testSetReport3() |
| UserServiceimpl | testSaveUser1() |
|| testSaveUser2()|
|| testGetAllUsers1() |
|| testGetUserById1() |
|| testGetUserById2() |
|| testGetUserById3() |
|| testIncreaseUserReputation() |
|| testDecreaseUserReputation() |
|| testLogin() |
|| testDeleteUser() |

# Integration approach (Mock ups)

    <Write here the integration sequence you adopted, in general terms (top down, bottom up, mixed) and as sequence
    (ex: step1: class A, step 2: class A+B, step 3: class A+B+C, etc)> 
    <The last integration step corresponds to API testing at level of Service package>
    <Tests at level of Controller package will be done later>

A mixed approach has been used for integration test with mock ups.

GasStationServiceimpl+GasStation+GasStationDto+mock(GasStationRepository)+User+UserDto+mock(UserRepository), UserServiceimpl+User+UserDto+mock(UserRepository)

#  Tests (Mock ups)

   <define below a table for each integration step. For each integration step report the group of classes under test, and the names of
     JUnit test cases applied to them>


## API Tests with Mockito

   <The last integration step  should correspond to API testing, or tests applied to all classes implementing the APIs defined in the Service package>

| Classes  | JUnit test cases |
|--|--|
| GasStationServiceimpl | testGetAllGasStations() |
|  | testGetAllGasStationsNone() |
|  | testGetGasStationsByGasolineTypeInvalid() |
|  | testGetGasStationsByProximityWrongLat() |
|  | testGetGasStationsByProximityWrongLon() |
|  | testGetGasStationsByProximityWrongLonLat() |
|  | testGetGasStationById() |
|  | testGetGasStationByIdAbsent() |
|  | testDeleteGasStation() |
|  | testDeleteGasStationAbsent() |
|  | testDeleteGasStationInvalid() |
|  | testSaveGasStation1() |
|  | testSaveGasStation2() |
|  | testSaveGasStation3() |
|  | testSaveGasStation4() |
|  | testSaveGasStation5() |
|  | testSaveGasStation6() |
|  | testSaveGasStation6() |
| UserServiceimpl | testSaveUser() |
|| testSaveUser1()|
|| testGetAllUsers() |
|| testGetUserById() |
|| testGetUserById2() |
|| testGetUserById3() |
|| testIncreaseUserReputation() |
|| testIncreaseUserReputationInvalid() |
|| testIncreaseUserReputationLimit() |
|| testDecreaseUserReputation() |
|| testDecreaseUserReputationInvalid() |
|| testDecreaseUserReputationLimit() |
|| testLogin() |
|| testLoginWrongEmail() |
|| testLoginWrongPassword() |
|| testDeleteUser() |
|| testDeleteUserAbsent() |
|| testDeleteUserInvalid() |



# Scenarios


<If needed, define here additional scenarios for the application. Scenarios should be named
 referring the UC they detail>

## Scenario UCx.y

| Scenario |  name |
| ------------- |:-------------:| 
|  Precondition     |  |
|  Post condition     |   |
| Step#        | Description  |
|  1     |  ... |  
|  2     |  ... |



# Coverage of Scenarios and FR


<Report in the following table the coverage of  scenarios (from official requirements and from above) vs FR. 
Report also for each of the scenarios the (one or more) API JUnit tests that cover it. >




| Scenario ID | Functional Requirements covered | JUnit  Test(s) | 
| ----------- | ------------------------------- | ----------- | 
| UC7.1       | FR5.1                           | testSetReport() (1-5) |
| UC7.1       | FR5.2                           | testSetReport() (1-5) |
| UC8.1       | FR4.1                           | testGetGasStationsWithCoordinates()<br>testGetGasStationsWithCoordinatesOnlyCoordinates()<br>testGetGasStationsByProximity()<br> testGetGasStationsByProximityBoundaryIn()<br>testGetGasStationsByProximityAbsent() |
| UC8.2       | FR4.1                           | testGetGasStationsWithCoordinates()<br>testGetGasStationsWithCoordinatesOnlyCoordinates()<br>testGetGasStationsByProximity()<br> testGetGasStationsByProximityBoundaryIn()<br>testGetGasStationsByProximityAbsent() |
| UC8.2       | FR4.5                           | testGetGasStationsWithCoordinates()<br>testGetGasStationsByGasolineType()<br>testGetGasStationsByGasolineTypeAbsent()<br>testGetGasStationsByGasolineTypeInvalid() |
| UC8.3       | FR4.1                           | testGetGasStationsWithCoordinates()<br>testGetGasStationsWithCoordinatesOnlyCoordinates()<br>testGetGasStationsByProximity()<br> testGetGasStationsByProximityBoundaryIn()<br>testGetGasStationsByProximityAbsent() |
| UC8.3       | FR4.5                           | testGetGasStationsWithCoordinates()<br>testGetGasStationsByGasolineType()<br>testGetGasStationsByGasolineTypeAbsent()<br>testGetGasStationsByGasolineTypeInvalid() |
| UC10.1      | FR5.2                           | testIncreaseUserReputation()<br>testDecreaseUserReputation()<br>testSetReport() (1-5) |
| UC10.1      | FR5.3                           | testIncreaseUserReputation()<br>testDecreaseUserReputation()<br>testSetReport() (1-5) |
| UC10.2      | FR5.2                           | testIncreaseUserReputation()<br>testDecreaseUserReputation()<br>testSetReport() (1-5) |
| UC10.2      | FR5.3                           | testIncreaseUserReputation()<br>testDecreaseUserReputation()<br>testSetReport() (1-5) |



# Coverage of Non Functional Requirements


<Report in the following table the coverage of the Non Functional Requirements of the application - only those that can be tested with automated testing frameworks.>


### 

| Non Functional Requirement | Test name |
| -------------------------- | --------- |
| NFR2                       | All tests check timing |


