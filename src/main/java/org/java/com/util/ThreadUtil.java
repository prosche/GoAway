package org.java.com.util;

import java.util.List;

public class ThreadUtil implements Runnable {

	private List<String> list;
	private static int num = 10;
	
	public ThreadUtil(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < num; i++){
				System.out.println("当前线程：" + list.get(0) + ", 线程号：" + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
