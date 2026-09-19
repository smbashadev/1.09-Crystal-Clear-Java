## 🧒 Calculator Program Using `Scanner`

Let's build a calculator where the **user enters two numbers and chooses an operation**.

The program will support:

```text
1 → Addition
2 → Subtraction
3 → Multiplication
4 → Division
```

---

# 💻 Complete Program

```java
import java.util.Scanner;

class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First number
        System.out.print("Enter first number: ");
        double first = sc.nextDouble();

        // Second number
        System.out.print("Enter second number: ");
        double second = sc.nextDouble();

        // User choice
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Decision making
        if (choice == 1) {

            double result = first + second;
            System.out.println("Addition = " + result);

        } else if (choice == 2) {

            double result = first - second;
            System.out.println("Subtraction = " + result);

        } else if (choice == 3) {

            double result = first * second;
            System.out.println("Multiplication = " + result);

        } else if (choice == 4) {

            if (second == 0) {
                System.out.println("Division by zero is not allowed.");
            } else {
                double result = first / second;
                System.out.println("Division = " + result);
            }

        } else {

            System.out.println("Invalid choice");

        }

        sc.close();
    }
}
```

---

# 🔍 Understand the Program Step-by-Step

## 1️⃣ `Scanner`

```java
Scanner sc = new Scanner(System.in);
```

Creates a Scanner to receive input from the keyboard.

```text
Keyboard
   ↓
System.in
   ↓
Scanner
   ↓
Java Program
```

---

## 2️⃣ First Number

```java
double first = sc.nextDouble();
```

The user enters the first number.

Example:

```text
Enter first number: 20
```

Now:

```text
first = 20
```

---

## 3️⃣ Second Number

```java
double second = sc.nextDouble();
```

Example:

```text
Enter second number: 10
```

Now:

```text
second = 10
```

---

# 4️⃣ User Choice

We show the user four choices:

```text
1. Addition
2. Subtraction
3. Multiplication
4. Division
```

Then:

```java
int choice = sc.nextInt();
```

Suppose the user enters:

```text
1
```

Then:

```text
choice = 1
```

---

# 5️⃣ `if`

```java
if (choice == 1) {
    double result = first + second;
}
```

If the choice is `1`, Java performs **addition**.

---

# 6️⃣ `else if`

If the first condition is false, Java checks the next condition.

```java
else if (choice == 2) {
    double result = first - second;
}
```

Then:

```text
choice = 2
      ↓
Subtraction
```

Similarly:

```java
else if (choice == 3)
```

means multiplication.

```java
else if (choice == 4)
```

means division.

---

# 7️⃣ `else`

If **none of the choices** are correct:

```java
else {
    System.out.println("Invalid choice");
}
```

For example:

```text
choice = 7
```

There is no option `7`.

Therefore:

```text
Invalid choice
```

---

# 🔄 Complete Flow

```text
              Start
                ↓
        Enter first number
                ↓
       Enter second number
                ↓
         Enter user choice
                ↓
        ┌───────┴────────┐
        ↓                ↓
     choice == 1?      No
        ↓
      Addition
        │
        └──────────────┐
                       ↓
                 choice == 2?
                       ↓
                  Subtraction
                       │
                       ↓
                 choice == 3?
                       ↓
                 Multiplication
                       │
                       ↓
                 choice == 4?
                    ↙       ↘
                  Yes        No
                   ↓          ↓
               Division    Invalid choice
```

---

# 🧪 Four Sample Executions

## 🟢 1. Addition

```text
Enter first number: 20
Enter second number: 10

Choose an operation:
1. Addition
2. Subtraction
3. Multiplication
4. Division

Enter your choice: 1

Addition = 30.0
```

---

## 🔵 2. Subtraction

```text
Enter first number: 20
Enter second number: 10

Choose an operation:
1. Addition
2. Subtraction
3. Multiplication
4. Division

Enter your choice: 2

Subtraction = 10.0
```

---

## 🟡 3. Multiplication

```text
Enter first number: 20
Enter second number: 10

Choose an operation:
1. Addition
2. Subtraction
3. Multiplication
4. Division

Enter your choice: 3

Multiplication = 200.0
```

---

## 🔴 4. Division

```text
Enter first number: 20
Enter second number: 10

Choose an operation:
1. Addition
2. Subtraction
3. Multiplication
4. Division

Enter your choice: 4

Division = 2.0
```

---

# ❌ Invalid Choice Example

If the user enters:

```text
Enter your choice: 9
```

Then:

```text
Invalid choice
```

because only `1`, `2`, `3`, and `4` are valid choices.

---

## 🧠 Remember the Whole Program

```text
Scanner
   ↓
First Number
   ↓
Second Number
   ↓
User Choice
   ↓
if
   → 1 → Addition
   ↓
else if
   → 2 → Subtraction
   ↓
else if
   → 3 → Multiplication
   ↓
else if
   → 4 → Division
   ↓
else
   → Invalid Choice
```

### 🔑 One-line memory

> **Input → Choose → Check → Calculate → Display**

This calculator combines several important Java concepts you've learned: **`Scanner` + variables + arithmetic operators + `if-else if-else` + boolean conditions**.
