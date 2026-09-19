# 🧒 Encapsulation Programs in Java

Let's practice encapsulation with **two real-world examples**:

1. 🏦 **Bank Account** → protect `amount` and `PIN`
2. 👨‍💼 **Employee** → protect `name` and `salary`

The main pattern is:

```text
private data
     ↓
public setter
     ↓
validation / controlled modification
     ↓
public getter
     ↓
read the data
```

---

# 🏦 Program 1 — Bank Amount and PIN

Suppose a bank account contains:

```text
Amount = ₹10,000
PIN = 1234
```

We don't want anyone to directly modify these values.

So we make them `private`.

```java
class Bank {

    private double amount;
    private int pin;

    public void setAmt(double amount) {

        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public double getAmt() {
        return amount;
    }

    public void setPin(int pin) {

        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public int getPin() {
        return pin;
    }
}
```

---

## Using the Bank Class

```java
class Demo {

    public static void main(String[] args) {

        Bank account = new Bank();

        account.setAmt(10000);
        account.setPin(1234);

        System.out.println("Amount: " + account.getAmt());
        System.out.println("PIN: " + account.getPin());
    }
}
```

### Output

```text
Amount: 10000.0
PIN: 1234
```

---

# 🧠 How the Bank Program Works

When we write:

```java
account.setAmt(10000);
```

the value doesn't directly go into the variable from outside.

It goes through:

```text
10000
  ↓
setAmt()
  ↓
Validation
  ↓
private amount
```

Similarly:

```java
account.setPin(1234);
```

goes through:

```text
1234
  ↓
setPin()
  ↓
PIN validation
  ↓
private pin
```

To read the values:

```java
account.getAmt();
account.getPin();
```

---

# 🚫 Direct Access Is Not Allowed

This will produce a compile-time error:

```java
account.amount = 50000;
```

because:

```java
private double amount;
```

And this is also not allowed:

```java
account.pin = 1111;
```

because:

```java
private int pin;
```

The outside class must use the public methods.

---

# 👨‍💼 Program 2 — Employee Encapsulation

Now let's create an `Employee`.

An employee has:

```text
Name
Salary
```

We don't want these values to be directly changed from outside.

So:

```java
class Employee {

    private String name;
    private double salary;

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setSalary(double salary) {

        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary");
        }
    }

    public double getSalary() {

        return salary;
    }
}
```

---

# Using the Employee Class

```java
class Demo {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Basha");
        emp.setSalary(50000);

        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Salary: " + emp.getSalary());
    }
}
```

### Output

```text
Employee Name: Basha
Employee Salary: 50000.0
```

---

# 🧠 Employee Program Flow

### Setting the name

```java
emp.setName("Basha");
```

```text
"Basha"
   ↓
setName()
   ↓
private name
```

### Reading the name

```java
emp.getName();
```

```text
private name
     ↓
getName()
     ↓
"Basha"
```

---

### Setting salary

```java
emp.setSalary(50000);
```

```text
50000
  ↓
setSalary()
  ↓
Check salary
  ↓
private salary
```

### Reading salary

```java
emp.getSalary();
```

```text
private salary
     ↓
getSalary()
     ↓
50000
```

---

# 🚨 Salary Validation Example

Suppose someone tries:

```java
emp.setSalary(-5000);
```

Our setter checks:

```java
if (salary >= 0)
```

Since `-5000` is invalid:

```text
Invalid salary
```

The invalid salary isn't stored.

This is why setters can provide **controlled access**.

---

# 📊 Complete Encapsulation Pattern

| Data              | Access    | Setter        | Getter        |
| ----------------- | --------- | ------------- | ------------- |
| Bank `amount`     | `private` | `setAmt()`    | `getAmt()`    |
| Bank `pin`        | `private` | `setPin()`    | `getPin()`    |
| Employee `name`   | `private` | `setName()`   | `getName()`   |
| Employee `salary` | `private` | `setSalary()` | `getSalary()` |

---

# 🔐 The Big Picture

```text
                 ENCAPSULATION
                      │
                      ↓
               PRIVATE DATA
                      │
          ┌───────────┴───────────┐
          ↓                       ↓
       SETTER                   GETTER
          ↓                       ↓
   Change data                Read data
          ↓
      Validation
          ↓
   Controlled access
```

---

# ⭐ Golden Rule

Remember this pattern:

```java
private data;

public void setData(data) {
    // validation
    this.data = data;
}

public data getData() {
    return data;
}
```

For your examples:

```text
Bank
 ├── private amount
 │     ├── setAmt()
 │     └── getAmt()
 │
 └── private pin
       ├── setPin()
       └── getPin()


Employee
 ├── private name
 │     ├── setName()
 │     └── getName()
 │
 └── private salary
       ├── setSalary()
       └── getSalary()
```

### 🧠 One sentence to remember:

> **Private variables hide the data; setters control how data is changed; getters control how data is read.**

That combination gives us **encapsulation and controlled access**.
