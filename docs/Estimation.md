# Project Estimation  

Authors:  Alberto Canta, Dario Licastro, Ignacio López-Perea, Luca Rinelli

Date: 25/04/2020

Version: 1

# Contents



- [Estimate by product decomposition](#estimate-by-product-decomposition)
- [Estimate by activity decomposition](#Estimate-by-activity-decomposition)



# Estimation approach

Consider the EZGas  project as described in requirement document, this is an estimate plan for the project.
We considered to use Java Language with Spring Framework.
Group are about 4 developer working in parallel.

# Estimate by product decomposition



### 


|             | Estimate                        |             
| ----------- | ------------------------------- |  
| NC =  Estimated number of classes to be developed   |        33                     |             
|  A = Estimated average size per class, in LOC       |                58            | 
| S = Estimated size of project, in LOC (= NC * A) | 1914 |
| E = Estimated effort, in person hours (here use productivity 10 LOC per person hour)  | 192                                     |   
| C = Estimated cost, in euro (here use 1 person hour cost = 30 euro) | 5760 | 
| Estimated calendar time, in calendar weeks (Assume team of 4 people, 8 hours per day, 5 days per week ) |  2                  |  

# Estimate by activity decomposition



### 

|         Activity name    | Estimated effort (person hours)   |             
| ----------- | ------------------------------- | 
| Requirements| 60 |
| V&V Requirements | 10 |
| Design | 16 |
| V&V Design | 6 |
| Implementation | 192 |
| Code inspection and Test | 60 |


###
```plantuml
@startuml
printscale daily
Project starts the 13th of april 2020

[Requirements] lasts 5 days
[Requirements] is colored in Lightgreen/Blue

[V&V Requirements] starts the 15th of april 2020
[V&V Requirements] lasts 3 days

[Design] starts at [Requirements]'s end
[Design] lasts 8 days
[Design] is colored in Yellow/Blue

[V&V Design] starts the 24th of april 2020
[V&V Design] lasts 2 days
[V&V Design] is colored in Lightyellow/Blue

[Implementation] starts the 28th of april 2020
[Implementation] lasts 15 days
[Implementation] is colored in Red/Blue
[Design]->[Implementation]

[Code inspection and Test] starts the 13th of may 2020
[Code inspection and Test] lasts 7 days
[Code inspection and Test] is colored in Coral/Blue
[Implementation]->[Code inspection and Test]

@enduml

```


