# 🧒 Object-to-String / Array Printing in Java

When you print something using:

```java
System.out.println();
```

Java behaves differently depending on **what you are printing**.

For example:

```java
String
Array
Object
```

A `String` usually prints its actual text, while arrays and ordinary objects can appear as something that looks strange, such as:

```text
[I@5e2de80c
Student@1b6d3586
```

Let's understand why.

---

# 1. Printing a String Object

Consider:

```java
String s = "Java";

System.out.println(s);
```

Output:

```text
Java
```

Why?

Because `String` has its own implementation of `toString()` that returns the String's actual contents.

Think:

```text
String object
     ↓
"Java"
     ↓
println()
     ↓
Java
```

So when you print a String, you normally see its **value**.

---

# 2. Printing an Array

Now consider:

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers);
```

You might expect:

```text
10 20 30
```

But you may get something like:

```text
[I@5e2de80c
```

This looks confusing. 😵

Don't worry.

That is Java's default object-style representation of the array.

---

# 3. Why Does the Array Print Like That?

An array is an **object in Java**.

When you do:

```java
System.out.println(numbers);
```

Java is effectively converting the object to a String representation.

An ordinary array does not override `toString()` to print all its elements.

So you see a representation similar to:

```text
[I@5e2de80c
```

The exact value after `@` will normally be different.

---

# 4. Understanding `[I@5e2de80c`

Let's break it into pieces:

```text
[I@5e2de80c
│ │
│ └── identity-style hash representation
│
└── array type information
```

For an `int[]`:

```text
[I
```

roughly indicates:

```text
[  → array
I  → int
```

So:

```text
[I@5e2de80c
```

is **not the actual contents**:

```text
10
20
30
```

It is an object representation.

---

# 5. How Do We Actually Print Array Elements?

Use a loop:

```java
class ArrayPrinting {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
```

Output:

```text
10
20
30
```

Or use:

```java
System.out.println(java.util.Arrays.toString(numbers));
```

Output:

```text
[10, 20, 30]
```

---

# 6. Printing an Ordinary Object

Suppose we create a `Student` class:

```java
class Student {

    String name = "Basha";
    int age = 25;

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s);
    }
}
```

You may get something like:

```text
Student@5e2de80c
```

Again, this is **not**:

```text
Basha 25
```

Why?

Because `Student` has not provided its own `toString()` implementation.

---

# 7. What Is the Default Object Representation?

Every Java class ultimately inherits methods from the `Object` class.

One important method is:

```java
toString()
```

If your class does not override it, the inherited implementation produces a representation based on the object's class and identity-related information.

It commonly looks like:

```text
ClassName@hexadecimalHash
```

For example:

```text
Student@5e2de80c
```

Think:

```text
Student
   ↓
Object's default toString()
   ↓
Student@5e2de80c
```

---

# 8. Why Doesn't Java Automatically Print the Object's Data?

Suppose:

```java
class Student {

    String name = "Basha";
    int age = 25;
}
```

Java cannot assume that you want:

```text
Basha 25
```

Maybe you want:

```text
Student: Basha
Age: 25
```

Or:

```text
Basha is 25 years old
```

So Java gives the default representation unless you tell the class how you want it represented.

---

# 9. Overriding `toString()`

We can tell Java exactly what to print.

```java
class Student {

    String name = "Basha";
    int age = 25;

    @Override
    public String toString() {
        return name + " " + age;
    }

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s);
    }
}
```

Output:

```text
Basha 25
```

Now Java uses our `toString()`.

---

# 10. Why Does `System.out.println(s)` Call `toString()`?

When you write:

```java
System.out.println(s);
```

where `s` is an object, Java needs to turn that object into text for printing.

Conceptually:

```text
s
↓
toString()
↓
String representation
↓
println()
```

So this:

```java
System.out.println(s);
```

is conceptually similar to:

```java
System.out.println(s.toString());
```

for an object reference.

---

# 11. String vs Object vs Array

| What you print                      | Example                       | Typical output   |
| ----------------------------------- | ----------------------------- | ---------------- |
| String                              | `System.out.println("Java")`  | `Java`           |
| String variable                     | `System.out.println(s)`       | `Java`           |
| Array                               | `System.out.println(arr)`     | `[I@...`         |
| Normal object                       | `System.out.println(student)` | `Student@...`    |
| Object with overridden `toString()` | `System.out.println(student)` | Your chosen text |

---

# 12. Very Important Difference

Suppose:

```java
String s = "Java";
```

Then:

```java
System.out.println(s);
```

prints:

```text
Java
```

But:

```java
int[] arr = {10, 20, 30};
```

and:

```java
System.out.println(arr);
```

does **not** print:

```text
10 20 30
```

Instead, you get something like:

```text
[I@...
```

Similarly:

```java
Student student = new Student();
System.out.println(student);
```

may produce:

```text
Student@...
```

---

# 🧠 Real-Life Example

Imagine you have three things:

### 📄 String

A paper says:

```text
Java
```

When someone asks what's written on it:

```text
Java
```

---

### 📦 Array

You have a box containing:

```text
10
20
30
```

If someone gives you only the **box identity**, you might say:

```text
Box #12345
```

You haven't listed what's inside.

That's similar to printing an array reference directly.

---

### 👨 Student Object

You have a student object:

```text
Name: Basha
Age: 25
```

Without defining how the object should be represented, Java may give:

```text
Student@5e2de80c
```

If you override `toString()`, you can tell Java:

```text
When someone prints me,
show my name and age.
```

---

# 🎯 Remember Forever

### String

```text
String
  ↓
has its own toString() behavior
  ↓
prints its text/value
```

### Array

```text
Array
  ↓
is an object
  ↓
doesn't override toString() to list elements
  ↓
array reference-style representation
```

### Normal Object

```text
Object
  ↓
toString()
  ↓
ClassName@identity-style-hash
```

### If you want object data

```java
@Override
public String toString() {
    return ...;
}
```

---

# ⭐ Golden Memory Trick

> **Printing a String gives its value. Printing an array directly gives an array object representation. Printing an ordinary object gives its default object representation unless you override `toString()`.**

```text
String
  ↓
"Java"

Array
  ↓
[I@...

Object
  ↓
Student@...

Override toString()
  ↓
Your own readable output
```
