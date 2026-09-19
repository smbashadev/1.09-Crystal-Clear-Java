## 🧒 Stack Frame of a Method

When a method is **called**, Java needs a temporary place to keep information needed while that method is running.

That temporary area is called a **stack frame**.

> **Every method invocation gets its own stack frame on the thread's JVM stack.**

---

# 1️⃣ Method Call

Suppose we have:

```java
class Demo {

    static void add() {
        int a = 10;
        int b = 20;
        int sum = a + b;

        System.out.println(sum);
    }

    public static void main(String[] args) {
        add();
    }
}
```

When Java reaches:

```java
add();
```

the `add()` method is **called**.

---

# 2️⃣ Stack Frame

When `add()` starts executing, the JVM creates a **stack frame** for that method invocation.

Think of it as giving the method its own **temporary workspace** 🗂️.

```text id="w2t5kv"
        JVM Stack
┌─────────────────────┐
│  add() Stack Frame  │ ← Current method
│  a = 10             │
│  b = 20             │
│  sum = 30           │
├─────────────────────┤
│ main() Stack Frame  │
└─────────────────────┘
```

The frame contains information needed for that particular method invocation, including things such as local variables and execution state.

---

# 3️⃣ Stack Segment

You may see your notes say **"stack segment."**

For beginner understanding:

```text id="k5p3xz"
JVM Stack
    ↓
Stack Frames
    ↓
One frame for each active method invocation
```

More accurately, each **thread has its own JVM stack**, and that stack consists of frames.

So don't think of "stack segment" as a separate Java memory area that stores all local variables.

---

# 4️⃣ Local Variables

Consider:

```java id="d6t2qa"
static void add() {
    int a = 10;
    int b = 20;
    int sum = a + b;
}
```

The variables:

```text id="n8f4sm"
a
b
sum
```

are **local variables** of `add()`.

They are associated with the `add()` method's execution.

Conceptually:

```text id="2n8x5q"
add() Stack Frame
┌──────────────────┐
│ a   = 10         │
│ b   = 20         │
│ sum = 30         │
└──────────────────┘
```

---

# 5️⃣ Memory Allocation

When `add()` is invoked:

```text id="x5r7mb"
add() called
    ↓
New stack frame created
    ↓
Space for method's execution information
    ↓
Local variables are associated with that frame
```

So your notes' idea of **memory allocation** means the JVM creates the necessary frame for the method invocation.

---

# 6️⃣ Method Returns

After the method finishes:

```java id="r8k3wv"
static void add() {
    int a = 10;
    int b = 20;
    int sum = a + b;

    System.out.println(sum);
}
```

control returns to the point where `add()` was called:

```java id="q9m2vc"
public static void main(String[] args) {
    add();

    System.out.println("Back in main");
}
```

Flow:

```text id="n2x8qa"
main()
  ↓
add()
  ↓
add() executes
  ↓
add() finishes
  ↓
return to main()
  ↓
"Back in main"
```

---

# 7️⃣ Stack-Frame Deletion

When the `add()` method invocation finishes, its **stack frame is popped from the thread's JVM stack**.

```text id="w3k6pz"
Before add():

┌─────────────────────┐
│  main() Frame       │
└─────────────────────┘

       ↓ add()

┌─────────────────────┐
│  add() Frame        │
│  a = 10             │
│  b = 20             │
│  sum = 30           │
├─────────────────────┤
│  main() Frame       │
└─────────────────────┘

       ↓ add() returns

┌─────────────────────┐
│  main() Frame       │
└─────────────────────┘
```

This is essentially **stack-frame removal/pop**.

---

# 8️⃣ Local-Variable Deletion

When the `add()` frame is popped, its **frame-associated local variables are no longer available as locals of that invocation**.

So:

```text id="f5c2mn"
add() Frame
   ↓
a = 10
b = 20
sum = 30
   ↓
method finishes
   ↓
frame popped
   ↓
those local variables are gone from that invocation
```

⚠️ Important:

Don't say **"Java's Garbage Collector deletes local variables."**

That's not accurate.

* **Stack frame:** managed as part of method invocation/return.
* **Local variables:** cease to exist as accessible locals when their invocation ends.
* **Objects created by `new`:** normally live in the heap and are managed separately by the Garbage Collector when no longer reachable.

---

# 🧠 Complete Picture

```text id="u8m4qw"
             METHOD CALL
                  ↓
          Stack Frame Created
                  ↓
       Local variables / state
                  ↓
           Method executes
                  ↓
            Method returns
                  ↓
          Frame is popped
                  ↓
      Local variables of that
       invocation disappear
```

### 🔑 Easy Memory Trick

> **Call → Frame → Locals → Execute → Return → Frame Pop**

Or:

```text id="j2p7sx"
CALL
 ↓
CREATE FRAME
 ↓
USE LOCALS
 ↓
EXECUTE
 ↓
RETURN
 ↓
POP FRAME
```

### ⭐ Interview Answer

> **When a method is invoked, the JVM creates a stack frame for that method invocation on the current thread's JVM stack. The frame holds information needed for execution, including local variables. When the method returns, its frame is popped from the stack, and the local variables associated with that invocation are no longer accessible.**
