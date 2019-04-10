# 多线程

## 线程的状态

![1689841-383f7101e6588094](images/thread/1689841-383f7101e6588094.png)

线程的状态转换如上图所示，其中可能会遇到阻塞状态（blocked）的情况有

1. 调用join()和sleep()方法，sleep()时间结束或被打断，join()中断,IO完成都会回到Runnable状态，等待JVM的调度。
2. 调用wait()，使该线程处于等待池(wait blocked pool)，直到notify()/notifyAll()，线程被唤醒被放到锁定池(lock blocked pool )，释放同步锁使线程回到可运行状态（Runnable）
3. 对Running状态的线程加同步锁(Synchronized)使其进入(lock blocked pool )，同步锁被释放进入可运行状态(Runnable)。

## 同步

**并发**：同时有多个线程在抢占一个cpu资源，但同时只有一个线程真正处于运行状态。这种方式成为并发。

**线程安全**：经常用来描绘一段代码。指在并发的情况之下，该代码经过多线程使用，线程的调度顺序不影响任何结果。这个时候使用多线程，我们只需要关注系统的内存，cpu是不是够用即可。反过来，线程不安全就意味着线程的调度顺序会影响最终结果。

**同步**：是指通过人为的控制和调度，保证共享资源的多线程访问成为线程安全，来保证结果的准确。





## 多线程相关类API

### Runnable接口

方法：`void run() `     重写该抽象方法来实现多线程

### Thread类

Thread类实现了Runnable接口。

#### 构造函数：

```java
Thread()
Thread(String name)
Thread(Runnable target)
Thread(Runnable target, String name)
```

#### 方法：

```java
void run()
void start()     运行该线程
String getName()     获取线程的名字，Thread-编号(从0开始) ，主线程名字为main
int getPriority()  获取优先级
void setPriority(int newPriority)     设置优先级1~10，默认为5
void join()     直到用该方法的线程死亡前一直等待。(在A的线程中间调用B.join()，则直到B结束A才会运行)
static void sleep(long millis)     在指定的毫秒数内让当前正在执行的线程休眠（代码所在的线程休眠，实例调用也一样）
boolean isAlive()  当前线程是否处于活跃状态(线程执行结束后的状态返回false)
Thread.State getState()  返回一个State枚举常量
static Thread currentThread()     返回一个当前线程对象。
void	interrupt()  把当前线程从阻塞状态中恢复到可执行状态
static void yield()  当前线程释放执行权限,进行新一轮的权限争夺
```

#### synchronized关键词

```java
// 同步代码块，括号内填实例对象，或者.class对象作为锁
synchronized(对象)
{
	// 需要被同步的代码；
}

// 同步函数，锁是this对象
public synchronized void fn(){
    // 需要被同步的代码；
}

// 同步静态函数，锁是字节码对象对象*.class/this.getClass
public synchronized void fn(){
    // 需要被同步的代码；
}
```

#### Object类里的线程通信方法:

```java
void wait()  让当前线程冻结,并释放锁
void wait(long timeout,)
void wait(long timeout,int nanos)分别是毫秒和纳秒,(当纳秒>500,000时,timeout++)
void notify()  唤醒一个当前对象线程池中的线程(任意)
void notifyAll()  唤醒当前对象线程池中所有的线程
```



### java.util.concurrent.locks

#### Lock接口

方法:

```java
void lock()  当前线程获取锁,
void unlock()  当前线程释放锁.
Condition  newCondition()  返回监视器对象
```

ReentrantLock类

`ReentrantLock()`

Condition接口

方法:

```java
void	await()
void	signal()
void	signalAll()
```

