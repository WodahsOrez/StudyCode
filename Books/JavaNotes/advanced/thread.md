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


#### synchronized关键词

```java
// 同步代码块，括号内填实例对象，或者.class对象作为锁
synchronized(对象)
{
	// 需要被同步的代码；
}

// 同步方法，锁是this对象
public synchronized void fn(){
    // 需要被同步的代码；
}

// 同步静态方法，锁是字节码对象对象*.class/this.getClass
public synchronized void fn(){
    // 需要被同步的代码；
}
```

同步方法被锁后，不影响多线程对非同步方法的访问。

对于synchronize线程抛出异常锁就会被释放。

synchronize(o)，o指向的对象属性改变不影响锁的使用，但如果o的引用指向了其他对象，那么锁定的对象也发生改变。

不要用字符串常量作为锁定对象，容易锁到同一个常量而导致死锁。



重入锁：同一把锁在未被释放时，可以被重复多次获得。

synchronize支持重入锁，应用情景有：

- 同一线程在锁A的方法内部访问另一个锁是A的同步方法。
- 子类this同步方法内访问父类this同步方法。

死锁：两个线程分别持有对方想要的锁。A有锁1去要锁2，B有锁2去要锁1。





**volatile关键词**：

- 由于线程都有各自独立的缓存，非volatile变量的值被线程缓存后，线程A更新了这个值，线程B读取这个变量的值时可能读到的并不是是线程A更新后的值。
- volatile变量则会变得多线程可见，即该变量会强制将修改的值立即写入主存，主存中值的更新会使缓存中的值失效。以使得该变量在多线程中值的同步。
- volatile要比synchronize效率高的多，但只保证可见性，不保证原子性。（即读的时候是最新的值，但写的时候就不会检查是否还是之前读的那个值了）



原子性包：Atomic开头的类基本都保证了原子性和线程安全，且性能比synchronize高。如：java.util.concurrent.atomic包。




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

