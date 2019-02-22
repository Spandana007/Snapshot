import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
* This program demonstrates how to capture screenshot of a portion of screen.
* 
*/
/**
 * @author co26350
 *
 */
/**
 * @author co26350
 *
 */
public class SandboxSnapshot  {
 
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * 
    */
	
	
	JFileChooser fs;
	
	
    public SandboxSnapshot(){
    	  //fs=new JFileChooser();
    	  
   
    		try {
    		     
    		      
    			
    		      		     
    		     
    			 fs=new JFileChooser();
    	            String fileName=getWheretoSave();
      		      
       		     
      		      
      		      fs.setDialogTitle("Save Snapshot");
    		        
    		    
    		      if(fileName.toLowerCase().endsWith(".jpg"))
    		      {
    		    	  

    		    	  //Thread.sleep(2000);
        		      Robot robot = new Robot();
        		    
        		      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        	            screenSize.width=750;
        	            screenSize.height=500;
        	            Rectangle rectArea = new Rectangle(0, 350, screenSize.width, screenSize.height);
        	            BufferedImage screenFullImage = robot.createScreenCapture(rectArea);
        		         ImageIO.write(screenFullImage, "jpg", new File(fileName));
        		         System.out.println("Screenshot is captured");
        		         JOptionPane.showMessageDialog(null, "Screen saved successfully.",null, 1);
        		         
    		    	 
    		      }
    		      
    		      else
    		      {
    		    	  
        		         JOptionPane.showMessageDialog(null, "Error: file name must end with \".jpg\".",
      		    	           null, 1); 
        		         
        		        new SandboxSnapshot();
    		    	  
    		      }
    		      
    		      
    	    		 
    		     
    		      
    		      
    		  } 
    		  catch (AWTException | NullPointerException ex) 
    		  {
    		           System.err.println(ex);
    		  } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
   		      
    		
    	 
    	}

		String getWheretoSave() {
			// TODO Auto-generated method stub
			int retVal=fs.showSaveDialog(null);
			File file = null;
			if(retVal==JFileChooser.APPROVE_OPTION)
			
			{
			    file=fs.getSelectedFile();
				if(file.exists())
				{
					JOptionPane.showMessageDialog(null, "Cannot have a file with same filename. Rename the file",
   		    	           null, 1); 
					
					
     		     
				}	
				else if(!file.exists())
				{
					return file.getAbsolutePath();
				}
				
				
			}
			
			
			return file.getAbsolutePath();
				
				
				
			
			
		}
    
    
    
   
    
    
     public static void main(String[] args) 
     {
    	new SandboxSnapshot();
    	
    	
           
     }
    }