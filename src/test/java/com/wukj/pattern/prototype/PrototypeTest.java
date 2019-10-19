package com.wukj.pattern.prototype;

import org.junit.Test;

public class PrototypeTest {

    @Test
    public void testPrototype() {
        // 准备
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("splash box", sbox);

        // 生成
        Product p1 = manager.create("strong message");
        p1.use("Hello world");
        Product p2 = manager.create("warning box");
        p2.use("Hello world");
        Product p3 = manager.create("splash box");
        p3.use("Hello world");

    }
}