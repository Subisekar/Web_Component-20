import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GuviSignup2 {

	public static void main(String[] args) throws InterruptedException {
       

        //  the Chrome driver
        ChromeDriver driver = new ChromeDriver();

        try {
            // Maximize 
            driver.manage().window().maximize();

            // the URL
            driver.get("https://www.guvi.in/");

            // Locate the Signup button 
            WebElement signupButton = driver.findElement(By.cssSelector("body > main > div.navbar.shadow-md.py-1.px-0._nav_fc38z_1 > div > div.pr-3 > div > div:nth-child(2) > a"));
            signupButton.click();

            
            // Fill in the signup form with required details
            driver.findElement(By.id("name")).sendKeys("Testwo Name");
            driver.findElement(By.id("email")).sendKeys("Testemail19@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Test2password");
            driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9900567890");
            
            
         // Click on the "Signup" button to submit the form
            WebElement submitSignupButton = driver.findElement(By.id("signup-btn"));
            submitSignupButton.click();
            
            Thread.sleep(5000);
            
            WebElement profile =driver.findElement(By.xpath("//*[@id=\"profileDrpDwn\"]"));
            Select select= new Select(profile);
            
            select.selectByValue("Student");
            
            WebElement degree =driver.findElement(By.xpath("//*[@id=\"degreeDrpDwn\"]"));
            Select select2= new Select(degree);
            
            select2.selectByValue("B.E. / B.Tech. Computer Science");
            
            driver.findElement(By.id("year")).sendKeys("2020");
            driver.findElement(By.xpath("//*[@id=\"details-btn\"]")).click();
            
            //successfully login
            System.out.println("User registered successfully");
            
            // reload the page
            driver.executeScript("location.reload()");
            
            // Locate the Login button
            driver.findElement(By.xpath("//a[text()='Login']")).click();
            
            
            //email
            driver.findElement(By.id("email")).sendKeys("Testemail19@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Test2password");
            
            //Login Button
            driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
            
            //wait
            Thread.sleep(5000); // Add an appropriate wait
            String loginTitle = driver.getTitle();
            if (loginTitle.contains("Dashboard")) {
                System.out.println("User logged in successfully");
            } else {
                System.out.println("User login failed");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            
            
        }
        finally {
            // Close the browser
        	  driver.quit();
        }
	}
}