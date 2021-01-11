package com.mekcone.playground.collection;

/**
 * @author Tenton Lien
 */
public class OperatorTest {

    public static void main(String[] args) {

        Operator addOperator = (a, b) -> a + b;
        Operator reduceOperator = (a, b) -> a - b;
        Operator multiplyOperator = (a, b) -> a * b;
        Operator DivideOperator = (a, b) -> a / b;

        OperatorTest test = new OperatorTest();
        System.out.println(test.getResult(3, 3, addOperator));
        System.out.println(test.getResult(3, 3, reduceOperator));
        System.out.println(test.getResult(3, 3, multiplyOperator));
        System.out.println(test.getResult(3, 3, DivideOperator));
    }

    public int getResult(int a, int b, Operator operator) {
        return operator.convert(a, b);
    }

    public interface Operator {
        int convert(int a, int b);
        default int get(int a) {
            return a;
        }

        // Object 基类方法可以有
        boolean equals(Object obj);
        String toString();
        int hashCode();
    }
}
