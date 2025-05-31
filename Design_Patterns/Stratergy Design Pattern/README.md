In Low-Level Design (LLD), the pattern that focuses on isolating the changeable and non-changeable parts of a system is the Strategy Pattern.
The Strategy Pattern allows you to define a family of algorithms, encapsulate each one, and make them interchangeable. This helps in separating the parts of the system that remain constant from those that can vary, making the design more flexible and maintainable.

Ex: Consider an abstract Class(interface) named Robot has methods walk,talk,projection implemented by concerete classes like WorkerRobot, CompanionRobot . Later if therecomes a no.of robots which has ability to fly (i.e. method fly) . so change architecture as flyable so on... 
Since some methods like walk,talk,see are fixed for any robot and some methods like fly,dance etc are changble so seperate them from fixed part . This Design Pattern is called Strategy Design Pattern.
