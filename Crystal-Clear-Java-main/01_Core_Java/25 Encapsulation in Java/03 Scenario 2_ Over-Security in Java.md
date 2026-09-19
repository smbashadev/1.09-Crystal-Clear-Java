# 🧒 Scenario 2: Over-Security in Java

Now let's take the previous **Hero and Villain** example one step further.

In Scenario 1, the problem was:

> 🔓 **Everyone could directly access the Hero's data.**

So we tried to fix it using `private`.

But now we can create another problem:

> 🔐 **The data is so protected that even the Hero's own code cannot directly access it from outside the class.**

---

# 1. Make the Data `private`

```java
class Hero {

    private int amount = 10000;
}
```

The keyword:

```java
private
```

means:

> **The variable can be directly accessed only inside the same class where it is declared.**

So:

```text
Hero class
   ↓
private amount
```

The `amount` is protected from outside access.

---

# 2. Villain Cannot Access It ❌

Suppose the Villain tries:

```java
class Villain {

    void attack() {

        Hero h = new Hero();

        h.amount = 0;
    }
}
```

Java gives a **compile-time error**.

Why?

Because:

```java
private int amount;
```

can only be directly accessed inside `Hero`.

The `Villain` class is outside `Hero`.

So:

```text
Villain
   ↓
h.amount
   ↓
❌ Not allowed
```

That's good for security.

---

# 3. But There Is Another Problem

Now suppose the Hero himself has another method that tries to access the private variable.

For example:

```java
class Hero {

    private int amount = 10000;
}

class Demo {

    public static void main(String[] args) {

        Hero h = new Hero();

        System.out.println(h.amount);
    }
}
```

This also gives a **compile-time error**.

Why?

Because `Demo` is trying to access:

```java
h.amount
```

but `amount` is `private`.

```text
Demo
 ↓
h.amount
 ↓
❌ Compile-time error
```

---

# 4. Important Correction: "Hero Also Blocked"

There is an important distinction here.

If by **Hero** you mean the **`Hero` class itself**, then the Hero **is NOT blocked**.

Inside the `Hero` class, this is perfectly valid:

```java
class Hero {

    private int amount = 10000;

    void display() {

        System.out.println(amount);
    }
}
```

The class that owns the private variable can access it.

So the correct rule is:

> **`private` blocks direct access from outside the class, not from inside the declaring class.**

---

# 5. Where Does the "Over Security" Problem Come From?

Suppose we have:

```java
class Hero {

    private int amount = 10000;
}
```

Now nobody outside `Hero` can do:

```java
h.amount
```

So:

```text
Villain → ❌
Demo    → ❌
Other class → ❌
```

But what if we want legitimate code to **read or modify** the amount?

There is currently no way to do it from outside.

That's the problem:

```text
Too much protection
       ↓
Nobody can directly access the data
       ↓
Even legitimate outside code cannot use it
```

---

# 6. The Solution: Controlled Access

We don't want:

```text
🔓 Everyone can access
```

And we don't want:

```text
🔒 Nobody can access
```

We want:

```text
🔐 Controlled access
```

That's the real purpose of **encapsulation**.

For example:

```java
class Hero {

    private int amount = 10000;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {

        if (amount >= 0) {
            this.amount = amount;
        }
    }
}
```

Now:

```text
Outside world
      ↓
 public methods
      ↓
 private data
```

The outside world cannot directly touch `amount`.

Instead, it must go through the methods.

---

# 7. Hero Controls the Data 🦸

Suppose:

```java
Hero h = new Hero();
```

To see the amount:

```java
System.out.println(h.getAmount());
```

To change the amount:

```java
h.setAmount(15000);
```

But:

```java
h.setAmount(-5000);
```

will be rejected by our condition.

So the Hero has **control** over his own data.

---

# 🧠 Scenario 1 vs Scenario 2

### Scenario 1 — No Security 🔓

```java
public int amount;
```

Anyone can directly access it.

```text
Villain → amount ❌? No, actually allowed
```

Problem:

> **Too little protection.**

---

### Scenario 2 — Too Much Direct Protection 🔐

```java
private int amount;
```

Outside classes cannot directly access it.

```text
Villain → ❌
Demo    → ❌
```

But the `Hero` class itself can access it.

Problem:

> **Outside code has no direct access.**

---

### Encapsulation — Controlled Security 🔐✅

```java
private int amount;

public int getAmount() {
    return amount;
}

public void setAmount(int amount) {
    // validation
}
```

Now:

```text
Outside
   ↓
getAmount() / setAmount()
   ↓
private amount
```

---

# ⭐ Golden Rule

> **`private` means direct access is restricted to the class that declares the member.**

And remember the three stages:

```text
Scenario 1
PUBLIC
  ↓
Too open 🔓
  ↓
Anyone can modify data


Scenario 2
PRIVATE
  ↓
Direct outside access blocked 🔐
  ↓
Need controlled access


Encapsulation
PRIVATE + METHODS
  ↓
Controlled access 🔐
  ↓
Safe and useful
```

### 🧠 One-line memory trick:

> **Don't keep the door completely open, and don't throw away the key—lock the data and provide a controlled door (`methods`).** 🔐
