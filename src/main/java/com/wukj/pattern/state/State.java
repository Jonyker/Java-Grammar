package com.wukj.pattern.state;

/**
 * 表示金库状态接口
 * 
 * @author Administrator
 *
 */
public interface State {

	/**
	 * 设置时间
	 * @param context
	 * @param hour
	 */
	public abstract void doClock(Context context,int hour);

	/**
	 * 使用仓库
	 */
	public abstract void doUse(Context context);

	/**
	 * 按下警铃
	 */
	public abstract void doAlam(Context context);

	/**
	 * 正常通话
	 */
	public abstract void doPhone(Context context);

}
