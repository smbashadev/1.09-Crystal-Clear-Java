# 🧒 Encapsulation Using Constructor

We already learned:

```text
private data
      ↓
setter method
      ↓
validation
      ↓
getter method
```

Now we can do something similar using a **constructor**.

The main idea is:

> 🔐 **A constructor can initialize private fields when the object is created, while applying validation before storing the values.**

---

# 1. Private Fields

Suppose a bank account has:

```text
PIN
Amount
```

We don't want outside classes to directly access them.

So we make them `private`.

```java
class BankAccount {

    private int pin;
    private double amount;
}
```

Now:

```text
Outside class
     ↓
❌ Direct access
     ↓
private pin
private amount
```

---

# 2. Constructor

We can provide the values when creating the object:

```java
BankAccount account = new BankAccount(1234, 10000);
```

The constructor receives:

```text
1234  → PIN
10000 → Amount
```

and initializes the private fields.

---

# 3. PIN Validation Inside Constructor

We can validate the PIN before storing it.

```java
class BankAccount {

    private int pin;
    private double amount;

    BankAccount(int pin, double amount) {

        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
        } else {
            System.out.println("Invalid PIN");
        }

        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public int getPin() {
        return pin;
    }

    public double getAmount() {
        return amount;
    }
}
```

---

# 4. Complete Program

```java
class BankAccount {

    private int pin;
    private double amount;

    BankAccount(int pin, double amount) {

        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
        } else {
            System.out.println("Invalid PIN");
        }

        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public int getPin() {
        return pin;
    }

    public double getAmount() {
        return amount;
    }
}

class Demo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1234, 10000);

        System.out.println("PIN: " + account.getPin());
        System.out.println("Amount: " + account.getAmount());
    }
}
```

### Output

```text
PIN: 1234
Amount: 10000.0
```

---

# 5. Understand the Flow 🧠

When we write:

```java
BankAccount account = new BankAccount(1234, 10000);
```

Java creates the object and calls the constructor.

```text
new BankAccount(1234, 10000)
             ↓
        Constructor
             ↓
      PIN validation
             ↓
      Amount validation
             ↓
       Store values
```

So:

```text
1234
 ↓
constructor
 ↓
valid PIN?
 ↓ YES
private pin
```

And:

```text
10000
 ↓
constructor
 ↓
valid amount?
 ↓ YES
private amount
```

---

# 6. Why Do We Need Getter Methods?

The fields are private:

```java
private int pin;
private double amount;
```

Therefore, outside code cannot do:

```java
System.out.println(account.pin);
```

❌ Compile-time error.

Instead, we provide getter methods:

```java
public int getPin() {
    return pin;
}
```

and:

```java
public double getAmount() {
    return amount;
}
```

So the flow is:

```text
private field
     ↓
getter
     ↓
outside code
```

---

# 7. Constructor Acting Like a Setter

This is the important point from your notes.

Normally, a setter looks like:

```java
public void setPin(int pin) {

    if (pin >= 1000 && pin <= 9999) {
        this.pin = pin;
    }
}
```

We call it **after creating the object**:

```java
account.setPin(1234);
```

A constructor can perform a similar initialization:

```java
BankAccount(int pin) {

    if (pin >= 1000 && pin <= 9999) {
        this.pin = pin;
    }
}
```

And we provide the value **when creating the object**:

```java
BankAccount account = new BankAccount(1234);
```

---

# 8. Setter vs Constructor

| Setter                       | Constructor                                    |
| ---------------------------- | ---------------------------------------------- |
| Used to set/change data      | Used to initialize data during object creation |
| Called explicitly            | Called automatically during object creation    |
| Object must already exist    | Called as part of object creation              |
| Can validate data            | Can also validate data                         |
| Can be called multiple times | Runs once for each object creation             |

Think:

```text
SETTER
Object already exists
       ↓
setPin(1234)
```

But:

```text
CONSTRUCTOR
       ↓
new BankAccount(1234)
       ↓
Object created + data initialized
```

---

# 9. Invalid PIN Example

Suppose:

```java
BankAccount account = new BankAccount(123, 10000);
```

The constructor receives:

```text
PIN = 123
```

It checks:

```java
if (pin >= 1000 && pin <= 9999)
```

`123` is invalid.

Therefore:

```text
Invalid PIN
```

is printed.

The constructor acts as a **gatekeeper**:

```text
             PIN
              ↓
        ┌─────────────┐
        │ Constructor │
        │ Validation  │
        └──────┬──────┘
               ↓
        ┌──────┴──────┐
        ↓             ↓
      Valid         Invalid
        ↓             ↓
     Store          Reject
```

---

# 🔐 10. Why Is This Encapsulation?

We have all the important pieces:

```text
                ENCAPSULATION
                     │
       ┌─────────────┴─────────────┐
       ↓                           ↓
 Private fields              Public methods
       │                           │
       │                     ┌─────┴─────┐
       │                     ↓           ↓
       │                  Getter    Constructor
       │                                 ↓
       │                            Validation
       │
       └────────── Controlled Access ────┘
```

The outside world cannot directly touch the private fields.

It must use the mechanisms provided by the class.

---

# ⭐ Important Interview Point

Don't say:

> ❌ "A constructor is a setter."

That's not technically correct.

Say:

> ✅ **"A constructor can perform the initial setting of private fields, similar to a setter, but its primary purpose is to initialize an object during object creation."**

### 🧠 Remember Forever

```text
Setter:
Object → then set value

Constructor:
Create Object → initialize value
```

And for encapsulation:

> **Private fields + controlled initialization through constructor + getter methods = encapsulated object with controlled access.**
