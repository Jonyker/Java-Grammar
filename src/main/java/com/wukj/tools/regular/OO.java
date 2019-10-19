
package com.wukj.tools.regular;

public class OO {
    public static void main(String[] args) {
        A a = new A();

        B b1 = new B(a);
        B b2 = new B(a);
        B b3 = new B(a);
        B b4 = new B(a);
        B b5 = new B(a);
        b1.reduce();
        b2.reduce();

        System.out.println("count:"+a.count);
    }
}

class A {
    int count = 10;
}

class B {
    public B(A _a) {
        this.a = _a;
    };
    public A a;

    public void reduce(){
        a.count--;
    }
}

