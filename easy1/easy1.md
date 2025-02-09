**Issues in the Code**

1. **Single Responsibility Principle (SRP) Violation** :

* The `Employee` class has multiple responsibilities:
  * Storing employee details (`name`, `salary`)
  * Printing a payslip (`printPaySlip()`)
  * Saving employee details to a database (`saveToDatabase()`)
* This makes the class harder to maintain and test.

1. **Open/Closed Principle (OCP) Violation** :

* If we want to change the storage method (e.g., save to a file instead of a database), we must modify `Employee`, violating OCP.
* The class should be  **open for extension but closed for modification** .

**Explanation of Improvements**

✅ **Single Responsibility Principle (SRP)**

* `Employee` now  **only represents an employee** .
* `PaySlipPrinter`  **handles printing** .
* `EmployeeStorage`  **handles storage operations** .

✅ **Open/Closed Principle (OCP)**

* Instead of modifying `Employee` to change storage methods, we created an  **`EmployeeStorage` interface** .
* Now, we can add new storage options (e.g., `FileStorage`, `CloudStorage`)  **without modifying existing code** .

This design ensures **better maintainability, extensibility, and separation of concerns** .

**🔹 Summary of Improvements**

| **Principle** |                          **Before Refactoring**                          | **After Refactoring**                                                                              |
| :------------------ | :----------------------------------------------------------------------------: | -------------------------------------------------------------------------------------------------------- |
| **SRP**       | `Employee`class handles multiple responsibilities (data, printing, storage). | `Employee` only stores data. `PaySlipPrinter` handles printing.`EmployeeStorage` handles storage. |
| **OCP**       |        Adding new storage types required modifying `Employee `class.        | New storage methods can be added by creating new classes without modifying existing code.                |

**Final Benefits of Refactoring**

✅ **Easier to maintain** – Changes in printing or storage don’t affect the `Employee` class.
✅ **More scalable** – New features can be added without breaking existing functionality.
✅ **Better testability** – We can unit test `Employee`, `PaySlipPrinter`, and `EmployeeStorage` separately.
