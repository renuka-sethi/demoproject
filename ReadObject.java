package cdsUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {

	Properties p=new Properties();
	
	public Properties getObjectRepository() throws IOException
	{
		//File fs=new File();
		//Read object repository file
		InputStream stream=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\cdsUpload\\object.properties"));
		
		//InputStream stream=new FileInputStream()
		
		//load all objects
		p.load(stream);
		
		return p;
	}
}
