package com.base.basis.next;

import java.io.*;
import java.util.Scanner;

/**
 * Exception and Error
 * Exception :程序本身可以处理的异常，可以通过 catch 来进行捕获。Exception
 * 又可以分为 Checked Exception (受检查异常，必须处理) 和 Unchecked Exception
 * (不受检查异常，可以不处理)。
 * Error：Error 属于程序无法处理的错误 ，我们没办法通过 catch 来进行捕获不建议通过catch捕获 。
 * 例如 Java 虚拟机运行错误（Virtual MachineError）、虚拟机内存不够错误(OutOfMemoryError)、
 * 类定义错误（NoClassDefFoundError）等 。这些异常发生时，Java 虚拟机（JVM）一般会选择线程终止
 *
 * try-catch-finally 如何使用？
 * 在以下 2 种特殊情况下，finally 块的代码也不会被执行：
 *     程序所在的线程死亡。
 *     关闭 CPU。
 */
public class NextJava {

    // 使用 try-with-resources 代替try-catch-finally
    private void useTryWithResources() {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 多个资源需要关闭的时候，使用 try-with-resources 实现起来也非常简单，
    // 如果你还是用try-catch-finally可能会带来很多问题
    private void useMultipleResources() {
        try (InputStream in1 = new FileInputStream("file1.txt");
             InputStream in2 = new FileInputStream("file2.txt")) {
            // 使用资源 ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Java 泛型（Generics） 是 JDK 5 中引入的一个新特性。使用泛型参数，可以增强代码的可读性以及稳定性
    // 泛型一般有三种使用方式:泛型类、泛型接口、泛型方法
    // 泛型类
    static class MyClass<T> {

        private T value;

        public MyClass(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    // 泛型接口
    interface MyInterface<T> {
        void method(T t);
    }

    // 实现泛型接口 不确定类型，使用 Object
    static class MyImpl<T> implements MyInterface<T> {
        @Override
        public void method(T s) {
            System.out.println(s);
        }
    }

    // 泛型接口确定类型
    static class MyImpl2 implements MyInterface<String> {
        @Override
        public void method(String s) {
            System.out.println(s);
        }
    }

    // 泛型方法
    static <T> void method(T[] t) {
        for (T element : t){
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    private void useGenericsMethod() {
        String[] strArr = {"hello", "world"};
        method(strArr);
        Integer[] intArr = {1, 2, 3};
        method(intArr);
    }



}
