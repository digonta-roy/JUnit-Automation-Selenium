import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.logfile", "D:\\selenium_logs\\chromedriver.log");
        System.setProperty("webdriver.chrome.silentOutput", "true"); // optional: disables extra console noise
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-breakpad"); // disables crash dumps
        options.addArguments("user-data-dir=D:/chrome_profiles/test_profile"); // moves browser data to D
        driver = new ChromeDriver(options);
        //driver is obj of ChromeDriver(); this method uses Webdriver to show his capabilites
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("Check Title") //test title
    @Test
    public void visitWebsite() {
        driver.get("https://demoqa.com/");
        String expectedResult = driver.getTitle();//expected result
        String actualResult = "DEMOQA";//actual result
        Assertions.assertEquals(expectedResult, actualResult);//test status


    }

    @Test
    public void submitForm() {
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Test User");
        driver.findElement(By.cssSelector("[type=email]")).sendKeys("testuser@test.com");
        List<WebElement> elements = driver.findElements(By.className("form-control"));
        elements.get(2).sendKeys("Dhaka");
        elements.get(3).sendKeys("Chattogram");

        JavascriptExecutor js = (JavascriptExecutor) driver; //keeping WebDriver in J..Exe.. to do no scrolling...so casting is needed
        js.executeScript("window.scrollBy(0,500)");

//            List<WebElement> btnElement = driver.findElements(By.tagName("button"));
//            btnElement.get(1).click();
        driver.findElements(By.tagName("button")).get(1).click();

        List<WebElement> textElement = driver.findElements(By.tagName("p"));
        String usernameActual = textElement.get(0).getText();
        String emailActual = textElement.get(1).getText();
        String curraddActual = textElement.get(2).getText();
        String peraddActual = textElement.get(3).getText();

        Assertions.assertTrue(usernameActual.contains("Test User"));
        Assertions.assertTrue(emailActual.contains("testuser@test.com"));
        Assertions.assertTrue(curraddActual.contains("Dhaka"));
        Assertions.assertTrue(peraddActual.contains("Chattogram"));


    }

    @Test
    public void doubClick() {
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        actions.doubleClick(buttons.get(1)).perform();
        actions.contextClick(buttons.get(2)).perform();
        actions.click(buttons.get(3)).perform();
        // actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
    }

    @Test
    public void handleAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();//.dismiss() instead of .accept() for "cancel" instead of "ok"
    }

    @Test
    public void setDate() {
        driver.get("https://demoqa.com/date-picker");
        WebElement txtdate = driver.findElement(By.id("datePickerMonthYearInput"));
        //Actions actions = new Actions(driver);
        txtdate.click();
        txtdate.sendKeys(Keys.CONTROL + "a");
        txtdate.sendKeys(Keys.BACK_SPACE);
        txtdate.sendKeys("07/01/2025");
        txtdate.sendKeys(Keys.ENTER);

    }

//    @Test
//    public void selectDropdown() throws InterruptedException {
//        driver.get("https://demoqa.com/select-menu");

    /// /        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
    /// /        select.selectByVisibleText("Magenta");
//        List<WebElement> dropdown = driver.findElements(By.className("css-1hwfws3"));
//        dropdown.get(1).click();
//        Thread.sleep(1000);
//        //dropdown.get(1).sendKeys(Keys.ENTER);
//        Actions actions = new Actions(driver);
//        for (int i = 0; i < 3; i++) {
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//        }
//        actions.sendKeys(Keys.ENTER).perform();
//    }
    @Test
    public void selectDropdown() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
//        Select select=new Select(driver.findElement(By.id("oldSelectMenu")));
//        select.selectByVisibleText("Green");
        List<WebElement> dropdown = driver.findElements(By.className("css-1hwfws3"));
        dropdown.get(1).click();
        Thread.sleep(1000);
//        dropdown.get(1).sendKeys(Keys.ARROW_DOWN);
//        dropdown.get(1).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
//        for (int i = 0; i < 2; i++) {
//            actions.sendKeys(Keys.ARROW_DOWN).perform();
//        }
//        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }

    //    @Test
//    public void mouseHover(){
//        driver.get("https://www.aiub.edu/");
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),\"About\")]"))).perform();
//    }
    @Test
    public void mouseHoverMultiple() throws InterruptedException {
        driver.get("https://www.aiub.edu/");
        Actions actions = new Actions(driver);

        // Step 1: Store menu texts in a String array
        String[] menuItems = {"About", "Academics", "Administration", "Research"};
        // Step 2: Loop through each text and hover over it
        for (String item : menuItems) {
            WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'" + item + "')]"));
            actions.moveToElement(menu).perform();
            Thread.sleep(1500); // Wait to see the hover effect
        }
    }

    @Test
    public void multipleTabs() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);
        ArrayList<String> arrayList = new ArrayList(driver.getWindowHandles());
        //System.out.println(arrayList);
        driver.switchTo().window(arrayList.get(1));
        String heading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(heading);
        driver.close();
        driver.switchTo().window(arrayList.get(0));

    }

    @Test
    public void handlemultiplewindow() {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterator = allWindow.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                String txt = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(txt);
            }
        }
        driver.close();
        driver.switchTo().window(parentWindow);

    }

    @Test
    public void scrapData() {
        driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> allRows = table.findElements(By.cssSelector("[role=rowgroup]"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.cssSelector("[role=gridcell]"));
            for (WebElement cell : cells) {
                System.out.println(cell.getText());
            }
        }


    }


    @Test
    public void handleIframe() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assertions.assertTrue(text.contains("This is a sample page"));
        driver.switchTo().defaultContent();
    }

    @Test
    public void uploadAndDownloadFile() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        String filePath = System.getProperty("user.dir") + "./src/test/resources/nature.png";
        WebElement uploadInput = driver.findElement(By.id("uploadFile"));
        uploadInput.sendKeys(filePath);
        Thread.sleep(2000);
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();
        Thread.sleep(2000);
    }


    @AfterAll
    public void tearDown() {
        driver.quit();
    }


}



