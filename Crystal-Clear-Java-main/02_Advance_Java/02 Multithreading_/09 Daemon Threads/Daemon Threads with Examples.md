# 27. Daemon Threads

### 1. Basic Idea

A **daemon thread** is a thread that works in the **background to support another important thread**.

It is not usually responsible for the main work of the application.

Think of an application like a video broadcasting system:

```text
Main / Major Thread
        ↓
Video Broadcasting
        ↓
Important work
```

Behind it, other threads may provide support:

```text
NetworkStabilizzer
        ↓
Keeps network stable

VideoEnhancer
        ↓
Improves video quality
```

These supporting threads can be made **daemon threads**.

The central idea is:

> **A daemon thread performs background/supporting work while the main application is running.**

---

### 2. What Does "Supportive Thread" Mean?

A supportive thread is a thread whose job is to **help another important activity**.

For example:

```text
VideoBroadCast
      ↑
      │
 ┌────┴─────┐
 │          │
Network   Video
Stabilizzer Enhancer
```

The main activity is:

```text
VideoBroadCast
```

The supporting activities are:

```text
NetworkStabilizzer
VideoEnhancer
```

They help the main activity, but they are not the primary purpose of the application.

---

### 3. Real-World Analogy

Imagine a cricket match.

The main activity is:

```text
Cricket Match
```

There are people supporting the match:

```text
Ground Staff
Medical Team
Security Team
```

The match is the major activity.

The supporting teams help while the match is happening.

If the match ends, there is no reason for the match-support activities to continue indefinitely.

Daemon threads work with a similar idea:

```text
Major activity
      ↓
Main thread

Supporting activities
      ↓
Daemon threads
```

---

### 4. Why Do We Need Daemon Threads?

Suppose a video broadcasting application has three threads:

```text
VideoBroadCast
NetworkStabilizzer
VideoEnhancer
```

All three are running concurrently.

But the actual purpose of the application is:

```text
VideoBroadCast
```

The other two are supporting it.

If the video broadcasting activity ends, the supporting background activities may no longer be necessary.

Daemon threads provide a mechanism for this type of background support.

---

### 5. Major Thread and Supporting Threads

For our example:

```text
             Video Application
                    ↓
             VideoBroadCast
                    ↓
              MAJOR THREAD
                    |
          ┌─────────┴─────────┐
          ↓                   ↓
NetworkStabilizzer      VideoEnhancer
     SUPPORT                 SUPPORT
```

The major activity is:

```text
VideoBroadCast
```

The supporting activities are:

```text
NetworkStabilizzer
VideoEnhancer
```

---

### 6. `VideoBroadCast`

`VideoBroadCast` represents the major activity of broadcasting video.

For example:

```java
class VideoBroadCast implements Runnable {

    public void run() {

        // Video broadcasting activity

    }
}
```

Its job is to perform the main work:

```text
VideoBroadCast
       ↓
Broadcast video
```

This is the activity that we want to continue as the major operation.

---

### 7. `NetworkStabilizzer`

`NetworkStabilizzer` represents a supporting task that helps maintain network stability.

For example:

```java
class NetworkStabilizzer implements Runnable {

    public void run() {

        // Network stabilization activity

    }
}
```

Its conceptual responsibility is:

```text
NetworkStabilizzer
        ↓
Support network stability
        ↓
Help video broadcasting
```

It is not the main purpose of the application.

---

### 8. `VideoEnhancer`

`VideoEnhancer` represents another supporting task.

Its purpose is to support video quality.

```text
VideoEnhancer
      ↓
Improve/support video quality
      ↓
Help VideoBroadCast
```

So our three activities are:

```text
VideoBroadCast
    ↓
Main activity

NetworkStabilizzer
    ↓
Supporting activity

VideoEnhancer
    ↓
Supporting activity
```

---

### 9. Three Threads

Suppose we create:

```text
Thread 1 → VideoBroadCast
Thread 2 → NetworkStabilizzer
Thread 3 → VideoEnhancer
```

They can execute concurrently.

Conceptually:

```text
Time →
VideoBroadCast       ███████████████████
NetworkStabilizzer   █████████████████
VideoEnhancer        ██████████████████
```

The operating system and Java thread scheduler decide when each thread gets execution time.

---

### 10. Concurrent Execution

**Concurrent execution** means multiple threads make progress during overlapping periods of time.

For example:

```text
VideoBroadCast
       ↓
Broadcasting

NetworkStabilizzer
       ↓
Stabilizing network

VideoEnhancer
       ↓
Enhancing video
```

These activities can overlap.

Therefore:

```text
Three threads
      ↓
Concurrent execution
```

---

### 11. Output Order Cannot Be Predicted

If all three threads print messages, you should not assume that the output will always appear in exactly the same order.

One execution could produce:

```text
Video Broadcasting
Network Stabilization
Video Enhancement
```

Another execution might produce:

```text
Network Stabilization
Video Broadcasting
Video Enhancement
```

Another might produce:

```text
Video Enhancement
Video Broadcasting
Network Stabilization
```

The scheduling order can vary.

---

### 12. The Problem With Normal Threads

Suppose all three are normal threads:

```text
VideoBroadCast       → normal
NetworkStabilizzer   → normal
VideoEnhancer        → normal
```

The supporting threads are still normal threads.

This means they are not automatically treated as background work that can be discarded when the major application work finishes.

For our example, this creates a conceptual problem:

```text
VideoBroadCast
       ↓
Main activity finishes

But...

NetworkStabilizzer
       ↓
Still running

VideoEnhancer
       ↓
Still running
```

The supporting activities may continue even though their main purpose has ended.

---

### 13. The Daemon Solution

We can make the supporting threads daemon threads:

```text
VideoBroadCast
       ↓
Major / main thread
       ↓
Normal thread

NetworkStabilizzer
       ↓
Daemon thread

VideoEnhancer
       ↓
Daemon thread
```

Now the relationship becomes:

```text
             VideoBroadCast
               MAIN WORK
                   ↓
          ┌────────┴────────┐
          ↓                 ↓
 NetworkStabilizzer   VideoEnhancer
     DAEMON               DAEMON
```

---

### 14. Setting a Thread as Daemon

Java provides:

```java
setDaemon(true);
```

For example:

```java
Thread t2 = new Thread(networkTask);

t2.setDaemon(true);
```

This tells Java:

> Treat `t2` as a daemon thread.

Similarly:

```java
Thread t3 = new Thread(enhancerTask);

t3.setDaemon(true);
```

makes `t3` a daemon thread.

---

### 15. Meaning of `setDaemon(true)`

Break it into pieces:

```text
setDaemon()
     ↓
Set whether the thread is a daemon
```

And:

```text
true
     ↓
Yes
```

Therefore:

```java
t2.setDaemon(true);
```

means:

> Set `t2` as a daemon thread.

---

### 16. Important Timing Rule

The daemon status should be set **before the thread is started**.

Correct:

```java
Thread t2 = new Thread(task);

t2.setDaemon(true);

t2.start();
```

The order is:

```text
Create thread
     ↓
Set daemon = true
     ↓
Start thread
```

Do not wait until after starting the thread to decide that it should be a daemon.

---

### 17. Video Broadcasting Example

Imagine:

```text
VideoBroadCast
NetworkStabilizzer
VideoEnhancer
```

We want:

```text
VideoBroadCast → major work
NetworkStabilizzer → background support
VideoEnhancer → background support
```

So:

```text
VideoBroadCast
      ↓
Normal thread

NetworkStabilizzer
      ↓
Daemon thread

VideoEnhancer
      ↓
Daemon thread
```

---

### 18. Complete Conceptual Program

```java
class VideoBroadCast implements Runnable {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Video Broadcasting");

        }
    }
}


class NetworkStabilizzer implements Runnable {

    public void run() {

        for (;;) {

            System.out.println("Network Stabilization");

        }
    }
}


class VideoEnhancer implements Runnable {

    public void run() {

        for (;;) {

            System.out.println("Video Enhancement");

        }
    }
}


public class VideoApps {

    public static void main(String[] args) {

        VideoBroadCast videoTask = new VideoBroadCast();
        NetworkStabilizzer networkTask =
                new NetworkStabilizzer();
        VideoEnhancer enhancerTask =
                new VideoEnhancer();

        Thread video =
                new Thread(videoTask);

        Thread network =
                new Thread(networkTask);

        Thread enhancer =
                new Thread(enhancerTask);

        network.setDaemon(true);
        enhancer.setDaemon(true);

        video.start();
        network.start();
        enhancer.start();
    }
}
```

---

### 19. Understanding the Main Thread

When `main()` begins:

```java
public static void main(String[] args)
```

the `main` thread is executing.

Then it creates:

```text
video
network
enhancer
```

The intended structure is:

```text
main()
  ↓
Create three thread objects
  ↓
Configure daemon status
  ↓
Start threads
```

---

### 20. Setting the Supporting Threads as Daemon

These statements are important:

```java
network.setDaemon(true);
enhancer.setDaemon(true);
```

They mean:

```text
network
   ↓
Daemon = true

enhancer
   ↓
Daemon = true
```

But:

```java
video.setDaemon(true);
```

is not used in our intended design because `VideoBroadCast` is the major activity.

---

### 21. Why `VideoBroadCast` Is the Major Thread

The main purpose of the application is:

```text
Broadcast video
```

Therefore:

```text
VideoBroadCast
       ↓
Major activity
```

The other activities exist to support it:

```text
NetworkStabilizzer
       ↓
Support network

VideoEnhancer
       ↓
Support video
```

So the design is:

```text
Major
  ↓
VideoBroadCast

Supporting
  ↓
NetworkStabilizzer
VideoEnhancer
```

---

### 22. Infinite Loop `for(;;)`

Your notes mention:

```java
for(;;)
```

This is an **infinite loop**.

It means the loop has:

```text
initialization → omitted
condition      → omitted
update         → omitted
```

For a `for` loop:

```java
for(initialization; condition; update)
```

if all three sections are omitted:

```java
for(;;)
```

the loop keeps repeating.

Conceptually:

```text
Start
  ↓
Execute body
  ↓
Repeat
  ↓
Execute body
  ↓
Repeat
  ↓
Execute body
  ↓
Forever...
```

---

### 23. Why Use an Infinite Loop for Background Activity?

A background support activity may conceptually need to keep checking or supporting something repeatedly while the major application is alive.

For example:

```text
NetworkStabilizzer

Check network
     ↓
Stabilize network
     ↓
Check again
     ↓
Stabilize again
     ↓
Continue...
```

An infinite loop represents continuous activity.

The same idea can be used for:

```text
VideoEnhancer
     ↓
Monitor/enhance
     ↓
Monitor/enhance
     ↓
Continue...
```

---

### 24. Important Warning About Infinite Loops

An infinite loop should not be used carelessly.

This:

```java
for (;;) {
}
```

continuously consumes execution resources.

In a real application, background work would normally have appropriate waiting, blocking, scheduling, or termination logic.

For learning the daemon-thread concept, however:

```java
for(;;)
```

clearly demonstrates continuous background activity.

---

### 25. Thread Priority

Your notes mention:

```java
setPriority(1);
```

Java provides thread priorities.

The constant values are generally:

```text
MIN_PRIORITY = 1
NORM_PRIORITY = 5
MAX_PRIORITY = 10
```

Therefore:

```java
thread.setPriority(1);
```

sets the thread's priority to the minimum priority value.

---

### 26. `setPriority(1)`

For example:

```java
network.setPriority(1);
```

means:

```text
network thread
      ↓
priority = 1
      ↓
minimum Java thread priority value
```

The intention in your notes is to give the supportive thread a low priority.

---

### 27. Priority Does NOT Mean Guaranteed Order

This is extremely important.

If:

```java
network.setPriority(1);
```

is used, it does **not** mean:

> "The network thread will definitely execute last."

Thread priority is a scheduling hint; actual scheduling depends on the JVM and underlying operating system.

Therefore, never rely on priority to guarantee execution order.

---

### 28. Combining Daemon and Priority

The supporting thread can be configured like:

```java
network.setDaemon(true);
network.setPriority(1);
```

This gives us:

```text
network
   ↓
Daemon = true
   ↓
Priority = 1
```

Similarly:

```java
enhancer.setDaemon(true);
enhancer.setPriority(1);
```

gives:

```text
enhancer
   ↓
Daemon = true
   ↓
Priority = 1
```

---

### 29. Three Important Steps From Your Notes

Your notes describe three steps:

```text
1. Set daemon value as true
2. Set low priority for thread
3. Put daemon activity inside infinite loop
```

The conceptual structure is:

```text
Supporting Thread
       ↓
setDaemon(true)
       ↓
setPriority(1)
       ↓
run()
       ↓
for(;;)
       ↓
Continuous background activity
```

These are the characteristics of the particular teaching example.

---

### 30. Daemon Thread and Main Activity

The most important relationship is:

```text
Main / Major Activity
          ↓
     VideoBroadCast
          ↓
    Application work
          ↓
Supporting Activities
     ↙          ↘
Network       Video
Stabilizer    Enhancer
   ↓              ↓
Daemon          Daemon
```

The daemon threads support the major activity.

---

### 31. What Happens When the Major Work Ends?

The JVM does not keep running solely because daemon threads are still alive.

If there are no remaining **non-daemon** threads, the JVM can terminate, and daemon threads are stopped as part of JVM shutdown.

For the example:

```text
VideoBroadCast
       ↓
Major non-daemon thread
       ↓
FINISHES

NetworkStabilizzer
       ↓
Daemon

VideoEnhancer
       ↓
Daemon
```

If those daemon threads are the only remaining threads, the JVM can terminate.

This is the key characteristic of daemon threads.

---

### 32. Important Correction to the Simple Rule

People often say:

> "Daemon threads automatically finish when the main thread ends."

That statement is too broad.

The more accurate rule is:

> **Daemon threads do not keep the JVM alive. When all non-daemon threads have finished, the JVM terminates, and remaining daemon threads do not prevent that termination.**

So the important concept is not simply:

```text
main ends → daemon immediately ends
```

It is:

```text
All non-daemon threads finish
          ↓
JVM can terminate
          ↓
Remaining daemon threads do not keep it alive
```

---

### 33. `main` Thread vs `VideoBroadCast`

In your example, the phrase **main/major thread** should be understood carefully.

Technically:

```text
main thread
```

is the thread that executes:

```java
main()
```

while:

```text
VideoBroadCast
```

may be a separate worker thread created by `new Thread(...)`.

So the conceptual application can be:

```text
main thread
    ↓
creates and starts
    ↓
VideoBroadCast thread
    ↓
major application work

NetworkStabilizzer
    ↓
daemon

VideoEnhancer
    ↓
daemon
```

The JVM remains alive as long as there is a non-daemon thread still running.

---

### 34. Why Daemon Threads Are Useful

Daemon threads are useful for background/support work that should not prevent the application from terminating.

Common conceptual examples include:

```text
Background monitoring
Garbage collection
Background maintenance
Supporting services
```

The exact implementation depends on the application.

The central principle remains:

```text
Important work
     ↓
Non-daemon thread

Background support
     ↓
Daemon thread
```

---

### 35. Important Rules and Common Mistakes

**Rule 1 — Set daemon status before starting**

Correct:

```java
t.setDaemon(true);
t.start();
```

Do not try to change the daemon status after the thread has already started.

---

**Rule 2 — Daemon does not mean "always low priority"**

These are separate concepts:

```text
Daemon status → determines whether the thread keeps JVM alive

Priority → scheduling priority/hint
```

Setting:

```java
t.setDaemon(true);
```

does not automatically make its priority `1`.

If you want priority `1`, explicitly use:

```java
t.setPriority(1);
```

---

**Rule 3 — Daemon does not mean "runs simultaneously"**

Concurrent execution is a separate concept.

```text
Concurrency → multiple threads make progress
Daemon      → background/JVM-lifetime behavior
```

---

**Rule 4 — Daemon does not mean "less important to Java"**

It means the thread is not allowed to keep the JVM alive by itself.

---

**Rule 5 — Do not depend on exact output order**

Multiple threads may execute concurrently, so output order can vary.

---

### 36. Lifetime Memory

```text
                 DAEMON THREAD
                       ↓
              Background Support
                       ↓
          ┌────────────┴────────────┐
          ↓                         ↓
NetworkStabilizzer            VideoEnhancer
          ↓                         ↓
      setDaemon(true)          setDaemon(true)
          ↓                         ↓
      setPriority(1)           setPriority(1)
          ↓                         ↓
        run()                     run()
          ↓                         ↓
       for(;;)                    for(;;)
          ↓                         ↓
 Continuous support          Continuous support
          └────────────┬────────────┘
                       ↓
                Supports major work
                       ↓
                VideoBroadCast
                       ↓
                 Major activity
                       ↓
              Non-daemon work ends
                       ↓
             JVM may terminate
                       ↓
       Remaining daemon threads do
          not keep JVM alive
```

### 🔑 Final Memory Formula

> **Daemon thread = background/supporting thread that does not keep the JVM alive after all non-daemon threads have finished.**

And remember these four pieces separately:

```text
setDaemon(true)
       ↓
Make thread a daemon

setPriority(1)
       ↓
Set minimum Java priority value

for(;;)
       ↓
Repeat continuously

Non-daemon threads finish
       ↓
JVM can terminate
       ↓
Daemon threads cannot keep it alive
```

For your **Video Broadcasting** example:

```text
VideoBroadCast
      ↓
Major work

NetworkStabilizzer
      ↓
Daemon support

VideoEnhancer
      ↓
Daemon support
```

**One sentence to remember for life:**

> **A daemon thread is a background helper: it supports the important work while non-daemon work is alive, but it cannot keep the Java application alive by itself.**
