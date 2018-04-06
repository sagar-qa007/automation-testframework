package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import WebElement.LoginWebe;




public class ExecutionSetup
{

	public static WebDriver driver = null;

	static boolean loginStatus;
	public static LoginWebe login_webe;
	
	
	@Parameters("browser")
	public static void setUp(String browser)
	{
		try
		{
			System.out.println("-------------------------------------------------------------> In BeforeSuite");
				
			if(browser.equals("chrome"))
			{
				String exePath = "C:\\Users\\abc\\Desktop\\Server\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", exePath);
				driver = new ChromeDriver();
				
			}
			else if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);
			}
			else if(browser.equals("ie"))
			{
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.google.com");
				cap.setCapability("ignoreProtectedModeSettings", false);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setJavascriptEnabled(true);
				cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1);
				cap.setCapability("cssSelectorsEnabled", true);
				cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

				driver = new InternetExplorerDriver(cap);	
			}
			else if(browser.equals("edge"))
			{
				 System.setProperty("webdriver.edge.driver","D://Selenium Training//Selenium Environment Files//MicrosoftWebDriver.exe"); 
				 
	              driver = new EdgeDriver();
			}
			else
			{
				System.out.println("Kindly check Browser parameter from TestNG XML file.");
			}
			driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
		}
		catch (Exception e)
		{
			System.out.println("----------------------------------- > Problem found in Setup Method ");
			e.printStackTrace();
		}
	}

	
	public static void tearDown()
	{

		try
		{
			System.out.println("In AfterSuite");
			//driver.close();
			driver.quit();
			driver = null;
			System.out.println("-------------------------------> Complete tearDown");
		}
		catch (Exception e)
		{
			System.out.println("Problem found in :: tearDown");
			e.printStackTrace();
		}
	}

	
	public static WebDriver getDriver()
	{
		return driver;

	}

}
