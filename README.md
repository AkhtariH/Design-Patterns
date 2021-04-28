# Design Patterns: ToDo Application

<p align="center">
<img src="https://i.imgur.com/nxwa8lY.png" alt="Image" width="400">
</p>


## Description

The objective of this final assignment is to develop a Java application that incorporates at least three design patterns (Singleton and Iterator excluded). This application uses the Factory method pattern, Decorator pattern and the State pattern to create a simple console-based ToDo application where the user is able to create Lists and items within these lists. For more information about the application see the [documentation](#documentation).

## Documentation

[Click here](https://newuniversity-my.sharepoint.com/:b:/g/personal/hemran_akhtari_student_nhlstenden_com/Eb2sQxctwutHvrNmtiz0F8cBmKxeuegIfvKtsk3bKCpUXw?e=ozmU0h).

## Requirements
- Java JDK 11 or higher

## Usage

1. ``` git clone https://github.com/AkhtariH/Design-Patterns.git ```
2. ``` cd Design-Patterns/out/artifacts/todo_jar ```
3. ``` java -jar todo.jar ```

## Class diagram

<p align="center">
<img src="https://i.imgur.com/bFXiFqJ.png" alt="Class Diagram" width="650">
</p>

## Changelog
### Version 1.0
- Task interface and abstract class
- Private and Work class
- Factory pattern
- States (Backlog, InProgress, Done)
- Item interface and class
- Added decorator to Items
- Created console output in main 

### Version 1.1
- Some error handling
- Improved state pattern by adding next and previous state
- Added unique functionality for each state (Different rights for each state -> ADD, DELETE)
- Added ItemColorDecorator, ItemPriorityDecorator and ItemReminderDecorator
- Fixed Decorator by adding super etc.
- Created Application class where all the console output is handled
- Created .jar file for execution



