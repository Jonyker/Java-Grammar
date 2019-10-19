package com.wukj.pattern.state;

public class NightState implements State {

	private static NightState singleton = new NightState();

	public static NightState getInstance() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.recordLog("紧急：晚上使用金库！");
	}

	@Override
	public void doAlam(Context context) {
		context.callSecurityCenter("按下警铃（晚上）");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("晚上通话录音");
	}

	@Override
	public String toString() {
		return "[晚上]";
	}

}
