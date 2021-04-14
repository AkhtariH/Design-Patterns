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
<img src="https://northeurope1-mediap.svc.ms/transform/thumbnail?provider=spo&inputFormat=png&cs=fFNQTw&docid=https%3A%2F%2Fnewuniversity-my.sharepoint.com%3A443%2F_api%2Fv2.0%2Fdrives%2Fb!FoqPN0w1JU67L4hRpPLvubiOhD1-AB1Kj2aUdVa53fBBD1J-dnclTaEaS6tBko9-%2Fitems%2F01SVBBAJBXDRCE7DLK5BGYJUIHZCAJN5EU%3Fversion%3DPublished&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvbmV3dW5pdmVyc2l0eS1teS5zaGFyZXBvaW50LmNvbUAwMTZhOWU0OC1iYTBiLTQ5ZjQtOTdmOC1hODgzNTIxNjRlNTgiLCJpc3MiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAiLCJuYmYiOiIxNjE4NDAxNjAwIiwiZXhwIjoiMTYxODQyMzIwMCIsImVuZHBvaW50dXJsIjoiM25CTjkrYy82ZFhyaENncmZ4MEo2Z2ZIMDVidHJiODFablVJY1pZSXA5MD0iLCJlbmRwb2ludHVybExlbmd0aCI6IjEyMyIsImlzbG9vcGJhY2siOiJUcnVlIiwidmVyIjoiaGFzaGVkcHJvb2Z0b2tlbiIsInNpdGVpZCI6Ik16YzRaamhoTVRZdE16VTBZeTAwWlRJMUxXSmlNbVl0T0RnMU1XRTBaakpsWm1JNSIsInNpZ25pbl9zdGF0ZSI6IltcImttc2lcIl0iLCJuYW1laWQiOiIwIy5mfG1lbWJlcnNoaXB8aGVtcmFuLmFraHRhcmlAc3R1ZGVudC5uaGxzdGVuZGVuLmNvbSIsIm5paSI6Im1pY3Jvc29mdC5zaGFyZXBvaW50IiwiaXN1c2VyIjoidHJ1ZSIsImNhY2hla2V5IjoiMGguZnxtZW1iZXJzaGlwfDEwMDMwMDAwYWI4MTgyODBAbGl2ZS5jb20iLCJ0dCI6IjAiLCJ1c2VQZXJzaXN0ZW50Q29va2llIjoiMyJ9.dGFaUWI1djJrMXFxWDF3WDdVa2Q2V2swVUUrVndTN2NySTg3SEtXdTJFUT0&encodeFailures=1&width=3840&height=1724&srcWidth=&srcHeight=" alt="Class Diagram" width="500">
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
- Added unique functionality for each state
- Added ItemColorDecorator, ItemPriorityDecorator and ItemReminderDecorator
- Fixed Decorator by adding super etc.
- Created Application class where all the console output is handled
- Created .jar file for execution



