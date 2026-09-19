# 🧒`private` Access Specifier in Java

`private` is the **most restrictive** access specifier in Java.

> 🧠 **A private member can be accessed only inside the same class where it is declared.**

Think of a **personal locker** 🔒:

```text
private
   ↓
Only the owner can access it
```

---

## 1. Private Means Same Class Only

Example:

```java
class Student {

    private int age = 25;

    void display() {

        System.out.println(age);
    }
}
```

Here:

```java
private int age = 25;
```

means `age` can be accessed **inside `Student` only**.

So this is allowed:

```java
void display() {

    System.out.println(age);   // ✅
}
```

because `display()` is inside the same `Student` class.

---

# 2. Accessing From Another Class ❌

Now suppose we try:

```java
class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.age);  // ❌
    }
}
```

This gives a **compile-time error**.

Why?

Because:

```text
Student
   ↓
private age
   ↓
Demo
   ↓
ACCESS ❌
```

`Demo` is a different class.

---

# 3. Complete Program

```java
class Student {

    private int age = 25;

    void display() {

        System.out.println("Age = " + age);
    }
}

class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        s.display();

        // System.out.println(s.age);  // ❌ Compile-time error
    }
}
```

### Output

```text
Age = 25
```

The `display()` method can access `age` because both are inside:

```text
Student class
```

But `Demo` cannot directly access `age`.

---

# 4. How Can Another Class Access Private Data?

This is where **Encapsulation** becomes useful.

Instead of directly accessing:

```java
s.age
```

we can provide a public method:

```java
class Student {

    private int age = 25;

    public int getAge() {

        return age;
    }
}
```

Now:

```java
class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.getAge());
    }
}
```

Output:

```text
25
```

Notice:

```text
Demo
 ↓
public getAge()
 ↓
private age
```

The outside class **doesn't directly access** the private variable.

The public method provides **controlled access**.

---

# 5. Why Use `private`?

Suppose a bank has:

```java
class BankAccount {

    private double balance;
}
```

We don't want anyone to directly do:

```java
account.balance = -50000;
```

Instead, we can control how the value is changed:

```java
public void setBalance(double balance) {

    if (balance >= 0) {
        this.balance = balance;
    }
}
```

So:

```text
Outside class
      ↓
Public method
      ↓
Validation
      ↓
Private data
```

This provides **security and controlled access**.

---

# 6. `private` Has Minimum Visibility

Among Java's four access levels:

```text
public
   ↓
protected
   ↓
default
   ↓
private
```

`private` has the **minimum visibility**.

| Access Specifier | Same Class | Same Package | Different Package |
| ---------------- | ---------: | -----------: | ----------------: |
| `public`         |          ✅ |            ✅ |                 ✅ |
| `protected`      |          ✅ |            ✅ |        Restricted |
| `default`        |          ✅ |            ✅ |                 ❌ |
| `private`        |          ✅ |            ❌ |                 ❌ |

For `private`, the important rule is simply:

> **Same class only.**

---

# 🧠 Easy Real-Life Example

Imagine your **phone password** 🔐.

```text
Password
   ↓
Private
   ↓
Only you can directly use it
```

Other people cannot directly access it.

Similarly:

```java
private int balance;
```

means:

```text
Same class       → ✅
Other class      → ❌
Same package     → ❌
Different package → ❌
Child class      → ❌
```

A child class does **not** inherit/access the parent's private members directly.

---

# ⭐ Remember Forever

### Definition

> **`private` is an access specifier that provides the minimum visibility in Java. A private member can be accessed directly only within the class in which it is declared.**

### Golden Rule 🔥

```text
private
   ↓
SAME CLASS ONLY
```

### And remember:

```text
private data
    +
public getter/setter
    ↓
Encapsulation
    ↓
Controlled access
```

So when you see:

```java
private int amount;
```

immediately think:

> 🔒 **"Only this class can directly access it."**
