package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * this class utilise the common data of property file
 * @author HP
 *
 */
public class PropertyUtility {
	/**
	 * this generic method use to read data from property file given by user
	 * @throws IOException 
	 */
 public String readDataFromPropertyFile(String key) throws IOException
 {
	 FileInputStream fis = new FileInputStream(IConstantUtility.propertyFilePath);
	 Properties pos = new Properties();
	 pos.load(fis);
	 String val = pos.getProperty(key);
	 return val;
 }
}
