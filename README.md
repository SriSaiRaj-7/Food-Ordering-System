# Food Ordering System

A simple Java console-based food ordering application built with object-oriented programming concepts such as classes, encapsulation, inheritance, and aggregation.

## Features

- View a restaurant menu with item ID, category, and price
- Add items to a cart
- Enter customer details
- Choose a payment method: cash, card, or UPI
- Place an order and print a summary
- Exit the application from the main menu

## Project structure

```text
Food Ordering System - Copy/
├── src/
│   └── com/
│       └── foodordering/
│           ├── Beverage.java
│           ├── CardPayment.java
│           ├── Cart.java
│           ├── CashPayment.java
│           ├── Customer.java
│           ├── Main.java
│           ├── MenuItem.java
│           ├── NonVegItem.java
│           ├── Order.java
│           ├── Payment.java
│           ├── Restaurant.java
│           ├── UpiPayment.java
│           └── VegItem.java
├── out/
│   └── com/
│       └── foodordering/
├── README.md
└── .gitignore (optional)
```

## Prerequisites

- Java Development Kit (JDK) installed
- A terminal or command prompt

Check Java is installed:

```bash
java -version
javac -version
```

## How to run the console app

From the project root folder, compile the Java source files and then run the main class.

### Windows PowerShell

```powershell
cd "C:\Users\Sri Sai Raj\Documents\college\Mini projects\OOPS\Food Ordering System - Copy"
Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { javac -d out $_.FullName }
java -cp out com.foodordering.Main
```

### Alternative: compile once, then run

```powershell
cd "C:\Users\Sri Sai Raj\Documents\college\Mini projects\OOPS\Food Ordering System - Copy"
javac -d out (Get-ChildItem -Recurse -Filter *.java -Path src | Select-Object -ExpandProperty FullName)
java -cp out com.foodordering.Main
```

## How to use the app

When the program starts, it displays the menu and prompts for input:

1. Press `1` to create an order
2. Enter item IDs from the menu
3. Type `0` when you are done selecting items
4. Enter your name and phone number
5. Choose a payment method:
   - `1` = Cash
   - `2` = Card
   - `3` = UPI
6. Press `2` in the main menu to exit the app

## Example interaction

```text
WELCOME TO FOOD ORDERING SYSTEM

==================== MENU ====================
ID   ITEM                     CATEGORY                PRICE
...
1. Create order
2. Exit
Choose an option: 1
Enter item IDs to add. Enter 0 when finished.
Item ID: 1
Item ID: 0
Customer name: Alice
Phone number: 9876543210
Payment methods:
1. Cash
2. Card
3. UPI
Choose payment method: 1
```

## Notes

- The app is fully interactive and expects input from the console.
- Use the terminal to type values when prompted.
- The project uses the package name `com.foodordering`.

## License

This project is for educational and learning purposes.
