package org.java.com;

import java.util.ArrayList;
import java.util.List;

import org.java.com.util.ThreadUtil;
import org.junit.Test;

public class TestThread {

	@Test
	public void run() {
		System.out.println("Ö÷Ïß³ÌID£º" + Thread.currentThread().getId());
		List<String> list = new ArrayList<String>();
		list.add(0, "A");
		List<String> list1 = new ArrayList<String>();
		list1.add(0, "B");
		ThreadUtil thread = new ThreadUtil(list);
		ThreadUtil thread1 = new ThreadUtil(list1);
		Thread th = new Thread(thread);
		Thread th1 = new Thread(thread1);
		th.start();
		th1.start();
	}
}
