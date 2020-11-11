package com.wukj.binary;

public class Test {

    @org.junit.Test
    public void testBCD(){
        byte[] b = BCDDecodeUtils.str2Bcd("2010");
        System.out.println(BCDDecodeUtils.bcd2Str(b));
    }

}
