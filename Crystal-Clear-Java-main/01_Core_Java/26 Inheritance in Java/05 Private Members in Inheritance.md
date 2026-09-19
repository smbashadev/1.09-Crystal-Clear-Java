# 🧒 Private Members in Inheritance

Now let's understand an important rule of inheritance:

> 🔐 **Private members of a parent class are not directly accessible in the child class.**

This is because `private` is mainly about **encapsulation and security**.

---

# 1. What Is a Private Member?

Suppose we have a parent class:

```java
class Parent {

    private int money = 10000;
}
```

The variable:

```java
private int money;
```

is a **private data member**.

It can be directly accessed only inside the `Parent` class.

---

# 2. Child Class Cannot Directly Access It ❌

Suppose:

```java
class Parent {

    private int money = 10000;
}

class Child extends Parent {

    void display() {

        System.out.println(money);
    }
}
```

This produces a:

```text
❌ Compile-time error
```

Why?

Because `money` is `private`.

```text
Parent
 └── private money 🔐
          ↓
       Child
          ↓
       ❌ Direct access
```

---

# 3. Does Private Member Participate in Inheritance?

For beginner-level understanding, remember:

> **Private members are not directly accessible in the child class and are therefore treated as not participating in inheritance.**

The child cannot do:

```java
System.out.println(money);
```

directly.

However, the parent object/class still has its private state internally. The child can interact with that state **through accessible methods provided by the parent**.

---

# 4. Encapsulation Is Preserved 🔐

Why does Java restrict this?

Because the parent class wants to protect its data.

For example:

```java
class Bank {

    private double amount;

    public void setAmount(double amount) {

        if (amount >= 0) {
            this.amount = amount;
        }
    }

    public double getAmount() {
        return amount;
    }
}
```

Now suppose:

```java
class ChildBank extends Bank {
}
```

`ChildBank` cannot directly do:

```java
amount = -5000;
```

❌ Not allowed.

But it can use the public methods:

```java
setAmount(10000);
```

and:

```java
getAmount();
```

So encapsulation remains protected.

---

# 5. Simple Example

```java
class Parent {

    private int money = 10000;

    public int getMoney() {
        return money;
    }
}

class Child extends Parent {

    void display() {

        // System.out.println(money);  // ❌ Error

        System.out.println(getMoney()); // ✅ Allowed
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
10000
```

The child doesn't directly access:

```java
money
```

Instead, it uses:

```java
getMoney()
```

which is a public method inherited from the parent.

---

# 6. Think of It Like a Locked Box 📦

Imagine the parent has:

```text
Parent
┌─────────────────────┐
│ 🔐 private money    │
│                     │
│ public getMoney()   │
└─────────────────────┘
```

The child cannot open the locked box directly.

```text
Child
  ↓
private money
  ↓
❌ Direct access
```

But the parent provides a safe window:

```text
Child
  ↓
getMoney()
  ↓
Parent's private money
  ↓
Value returned
```

That's **controlled access**.

---

# 7. What About Constructors?

Another important point from your notes:

> **Constructors are not inherited.**

Suppose:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    Child() {
        System.out.println("Child constructor");
    }
}
```

The `Child` class does **not inherit** the `Parent()` constructor.

But when we create:

```java
Child c = new Child();
```

the child constructor implicitly calls:

```java
super();
```

So the parent constructor executes.

```text
Child object creation
        ↓
Child()
        ↓
super()
        ↓
Parent()
```

### Output

```text
Parent constructor
Child constructor
```

---

# 8. Constructor ≠ Inherited Member

This is very important.

```text
Parent
 ├── variable     → may be inherited/accessed depending on access
 ├── method       → may be inherited/accessed depending on access
 └── constructor   → ❌ not inherited
```

The child gets its own constructor.

The parent constructor is called during construction using `super()`.

---

# 9. Private Member vs Constructor

| Feature                         | Private Member                      | Constructor                                        |
| ------------------------------- | ----------------------------------- | -------------------------------------------------- |
| Directly accessible from child? | ❌ No                                | ❌ Not inherited                                    |
| Inherited?                      | ❌ Not directly accessible/inherited | ❌ No                                               |
| Purpose                         | Encapsulation/security              | Object initialization                              |
| Can child use it indirectly?    | ✅ Through accessible parent methods | ✅ Parent constructor can execute through `super()` |

---

# 🧠 10. Easy Family Example

Imagine:

```text
                 Parent
                   │
        ┌──────────┴──────────┐
        │                     │
   private money           Parent()
        │                     │
        │                     │
   🔐 Protected          Constructor
        │
        ↓
      Child
```

The child cannot directly take the parent's private money.

But the parent can provide:

```text
getMoney()
```

to allow controlled access.

And when the child is created:

```text
Child()
  ↓
super()
  ↓
Parent()
```

---

# ⭐ Remember Forever

### Private members:

> **Private members of a parent class cannot be directly accessed by the child class. This restriction helps preserve encapsulation and security.**

### Constructors:

> **Constructors are not inherited. When a child object is created, the parent constructor can be invoked using `super()`.**

### 🧠 Memory Trick

```text
PRIVATE
   ↓
Not directly accessible by child 🔐
   ↓
Use public/protected methods for controlled access


CONSTRUCTOR
   ↓
Not inherited ❌
   ↓
Called through super() during child construction
```

### 🔥 Interview Answer

> **Private members of a parent class are not directly accessible in a child class, which preserves encapsulation and security. Constructors are also not inherited; however, the parent constructor is invoked during child-object creation through `super()`.**
