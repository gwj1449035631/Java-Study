package com.base.basis.bd;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {
        // 解决浮点数运算精度丢失这个问题，可以直接使用 BigDecimal 来定义浮点数的值，然后再进行浮点数的运算操作
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        // substract 等于减法
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x.compareTo(y));// 0

        // 使用 BigDecimal 时，为了防止精度丢失，
        // 推荐使用它的BigDecimal(String val)构造方法或者 BigDecimal.valueOf(double val) 静态方法来创建对象
        // BigDecimal(double) 会精度缺失，而 BigDecimal(String) 不会
    }

    // 加减乘除
    public static void optTest() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.add(b));// 1.9
        System.out.println(a.subtract(b));// 0.1
        System.out.println(a.multiply(b));// 0.90
        System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
        // 保留两位小数，四舍五入
        // 这里需要注意的是，在我们使用 divide 方法的时候尽量使用 3 个参数版本，
        // 并且RoundingMode 不要选择 UNNECESSARY，
        // 否则很可能会遇到 ArithmeticException（无法除尽出现无限循环小数的时候），
        // 其中 scale 表示要保留几位小数，roundingMode 代表保留规则
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11

        // 大小比较
        // 返回 -1 表示 a 小于 b，0 表示 a 等于 b ， 1 表示 a 大于 b
        System.out.println(a.compareTo(b));// 1
        // BigDecimal 等值比较问题
        // 因为 equals() 方法不仅仅会比较值的大小（value）还会比较精度（scale），而 compareTo() 方法比较的时候会忽略精度
    }

}
