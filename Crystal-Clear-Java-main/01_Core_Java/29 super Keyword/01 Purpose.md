# 🧒 `super` Keyword in Java

The `super` keyword is used inside a **child class** to refer to things that belong to its **immediate parent class**.

For your topic, we mainly use `super` to:

1. Access **parent class variables**
2. Access **parent class methods**

Think of it like:

```text
Child
  │
  └── super → "Go to my immediate parent"
```

---

# 1. Access Parent Class Variables

Suppose both the parent and child have a variable with the **same name**.

### Example

```java
class Parent {

    int x = 10;
}

class Child extends Parent {

    int x = 20;

    void display() {

        System.out.println(x);
        System.out.println(super.x);
    }
}
```

Create the object:

```java
class Demo {

    public static void main(String[] args) {

        Child c = new Child();

        c.display();
    }
}
```

### Output

```text
20
10
```

Why?

Inside `Child`:

```java
System.out.println(x);
```

means:

> "Give me the `x` belonging to the current class."

So it gets:

```text
Child x = 20
```

But:

```java
System.out.println(super.x);
```

means:

> "Go to my parent and give me its `x`."

So it gets:

```text
Parent x = 10
```

---

# 2. Visualize It 🧠

```text
             Parent
               │
             x = 10
               ↑
             super.x
               │
              Child
               │
             x = 20
```

Therefore:

```text
x       → Child's x
super.x → Parent's x
```

---

# 3. Why Do We Need `super.x`?

Imagine both classes have the same variable:

```java
class Parent {

    int amount = 1000;
}

class Child extends Parent {

    int amount = 500;
}
```

Now:

```java
System.out.println(amount);
```

prints:

```text
500
```

because the child has its own `amount`.

If we want the parent's amount:

```java
System.out.println(super.amount);
```

prints:

```text
1000
```

So `super` removes the confusion.

---

# 4. Access Parent Class Methods

`super` can also call a **method belonging to the parent class**.

Suppose:

```java
class Parent {

    void display() {
        System.out.println("Parent display()");
    }
}
```

The child overrides the method:

```java
class Child extends Parent {

    @Override
    void display() {
        System.out.println("Child display()");
    }
}
```

Normally:

```java
Child c = new Child();

c.display();
```

calls:

```text
Child display()
```

because the child has overridden the method.

---

# 5. Calling Parent Method Using `super`

Inside the child, we can specifically call the parent's version:

```java
class Child extends Parent {

    @Override
    void display() {

        System.out.println("Child display()");

        super.display();
    }
}
```

Now:

```java
Child c = new Child();

c.display();
```

### Output

```text
Child display()
Parent display()
```

Here:

```java
super.display();
```

means:

> **"Call the `display()` method from my immediate parent."**

---

# 6. Complete Program

```java
class Parent {

    int x = 10;

    void display() {
        System.out.println("Parent display()");
    }
}

class Child extends Parent {

    int x = 20;

    @Override
    void display() {

        System.out.println("Child x = " + x);

        System.out.println("Parent x = " + super.x);

        System.out.println("Child display()");

        super.display();
    }
}

class Demo {

    public static void main(String[] args) {

        Child c = new Child();

        c.display();
    }
}
```

### Output

```text
Child x = 20
Parent x = 10
Child display()
Parent display()
```

---

# 7. `super` Has Multiple Uses

The `super` keyword can be used in different ways:

| Syntax            | Purpose                   |
| ----------------- | ------------------------- |
| `super.x`         | Access parent variable    |
| `super.display()` | Access/call parent method |
| `super()`         | Call parent constructor   |

So remember:

```text
super.x
   ↓
Parent variable

super.display()
   ↓
Parent method

super()
   ↓
Parent constructor
```

---

# 🧠 Easy Real-Life Example

Imagine a parent and child both have a notebook called `notes`.

```text
Parent → notes
Child  → notes
```

If the child says:

```text
notes
```

it means the child's notes.

If the child says:

```text
super.notes
```

it means:

> "Give me my parent's notes."

Similarly:

```java
super.display();
```

means:

> "Parent, run your `display()` method."

---

# ⭐ Remember Forever

```text
             Parent
          /           \
       x = 10       display()
          ↑             ↑
       super.x     super.display()
          │             │
          └──────┬──────┘
                 ↓
               Child
              x = 20
```

### 🔥 Golden Rule

> **`super` means "refer to my immediate parent."**

```text
super.variable  → Parent variable
super.method()  → Parent method
super()         → Parent constructor
```

And the easiest way to remember the purpose you asked about:

> **`super` is used when the child wants to specifically access the parent's variable or parent's method.**
