package com.example.config;

public class Test {
    final int value = 10;
    final static int value1 = 20;
    private Test() {}

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.value);

        // Call Example.main() to execute it as well
        Example.main(args);
    }
}
class Example {
    public static void main(String[] args) {
        System.out.println(Test.value1);
    }
    
    
    
}
