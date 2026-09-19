# 🧒 Method Overriding in Java

**Method Overriding** is one of the main ways Java achieves **Runtime Polymorphism**.

The simple idea is:

> 🧠 **Parent has a method → Child provides its own version of that method.**

Then, when the method is called through a parent reference, Java decides **at runtime** which version should execute.

---

## 1. Parent Method

First, create a parent class:

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}
```

The parent has:

```text
Animal
  ↓
sound()
```

---

## 2. Child Overrides the Method

Now the child provides its own version:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Now:

```text
Animal
   ↓
sound() → Animal version

Dog
   ↓
sound() → Dog version
```

The child method **overrides** the parent method.

---

# 3. Runtime Polymorphism

Now use:

```java
Animal a = new Dog();
```

Look carefully:

```text
Animal a
   ↓
Parent reference

new Dog()
   ↓
Child object
```

Now call:

```java
a.sound();
```

Which method executes?

```text
a.sound()
    ↓
Actual object = Dog
    ↓
Dog.sound()
```

### Output

```text
Dog barks
```

This is **runtime polymorphism**.

---

# 4. Dynamic Method Dispatch

The process of deciding which overridden method should execute **at runtime** is called:

> **Dynamic Method Dispatch**

Think of it as:

```text
Method call
    ↓
Wait until runtime
    ↓
Check actual object
    ↓
Select overridden method
    ↓
Execute it
```

For:

```java
Animal a = new Dog();
a.sound();
```

the JVM effectively determines:

```text
Reference type → Animal
Actual object  → Dog
                     ↓
              Dog.sound()
```

---

# 5. Runtime Method Selection

Suppose we have three animals:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

Now:

```java
Animal a;

a = new Dog();
a.sound();

a = new Cat();
a.sound();
```

### Output

```text
Dog barks
Cat meows
```

The method call is the same:

```java
a.sound();
```

But the method selected at runtime is different.

```text
a = new Dog()
      ↓
a.sound()
      ↓
Dog.sound()

a = new Cat()
      ↓
a.sound()
      ↓
Cat.sound()
```

---

# 6. Complete Program

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

class Demo {

    public static void main(String[] args) {

        Animal a;

        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();
    }
}
```

### Output

```text
Dog barks
Cat meows
```

---

# 🧠 Three Terms — Don't Confuse Them

| Term                        | Simple Meaning                                          |
| --------------------------- | ------------------------------------------------------- |
| **Method Overriding**       | Child provides its own version of parent's method       |
| **Runtime Polymorphism**    | One parent reference works with different child objects |
| **Dynamic Method Dispatch** | Runtime process of selecting the overridden method      |

### Flow:

```text
Method Overriding
       ↓
Runtime Polymorphism
       ↓
Dynamic Method Dispatch
       ↓
Runtime Method Selection
```

---

# ⭐ Remember Forever

### Method Overriding

```text
Parent
  ↓
fun()

Child
  ↓
@Override
fun()
```

### Runtime execution

```text
Parent reference
       ↓
Child object
       ↓
overridden method call
       ↓
Runtime decides
       ↓
Child method executes
```

### 🔥 Interview Answer

> **Method overriding occurs when a child class provides its own implementation of a method inherited from the parent class. When a parent reference refers to a child object, Java uses dynamic method dispatch to select the appropriate overridden method at runtime. This is called runtime polymorphism.**
