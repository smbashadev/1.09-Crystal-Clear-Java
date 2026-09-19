# 33. Resource Locking / Nested Synchronization

Resource locking is an important concept in **multithreading and synchronization**.

When multiple threads work with the same application, they may need to access the same resources. If those resources are accessed without proper coordination, threads can interfere with one another.

In this topic, we use a **Library** example containing:

* Java Book
* Python Book
* JavaScript Book

Two threads, **Thor** and **Loki**, access these resources.

The main idea is:

> A thread can acquire the lock of one resource and then acquire the lock of another resource. This is called **nested synchronization/locking**.

---

## 33.1 Library Example

Consider a library containing three books:

```text
Library
│
├── Java Book
├── Python Book
└── JavaScript Book
```

In a multithreaded application, different threads may want to access these books.

For example:

```text
Thor  → Java Book → Python Book → JavaScript Book

Loki  → JavaScript Book → Python Book → Java Book
```

Here, the books represent **shared resources**.

A shared resource is something that can be accessed by more than one thread.

### Real-world examples of shared resources

The same idea occurs with:

* Bank account
* Printer
* File
* Database record
* Ticket inventory
* Library resource
* Shared memory
* Network resource

If two threads modify or use the same resource at the same time, synchronization may be required.

---

## 33.2 Why Resource Locking Is Required

Suppose two threads want to use the same resource.

```text
Thor  → Java Book
Loki  → Java Book
```

Without coordination, both threads could enter the protected operation at the same time.

Resource locking provides a mechanism for saying:

> "This resource is currently being used by one thread. Another thread must wait until the required lock becomes available."

Conceptually:

```text
Java Book
    ↓
Java Book Lock
    ↓
Thor acquires lock
    ↓
Thor uses resource
    ↓
Thor releases lock
    ↓
Loki can acquire lock
```

So locking provides controlled access to shared resources.

---

## 33.3 Thor

In our example, **Thor** needs to access all three books.

His resource-access sequence is:

```text
Thor
 ↓
Java Book
 ↓
Python Book
 ↓
JavaScript Book
```

Thor may therefore acquire locks in this order:

```text
Java Book Lock
      ↓
Python Book Lock
      ↓
JavaScript Book Lock
```

This is an example of **multiple resource locking**.

When one lock is acquired inside another synchronized section, the locks become nested.

---

## 33.4 Thor's Nested Synchronization

Consider:

```java
synchronized(javaBook) {

    synchronized(pythonBook) {

        synchronized(javaScriptBook) {

            System.out.println("Thor is reading");

        }
    }
}
```

The structure is:

```text
Lock Java Book
     ↓
Lock Python Book
     ↓
Lock JavaScript Book
     ↓
Read books
     ↓
Release JavaScript Book
     ↓
Release Python Book
     ↓
Release Java Book
```

Thor is holding the outer lock while acquiring the next lock.

That is the important idea behind nested locking.

---

## 33.5 Loki

Now consider **Loki**.

Suppose Loki accesses the resources in this order:

```text
Loki
 ↓
JavaScript Book
 ↓
Python Book
 ↓
Java Book
```

His locking structure can be:

```java
synchronized(javaScriptBook) {

    synchronized(pythonBook) {

        synchronized(javaBook) {

            System.out.println("Loki is reading");

        }
    }
}
```

So Loki's lock order is different from Thor's.

```text
Thor:
Java → Python → JavaScript

Loki:
JavaScript → Python → Java
```

This difference is extremely important.

---

## 33.6 Resource-Level Locking

Java allows us to specify the object whose monitor should be used:

```java
synchronized(resource) {

    // protected code
}
```

For example:

```java
synchronized(javaBook) {

    System.out.println("Reading Java Book");
}
```

Here:

```text
javaBook
   ↓
Java Book object
   ↓
Its monitor
   ↓
Lock used by synchronized
```

Similarly:

```java
synchronized(pythonBook) {

    // Python Book operation
}
```

uses the monitor associated with the Python Book object.

---

## 33.7 What Does `synchronized(resource)` Mean?

The syntax is:

```java
synchronized(object) {

    // critical section
}
```

The object supplied inside the parentheses acts as the **monitor/lock object** for that synchronized block.

For example:

```java
synchronized(javaBook) {

    System.out.println("Java Book is being accessed");
}
```

means that a thread must acquire the monitor associated with `javaBook` before entering the block.

If another thread attempts to enter another synchronized block using the **same `javaBook` object**, it must wait until the monitor becomes available.

---

## 33.8 `synchronized(this)` vs `synchronized(resource)`

These two are related but not identical.

### `synchronized(this)`

```java
synchronized(this) {

    // code
}
```

uses the current object's monitor.

Conceptually:

```text
this
 ↓
Current object
 ↓
Current object's monitor
```

### `synchronized(resource)`

```java
synchronized(resource) {

    // code
}
```

uses the specified resource object's monitor.

Conceptually:

```text
resource
 ↓
Resource object
 ↓
Resource object's monitor
```

Therefore:

```text
synchronized(this)
        ↓
Current object lock

synchronized(javaBook)
        ↓
Java Book object lock
```

---

## 33.9 Nested Synchronization

Nested synchronization means that one synchronized section contains another synchronized section.

Basic example:

```java
synchronized(resource1) {

    synchronized(resource2) {

        // protected operation

    }
}
```

The locking sequence is:

```text
Thread
  ↓
Acquire Resource 1 lock
  ↓
Acquire Resource 2 lock
  ↓
Perform operation
  ↓
Release Resource 2 lock
  ↓
Release Resource 1 lock
```

The second lock is acquired while the first lock is still being held.

---

## 33.10 Nested Locks With Three Resources

Our Library example has three resources.

```java
synchronized(javaBook) {

    synchronized(pythonBook) {

        synchronized(javaScriptBook) {

            // operation

        }
    }
}
```

Think of it like three doors:

```text
Door 1: Java Book
        ↓
Door 2: Python Book
        ↓
Door 3: JavaScript Book
        ↓
Actual operation
```

A thread must pass through the locks in the required order.

---

## 33.11 Thor's Complete Lock Flow

Thor executes:

```text
Thor
 ↓
Request Java Book lock
 ↓
Java Book lock acquired
 ↓
Request Python Book lock
 ↓
Python Book lock acquired
 ↓
Request JavaScript Book lock
 ↓
JavaScript Book lock acquired
 ↓
Read books
```

After the operation:

```text
Read complete
 ↓
Release JavaScript Book lock
 ↓
Release Python Book lock
 ↓
Release Java Book lock
```

The inner synchronized block completes before the outer synchronized block completes.

---

## 33.12 Loki's Complete Lock Flow

Loki executes:

```text
Loki
 ↓
Request JavaScript Book lock
 ↓
JavaScript Book lock acquired
 ↓
Request Python Book lock
 ↓
Python Book lock acquired
 ↓
Request Java Book lock
 ↓
Java Book lock acquired
 ↓
Read books
```

Then:

```text
Read complete
 ↓
Release Java Book lock
 ↓
Release Python Book lock
 ↓
Release JavaScript Book lock
```

So the two threads have different lock sequences.

---

## 33.13 Why Different Lock Sequences Are Dangerous

Suppose Thor gets:

```text
Java Book lock
```

and then waits for:

```text
Python Book lock
```

At the same time, Loki has:

```text
Python Book lock
```

and waits for:

```text
Java Book lock
```

Now:

```text
Thor
 ↓
Holds Java
 ↓
Needs Python
```

while:

```text
Loki
 ↓
Holds Python
 ↓
Needs Java
```

Neither can proceed.

This can create a **deadlock**.

---

## 33.14 Deadlock

A deadlock occurs when threads become stuck waiting for resources held by one another.

Conceptually:

```text
Thor
  │
  │ holds
  ↓
Java Lock
  │
  │ needs
  ↓
Python Lock
  ↑
  │ holds
  │
Loki
  │
  │ needs
  ↓
Java Lock
```

The circular dependency is:

```text
Thor waits for Loki
Loki waits for Thor
```

Therefore neither thread can continue.

---

## 33.15 Why Lock Ordering Matters

When a thread needs multiple locks, it is safer to establish a consistent order.

For example:

```text
1. Java Book
2. Python Book
3. JavaScript Book
```

Every thread should acquire them in that order:

```text
Thor:
Java → Python → JavaScript

Loki:
Java → Python → JavaScript
```

This reduces the possibility of circular waiting caused by inconsistent lock ordering.

---

## 33.16 Safe Lock Ordering

Instead of:

```text
Thor:
Java → Python → JavaScript

Loki:
JavaScript → Python → Java
```

use:

```text
Thor:
Java → Python → JavaScript

Loki:
Java → Python → JavaScript
```

Now both threads follow the same locking order.

Conceptually:

```text
Java
 ↓
Python
 ↓
JavaScript
```

The application has a predictable locking discipline.

---

## 33.17 Library Class

A simple Library class can contain the resources:

```java
class Library {

    Object javaBook = new Object();
    Object pythonBook = new Object();
    Object javaScriptBook = new Object();

}
```

Here we have three separate objects.

Therefore:

```text
javaBook
    ↓
Object 1
    ↓
Monitor 1

pythonBook
    ↓
Object 2
    ↓
Monitor 2

javaScriptBook
    ↓
Object 3
    ↓
Monitor 3
```

Each object can be used as a synchronization lock.

---

## 33.18 `thorReads()`

We can create a method for Thor:

```java
void thorReads() {

    synchronized(javaBook) {

        System.out.println("Thor locked Java Book");

        synchronized(pythonBook) {

            System.out.println("Thor locked Python Book");

            synchronized(javaScriptBook) {

                System.out.println("Thor locked JavaScript Book");

                System.out.println("Thor is reading");

            }
        }
    }
}
```

The method represents Thor's resource-access sequence.

---

## 33.19 Understanding `thorReads()`

The first block:

```java
synchronized(javaBook)
```

means:

> Thor must acquire the Java Book object's monitor.

Then:

```java
synchronized(pythonBook)
```

means:

> While still holding the Java Book lock, Thor tries to acquire the Python Book lock.

Then:

```java
synchronized(javaScriptBook)
```

means:

> While holding the previous locks, Thor tries to acquire the JavaScript Book lock.

So:

```text
Java lock
   ↓
Python lock
   ↓
JavaScript lock
   ↓
Reading
```

---

## 33.20 `lokiReads()`

Similarly:

```java
void lokiReads() {

    synchronized(javaScriptBook) {

        System.out.println("Loki locked JavaScript Book");

        synchronized(pythonBook) {

            System.out.println("Loki locked Python Book");

            synchronized(javaBook) {

                System.out.println("Loki locked Java Book");

                System.out.println("Loki is reading");

            }
        }
    }
}
```

Loki's sequence is:

```text
JavaScript
    ↓
Python
    ↓
Java
```

This demonstrates a different resource-locking sequence.

---

## 33.21 Reading Runnable

Now we can use `Runnable` to create the tasks.

```java
class LibraryTask implements Runnable {

    Library library;

    LibraryTask(Library library) {

        this.library = library;
    }

    public void run() {

        String name =
            Thread.currentThread().getName();

        if(name.equals("Thor")) {

            library.thorReads();

        }
        else {

            library.lokiReads();
        }
    }
}
```

The important concepts are:

```text
Runnable
 ↓
run()
 ↓
currentThread()
 ↓
getName()
 ↓
Identify thread
 ↓
Call appropriate method
```

---

## 33.22 `Thread.currentThread()`

Inside `run()`:

```java
Thread.currentThread()
```

returns the thread that is **currently executing the code**.

Suppose Thor is executing:

```text
Thread.currentThread()
        ↓
Thor thread
```

Suppose Loki is executing:

```text
Thread.currentThread()
        ↓
Loki thread
```

This allows the same Runnable implementation to determine which thread is currently running.

---

## 33.23 `getName()`

After obtaining the current thread:

```java
Thread.currentThread().getName()
```

gets its name.

For Thor:

```text
Thread.currentThread()
        ↓
Thor
        ↓
getName()
        ↓
"Thor"
```

For Loki:

```text
Thread.currentThread()
        ↓
Loki
        ↓
getName()
        ↓
"Loki"
```

---

## 33.24 Complete Runnable Program

```java
class Library {

    Object javaBook = new Object();
    Object pythonBook = new Object();
    Object javaScriptBook = new Object();


    void thorReads() {

        synchronized(javaBook) {

            System.out.println("Thor locked Java Book");

            synchronized(pythonBook) {

                System.out.println("Thor locked Python Book");

                synchronized(javaScriptBook) {

                    System.out.println(
                        "Thor locked JavaScript Book"
                    );

                    System.out.println(
                        "Thor is reading"
                    );
                }
            }
        }
    }


    void lokiReads() {

        synchronized(javaScriptBook) {

            System.out.println(
                "Loki locked JavaScript Book"
            );

            synchronized(pythonBook) {

                System.out.println(
                    "Loki locked Python Book"
                );

                synchronized(javaBook) {

                    System.out.println(
                        "Loki locked Java Book"
                    );

                    System.out.println(
                        "Loki is reading"
                    );
                }
            }
        }
    }
}


class LibraryTask implements Runnable {

    Library library;


    LibraryTask(Library library) {

        this.library = library;
    }


    public void run() {

        String name =
            Thread.currentThread().getName();


        if(name.equals("Thor")) {

            library.thorReads();

        }
        else {

            library.lokiReads();
        }
    }
}


public class LibraryApp {

    public static void main(String[] args) {

        Library library = new Library();

        LibraryTask task =
            new LibraryTask(library);

        Thread thor =
            new Thread(task);

        Thread loki =
            new Thread(task);

        thor.setName("Thor");
        loki.setName("Loki");

        thor.start();
        loki.start();
    }
}
```

---

## 33.25 Program Execution Flow

The program starts from:

```java
main()
```

Then:

```text
main()
 ↓
Create Library object
 ↓
Create LibraryTask object
 ↓
Create Thor thread
 ↓
Create Loki thread
 ↓
Set thread names
 ↓
thor.start()
 ↓
loki.start()
```

Both threads become eligible for execution.

---

## 33.26 Thor's Execution

If Thor gets CPU execution first:

```text
Thor
 ↓
run()
 ↓
getName()
 ↓
"Thor"
 ↓
thorReads()
 ↓
Lock Java Book
 ↓
Lock Python Book
 ↓
Lock JavaScript Book
 ↓
Read
```

After the inner operation finishes, the locks are released as the synchronized blocks exit.

---

## 33.27 Loki's Execution

If Loki gets CPU execution:

```text
Loki
 ↓
run()
 ↓
getName()
 ↓
"Loki"
 ↓
lokiReads()
 ↓
Lock JavaScript Book
 ↓
Lock Python Book
 ↓
Lock Java Book
 ↓
Read
```

The exact output order is not guaranteed because thread scheduling is not something you should assume will follow a fixed order.

---

## 33.28 Important Point About Thread Output

You should not assume:

```text
Thor always executes first
```

or:

```text
Loki always executes second
```

Calling:

```java
thor.start();
loki.start();
```

does not guarantee that Thor will completely execute before Loki.

The scheduler determines when each thread gets CPU time.

Therefore output may vary.

---

## 33.29 Resource Locking vs Thread Locking

A common misunderstanding is to say:

> "We are locking the thread."

That is not the correct idea here.

We are locking **an object/monitor associated with a resource**.

For example:

```java
synchronized(javaBook)
```

means the synchronization is based on the `javaBook` object.

The thread acquires the monitor; the resource object is the object being used as the lock.

Think:

```text
Thread
  ↓
tries to acquire
  ↓
Resource object's monitor
```

---

## 33.30 Every Java Object Can Act as a Monitor

Objects can be used for synchronization.

For example:

```java
Object javaBook = new Object();
```

can be used as:

```java
synchronized(javaBook) {

    // protected code
}
```

The important idea is:

```text
Java object
   ↓
Monitor associated with object
   ↓
Can participate in synchronized locking
```

This is why choosing appropriate lock objects matters.

---

## 33.31 Fine-Grained Resource Locking

Suppose we have:

```text
Java Book → Lock A
Python Book → Lock B
JavaScript Book → Lock C
```

This gives us separate locks for separate resources.

That is more fine-grained than locking the entire Library object for every operation.

Conceptually:

```text
Entire Library
      ↓
One large lock
```

versus:

```text
Java Book      → Lock A
Python Book    → Lock B
JavaScript     → Lock C
```

Fine-grained locking can allow more concurrency, but it also makes synchronization more complicated.

---

## 33.32 Advantage of Resource-Level Locking

Suppose:

```text
Thor → Java Book
Loki → Python Book
```

If the operations truly use independent resource locks, they may not need to block each other merely because they are both using the library.

Conceptually:

```text
Thor
 ↓
Java Book Lock

Loki
 ↓
Python Book Lock
```

Different monitors can allow greater concurrency.

This is one reason resource-level locking can be useful.

---

## 33.33 Disadvantage of Multiple Locks

The more locks an application uses, the more complicated the locking relationships become.

For example:

```text
Lock A
 ↓
Lock B
 ↓
Lock C
```

Now another thread might use:

```text
Lock C
 ↓
Lock B
 ↓
Lock A
```

This increases the possibility of circular waiting.

Therefore, fine-grained locking provides flexibility but requires careful design.

---

## 33.34 Common Mistake — Different Objects Mean Different Locks

Consider:

```java
Object a = new Object();
Object b = new Object();
```

Then:

```java
synchronized(a) {
}
```

and:

```java
synchronized(b) {
}
```

use different monitor objects.

Therefore, locking `a` does not automatically lock `b`.

Think:

```text
a → Monitor A

b → Monitor B
```

They are separate.

---

## 33.35 Common Mistake — Same Variable Name Is Not Enough

The important thing is whether the threads synchronize on the **same object instance**.

For example:

```java
synchronized(javaBook) {
}
```

If both threads use the same `javaBook` object:

```text
Thor → same javaBook object
Loki → same javaBook object
```

they compete for the same monitor.

But if they use different objects:

```text
Thor → JavaBook object A
Loki → JavaBook object B
```

they are not using the same monitor, even if the objects represent conceptually similar resources.

---

## 33.36 Interview Understanding

**Resource locking** is the practice of coordinating access to shared resources by using appropriate synchronization locks. In Java, a synchronized block can use a specific object as its monitor:

```java
synchronized(resource) {
    // critical section
}
```

**Nested synchronization** occurs when a thread acquires one lock and then acquires another lock while still holding the first lock:

```java
synchronized(resource1) {

    synchronized(resource2) {

        // operation
    }
}
```

In the Library example, Thor accesses:

```text
Java → Python → JavaScript
```

while Loki may access:

```text
JavaScript → Python → Java
```

If different threads acquire multiple locks in inconsistent orders, they can potentially create **deadlock** through circular waiting. A common strategy for avoiding this class of problem is to establish a consistent lock-acquisition order.

### Final memory picture

```text
             LIBRARY
                │
       ┌────────┼────────┐
       ↓        ↓        ↓
     Java     Python   JavaScript
      Book      Book      Book
       │        │        │
      Lock     Lock     Lock
       │        │        │
       └────────┼────────┘
                │
       Resource-level locking
                │
        Nested synchronization
                │
       ┌────────┴────────┐
       ↓                 ↓
     THOR               LOKI
       ↓                 ↓
 Java→Python→JS     JS→Python→Java
       │                 │
       └────────┬────────┘
                ↓
       Lock ordering matters
                ↓
       Inconsistent order
                ↓
       Possible deadlock
```

**Core idea to remember:**
`synchronized(resource)` means **use that resource object as the monitor for the synchronized block**. When one synchronized block is placed inside another, a thread can hold multiple locks at the same time. The more locks a thread holds, the more important proper lock ordering becomes.
