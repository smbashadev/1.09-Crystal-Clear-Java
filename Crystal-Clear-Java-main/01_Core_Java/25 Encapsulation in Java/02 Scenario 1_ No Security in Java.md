# 🧒 Scenario 1: No Security in Java

Let's understand **encapsulation** by first seeing what happens when we **do not protect our data**.

Imagine a hero has some money:

```text
Hero
 ↓
Amount = ₹10,000
```

If the amount can be accessed directly, anyone can change it.

That's the **no-security problem**.

---

## 1. Direct Access

Suppose we create this class:

```java
class Hero {

    public int amount = 10000;
}
```

Here:

```java
public int amount;
```

means the `amount` can be directly accessed from outside the class.

For example:

```java
Hero h = new Hero();

System.out.println(h.amount);
```

Output:

```text
10000
```

So far, everything looks fine.

But there is a problem.

---

# 2. Villain Can Directly Access the Amount 😈

Suppose we have another class:

```java
class Villain {

    public void attack() {

        Hero h = new Hero();

        h.amount = 0;
    }
}
```

The villain can directly change:

```java
h.amount
```

from:

```text
₹10,000
```

to:

```text
₹0
```

There is no protection.

---

# 3. Complete Program

```java
class Hero {

    public int amount = 10000;
}

class Villain {

    public void steal() {

        Hero h = new Hero();

        h.amount = 0;

        System.out.println("Amount after villain attack: " + h.amount);
    }
}

class Demo {

    public static void main(String[] args) {

        Villain v = new Villain();

        v.steal();
    }
}
```

### Output

```text
Amount after villain attack: 0
```

The villain was able to change the amount directly.

---

# 4. What Is the Problem? 🚨

The problem is:

```java
public int amount;
```

The data is openly accessible.

Think of it like a house with the door permanently open:

```text
🏠 Hero's Data

Door → OPEN 🚪

Anyone can enter
Anyone can change data
```

There is no proper control.

---

# 5. Direct Access

The villain can do:

```java
h.amount = 0;
```

There is no method involved.

It directly accesses the variable:

```text
Villain
   ↓
Hero object
   ↓
amount
   ↓
change value
```

This is called **direct access**.

---

# 6. What About Default Access?

Suppose we don't write `public`:

```java
class Hero {

    int amount = 10000;
}
```

This gives the variable **default/package-private access**.

It is not accessible from every class everywhere; it is accessible to classes in the **same package**.

So default access provides more restriction than `public`, but it is still not the usual encapsulation approach for protecting important object data.

For proper data protection, Java commonly uses:

```java
private
```

---

# 7. Public vs Default

| Access    | Directly accessible from outside the class? |
| --------- | ------------------------------------------- |
| `public`  | ✅ Yes                                       |
| default   | ⚠️ Only within the same package             |
| `private` | ❌ No                                        |

For our security example, `public` is the clearest example of unrestricted direct access.

---

# 8. Why Is This Bad?

Imagine this is a bank account:

```java
public double amount = 10000;
```

Someone could write:

```java
account.amount = -50000;
```

or:

```java
account.amount = 999999999;
```

The class has no control over what value is assigned.

That's why we need **encapsulation**.

---

# 🧠 Hero vs Villain

Think of it like this:

```text
                 HERO
                  │
             amount = ₹10,000
                  │
                  ↓
             🚪 NO SECURITY
                  │
                  ↓
               VILLAIN
                  │
                  ↓
          h.amount = 0
                  │
                  ↓
             ₹0 😭
```

The villain can directly modify the data because the data member is openly accessible.

---

# ⭐ The Main Lesson

### Without security:

```java
public int amount = 10000;
```

Anyone with access to the object can directly modify it:

```java
h.amount = 0;
```

### Problem:

```text
Direct access
     ↓
No proper control
     ↓
Data can be changed improperly
     ↓
Security problem
```

### This is why we need encapsulation.

In the **next scenario**, we can protect `amount` using `private` and allow the Hero to control access through methods.

> 🧠 **Remember:** `public` data = **"The door is open."** 🚪
> `private` data = **"The door is locked; use the proper method."** 🔐
