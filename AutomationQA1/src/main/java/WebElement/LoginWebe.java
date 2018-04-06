package WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebe {

	
		
		@FindBy(id = "")
		static WebElement id;
		
		
		static LoginWebe INSTANCE = null;

		public static LoginWebe getInstance(WebDriver driver)
		{
			if (INSTANCE != null)
			{
				INSTANCE = null;
				INSTANCE = PageFactory.initElements(driver, LoginWebe.class);
			}
			else
			{
				INSTANCE = PageFactory.initElements(driver, LoginWebe.class);
			}
			return INSTANCE;
		}


	}
