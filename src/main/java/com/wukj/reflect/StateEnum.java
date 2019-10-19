package com.wukj.reflect;

public enum StateEnum {

	START, DOING, END;

	/**
	 *  java中8种数据类型所占字节数如下：
	 *  boolean 这个试编译环境而定
	 *  byte 1个字节
	 *  short 2个字节
	 *  char 2个字节
	 *  int 4个字节
	 *  long 8个字节
	 *  float 4个字节
	 *  double 8个字节
	 */
	byte b;
	short s;
	int i;
	long l;

	float f;
	double d;

	boolean bo;

	char c;
	
	int doing() {
		return 0;
	}

}
