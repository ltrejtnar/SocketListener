/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 *
 * @author Ladislav Trejtnar CVUT FEL
 */
public class Loader {
   
     private Properties prop;
    private InputStream input;
    

    public Loader(String filename) {
        input=null;
        prop = new Properties();
        loadSettings(filename);
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
 
    private final void loadSettings(String name){
       try {
        input = Loader.class.getClassLoader().getResourceAsStream(name);
    		if(input==null){
    	            System.err.println("Sorry, unable to find " + name);
    		    return;
    		}

    		//load a properties file from class path, inside static method
    		prop.load(input);
               
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        } 
    }
    

    	

    		
    		
    
}
