package com.base.basis.collection;

import java.util.*;

/**
 * Java集合学习
 * Java 集合，也叫作容器，主要是由两大接口派生而来：一个是 Collection接口，
 * 主要用于存放单一元素；另一个是 Map 接口，主要用于存放键值对。对于Collection 接口，
 * 下面又有三个主要的子接口：List、Set 、 Queue
 *
 * List, Set, Queue, Map 四者的区别？
 * List(对付顺序的好帮手): 存储的元素是有序的、可重复的。
 * Set(注重独一无二的性质): 存储的元素不可重复的。
 * Queue(实现排队功能的叫号机): 按特定的排队规则来确定先后顺序，存储的元素是有序的、可重复的。
 * Map(用 key 来搜索的专家): 使用键值对（key-value）存储，类似于数学上的函数 y=f(x)，"x" 代表 key，"y" 代表 value，key 是无序的、不可重复的，value 是无序的、可重复的，每个键最多映射到一个值l
 *
 * List
 * ArrayList：Object[] 数组。详细可以查看：ArrayList 源码分析。
 * Vector：Object[] 数组。
 * LinkedList：双向链表(JDK1.6 之前为循环链表，JDK1.7 取消了循环)
 *
 * Set
 * HashSet(无序，唯一): 基于 HashMap 实现的，底层采用 HashMap 来保存元素。
 * LinkedHashSet: LinkedHashSet 是 HashSet 的子类，并且其内部是通过 LinkedHashMap 来实现的。
 * TreeSet(有序，唯一): 红黑树(自平衡的排序二叉树)。
 *
 * Queue
 * PriorityQueue: Object[] 数组来实现小顶堆。
 * DelayQueue:PriorityQueue 的子类，可以实现延迟执行的任务。
 * ArrayDeque: 可扩容动态双向数组。
 *
 * Map
 * HashMap: 基于哈希表实现的，元素是无序的、不可重复的。
 * LinkedHashMap: LinkedHashMap 是 HashMap 的子类，其内部是通过 LinkedHashMap 来实现的。
 * TreeMap: 红黑树(自平衡的排序二叉树)。
 * Hashtable: 基于哈希表实现的，元素是无序的、不可重复的。链表解决哈希冲突。
 *
 *  ArrayList 和 Vector 的区别?（了解即可）
 *  ArrayList 是 List 的主要实现类，底层使用 Object[]存储，适用于频繁的查找工作，线程不安全 。
 *  Vector 是 List 的古老实现类，底层使用Object[] 存储，线程安全。
 *
 *  Vector 和 Stack 的区别?（了解即可）Vector 和 Stack 两者都是线程安全的，
 *  都是使用 synchronized 关键字进行同步处理。Stack 继承自 Vector，是一个后进先出的栈，
 *  而 Vector 是一个列表。随着 Java 并发编程的发展，Vector 和 Stack 已经被淘汰，
 *  推荐使用并发集合类（例如 ConcurrentHashMap、CopyOnWriteArrayList 等）
 *  或者手动实现线程安全的方法来提供安全的多线程操作支持
 *
 *  ArrayList 插入和删除元素的时间复杂度？
 *  头部插入：由于需要将所有元素都依次向后移动一个位置，因此时间复杂度是 O(n)。
 *  尾部插入：当 ArrayList 的容量未达到极限时，往列表末尾插入元素的时间复杂度是 O(1)，
 *  因为它只需要在数组末尾添加一个元素即可；当容量已达到极限并且需要扩容时，
 *  则需要执行一次 O(n) 的操作将原数组复制到新的更大的数组中，然后再执行 O(1) 的操作添加元素。
 *  指定位置插入：需要将目标位置之后的所有元素都向后移动一个位置，然后再把新元素放入指定位置。
 *  这个过程需要移动平均 n/2 个元素，因此时间复杂度为 O(n)
 *
 *  删除
 *  头部删除：由于需要将所有元素都依次向前移动一个位置，因此时间复杂度是 O(n)。
 *  尾部删除：当 ArrayList 的容量未达到极限时，从列表末尾删除元素的时间复杂度是 O(1)，
 *  因为它只需要在数组末尾删除一个元素即可；当容量已达到极限并且需要缩容时，
 *  则需要执行一次 O(n) 的操作将原数组复制到新的更小的数组中，然后再执行 O(1) 的操作删除元素.
 *  指定位置删除：需要将目标位置之后的所有元素都向前移动一个位置，然后再删除指定位置上的元素。O(n)
 *
 *  LinkedList 的插入和删除操作的时间复杂度？
 *  头部插入/删除：只需要修改头结点的指针即可完成插入/删除操作，因此时间复杂度为 O(1)。
 *  尾部插入/删除：只需要修改尾结点的指针即可完成插入/删除操作，因此时间复杂度为 O(1)。
 *  指定位置插入/删除：需要先移动到指定位置，再修改指定节点的指针完成插入/删除，因此需要遍历平均 n/2 个元素，时间复杂度为 O(n)
 * LinkedList 为什么不能实现 RandomAccess 接口？RandomAccess 是一个标记接口，
 * 用来表明实现该接口的类支持随机访问（即可以通过索引快速访问元素）。
 * 由于 LinkedList 底层数据结构是链表，内存地址不连续，只能通过指针来定位，
 * 不支持随机快速访问，所以不能实现 RandomAccess 接口
 *
 * ArrayList 实现了 RandomAccess 接口， 而 LinkedList 没有实现。
 * 为什么呢？我觉得还是和底层数据结构有关！ArrayList 底层是数组，而 LinkedList 底层是链表。
 * 数组天然支持随机访问，时间复杂度为 O(1)，所以称为快速随机访问。
 * 链表需要遍历到特定位置才能访问特定位置的元素，时间复杂度为 O(n)，所以不支持快速随机访问。
 * ArrayList 实现了 RandomAccess 接口，就表明了他具有快速随机访问功能。
 * RandomAccess 接口只是标识，并不是说 ArrayList 实现 RandomAccess 接口才具有快速随机访问功能的
 *
 * Set
 * Comparable 和 Comparator 的区别
 * Comparable 接口和 Comparator 接口都是 Java 中用于排序的接口，它们在实现类对象之间比较大小、排序等方面发挥了重要作用
 * Comparable 接口实际上是出自java.lang包 它有一个 compareTo(Object obj)方法用来排序Comparator接口实际上是出自 java.util 包它有一个compare(Object obj1, Object obj2)方法用来排序
 * 一般我们需要对一个集合使用自定义排序时，我们就要重写compareTo()方法或compare()方法，当我们需要对某一个集合实现两种排序方式，比如一个 song 对象中的歌名和歌手名分别采用一种排序方法的话，我们可以重写compareTo()方法和使用自制的Comparator方法或者以两个 Comparator 来实现歌名排序和歌星名排序，第二种代表我们只能使用两个参数版的 Collections.sort()
 *
 * 无序性和不可重复性的含义是什么
 * 无序性不等于随机性 ，无序性是指存储的数据在底层数组中并非按照数组索引的顺序添加 ，
 * 而是根据数据的哈希值决定的。不可重复性是指添加的元素按照 equals() 判断时 ，
 * 返回 false，需要同时重写 equals() 方法和 hashCode() 方法
 *
 * 比较 HashSet、LinkedHashSet 和 TreeSet 三者的异同
 * HashSet、LinkedHashSet 和 TreeSet 都是 Set 接口的实现类，都能保证元素唯一，并且都不是线程安全的。
 * HashSet 是无序的，不保证元素的顺序，LinkedHashSet 是有序的，并且内部是通过 LinkedHashMap 来实现的，
 * HashSet、LinkedHashSet 和 TreeSet 的主要区别在于底层数据结构不同。
 * HashSet 的底层数据结构是哈希表（基于 HashMap 实现）。
 * LinkedHashSet 的底层数据结构是链表和哈希表，元素的插入和取出顺序满足 FIFO。
 * TreeSet 底层数据结构是红黑树，元素是有序的，排序的方式有自然排序和定制排序
 * 底层数据结构不同又导致这三者的应用场景不同。
 * HashSet 用于不需要保证元素插入和取出顺序的场景，
 * LinkedHashSet 用于保证元素的插入和取出顺序满足 FIFO 的场景，
 * TreeSet 用于支持对元素自定义排序规则的场景
 *
 * Queue
 * Queue 与 Deque的区别
 * Queue 是单端队列，只能从一端插入元素，另一端删除元素，实现上一般遵循 先进先出（FIFO） 规则
 * Queue 扩展了 Collection 的接口，根据 因为容量问题而导致操作失败后处理方式的不同 可以分为两类方法: 一种在操作失败后会抛出异常，另一种则会返回特殊值
 *
 * Deque:是双端队列，在队列的两端均可以插入或删除元素
 * Deque 扩展了 Queue 的接口, 增加了在队首和队尾进行插入和删除的方法，同样根据失败后处理方式的不同分
 * Deque 还提供有 push() 和 pop() 等其他方法，可用于模拟栈
 *
 */
public class CollectionLearn {

    // ArrayList 和 Array（数组）的区别？ArrayList 内部基于动态数组实现，
    // 比 Array（静态数组） 使用起来更加灵活：ArrayList会根据实际存储的元素动态地扩容或缩容，
    // 而 Array 被创建之后就不能改变它的长度了。ArrayList 允许你使用泛型来确保类型安全，
    // Array 则不可以。ArrayList 中只能存储对象。对于基本类型数据，
    // 需要使用其对应的包装类（如 Integer、Double 等）。Array 可以直接存储基本类型数据，
    // 也可以存储对象。ArrayList 支持插入、删除、遍历等常见操作，并且提供了丰富的 API 操作方法，
    // 比如 add()、remove()等。Array 只是一个固定长度的数组，只能按照下标访问其中的元素，
    // 不具备动态添加、删除元素的能力。ArrayList创建时不需要指定大小，而Array创建时必须指定大小
    private void arrayListAndArray() {
        // 初始化一个 String 类型的数组
        String[] stringArr = new String[]{"hello", "world", "!"};
        // 修改数组元素的值
        stringArr[0] = "goodbye";
        System.out.println(Arrays.toString(stringArr));// [goodbye, world, !]
        // 删除数组中的元素，需要手动移动后面的元素
        for (int i = 0; i < stringArr.length - 1; i++) {
            stringArr[i] = stringArr[i + 1];
        }
        stringArr[stringArr.length - 1] = null;
        System.out.println(Arrays.toString(stringArr));// [world, !, null]

        // 初始化一个 String 类型的 ArrayList
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("hello", "world", "!"));
        // 添加元素到 ArrayList 中
        stringList.add("goodbye");
        System.out.println(stringList);// [hello, world, !, goodbye]
        // 修改 ArrayList 中的元素
        stringList.set(0, "hi");
        System.out.println(stringList);// [hi, world, !, goodbye]
        // 删除 ArrayList 中的元素
        stringList.remove(0);
        System.out.println(stringList); // [world, !, goodbye]


    }

    // Comparator 定制排序
    private void comparator() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        // 定制排序的用法
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        CollectionLearn collectionLearn = new CollectionLearn();
        collectionLearn.compareTo();
    }

    private void compareTo() {
        Person p1 = new Person("Tom", 30);
        Person p2 = new Person("Jerry", 25);
        Person p3 = new Person("Mike", 20);
        Person p4 = new Person("Lucy", 15);
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        for (Person key : persons) {
            System.out.println(key.getName() + " " + key.getAge());
        }

    }

}

// 重写 compareTo 方法实现按年龄来排序
class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        }
        return 0;
    }
}
