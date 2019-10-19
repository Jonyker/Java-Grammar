package com.wukj.pattern.state;

public class DayState implements State {

	private static DayState singleton = new DayState();

	public static DayState getInstance() {
		return singleton;
	}

	/**
	 * 设置时间
	 */
	@Override
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.recordLog("使用金库（白天）");
	}

	@Override
	public void doAlam(Context context) {
		context.callSecurityCenter("按下警铃（白天）");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("正常通话（白天）");
	}

	@Override
	public String toString() {
		return "[白天]";
	}

}
