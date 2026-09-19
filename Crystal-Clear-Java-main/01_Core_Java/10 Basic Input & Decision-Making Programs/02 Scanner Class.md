## 🧒 `Scanner` Class

Think of a Java program like a person who wants to **ask the user a question and listen to the answer**.

For example:

```text
Java: Enter your age:
User: 25
Java: Okay, your age is 25
```

Java uses the **`Scanner` class** to read that input.

---

## 1️⃣ `Scanner`

`Scanner` is a Java class used to **read input**.

First, import it:

```java
import java.util.Scanner;
```

Then create a Scanner object:

```java
Scanner sc = new Scanner(System.in);
```

Think:

```text
Scanner = Listener 👂
```

It listens for input from a source.

---

## 2️⃣ `System.in`

`System.in` represents the **standard input stream**.

For normal console programs, this usually means:

> **Input coming from the keyboard.**

So:

```java
new Scanner(System.in)
```

means:

> "Create a Scanner that reads input from the keyboard."

Think of it as:

```text
⌨️ Keyboard
    ↓
System.in
    ↓
Scanner
    ↓
Java Program
```

---

## 3️⃣ `nextInt()`

`nextInt()` is a Scanner method used to **read the next integer entered by the user**.

Example:

```java
int age = sc.nextInt();
```

If the user enters:

```text
25
```

then:

```text
age = 25
```

---

# 🔗 Put Everything Together

```java
import java.util.Scanner;

class Demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("You entered: " + number);

        sc.close();
    }
}
```

### Output

```text
Enter a number: 50
You entered: 50
```

---

## 🔍 Understand Each Part

### `Scanner`

```java
Scanner
```

➡️ Class used to read input.

### `sc`

```java
Scanner sc
```

➡️ `sc` is the **reference variable** pointing to the Scanner object.

### `new Scanner(System.in)`

```java
new Scanner(System.in)
```

➡️ Creates a Scanner object connected to standard input.

### `System.in`

```java
System.in
```

➡️ Standard input, normally the keyboard.

### `nextInt()`

```java
sc.nextInt()
```

➡️ Reads the next integer from the input.

---

## 🧠 Easy Memory Trick

```text
Scanner
   ↓
"Who will listen?"
   ↓
Scanner

System.in
   ↓
"Where does input come from?"
   ↓
Keyboard

nextInt()
   ↓
"What type of input should I read?"
   ↓
Integer
```

### ⭐ One-line formula

```text
Scanner + System.in + nextInt()
        ↓
Read integer from keyboard
```

**Interview answer:**

> `Scanner` is a Java class used to read input. `System.in` represents standard input, normally the keyboard, and `nextInt()` reads the next integer value from that input.
