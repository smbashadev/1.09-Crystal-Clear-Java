# 39. Inter-Thread Communication

Inter-thread communication is the mechanism that allows multiple threads working on the **same shared resource** to coordinate with each other.

In our PizzaHouse example:

```text
                 PizzaHouse
                /          \
               ↓            ↓
            Baker          Eater
           Producer       Consumer
               ↓            ↑
             bake()       eat()
               ↓            ↑
               └── pizza ──┘
```

The main objective is simple:

```text
One pizza produced
        ↓
One pizza consumed
        ↓
Next pizza produced
        ↓
Next pizza consumed
```

This prevents the Producer from continuously overwriting the value before the Consumer gets a chance to consume it.

---

## 39.1 PizzaHouse

`PizzaHouse` is the **shared resource**.

It contains:

```text
PizzaHouse
│
├── pizzaNum
├── baked
├── bake()
└── eat()
```

Both the Baker and Eater work with the same `PizzaHouse` object.

```text
             One PizzaHouse Object
                    │
             ┌──────┴──────┐
             ↓             ↓
           Baker          Eater
```

### `pizzaNum`

`pizzaNum` represents the pizza value.

For example:

```text
1
2
3
4
5
...
```

The Baker produces the value, and the Eater consumes that value.

### `baked`

`baked` tells us whether a pizza is currently available.

```text
baked = false
        ↓
Pizza is not available

baked = true
        ↓
Pizza is available
```

This flag is extremely important because it tells both threads what they are allowed to do.

### `bake()`

`bake()` represents the Producer's activity.

```text
Baker
  ↓
bake()
  ↓
Pizza produced
  ↓
baked = true
```

### `eat()`

`eat()` represents the Consumer's activity.

```text
Eater
  ↓
eat()
  ↓
Pizza consumed
  ↓
baked = false
```

So the basic state transition is:

```text
false
  ↓
bake()
  ↓
true
  ↓
eat()
  ↓
false
```

---

## 39.2 Baker

The `Baker` represents the **Producer**.

It implements `Runnable`, so its work can be executed by a separate thread.

Conceptually:

```text
Baker
 ↓
Producer
 ↓
Runnable
 ↓
run()
 ↓
bake()
```

The Baker receives a reference to the shared `PizzaHouse`.

```text
Baker
  ↓
PizzaHouse reference
  ↓
Shared PizzaHouse
```

Therefore, the Baker does not create its own separate PizzaHouse for production.

It works with the shared object.

---

## 39.3 Eater

The `Eater` represents the **Consumer**.

It also implements `Runnable`.

```text
Eater
 ↓
Consumer
 ↓
Runnable
 ↓
run()
 ↓
eat()
```

The Eater also receives a reference to the **same PizzaHouse**.

Therefore:

```text
                 PizzaHouse
                /          \
               ↑            ↑
              ph            ph
               │            │
             Baker         Eater
```

Both threads communicate through this common object.

---

## 39.4 PizzaApp

`PizzaApp` is responsible for creating the shared object and the threads.

The basic flow is:

```text
PizzaApp
   ↓
Create PizzaHouse
   ↓
Create Baker using PizzaHouse
   ↓
Create Eater using PizzaHouse
   ↓
Create Baker Thread
   ↓
Create Eater Thread
   ↓
start()
```

Conceptually:

```java
PizzaHouse ph = new PizzaHouse();

Baker b = new Baker(ph);
Eater e = new Eater(ph);

Thread t1 = new Thread(b);
Thread t2 = new Thread(e);

t1.start();
t2.start();
```

### Shared object

The most important point is:

```java
PizzaHouse ph = new PizzaHouse();
```

There is one shared `PizzaHouse`.

That same reference is passed to both:

```java
new Baker(ph);
new Eater(ph);
```

Therefore:

```text
              PizzaHouse
              /         \
             /           \
         Baker           Eater
        Producer        Consumer
```

### `start()`

The threads are started using:

```java
t1.start();
t2.start();
```

This allows the Baker and Eater activities to execute concurrently.

---

## 39.5 Communication Methods Used

Three important concepts are used:

```text
wait()
notify()
synchronized
```

They work together to coordinate the two threads.

### `synchronized`

`synchronized` provides controlled access to the shared `PizzaHouse`.

For example:

```java
synchronized void bake(int n)
```

and:

```java
synchronized void eat()
```

This means the corresponding operations execute under the object's monitor.

Conceptually:

```text
Thread
  ↓
synchronized method
  ↓
Acquire object monitor
  ↓
Perform shared-resource operation
```

This prevents uncontrolled simultaneous access to the shared state.

---

### `wait()`

`wait()` makes the current thread wait when its required condition is not satisfied.

For the Baker:

```text
Pizza already available
        ↓
Producer cannot produce another one
        ↓
wait()
```

For the Eater:

```text
No pizza available
        ↓
Consumer cannot consume
        ↓
wait()
```

Therefore:

```text
Producer → wait when resource is full

Consumer → wait when resource is empty
```

---

### `notify()`

`notify()` signals a waiting thread after the shared resource's state has changed.

After the Baker produces:

```text
bake()
 ↓
baked = true
 ↓
notify()
```

The waiting Consumer can now potentially continue.

After the Eater consumes:

```text
eat()
 ↓
baked = false
 ↓
notify()
```

The waiting Producer can now potentially continue.

So communication happens in both directions:

```text
Baker
 ↓
produce
 ↓
notify()
 ↓
Eater

Eater
 ↓
consume
 ↓
notify()
 ↓
Baker
```

---

## 39.6 Final Concept

The final objective of inter-thread communication in this example is:

> **One value should be produced and that value should be consumed before the next value is produced.**

The ideal sequence is:

```text
Baker
 ↓
Produce 1
 ↓
baked = true
 ↓
notify()
 ↓
Eater
 ↓
Consume 1
 ↓
baked = false
 ↓
notify()
 ↓
Baker
 ↓
Produce 2
 ↓
baked = true
 ↓
notify()
 ↓
Eater
 ↓
Consume 2
 ↓
...
```

This creates controlled coordination between the two threads.

### Complete picture

```text
                         PizzaApp
                            ↓
                    Shared PizzaHouse
                            │
                  ┌─────────┴─────────┐
                  ↓                   ↓
                Baker               Eater
               Producer            Consumer
                  ↓                   ↓
               Runnable             Runnable
                  ↓                   ↓
                run()               run()
                  ↓                   ↓
               bake()               eat()
                  ↓                   ↓
           baked = true         baked = false
                  ↓                   ↓
               notify()              notify()
                  ↓                   ↑
                wait() ←─────────────┘
```

The core cycle is:

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
Producer produces next
```

**Memory trick:**

```text
Baker  →  Bake  →  TRUE  →  Notify
Eater  →  Eat   →  FALSE →  Notify

TRUE  = Pizza available
FALSE = Pizza unavailable
```

And the most important rule is:

**`wait()` and `notify()` are used for inter-thread communication and must be called while the appropriate object's monitor is held, normally inside a synchronized method or block.**
