package model;
import java.io.File;


public class Test 
{
	String path;
//	FilterConfig config;
	public String pathString()
	{
/*		File currDir = new File("");
	    path = currDir.getAbsolutePath();
*/
		File catalinaBase = new File( System.getProperty( "catalina.home" ) ).getAbsoluteFile();
//		System.out.println("CATALINA "+System.getProperty( "catalina.home" ));
		File propertyFile = new File( catalinaBase, "webapps/" );
		System.out.println("CatalinaBase : "+catalinaBase +"\nPropertyFile :"+propertyFile);
	    return propertyFile.getAbsolutePath();
	}
}
