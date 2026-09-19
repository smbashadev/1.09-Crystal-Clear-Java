# 🧒 Interface Methods

In a Java interface, method declarations have special rules.

The key idea is:

> 🧠 **Interface methods are automatically `public abstract` (for ordinary abstract method declarations).**

---

## 1. Interface Method Is Automatically `public abstract`

Suppose we write:

```java
interface Animal {

    void eat();
}
```

Although we wrote only:

```java
void eat();
```

Java treats it as:

```java
public abstract void eat();
```

So these are equivalent:

```java
interface Animal {

    void eat();
}
```

and:

```java
interface Animal {

    public abstract void eat();
}
```

### Remember

```text
Interface method
      ↓
public + abstract
```

---

# 2. Abstract Method Declaration

An interface method normally contains only the declaration:

```java
void eat();
```

There is **no method body**.

```text
void eat();
       ↑
      ;
      ↓
No { } body
```

The interface specifies **what must be done**, not the implementation.

---

# 3. Implementing Class Must Use `public`

Suppose:

```java
interface Animal {

    void eat();
}
```

Because `eat()` is automatically:

```java
public abstract void eat();
```

the implementing class must provide it with **public visibility**.

### Correct ✅

```java
class Dog implements Animal {

    public void eat() {

        System.out.println("Dog eats");
    }
}
```

---

## 4. Why `public` Is Mandatory

This is incorrect:

```java
class Dog implements Animal {

    void eat() {      // ❌
        System.out.println("Dog eats");
    }
}
```

Why?

The interface method is:

```java
public abstract void eat();
```

But the implementation is:

```java
void eat()
```

which has weaker/default visibility.

Java does not allow an implementing class to **reduce the visibility** of an interface method.

```text
Interface
   ↓
public eat()
   ↓
Implementing class
   ↓
must remain public
```

---

# 5. Complete Program

```java
interface Animal {

    void eat();
}

class Dog implements Animal {

    @Override
    public void eat() {

        System.out.println("Dog eats");
    }
}

class Demo {

    public static void main(String[] args) {

        Animal a = new Dog();

        a.eat();
    }
}
```

### Output

```text
Dog eats
```

Notice:

```java
public void eat()
```

The `public` keyword is required.

---

# 6. Easy Comparison

| Interface                       | Implementing Class          |
| ------------------------------- | --------------------------- |
| `void eat();`                   | `public void eat() { }`     |
| Automatically `public abstract` | Must provide implementation |
| No body                         | Has body                    |
| Defines the requirement         | Provides implementation     |

---

# 🧠 Golden Rule

```text
Interface:

void eat();
      ↓
public abstract void eat();


Implementing class:

public void eat() {
    // implementation
}
```

### 🔥 Interview Answer

> **Methods declared in an interface are implicitly `public abstract` for ordinary abstract method declarations. When a class implements such a method, it must provide the implementation with `public` visibility; it cannot reduce the method's visibility.**
