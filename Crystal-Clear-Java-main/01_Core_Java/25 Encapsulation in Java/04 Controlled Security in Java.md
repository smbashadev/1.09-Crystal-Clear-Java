# 🧒 Controlled Security in Java

Now we have reached the **correct and practical form of Encapsulation**.

We saw:

```text
Scenario 1 → No Security
Scenario 2 → Too Much Direct Restriction
Scenario 3 → Controlled Security ✅
```

The goal of encapsulation is:

> 🔐 **Protect the data, but provide a safe and controlled way to use it.**

---

# 1. The Basic Idea

Imagine a bank account with a **PIN**.

We don't want anyone to directly see or change the PIN.

So we keep it:

```java
private int pin;
```

Then we provide methods to control access:

```java
public void setPin(...)
public int getPin()
```

But before changing the PIN, we can perform validation.

So the flow becomes:

```text
Outside World
      ↓
   Setter
      ↓
PIN Validation
      ↓
Private PIN
```

And for reading:

```text
Private PIN
      ↓
   Getter
      ↓
Outside World
```

---

# 2. Private Data Member 🔐

Let's create a `BankAccount` class.

```java
class BankAccount {

    private int pin;
}
```

The keyword:

```java
private
```

protects the variable from **direct access outside the class**.

So this is not allowed:

```java
BankAccount b = new BankAccount();

System.out.println(b.pin);
```

❌ Compile-time error.

Why?

Because `pin` is private.

---

# 3. Public Setter

If outside code needs to **set/change** the PIN, we provide a setter.

```java
public void setPin(int pin) {
    this.pin = pin;
}
```

The setter gives controlled access to the private variable.

Think:

```text
Outside
   ↓
setPin()
   ↓
private pin
```

---

# 4. Public Getter

If outside code needs to **read** the PIN, we can provide a getter.

```java
public int getPin() {
    return pin;
}
```

The getter allows controlled reading.

Think:

```text
private pin
    ↓
getPin()
    ↓
Outside
```

---

# 5. Add PIN Validation 🔐

Now let's make the example more useful.

Suppose our PIN must contain **exactly 4 digits**.

We don't want to accept:

```text
12
123
12345
```

We can validate the value inside the setter.

```java
class BankAccount {

    private int pin;

    public void setPin(int pin) {

        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            System.out.println("PIN accepted");
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public int getPin() {
        return pin;
    }
}
```

Now the setter is acting like a **security guard**. 🛡️

---

# 6. Complete Program

```java
class BankAccount {

    private int pin;

    public void setPin(int pin) {

        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            System.out.println("PIN accepted");
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public int getPin() {

        return pin;
    }
}

class Demo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setPin(1234);

        System.out.println("PIN: " + account.getPin());
    }
}
```

### Output

```text
PIN accepted
PIN: 1234
```

---

# 7. What Happens Step-by-Step?

First:

```java
BankAccount account = new BankAccount();
```

An object is created.

Then:

```java
account.setPin(1234);
```

The setter receives:

```text
1234
```

The validation checks:

```java
if (pin >= 1000 && pin <= 9999)
```

`1234` is valid.

Therefore:

```java
this.pin = pin;
```

stores the value inside the private variable.

---

# 8. What If Someone Gives an Invalid PIN?

Suppose:

```java
account.setPin(123);
```

The setter receives:

```text
123
```

The condition:

```java
pin >= 1000 && pin <= 9999
```

is false.

Therefore:

```text
Invalid PIN
```

is printed.

The invalid value is not stored.

This is **controlled access**.

---

# 9. Why Not Make `pin` Public?

Imagine:

```java
public int pin;
```

Then someone could do:

```java
account.pin = 12;
```

There is no validation.

The value could become invalid.

With encapsulation:

```java
private int pin;
```

outside code cannot directly modify it.

It has to go through:

```java
setPin()
```

where we can check the value.

---

# 10. Setter as a Security Guard 🛡️

Imagine a building:

```text
                 BUILDING
                    │
              Private Data
                    │
                    │
              🛡️ Security Guard
                    │
                 Setter
                    │
              Outside World
```

The outside world says:

> "I want to change the PIN."

The setter says:

> "Let me check whether it is valid first."

If valid:

```text
✅ Allow
```

If invalid:

```text
❌ Reject
```

---

# 11. Getter as a Controlled Window 🪟

The getter allows controlled reading:

```java
public int getPin() {
    return pin;
}
```

So:

```text
Private PIN
    ↓
 Getter
    ↓
Outside world
```

The outside world doesn't directly touch the variable.

---

# 12. Complete Encapsulation Structure

The common pattern looks like this:

```java
class BankAccount {

    // Private data
    private int pin;

    // Setter
    public void setPin(int pin) {

        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
        }
    }

    // Getter
    public int getPin() {
        return pin;
    }
}
```

Remember:

```text
private data
     ↓
public methods
     ↓
controlled access
```

---

# 13. Real-Life Example 📱

Think about your phone's PIN.

You don't normally change the internal PIN storage directly.

Instead, you perform an operation such as:

```text
Enter new PIN
      ↓
System validates it
      ↓
If valid → Save
If invalid → Reject
```

This is similar to:

```text
setPin()
   ↓
validation
   ↓
private pin
```

---

# 14. Scenario Comparison

Now all three scenarios become easy.

### 🔓 Scenario 1 — No Security

```java
public int pin;
```

Anyone can directly change it.

```text
Anyone
  ↓
pin
```

❌ Too open.

---

### 🔒 Scenario 2 — Private Only

```java
private int pin;
```

Outside code cannot directly access it.

```text
Outside
   ↓
❌ pin
```

The data is protected, but outside code needs a proper interface to use it.

---

### 🔐 Scenario 3 — Controlled Security

```java
private int pin;

public void setPin(int pin) {
    // validation
}

public int getPin() {
    return pin;
}
```

Now:

```text
                 Encapsulation
                      │
             ┌────────┴────────┐
             ↓                 ↓
       Private Data       Public Methods
             │                 │
             │          ┌──────┴──────┐
             │          ↓             ↓
             │       Setter         Getter
             │          ↓
             │      Validation
             │
             └──── Controlled Access
```

✅ This is the useful form of encapsulation.

---

# ⭐ Golden Rule

> **Encapsulation protects data by keeping data members private and providing controlled access through public methods such as getters and setters. Validation can be added inside these methods to prevent invalid data.**

### 🧠 Remember Forever

```text
PRIVATE DATA
     ↓
Nobody directly touches it
     ↓
PUBLIC SETTER
     ↓
VALIDATION
     ↓
Store valid data

PRIVATE DATA
     ↓
PUBLIC GETTER
     ↓
Read data
```

### 🔥 One-line interview answer

> **Encapsulation is achieved by keeping data members private and providing controlled access through public getter and setter methods, where validation can be applied.**
