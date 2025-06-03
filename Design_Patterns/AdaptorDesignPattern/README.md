The Adapter Design Pattern is a structural pattern used in Low-Level Design (LLD) to enable interoperability between incompatible interfaces. It allows an existing class with an interface that doesn’t match what a client expects to work seamlessly without modifying the original class. Essentially, it acts as a bridge between two systems.
Key Concepts
- Target Interface: The expected interface that the client interacts with.
- Adaptee: The existing class with a different interface that needs adaptation.
- Adapter: A wrapper class that translates the adaptee’s interface to match the target interface.

In other words:Adaptor converts interface of 1 class into interface that client expects.
Adaptor lets classees work together that couldn't otherwise because of incompatible types.

Applications:
1) When u supposed to use  a 3rd party service in your application ex: payment logic etc
2) Working with legacy code to build modern application.