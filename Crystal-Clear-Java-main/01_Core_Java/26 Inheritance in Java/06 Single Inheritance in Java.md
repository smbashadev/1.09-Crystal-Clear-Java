# 🧒 Single Inheritance in Java

**Single Inheritance** is the simplest type of inheritance.

> 🧠 **One parent class → One child class**

In your example:

```text
Gadget
   ↓
SmartWatch
```

`Gadget` is the **parent**, and `SmartWatch` is the **child**.

---

## 1. What Is Single Inheritance?

Suppose we have a general class:

```java
class Gadget {

    void powerOn() {
        System.out.println("Gadget is switched on");
    }
}
```

Now we create:

```java
class SmartWatch extends Gadget {

    void showTime() {
        System.out.println("SmartWatch shows time");
    }
}
```

Here:

```text
Gadget
  ↓
SmartWatch
```

This is **Single Inheritance** because there is:

* **One parent** → `Gadget`
* **One child** → `SmartWatch`

---

# 2. Complete Program

```java
class Gadget {

    void powerOn() {
        System.out.println("Gadget is switched on");
    }
}

class SmartWatch extends Gadget {

    void showTime() {
        System.out.println("SmartWatch shows time");
    }
}

class Demo {

    public static void main(String[] args) {

        SmartWatch watch = new SmartWatch();

        watch.powerOn();
        watch.showTime();
    }
}
```

### Output

```text
Gadget is switched on
SmartWatch shows time
```

---

# 3. Where Did `powerOn()` Come From?

Look at:

```java
watch.powerOn();
```

`powerOn()` is **not declared inside `SmartWatch`**.

It is declared inside:

```java
class Gadget
```

Because:

```java
class SmartWatch extends Gadget
```

`SmartWatch` inherits the accessible `powerOn()` method.

So:

```text
Gadget
 └── powerOn()
        ↓
     inherited
        ↓
SmartWatch
```

---

# 4. What Belongs to SmartWatch?

`SmartWatch` has its own method:

```java
void showTime() {
    System.out.println("SmartWatch shows time");
}
```

Therefore, the `SmartWatch` object can use:

```text
SmartWatch
 ├── powerOn()   ← inherited from Gadget
 └── showTime()  ← SmartWatch's own method
```

---

# 5. Why Is It Called "Single"?

Because there is only **one inheritance path**:

```text
       Gadget
       Parent
          ↓
    SmartWatch
       Child
```

There isn't another parent involved.

So:

```text
1 Parent
   ↓
1 Child
```

= **Single Inheritance**

---

# 🧠 Real-Life Example

Think about an electronic gadget.

```text
Gadget
 ├── powerOn()
 └── powerOff()
```

A smartwatch is a type of gadget:

```text
SmartWatch
 ├── powerOn()   ← inherited
 ├── powerOff()  ← inherited
 └── showTime()  ← its own behavior
```

So:

> **SmartWatch IS-A Gadget.**

---

# ⭐ Remember Forever

```text
          Gadget
       (Parent Class)
             │
          extends
             ↓
        SmartWatch
       (Child Class)
```

### Formula:

```text
One Parent
    +
One Child
    ↓
Single Inheritance
```

### 🔥 Interview Answer

> **Single inheritance is a type of inheritance in which one child class inherits from one parent class. For example, `SmartWatch extends Gadget`, so `SmartWatch` can reuse the accessible properties and methods of `Gadget`.**
