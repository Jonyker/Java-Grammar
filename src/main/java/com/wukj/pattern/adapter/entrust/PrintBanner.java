package com.wukj.pattern.adapter.entrust;

public class PrintBanner extends Print {
	
	private Banner banner;
	
	

	public PrintBanner(String string) {
		banner = new Banner(string);
	}

	@Override
	public void printWeak() {
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		banner.showWithAster();
	}

	
	
	
	
	
}
