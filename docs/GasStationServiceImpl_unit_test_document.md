# GasStationServiceImpl Unit Test

## Black Box

### GasStationDto getGasStationById(Integer gasStationId)

Queries the database and return a single gas station corresponding to the database given as parameter.

Returns null if no gas station is found with the given id.

#### 1. Criteria
- Value of gasStationId
	
#### 2. Predicates
- Value of gasStationId
	+ a gas station with this gasStationId is present in the database
	+ no gas station in the database for this gasStationId

#### 3. Combine and prune

| Value of gasStationId |
| --- |
| Is in the db |
| Is not in the db |

#### 4. Test cases

| Value of gasStationId | Test case |
| --- | --- |
| Is in the db | T1{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* get id and save it in gsid\*/<br>gss.getGasStationById(gsid) -> gsdto;} |
| Is not in the db | T2{gasStationService gss;<br>/\* get id and save it in gsid\*/<br>gss.getGasStationById(gsid) -> null;} |

### GasStationDto saveGasStation(GasStationDto gasStationDto)

Receives a GasStationDto and store it in the database.

Throws exceptions in case of negative prices or wrong latitude and longitude values in the GasStationDto.

#### 1. Criteria
- Value of prices
- Value latitude
- Value longitude
	
#### 2. Predicates
- Value of prices
	+ no price is negative
	+ at least one price is negative
- Value latitude
	+ correct [-90, +90]
	+ wrong (-inf, -90) U (+90, +inf)
- Value longitude
	+ correct [-180, +180]
	+ wrong (-inf, -180) U (+180, +inf)

#### 3. Combine and prune

| Value of prices | Value latitude | Value longitude |
| --- | --- | --- |
| no negative | correct | correct |
| no negative | correct | wrong |
| no negative | wrong | correct |
| no negative | wrong | wrong |
| at least one negative | correct | correct |
| at least one negative | correct | wrong |
| at least one negative | wrong | correct |
| at least one negative | wrong | wrong |

#### 4. Test cases

| Value of prices | Value latitude | Value longitude | Test case |
| --- | --- | --- | --- |
| no negative | correct | correct | T3{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* No exception must be generated \*/<br>//Check that is in the db<br>gss.getGasStationById(gsid) -> gsdto;} |
| no negative | correct | wrong | T4{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for GPS must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |
| no negative | wrong | correct | T5{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for GPS must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |
| no negative | wrong | wrong | T6{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for GPS must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |
| at least one negative | correct | correct | T7{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for price must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |
| at least one negative | correct | wrong | T8{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for price or GPS must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |
| at least one negative | wrong | correct | T9{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for price or GPS must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |
| at least one negative | wrong | wrong |  T10{gasStationService gss;<br>GasStationDto gsdto;<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>/\* An exception for price or GPS must be generated \*/<br>//Check that is NOT in the db<br>gss.getGasStationById(gsid) -> null;} |

### List<GasStationDto> getAllGasStations()
Returns an ArrayList with all the GasStations stored in the database

Returns an empty ArrayList if no gas station is registered in the database

#### 1. Criteria
- Number of gas stations in db
	
#### 2. Predicates
- Number of gas stations in db
	+ no gas station in the db
	+ one gas station in the db
	+ many gas station in the db

#### 3. Combine and prune

| Number of gas stations in db |
| --- | 
| no gas station in the db |
| one gas station in the db (pruned)|
| many gas station in the db |

#### 4. Test cases

| Number of gas stations in db | Test case |
| --- | --- |
| no gas station in the db | T11{gasStationService gss;<br>gss.getAllGasStations() -> empty List} |
| many gas station in the db | T12{gasStationService gss;<br>GasStationDto gsdto;<br>loop N times<br>/\* set parameters for dto\*/<br>gsdto = gss.saveGasStation(gsdto);<br>end loop<br>gss.getAllGasStations() -> List with the same dtos obtained from save;} |