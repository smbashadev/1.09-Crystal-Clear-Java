# 🧒 `protected` Access Specifier in Java

`protected` means:

> 🧠 **The member can be accessed by classes in the same package, and by child classes even when those child classes are in a different package.**

Think of it as:

```text
protected
   ↓
Same package → ✅
Child in different package → ✅
Unrelated class in different package → ❌
```

---

# 1. `protected` in the Same Package

Suppose we have:

```java
package pack1;

public class Parent {

    protected int x = 100;
}
```

Another class in the **same package**:

```java
package pack1;

class Demo {

    public static void main(String[] args) {

        Parent p = new Parent();

        System.out.println(p.x);
    }
}
```

Output:

```text
100
```

Why?

Both classes are in:

```text
pack1
```

Therefore:

```text
Same package
     ↓
protected member
     ↓
Accessible ✅
```

---

# 2. Child Class in a Different Package

This is the special feature of `protected`.

### Parent class

```java
package pack1;

public class Parent {

    protected int x = 100;

    protected void display() {

        System.out.println("Parent display()");
    }
}
```

Now create a child class in another package:

```java
package pack2;

import pack1.Parent;

public class Child extends Parent {

    public void show() {

        System.out.println(x);

        display();
    }
}
```

Notice:

```text
Parent → pack1
Child  → pack2
```

They are in **different packages**.

But `Child` is a subclass of `Parent`.

Therefore it can access the protected members through inheritance.

---

# 3. Complete Program

### `Parent.java`

```java
package pack1;

public class Parent {

    protected int x = 100;

    protected void display() {

        System.out.println("Parent display()");
    }
}
```

### `Child.java`

```java
package pack2;

import pack1.Parent;

public class Child extends Parent {

    public void show() {

        System.out.println("x = " + x);

        display();
    }
}
```

### `Demo.java`

```java
package pack2;

public class Demo {

    public static void main(String[] args) {

        Child c = new Child();

        c.show();
    }
}
```

### Output

```text
x = 100
Parent display()
```

---

# 4. What Happened?

The parent is in:

```text
pack1
```

The child is in:

```text
pack2
```

Normally, a different-package class cannot directly access a protected member just because it has an object of the parent class.

But `Child` **extends `Parent`**.

Therefore inside `Child`:

```java
id="f3k8w2"
x
```

and:

```java
id="j9v4s1"
display();
```

are accessible.

```text
Parent (pack1)
    │
    │ protected
    ↓
Child (pack2)
    │
    ├── x          ✅
    └── display()  ✅
```

---

# 5. Important Difference ⚠️

Consider this:

```java
Child extends Parent
```

Inside `Child`, this is allowed:

```java
System.out.println(x);
```

But from an unrelated class in another package:

```java
Parent p = new Parent();

System.out.println(p.x);  // ❌
```

That is not allowed.

So the **different-package access is specifically available to the subclass through inheritance**, subject to Java's protected access rules.

---

# 6. Easy Comparison

| Location                             | `protected` access |
| ------------------------------------ | ------------------ |
| Same class                           | ✅                  |
| Same package                         | ✅                  |
| Child class in different package     | ✅                  |
| Unrelated class in different package | ❌                  |

---

# 🧠 Real-Life Example

Think of `protected` like a **family facility**.

```text
Same family/community
        ↓
Can use it ✅

Child/family member
in another location
        ↓
Can use it through family relationship ✅

Complete stranger
        ↓
Cannot use it ❌
```

Similarly:

```text
protected
    ↓
Same package → access
    ↓
Child in another package → access
    ↓
Unrelated different-package class → no access
```

---

# ⭐ Remember Forever

### `protected` has two important rules:

```text
1️⃣ Same package
       ↓
     ACCESS ✅

2️⃣ Child class in different package
       ↓
     ACCESS ✅
```

But:

```text
Different package
+
Not a child
       ↓
ACCESS ❌
```

### 🔥 Interview Answer

> **`protected` members are accessible within the same package and are also accessible in subclasses located in different packages. This makes `protected` useful when a parent class wants to provide members to its child classes while restricting access from unrelated classes outside the package.**
