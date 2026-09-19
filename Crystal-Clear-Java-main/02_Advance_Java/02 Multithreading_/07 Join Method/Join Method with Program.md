# 🧒 25. Join Method

### 1. Basic Idea

The `join()` method is used when **one thread needs to wait for another thread to finish**.

The most common situation is:

```text
Main Thread
    ↓
starts another thread
    ↓
waits using join()
    ↓
other thread finishes
    ↓
main thread continues
```

The easiest sentence to remember is:

> **`join()` means: “Wait for this thread to finish before continuing.”**

---

### 2. Why `join()` Is Needed

Normally, when the main thread starts another thread, both can continue executing independently.

For example:

```text
Main Thread          Java Session Thread
     ↓                       ↓
Meeting started        Session starts
     ↓                       ↓
Meeting ended          Students attend
                             ↓
                        Students leave
```

Here, the main thread might print **“Meeting ended” before the Java session has actually finished**.

That may be incorrect for the application's requirement.

We can use `join()` to make the main thread wait.

---

### 3. Simple Real-World Analogy

Imagine a teacher starts an online class.

```text
Teacher
   ↓
Starts class
   ↓
Waits until students leave
   ↓
Ends meeting
```

The teacher should not announce:

> “The meeting has ended”

while students are still attending.

So the teacher waits.

In Java:

```text
start()
   ↓
Start session thread

join()
   ↓
Wait for session thread

session completes
   ↓
Meeting ends
```

---

### 4. What `join()` Means

Suppose we have:

```java
t1.start();
t1.join();
```

The meaning is:

```text
t1.start()
    ↓
Start t1
    ↓
t1 performs its work

t1.join()
    ↓
Current thread waits
    ↓
t1 finishes
    ↓
Current thread continues
```

If the current thread is `main`, then **the main thread waits for `t1` to complete**.

---

### 5. `join()` Belongs to Thread

`join()` is a method of the predefined `Thread` class.

For example:

```java
t1.join();
```

Here `t1` is a `Thread` object.

Therefore, the method is called on the thread that we want to wait for.

```text
t1.join()
   ↓
Wait for t1
```

---

### 6. Understanding the Word "Joining"

The word **join** can be confusing.

In multithreading, think of it as:

```text
Current execution
       ↓
wait here
       ↓
another thread completes
       ↓
execution continues
```

It is like saying:

> “I will continue after you finish.”

---

### 7. Without `join()`

Consider:

```java
System.out.println("Meeting started");

t1.start();

System.out.println("Meeting ended");
```

Possible output:

```text
Meeting started
Meeting ended
Students attend
Students leave
```

This means the main thread did not wait for the session thread.

The meeting appears to end while students are still attending.

---

### 8. With `join()`

Now:

```java
System.out.println("Meeting started");

t1.start();

t1.join();

System.out.println("Meeting ended");
```

The flow becomes:

```text
Meeting started
      ↓
t1 starts
      ↓
t1 performs session
      ↓
Students attend
      ↓
Students leave
      ↓
t1 finishes
      ↓
join() completes
      ↓
Meeting ended
```

This gives us the required order.

---

### 9. `ZoomApps` Example

Let us imagine a simple Zoom-like application.

The application has:

```text
Main Thread
    ↓
Meeting management

Java Session Thread
    ↓
Students attend Java session
```

The main thread starts the Java session and should wait until the session is finished before declaring that the meeting has ended.

---

### 10. Creating the `JavaSession` Task

We can create a Runnable task:

```java
class JavaSession implements Runnable {

    public void run() {

        System.out.println("Students attend");

    }
}
```

The `run()` method contains the work performed by the session thread.

---

### 11. Adding Session Activities

We can make the example more realistic:

```java
class JavaSession implements Runnable {

    public void run() {

        System.out.println("Students attend");

        System.out.println("Students leave");

    }
}
```

The session thread performs:

```text
Students attend
       ↓
Students leave
       ↓
run() ends
```

---

### 12. Creating the Runnable Object

Inside `main()`:

```java
JavaSession task = new JavaSession();
```

This creates the task object.

```text
task
 ↓
JavaSession
 ↓
Runnable task
```

The task defines what the session thread should do.

---

### 13. Creating the Thread Object

Now:

```java
Thread t1 = new Thread(task);
```

This creates a `Thread` object associated with the Java session task.

```text
JavaSession task
       ↓
Thread t1
       ↓
Java session execution
```

---

### 14. Meeting Started

The main thread first prints:

```java
System.out.println("Meeting started");
```

Output:

```text
Meeting started
```

This represents the beginning of the online meeting.

---

### 15. Calling `start()`

Then:

```java
t1.start();
```

starts the Java session thread.

The flow is:

```text
t1.start()
    ↓
Java session thread starts
    ↓
run()
    ↓
Students attend
```

At this point, the session thread can execute independently.

---

### 16. Calling `join()`

Now:

```java
t1.join();
```

is called.

This tells the current thread:

> “Wait until `t1` has completed.”

If `main()` is the current thread:

```text
Main Thread
    ↓
t1.join()
    ↓
WAIT
```

The main thread does not continue to the next statement until `t1` finishes.

---

### 17. What Happens During `join()`?

Suppose:

```text
Main Thread
    ↓
t1.join()
```

and `t1` is still working.

Then:

```text
Main Thread          t1
    ↓                 ↓
   WAIT          Students attend
    ↓                 ↓
   WAIT          Students leave
    ↓                 ↓
   WAIT             DONE
    ↓
CONTINUE
```

This is the heart of the `join()` concept.

---

### 18. Meeting Ended

After `t1` finishes, `join()` allows the main thread to continue.

Then:

```java
System.out.println("Meeting ended");
```

executes.

So the output becomes:

```text
Meeting started
Students attend
Students leave
Meeting ended
```

This ordering is the purpose of using `join()` here.

---

### 19. Complete `ZoomApps` Program

```java
class JavaSession implements Runnable {

    public void run() {

        System.out.println("Students attend");

        System.out.println("Students leave");

    }
}


public class ZoomApps {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("Meeting started");

        JavaSession task = new JavaSession();

        Thread t1 = new Thread(task);

        t1.start();

        t1.join();

        System.out.println("Meeting ended");
    }
}
```

---

### 20. Why `InterruptedException` Appears

The `join()` method can result in a checked exception called:

```text
InterruptedException
```

Therefore, our `main()` method can declare:

```java
throws InterruptedException
```

So:

```java
public static void main(String[] args)
        throws InterruptedException
```

means that if the waiting thread is interrupted, the exception is passed to the caller/runtime rather than being handled inside `main()`.

Alternatively, we could use `try-catch`.

```java
try {
    t1.join();
}
catch (InterruptedException e) {
    System.out.println("Main thread interrupted");
}
```

---

### 21. Complete Execution Flow

The complete execution is:

```text
main()
  ↓
Meeting started
  ↓
Create JavaSession task
  ↓
Create Thread t1
  ↓
t1.start()
  ↓
Java session thread begins
  ↓
Students attend
  ↓
Students leave
  ↓
Thread completes
  ↓
t1.join() finishes waiting
  ↓
Meeting ended
```

This exactly matches the required meeting scenario.

---

### 22. Main Thread Waiting

One of the most important points is:

```java
t1.join();
```

does **not mean t1 waits for main**.

It means the **current thread waits for t1**.

If `main()` calls:

```java
t1.join();
```

then:

```text
main thread → waits for t1
```

This distinction is very important.

---

### 23. `join()` Does Not Stop the Other Thread

Another common confusion is thinking that `join()` stops `t1`.

It does not.

When we write:

```java
t1.join();
```

`t1` continues doing its work.

The thread that waits is the **current thread**.

```text
t1
 ↓
continues working

main
 ↓
waits
```

After `t1` finishes:

```text
t1 → DONE
main → continues
```

---

### 24. Simple Timeline

Without `join()`:

```text
Time →
Main:    Meeting started ── Meeting ended
Thread:                ── Attend ── Leave
```

With `join()`:

```text
Time →
Main:    Meeting started ── WAIT ───────── Meeting ended
Thread:                  ── Attend ── Leave ── DONE
```

The main thread cannot reach **“Meeting ended”** until the session thread completes.

---

### 25. `start()` and `join()` Together

These two methods have different jobs.

```java
t1.start();
t1.join();
```

Think:

```text
start()
  ↓
"Begin your work."

join()
  ↓
"I will wait until your work is finished."
```

Therefore:

```text
start → begin
join  → wait for completion
```

This is an excellent memory trick.

---

### 26. Real-World Example

Imagine downloading a file.

```text
Main application
      ↓
Start download
      ↓
Download thread works
      ↓
Main waits
      ↓
Download completed
      ↓
Continue application
```

If the application needs the downloaded file before continuing, it can use the equivalent idea of waiting for the worker thread to finish.

Similarly, in our Zoom example:

```text
Meeting starts
      ↓
Session starts
      ↓
Students attend
      ↓
Students leave
      ↓
Session completes
      ↓
Meeting ends
```

---

### 27. Another Example: Exam Application

Imagine an online examination system.

```text
Main Thread
    ↓
Start exam
    ↓
Exam Thread
    ↓
Student writes exam
    ↓
Student submits
    ↓
Exam thread completes
    ↓
Main thread continues
    ↓
Show exam completed
```

Using `join()` ensures that the main thread does not announce completion before the exam task has finished.

---

### 28. Important Rules

* `join()` is a method of the `Thread` class.
* `join()` makes the current thread wait for another thread to finish.
* `t1.join()` means the current thread waits for `t1`.
* `join()` does not stop the target thread.
* The target thread continues executing while the current thread waits.
* Once the target thread completes, the waiting thread continues.
* `start()` starts the thread.
* `join()` waits for that thread's completion.
* `start()` and `join()` have different purposes.
* `join()` can throw `InterruptedException`.
* The exact output of concurrent threads can vary, but statements after `join()` execute only after the joined thread has completed.
* If `main()` calls `t1.join()`, the main thread waits for `t1`.

---

### 29. Common Mistake: Thinking `join()` Starts the Thread

This is incorrect:

```java
t1.join();
```

`join()` does not start the thread.

Correct sequence:

```java
t1.start();
t1.join();
```

First:

```text
start → begin thread
```

Then:

```text
join → wait for thread
```

---

### 30. Common Mistake: Thinking `join()` Makes Main Finish First

It is the opposite.

Suppose:

```java
t1.start();

t1.join();

System.out.println("Meeting ended");
```

The final message cannot execute until `t1` finishes.

Therefore:

```text
t1 work
   ↓
t1 finishes
   ↓
join returns
   ↓
Meeting ended
```

---

### 31. Common Mistake: Thinking `join()` Makes Threads Sequential From the Beginning

`join()` does not prevent concurrency from starting.

For example:

```java
t1.start();
t1.join();
```

`t1` is running while `main` waits.

The important point is that **the waiting happens after `start()`**.

So:

```text
start
 ↓
t1 runs

join
 ↓
main waits
```

---

### 32. Important Comparison

| Method    | Purpose                                          |
| --------- | ------------------------------------------------ |
| `start()` | Starts a new thread                              |
| `run()`   | Contains the thread's task                       |
| `join()`  | Makes the current thread wait for another thread |
| `sleep()` | Pauses the currently executing thread            |

A very easy memory table:

```text
start() → START
run()   → WORK
join()  → WAIT
sleep() → PAUSE
```

---

### 33. Memory Trick

Remember the four words:

```text
START → WORK → WAIT → CONTINUE
```

For our program:

```text
t1.start()
    ↓
Java session begins
    ↓
run()
    ↓
Students attend
    ↓
Students leave
    ↓
t1.join()
    ↓
Main waits until t1 finishes
    ↓
Meeting ended
```

The strongest memory sentence is:

> **`start()` says “go”, `run()` says “do the work”, and `join()` says “I will wait until you finish.”**

---

### 34. Interview Understanding

The `join()` method in Java is used when one thread needs to wait for another thread to complete. For example, in a Zoom-like application, the main thread can print **“Meeting started”**, create and start a Java session thread, and then call `t1.join()`. At that point, the main thread waits while `t1` performs its work, such as students attending and leaving the session. After `t1` completes, `join()` finishes waiting, and the main thread continues to print **“Meeting ended.”** Therefore, `join()` is useful when the next operation depends on the completion of another thread.

---

### 35. Complete Mental Picture

```text
                 ZoomApps
                    ↓
                  main()
                    ↓
            Meeting started
                    ↓
          Create JavaSession
                    ↓
             Create t1
                    ↓
               t1.start()
                    ↓
        ┌─────────────────────┐
        │   Java Session      │
        │                     │
        │ Students attend     │
        │        ↓            │
        │ Students leave      │
        │        ↓            │
        │ Thread completes    │
        └─────────────────────┘
                    ↑
                    │
                t1.join()
                    │
             Main thread waits
                    ↓
            Meeting ended
```

---

### 36. Lifetime Memory

```text
JOIN METHOD
     ↓
Start another thread
     ↓
start()
     ↓
Thread performs its work
     ↓
Current thread calls join()
     ↓
Current thread WAITS
     ↓
Other thread continues working
     ↓
Other thread finishes
     ↓
join() completes
     ↓
Waiting thread CONTINUES
```

For the **ZoomApps** example:

```text
Meeting started
       ↓
Java session starts
       ↓
Students attend
       ↓
Students leave
       ↓
Java session completes
       ↓
main thread finishes waiting
       ↓
Meeting ended
```

**Remember forever:**

> **`join()` does not mean “join the threads together.” It means “wait for this thread to finish before the current thread continues.”**
