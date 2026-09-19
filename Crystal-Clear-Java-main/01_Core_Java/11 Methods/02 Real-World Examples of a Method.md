## 🧒 Real-World Examples of a Method

To understand a **Java method**, imagine a method as a **recipe or a process**.

> A method is a **set of steps/statements grouped together to perform one specific task**.

---

# 🍜 Example 1: Method to Prepare Maggi

The **specific task** is:

> **Prepare Maggi**

The method contains several steps:

```text id="4b0n8d"
prepareMaggi()
      ↓
1. Boil water
      ↓
2. Add Maggi and ingredients
      ↓
3. Stir
      ↓
4. Serve
      ↓
5. Eat
```

In programming terms:

```text id="z8l2cv"
Method = prepareMaggi()

Statements/Steps:
    Boil water
    Add Maggi and ingredients
    Stir
    Serve
    Eat
```

So:

```text id="q2t6fs"
Set of steps
      +
Specific task
      ↓
    Method
```

---

# 💼 Example 2: Method for Getting a Job

The **specific task** is:

> **Get a job**

The process contains several steps:

```text id="w4x7pn"
getJob()
   ↓
1. Get skilled
   ↓
2. Apply for interviews
   ↓
3. Give interview
   ↓
4. Crack interview
   ↓
5. Accept offer letter
```

Think of these steps as the **statements inside a method**.

```text id="a8c3rm"
Method: getJob()

Statements:
    Get skilled
    Apply for interview
    Give interview
    Crack interview
    Accept offer letter
```

---

## 🧠 Connect This to Java

In Java, we can imagine:

```java id="h3v8k2"
void prepareMaggi() {
    boilWater();
    addMaggi();
    stir();
    serve();
}
```

And:

```java id="p7m2x9"
void getJob() {
    getSkilled();
    applyForInterview();
    giveInterview();
    crackInterview();
    acceptOfferLetter();
}
```

These are **just conceptual examples** to understand the idea.

### 🔑 Remember

```text id="c6n4qa"
METHOD
  ↓
Set of statements/steps
  ↓
Performs ONE specific task
```

**Maggi method** → prepares Maggi 🍜

**Job method** → follows steps toward getting a job 💼

So whenever you see a Java method, ask:

> **"What specific task is this method responsible for?"**
