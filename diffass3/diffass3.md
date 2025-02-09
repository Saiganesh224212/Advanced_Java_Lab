# **Payment Processing System – Explanation (Applying SOLID Principles)**

This **payment processing system** supports multiple payment methods ( **Credit Card, PayPal, Google Pay** ) while ensuring **scalability, flexibility, and maintainability** using  **SOLID principles** .

---

## **📌 Overview of the Code**

The system consists of  **multiple classes, each handling a specific responsibility** :

1. **`PaymentService` Interface** → Defines a **common contract** for all payment methods.
2. **Payment Implementations (`CreditCardPayment`, `PayPalPayment`, `GooglePayPayment`)** → Handle different payment methods.
3. **`PaymentProcessor`** → Executes the payment process (authorization & completion).
4. **`PaymentLogger`** → Logs transaction details.
5. **`PaymentServiceManager`** → Manages payment processing, keeps `main` method clean.
6. **`main` Method** → Simply triggers payment processing.

1️⃣ `PaymentService` Interface (OCP, ISP)

✔ **Open for Extension (OCP)** – New payment methods can be added  **without modifying existing code** .
✔ **Interface Segregation (ISP)** – The interface **only** defines relevant payment-related methods.

2️⃣ Payment Implementations (LSP)

✔ **Liskov Substitution Principle (LSP)** – `CreditCardPayment`, `PayPalPayment`, and `GooglePayPayment` **can replace `PaymentService`** without breaking the system.

3️⃣ `PaymentProcessor` (DIP, SRP)

✔ **Dependency Inversion Principle (DIP)** – `PaymentProcessor` **depends on an abstraction (`PaymentService`)** instead of concrete classes.
✔ **Single Responsibility Principle (SRP)** – It **only** handles the payment process,  **not logging or user input** .

4️⃣ `PaymentLogger` (SRP)

✔ **SRP (Single Responsibility Principle)** – This class  **only logs transactions** , keeping logging **separate** from payment processing.

5️⃣ `PaymentServiceManager` (Manages the Payment Flow)

✔ **Keeps `main` method clean.**
✔ **Manages both processing and logging in a structured way.**
✔ **If more functionality (like refunds) is needed, we add it here—without modifying `main`!**

## **✅ How Each SOLID Principle is Applied**

| **SOLID Principle**                       | **How It Is Applied in This System**                                                                                                |
| ----------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| **SRP (Single Responsibility Principle)** | `PaymentProcessor` handles only execution,`PaymentLogger` handles logging,`PaymentServiceManager` manages operations.               |
| **OCP (Open/Closed Principle)**           | New payment methods (e.g.,`PaytmPayment`) can be added **without modifying existing code** .                                      |
| **LSP (Liskov Substitution Principle)**   | `CreditCardPayment`,`PayPalPayment`, and `GooglePayPayment`  **can replace `PaymentService` without breaking the system** . |
| **ISP (Interface Segregation Principle)** | `PaymentService` **only**defines necessary methods, so classes don’t have to implement unnecessary ones.                         |
| **DIP (Dependency Inversion Principle)**  | `PaymentProcessor` depends on `PaymentService` (an abstraction), **not concrete classes** .                                     |

## **Final Benefits of This Design**

✔ **Modular & Maintainable** – Easy to add new payment types  **without modifying existing classes** .
✔ **Flexible & Extensible** – We can extend functionality (e.g., refunds, multiple currencies)  **without breaking the system** .
✔ **Testable & Scalable** – Each class can be  **tested separately** , making debugging easier.
✔ **Adheres to Best Practices** – The  **`main` method is clean** , and concerns are well-separated.

💯 **This design ensures a flexible, extensible, and scalable payment processing system following all SOLID principles.**
