package com.wukj.reflect;

import java.util.ArrayList;
import java.util.List;

public class D extends Animal {

	public int km;

	private String des;

	private Color mColor;

	public List<String> mBu;
	
	public int[] nums;
	

	public int[] getNums() {
		return nums;
	}

	public D() {
		System.out.println("调用无参构造");
	}

	public D(String self) {
		System.out.println("调用有参构造self：" + self);
	}

	public enum Color {
		RED, WHITE, BLACK, BLUE, YELLOR
	}

	private List<Double> walk() {
		System.out.println("-----开始走路");
		return new ArrayList<>();
	}

	public void play(List<Integer> tools) throws Exception {
		System.out.println("-----开始玩耍");
	}

	@E(flag = 1)
	public int recharge(int money) {
		System.out.println("-----开始充值");
		return 0;
	}

	public void add() throws IllegalAccessException {
		System.out.println("-----手动抛出异常");
		throw new IllegalAccessException();
	}

	public static void clear() {
		System.out.println("-----清理");
	}

	private int sub(int a, int b) {
		System.out.println("-----两数相减");
		return a - b;
	}

}
