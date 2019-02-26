import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;



public class SandboxSnapshot  {
	JFileChooser fs;
	File fname;
	boolean dirFlag,fileFlag;
	public static void main(String[] args) 
    {
   	    SandboxSnapshot s=new SandboxSnapshot();
   	    s.SandboxSaveSnapshot();
   	  	         
    }
 
    public void SandboxSaveSnapshot(){
    	  
    		try {
    		     
    			   
    			    
    			       			    
    			    JFileChooser fs = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    			 
    			    fs.setPreferredSize(new Dimension(800,600));
    				fs.setDialogTitle("CHOOSE A DIRECTORY TO SAVE YOUR FILE ");
    				fs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    
                    int canceloption = 0;
                    int returnValue = fs.showSaveDialog(null);
    				if (returnValue == JFileChooser.APPROVE_OPTION) 
    				{
    					if (fs.getSelectedFile().exists()) 
    					{
    						
    						   JOptionPane.showMessageDialog(null, "Entered directory name " + fs.getSelectedFile().getName() + " exists!!!!",null, 1); 
    						   int input = JOptionPane.showConfirmDialog(null, "Do you want to open the existing directory?",null, JOptionPane.YES_NO_OPTION);
    						   if(input == JOptionPane.YES_OPTION)
    						   {
    							   
    							  
    							   int result = fs.showOpenDialog(null);
    							   if(result==JFileChooser.APPROVE_OPTION)
    							   {
    								  	   
    							       dirFlag=false;
    							       fname=fs.getSelectedFile();
    							   }
    							   else
    							   {
    								  
    								   JOptionPane.showMessageDialog(null, "Please enter the existing directory",null, 1);    
    								   SandboxSaveSnapshot();
    							   }
    							   
    						   }
    						   else if(input==JOptionPane.NO_OPTION)
    						   {
    							
    							 
    							   dirFlag=true;
    							  SandboxSaveSnapshot();
    					       }
    						   else if(input==JOptionPane.CANCEL_OPTION)
    						   {
    							  
    							   canceloption=input;
    							   System.exit(0);
    						   }
    					}
    						
    					else if(!(fs.getSelectedFile()).exists())
    						{
    							File f=fs.getSelectedFile();
        					    f.mkdir();
        					    JOptionPane.showMessageDialog(null, "You have created a new directory "+ (f.getName()).toUpperCase(),null, 1); 
        					    dirFlag=false;
        					    fname=fs.getSelectedFile();
        	
    						}
    		
    				}
    				else
    				
    				{
    					System.exit(0);
    				}
    			   
    				if(dirFlag==false && ((returnValue==0) && (canceloption==0)))
    				{
    	            String fileName=getWheretoSave();
      		   
    		          if(fileName.toLowerCase().endsWith(".jpg") && fileFlag==true)
    		           {
    		    	  

    		    	 
    		    	      Robot robot = new Robot();
          		          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          	            screenSize.width=850;
          	            screenSize.height=500;
          	            Rectangle rectArea = new Rectangle(0, 350, screenSize.width, screenSize.height);
          	            BufferedImage screenFullImage = robot.createScreenCapture(rectArea);
        		     
        		         ImageIO.write(screenFullImage, "jpg", new File(fileName));
        		         System.out.println("Screenshot is captured");
        		         JOptionPane.showMessageDialog(null, "Snapshot saved successfully.",null, 1);
        		         dirFlag=true;
        		   
    		      }
    		      
    		      else if(!(fileName.toLowerCase().endsWith(".jpg")))
    		      {
    		    	  
        		         JOptionPane.showMessageDialog(null, "Error: file name must end with \".jpg\".", null, 1); 
        		          fileFlag=false;
        		          getWheretoSave();
    		    	  
    		      }
    		      else
    		      {
    		    	  JOptionPane.showMessageDialog(null, "Give a filename in .jpg format only", null, 1);
    		    	  fileFlag=false;
    		    	  getWheretoSave();
    		      }
    		
    		  } 
    		}
    		  catch (AWTException | NullPointerException ex) 
    		  {
    		           System.err.println(ex);
    		  } catch (IOException e1) {
				
				e1.printStackTrace();
			}
    
    	}

		@SuppressWarnings("null")

		String getWheretoSave() 
		{
			
			 fs = new JFileChooser(fname);
			 fs.setPreferredSize(new Dimension(800,600));
			 fs.setDialogTitle("SAVE SNAPSHOT");
 		     
		     fs.setAcceptAllFileFilterUsed(false);
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG images", "jpg");
			 fs.addChoosableFileFilter(filter);
			 int retVal=fs.showSaveDialog(null);
		     File file = fname;
			
			 if(retVal==JFileChooser.APPROVE_OPTION)
			
			 {
			    file=fs.getSelectedFile();
				if(file.exists())
				{
					JOptionPane.showMessageDialog(null, "Cannot have a file with same filename. Rename the file",null, 1); 
					
					getWheretoSave();
				
				}	
				else if(!file.exists())
				{
					fileFlag=true;
					if(fileFlag==true)
					{
					  return file.getAbsolutePath();
					}
					
				}
			
			}
			else if(retVal==JFileChooser.CANCEL_OPTION)
					{
				      System.exit(0);
					}
			
			return null;
			
		}
    
    }
