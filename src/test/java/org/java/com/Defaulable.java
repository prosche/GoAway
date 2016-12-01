package org.java.com;

public interface Defaulable {
	default String notRequired(){
		return "default implementation, not required!";
	}
}
