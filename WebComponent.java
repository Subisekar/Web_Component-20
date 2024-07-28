import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebComponent {
	public static void main(String[] args) {
        

        //  Chrome driver
        ChromeDriver driver = new ChromeDriver();

        try {
            // Maximise 
            driver.manage().window().maximize();

            //  URL
            driver.get("https://jqueryui.com/datepicker/");

            // Switch to the iframe 
       driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

       // datepicker
       WebElement datepicker = driver.findElement(By.id("datepicker"));
       datepicker.click();
       
    //  next month button
       WebElement nextMonthButton = driver.findElement(By.xpath("//a[@title='Next']"));
       nextMonthButton.click();

       
    // Select the date "22"
       WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
       dateToSelect.click();
       
    // Get the selected date
       String selectedDate = datepicker.getAttribute("value");
       
       
    // Print the selected date 
       System.out.println("Selected date: " + selectedDate);
       
        } finally {
            // Close 
            driver.quit();
        }
    }
}