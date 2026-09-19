# 🧒 Java — Store and Print Name & Age

Here we learn how to **store information in variables** and then **display it on the screen**.

Imagine a person:

```text
Name → Basha
Age  → 26
```

We can store these two values using two different data types:

```text
String → Name
int    → Age
```

---

# 1. String Variable — Store Name

A **String** is used to store text.

Example:

```java
String name = "Basha";
```

Think of it as a box:

```text
┌─────────────┐
│ name        │
│   "Basha"   │
└─────────────┘
```

Here:

* `String` → data type
* `name` → variable name
* `"Basha"` → value

So:

> **String variable = a variable used to store text.**

Examples:

```java
String name = "Basha";
String city = "Hyderabad";
String course = "Java";
```

---

# 2. `int` Variable — Store Age

An `int` is used to store **whole numbers**.

Example:

```java
int age = 26;
```

Think of it as:

```text
┌─────────────┐
│ age         │
│     26      │
└─────────────┘
```

Here:

* `int` → data type
* `age` → variable name
* `26` → value

So:

> **`int` variable = a variable used to store whole-number values.**

Examples:

```java
int age = 26;
int marks = 90;
int salary = 30000;
```

---

# 3. Store Name and Age Together

Now we can write:

```java
String name = "Basha";
int age = 26;
```

We have:

```text
name → "Basha"

age  → 26
```

---

# 4. Print Name

We can print the name:

```java
System.out.println(name);
```

Output:

```text
Basha
```

Print age:

```java
System.out.println(age);
```

Output:

```text
26
```

---

# 5. String Concatenation 🔗

**Concatenation** simply means:

> **Joining strings and other values together.**

In Java, we commonly use the `+` operator for concatenation.

Example:

```java
String name = "Basha";
int age = 26;

System.out.println("Name: " + name);
```

Output:

```text
Name: Basha
```

We can combine both:

```java
System.out.println("Name: " + name + ", Age: " + age);
```

Output:

```text
Name: Basha, Age: 26
```

Think of `+` as **joining things together** when a String is involved.

```text
"Name: " + "Basha"
       ↓
"Name: Basha"
```

---

# 6. Important: `+` Can Mean Addition or Concatenation

This is very important.

### Numbers only → Addition

```java
System.out.println(10 + 20);
```

Output:

```text
30
```

### String involved → Concatenation

```java
System.out.println("Age: " + 26);
```

Output:

```text
Age: 26
```

So:

```text
10 + 20
   ↓
Addition
   ↓
30
```

But:

```text
"Age: " + 26
       ↓
Concatenation
       ↓
"Age: 26"
```

---

# 7. Output Formatting

**Output formatting** means presenting information in a **clean and readable way**.

Instead of:

```text
Basha
26
```

we can make it clearer:

```text
Name: Basha
Age: 26
```

Program:

```java
class Person {
    public static void main(String[] args) {

        String name = "Basha";
        int age = 26;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

Output:

```text
Name: Basha
Age: 26
```

---

# 8. Print Both in One Line

You can also print everything on one line:

```java
System.out.println("Name: " + name + ", Age: " + age);
```

Output:

```text
Name: Basha, Age: 26
```

---

# 9. Using `\t` for Formatting

You can use a tab to create spacing:

```java
System.out.println("Name\tAge");
System.out.println(name + "\t" + age);
```

Output approximately:

```text
Name    Age
Basha   26
```

---

# 10. Using `\n` for Formatting

`\n` moves the output to the next line.

```java
System.out.println("Name: " + name + "\nAge: " + age);
```

Output:

```text
Name: Basha
Age: 26
```

---

# 🧠 Complete Program

```java
class Person {
    public static void main(String[] args) {

        String name = "Basha";
        int age = 26;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        System.out.println();

        System.out.println("Person Details");
        System.out.println("Name\t: " + name);
        System.out.println("Age\t: " + age);
    }
}
```

Output:

```text
Name: Basha
Age: 26

Person Details
Name    : Basha
Age     : 26
```

---

# 🎯 Easy Way to Remember

```text
String
  ↓
Text
  ↓
String name = "Basha";


int
  ↓
Whole number
  ↓
int age = 26;
```

Then:

```text
String + value
      ↓
Concatenation
      ↓
Readable output
```

### ⭐ Interview Answer

> **A String variable stores text such as a person's name, while an int variable stores whole-number values such as age. In Java, the `+` operator can be used for String concatenation to combine text with variables and create formatted output.**
