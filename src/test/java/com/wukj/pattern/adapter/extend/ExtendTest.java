
package com.wukj.pattern.adapter.extend;

import org.junit.Test;

public class ExtendTest {

    @Test
    public void testExtend() {

        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();

    }
}
