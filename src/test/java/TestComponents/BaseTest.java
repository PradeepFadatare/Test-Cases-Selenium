package TestComponents;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public String email;
    public String password;

    public WebDriver InitializeBrowser() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Resources//GlobalData.properties");
        properties.load(fis);
        email = properties.getProperty("email");
        password = properties.getProperty("password");
        String BrowserName = properties.getProperty("browser");
        if (BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager manager = new ChromeDriverManager();
            driver = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("firefox")) {
            WebDriverManager manager = new FirefoxDriverManager();
            driver = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("edge")) {
            WebDriverManager manager = new EdgeDriverManager();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

//    @BeforeMethod
//    public LoginPage launchApp() throws IOException {
//        driver=InitializeBrowser();
//        loginPage = new LoginPage(driver);
//        loginPage.goToLoginPage();
//        return loginPage;
//        File file = new File("C:\\Users\\prade\\IdeaProjects\\Mds_Woocommerce\\src\\main\\java\\Resources\\cookies.data");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] token = line.split(";");
//            String name = token[0];
//            String value = token[1];
//            String domain = token[2];
//            String path = token[3];
//            String expiry = token[4];
//            boolean isSecure = Boolean.parseBoolean(token[5]);
//
//            // Create a new Cookie object
//            org.openqa.selenium.Cookie cookie;
//            cookie = new org.openqa.selenium.Cookie(name, value, domain, path, null, isSecure);
//            // Add the cookie to the current session
//            driver.manage().addCookie((org.openqa.selenium.Cookie) cookie);
//        }
//        bufferedReader.close();
//
//        // Refresh the page to apply cookies
//        driver.navigate().refresh();
//
//        // Continue with your test actions
//        System.out.println("Session cookies loaded!");
//
//    }


    @BeforeMethod
    public LoginPage loginWithCookies() throws IOException {
        WebDriver driver = InitializeBrowser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();

        // Load cookies from the file
        File file = new File("C:\\Users\\prade\\IdeaProjects\\Mds_Woocommerce\\src\\main\\java\\Resources\\cookies.data");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] token = line.split(";");
            String name = token[0];
            String value = token[1];
            String domain = token[2];
            String path = token[3];
            String expiry = token[4]; // Expiry is read but not used here
            boolean isSecure = Boolean.parseBoolean(token[5]);

            // Create a new Cookie object with null expiry
            org.openqa.selenium.Cookie cookie = new org.openqa.selenium.Cookie(name, value, domain, path, null, isSecure);
            // Add the cookie to the current session
            driver.manage().addCookie(cookie);
        }
        bufferedReader.close();

        // Refresh the page to apply cookies
        driver.navigate().refresh();

        // Continue with your test actions
        System.out.println("Session cookies loaded!");

        return loginPage;  // Return the login page object at the end
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}



