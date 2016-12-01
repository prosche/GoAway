package org.java.com;

import com.google.common.base.Supplier;

public class DefaulableFactory {

	static Defaulable create(Supplier<Defaulable> supplier){
		return supplier.get();
	}
}
