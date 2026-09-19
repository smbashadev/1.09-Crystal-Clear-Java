# 🧒 Runtime Polymorphism in Java

**Runtime Polymorphism** means:

> 🧠 **The method that should execute is decided at runtime, based on the actual object.**

The most important pattern is:

```text
Parent reference
      ↓
Child object
      ↓
Overridden method
      ↓
Decision at runtime
```

---

# 1. Parent Reference

Suppose we have a parent class:

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}
```

Now we have a child class:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Here `Dog` is a child of `Animal`.

```text
Animal
   ↓
Dog
```

---

# 2. Parent Reference + Child Object ⭐

Now comes the important part:

```java
Animal a = new Dog();
```

Look carefully.

### Left side:

```text
Animal a
```

This is the **parent reference**.

### Right side:

```text
new Dog()
```

This is the **child object**.

So:

```text
Parent reference
      ↓
Animal a
      ↓
Child object
      ↓
new Dog()
```

This is the key setup for runtime polymorphism.

---

# 3. Calling the Overridden Method

Now write:

```java
a.sound();
```

Which `sound()` will execute?

Parent has:

```java
void sound() {
    System.out.println("Animal makes sound");
}
```

Child has:

```java
@Override
void sound() {
    System.out.println("Dog barks");
}
```

Because the actual object is:

```text
Dog
```

the **Dog's overridden method** executes.

### Output

```text
Dog barks
```

---

# 4. Complete Program

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

class Demo {

    public static void main(String[] args) {

        Animal a = new Dog();

        a.sound();
    }
}
```

### Output

```text
Dog barks
```

---

# 5. Why Doesn't the Parent Method Execute?

This is the most important point.

We have:

```java
Animal a = new Dog();
```

The **reference type** is:

```text
Animal
```

But the **actual object type** is:

```text
Dog
```

When an overridden instance method is called, Java determines the implementation at **runtime** based on the actual object.

```text
Reference type → Animal
Object type    → Dog
                     ↓
              Dog's sound()
```

Therefore:

```text
a.sound()
   ↓
Dog.sound()
```

---

# 6. Think of a Remote Control 📺

Imagine `Animal` is a remote-control design.

The remote has a button:

```text
sound()
```

But the actual device connected to the remote is a `Dog`.

When you press:

```text
sound()
```

the actual device decides what happens.

```text
Animal reference
      ↓
   sound()
      ↓
Actual object = Dog
      ↓
Dog's sound()
```

So the **actual object controls the behavior**.

---

# 7. Different Child Objects

This becomes even easier to understand when we have multiple children.

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
Animal a1 = new Dog();
Animal a2 = new Cat();

a1.sound();
a2.sound();
```

### Output

```text
Dog barks
Cat meows
```

Notice something interesting:

Both references are of type:

```text
Animal
```

But they point to different objects:

```text
a1 → Dog
a2 → Cat
```

Therefore:

```text
a1.sound() → Dog's sound()
a2.sound() → Cat's sound()
```

---

# 8. Runtime Decision

This is why it is called **Runtime Polymorphism**.

The decision about which overridden method implementation executes is made when the program is **running**.

```text
                 Animal
                    │
             sound() method
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
        Dog                  Cat
          ↓                   ↓
       bark()               meow()
```

At runtime:

```text
Animal a = new Dog();
a.sound();
       ↓
Dog's sound()

Animal a = new Cat();
a.sound();
       ↓
Cat's sound()
```

---

# 9. Very Important Formula 🧠

Remember this pattern:

```java
Parent ref = new Child();
ref.overriddenMethod();
```

For example:

```java
Animal a = new Dog();
a.sound();
```

### Formula:

```text
Parent Reference
      +
Child Object
      +
Overridden Method
      ↓
Runtime Polymorphism
```

---

# 10. What If We Use a Parent Object?

Compare:

```java
Animal a = new Animal();
a.sound();
```

Here the actual object is `Animal`.

So:

```text
Animal reference
      ↓
Animal object
      ↓
Animal sound()
```

Output:

```text
Animal makes sound
```

But:

```java
Animal a = new Dog();
a.sound();
```

gives:

```text
Dog barks
```

The difference is the **actual object**.

---

# 🧠 Remember Forever

### Runtime Polymorphism:

```text
Parent reference
       ↓
Child object
       ↓
Overridden method
       ↓
Runtime decides
       ↓
Child method executes
```

### One-line memory trick:

> **"Parent reference, child object — child overridden method at runtime."**

### 🔥 Interview Answer

> **Runtime polymorphism is a form of polymorphism in which a parent class reference refers to a child class object, and the overridden method that executes is determined at runtime based on the actual object.**
