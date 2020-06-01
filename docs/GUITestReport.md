# GUI  Testing Documentation

Authors: Alberto Canta, Dario Licastro, Ignacio Lopez-Perea Villacanas, Luca Rinelli

Date: 31/05/2020

Version: I

# GUI testing

This part of the document reports about testing at the GUI level. Tests are end to end, so they should cover the Use Cases, and corresponding scenarios.

## Coverage of Scenarios and FR

```
<Complete this table (from IntegrationApiTestReport.md) with the column on the right. In the GUI Test column, report the name of the .py  file with the test case you created.>
```

###

| Use Cases ID | Functional Requirements covered | GUI Test(s) |
| ----------- | ------------------------------- | ----------- |
| 1           | FR1.1                           | UC1.sikuli - Create User Account |             
| 2           | FR1.1                           | UC2 - Modify User  |             
| 3           | FR1.2 FR1.3                     | UC3 - Delete User |         
| 4           | FR3.2 FR4.2                     | UC4.sikuli - Create Gas Station |             
| 5           | FR3.3 FR3.1                     | UC5 - Modify Gas Station Information |             
| 6           | FR3 FR3.2                       | UC6.sikuli - Delete Gas Station |
| 7           | FR5 FR5.1                       | UC7.sikuli - Report fuel price for a gas station |
| 8           |                                 |             |
| 9           | FR5 FR5.2 FR5.3                 | UC10.sikuli - Evaluate price and update trust level |
| 10          | FR5 FR5.2 FR5.3                 | UC10.sikuli - Evaluate price |

# REST  API  Testing

This part of the document reports about testing the REST APIs of the back end. The REST APIs are implemented by classes in the Controller package of the back end.
Tests should cover each function of classes in the Controller package

## Coverage of Controller methods


<Report in this table the test cases defined to cover all methods in Controller classes >

| class.method name | Functional Requirements covered |REST  API Test(s) |
| ----------- | ------------------------------- | ----------- |
| GasStationController.getGasStationById | FR4                               | testGetGasStationById() |     
| GasStationController.getAllGasStations | FR3.3                    | testGetAllGasStations() |             
| GasStationController.saveGasStation | FR3 FR3.1                    | testSaveGasStation() |             
| GasStationController.deleteUser | FR3 FR3.2                      | testGasStationDeleteUser() |             
| GasStationController.getGasStationsByGasolineType | FR4.5                       | testGetGasStationsByGasolineType() |             
| GasStationController.getGasStationsByProximity | FR4.1                            | testGetGasStationsByProximity() |                  
| GasStationController.getGasStationsWithCoordinates | FR4.1 FR4.5                            | testGetGasStationsWithCoordinates() |     
| GasStationController.setGasStationReport | FR3.1                 | testSetGasStationReport() |             
| HomeController.admin |                                 | testAdmin() |             
| HomeController.index |                                 | testIndex() |             
| HomeController.map |                                 | testMap() |             
| HomeController.login |                                 | testHomeLogin() |     
| HomeController.update |                             | testUpdate() |     
| HomeController.signup |                              | testSignup() |             
| UserController.getUserById |    FR1.4                         | testGetUserById() |             
| UserController.getAllUsers | FR1.3                           | testGetAllUsers() |             
| UserController.saveUser |          FR1.1                   | testSaveUser() |             
| UserController.deleteUser | FR1 FR1.2                   | testUserDeleteUser() |     
| UserController.increaseUserReputation | FR1 FR5.2                       | testIncreaseUserReputation() |             
| UserController.decreaseUserReputation | FR1 FR5.2                       | testDecreaseUserReputation() |             
| UserController.login |                                      | testUserLogin() |     
