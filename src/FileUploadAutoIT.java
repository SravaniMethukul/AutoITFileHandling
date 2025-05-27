import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String downloadPath = System.getProperty("user.dir"); // To get the path of the project
		System.out.println(downloadPath);

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriverManager.chromedriver().browserVersion("137.0.7151.41").setup();

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		
		driver.findElement(By.cssSelector("#pickfiles")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("P:\\TestScriptsAutoIT\\fileUpload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#processTask")));
		
		driver.findElement(By.cssSelector("#processTask")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pickfiles")));
		driver.findElement(By.cssSelector("#pickfiles")).click();
		Thread.sleep(5000);
		
		File f = new File(downloadPath+"/ilovepdf_pages-to-jpg.zip");
		

		if (f.exists()) {
		    System.out.println("File found");
		    if(f.delete()) {
		    	System.out.println("file deleted");
		    }
		}
		else {
			System.out.println("file not found");
		}
		
	}

}
