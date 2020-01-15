# JavaSE

[《Java 编程思想》第五版](https://lingcoder.github.io/OnJava8/#/sidebar)

## 面向对象

**万物皆对象**

### 封装


### 继承


### 多态


## 垃圾回收

## 运算符


## 控制流



## 并发编程

- 并发是关于正确有效地控制对共享资源的访问。
- 并行是使用额外的资源来更快地产生结果。

**并发性是一系列性能技术，专注于减少等待**
- 这是一个集合：有许多不同的方法来解决这个问题。这是使定义并发性如此具有挑战性的问题之一，因为技术差别很大
- 这些是性能技术：就是这样。并发的关键点在于让您的程序运行得更快。
在Java中，并发是非常棘手和困难的，所以绝对不要使用它，除非你有一个重大的性能问题 
- 即使这样，使用最简单的方法产生你需要的性能，因为并发很快变得无法管理。
- “减少等待”部分很重要而且微妙。无论（例如）你运行多少个处理器，你只能在等待某个地方时产生结果。
如果您发起I/O请求并立即获得结果，没有延迟，因此无需改进。如果您在多个处理器上运行多个任务，并且每个处理器都以满容量运行，并且任何其他任务都没有等待，
那么尝试提高吞吐量是没有意义的。并发的唯一形式是如果程序的某些部分被迫等待。等待可以以多种形式出现 - 这解释了为什么存在如此不同的并发方法。

## Stream

Java8 的 Stream API 可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。

根据大神的分析，记录 stream 与传统写法的性能比较
篇幅有限，只写结果。

基本类型
1. 使用Stream并行API在单核情况下性能很差，比Stream串行API的性能还差
2. 随着使用核数的增加，Stream并行效果逐渐变好，比使用for循环外部迭代的性能还好

对象迭代
1. 对于对象类型Stream串行迭代的性能开销仍然高于外部迭代开销（1.5倍），但差距没有基本类型那么大
2. Stream并行迭代的性能比串行迭代和外部迭代都好

复杂对象规约
1. Stream API的性能普遍好于外部手动迭代，并行Stream效果更佳
2. 使用Stream并行归约在单核情况下性能比串行归约以及手动归约都要差，简单说就是最差的
3. 随着使用核数的增加，Stream并行效果逐渐变好，多核带来的效果明显。

总结
1. 对于简单操作，比如最简单的遍历，Stream串行API性能明显差于显示迭代，但并行的Stream API能够发挥多核特性。
2. 对于复杂操作，Stream串行API性能可以和手动实现的效果匹敌，在并行执行时Stream API效果远超手动实现。

使用方式
1.  对于简单操作推荐使用外部迭代手动实现 
2. 对于复杂操作，推荐使用Stream API 
3. 在多核情况下，推荐使用并行Stream API来发挥多核优势， 
4. 单核情况下不建议使用并行Stream API。


不管什么语言，IO 这块都是挺麻烦的

并且考虑到优化，更是考验程序员的能力关键

## BIO

为何阻塞：
服务端的 accept() 和 read()、write() 都是阻塞的

> 效率低不代表没有用，如果确定连接的客户端非常少可以使用 BIO，
简单方便，不容易出错


## NIO (Non-Blocking)

### Single Thread

主线程的大管家（selector）每隔一段时间看一次客户端状态（轮询），负责 client 连接管理连接后的读写。

> NIO 中 Oracle 设计了 ByteBuffer。听说十分不好用，反人类。

### reactor模式 (响应式编程)

大管家领着一帮工人（线程池）干活，
大管家只负责连接，工人负责读写

## AIO (Asynchronous IO) 

运用观察者模式，异步非阻塞，封装的很好。将钩子函数直接放进了OS，拂衣而去。

## Netty
连接和业务的代码可以分开，互不影响。

## Optional
使用Optional除了赋予null语义，增加了可读性，最大的优点在于它是一种傻瓜式的防护。
Optional迫使你积极思考引用缺失的情况，因为你必须显式地从Optional获取引用。
直接使用null很容易让人忘掉某些情形，尽管FindBugs可以帮助查找null相关的问题，
但是我们还是认为它并不能准确地定位问题根源。



---
记录一个练习，这个[反射交换](https://github.com/MrTallon/HelloJava/blob/master/src/com/java/variable/CashVariable.java)的方法在jdk9之前不会报警告的
```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.java.variable.CashVariable (file:/Users/yangbo/Work/code/java/HelloJava/out/production/HelloJava/) to field java.lang.Integer.value
WARNING: Please consider reporting this to the maintainers of com.java.variable.CashVariable
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```


 List<String> addPermissionIds = 
 addPermission.stream().map(CusUserPermissionMappingDTO::getPermissionId).collect(Collectors.toList());
 
 将对象集合中的某个属性都拿出来



