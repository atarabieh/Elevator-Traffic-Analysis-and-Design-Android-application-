# Elevator Traffic Analysis and Design
![logo](https://i.imgur.com/AkBhBjY.png)

#### Objective: _To help designing and elevator system for different types of buildings, and to minimize the problem of overcrowding, specially in peek hours._

#### This application was based on (Monte Carlo Simulation) method.

###### It was developed on Android Studio IDE, to make it possible for any android users to have this helpful tool in their hands, rather than manually making surveys and doing a lot of calculation.

### Flow chart:
![Flow Chart](https://i.imgur.com/oRkegXt.png)

## Tutorial:

1. The first step is to get the floor populations:
    1. Where you must first know if the floor populations are equal or not.
    2. If not equal the user inputs the number of floors above the ground and then the population per floor.
    3. From there you can easily get the building population.
    
2.	Calculate the arrival entrances from the multiple entrances (if they are multiple) and represent the arrival percentages as a Probability Density Function (PDF). Shown below is an example of a PDF

3. The PDF is then converted to a Cumulative Distribution Function (CDF) by integration

4.	Next you need to get the number of passengers; you can either do this by calculating the arrival rate and from there get the number of passengers or ask the user to enter the number of passengers.

5.	The floor heights must be obtained:
    1. This category can either be equal or unequal floor heights.
    2.	Where the user must enter the floor heights himself

6.	The kinematic parameters must be inserted (velocity, acceleration and jerk).

7.	Next the inter-floor distance matrix must be calculated.
    1.	Where the matrix is set to zero at first.
    2.	Set the diagonal values to zero.
    3.	Calculate the upper triangle of the matrix.
    4.	Equate the lower triangle to the upper triangle.

8.	Evaluate the kinematics matrix and its 3 cases:
    1.	Case 1: Rated speed and acceleration attained.
    2.	Case 2: Rated speed not attained but rated acceleration attained.
    3.	Case 3: Rated speed and rated acceleration not attained.

9.	Create a loop for the Calculation.

10.	 Generate random passenger destinations.

11.	 Find the number of stops.

12.	 Let the user enter the following information:
    1. Door opening and closing times.
    2. Passenger boarding and alighting times.

13.	 Calculate the kinematic time.

14.	 Find the RTT for all the trials and add them together.

15.	 Finally, repeating many scenarios, finding the round-trip time for each scenario and then taking the average value of the round trip, The RTT is obtained.


