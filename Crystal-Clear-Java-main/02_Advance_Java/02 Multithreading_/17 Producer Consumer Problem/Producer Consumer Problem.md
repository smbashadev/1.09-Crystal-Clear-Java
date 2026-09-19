# 36. Producer–Consumer Problem

The **Producer–Consumer Problem** is a classic multithreading problem where one thread **produces data/resources** and another thread **consumes that data/resource**.

In your example:

```text
Baker  → produces pizza
Eater  → consumes pizza
             ↓
       PizzaHouse
       (shared resource)
```

The important concept is that **both threads work with the same `PizzaHouse` object**.

---

## 36.1 Producer

A **producer** is a thread that creates or produces something that another thread will use.

Here, the producer is:

```text
Baker
```

The Baker produces:

```text
Pizza
```

So the relationship is:

```text
Baker
  ↓
Produces Pizza
  ↓
PizzaHouse
```

The Baker needs access to the `PizzaHouse` because that is where the pizza is produced/stored.

Therefore, the Baker maintains a reference to the `PizzaHouse` object.

Conceptually:

```text
Baker
  ↓
PizzaHouse reference
  ↓
bake()
  ↓
Pizza produced
```

### Real-world analogy

Think about a bakery.

The baker prepares pizzas and places them in a common area.

The baker does not eat every pizza immediately.

Instead:

```text
Baker
  ↓
Makes pizza
  ↓
PizzaHouse
  ↓
Eater
```

The Baker is therefore the **producer**.

---

## 36.2 Consumer

A **consumer** is a thread that takes or consumes something produced by another thread.

Here, the consumer is:

```text
Eater
```

The Eater consumes:

```text
Pizza
```

Therefore:

```text
Eater
  ↓
PizzaHouse reference
  ↓
eat()
  ↓
Pizza consumed
```

The Eater also needs a reference to the same `PizzaHouse`.

This is important because the Baker and Eater must communicate through the **same shared resource**.

---

## 36.3 Shared Resource — PizzaHouse

`PizzaHouse` is the shared resource between the producer and consumer.

It contains:

```text
PizzaHouse
│
├── pizzaNum
├── bake()
└── eat()
```

The basic relationship is:

```text
             PizzaHouse
            /          \
           /            \
       Baker            Eater
        ↓                 ↓
      bake()             eat()
        ↓                 ↓
     produces          consumes
        ↓                 ↓
            Pizza
```

### Why is PizzaHouse shared?

Because the Baker needs somewhere to place the produced pizza, while the Eater needs somewhere to obtain the pizza.

So both threads use the same object:

```text
Baker ───────┐
             ↓
        PizzaHouse
             ↑
             │
Eater ───────┘
```

This is the central idea of the Producer–Consumer problem.

---

## 36.4 `pizzaNum`

`pizzaNum` represents the pizza number being produced or consumed.

For example:

```text
Pizza 1
Pizza 2
Pizza 3
Pizza 4
...
```

The Baker can produce pizzas sequentially:

```text
1 → 2 → 3 → 4 → 5
```

The Eater consumes the pizzas from the shared `PizzaHouse`.

Conceptually:

```text
Baker
 ↓
bake(1)
 ↓
Pizza 1
 ↓
Eater
 ↓
eat()

Baker
 ↓
bake(2)
 ↓
Pizza 2
 ↓
Eater
 ↓
eat()
```

---

## 36.5 `bake()`

The `bake()` method represents the producer's activity.

Conceptually:

```java
void bake(int pizzaNum) {
    // produce pizza
}
```

The Baker calls:

```text
bake(t++)
```

Here, `t` represents the changing pizza number.

If:

```text
t = 1
```

then:

```text
bake(t++)
```

produces pizza number `1`, and `t` is then increased.

The sequence can therefore become:

```text
bake(1)
bake(2)
bake(3)
bake(4)
...
```

---

## 36.6 `eat()`

The `eat()` method represents the consumer's activity.

Conceptually:

```java
void eat() {
    // consume pizza
}
```

The Eater repeatedly calls:

```text
eat()
```

Therefore:

```text
Baker → bake()
             ↓
         PizzaHouse
             ↓
           eat()
             ↓
           Eater
```

---

# 36.7 Baker Class

The `Baker` implements `Runnable`.

```java
class Baker implements Runnable {

    PizzaHouse ph;

    Baker(PizzaHouse ph) {
        this.ph = ph;
    }

    public void run() {

        int t = 1;

        for (;;) {

            ph.bake(t++);

        }
    }
}
```

Let's understand every part.

---

## 36.8 `implements Runnable`

```java
class Baker implements Runnable
```

means `Baker` represents a task that can be executed by a thread.

Because `Runnable` contains:

```java
void run();
```

the Baker provides its implementation:

```java
public void run()
```

The actual producer activity is therefore placed inside `run()`.

---

## 36.9 PizzaHouse Reference

Inside Baker:

```java
PizzaHouse ph;
```

This variable stores a reference to a `PizzaHouse` object.

It does not create a new PizzaHouse.

It simply refers to an existing object.

Conceptually:

```text
ph
 ↓
PizzaHouse object
```

---

## 36.10 Baker Constructor

The constructor:

```java
Baker(PizzaHouse ph) {
    this.ph = ph;
}
```

receives a PizzaHouse reference.

Suppose `PizzaApp` creates:

```java
PizzaHouse ph = new PizzaHouse();
```

Then:

```java
Baker b = new Baker(ph);
```

passes that same PizzaHouse reference into the Baker.

So:

```text
PizzaApp
   ↓
PizzaHouse object
   ↓
Baker
   ↓
ph
```

The Baker can now access:

```java
ph.bake(...)
```

---

## 36.11 Infinite Production Loop

The Baker uses:

```java
for (;;) {
    ph.bake(t++);
}
```

`for(;;)` is an infinite loop.

It means the Baker keeps performing the production activity continuously.

Conceptually:

```text
Baker
 ↓
bake()
 ↓
bake()
 ↓
bake()
 ↓
bake()
 ↓
...
```

The producer does not naturally stop in this example.

---

## 36.12 Why `t++`?

Suppose:

```java
int t = 1;
```

Then:

```java
ph.bake(t++);
```

causes the pizza numbers to progress:

```text
1
2
3
4
5
...
```

So the Baker is continuously producing numbered pizzas.

---

# 36.13 Eater Class

The consumer is similarly implemented using `Runnable`.

```java
class Eater implements Runnable {

    PizzaHouse ph;

    Eater(PizzaHouse ph) {
        this.ph = ph;
    }

    public void run() {

        for (;;) {

            ph.eat();

        }
    }
}
```

The Eater follows the same basic structure as the Baker.

---

## 36.14 Eater's PizzaHouse Reference

```java
PizzaHouse ph;
```

stores a reference to the shared `PizzaHouse`.

The constructor receives that reference:

```java
Eater(PizzaHouse ph) {
    this.ph = ph;
}
```

Therefore both Baker and Eater can refer to the same object:

```text
             PizzaHouse
             /        \
            ↓          ↓
         Baker        Eater
           ph           ph
```

---

## 36.15 Infinite Consumption Loop

The Eater contains:

```java
for (;;) {
    ph.eat();
}
```

This means the Eater continuously attempts to consume pizzas.

Conceptually:

```text
Eater
 ↓
eat()
 ↓
eat()
 ↓
eat()
 ↓
eat()
 ↓
...
```

So we have:

```text
Baker → continuously produces
Eater → continuously consumes
```

---

# 36.16 PizzaApp

`PizzaApp` is the class where the objects and threads are created.

A simplified structure is:

```java
public class PizzaApp {

    public static void main(String[] args) {

        PizzaHouse ph = new PizzaHouse();

        Baker b = new Baker(ph);

        Eater e = new Eater(ph);

        Thread t1 = new Thread(b);

        Thread t2 = new Thread(e);

        t1.start();

        t2.start();
    }
}
```

---

## 36.17 Create PizzaHouse

First:

```java
PizzaHouse ph = new PizzaHouse();
```

This creates the shared resource.

```text
PizzaApp
   ↓
PizzaHouse
```

There is one PizzaHouse object.

---

## 36.18 Create Baker

Next:

```java
Baker b = new Baker(ph);
```

The PizzaHouse reference is passed to the Baker.

```text
Baker
  ↓
same PizzaHouse
```

Now the Baker knows where to produce pizza.

---

## 36.19 Create Eater

Next:

```java
Eater e = new Eater(ph);
```

The **same** PizzaHouse reference is passed to the Eater.

Therefore:

```text
Baker ────────┐
              ↓
         PizzaHouse
              ↑
Eater ────────┘
```

This shared object is what allows the producer and consumer to communicate.

---

## 36.20 Create Producer Thread

Because Baker implements `Runnable`:

```java
Thread t1 = new Thread(b);
```

creates a Thread object and gives it the Baker task.

Conceptually:

```text
Thread t1
   ↓
Baker Runnable
   ↓
run()
   ↓
bake()
```

---

## 36.21 Create Consumer Thread

Similarly:

```java
Thread t2 = new Thread(e);
```

creates another Thread object and gives it the Eater task.

```text
Thread t2
   ↓
Eater Runnable
   ↓
run()
   ↓
eat()
```

---

## 36.22 Start Producer

```java
t1.start();
```

starts the producer thread.

The thread eventually executes:

```java
b.run()
```

which continuously performs:

```text
ph.bake(t++)
```

---

## 36.23 Start Consumer

Then:

```java
t2.start();
```

starts the consumer thread.

It eventually executes:

```text
e.run()
```

which continuously performs:

```text
ph.eat()
```

---

# 36.24 Complete Architecture

The complete relationship is:

```text
                         PizzaApp
                            |
                    Create PizzaHouse
                            |
                       PizzaHouse
                       /         \
                      /           \
                     ↓             ↓
                  Baker          Eater
                Runnable        Runnable
                     ↓             ↓
                   run()         run()
                     ↓             ↓
                  bake()         eat()
                     ↓             ↑
                     └──────┬──────┘
                            ↓
                     Shared Resource
                      PizzaHouse
```

---

# 36.25 Complete Execution Flow

```text
PizzaApp
   ↓
Create PizzaHouse
   ↓
Create Baker with PizzaHouse reference
   ↓
Create Eater with PizzaHouse reference
   ↓
Create Thread for Baker
   ↓
Create Thread for Eater
   ↓
Start Baker thread
   ↓
Start Eater thread
   ↓
       ┌─────────────────┐
       │                 │
       ↓                 ↓
    Baker              Eater
       ↓                 ↓
    bake()             eat()
       ↓                 ↓
  Produces pizza    Consumes pizza
       │                 │
       └──────→ PizzaHouse ←──────┘
```

---

# 36.26 Why This Is a Multithreading Problem

There are two independent activities:

```text
Producer
   ↓
Baker
```

and:

```text
Consumer
   ↓
Eater
```

They run using separate threads:

```text
Thread 1 → Baker
Thread 2 → Eater
```

Both access:

```text
PizzaHouse
```

Therefore:

```text
Multiple threads
       +
Shared resource
       ↓
Producer–Consumer problem
```

---

# 36.27 The Most Important Point

The central relationship is:

```text
Baker
  ↓
Produces
  ↓
PizzaHouse
  ↑
Consumes
  ↑
Eater
```

The Baker cannot simply produce independently of the Eater in a real producer-consumer system.

Similarly, the Eater cannot consume something that has not been produced.

This creates a dependency:

```text
Producer → Data/Resource → Consumer
```

In this example:

```text
Baker → Pizza → Eater
```

---

# 36.28 Real-World Examples

The same pattern exists in many real systems.

### Restaurant

```text
Cook
 ↓
Prepares food
 ↓
Kitchen/Counter
 ↓
Waiter
 ↓
Delivers food
```

### Online shopping

```text
Order Producer
 ↓
Orders
 ↓
Queue
 ↓
Order Consumer
 ↓
Processing
```

### Download system

```text
Downloader
 ↓
Downloaded data
 ↓
Buffer
 ↓
Video player
 ↓
Consumes data
```

### Printing system

```text
Applications
 ↓
Print jobs
 ↓
Print queue
 ↓
Printer
 ↓
Consumes jobs
```

The names change, but the fundamental idea remains:

```text
Producer → Shared resource → Consumer
```

---

# 36.29 Important Rules

**Rule 1:** A producer creates or provides data/resources.

**Rule 2:** A consumer uses or consumes that data/resource.

**Rule 3:** Producer and consumer can execute in different threads.

**Rule 4:** They communicate through a shared resource.

**Rule 5:** In this example, `PizzaHouse` is the shared resource.

**Rule 6:** `Baker` implements `Runnable`.

**Rule 7:** `Eater` implements `Runnable`.

**Rule 8:** The actual thread activities are written inside `run()`.

**Rule 9:** `PizzaHouse` reference is passed to both Baker and Eater.

**Rule 10:** `start()` is used to start the producer and consumer threads.

---

# 36.30 Common Confusion — Baker and Thread Are Not the Same

`Baker` implements `Runnable`.

Therefore:

```java
Baker b = new Baker(ph);
```

does **not itself mean** that `b` is a Thread object.

It is a Runnable task.

A Thread object is created separately:

```java
Thread t1 = new Thread(b);
```

So:

```text
Baker
  ↓
Runnable task

Thread
  ↓
Executes Baker task
```

This is the same Runnable approach from your earlier multithreading topic.

---

# 36.31 Common Confusion — Same PizzaHouse

We create only one:

```java
PizzaHouse ph = new PizzaHouse();
```

Then:

```java
new Baker(ph);
new Eater(ph);
```

Both receive the same reference.

Therefore:

```text
          One PizzaHouse
             /       \
            /         \
        Baker         Eater
```

If separate PizzaHouse objects were used, they would not be communicating through the same shared resource.

---

# 36.32 Memory Trick

Remember the entire topic using:

```text
B → P → E
```

Where:

```text
B = Baker
P = PizzaHouse
E = Eater
```

And:

```text
Baker
  ↓
Bake
  ↓
PizzaHouse
  ↓
Eat
  ↓
Eater
```

For the Java implementation:

```text
Baker → Runnable → run() → bake()

Eater → Runnable → run() → eat()

Both → same PizzaHouse
```

---

# 36.33 Interview Understanding

The **Producer–Consumer Problem** is a multithreading problem in which one thread produces data while another thread consumes that data through a shared resource. In this example, `Baker` is the producer and `Eater` is the consumer. Both implement `Runnable` and receive a reference to the same `PizzaHouse` object. The Baker's `run()` method contains an infinite production loop that repeatedly calls `bake(t++)`, while the Eater's `run()` method contains an infinite consumption loop that repeatedly calls `eat()`. In `PizzaApp`, the `PizzaHouse`, Baker, Eater, and their corresponding Thread objects are created, and both threads are started.

The complete concept can be remembered as:

```text
                    PizzaApp
                       ↓
                PizzaHouse Object
                       ↓
              Shared Resource
                  /         \
                 ↓           ↓
              Baker         Eater
            Producer       Consumer
                 ↓           ↓
              Runnable     Runnable
                 ↓           ↓
               run()       run()
                 ↓           ↓
              bake()       eat()
                 ↓           ↑
                 └── Pizza ──┘
```

**Core idea:** The Baker produces pizzas, the Eater consumes pizzas, and both coordinate through the same `PizzaHouse` shared resource.
