import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuviSignup {

	public static void main(String[] args) {
       

        //  the Chrome driver
        ChromeDriver driver = new ChromeDriver();

        try {
            // Maximize 
            driver.manage().window().maximize();

            // the URL
            driver.get("https://www.guvi.in/");

            // Locate the Signup button 
            WebElement signupButton = driver.findElement(By.xpath("//*[@id=\"sidebarTabs\"]/ul/div[5]/a[1]"));
            signupButton.click();

            // Fill in the signup form with required details
            driver.findElement(By.id("name")).sendKeys("User Name");
            driver.findElement(By.id("email")).sendKeys("Testemail@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Testpassword");

            // Click on the "Signup" button 
            WebElement submitSignupButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
            submitSignupButton.click();

            // Wait for the page to load 
            Thread.sleep(5000); 
            String signupTitle = driver.getTitle();
            if (signupTitle.contains("Welcome")) {
                System.out.println("User registered successfully");
            } else {
                System.out.println("User registration failed");
            }

            // Locate the Login button 
            WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
            loginButton.click();

            // Fill in the login form with the email and password 
            driver.findElement(By.id("email")).sendKeys("Testemail@gmail.com");
            driver.findElement(By.id("password")).sendKeys("Testpassword");

            // Click on the "Login" button 
            WebElement submitLoginButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
            submitLoginButton.click();

            // Wait for the page 
            Thread.sleep(5000); 
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


