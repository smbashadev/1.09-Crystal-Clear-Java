## 🧒 User-defined Methods

**User-defined methods** are methods that are **created/defined by the programmer** according to the program's requirements.

> **Programmer creates the method → method performs a required task → programmer calls the method when needed.**

---

## 1️⃣ Defined by Programmer

Suppose we want a method to display a welcome message.

We create it ourselves:

```java id="j5r2wa"
static void welcome() {
    System.out.println("Welcome to Java!");
}
```

Here, `welcome()` is a **user-defined method**.

Java didn't give us this method. **We created it.**

---

## 2️⃣ Requirement-based Methods

We create methods based on **what our program needs to do**.

For example:

```text id="4z0w7k"
Requirement
    ↓
Need to add numbers
    ↓
Create add() method

Requirement
    ↓
Need to calculate square
    ↓
Create square() method

Requirement
    ↓
Need to display student details
    ↓
Create displayStudent() method
```

Examples:

```java id="9gq8r1"
static void add() {
    // addition logic
}

static void calculateSquare() {
    // square logic
}

static void displayStudent() {
    // student details logic
}
```

---

# 3️⃣ Calling a User-defined Method

**Defining** a method means **creating/writing it**.

**Calling** a method means **asking Java to execute it**.

Example:

```java id="x8k3m2"
class Demo {

    static void greet() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {

        greet();    // Calling the method
    }
}
```

### Flow

```text id="q4v7nz"
Define method
    ↓
greet()
    ↓
main() calls greet()
    ↓
greet() executes
    ↓
Hello!
```

---

## 🔍 Definition vs Calling

### Defining

```java id="7s1mka"
static void greet() {
    System.out.println("Hello!");
}
```

Means:

> "Here is what the `greet()` method should do."

### Calling

```java id="q6r9pt"
greet();
```

Means:

> "Execute the `greet()` method now."

---

# 🧠 Real-World Example

Imagine you create a **Maggi recipe** 🍜.

### Define

```text id="r8m3yc"
prepareMaggi()
    ↓
Boil water
Add Maggi
Stir
Serve
```

You have created the method/recipe.

### Call

```text id="s2n7vb"
prepareMaggi();
```

You are saying:

> **"Prepare Maggi now!"**

---

## ⭐ Easy Memory Trick

```text id="a6k9qw"
USER-DEFINED METHOD

Programmer creates it
        ↓
Based on requirement
        ↓
Define the method
        ↓
Call the method
        ↓
Method executes
```

### 🔑 Interview Answer

> **A user-defined method is a method created by the programmer according to the requirements of the application. It is defined with the required logic and can be executed by calling its method name.**
