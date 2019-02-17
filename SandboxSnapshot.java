
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;


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
public class SandboxSnapshot extends JFrame {
 
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * 
    */
	
	JButton GetSnapshotButton;
	JLabel savesnapshotLabel;
	
	
    public SandboxSnapshot(){
    GetSnapshotButton=new JButton("Get Snapshot");
    GetSnapshotButton.setBounds(300,0,300,50);
    add(GetSnapshotButton);
    
    
    
    GetSnapshotButton.addActionListener(new ActionListener(){
    	
    	public void actionPerformed(ActionEvent e) 
    	{
    		try {
    		     /*
    		      * Let the program wait for 5 seconds to allow you to open the
    		      * window whose screenshot has to be captured
    		      */
    		      Thread.sleep(5000);
    		      Robot robot = new Robot();
    		     // String fileName = "C://PartScreenshot.jpg";

    		     
    		      Rectangle rectArea = new Rectangle(10, 50, 500, 400);
    		      BufferedImage screenFullImage = robot.createScreenCapture(rectArea);
    		     // ImageIO.write(screenFullImage, "jpg", new File(fileName));

    		      
    		      
    		      JOptionPane waitPane = new JOptionPane("Snapshot is captured successfully", JOptionPane.INFORMATION_MESSAGE);
    		      JDialog waitDialog = waitPane.createDialog(null, "Capture snapshot");
    		      waitDialog.setVisible(true);
    		      JFileChooser fs=new JFileChooser();
    		      fs.setCurrentDirectory(new File("C:\\"));
    		      fs.setFileFilter(new FileNameExtensionFilter("JPEG images","jpeg","jpg"));
    		      fs.setDialogTitle("Save Snapshot");
    		     // fs.setFileFilter(new FileTypeFilter(".jpeg"," JPEG file"));
    		      String path = "C:// Shot.jpg";
    		      int result=fs.showSaveDialog(null);
    		      if(result==JFileChooser.APPROVE_OPTION)
    		      {
    		    	  
    		    	  
    		    	  try{
    		    		 // ImageIO.write(screenFullImage, ".jpeg", fs.getSelectedFile());
    		    		  ImageIO.write(screenFullImage, ".jpeg", new File(path));
    		    		  JOptionPane waitPane1 = new JOptionPane("Snapshot is saved successfully", JOptionPane.INFORMATION_MESSAGE);
    		    		  JDialog waitDialog1 = waitPane1.createDialog(null, "Saved Snapshot");
    		    		  waitDialog1.setVisible(true);
    		    	  }
    		    	  catch(Exception e2)
    		    	  {
    		    		  
    		    		  JOptionPane waitPane2 = new JOptionPane("Failed to save snapshot", JOptionPane.INFORMATION_MESSAGE);
    		    		  JDialog waitDialog2 = waitPane2.createDialog(null, "Failed message");
    		    		  waitDialog2.setVisible(true);
    		    	  }
    		      }
    		      
    		      
    	    		 
    		     
    		      
    		      
    		  } 
    		  catch (AWTException | InterruptedException ex) 
    		  {
    		           System.err.println(ex);
    		  }
    		
   		    
    		
    	 
    	}
    
    });
    
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(700,400);
    setVisible(true);
 }
    
    
     public static void main(String[] args) 
     {
    	new SandboxSnapshot();
    	
    	
           
     }
    }

