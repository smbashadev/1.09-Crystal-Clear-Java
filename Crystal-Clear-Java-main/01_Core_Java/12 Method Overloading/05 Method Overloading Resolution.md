## 🧒 Method Overloading Resolution

When multiple methods have the **same name**, Java has to decide:

> **"Which method should I execute?"**

This process is called **method overloading resolution**.

Think of Java as a **selector** 🔍 that looks at the method call and finds the best matching method.

---

# Example

Suppose we have:

```java
static void acceptInfo(int age) {
    System.out.println("Integer version");
}

static void acceptInfo(String name) {
    System.out.println("String version");
}

static void acceptInfo(String name, int age) {
    System.out.println("String + Integer version");
}
```

Now we call:

```java
acceptInfo("Basha", 26);
```

Java needs to determine which `acceptInfo()` to execute.

---

# 🥇 Step 1: Number of Arguments

First, Java looks at:

> **How many arguments did we pass?**

For:

```java
acceptInfo("Basha", 26);
```

There are:

```text id="4q6m8p"
2 arguments
```

Java first looks for methods that can accept **2 arguments**.

```text id="y3k7vz"
acceptInfo(int)              → 1 parameter ❌
acceptInfo(String)           → 1 parameter ❌
acceptInfo(String, int)      → 2 parameters ✅
```

So the search becomes smaller.

### 🧠 Remember

```text id="s8m2qx"
Step 1
  ↓
Count arguments
  ↓
Find matching parameter count
```

---

# 🥈 Step 2: Data Types of Arguments

Next, Java checks:

> **What are the data types of the arguments?**

Our call:

```java
acceptInfo("Basha", 26);
```

has:

```text id="w5n9kc"
"Basha" → String
26      → int
```

So Java compares:

```text id="m7p3xa"
Call:
(String, int)

Method:
acceptInfo(String, int)
```

✅ Exact match.

---

# 🥉 Step 3: Order of Data Types

The **order of parameters matters**.

Consider:

```java id="q2v6mz"
static void acceptInfo(String name, int age) {
    System.out.println("String, int");
}

static void acceptInfo(int age, String name) {
    System.out.println("int, String");
}
```

These are valid overloaded methods because their parameter lists are different.

Now:

```java id="n8k4pr"
acceptInfo("Basha", 26);
```

Types are:

```text id="r6x2qm"
String → first
int    → second
```

So Java selects:

```java id="j5w9vx"
acceptInfo(String, int)
```

If we call:

```java id="c3m7qa"
acceptInfo(26, "Basha");
```

Types are:

```text id="t8p4nz"
int    → first
String → second
```

So Java selects:

```java id="x7k2ms"
acceptInfo(int, String)
```

---

# 🔄 Three-Step Memory Flow

```text id="a9q5mv"
           Method Call
                ↓
       STEP 1: Number
                ↓
       How many arguments?
                ↓
       STEP 2: Data Type
                ↓
       What types are they?
                ↓
       STEP 3: Order
                ↓
       In what order are they?
                ↓
       Best matching method
                ↓
             Execute
```

---

# 💻 Complete Example

```java id="p4x8kn"
class Demo {

    static void acceptInfo(int age) {
        System.out.println("Integer version");
    }

    static void acceptInfo(String name) {
        System.out.println("String version");
    }

    static void acceptInfo(String name, int age) {
        System.out.println("String + Integer version");
    }

    static void acceptInfo(int age, String name) {
        System.out.println("Integer + String version");
    }

    public static void main(String[] args) {

        acceptInfo(26);

        acceptInfo("Basha");

        acceptInfo("Basha", 26);

        acceptInfo(26, "Basha");
    }
}
```

Output:

```text id="m6q3vz"
Integer version
String version
String + Integer version
Integer + String version
```

---

## 🧠 Super-Easy Trick

When Java sees overloaded methods, think:

### **1 → 2 → 3**

```text id="y7p2mk"
1. NUMBER
      ↓
2. TYPE
      ↓
3. ORDER
```

For:

```java
acceptInfo("Basha", 26);
```

Java thinks:

```text id="k4n8qx"
1️⃣ How many? → 2

2️⃣ What types? → String, int

3️⃣ What order? → String first, int second

           ↓

acceptInfo(String, int)
```

### ⚠️ Small Technical Correction

These three are excellent **beginner-level matching checkpoints**, but Java's real overload resolution is more detailed. If there are multiple applicable methods, Java also considers **conversion rules and specificity** to select the most specific applicable method.

For your current notes, remember:

> **Number → Data Type → Order**.
