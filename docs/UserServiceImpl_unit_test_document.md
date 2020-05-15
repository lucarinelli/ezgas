# UserService Unit Test




### Criteria
- User Id
- User reputation

### Predicates
|value of userId |
| ---- |  
| User Is present in database |
| value of UserId is illegal i.e <0|
| User is not present in database |

|value of argument in  saveUser(..)|
| ---- |
| UserDto obj|
| wrong Obj|

|value of reputation|
| ---- |  
| reputation<-5 or reputation >5 |
|reputation not integer|
| reputation in range |


### Test cases

| value of useId | value of argument in saveUser()| value of reputation | test case |
| ----- | ----- | ------ | ----- |
| User Id present in database | ... | ... | t0(getUserById(userId)-return UserDto) |
| user Id not present in database | .... | .... | t1(getUserId(userId)-null ) |
| Illegal User Id | ... | ... | t2(getUserById(userId)->throwExeption)|
| .... | Correct UserDto Obj| ..... | t3(saveUser(UserDto userDto)->returns array of users) |
| ...  | Wrong UserDto Obj | ..... | t4(saveUser(UserDto userDto)-> null) |
| ... | ..... | value of reputation in range | t5(increaseUserReputation(userReputation:5)>userReputation=5)|
| ... | .... | value of reputation not in range | t6 (increaseUserReputation(userReputation:-1)->null)|
 
