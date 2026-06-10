Camp Gear Manager App

Student Information

Name: Blessings Massiye
Student Number: ST10395974
Module: IMAD5112
Assessment: Practicum Examination

Project Overview

The Camp Gear Manager App is an Android application developed using Kotlin in Android Studio. The purpose of the application is to help users manage camping gear by allowing them to add items, categorize them, record quantities, and include comments for each item.

The application provides a simple and user-friendly interface for managing gear information and viewing detailed item information. The app uses parallel arrays to store and manage data efficiently.

Application Features

Splash Screen
Displays the application logo and title.
Automatically transitions to the Home Screen after 3 seconds.
<img width="310" height="687" alt="Screenshot 2026-06-10 at 10 22 38" src="https://github.com/user-attachments/assets/bef431aa-c20b-4982-8d93-e0baec45537a" />


Home Screen

Allows users to enter:
Item Name
Category
Quantity
Comments

Add new gear items to the application.

Displays a running list of added items.

Calculates and displays the total number of packed items using a loop.

Provides navigation to the Detailed View screen.

<img width="242" height="537" alt="Screenshot 2026-06-10 at 13 07 36" src="https://github.com/user-attachments/assets/c64f1b1e-1825-461b-b7d7-57f4b5bfb917" />

Detailed View Screen

Displays complete information for all stored gear items.
Shows item comments.
Displays additional packing tips and recommendations.
Provides navigation back to the Home Screen.

<img width="324" height="712" alt="Screenshot 2026-06-10 at 13 38 20" src="https://github.com/user-attachments/assets/931cf71d-76ef-4458-a202-6d2645fc59f4" />

Data Structures Used

The application uses parallel ArrayLists to store item information.
val itemNames = ArrayList<String>()
val categories = ArrayList<String>()
val quantities = ArrayList<Int>()
val comments = ArrayList<String>()
Each index position across the arrays represents one gear item.

Example:

Item Name	Category	Quantity	Comment
Tent	Shelter	1	Waterproof tent
Sleeping Bag	Sleeping	2	Warm and comfortable
Programming Concepts Implemented

The application demonstrates the following programming concepts:

Variables
Functions
Loops
Arrays
Parallel Arrays
Input Validation
Activity Navigation
User Interaction
Kotlin Programming

Total Items Calculation

The total number of packed items is calculated using a loop:
var totalItems = 0
for (quantity in quantities) {
    totalItems += quantity
}

Sample Data

The application is initialized with sample camping gear data:

Tent
Sleeping Bag
Water Bottle
This allows the application to demonstrate functionality immediately after launch.

Application Flow

User opens the application.
Splash Screen displays for 3 seconds.
Home Screen opens.
User enters gear information.
User clicks Add Item.
Item is stored in the parallel arrays.
Total packed items are updated.
User selects View Details.
Detailed information and packing tips are displayed.

Technologies Used

Android Studio
Kotlin


How to Run the Application

Open Android Studio.
Clone or download the project.
Open the project folder.
Allow Gradle to sync.
Run the application on an emulator or Android device.

