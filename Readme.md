# Automatic Garbage Collector in Java

This repository demonstrates Java's automatic garbage collection mechanism, a core feature that manages memory automatically by reclaiming objects that are no longer in use.

## What is Automatic Garbage Collector?
Java’s automatic garbage collector is a built-in process within the Java Virtual Machine (JVM) that continuously monitors and frees memory by identifying objects that are no longer reachable. This process helps manage memory without explicit programmer intervention.

## How is Automatic Garbage Collector Different from Other Languages?
- **Automatic Memory Management:** Unlike languages such as C/C++ that require manual memory management (using functions like `malloc/free` or `new/delete`), Java handles memory deallocation automatically.
- **Reduced Programmer Burden:** This minimizes errors such as memory leaks and dangling pointers.
- **Non-Deterministic Behavior:** The exact time when the garbage collector reclaims memory is not predictable, unlike manual memory management where the programmer decides when to free memory.

## Why Was the Concept Introduced?
- **Simplification:** It relieves developers from the intricate task of manual memory management.
- **Error Prevention:** Automatic garbage collection significantly reduces the risk of memory-related bugs.
- **Efficiency:** The JVM can optimize memory usage based on runtime behavior, resulting in more efficient applications.
- **Portability:** It ensures consistent memory management across various platforms without changing the code.

## Why Can’t We See Garbage Collection in Normal Programs?
Garbage collection is inherently non-deterministic. It runs in the background at times decided by the JVM, so its activity is usually invisible in standard program output. Unless explicitly triggered or logged (for example, via print statements in overridden methods), garbage collection happens silently.

## How Can We Visualize Garbage Collection?
- **Overriding `finalize()`:** In this repository, classes override the `finalize()` method to print messages when an object is collected.
- **Explicit GC Calls:** Using `System.gc()` (although it is only a suggestion to the JVM) can help trigger garbage collection.

## The `finalize` Method
The `finalize()` method is called by the garbage collector on an object when it determines there are no more references to that object. It is meant to allow cleanup of resources before the object is reclaimed. However, its execution is uncertain, and its use is generally discouraged in modern Java development because:
- It may not be executed promptly—or at all.
- It can lead to unpredictable behavior and performance issues.
- Newer Java versions have deprecated its use in favor of more robust resource management techniques.

## Explanation of the Program Codes

### FinalizeExample.java
- **Purpose:** Demonstrates garbage collection by creating a large number of objects.
- **How It Works:** 
  - The `GarbageCollector1` class logs a message upon object creation and when the object is garbage collected (via its `finalize()` method).
  - The `FinalizeExample` class creates one million `GarbageCollector1` objects without storing their references, making them eligible for garbage collection.
- **Outcome:** As objects become unreachable, their finalizers print messages indicating garbage collection activity.

### Car.java
- **Purpose:** Defines a `Car` class with a `maxspeed` attribute.
- **Key Feature:** Overrides the `finalize()` method to print a message when a `Car` object is garbage collected.
- **Note:** The `finalize()` method is used here solely for demonstration.

### Truck.java
- **Purpose:** Defines a `Truck` class with a `maxspeed` attribute.
- **Key Feature:** Similar to `Car`, it overrides `finalize()` to log when the object is collected.
- **Usage:** Helps illustrate garbage collection on objects still in use versus those nullified.

### FinalizeExample2.java
- **Purpose:** Illustrates garbage collection by manipulating object references.
- **How It Works:** 
  - A `Car` object is created and then set to `null`, making it eligible for garbage collection.
  - A `Truck` object is instantiated and used in a loop to simulate ongoing operations.
  - A call to `System.gc()` is made to suggest that the JVM perform garbage collection.
- **Outcome:** You may observe the `finalize()` message for the `Car` object when it is collected, whereas the `Truck` object remains in use.

## Download and Run Instructions

### Prerequisites
- **Java Development Kit (JDK):** Ensure you have JDK 8 or later installed. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.
- **Git:** (Optional) For cloning the repository.

### Cloning the Repository from GitHub
Clone the repository using Git with the following command:
```bash
git clone https://github.com/computerman2027/AUTOMATIC-GARBAGE-COLLECTOR-IN-JAVA.git
```

### Running the Code
1. **Navigate to the Repository Directory:**
   Open your terminal or command prompt and change to the repository directory:
   ```bash
   cd "AUTOMATIC-GARBAGE-COLLECTOR-IN-JAVA"
   ```
2. **Compile the Java Files:**
   Compile all the Java source files:
   ```bash
   javac *.java
   ```
3. **Run the Examples:**
   - To run the garbage collection demonstration with many objects:
     ```bash
     java FinalizeExample
     ```
   - To run the example that uses explicit `System.gc()` and demonstrates reference nullification:
     ```bash
     java FinalizeExample2
     ```
4. **Observing the Output:**
   The console will display messages indicating object creation, garbage collection, and finalization (if the garbage collector runs as suggested).
