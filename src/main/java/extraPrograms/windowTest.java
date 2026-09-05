package extraPrograms;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		//==========================Implicit Waits========================================
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
	
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		//driver.navigate().to(""https://www.google.com);
		
		//=========================Navigation ======================
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
		//===================
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(1024,768));
		driver.manage().window().setPosition(new Point(100,100));
		
		//===================== Waits= Explicit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement speaking = driver.findElement(By.xpath("//ul[@id='menu-primary']/li[4]/a"));
		
		wait.until(ExpectedConditions.elementToBeClickable(speaking));
		//wait.until(ExpectedConditions.presenceOfElementLocated(footerLocator));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(finishTextLocator));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinnerLocator));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(dynamicMessageLocator, "It's gone!"));
		//wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listItemsLocator, 3));
		//wait.until(ExpectedConditions.alertIsPresent());
		

		//================================Single Web Elements ==============================
		WebElement elementId = driver.findElement(By.id("menu-item-8"));
		elementId.click();
		//WebELement elementName = driver.findElement(By.name(""));
		//elementName.click();
		WebElement elementXpath = driver.findElement(By.xpath("//li[@id='menu-item-9']/a"));
		elementXpath.click();
		WebElement elementCssSelector = driver.findElement(By.cssSelector("#menu-item-10 > a"));
		elementCssSelector.click();
		WebElement elementLinkText = driver.findElement(By.linkText("SPEAKING"));
		elementLinkText.click();
		WebElement elementPartialLinkText = driver.findElement(By.partialLinkText("TEACH"));
		elementPartialLinkText.click();
		WebElement elementTagName = driver.findElement(By.tagName("a"));
		elementTagName.click();
		//WebElement elementClassName = driver.findElement(By.className("nav-menu"));
		//elementClassName.click();
		
		//====================== List Web Elements ================================
		
		
		List<WebElement> elementList = driver.findElements(By.tagName("a"));
		for(WebElement element: elementList) {
			System.out.println(element.getText());
		}	
		
		//====================== Cookies ========================================
		
		Set<Cookie> allCookie = driver.manage().getCookies();
		
		for(Cookie cookie: allCookie) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		driver.manage().deleteAllCookies();
		
		//====================== Logs ==========================================
		
		LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
		LogEntries driverLogs = driver.manage().logs().get(LogType.DRIVER);
		
		System.out.println("Browser Logs:");
		System.out.println(browserLogs);
		System.out.println("Driver Logs:");
		System.out.println(driverLogs);
		
		//=======================================================================
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
		searchBox.sendKeys("Test Automation");
		searchBox.clear();
		searchBox.sendKeys("Selenium");
		searchBox.sendKeys(Keys.ENTER);
		//searchBox.submit();
		
		//String eleText = searchBox.getText();
		//System.out.println(" TextSearch Box :"+eleText);
		//searchBtn.click();
		
		WebElement eleTwo = driver.findElement(By.className("page-title"));
		String eleTwoText = eleTwo.getText();
		String eleTwoAttr = eleTwo.getAttribute("value");
		String eleCss  = eleTwo.getCssValue("background-color");
		
		System.out.println(" TextSearch Box :"+eleTwoText);
		System.out.println(" TextSearch Box Attr Val:"+eleTwoAttr);
		System.out.println(" TextSearch Box CSS Val:"+eleCss);
		
		boolean isDisp = eleTwo.isDisplayed();
		System.out.println("IsDisplayed :"+isDisp);
		boolean isEnab = eleTwo.isEnabled();
		System.out.println("IsEnabled :"+isEnab);
		boolean isSele = eleTwo.isSelected();
		System.out.println("IsSelected :"+isSele);
		
		
		WebElement dropElement  = driver.findElement(By.id("dropdownId"));
		Select sel = new Select(dropElement);
		
		sel.selectByIndex(1);
		sel.selectByValue("US");
		sel.selectByVisibleText("USA");
		
		sel.deselectAll();
		
		Actions act = new Actions(driver);
		
		WebElement menu = driver.findElement(By.id("menuId"));
		WebElement target = driver.findElement(By.id("targetId"));
		
		act.moveToElement(menu).build().perform();
		act.dragAndDrop(menu,target).build().perform();
		act.contextClick(menu).perform();
		act.doubleClick(menu).perform();
		
		act.sendKeys(Keys.ENTER).perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		
		al.accept();
		al.dismiss();
		
		
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame_name");
		driver.switchTo().defaultContent();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String windowHandle: allWindows) {
			if(!parentWindow.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement el = driver.findElement(By.id("hidden-btn"));
		js.executeScript("arguments[0].click();", el);
		
		//driver.close();
		driver.quit();
	}

}
