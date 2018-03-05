package cdsUpload;

import java.util.Scanner;

public class stringTest {

	public static void main (String[] s)
	{
		 append();
	}

		//Joining, Concatenating or Appending Strings in Java

	public static void  append()
		{
		StringBuilder sb = new StringBuilder();
	    
		sb.append("Hello");
		sb.append(" to");
		sb.append(" you");
		sb.delete(2,3);
		sb.append(" vip");
		//sb.capacity();
		        
		System.out.println(sb.toString()+"  "+sb.capacity());
		}
	
}
