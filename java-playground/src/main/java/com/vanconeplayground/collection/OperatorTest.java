package com.vanconeplayground.collection;

/**
 * @author Tenton Lien
 */
public class OperatorTest {

    public static void main(String[] args) {

        Operator addOperator = (a, b) -> a + b;
        Operator reduceOperator = (a, b) -> a - b;
        Operator multiplyOperator = (a, b) -> a * b;
        Operator divideOperator = (a, b) -> a / b;

        OperatorTest test = new OperatorTest();
        System.out.println("3 + 3 = " + test.getResult(3, 3, addOperator));
        System.out.println("3 - 3 = " + test.getResult(3, 3, reduceOperator));
        System.out.println("3 * 3 = " + test.getResult(3, 3, multiplyOperator));
        System.out.println("3 / 3 = " + test.getResult(3, 3, divideOperator));
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
        @Override
        boolean equals(Object obj);

        @Override
        String toString();

        @Override
        int hashCode();
    }
}
