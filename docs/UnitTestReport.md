# Unit Testing Documentation

Authors: Luca Rinelli, Alberto Canta, Ignacio Lopez-Perea Villacanas, Dario Licastro

Date: 29/06/2020

Version: 3

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)
   + [Gas Station](#gas-station)
   + [User](#User)

- [White Box Unit Tests](#white-box-unit-tests)
   + [GasStationDto](#GasStationDto)
   + [UserDto](#UserDto)
   + [IdPw](#IdPw)
   + [LoginDto](#LoginDto)


# Black Box Unit Tests

    <Define here criteria, predicates and the combination of predicates for each function of each class.
    Define test cases to cover all equivalence classes and boundary conditions.
    In the table, report the description of the black box test case and (traceability) the correspondence with the JUnit test case writing the
    class and method name that contains the test case>
    <JUnit test classes must be in src/test/java/it/polito/ezgas   You find here, and you can use,  class EZGasApplicationTests.java that is executed before
    the set up of all Spring components
    >

# Gas Station

### Class *GasStation* - method *setGasStationId*

**Criteria for method *GasStation*:setGasStationId**

 -This method shou be used to set the ID of a gasStation

**Predicates for method *GasStation*SetGetGasStationId:**

| Criteria | Predicate |
| :---------: | --------- |
| ID must be a positive integer| ID >= 0 |
| ID has to be null when the gasStation has not been set with all the parameters | ID = null |

**Boundaries**:

| Criteria | Boundary values |
| --- | --- |
| ID must be between [0,MAXINT]| 0 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.setGasStationId(1) | Valid | Set the gasStationID to 1 | testSetGetGasStationId() |
| gasStation.setGasStationId(777) | Valid | Set the gasStationID to 777 | testSetGetGasStationId1() |
| gasStation = New GasStation() | Valid | A gasStation without parameters set should have a null ID | testSetGetGasStationId2() |

### Class *GasStation* - method *getGasStationId*

**Criteria for method *GasStation*:**

 -This method should be used to get the ID of a gasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| ID must be a positive integer| ID >= 0 |
| ID has to be null when the gasStation has not been set with all the parameters | ID = null |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| ID must be between [0,MAXINT]| 0|

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.getGasStationId() | Valid | Get the gasStationID = 1 | testSetGetGasStationId() |
| gasStation.getGasStationId() | Valid | Get the gasStationID = 777 | testSetGetGasStationId1() |
| gasStation.getGasStationId() | Valid | A gasStation without parameters set should return a null ID | testSetGetGasStationId2() |
| gasStation.GetGasStationId() | Valid | Check that the return type is a String | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |


### Class *GasStation* - method *setGasStationName*

**Criteria for method *GasStation*:**

 -This method returns a string with the name of the GasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a string |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |       String          |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.SetGasStationName() | Valid | Set the name of a gasStation | testSetGetGasStationName() |
| gasStation.SetGasStationName() | Valid | Set the name of a gasStation | testSetGetGasStationName1() |
| gasStation.SetGasStationName() | Valid | Check that when a name is not set, it will return null | testSetGetGasStationName2() |

### Class *GasStation* - method *getGasStationName*

**Criteria for method *GasStation*:**

 -This method returns a string with the name of the GasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a string |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |       String          |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.GetGasStationName() | Valid | Set the name of a gasStation | testSetGetGasStationName() |
| gasStation.GetGasStationName() | Valid | Set the name of a gasStation | testSetGetGasStationName1() |
| gasStation.GetGasStationName() | Valid | Check that when a name is not set, it will return null | testSetGetGasStationName2() |
| gasStation.GetGasStationName() | Valid | Check that the return type is a String | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *setGasStationAddress*

**Criteria for method *GasStation*:**

 -This method returns a string with the name of the GasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a string |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |       String          |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.setGasStationAddress(-) | Valid | Check if the address setted is returned in the get method| testSetGetGasStationAddress() |
| gasStation.setGasStationAddress(-) | Valid | Check if the address setted is returned in the get method| testSetGetGasStationAddress1() |
| gasStation.setGasStationAddress() | Valid | When the address is not set, it should return a null | testSetGetGasStationAddress2() |

### Class *GasStation* - method *getGasStationAddress*

**Criteria for method *GasStation*:**

 -This method returns a string with the name of the GasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a string |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |       String          |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.setGasStationAddress(-) | Valid | Check if the address setted is returned in the get method| testSetGetGasStationAddress() |
| gasStation.setGasStationAddress(-) | Valid | Check if the address setted is returned in the get method| testSetGetGasStationAddress1() |
| gasStation.setGasStationAddress() | Valid | When the address is not set, it should return a null | testSetGetGasStationAddress2() |
| gasStation.GetGasStationAddress() | Valid | Check that the return type is a String | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |


### Class *GasStation* - method *setReportDependability*

**Criteria for method *GasStation*:**

 -Set a double value between [0.0 , 100.0]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a double value | (double) |
| |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Has to be between a preciously set values | [0.0 , 100.0] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.setReportDependability(96.0); | Valid | Set the value 96.0 and then check that it has change using the get method| testSetGetReportDependability() |
|  | Valid | Check that when is not iniciated, the value is set to 0.0 | testSetGetReportDependability2() |

### Class *GasStation* - method *getReportDependability*

**Criteria for method *GasStation*:**

-Get a double value between [0.0 , 100.0]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a double value | (double) |
| |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Has to be between a preciously set values | [0.0 , 100.0] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.getReportDependability(); | Valid | Set the value 96.0 and then check that it has change using the get method| testSetGetReportDependability() |
|  | Valid | Check that when is not iniciated, the value is set to 0.0 | testSetGetReportDependability2() |
| gs.getReportDependability(); | Valid | Check if the return type is a double | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *setReportUser*

**Criteria for method *GasStation*:**

 - Set an Integer value between [ 0 , MAXINT]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be an integer value |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Has to be a positive number |  [ 0 , MAXINT ] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.setReportUser(42); | Valid | Set a value of 42 in the ReportUser attribute and then check that it has been saved using the get method | testSetGetReportUser() |
|  |  | Check that when the attribute is not set, the value is null | testSetGetReportUser2() |

### Class *GasStation* - method *getReportUser*

**Criteria for method *GasStation*:**


 - Get an Integer value between [ 0 , MAXINT]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be an integer value |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Has to be a positive number |  [ 0 , MAXINT ] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.getReportUser(); | Valid | Set a value of 42 in the ReportUser attribute and then check that it has been saved using the get method | testSetGetReportUser() |
|  |  | Check that when the attribute is not set, the value is null | testSetGetReportUser2() |
| gs.getReportUser(); | Valid | Check that the return type is an Integer | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *setReportTimestamp*

**Criteria for method *GasStation*:**

 -Set the string with the information of the date a report has been made in the value ReportTimeStamp

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a String |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Has to be a String |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.setReportTimestamp("TIMESTAMP FORMAT"); | Valid | Set the ReportStampAtribute and check that is changed using the get function | testSetGetReportTimestamp() |
| gs.setReportTimestamp("25/12"); | Valid | Set the ReportStampAtribute and check that is changed using the get function | testSetGetReportTimestamp1() |
|  |  | Check that if the ReportTimeStamp is not set, its value is null | testSetGetReportTimestamp2() |

### Class *GasStation* - method *getReportTimestamp*

**Criteria for method *GasStation*:**


 -Get the string with the information of the date a report has been made in the value ReportTimeStamp

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a String |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Has to be a String |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.getReportTimestamp(); | Valid | Set the ReportStampAtribute and check that is changed using the get function | testSetGetReportTimestamp() |
| gs.getReportTimestamp(); | Valid | Set the ReportStampAtribute and check that is changed using the get function | testSetGetReportTimestamp1() |
|  |  | Check that if the ReportTimeStamp is not set, its value is null | testSetGetReportTimestamp2() |
| gs.getReportTimestamp(); | Valid | Check that the return type is a String | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *setUser*

**Criteria for method *GasStation*:**

 -Set a User object

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a User Object |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUser() |

### Class *GasStation* - method *getUser*

**Criteria for method *GasStation*:**

 -

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUser() |

### Class *GasStation* - method *setCarSharing*


**Criteria for method *GasStation*:**

 -This method returns a string with the name of the GasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a string |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |       String          |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.setGasStationCarSharing(-) | Valid |Check if the CarSharingsetted is returned in the get method  | testSetGetCarSharing() |
| gasStation.setGasStationCarSharing(-) | Valid |When the CarSharing is not setted, it should return null  | testSetGetCarSharing2() |


### Class *GasStation* - method *getCarSharing*

**Criteria for method *GasStation*:**

 -This method returns a string with the name of the GasStation

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a string |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |       String          |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gasStation.setGasStationCarSharing(-) | Valid |Check if the CarSharingsetted is returned in the get method  | testSetGetCarSharing() |
| gasStation.setGasStationCarSharing(-) | Valid |When the CarSharing is not setted, it should return null  | testSetGetCarSharing2() |
| gasStation.setGasStationCarSharing(-) | Valid | Check that the return type is a String | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *setLat*

**Criteria for method *GasStation*:**

 -Set a lat value (double) in the range of [-90.0 ,90.0]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to save in the attribute lat, the value selected | setLat() |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| The value has to be in a certain range | [-90.0 , 90.0] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.setLat(45.45); gs.setLat(505.4); gs.setLat(-1); gs.setLat(-91);| Valid; Invalid; Valid; Invalid | Set Different values for lat and check if the return is the value previously set | testSetGetLat() |
| gs.setLat(); | Valid | Check that when there is not specification the value of Lat is 0.0 | testSetGetLat2() |

### Class *GasStation* - method *getLat*

**Criteria for method *GasStation*:**

 -Get a lat value (double) in the range of [-90.0 ,90.0]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to get the value of the attribute lat | setLat() |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| The value has to be in a certain range | [-90.0 , 90.0] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.getLat(); | Valid | Get Different values for lat and check if the return is the value previously set | testSetGetLat() |
| gs.getLat(); | Valid | Check that when there is not specification the value of Lat is 0.0 | testSetGetLat2() |
| gs.getLat() | Valid | Check that the type return is a double | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *setLon*

**Criteria for method *GasStation*:**

 -Set a lon value (double) in the range of [-180.0 ,180.0]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to save in the attribute lon, the value selected | setLon() |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| The value has to be in a certain range | [-180.0 , 180.0] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.setLon(45.45); gs.setLon(505.4); gs.setLon(-23.3); gs.setLon(-181);| Valid; Invalid; Valid; Invalid | Set Different values for lon and check if the return is the value previously set | testSetGetLon() |
| gs.setLat(); | Valid | Check that when there is not specification the value of Lat is 0.0 | testSetGetLon2() |

### Class *GasStation* - method *getLon*

**Criteria for method *GasStation*:**

 -Get a lon value (double) in the range of [-180.0 ,180.0]

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to get the value of the attribute lon | setLon() |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| The value has to be in a certain range | [-180.0 , 180.0] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| gs.getLon(); | Valid | Get Different values for lon and check if the return is the value previously set | testSetGetLon() |
| gs.getLon(); | Valid | Check that when there is not specification the value of Lon is 0.0 | testSetGetLon2() |
| gs.getLon() | Valid | Check that the type return is a double | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |


### Class *GasStation* - method *setHas...*

**Criteria for method *GasStation*:**

 -Set a Boolean value

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a boolean type |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| True-false |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasDiesel() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasSuper() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasSuperPlus() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasGas() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasMethane() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasPremiumDiesel() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasDiesel2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasSuper2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasSuperPlus2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasGas2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasMethane2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasPremiumDiesel2() |

### Class *GasStation* - method *getHas...*

**Criteria for method *GasStation*:**

 -Set a Boolean value

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a boolean type |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| True-false |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasDiesel() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasSuper() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasSuperPlus() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasGas() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasMethane() |
|  | Valid  | Set the value first to false,check with a get method that the value is setted, and after set it to false and check it | testSetGetHasPremiumDiesel() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasDiesel2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasSuper2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasSuperPlus2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasGas2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasMethane2() |
|  | Valid  | Check that when a value is not setted, the value is false | testSetGetHasPremiumDiesel2() |
|  | Valid  | Check that the return type is a Boolean | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *set...Price*

**Criteria for method *GasStation*:**

 -Set a positive double value

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a positive double value |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Price has to be positive | [ 0.0 , MAXDOUBLE] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method | testSetGetDieselPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetSuperPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetSuperPlusPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetGasPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetMethanePrice() |
|  | Valid | When is not setted, the value should be null | testSetGetDieselPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetSuperPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetSuperPlusPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetGasPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetMethanePrice2() |

### Class *GasStation* - method *get...Price*

**Criteria for method *GasStation*:**

 -Get a positive double value

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
| Has to be a positive double value |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Price has to be positive | [ 0.0 , MAXDOUBLE] |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method | testSetGetDieselPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetSuperPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetSuperPlusPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetGasPrice() |
|  | Valid; Valid; Invalid | Set the value to 99.9 ; 0.0 ;-1.0 and check that the value is setted correctly using the get method  | testSetGetMethanePrice() |
|  | Valid | When is not setted, the value should be null | testSetGetDieselPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetSuperPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetSuperPlusPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetGasPrice2() |
|  | Valid | When is not setted, the value should be null | testSetGetMethanePrice2() |
|  | Valid | Check the return type is a double | testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStation* - method *GasStation*

**Criteria for method *GasStation*:**

 -

**Predicates for method *GasStation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  |testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

# User

### Class *User* - method *User*

**Criteria for method *User*:**

 -

**Predicates for method *User*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  |testUser() |
|  |  |  |testUser2() |

### Class *User* - method *getUserId()*

**Criteria for method *getUserId*:**

 - value of Id

**Predicates for method *getUserId*:**

| Criteria | Predicate |
| -------- | --------- |
| value Id | -1 (invalid) |
|          | 1 (valid) |
|| no value |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserId() (test valid and invalid Id) |
|  |  |  | testSetGetUserId2() (test null Id)|

### Class *User* - method *setUserId()*

**Criteria for method *setUserId*:**

 -

**Predicates for method *setUserId*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserId() |
|  |  |  | testSetGetUserId2() |

### Class *User* - method *getUserName()*

**Criteria for method *getUserName*:**

 -

**Predicates for method *getUserName*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserName() |
|  |  |  | testSetGetUserName2() |

### Class *User* - method *setUserName()*

**Criteria for method *setUserName*:**

 -

**Predicates for method *setUserName*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserName() |
|  |  |  | testSetGetUserName2() |

### Class *User* - method *getPassword()*

**Criteria for method *getPassword*:**

 -

**Predicates for method *getPassword*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetPassword() |
|  |  |  | testSetGetUserPassword2() |

### Class *User* - method *setPassword()*

**Criteria for method *setPassword*:**

 -

**Predicates for method *setPassword*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetPassword() |
|  |  |  | testSetGetPassword2() |

### Class *User* - method *getEmail()*

**Criteria for method *getEmail*:**

 -

**Predicates for method *getEmail*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetEmail() |
|  |  |  | testSetGetEmail2() |

### Class *User* - method *setEmail()*

**Criteria for method *setEmail*:**

 -

**Predicates for method *setEmail*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetEmail() |
|  |  |  | testSetGetEmail2() |

### Class *User* - method *getReputation()*

**Criteria for method *getReputation*:**

 -

**Predicates for method *getReputation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReputation() |
|  |  |  | testSetGetReputation2() |

### Class *User* - method *setReputation()*

**Criteria for method *setReputation*:**

 -

**Predicates for method *setReputation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReputation() |
|  |  |  | testSetGetReputation2() |

### Class *User* - method *getAdmin()*

**Criteria for method *getAdmin*:**

 -

**Predicates for method *getAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetAdmin() |
|  |  |  | testSetGetAdmin2() |

### Class *User* - method *setAdmin()*

**Criteria for method *setAdmin*:**

 -

**Predicates for method *setAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetAdmin() |
|  |  |  | testSetGetAdmin2() |

# White Box Unit Tests

### Test cases definition

    <JUnit test classes must be in src/test/java/it/polito/ezgas>
    <Report here all the created JUnit test cases, and the units/classes under test >
    <For traceability write the class and method name that contains the test case>


|      Unit name      |     JUnit test case     |
|---------------------|-------------------------|
| GasStation.java     | GasStationTest.java     |
| User.java           | UserTest.java           |
| [GasStationDto.java](#GasStationDto)  | testGasStationDto.java  |
| [UserDto.java](#UserDto)              | testUserDto.java        |
| [IdPw.java](#IdPw)                    | testIdPw.java           |
| [LoginDto.java](#LoginDto)       | testLoginDto.java       |

# GasStationDto

### Class *GasStationDto* - method *GasStationDto*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  |testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() |

### Class *GasStationDto* - method *setGasStationDtoId*

**Criteria for method *GasStationDto*:**

 -Set the ID of a GasStationDto. 

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| VaLUE ID | Valid |
|          | Invalid |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Integer positive Value | [ 0 , MAXINT ]|

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid ID | Valid | Set the value to 1 and then check it is setted | testSetGetGasStationDtoId() |
| Valid ID | Valid | Set the value to 1 and then check it is setted | testSetGetGasStationDtoId1() |
| No ID | Valid | When the value is not setted, the value should be null | testSetGetGasStationDtoId2() |

### Class *GasStationDto* - method *getGasStationDtoId*

**Criteria for method *GasStationDto*:**

 -Get the ID of a GasStationDto. 

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| VaLUE ID | Valid |
|          | Invalid |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Integer positive Value | [ 0 , MAXINT ]|

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid ID | Valid | Set the value to 1 and then check it is setted | testSetGetGasStationDtoId() |
| Valid ID | Valid | Set the value to 1 and then check it is setted | testSetGetGasStationDtoId1() |
| No ID | Valid | When the value is not setted, the value should be null | testSetGetGasStationDtoId2() |

### Class *GasStationDto* - method *setGasStationDtoName*

**Criteria for method *GasStationDto*:**

 - Set a name for a GasStation

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| String | Valid name |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid Name | Valid | Set a name and check the value | testSetGetGasStationDtoName() |
| Valid Name | Valid | Set a name and check the value | testSetGetGasStationDtoName1() |
|  | Valid | Check that when the value is not setted, the value is null | testSetGetGasStationDtoName2() |

### Class *GasStationDto* - method *getGasStationDtoName*

**Criteria for method *GasStationDto*:**

  - Get a name for a GasStation

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| String | Valid name |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid Name | Valid | Set a name and check the value | testSetGetGasStationDtoName() |
| Valid Name | Valid | Set a name and check the value | testSetGetGasStationDtoName1() |
|  | Valid | Check that when the value is not setted, the value is null | testSetGetGasStationDtoName2() |

### Class *GasStationDto* - method *setGasStationDtoAddress*

**Criteria for method *GasStationDto*:**

  - Set an address for a GasStation

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| String | Valid name |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |                 |


**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid Address| Valid | Set an address and check the value | testSetGetGasStationDtoAddress() |
| Valid Address| Valid | Set an address and check the value | testSetGetGasStationDtoAddress1() |
|  | Valid | Check that when the value is not setted, the value is null | testSetGetGasStationDtoAddress2() |

### Class *GasStationDto* - method *getGasStationDtoAddress*

**Criteria for method *GasStationDto*:**

  - Get an address for a GasStation

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| String | Valid name |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| String |                 |


**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid Address| Valid | Set an address and check the value | testSetGetGasStationDtoAddress() |
| Valid Address| Valid | Set an address and check the value | testSetGetGasStationDtoAddress1() |
|  | Valid | Check that when the value is not setted, the value is null | testSetGetGasStationDtoAddress2() |

### Class *GasStationDto* - method *setReportDependability*

**Criteria for method *GasStationDto*:**

 - Set the ReportDependability

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| ReportDependability | Valid |
|          | Invalid |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  | [0.0 , 100.0|

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid ID | Valid | Test the method with a valid ID | testSetGetReportDependability() |
|  |  | Test the method when the attribute is not setted | testSetGetReportDependability2() |

### Class *GasStationDto* - method *getReportDependability*

**Criteria for method *GasStationDto*:**

 - Get the ReportDependability

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| ReportDependability | Valid |
|          | Invalid |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  | [0.0 , 100.0|

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Valid ID | Valid | Test the method with a valid ID | testSetGetReportDependability() |
|  |  | Test the method when the attribute is not setted | testSetGetReportDependability2() |

### Class *GasStationDto* - method *setReportUser*

**Criteria for method *GasStationDto*:**

 -Set the attribute ReportUser 

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| ReportUser as a positive number (Integer) | Valid |
|          | Invalid |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Positive INTEGER | 0 < * |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Positive integer | Valid | Check that when you set the attribute value to a positive integer is saved correctly | testSetGetReportUser() |
|  |  | Check that when the attribute is not setted, it should return a null | testSetGetReportUser2() |

### Class *GasStationDto* - method *getReportUser*

**Criteria for method *GasStationDto*:**

  -Set the attribute ReportUser 

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
| ReportUser as a positive number (Integer) | Valid |
|          | Invalid |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Positive INTEGER | 0 < * |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
| Positive integer | Valid | Check that when you set the attribute value to a positive integer is saved correctly | testSetGetReportUser() |
|  |  | Check that when the attribute is not setted, it should return a null | testSetGetReportUser2() |

### Class *GasStationDto* - method *setReportTimestamp*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReportTimestamp() |
|  |  |  | testSetGetReportTimestamp1() |
|  |  |  | testSetGetReportTimestamp2() |

### Class *GasStationDto* - method *getReportTimestamp*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReportTimestamp() |
|  |  |  | testSetGetReportTimestamp1() |
|  |  |  | testSetGetReportTimestamp2() |

### Class *GasStationDto* - method *setUser*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUser() |

### Class *GasStationDto* - method *getUser*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUser() |

### Class *GasStationDto* - method *setCarSharing*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetCarSharing() |
|  |  |  | testSetGetCarSharing2() |

### Class *GasStationDto* - method *getCarSharing*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetCarSharing() |
|  |  |  | testSetGetCarSharing2() |

### Class *GasStationDto* - method *setLat*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetLat() |
|  |  |  | testSetGetLat2() |

### Class *GasStationDto* - method *getLat*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetLat() |
|  |  |  | testSetGetLat2() |

### Class *GasStationDto* - method *setLon*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetLon() |
|  |  |  | testSetGetLon2() |

### Class *GasStationDto* - method *getLon*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetLon() |
|  |  |  | testSetGetLon2() |

### Class *GasStationDto* - method *setHas...*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetHasDiesel() |
|  |  |  | testSetGetHasSuper() |
|  |  |  | testSetGetHasSuperPlus() |
|  |  |  | testSetGetHasGas() |
|  |  |  | testSetGetHasMethane() |
|  |  |  | testSetGetHasDiesel2() |
|  |  |  | testSetGetHasSuper2() |
|  |  |  | testSetGetHasSuperPlus2() |
|  |  |  | testSetGetHasGas2() |
|  |  |  | testSetGetHasMethane2() |

### Class *GasStationDto* - method *getHas...*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetHasDiesel() |
|  |  |  | testSetGetHasSuper() |
|  |  |  | testSetGetHasSuperPlus() |
|  |  |  | testSetGetHasGas() |
|  |  |  | testSetGetHasMethane() |
|  |  |  | testSetGetHasDiesel2() |
|  |  |  | testSetGetHasSuper2() |
|  |  |  | testSetGetHasSuperPlus2() |
|  |  |  | testSetGetHasGas2() |
|  |  |  | testSetGetHasMethane2() |

### Class *GasStationDto* - method *set...Price*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetDieselPrice() |
|  |  |  | testSetGetSuperPrice() |
|  |  |  | testSetGetSuperPlusPrice() |
|  |  |  | testSetGetGasPrice() |
|  |  |  | testSetGetMethanePrice() |
|  |  |  | testSetGetDieselPrice2() |
|  |  |  | testSetGetSuperPrice2() |
|  |  |  | testSetGetSuperPlusPrice2() |
|  |  |  | testSetGetGasPrice2() |
|  |  |  | testSetGetMethanePrice2() |

### Class *GasStationDto* - method *get...Price*

**Criteria for method *GasStationDto*:**

 -

**Predicates for method *GasStationDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetDieselPrice() |
|  |  |  | testSetGetSuperPrice() |
|  |  |  | testSetGetSuperPlusPrice() |
|  |  |  | testSetGetGasPrice() |
|  |  |  | testSetGetMethanePrice() |
|  |  |  | testSetGetDieselPrice2() |
|  |  |  | testSetGetSuperPrice2() |
|  |  |  | testSetGetSuperPlusPrice2() |
|  |  |  | testSetGetGasPrice2() |
|  |  |  | testSetGetMethanePrice2() |

# UserDto

### Class *UserDto* - method *UserDto*

**Criteria for method *UserDto*:**

 -

**Predicates for method *UserDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  |testUserDto() |
|  |  |  |testUserDto2() |

### Class *UserDto* - method *getUserDtoId()*

**Criteria for method *getUserDtoId*:**

 - value of Id

**Predicates for method *getUserDtoId*:**

| Criteria | Predicate |
| -------- | --------- |
| value Id | -1 (invalid) |
|          | 1 (valid) |
|| no value |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserDtoId() (test valid and invalid Id) |
|  |  |  | testSetGetUserDtoId2() (test null Id)|

### Class *UserDto* - method *setUserDtoId()*

**Criteria for method *setUserDtoId*:**

 -

**Predicates for method *setUserDtoId*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserDtoId() |
|  |  |  | testSetGetUserDtoId2() |

### Class *UserDto* - method *getUserDtoName()*

**Criteria for method *getUserDtoName*:**

 -

**Predicates for method *getUserDtoName*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserDtoName() |
|  |  |  | testSetGetUserDtoName2() |

### Class *UserDto* - method *setUserDtoName()*

**Criteria for method *setUserDtoName*:**

 -

**Predicates for method *setUserDtoName*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserDtoName() |
|  |  |  | testSetGetUserDtoName2() |

### Class *UserDto* - method *getPassword()*

**Criteria for method *getPassword*:**

 -

**Predicates for method *getPassword*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetPassword() |
|  |  |  | testSetGetUserDtoPassword2() |

### Class *UserDto* - method *setPassword()*

**Criteria for method *setPassword*:**

 -

**Predicates for method *setPassword*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetPassword() |
|  |  |  | testSetGetPassword2() |

### Class *UserDto* - method *getEmail()*

**Criteria for method *getEmail*:**

 -

**Predicates for method *getEmail*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetEmail() |
|  |  |  | testSetGetEmail2() |

### Class *UserDto* - method *setEmail()*

**Criteria for method *setEmail*:**

 -

**Predicates for method *setEmail*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetEmail() |
|  |  |  | testSetGetEmail2() |

### Class *UserDto* - method *getReputation()*

**Criteria for method *getReputation*:**

 -

**Predicates for method *getReputation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReputation() |
|  |  |  | testSetGetReputation2() |

### Class *UserDto* - method *setReputation()*

**Criteria for method *setReputation*:**

 -

**Predicates for method *setReputation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReputation() |
|  |  |  | testSetGetReputation2() |

### Class *UserDto* - method *getAdmin()*

**Criteria for method *getAdmin*:**

 -

**Predicates for method *getAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetAdmin() |
|  |  |  | testSetGetAdmin2() |

### Class *UserDto* - method *setAdmin()*

**Criteria for method *setAdmin*:**

 -

**Predicates for method *setAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetAdmin() |
|  |  |  | testSetGetAdmin2() |

# IdPw

### Class *IdPw* - method *IdPw*

**Criteria for method *IdPw*:**

 -

**Predicates for method *IdPw*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  |testIdPw() |
|  |  |  |testIdPwStringString() |

### Class *IdPw* - method *getPw()*

**Criteria for method *getPw*:**

 -

**Predicates for method *getPw*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetPw() |

### Class *IdPw* - method *setPw()*

**Criteria for method *setPw*:**

 -

**Predicates for method *setPw*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetPw() |

### Class *IdPw* - method *getUser()*

**Criteria for method *getUser*:**

 -

**Predicates for method *getUser*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUser() |

### Class *IdPw* - method *setUser()*

**Criteria for method *setUser*:**

 -

**Predicates for method *setUser*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUser() |

# LoginDto

### Class *LoginDto* - method *LoginDto*

**Criteria for method *LoginDto*:**

 -

**Predicates for method *LoginDto*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  |testLoginDto() |
|  |  |  |testLoginDtoIntegerStringStringStringInteger() |

### Class *LoginDto* - method *getLoginDtoId()*

**Criteria for method *getLoginDtoId*:**

 - value of Id

**Predicates for method *getLoginDtoId*:**

| Criteria | Predicate |
| -------- | --------- |
| value Id | -1 (invalid) |
|          | 1 (valid) |
|| no value |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserId() (test valid and invalid Id) |
|  |  |  | testSetGetUserId2() (test null Id)|

### Class *LoginDto* - method *setLoginDtoId()*

**Criteria for method *setLoginDtoId*:**

 -

**Predicates for method *setLoginDtoId*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserId() |
|  |  |  | testSetGetUserId2() |

### Class *LoginDto* - method *getLoginDtoName()*

**Criteria for method *getLoginDtoName*:**

 -

**Predicates for method *getLoginDtoName*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserName() |
|  |  |  | testSetGetUserName2() |

### Class *LoginDto* - method *setLoginDtoName()*

**Criteria for method *setLoginDtoName*:**

 -

**Predicates for method *setLoginDtoName*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetUserName() |
|  |  |  | testSetGetUserName2() |

### Class *LoginDto* - method *getToken()*

**Criteria for method *getToken*:**

 -

**Predicates for method *getToken*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetToken() |
|  |  |  | testSetGetToken2() |

### Class *LoginDto* - method *setToken()*

**Criteria for method *setToken*:**

 -

**Predicates for method *setToken*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetToken() |
|  |  |  | testSetGetToken2() |

### Class *LoginDto* - method *getEmail()*

**Criteria for method *getEmail*:**

 -

**Predicates for method *getEmail*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetEmail() |
|  |  |  | testSetGetEmail2() |

### Class *LoginDto* - method *setEmail()*

**Criteria for method *setEmail*:**

 -

**Predicates for method *setEmail*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetEmail() |
|  |  |  | testSetGetEmail2() |

### Class *LoginDto* - method *getReputation()*

**Criteria for method *getReputation*:**

 -

**Predicates for method *getReputation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReputation() |
|  |  |  | testSetGetReputation2() |

### Class *LoginDto* - method *setReputation()*

**Criteria for method *setReputation*:**

 -

**Predicates for method *setReputation*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetReputation() |
|  |  |  | testSetGetReputation2() |

### Class *LoginDto* - method *getAdmin()*

**Criteria for method *getAdmin*:**

 -

**Predicates for method *getAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetAdmin() |
|  |  |  | testSetGetAdmin2() |

### Class *LoginDto* - method *setAdmin()*

**Criteria for method *setAdmin*:**

 -

**Predicates for method *setAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
|  |  |
|          |  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|  |                 |

**Combination of predicates**:

| Criteria | Valid / Invalid | Description of the test case | JUnit test case |
| ------- | -------|-------|-------|
|  |  |  | testSetGetAdmin() |
|  |  |  | testSetGetAdmin2() |


### Code coverage report

    <Add here the screenshot report of the statement and branch coverage obtained using
    the Eclemma tool. >

![Coverage](coverage.png)

### Loop coverage analysis

    <Identify significant loops in the units and reports the test cases
    developed to cover zero, one or multiple iterations >

|Unit name | Loop rows | Number of iterations | JUnit test case |
|---|---|---|---|
|||||
|||||
||||||
