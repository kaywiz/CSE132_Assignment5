package assignment5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import studio4.SerialComm;
import assignment4.ViewInputStream;
import assignment5.ViewOutputStream;

public class SerialTestOutput {

	public static void main(String[] args) {
		// FIXME Auto-generated method stub
		
		InputStream systemIn = null;
		
		try {
			systemIn = System.in;
			if(systemIn.available() > 0){
			System.out.println("Line entered : " + systemIn.read());
			}
		}
		catch (IOException ioe) {
			System.out.println("Exception while reading input "+ ioe);
		}
		
		 try {   
			 SerialComm s = new SerialComm();
	         s.connect("/dev/cu.usbserial-DN00MZW8"); // Adjust this to be the right port for your machine
	         InputStream in = s.getInputStream();
	         OutputStream out = s.getOutputStream();
	         ViewOutputStream vis = new ViewOutputStream(out);
	         while(true){
	        	 while(systemIn.available() > 0){
	        		 System.out.println(systemIn.read());
	        		 vis.write(systemIn.read());
	        	 }
	         }
	         // InputStream and OutputStream are now available for use
	         // insert code below to use them
	            
	            
	        }
	        catch ( Exception e )
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

}
