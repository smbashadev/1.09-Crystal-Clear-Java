# 🧒 Impure Abstract Class

An **Impure Abstract Class** is an abstract class that contains **both abstract and concrete methods**.

### Definition

> **An impure abstract class is an abstract class containing at least one abstract method and one or more concrete (non-abstract) methods.**

---

## 1️⃣ Example

```java
abstract class Animal {

    // Abstract method
    abstract void eat();

    // Concrete method
    void sleep() {
        System.out.println("Animal sleeps");
    }
}
```

Here:

```text
Animal
  ↓
Abstract class
  ├── eat()    → Abstract method ❌ body
  └── sleep()  → Concrete method ✅ body
```

Therefore, `Animal` is an **impure abstract class**.

---

## 2️⃣ Child Class

The child class must provide the implementation for the abstract method:

```java
class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats");
    }
}
```

The concrete `sleep()` method is already available to `Dog`.

```java
class Demo {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.sleep();
    }
}
```

### Output

```text
Dog eats
Animal sleeps
```

---

# ⭐ Pure vs Impure Abstract Class

| Pure Abstract Class             | Impure Abstract Class                      |
| ------------------------------- | ------------------------------------------ |
| Contains only abstract methods  | Contains abstract + concrete methods       |
| No concrete implementation      | Provides some implementation               |
| Example: `abstract void eat();` | `abstract void eat();` + `void sleep() {}` |

### 🧠 Easy Memory Trick

```text
Abstract Class
      ↓
 ┌────┴─────┐
 ↓          ↓
Only       Abstract +
abstract   concrete
methods    methods
 ↓          ↓
Pure       Impure
```

> **Pure = only abstract methods.**
> **Impure = abstract + concrete methods.**
