Chmod Calculator
This program is a simple graphical tool to calculate numeric and symbolic permissions of a file or directory using the Unix-style permissions model, also known as "chmod".

How to use
When the program is launched, a window with three columns will appear. The left column is for the owner's permissions, the middle column is for the group's permissions, and the right column is for the public's permissions.

Each column contains three checkboxes that represent read, write, and execute permissions. By checking or unchecking these checkboxes, you can set or remove the corresponding permissions for each user group.

As you make changes, the program will automatically calculate and display the equivalent numeric and symbolic permissions in the fields at the bottom of the window.

You can also enter a numeric permission value directly into the "Numeric Permissions" field and the program will calculate and display the equivalent symbolic permissions.

Technical details
This program is written in Java and uses the Swing GUI toolkit. The program extends the JFrame class and implements the ActionListener interface to handle user input events.

The program defines several components, including checkboxes, labels, and text fields, and arranges them in a grid layout using the GridLayout manager.

The program uses color and font settings to customize the appearance of the checkboxes and text fields.

The actionPerformed method is used to handle user input events and update the numeric and symbolic permissions accordingly. When a checkbox is checked or unchecked, the method calculates the new numeric and symbolic values and updates the corresponding fields. Similarly, when a numeric value is entered, the method calculates the corresponding symbolic value and updates the symbolic field.
