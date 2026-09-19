## 🧒 Method Overloading Program

Let's create several `acceptInfo()` methods.

The **method name stays the same**, but the **parameter list changes**.

```text
acceptInfo()
acceptInfo(String)
acceptInfo(String, int)
acceptInfo(String, int, String)
```

That's **method overloading**.

---

## 💻 Program

```java id="k7m3px"
class Student {

    // No parameters
    static void acceptInfo() {
        System.out.println("No information provided");
    }

    // One parameter
    static void acceptInfo(String name) {
        System.out.println("Name = " + name);
    }

    // Two parameters
    static void acceptInfo(String name, int age) {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
    }

    // Three parameters
    static void acceptInfo(String name, int age, String city) {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
        System.out.println("City = " + city);
    }

    public static void main(String[] args) {

        acceptInfo();

        acceptInfo("Basha");

        acceptInfo("Basha", 26);

        acceptInfo("Basha", 26, "Hyderabad");
    }
}
```

---

## 🔍 What is happening?

### Call 1

```java id="z6p4qm"
acceptInfo();
```

There are **0 arguments**.

Java selects:

```java id="x2k8rv"
acceptInfo()
```

---

### Call 2

```java id="m9q3ws"
acceptInfo("Basha");
```

There is **1 argument**.

Java selects:

```java id="r5v7kp"
acceptInfo(String)
```

---

### Call 3

```java id="c8n2xm"
acceptInfo("Basha", 26);
```

There are **2 arguments**.

Java selects:

```java id="q4m6zs"
acceptInfo(String, int)
```

---

### Call 4

```java id="w7p3ka"
acceptInfo("Basha", 26, "Hyderabad");
```

There are **3 arguments**.

Java selects:

```java id="h5x9mv"
acceptInfo(String, int, String)
```

---

## 🔄 The Big Picture

```text
                    acceptInfo()
                         │
             ┌───────────┼────────────┐
             ↓           ↓            ↓
          0 args       1 arg       2 args       3 args
             ↓           ↓            ↓             ↓
      acceptInfo()  acceptInfo(String)  acceptInfo(String,int)  acceptInfo(String,int,String)
```

Java looks at the **method call and its arguments** and determines which overloaded method is the best match.

---

## 🧠 Why is this Useful?

Without overloading:

```text
acceptInfoBasic()
acceptInfoName()
acceptInfoNameAge()
acceptInfoFullDetails()
```

With overloading:

```text
acceptInfo()
acceptInfo(String)
acceptInfo(String, int)
acceptInfo(String, int, String)
```

One common name represents the same general operation:

> **Accept information.**

Only the required input changes.

### 🔑 Memory Trick

```text
SAME NAME
    +
DIFFERENT PARAMETERS
    +
DIFFERENT CALLS
    ↓
METHOD OVERLOADING
```

**Important:** It is the **parameter list**, not merely the argument variable names or return type, that distinguishes overloaded methods.
