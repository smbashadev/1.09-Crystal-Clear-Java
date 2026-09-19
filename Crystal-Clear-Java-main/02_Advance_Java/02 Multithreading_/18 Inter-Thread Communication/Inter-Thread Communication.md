# 38. Inter-Thread Communication

Inter-thread communication is the mechanism through which multiple threads **coordinate with each other** when they are working with a shared resource.

In the Producer–Consumer problem, the Producer should not continuously produce when the shared resource already contains a value, and the Consumer should not try to consume when no value is available.

The Producer and Consumer therefore communicate using:

```text
wait()
notify()
```

The entire concept revolves around the `baked` flag.

```text
baked = false
        ↓
Pizza not available

baked = true
        ↓
Pizza available
```

---

### 38.1 Why Inter-Thread Communication Is Needed

Without communication, the Baker and Eater work independently.

```text
Baker → produces → produces → produces → produces
Eater → consumes → consumes → consumes
```

This can create problems because the Producer may produce another value before the Consumer has consumed the current value.

We therefore need a mechanism through which one thread can tell another thread:

```text
"I cannot continue now."
```

or:

```text
"The resource is now available."
```

That coordination is called **inter-thread communication**.

---

### 38.2 The Two Important Methods

The two methods used in this example are:

```java
wait();
notify();
```

Their basic responsibilities are:

```text
wait()
  ↓
Current thread waits

notify()
  ↓
Notifies a waiting thread
```

These methods are associated with Java's object-monitor mechanism.

---

### 38.3 `wait()` — Basic Meaning

`wait()` causes the currently executing thread to wait.

For example:

```java
wait();
```

means that the current thread cannot continue its synchronized activity until it is appropriately notified and can reacquire the monitor.

In the Producer–Consumer problem, `wait()` is used when the required condition is not available.

---

### 38.4 When the Producer Uses `wait()`

Suppose the Baker has already baked a pizza.

```text
baked = true
```

This means a pizza is already available.

The Baker should **not produce another pizza** because there is only one shared value in this simple example.

Therefore:

```text
Pizza already available
        ↓
Producer cannot produce
        ↓
Producer calls wait()
```

The Baker waits for the Consumer to consume the existing pizza.

---

### 38.5 When the Consumer Uses `wait()`

Now consider the opposite situation.

```text
baked = false
```

This means there is no pizza available.

The Eater cannot consume anything.

Therefore:

```text
Pizza not available
        ↓
Consumer cannot consume
        ↓
Consumer calls wait()
```

The Eater waits until the Baker produces a pizza.

---

### 38.6 `notify()` — Basic Meaning

`notify()` is used to notify a waiting thread that the condition associated with the shared resource may have changed.

For example:

```java
notify();
```

After the Baker produces a pizza:

```text
Baker
 ↓
Produces pizza
 ↓
baked = true
 ↓
notify()
```

The notification tells the waiting Consumer that a pizza may now be available.

Similarly, after the Consumer eats a pizza:

```text
Consumer
 ↓
Consumes pizza
 ↓
baked = false
 ↓
notify()
```

The waiting Producer can now potentially produce the next pizza.

---

### 38.7 Important `wait()` and `notify()` Rule

`wait()` and `notify()` must be used while the current thread owns the monitor of the object on which they are called.

Therefore, they are used inside a synchronized method or synchronized block.

For example:

```java
synchronized void bake(int n) {
    // communication
}
```

or:

```java
synchronized(this) {
    // communication
}
```

Think of it as:

```text
synchronized
     ↓
Acquire object's monitor
     ↓
wait() / notify()
```

---

### 38.8 Why `synchronized` Is Required

The Producer and Consumer are accessing the same shared resource.

Without synchronization, both threads could examine and modify the shared state at inappropriate times.

Synchronization provides controlled access to the shared object.

In this example:

```text
Baker ───────┐
             ↓
        PizzaHouse
             ↑
Eater ───────┘
```

`PizzaHouse` is the shared object.

Its synchronized methods control access to the shared state.

---

### 38.9 The `baked` Flag

The `baked` variable is used to represent whether a pizza is currently available.

It has two important states:

```text
baked = false
```

means:

```text
Pizza is NOT available
```

and:

```text
baked = true
```

means:

```text
Pizza IS available
```

Therefore:

```text
false → Empty
true  → Full
```

This single variable allows the Producer and Consumer to understand the state of the shared resource.

---

### 38.10 Initial State of `baked`

Initially:

```java
boolean baked = false;
```

This means no pizza has been produced yet.

The state is:

```text
PizzaHouse
   ↓
baked = false
   ↓
No pizza available
```

Therefore, if the Eater tries to consume at this point, it must wait.

The Baker, however, is allowed to produce.

---

### 38.11 Producer's Condition

The Producer checks:

```text
Is pizza already baked?
```

If:

```text
baked == true
```

then a pizza is already available.

The Producer waits:

```text
baked == true
      ↓
wait()
```

If:

```text
baked == false
```

then no pizza is currently available.

The Producer can produce:

```text
baked == false
      ↓
produce pizza
```

---

### 38.12 Consumer's Condition

The Consumer checks:

```text
Is a pizza baked?
```

If:

```text
baked == false
```

there is nothing to consume.

Therefore:

```text
baked == false
      ↓
wait()
```

If:

```text
baked == true
```

a pizza is available.

The Consumer can consume it.

---

### 38.13 Synchronized `bake()` Method

The Producer's activity is placed inside a synchronized method.

Conceptually:

```java
synchronized void bake(int n) {

    if (baked) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Pizza production

    baked = true;

    notify();
}
```

The important elements are:

```text
synchronized
     ↓
baked flag
     ↓
wait()
     ↓
Pizza production
     ↓
baked = true
     ↓
notify()
```

---

### 38.14 Producer Checks `baked`

At the beginning of `bake()`:

```java
if (baked) {
    wait();
}
```

If `baked` is `true`, the previous pizza has not yet been consumed.

Therefore the Baker waits.

Conceptually:

```text
Baker enters bake()
        ↓
Is baked true?
        ↓
YES
        ↓
wait()
```

This prevents immediate overwriting.

---

### 38.15 Producer Produces the Pizza

If `baked` is false, the Baker proceeds with production.

For example:

```java
System.out.println("Baked Pizza " + n);
```

The important conceptual action is:

```text
Baker
 ↓
Produces Pizza
 ↓
Pizza becomes available
```

At this point, the state must change.

---

### 38.16 Producer Sets `baked = true`

After producing the pizza:

```java
baked = true;
```

This is extremely important.

Before production:

```text
baked = false
```

After production:

```text
baked = true
```

Therefore:

```text
false
 ↓
Pizza produced
 ↓
true
```

Now the shared resource indicates that a pizza is available.

---

### 38.17 Producer Calls `notify()`

After setting:

```java
baked = true;
```

the Producer calls:

```java
notify();
```

Conceptually:

```text
Baker
 ↓
Pizza produced
 ↓
baked = true
 ↓
notify()
 ↓
Waiting Consumer is notified
```

This allows the Consumer to become eligible to continue once it can reacquire the required monitor.

---

### 38.18 Synchronized `eat()` Method

The Consumer's activity is similarly synchronized.

Conceptually:

```java
synchronized void eat() {

    if (!baked) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Consume pizza

    baked = false;

    notify();
}
```

The important sequence is:

```text
synchronized
     ↓
Check baked
     ↓
wait() if necessary
     ↓
Consume pizza
     ↓
baked = false
     ↓
notify()
```

---

### 38.19 Consumer Checks `baked`

At the beginning of `eat()`:

```java
if (!baked) {
    wait();
}
```

If:

```text
baked = false
```

there is no pizza.

Therefore:

```text
Consumer
   ↓
Check baked
   ↓
false
   ↓
wait()
```

The Eater waits instead of consuming something that does not exist.

---

### 38.20 Consumer Consumes the Pizza

When:

```text
baked = true
```

the pizza is available.

The Eater can consume it.

Conceptually:

```text
PizzaHouse
    ↓
Pizza available
    ↓
Eater
    ↓
Consumes pizza
```

After consuming it, the shared state must change again.

---

### 38.21 Consumer Sets `baked = false`

After consuming the pizza:

```java
baked = false;
```

This means the PizzaHouse is now empty.

The state changes:

```text
true
 ↓
Pizza consumed
 ↓
false
```

Now the Baker can produce another pizza.

---

### 38.22 Consumer Calls `notify()`

After consuming:

```java
notify();
```

The Consumer notifies a waiting Producer.

The conceptual sequence is:

```text
Eater
 ↓
Consumes pizza
 ↓
baked = false
 ↓
notify()
 ↓
Waiting Baker can continue
```

This creates communication in the opposite direction.

---

### 38.23 Complete Producer Cycle

The Producer follows this pattern:

```text
Baker
 ↓
Check baked
 ↓
If true → wait
 ↓
Produce pizza
 ↓
baked = true
 ↓
notify()
 ↓
Repeat
```

So the Producer's responsibility is:

```text
Produce → mark available → notify → wait when necessary
```

---

### 38.24 Complete Consumer Cycle

The Consumer follows:

```text
Eater
 ↓
Check baked
 ↓
If false → wait
 ↓
Consume pizza
 ↓
baked = false
 ↓
notify()
 ↓
Repeat
```

So the Consumer's responsibility is:

```text
Wait for pizza → consume → mark unavailable → notify
```

---

### 38.25 Complete Coordination Cycle

Now combine both threads.

Initially:

```text
baked = false
```

The Baker can produce.

```text
Baker
 ↓
Produce Pizza 1
 ↓
baked = true
 ↓
notify()
```

The Eater consumes:

```text
Eater
 ↓
Consume Pizza 1
 ↓
baked = false
 ↓
notify()
```

Then the Baker produces again:

```text
Baker
 ↓
Produce Pizza 2
 ↓
baked = true
```

And the cycle continues.

---

### 38.26 Visual State Transition

The easiest way to understand the entire mechanism is:

```text
                 baked = false
                Pizza unavailable
                       ↓
                  Baker produces
                       ↓
                 baked = true
                  Pizza available
                       ↓
                  Eater consumes
                       ↓
                 baked = false
                  Pizza unavailable
                       ↓
                  Baker produces
                       ↓
                      ...
```

This is the central cycle of the Producer–Consumer problem.

---

### 38.27 Producer–Consumer Communication Table

| Shared State      | Producer — Baker | Consumer — Eater |
| ----------------- | ---------------- | ---------------- |
| `baked = false`   | Can produce      | Must wait        |
| `baked = true`    | Must wait        | Can consume      |
| After production  | Sets `true`      | Can consume      |
| After consumption | Can produce      | Sets `false`     |
| Communication     | `notify()`       | `notify()`       |

The entire coordination is controlled by the `baked` state.

---

### 38.28 Why the `baked` Flag Is So Important

Without the flag, the threads would not have a simple shared indication of whether the PizzaHouse currently contains a pizza.

With:

```java
boolean baked;
```

the shared resource has a clear state:

```text
false → no pizza
true  → pizza available
```

This allows the threads to make decisions.

The Producer asks conceptually:

```text
"Is baked true?"
```

The Consumer asks:

```text
"Is baked false?"
```

---

### 38.29 Why `if` Is Often Replaced by `while`

For robust Producer–Consumer implementations, the condition surrounding `wait()` is generally checked with `while`, not merely `if`.

For example:

```java
while (baked) {
    wait();
}
```

and:

```java
while (!baked) {
    wait();
}
```

The reason is that after a thread wakes, it should **recheck the condition** before proceeding.

The conceptual rule is:

```text
wait()
 ↓
Wake up
 ↓
Check condition again
 ↓
Proceed only if condition is satisfied
```

This is an important practical Java rule when implementing wait/notify-based coordination.

---

### 38.30 Common Confusion — `notify()` Does Not Consume or Produce

`notify()` does not perform the actual work.

It does **not** mean:

```text
notify() → consume pizza
```

and it does not mean:

```text
notify() → produce pizza
```

Instead:

```text
notify()
   ↓
Signals a waiting thread
```

The actual work is still performed by:

```text
bake()
eat()
```

---

### 38.31 Common Confusion — `wait()` Does Not Mean Thread Death

When the Baker executes:

```java
wait();
```

the Baker is not dead.

It is waiting.

Similarly, when the Eater waits:

```java
wait();
```

the Eater has not terminated.

Conceptually:

```text
Running
   ↓
wait()
   ↓
Waiting
   ↓
notification + monitor reacquisition
   ↓
Can continue
```

---

### 38.32 Common Confusion — `wait()` vs `sleep()`

These methods have different purposes.

`Thread.sleep()` is primarily a time-based pause:

```java
Thread.sleep(1000);
```

`wait()` is used for coordination between threads:

```java
wait();
```

Producer–Consumer communication uses:

```text
wait()
notify()
```

because the threads need to coordinate based on the state of the shared resource.

---

### 38.33 Real-World Analogy

Imagine a bakery with one serving counter.

Initially:

```text
Counter = Empty
```

The Baker can place a pizza:

```text
Baker
 ↓
Places Pizza
 ↓
Counter = Full
```

The Baker now waits because the counter already contains a pizza.

The Eater takes it:

```text
Eater
 ↓
Takes Pizza
 ↓
Counter = Empty
```

The Eater notifies the Baker.

The Baker can now place another pizza.

So:

```text
Empty
 ↓
Baker produces
 ↓
Full
 ↓
Eater consumes
 ↓
Empty
 ↓
Baker produces again
```

That is exactly what the `baked` flag represents.

---

### 38.34 Complete Conceptual Program

A simplified version of the `PizzaHouse` logic is:

```java
class PizzaHouse {

    int pizzaNum;
    boolean baked = false;

    synchronized void bake(int n) {

        while (baked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pizzaNum = n;
        System.out.println("Baked Pizza " + pizzaNum);

        baked = true;

        notify();
    }

    synchronized void eat() {

        while (!baked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Eating Pizza " + pizzaNum);

        baked = false;

        notify();
    }
}
```

The core logic is:

```text
                 PizzaHouse
                     │
              baked = false
                     │
          ┌──────────┴──────────┐
          ↓                     ↓
        Baker                  Eater
          ↓                     ↓
    if baked → wait       if !baked → wait
          ↓                     ↓
       bake()                eat()
          ↓                     ↓
    baked = true           baked = false
          ↓                     ↓
       notify()               notify()
```

---

### 38.35 Interview Understanding

**Inter-thread communication** is a mechanism used by threads to coordinate when they share a resource. In the Producer–Consumer problem, the Baker produces a pizza and the Eater consumes it. The `PizzaHouse` acts as the shared resource, while the `baked` flag indicates whether a pizza is currently available.

When `baked` is `false`, no pizza is available, so the Consumer waits. When `baked` is `true`, a pizza is available, so the Consumer can consume it. After producing a pizza, the Producer changes `baked` to `true` and calls `notify()`. After consuming the pizza, the Consumer changes `baked` to `false` and calls `notify()`.

The communication therefore follows:

```text
Producer
   ↓
If pizza already available
   ↓
wait()
   ↓
Produce pizza
   ↓
baked = true
   ↓
notify()
   ↓
Consumer

Consumer
   ↓
If pizza unavailable
   ↓
wait()
   ↓
Consume pizza
   ↓
baked = false
   ↓
notify()
   ↓
Producer
```

The most important memory pattern is:

```text
FALSE
 ↓
Producer produces
 ↓
TRUE
 ↓
Consumer consumes
 ↓
FALSE
 ↓
Producer produces again
```

**Core idea:** `baked` represents the shared resource's state, `wait()` makes a thread wait when its required condition is unavailable, and `notify()` signals a waiting thread after the shared state changes. All of this communication must happen while the appropriate object's monitor is held, normally through `synchronized` methods or blocks.
