# **📌 Advanced Java Lab - Assignments (UCSH-605)**
This folder contains all the **assignments for the Advanced Java Lab (UCSH-605)** course, focusing on **SOLID principles, Object-Oriented Design, and Java Coding practices**.

---

## **📜 List of Assignments**
| **Assignment** | **Description** | **Topics Covered** |
|--------------|----------------|--------------------|
| **Assignment 1** | Refactor a Poorly Designed Code (Apply SRP & OCP) | **Single Responsibility Principle (SRP), Open/Closed Principle (OCP)** |
| **Assignment 2** | Implement Liskov Substitution Principle (LSP) | **Liskov Substitution Principle (LSP), Class Hierarchy Design** |
| **Assignment 3** | Payment Processing System (Applying All SOLID Principles) | **SOLID Principles, Interface Segregation, Dependency Inversion** |
| **Assignment 4** | Chat App using Socket Programming in Java | **1) One-to-One 2) One-to-Many** |

---

## **🔹 Assignment 1: Refactor a Poorly Designed Code (SRP & OCP)**
### **📌 Problem Statement**
The given Java code violates **SRP (Single Responsibility Principle)** and **OCP (Open/Closed Principle)**.  
Refactor the code to:
1. **Separate concerns properly** (SRP)
2. **Make it extensible** for new storage types without modifying the base class (OCP)

### **📌 Files**
- `easy1.java`   Original code violating SOLID principles  → Refactored version following SRP & OCP.

### **📌 Topics Covered**
✅ **Single Responsibility Principle (SRP)** – Ensure each class has a single responsibility.  
✅ **Open/Closed Principle (OCP)** – Allow extension without modifying existing code.  

---

## **🔹 Assignment 2: Implement Liskov Substitution Principle (LSP)**
### **📌 Problem Statement**
A `Penguin` class extends `Bird`, but `Bird` has a `fly()` method. This **violates LSP** because not all birds can fly.

### **📌 Task**
1. Identify the issue in the hierarchy.
2. Refactor the design to **follow LSP**.
3. Ensure subclasses can replace the base class **without breaking behavior**.

### **📌 Files**
- `easy2.java`
  - **Before Refactoring** → Penguin inherits `fly()`, violating LSP.
  - **After Refactoring** → Introduces `Bird` as an abstract class and `CanFly` interface.

### **📌 Topics Covered**
✅ **Liskov Substitution Principle (LSP)** – Subclasses must be replaceable without altering system correctness.  
✅ **Proper Class Hierarchy Design** – Use **abstraction** to define capabilities correctly.  

---

## **🔹 Assignment 3: Design a Payment Processing System (SOLID)**
### **📌 Problem Statement**
Create a **scalable and maintainable** payment processing system supporting:
- **Credit Card**
- **PayPal**
- **Google Pay**

### **📌 Requirements**
✅ **Follow SOLID Principles**  
✅ Allow adding new payment methods **without modifying existing code**  
✅ Use **dependency injection** for flexibility  

### **📌 Class Structure**
```plaintext
PaymentService (Interface)
   ├── CreditCardPayment (Implements PaymentService)
   ├── PayPalPayment (Implements PaymentService)
   ├── GooglePayPayment (Implements PaymentService)
PaymentProcessor
PaymentLogger
PaymentServiceManager
Main
```

### **📌 Files**
diffass3.java
Implements all SOLID principles in a payment system.
### **📌 Topics Covered**
```
✅ Single Responsibility Principle (SRP) – Separate payment processing, logging, and transaction handling.
✅ Open/Closed Principle (OCP) – Allow new payment methods without modifying existing code.
✅ Liskov Substitution Principle (LSP) – Ensure each payment method behaves correctly as a PaymentService.
✅ Interface Segregation Principle (ISP) – Keep interfaces minimal and focused.
✅ Dependency Inversion Principle (DIP) – Depend on abstractions (PaymentService), not concrete implementations.
```
how_to_run:
  steps:
  
    - step: Clone the repository
      command: |
        git clone https://github.com/Saiganesh224212/Advanced_Java_Lab.git

    - step: Compile Java files
      commands:
        - javac easy1.java
        - javac easy2.java
        - javac diffass3.java

    - step: Run Java programs
      commands:
        - java easy1
        - java easy2
        - java diffass3

## **🔹 Assignment 4: Design a Chat App using Sockets in JAVA**






