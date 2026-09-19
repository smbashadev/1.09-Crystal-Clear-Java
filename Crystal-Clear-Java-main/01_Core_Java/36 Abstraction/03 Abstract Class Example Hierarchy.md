# 🧒 Abstract Class Example Hierarchy

Let's build an **abstract class hierarchy** using your example:

```text
                    Animal
               (abstract class)
                       │
          ┌────────────┼────────────┐
          ↓            ↓            ↓
    Herbivorous    Carnivorous   Omnivorous
      (abstract)      (abstract)    (abstract)
          │              │             │
       ┌──┴──┐        ┌──┴──┐       ┌──┴──┐
       ↓     ↓        ↓     ↓       ↓     ↓
      Cow   Goat     Tiger  Lion    Dog   Cat
```

The idea is:

* `Animal` → common parent
* `Herbivorous` → animals that eat plants
* `Carnivorous` → animals that eat meat
* `Omnivorous` → animals that eat both
* `Cow`, `Goat`, `Tiger`, `Lion`, `Dog`, `Cat` → concrete classes whose objects can be created

---

## 1. `Animal` — Top-Level Abstract Class

```java
abstract class Animal {

    abstract void eat();
}
```

We don't want to create:

```java
Animal a = new Animal();   // ❌
```

Instead, `Animal` provides a common abstraction.

---

## 2. `Herbivorous`

```java
abstract class Herbivorous extends Animal {

}
```

It inherits from `Animal`.

```text
Animal
   ↑
Herbivorous
```

Since `Herbivorous` is also abstract, we don't need to implement `eat()` yet.

---

## 3. `Carnivorous`

```java
abstract class Carnivorous extends Animal {

}
```

Hierarchy:

```text
Animal
   ↑
Carnivorous
```

---

## 4. `Omnivorous`

```java
abstract class Omnivorous extends Animal {

}
```

Hierarchy:

```text
Animal
   ↑
Omnivorous
```

---

# 5. Concrete Child Classes

Now we create actual animal classes.

### Cow

```java
class Cow extends Herbivorous {

    @Override
    void eat() {

        System.out.println("Cow eats plants");
    }
}
```

### Goat

```java
class Goat extends Herbivorous {

    @Override
    void eat() {

        System.out.println("Goat eats plants");
    }
}
```

### Tiger

```java
class Tiger extends Carnivorous {

    @Override
    void eat() {

        System.out.println("Tiger eats meat");
    }
}
```

### Lion

```java
class Lion extends Carnivorous {

    @Override
    void eat() {

        System.out.println("Lion eats meat");
    }
```

### Dog

```java
class Dog extends Omnivorous {

    @Override
    void eat() {

        System.out.println("Dog eats plants and meat");
    }
}
```

### Cat

```java
class Cat extends Omnivorous {

    @Override
    void eat() {

        System.out.println("Cat eats plants and meat");
    }
}
```

---

# 6. Complete Program

```java
abstract class Animal {

    abstract void eat();
}

abstract class Herbivorous extends Animal {

}

abstract class Carnivorous extends Animal {

}

abstract class Omnivorous extends Animal {

}

class Cow extends Herbivorous {

    @Override
    void eat() {
        System.out.println("Cow eats plants");
    }
}

class Goat extends Herbivorous {

    @Override
    void eat() {
        System.out.println("Goat eats plants");
    }
}

class Tiger extends Carnivorous {

    @Override
    void eat() {
        System.out.println("Tiger eats meat");
    }
}

class Lion extends Carnivorous {

    @Override
    void eat() {
        System.out.println("Lion eats meat");
    }
}

class Dog extends Omnivorous {

    @Override
    void eat() {
        System.out.println("Dog eats plants and meat");
    }
}

class Cat extends Omnivorous {

    @Override
    void eat() {
        System.out.println("Cat eats plants and meat");
    }
}

class Demo {

    public static void main(String[] args) {

        Animal a;

        a = new Cow();
        a.eat();

        a = new Goat();
        a.eat();

        a = new Tiger();
        a.eat();

        a = new Lion();
        a.eat();

        a = new Dog();
        a.eat();

        a = new Cat();
        a.eat();
    }
}
```

### Output

```text
Cow eats plants
Goat eats plants
Tiger eats meat
Lion eats meat
Dog eats plants and meat
Cat eats plants and meat
```

---

# 7. Where Is Polymorphism?

Look at:

```java
Animal a;
```

`Animal` is an **abstract parent reference**.

Then:

```java
a = new Cow();
a = new Goat();
a = new Tiger();
a = new Lion();
a = new Dog();
a = new Cat();
```

The same reference can point to different child objects.

```text
Animal a
   │
   ├──→ Cow
   ├──→ Goat
   ├──→ Tiger
   ├──→ Lion
   ├──→ Dog
   └──→ Cat
```

When we call:

```java
a.eat();
```

the appropriate child's overridden `eat()` executes.

That's **runtime polymorphism**.

---

# 🧠 Important Point About the Hierarchy

There are **three levels** here:

```text
                Animal
             abstract
                 │
       ┌─────────┼─────────┐
       ↓         ↓         ↓
 Herbivorous Carnivorous Omnivorous
  abstract     abstract    abstract
       │          │           │
    ┌──┴──┐     ┌─┴──┐      ┌─┴──┐
    Cow  Goat  Tiger Lion    Dog Cat
```

### Abstract classes

```text
Animal
Herbivorous
Carnivorous
Omnivorous
```

### Concrete classes

```text
Cow
Goat
Tiger
Lion
Dog
Cat
```

The concrete classes provide the implementation of:

```java
eat();
```

---

# ⭐ Interview Understanding

If the interviewer asks:

**"Why make `Animal` abstract?"**

You can say:

> `Animal` represents a general concept, and we don't want to create a generic Animal object directly. We use it as an abstraction and parent reference for specific animal classes.

If they ask:

**"Why are Herbivorous, Carnivorous and Omnivorous also abstract?"**

You can say:

> They represent intermediate/general categories in the hierarchy. Their concrete subclasses such as Cow, Goat, Tiger, Lion, Dog and Cat provide the actual implementation.

### 🔥 Final memory:

```text
Abstract class
      ↓
General concept
      ↓
Cannot create its direct object
      ↓
Can create parent reference
      ↓
Parent reference → Child object
      ↓
Runtime polymorphism
```
