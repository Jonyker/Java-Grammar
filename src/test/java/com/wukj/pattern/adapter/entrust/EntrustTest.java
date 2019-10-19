package com.wukj.pattern.adapter.entrust;

import org.junit.Test;

public class EntrustTest {

    @Test
    public void testEntrust() {

        Print print = new PrintBanner("Hello");
		print.printWeak();
		print.printStrong();

    }
}
