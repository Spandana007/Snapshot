import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SnapshotElement {
	private static final String LocalDateTime = null;
	//private static Object driver;
	static WebDriver driver;
	public static void main(String args[])
	{
		try{
			
				
				/* Thread.sleep(2000);
			     Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			     ImageIO.write(fpScreenshot.getImage(),"JPG",new File("C:\\Users\\SPANDANA\\Desktop\\FullPageScreenshot.png"));
				*/
				 
			     
			       // driver.manage().window().maximize();
			        /*WebElement myWebElement = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("example")));
			        Thread.sleep(1000);
		            Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000).takeScreenshot(driver);
		            ImageIO.write(myScreenshot.getImage(),"JPG",new File("C:\\Users\\SPANDANA\\Desktop\\elementScreenshot.png"));
		            driver.quit();*/
			String key  = "webdriver.chrome.driver";
	        String value = "C:\\Users\\SPANDANA\\Desktop\\Prism\\chromedriver_win32\\chromedriver.exe";
	        System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/examples/basic_init/scroll_y.html");
		            WebElement scroll = driver.findElement(By.id("example"));
		            scroll.sendKeys(Keys.PAGE_DOWN);
		            
		            
		            
		            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						BufferedImage  fullImg = ImageIO.read(screenshot);

						//Get the location of element on the page
						Point point = scroll.getLocation();

						// Get width and height of the element
						int eleWidth = scroll.getSize().getWidth();
						int eleHeight = scroll.getSize().getHeight();

						// Crop the entire page screenshot to get only element screenshot
					BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
					ImageIO.write(eleScreenshot, "jpg", screenshot);

						// Copy the element screenshot to disk
						File screenshotLocation = new File("C:\\Users\\SPANDANA\\Desktop\\screenshot.jpg");
						FileHandler.copy(screenshot, screenshotLocation);
						driver.quit();
		            
			     
			
				
				
			}
			
		
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
