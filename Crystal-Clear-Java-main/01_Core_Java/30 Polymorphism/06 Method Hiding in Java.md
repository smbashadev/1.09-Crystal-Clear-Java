# 🧒 Method Hiding in Java

**Method Hiding** happens when both the **parent and child classes have a static method with the same signature**.

The most important thing to remember is:

> 🧠 **Static methods are hidden, not overridden.**

---

## 1. Parent Has a Static Method

```java
class Parent {

    static void fun() {
        System.out.println("Parent fun()");
    }
}
```

Here `fun()` is a **static method**.

---

## 2. Child Has the Same Static Method

```java
class Child extends Parent {

    static void fun() {
        System.out.println("Child fun()");
    }
}
```

Both classes have:

```text
Parent → static fun()
Child  → static fun()
```

The child does **not override** the parent's static method.

It **hides** it.

---

# 3. Why Is It Called Method Hiding?

Because static methods belong to the **class**, not to individual objects.

So Java does not use runtime polymorphism to select between the two static methods.

Instead, the **reference/class type determines which method is called**.

---

# 4. Important Program ⭐

```java
class Parent {

    static void fun() {
        System.out.println("Parent fun()");
    }
}

class Child extends Parent {

    static void fun() {
        System.out.println("Child fun()");
    }
}

class Demo {

    public static void main(String[] args) {

        Parent p = new Child();

        p.fun();
    }
}
```

### Output

```text
Parent fun()
```

This may look surprising.

The object is:

```text
new Child()
```

But the reference is:

```text
Parent p
```

For a static method, the **reference type** is used.

```text
Parent p = new Child();
      ↓
p.fun();
      ↓
Reference type = Parent
      ↓
Parent.fun()
```

---

# 5. Compare With Method Overriding

### Instance method — overriding

```java
Parent p = new Child();

p.fun();
```

If `fun()` is an overridden **non-static** method:

```text
Actual object = Child
       ↓
Child.fun()
```

### Static method — hiding

If `fun()` is **static**:

```text
Reference type = Parent
       ↓
Parent.fun()
```

This is the key difference.

---

# 6. Class Name Should Be Used for Static Methods

Because static methods belong to classes, the preferred way to call them is using the **class name**.

```java
Parent.fun();
```

and:

```java
Child.fun();
```

Output:

```text
Parent fun()
Child fun()
```

This makes it very clear which class's static method you want.

---

# 7. Complete Program

```java
class Parent {

    static void fun() {
        System.out.println("Parent fun()");
    }
}

class Child extends Parent {

    static void fun() {
        System.out.println("Child fun()");
    }
}

class Demo {

    public static void main(String[] args) {

        Parent.fun();
        Child.fun();

        Parent p = new Child();

        p.fun();
    }
}
```

### Output

```text
Parent fun()
Child fun()
Parent fun()
```

---

# 🧠 Why `p.fun()` Calls Parent?

Because:

```java
Parent p = new Child();
```

has:

```text
Reference type → Parent
Actual object  → Child
```

For **static methods**, Java uses the **reference/class type**, not the actual object's type.

Therefore:

```text
p.fun()
 ↓
Parent.fun()
```

---

# 8. Very Important Comparison

| Feature                         | Method Overriding   | Method Hiding        |
| ------------------------------- | ------------------- | -------------------- |
| Method type                     | Instance/non-static | Static               |
| Parent & child same method      | Yes                 | Yes                  |
| Child replaces parent behavior? | Overrides           | Hides                |
| Runtime polymorphism?           | Yes                 | No                   |
| Method selection                | Actual object       | Reference/class type |
| Recommended call                | Reference/object    | Class name           |

---

# ⭐ Remember Forever

### Method Overriding:

```text
Non-static method
      ↓
Parent reference + Child object
      ↓
Runtime
      ↓
Child method
```

### Method Hiding:

```text
Static method
      ↓
Parent + Child have same static method
      ↓
No overriding
      ↓
Method is hidden
      ↓
Reference/class type determines method
```

### Golden Rule 🔥

> **Static methods are hidden, not overridden.**

And:

> **Use the class name to call static methods.**

```java
Parent.fun();
Child.fun();
```

### Interview Answer

> **Method hiding occurs when a child class defines a static method with the same signature as a static method in its parent class. Static methods cannot be overridden because they belong to the class. The method selected is determined by the reference or class type rather than the actual object type.**
