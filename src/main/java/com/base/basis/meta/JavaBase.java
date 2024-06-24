package com.base.basis.meta;

/**
 * Java SE（Java Platform，Standard Edition）: Java 平台标准版，Java 编程语言的基础，
 * 它包含了支持 Java 应用程序开发和运行的核心类库以及虚拟机等核心组件。
 * Java SE 可以用于构建桌面应用程序或简单的服务器应用程序。
 * Java EE（Java Platform, Enterprise Edition ）：Java 平台企业版，建立在 Java SE 的基础上，
 * 包含了支持企业级应用程序开发和部署的标准和规范（比如 Servlet、JSP、EJB、JDBC、JPA、JTA、JavaMail、JMS）。
 * Java EE 可以用于构建分布式、可移植、健壮、可伸缩和安全的服务端 Java 应用程序，例如 Web 应用程序
 * Java SE 是 Java 的基础版本，Java EE 是 Java 的高级版本。
 * Java SE 更适合开发桌面应用程序或简单的服务器应用程序，
 * Java EE 更适合开发复杂的企业级应用程序或 Web 应用程序
 *
 * JVM
 * Java 虚拟机（Java Virtual Machine, JVM）是运行 Java 字节码的虚拟机。
 * JVM 有针对不同系统的特定实现（Windows，Linux，macOS），目的是使用相同的字节码，它们都会给出相同的结果。
 * 字节码和不同系统的 JVM 实现是 Java 语言“一次编译，随处可以运行”的关键所在
 * JVM 并不是只有一种！只要满足 JVM 规范，每个公司、组织或者个人都可以开发自己的专属 JVM。
 * 也就是说我们平时接触到的 HotSpot VM 仅仅是是 JVM 规范的一种实现而已
 *
 * JDK 和 JRE
 * JDK（Java Development Kit），它是功能齐全的 Java SDK，
 * 是提供给开发者使用，能够创建和编译 Java 程序的开发套件。它包含了 JRE，
 * 同时还包含了编译 java 源码的编译器 javac 以及一些其他工具比如
 * javadoc（文档注释工具）、jdb（调试器）、jconsole（基于 JMX 的可视化监控⼯具）、javap（反编译工具）等等。
 * JRE（Java Runtime Environment） 是 Java 运行时环境。
 * 它是运行已编译 Java 程序所需的所有内容的集合，主要包括 Java 虚拟机（JVM）、Java 基础类库（Class Library）。
 * 也就是说，JRE 是 Java 运行时环境，仅包含 Java 应用程序的运行时环境和必要的类库。
 * 而 JDK 则包含了 JRE，同时还包括了 javac、javadoc、jdb、jconsole、javap 等工具，
 * 可以用于 Java 应用程序的开发和调试。如果需要进行 Java 编程工作，比如编写和编译 Java 程序、
 * 使用 Java API 文档等，就需要安装 JDK。而对于某些需要使用 Java 特性的应用程序，如 JSP 转换为 Java Servlet、使用反射等，
 * 也需要 JDK 来编译和运行 Java 代码。因此，即使不打算进行 Java 应用程序的开发工作，也有可能需要安装 JDK
 *
 * 什么是字节码?采用字节码的好处是什么?
 * 在 Java 中，JVM 可以理解的代码就叫做字节码（即扩展名为 .class 的文件），
 * 它不面向任何特定的处理器，只面向虚拟机。Java 语言通过字节码的方式，
 * 在一定程度上解决了传统解释型语言执行效率低的问题，同时又保留了解释型语言可移植的特点。
 * 所以， Java 程序运行时相对来说还是高效的（不过，和 C、 C++，Rust，Go 等语言还是有一定差距的），
 * 而且，由于字节码并不针对一种特定的机器，因此，Java 程序无须重新编译便可在多种不同操作系统的计算机上运行
 *
 * 格外注意的是 .class->机器码 这一步。在这一步 JVM 类加载器首先加载字节码文件，
 * 然后通过解释器逐行解释执行，这种方式的执行速度会相对比较慢。而且，有些方法和代码块是经常需要被调用的(也就是所谓的热点代码)，
 * 所以后面引进了 JIT（Just in Time Compilation） 编译器，而 JIT 属于运行时编译。
 * 当 JIT 编译器完成第一次编译后，其会将字节码对应的机器码保存下来，下次可以直接使用。而我们知道，
 * 机器码的运行效率肯定是高于 Java 解释器的。这也解释了我们为什么经常会说 Java 是编译与解释共存的语言
 *
 * 为什么说 Java 语言“编译与解释并存”？
 * 我们可以将高级编程语言按照程序的执行方式分为两种：
 * 编译型：编译型语言会通过编译器
 * 将源代码一次性翻译成可被该平台执行的机器码。一般情况下，
 * 编译语言的执行速度比较快，开发效率比较低。常见的编译性语言有 C、C++、Go、Rust 等等。
 * 解释型：解释型语言
 * 会通过解释器一句一句的将代码解释（interpret）为机器代码后再执行。
 * 解释型语言开发效率比较快，执行速度比较慢。常见的解释性语言有 Python、JavaScript、PHP 等等
 * 为什么说 Java 语言“编译与解释并存”？这是因为 Java 语言既具有编译型语言的特征，也具有解释型语言的特征。因为 Java 程序要经过先编译，后解释两个步骤，由 Java 编写的程序需要先经过编译步骤，生成字节码（.class 文件），这种字节码必须由 Java 解释器来解释执行
 * AOT 有什么优点？为什么不全部使用 AOT 呢？JDK 9
 * 引入了一种新的编译模式 AOT(Ahead of Time Compilation) 。
 * 和 JIT 不同的是，这种编译模式会在程序被执行前就将其编译成机器码，
 * 属于静态编译（C、 C++，Rust，Go 等语言就是静态编译）。AOT 避免了 JIT 预热等各方面的开销，
 * 可以提高 Java 程序的启动速度，避免预热时间长。并且，
 * AOT 还能减少内存占用和增强 Java 程序的安全性（AOT 编译后的代码不容易被反编译和修改），特别适合云原生场景
 * 标识符和关键字的区别是什么？在我们编写程序的时候，需要大量地为程序、类、变量、方法等取名字，
 * 于是就有了 标识符 。简单来说， 标识符就是一个名字 。有一些标识符，
 * Java 语言已经赋予了其特殊的含义，只能用于特定的地方，这些特殊的标识符就是 关键字 。
 * 简单来说，关键字是被赋予特殊含义的标识符 。比如，在我们的日常生活中，如果我们想要开一家店，
 * 则要给这个店起一个名字，起的这个“名字”就叫标识符。但是我们店的名字不能叫“警察局”，
 * 因为“警察局”这个名字已经被赋予了特殊的含义，而“警察局”就是我们日常生活中的关键字
 * Java 中有 8 种基本数据类型：byte、short、int、long、float、double、boolean、char。
 * 包装类型的缓存机制
 * Byte、Short、Integer、Long 这四种包装类型在 Java 8 中引入了缓存机制，
 * 也就是说，如果一个 Integer 对象的值在 IntegerCache 的范围内，
 * 则直接返回缓存中的对象，而不是重新创建一个新的 Integer 对象。
 * 这样做的好处是可以减少内存的使用，提高性能。
 * 对于 Boolean 类型来说，Java 8 也引入了缓存机制，
 * 也就是说，如果一个 Boolean 对象的值为 true 或者 false，
 *
 * 所有整型包装类对象之间值的比较，全部使用equals()方法，而不是==运算符。
 * 什么是自动拆装箱子
 * 装箱：将基本类型用它们对应的引用类型包装起来；
 * 拆箱：将包装类型转换为基本数据类型
 * Integer i = 10 等价于 Integer i = Integer.valueOf(10)
 * int n = i 等价于 int n = i.intValue()
 *
 * 成员变量与局部变量的区别？
 * 语法形式：从语法形式上看，成员变量是属于类的，而局部变量是在代码块或方法中定义的变量或是方法的参数；
 * 成员变量可以被 public,private,static 等修饰符所修饰，
 * 而局部变量不能被访问控制修饰符及 static 所修饰；但是，成员变量和局部变量都能被 final 所修饰。
 *
 * 存储方式：从变量在内存中的存储方式来看，如果成员变量是使用 static 修饰的，那么这个成员变量是属于类的，
 * 如果没有使用 static 修饰，这个成员变量是属于实例的。而对象存在于堆内存，局部变量则存在于栈内存。
 *
 * 生存时间：从变量在内存中的生存时间上看，成员变量是对象的一部分，它随着对象的创建而存在，
 * 而局部变量随着方法的调用而自动生成，随着方法的调用结束而消亡。
 *
 * 默认值：从变量是否有默认值来看，
 * 成员变量如果没有被赋初始值，则会自动以类型的默认值而赋值（一种情况例外:被 final 修饰的成员变
 * 量也必须显式地赋值），而局部变量则不会自动赋值。
 *
 * 静态变量有什么作用？
 * 静态变量也就是被 static 关键字修饰的变量。它可以被类的所有实例共享，无论一个类创建了多少个对象，
 * 它们都共享同一份静态变量。也就是说，静态变量只会被分配一次内存，即使创建多个对象，这样可以节省内存。
 * 静态变量是通过类名来访问的，例如StaticVariableExample.staticVar
 * （如果被 private关键字修饰就无法这样访问了）。
 * 通常情况下，静态变量会被 final 关键字修饰成为常量。
 * String、StringBuffer、StringBuilder 的区别？可变性String 是不可变的（后面会详细分析原因）。
 * StringBuilder 与 StringBuffer
 * 都继承自 AbstractStringBuilder 类，在 AbstractStringBuilder
 * 中也是使用字符数组保存字符串，不过没有使用 final 和 private 关键字修饰，
 * 最关键的是这个 AbstractStringBuilder 类还提供了很多修改字符串的方法比如 append 方法
 * 线程安全性String 中的对象是不可变的，也就可以理解为常量，线程安全。AbstractStringBuilder
 * 是 StringBuilder 与 StringBuffer 的公共父类，定义了一些字符串的基本操作，
 * 如 expandCapacity、append、insert、indexOf 等公共方法。StringBuffer
 * 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。StringBuilder
 * 并没有对方法进行加同步锁，所以是非线程安全的
 * 性能每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，
 * 然后将指针指向新的 String 对象。StringBuffer 每次都会对 StringBuffer
 * 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用 StringBuilder 相
 * 比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险
 *
 * 对于三者使用的总结：
 *
 *     操作少量的数据: 适用 String
 *     单线程操作字符串缓冲区下操作大量数据: 适用 StringBuilder
 *     多线程操作字符串缓冲区下操作大量数据: 适用 StringBuffer
 *
 * 字符串拼接用“+” 还是 StringBuilder?
 * Java 语言本身并不支持运算符重载，“+”和“+=”是专门为 String 类重载过的运算符，
 * 也是 Java 中仅有的两个重载过的运算符
 * 在循环内使用“+”进行字符串的拼接的话，存在比较明显的缺陷：编译器不会创建单个 StringBuilder
 * 以复用，会导致创建过多的 StringBuilder 对象在循环内使用“+”进行字符串的拼接的话，
 * 存在比较明显的缺陷：编译器不会创建单个 StringBuilder 以复用，会导致创建过多的 StringBuilder 对象
 *
 * 我们在平时写代码的时候，尽量避免多个字符串对象拼接，因为这样会重新创建对象。如果需要改变字符串的话，
 * 可以使用 StringBuilder 或者 StringBuffer。不过，字符串使用 final 关键字声明之后，
 * 可以让编译器当做常量来处理
 * 一般模块之间都是通过接口进行通讯，那我们在服务调用方和服务实现方（也称服务提供者）之间引入一个“接口”。
 * 当实现方提供了接口和实现，我们可以通过调用实现方的接口从而拥有实现方给我们提供的能力，这就是 API ，
 * 这种接口和实现都是放在实现方的。当接口存在于调用方这边时，就是 SPI ，由接口调用方确定接口规则，
 * 然后由不同的厂商去根据这个规则对这个接口进行实现，从而提供服务
 * 通过 SPI 机制能够大大地提高接口设计的灵活性，但是 SPI 机制也存在一些缺点，比如：需要遍历加载所有的实现类，不
 * 能做到按需加载，
 * 这样效率还是相对较低的。当多个 ServiceLoader 同时 load 时，会有并发问题
 * Java IO 流了解吗？IO 即 Input/Output，输入和输出。
 * 数据输入到计算机内存的过程即输入，反之输出到外部存储（比如数据库，文件，远程主机）的过程即输出。
 * 数据传输过程类似于水流，因此称为 IO 流。IO 流在 Java 中分为输入流和输出流，
 * 而根据数据的处理方式又分为字节流和字符流。Java IO 流的 40 多个类都是从如下 4 个抽象类基类中派生出来的。
 * InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
 * OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流
 * 个人认为主要有两点原因：
 *     字符流是由 Java 虚拟机将字节转换得到的，这个过程还算是比较耗时；
 *     如果我们不知道编码类型的话，使用字节流的过程中很容易出现乱码问题
 *
 * BIO: 属于同步阻塞 IO 模型，数据读写必须等待，适用于连接数较少且固定的架构，
 * NIO: 属于同步非阻塞 IO 模型，支持多路复用，适用于连接数多且连接比较短的架构，
 * AIO: 属于异步非阻塞 IO 模型，支持 Future、CompletionHandler 回调机制，适用于连接数多且连接比较长的架构。

 */
public class JavaBase {

    //对象的相等一般比较的是内存中存放的内容是否相等。
    //引用相等一般比较的是他们指向的内存地址是否相等
    private void equalsTest() {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = "hello";
        // 使用 == 比较字符串的引用相等
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        // 使用 equals 方法比较字符串的相等
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
    }

    /**
     * 浅拷贝：浅拷贝会在堆上创建一个新的对象（区别于引用拷贝的一点），不过，
     * 如果原对象内部的属性是引用类型的话，浅拷贝会直接复制内部对象的引用地址，
     * 也就是说拷贝对象和原对象共用同一个内部对象。
     * 深拷贝：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象
     */
    private void copyTest() {
        Person person = new Person();
        person.setAddress(new Address());
        person.getAddress().setName("北京");
        Person personCopy = person.clone();
        System.out.println(person.getAddress() == personCopy.getAddress());
        //从输出结构就可以看出， personCopy 的克隆对象和 person 使用的仍然是同一个 Address 对象

        // 深拷贝：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象
        DeepPerson deepPerson = new DeepPerson();
        deepPerson.setAddress(new Address());
        deepPerson.getAddress().setName("深圳");
        DeepPerson deepPersonCopy = deepPerson.clone();
        System.out.println(deepPerson.getAddress() == deepPersonCopy.getAddress());

        // 那什么是引用拷贝呢？ 简单来说，引用拷贝就是两个不同的引用指向同一个对象
    }

    private void stringFinalTest() {
        final String str1 = "hello ";
        final String str2 = "world";
        // 下面两个表达式其实是等价的
        String c = "hello " + "world";// 常量池中的对象
        String d = str1 + str2; // 常量池中的对象
        System.out.println(c == d);// true
    }

}

class Address implements Cloneable{
    private String name;
    // 省略构造函数、Getter&Setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Person implements Cloneable {
    private Address address;

    // 省略构造函数、Getter&Setter方法
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class DeepPerson implements Cloneable {

    private Address address;

    // 省略构造函数、Getter&Setter方法
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public DeepPerson clone() {
        try {
            DeepPerson deepPerson = (DeepPerson) super.clone();
            deepPerson.setAddress(deepPerson.getAddress().clone());
            return deepPerson;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


