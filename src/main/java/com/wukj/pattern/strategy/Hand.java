package com.wukj.pattern.strategy;

public class Hand {

	public static final int HANDVALUE_GUU = 0; // 表示石头的值
	public static final int HANDVALUE_CHO = 1; // 表示剪刀的值
	public static final int HANDVALUE_PAA = 2; // 表示布的值
	// 表示猜拳中3种手势的实例
	public static final Hand[] hand = { new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA) };
	// 猜拳中出的手势值对应的字符串
	private static final String[] name = { "石头", "剪刀", "布" };
	// 猜拳中出的手势值
	private int handValue;

	private Hand(int handvalue) {
		this.handValue = handvalue;
	}

	// 根据手势的值获取其对应的实例
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}

	// 如果this胜了h则返回true
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}

	// 如果this输了h则返回true
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}

	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handValue + 1) % 3 == h.handValue) {
			return 1;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name[handValue];
	}

}
