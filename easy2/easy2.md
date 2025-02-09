**🚫Issue in the Hierarchy (Why it Violates LSP?)**

> **Liskov Substitution Principle (LSP) states that a subclass should be substitutable for its base class without breaking functionality.**

* Here, `Penguin` **inherits** the `fly()` method from `Bird`, but **penguins cannot fly** in reality.
* If we use a `Penguin` object in place of a `Bird` and call `fly()`, it will produce incorrect behavior.
* **This violates LSP** because not all `Birds` can fly, but `Bird` assumes that all of its subclasses will support `fly()`.

**✅How the Refactored Code Follows LSP**

1. **Created an abstract `Bird` class**
   * `Bird` **no longer assumes all birds can fly.** Instead, it has a generic `move()` method.
   * `Penguin` and `Parrot` both extend `Bird`, but each defines movement appropriately.
2. **Introduced a `CanFly` Interface**
   * Only birds that can actually **fly** (like `Parrot`) implement the `CanFly` interface.
   * `Penguin` does not implement `CanFly`, so  **it never has an incorrect `fly()` method** .

**🔹Summary of Fixes**

| **Problem**               | **Before Refactoring**                                             | **After Refactoring**                                                                   |
| ------------------------------- | ------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------- |
| **LSP Violation**         | `Penguin` extends `Bird` but inherits `fly()`, which it shouldn't. | `Bird` class **no longer assumes all birds fly** .`CanFly` interface is introduced. |
| **Incorrect Behavior**    | Calling `penguin.fly()` is logically incorrect.                        | Penguins**do not have a `fly()`method** , preventing misuse.                          |
| **Better Code Structure** | One big class with misleading behavior.                                  | A proper**hierarchy using abstraction & interfaces** .                                  |

**-> Final Benefits**

✅ **Ensures correct behavior** – `Penguin` never has an invalid `fly()` method.
✅ **Follows LSP** – Substituting `Penguin` or `Parrot` for `Bird` does not break functionality.
✅ **Easier to extend** – We can add more bird types without modifying existing code.

This approach **ensures maintainability, correctness, and compliance with Liskov’s Substitution Principle** !
