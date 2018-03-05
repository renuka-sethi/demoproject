package cdsUpload;

import java.util.*;
public class workingwithString {
	int rollno;  
	String name;  
	static String college ="ITS";  
	workingwithString(int r,String n){  
		rollno = r;  
		name = n;  
		}  
		void display (){
			//college="123";
			System.out.println(rollno+" "+name+" "+college);}  


		
		public static void main (String[] s)
			{
				String texttoreverse;
				Scanner scan=new Scanner(System.in); 
				texttoreverse=scan.nextLine();
				//System.out.println(""+texttoreverse);
				texttoreverse(texttoreverse);
				workingwithString s1 = new workingwithString(111,"Ran");  
				workingwithString s2 = new workingwithString(222,"Dan");  
				   
				 s1.display();  
				 s2.display();  
			}




public static void  texttoreverse(String txt) 
	{
		String[] parts= txt.split(" ");
		System.out.println(parts.length);
		try{
		for (int i = parts.length-1; i>=0; i--)
		{
			System.out.print(parts[i]+" ");
		}}catch(ArrayIndexOutOfBoundsException  e){System.out.println("Array over Limit");}

	}



} 
	
	

  

