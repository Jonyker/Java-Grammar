package com.wukj.pattern.state;

/**
 * 表示金库状态接口
 * 
 * @author Administrator
 *
 */
public interface Context {

	/**
	 * 设置时间
	 * @param hour
	 */
	public abstract void setClock(int hour);

	/**
	 * 改变状态
	 * @param state
	 */
	public abstract void changeState(State state);

	/**
	 * 联系警报中心
	 * @param msg
	 */
	public abstract void callSecurityCenter(String msg);

	/**
	 * 在警报中心留下纪录
	 * @param msg
	 */
	public abstract void recordLog(String msg);

}
