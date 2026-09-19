# 🧒 Constructors Based on Parameters

A constructor can accept **different numbers of parameters**.

When we talk about:

* **0-parameterized constructor**
* **1-parameterized constructor**
* **2-parameterized constructor**

we are simply counting **how many parameters the constructor receives**.

---

## 1. 0-Parameterized Constructor

A constructor with **zero parameters**.

```java
class Student {

    Student() {
        System.out.println("0 parameters");
    }
}
```

Here:

```text
Student()
   ↑
0 parameters
```

Creating the object:

```java
Student s = new Student();
```

There is nothing inside the brackets.

### Output

```text
0 parameters
```

🧠 **Remember:**

> `()` = 0 parameters

---

# 2. 1-Parameterized Constructor

A constructor with **one parameter**.

```java
class Student {

    Student(String name) {
        System.out.println("Name: " + name);
    }
}
```

Here:

```text
Student(String name)
        ↑
   1 parameter
```

Creating the object:

```java
Student s = new Student("Basha");
```

There is **one argument**:

```text
"Basha"
```

### Output

```text
Name: Basha
```

🧠 **Remember:**

> `(String name)` = 1 parameter

---

# 3. 2-Parameterized Constructor

A constructor with **two parameters**.

```java
class Student {

    Student(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

Here:

```text
Student(String name, int age)
        ↑             ↑
     Parameter 1   Parameter 2
```

Creating the object:

```java
Student s = new Student("Basha", 26);
```

There are **two arguments**:

```text
"Basha"   → name
26        → age
```

### Output

```text
Name: Basha
Age: 26
```

---

# 4. All Three Together

These can exist in the **same class** because they have different parameter lists.

```java
class Student {

    // 0-parameterized constructor
    Student() {
        System.out.println("No details");
    }

    // 1-parameterized constructor
    Student(String name) {
        System.out.println("Name: " + name);
    }

    // 2-parameterized constructor
    Student(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Demo {

    public static void main(String[] args) {

        Student s1 = new Student();

        Student s2 = new Student("Basha");

        Student s3 = new Student("Basha", 26);
    }
}
```

### Output

```text
No details

Name: Basha

Name: Basha
Age: 26
```

---

# 🧠 How Java Chooses the Constructor

Java looks at the arguments given during object creation.

```java
new Student();
```

Java sees:

```text
0 arguments
```

➡️ Calls:

```java
Student()
```

---

```java
new Student("Basha");
```

Java sees:

```text
1 argument
```

➡️ Calls:

```java
Student(String name)
```

---

```java
new Student("Basha", 26);
```

Java sees:

```text
2 arguments
```

➡️ Calls:

```java
Student(String name, int age)
```

---

# ⭐ Easy Memory Trick

```text
Student()
       ↓
0 parameters

Student(String)
       ↓
1 parameter

Student(String, int)
       ↓
2 parameters
```

So simply **count what's inside `()`**:

> **Nothing → 0**
> **One → 1**
> **Two → 2**

And when these constructors are present in the same class, this is an example of **constructor overloading**.
