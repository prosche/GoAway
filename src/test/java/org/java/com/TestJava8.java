package org.java.com;

import java.util.Arrays;

import org.junit.Test;

public class TestJava8 {

//	@Test
	public void asList(){
//		Arrays.asList( "a", "b", "d" ).forEach( e -> {
//		    System.out.print( e );
//		} );
		
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
			System.out.println(result);
		    return result;
		} );
	}
	

	@Test
	public void getDefaultable(){
		Defaulable defaulable = DefaulableFactory.create( DefaulableImpl::new );
		System.out.println( defaulable.notRequired() );
		DefaulableImpl defaulableImpl = new DefaulableImpl();
		String value = defaulableImpl.notRequired();
		System.out.println(value);
	}
}
