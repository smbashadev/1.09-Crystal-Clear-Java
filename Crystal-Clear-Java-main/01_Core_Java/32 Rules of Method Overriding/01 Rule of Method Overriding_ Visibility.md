# 🧒 Rule of Method Overriding: Visibility

One important rule of **method overriding** is:

> 🧠 **A child class cannot reduce the visibility of the overridden parent method.**

In simple words:

```text
Parent method visibility
        ↓
Child method visibility
        ↓
Same or Greater ✅
Smaller ❌
```

---

## 1. Same Visibility ✅

Suppose the parent method is `public`:

```java
class Parent {

    public void display() {
        System.out.println("Parent");
    }
}
```

The child can override it as `public`:

```java
class Child extends Parent {

    public void display() {
        System.out.println("Child");
    }
}
```

This is allowed:

```text
Parent → public
Child  → public
          ↓
        Same ✅
```

---

# 2. Greater Visibility ✅

Suppose the parent method is `protected`:

```java
class Parent {

    protected void display() {
        System.out.println("Parent");
    }
}
```

The child can use `public`:

```java
class Child extends Parent {

    public void display() {
        System.out.println("Child");
    }
}
```

This is allowed:

```text
Parent → protected
Child  → public
          ↓
      Greater ✅
```

The visibility can be **increased**, but not decreased.

---

# 3. Reduced Visibility ❌

Suppose the parent method is `public`:

```java
class Parent {

    public void display() {
        System.out.println("Parent");
    }
}
```

Now the child tries:

```java
class Child extends Parent {

    protected void display() {
        System.out.println("Child");
    }
}
```

❌ **Compile-time error.**

Why?

```text
Parent → public
Child  → protected
          ↓
       Reduced ❌
```

The child is making the method **less accessible** than it was in the parent.

---

# 4. Another Example

Parent:

```java
class Parent {

    protected void fun() {
        System.out.println("Parent");
    }
}
```

Child:

```java
class Child extends Parent {

    private void fun() {
        System.out.println("Child");
    }
}
```

❌ Not allowed.

Because:

```text
protected
   ↓
private
   ↓
Visibility reduced ❌
```

---

# 5. Visibility Order 🧠

For these four access levels, think:

```text
public
   ↓
protected
   ↓
default
   ↓
private
```

Moving **up** means greater visibility.

Moving **down** means reduced visibility.

So:

```text
Parent             Child

protected    →     public       ✅
protected    →     protected    ✅
protected    →     default      ❌
protected    →     private      ❌
```

And:

```text
Parent             Child

public       →     public       ✅
public       →     protected    ❌
public       →     default      ❌
public       →     private      ❌
```

---

# ⭐ Complete Program

### Correct Example

```java
class Parent {

    protected void display() {
        System.out.println("Parent display()");
    }
}

class Child extends Parent {

    @Override
    public void display() {
        System.out.println("Child display()");
    }
}

class Demo {

    public static void main(String[] args) {

        Parent p = new Child();

        p.display();
    }
}
```

### Output

```text
Child display()
```

Here:

```text
Parent → protected
Child  → public
```

So visibility increased.

✅ **Valid overriding**

---

# 🔥 Golden Rule

> **While overriding, the child method must have the same or greater visibility than the parent method. It cannot reduce the visibility.**

Remember:

```text
Same visibility      → ✅
Greater visibility   → ✅
Reduced visibility   → ❌
```

### Interview Answer

> **In method overriding, the child class cannot reduce the visibility of the overridden method. The child method can have the same or greater visibility than the parent method.**
