## 🧒 Square of an Integer

Suppose we want a Java program that finds the **square of a number**.

### 1️⃣ What is a square?

Square means:

> **Number × Number**

For example:

```text
5² = 5 × 5 = 25
```

So in Java:

```java
int square = number * number;
```

---

# 2️⃣ Hard Coding

**Hard coding** means directly writing a value inside the program instead of getting it from the user.

Example:

```java
int number = 5;
```

Here, `5` is a **hard-coded value**.

Complete program:

```java
class Square {
    public static void main(String[] args) {

        int number = 5;       // Hard-coded value
        int square = number * number;

        System.out.println("Square = " + square);
    }
}
```

Output:

```text
Square = 25
```

---

## 🧒 Why is this called Hard Coding?

Because the value is **fixed inside the source code**.

If you want the square of `10`, you have to change:

```java
int number = 5;
```

to:

```java
int number = 10;
```

Then you must **compile and run the program again**.

```text
Code
 ↓
number = 5
 ↓
Square = 25
```

If you want another number:

```text
Change code
 ↓
Compile again
 ↓
Run again
```

---

# 3️⃣ Why is Hard Coding Bad Practice?

Hard coding isn't always wrong. It is useful for **constants, examples, testing, and configuration defaults**.

But for values that should change, hard coding is usually bad because:

* ❌ User cannot easily provide different values
* ❌ You have to modify the source code
* ❌ You may need to compile again
* ❌ Less reusable
* ❌ Less flexible

### Example

Hard-coded:

```java
int number = 5;
```

Only works with the value you wrote.

Better:

```text
Ask user → Get number → Calculate square
```

---

# 4️⃣ User Input Program Using `Scanner`

Java provides the **`Scanner` class** to read input from the user.

First import it:

```java
import java.util.Scanner;
```

Then create a Scanner object:

```java
Scanner sc = new Scanner(System.in);
```

Now ask the user for a number:

```java
int number = sc.nextInt();
```

### Complete program

```java
import java.util.Scanner;

class Square {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        int square = number * number;

        System.out.println("Square = " + square);

        sc.close();
    }
}
```

### Example Output

```text
Enter an integer: 7
Square = 49
```

If the user enters:

```text
10
```

Output:

```text
Square = 100
```

If the user enters:

```text
12
```

Output:

```text
Square = 144
```

---

# 🔍 How `Scanner` Works

Think of `Scanner` as a **person listening to the keyboard** 🎤⌨️.

```text
User
  ↓
Types 7
  ↓
Keyboard
  ↓
System.in
  ↓
Scanner
  ↓
nextInt()
  ↓
number = 7
  ↓
number × number
  ↓
49
```

### Important lines

```java
Scanner sc = new Scanner(System.in);
```

Means:

> Create a Scanner that reads input from the keyboard.

```java
int number = sc.nextInt();
```

Means:

> Read an integer entered by the user and store it in `number`.

---

## 🧠 Hard Coding vs User Input

| Hard Coding                | User Input                    |
| -------------------------- | ----------------------------- |
| `int number = 5;`          | `int number = sc.nextInt();`  |
| Value fixed in program     | Value provided at runtime     |
| Less flexible              | More flexible                 |
| Code modification needed   | No code modification needed   |
| Good for fixed/test values | Good for interactive programs |

### 🔑 Remember

```text
Hard Coding:
Program → Fixed value → Calculate

User Input:
Program → Scanner → User enters value → Calculate
```

**Interview answer:**

> **Hard coding means directly writing fixed values in the source code. It can reduce flexibility and reusability when values are expected to change. Using `Scanner`, we can accept values from the user at runtime without modifying the source code.**
