
# Project Overview
This project implements a `Date` class in Java, designed to represent and manipulate dates. The class supports various operations, including:

- Validating a date
- Handling leap years
- Updating date attributes
- Determining the day of the week
- Calculating the difference in days between two dates
- Printing the date in a readable format
- Sorting a list of `Date` objects using `Collections.sort()`

The project includes a `Main` class to demonstrate these functionalities with various test cases.

---

# Features
- **Date Validation:** Checks if a date is valid, considering month lengths and leap years.
- **Leap Year Support:** Correctly handles February 29 for leap years.
- **Day of the Week Calculation:** Determines which day of the week a given date falls on.
- **Date Difference Calculation:** Computes the difference in days between two dates.
- **Sorting:** Implements `Comparable<Date>` to enable sorting by year, month, and day.
- **Error Handling:** Provides informative error messages for invalid inputs.

---

## Installation & Execution

## Prerequisites
Ensure you have the following installed on your system:
- Java Development Kit (JDK) 8 or later
- An IDE like IntelliJ IDEA, Eclipse, or VS Code (optional)
- Git (for cloning the repository)

## Steps to Run
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/yourusername/DateClassJava.git
   cd DateClassJava
   ```

2. **Compile the Java files:**
   ```sh
   javac Date.java Main.java
   ```

3. **Run the program:**
   ```sh
   java Main
   ```

4. **Expected Output:**
   - The program will demonstrate date validation, updating dates, printing the day of the week, computing date differences, and sorting dates.
   - If invalid dates are entered, error messages will be displayed.

---

### Notes & Challenges
- Handling leap years correctly required careful implementation.
  
I have a problem a determining whether a year is a leap year or not.
And how i solved it:
A year is considered a leap year if one of the following conditions is met:
It is divisible by 400 (e.g. 2000, 2400).
It is divisible by 4, but not divisible by 100 (e.g. 2024, 2028, but not 1900 or 2100).




- Zeller's congruence was used to calculate the day of the week.
     
I have a problem calculating the day of the week for a given date.
Then I searched the Internet for how to solve this problem and saw that there is a Zeller congruence that calculates the days of the week for a given date.
  
  




