# 🧒 20. Need for Multithreading

### 1. Basic Idea

A computer has a **CPU/processor** that executes program instructions.

Different applications need CPU time to perform their work.

For example:

```text
Eclipse
Chrome
VLC
Paint
```

All these applications need the processor to execute their tasks.

---

### 2. CPU / Processor Time

The CPU cannot simply give unlimited execution time to every task.

Each application needs an opportunity to use the processor.

Think of the CPU as a **single teacher** and applications as students waiting for the teacher's attention.

```text
CPU
 ↓
Eclipse
 ↓
Chrome
 ↓
VLC
 ↓
Paint
```

The operating system manages this access.

---

### 3. Why Applications Need CPU Time

An application contains instructions that must actually be executed.

For example, Eclipse may need the CPU to:

```text
Check Java syntax
Process keyboard input
Display results
```

Chrome may need it to:

```text
Process a webpage
Handle user input
Update the screen
```

VLC may need it to:

```text
Process audio
Process video
Buffer media
```

Each task requires processor execution time.

---

### 4. The Problem With a Single Thread

A single thread provides one line of execution.

```text
Task 1
  ↓
Task 2
  ↓
Task 3
  ↓
Task 4
```

The next task follows the execution of the previous task.

This can become inefficient when one task has to wait.

---

### 5. One Subtask at a Time

Suppose an application has these tasks:

```text
Typing
Syntax checking
Saving
```

With one execution path:

```text
Typing
 ↓
Syntax checking
 ↓
Saving
```

The tasks are handled sequentially.

One subtask completes or reaches a waiting point before the next one gets its opportunity.

---

### 6. Simple Real-World Analogy

Imagine one worker has three jobs:

```text
Job A → Download file
Job B → Play music
Job C → Accept user input
```

If the worker handles everything strictly one after another:

```text
Job A
 ↓
Job B
 ↓
Job C
```

the other jobs have to wait.

Having multiple workers makes it possible to handle different activities concurrently.

Threads are similar to these workers.

---

### 7. CPU Time May Be Wasted

Some tasks do not continuously need the CPU.

For example, a task may be waiting for:

```text
Input
File data
Network data
Buffer data
```

During such waiting periods, a single execution path may not make useful progress.

This is one reason multithreading can improve the utilization and responsiveness of an application.

---

### 8. Waiting Task Example

Imagine VLC is waiting for more video data to arrive into its buffer.

```text
VLC
 ↓
Waiting for data
```

At the same time, another task may be able to use processor time.

With appropriate multithreading, different threads can make progress on different activities.

---

### 9. Application Waiting for Thread Scheduling

The **thread scheduler** decides which eligible thread gets processor execution time.

A thread may therefore have to wait for its turn.

Conceptually:

```text
Thread A
   ↓
uses CPU
   ↓
Thread B
   ↓
uses CPU
   ↓
Thread C
```

The scheduler manages these opportunities.

---

### 10. Thread Scheduler

A **thread scheduler** is responsible for selecting threads for processor execution.

Its basic job can be remembered as:

```text
Threads waiting
      ↓
Thread Scheduler
      ↓
Selects a thread
      ↓
Processor executes it
```

---

### 11. Scheduler as a Traffic Police Officer

Imagine several vehicles reaching a narrow road.

A traffic police officer decides which vehicle can move.

Similarly:

```text
Threads
  ↓
Scheduler
  ↓
Which thread gets CPU time?
```

The scheduler helps manage access to processor execution.

---

### 12. Allocating Processor Execution Time

The thread scheduler allocates processor execution opportunities among threads according to the operating system's scheduling mechanisms.

Conceptually:

```text
CPU
 ↑
Scheduler
 ↑
T1   T2   T3
```

The scheduler selects a thread to run.

---

### 13. Choosing a Thread

Suppose an application has:

```text
Thread 1 → Typing
Thread 2 → Syntax checking
Thread 3 → File processing
```

The scheduler determines which thread gets an opportunity to execute.

The conceptual flow is:

```text
Thread 1 ─┐
Thread 2 ─┼→ Scheduler → CPU
Thread 3 ─┘
```

---

### 14. Why Multithreading Helps

Instead of forcing one thread to perform every activity:

```text
One Thread
 ↓
Typing
 ↓
Syntax checking
 ↓
Buffering
```

an application can have separate execution paths:

```text
Application
 ├── Thread → Typing
 ├── Thread → Syntax checking
 └── Thread → Buffering
```

This allows the application to make progress on different activities concurrently.

---

## 20.4 Applications Shown

### 15. Eclipse

Eclipse is a development environment used for programming.

While a programmer is working, several activities may be involved.

For example:

```text
Eclipse
 ↓
Typing code
 ↓
Syntax checking
```

The application must remain responsive while processing these activities.

---

### 16. Eclipse — Syntax Check

When Java code is typed, the development environment can perform syntax-related processing.

For example:

```java
int x = ;
```

contains an incomplete statement.

The editor can identify the problem.

Conceptually:

```text
Code typed
   ↓
Syntax checking
   ↓
Error detected
```

---

### 17. Eclipse — Typing

When the programmer presses a key:

```text
Keyboard
   ↓
Eclipse
   ↓
Character appears
```

The application needs to process this input promptly.

This is an example of an activity that should remain responsive while other work is also occurring.

---

### 18. Google Chrome

Google Chrome is a web browser.

While using Chrome, many activities can occur:

```text
Open webpage
Process webpage
Accept keyboard/mouse input
Update displayed content
```

The browser needs to manage these activities efficiently.

---

### 19. VLC Media Player

VLC Media Player handles media such as audio and video.

For example:

```text
VLC
 ├── Play music
 ├── Play video
 └── Buffer
```

These are different activities associated with media playback.

---

### 20. Paint

Paint is an application for creating and editing images.

While using it, the application may need to:

```text
Receive mouse input
Draw on screen
Update the image
```

The application needs to respond to user actions while processing its other work.

---

## 20.5 Tasks

### 21. Syntax Check

**Syntax checking** means examining code to identify syntax-related problems.

Example:

```java
int number = ;
```

The statement is incomplete.

Conceptually:

```text
Java code
   ↓
Syntax check
   ↓
Problem detected
```

---

### 22. Typing

Typing means receiving keyboard input from the user.

For example, when a programmer types:

```text
System.out.println("Hello");
```

the application processes those keystrokes.

```text
Keyboard
   ↓
Typing
   ↓
Application processes input
```

---

### 23. Play Music

A media player may need to process audio while the user continues interacting with the application.

```text
Music
 ↓
Audio processing
 ↓
Speaker
```

The application should continue handling other activities as appropriate.

---

### 24. Play Video

Video playback requires continuous processing of video data.

Conceptually:

```text
Video data
   ↓
Processing
   ↓
Display frames
   ↓
Screen
```

The player needs to keep the playback progressing.

---

### 25. Buffer

**Buffering** means temporarily storing data so that it can be processed or played smoothly.

For example, while streaming a video:

```text
Internet data
     ↓
Buffer
     ↓
Video player
     ↓
Screen
```

If the player needs more data, it may wait while additional data is received.

---

### 26. Why Buffering Matters

Suppose a video needs data faster than the network is currently providing it.

```text
Video needs data
       ↓
Not enough data
       ↓
Buffer more data
```

The player may temporarily pause playback while additional data becomes available.

This shows why applications often have multiple activities that need to be managed.

---

### 27. Single-Threaded View of the Tasks

Imagine one thread handling everything:

```text
Typing
  ↓
Syntax check
  ↓
Play music
  ↓
Play video
  ↓
Buffer
```

The activities form one execution sequence.

This can make the application less responsive when one activity takes time or waits.

---

### 28. Multithreaded View

With multiple threads, the conceptual organization can be:

```text
Application
      ↓
 ┌────┼────────┐
 ↓    ↓        ↓
T1   T2        T3
 ↓    ↓        ↓
Typing  Music  Video
          ↓      ↓
       Playback Buffer
```

The exact implementation depends on the application, but the important idea is that multiple threads provide multiple execution paths.

---

### 29. CPU and Multiple Threads

Suppose three threads exist:

```text
T1 → Typing
T2 → Syntax checking
T3 → Buffering
```

The scheduler manages their opportunities to execute.

```text
T1 ─┐
T2 ─┼→ Scheduler → CPU
T3 ─┘
```

The CPU executes instructions from the selected thread.

---

### 30. Rapid Switching

On a processor where only one execution context is active at a given instant, the system can rapidly switch execution between threads.

Conceptually:

```text
T1 → T2 → T1 → T3 → T2 → T1
```

The switching can happen so quickly that the activities appear to happen simultaneously.

On a multicore processor, some threads can also execute truly in parallel.

---

### 31. What Happens When One Thread Waits?

Suppose one thread is waiting for data:

```text
Thread 1 → Waiting for input
```

Another thread may still be able to make progress:

```text
Thread 1 → Waiting
Thread 2 → Working
```

This is an important advantage of having multiple execution paths.

---

### 32. Complete Application Example

Imagine using Eclipse while VLC is playing music.

The computer is managing:

```text
Eclipse
 ├── Typing
 └── Syntax checking

VLC
 ├── Play music
 └── Buffer
```

The operating system manages the processes and their threads, while the scheduler determines which runnable threads receive processor time.

---

### 33. Important Difference

Do not think:

> "Multithreading means one CPU literally executes every thread at exactly the same instant."

That is not always true.

A single processor core can switch rapidly between execution contexts, while multiple processor cores can execute multiple threads simultaneously.

```text
One core:
T1 → T2 → T1 → T3

Multiple cores:
Core 1 → T1
Core 2 → T2
```

---

### 34. Important Rules

* Applications need processor execution time to perform their work.
* A single thread provides one execution path.
* Strictly sequential execution can make one task wait behind another.
* Some tasks spend time waiting for input, data, or other resources.
* The thread scheduler selects threads for processor execution.
* Multithreading provides multiple execution paths within an application.
* Concurrent execution does not necessarily mean actual simultaneous execution.
* Parallel execution can occur when multiple processor cores execute tasks at the same time.
* Eclipse can perform activities such as typing and syntax checking.
* VLC can handle activities such as music/video playback and buffering.
* Buffering temporarily stores data for smoother processing or playback.
* `Thread.sleep()` pauses the currently executing thread; it does not create a new thread.

---

### 35. Memory Trick

Remember the need for multithreading as:

```text
ONE THREAD
    ↓
ONE EXECUTION PATH
    ↓
TASKS WAIT
    ↓
LESS RESPONSIVE WHEN WORK/WAITING BLOCKS PROGRESS
```

Then:

```text
MULTITHREADING
       ↓
MULTIPLE EXECUTION PATHS
       ↓
DIFFERENT TASKS CAN MAKE PROGRESS
       ↓
BETTER RESPONSIVENESS / UTILIZATION
```

And remember the applications:

```text
Eclipse → Typing + Syntax Check

Chrome → Browser Activities

VLC → Music + Video + Buffer

Paint → User Input + Drawing
```

---

### 36. Interview Understanding

The need for multithreading arises because applications often have multiple activities that need to make progress without forcing every activity into one strictly sequential execution path. A single thread provides one execution path, while multiple threads provide multiple execution paths within an application. The thread scheduler manages which runnable thread gets processor execution time. On a single processor core, rapid switching can create the appearance of simultaneous execution; on multicore systems, multiple threads can also execute in parallel. Examples include Eclipse handling typing and syntax checking, and VLC handling media playback and buffering.
