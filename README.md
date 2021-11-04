# PRO192-Car-Management

## Scenario
### The car showroom, named Minh Trang BMW, has a list of BMW cars. BMW brands are stored in a text file, named brands.txt, and cars are stored in a text file, named cars.txt as following:
#### File brands.txt	Description
```
B7-2018, BMW 730Li (2018), Harman Kardon: 3.749
B7-MS, BMW 730Li M Sport, Harman Kardon: 4.319
B7-MS20, BMW 730Li M Sport (2020), Harman Kardon: 4.369
B7-PE, BMW 730Li Pure Excellence, Harman Kardon: 4.929
B5-18, BMW 530i (2018), Alpine: 2.599
B7019, BMW 530i (2019) , Alpine: 2.729
BX4-18, BMW X4 xDrive20i (2018), Sony: 2.799
BX4-17, BMW X4 xDrive20i (2019) , Sony: 2.899
B3-GT18, BMW 320i GT (2018), Bose: 1.799
B3-S19, BMW 320i Sportline (2019), Bose: 1.899
B5-X19, BMW X5 xDrive40i XLine (2019), Bose: 4.199
B5-X20, BMW X5 xDrive40i XLine (2020), Bose: 4.239
<ID, brand name, sound brand: price>
```
#### File cars.txt	Description
```
C01, B7-2018, red, F12345, E12345
C02, B7-2018, black, F12346, E12346
C03, B7-MS, orange, F12347, E12347
C04, B7-MS20, white, F12348, E12348
C05, B7-PE, pink, F12349, E12349 
C06, B5-18, pink, F12350, E12350
C07, B5-X20, grey, F12351, E12351
<ID, brand ID, color, frame ID, engine ID>
```

## Problem requirements

### The manager of the showroom needs a Java console application in which operations must be supported:
```
1. List all brands
2. Add a new brand
3. Search a brand based on its ID
4. Update a brand
5. Save brands to the file, named brands.txt
6. List all cars in ascending order of brand names
7. List cars based on a part of an input brand name
8. Add a car
9. Remove a car based on its ID
10. Update a car based on its ID
11. Save cars to file, named cars.txt
```

## Constraints
```
1. Constraints on brands:
  * Brand ID can not be duplicated.
  * The brand name can not be blank.
  * The sound manufacturer can not be blank.
  *	The price must be a positive real number.

2. Constraints on cars:
  * Car ID can not be duplicated.
  * Brand ID must have existed and it must be inputted using a menu.
  * Color can not be blank.
  * Frame ID can not be blank and must be in the  “F00000” format and can not be duplicated.
  * Engine ID can not be blank and must be in the  “E00000” format and can not be duplicated.
```
