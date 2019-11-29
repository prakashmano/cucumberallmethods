package com.cucumber.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserlaunch(String browser) {
	try {
		if(browser=="chrome"){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Prakash\\eclipse\\java-oxygen\\CucumberAllMethods\\src\\test\\resource\\com\\cucumber\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser=="firefox")
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ajith\\workspace\\Baseclass\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}
	 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	return driver; 
	}
	public static String getInputfromExcelAndgetText(int row, int cellnum) throws Exception {
		// TODO Auto-generated method stub
		String stringCellValue = null;
		File f = new File("C:\\Users\\Prakash\\eclipse\\java-oxygen\\CucumberAllMethods\\excel\\Excel1.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb1 = new XSSFWorkbook(fi);
		Sheet sheetAt = wb1.getSheetAt(0);
		Cell cell = sheetAt.getRow(row).getCell(cellnum);
		if (cell.getCellType().equals(CellType.STRING)) {
		String stringCellValue2 = cell.getStringCellValue();
		System.out.println(stringCellValue2);
		}
		else if (cell.getCellType().equals(CellType.NUMERIC)) {
		double numericCellValue = cell.getNumericCellValue();
		long l = (long) numericCellValue;
		stringCellValue = String.valueOf(l);
		System.out.println(stringCellValue);
		}
		return stringCellValue;
		}
	
	
	public static void geturl(String url) throws Exception {
	try {
		driver.get(url);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception("INVALID URL");
	}
	}
	public static void mousehover(WebElement element) {
		try {
			Actions ac=new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String currenturl() {
	try {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return currenturl();
	}
	public static void scroll(WebElement element) {
	try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrolltoView", element);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	public static boolean elementisdisplay(WebElement element) {
		boolean displayed=false;
	try {
		displayed = element.isDisplayed();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return displayed;
	}
	public static boolean elementisenable(WebElement element) {
		boolean enabled=false;
	try {
		enabled = element.isEnabled();
		System.out.println(enabled);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return enabled;

	}
	public static boolean elementiselected(WebElement element) {
		boolean selected=false;
	try {
		selected=element.isSelected();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return selected;
	}
	public static void sendkeys(WebElement element,String value) throws Throwable {
		try {
			if (elementisdisplay(element)&&elementisenable(element)) {
				element.clear();
				element.sendKeys(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("value is not present");
		}
	}
	public static String gettitle() {
	String title =null;
	try {
		title = driver.getTitle();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return title;
	}
	public static void dropdown(WebElement element,String option,String i) {
	Select s=new Select(element);
	try {
		if (option.equals("index")) {
			s.selectByIndex(Integer.parseInt(i));
			
		}else if (option.equals("text")) {
			s.selectByVisibleText(i);
		}
		else if (option.equals("value")) {
			s.selectByValue(i);
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void clickelement(WebElement element) {
	try {
		element.click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void navigateto(String url) {
	try {
		driver.navigate().to(url);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void navigateforward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void navigatebackward() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void navigaterefresh() {
		
	try {
		driver.navigate().refresh();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static String gettext(WebElement element) {
		
		try {
			element.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public static void getattribute(WebElement element) {
	try {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	public static void radiobutton(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

	public static void getoptions(WebElement element) {
		Select y = new Select(element);
		List<WebElement> options = y.getOptions();
		for (WebElement y1 : options) {
			System.out.println(y1.getText());
	}
	}
		public static void clickkk(WebElement element) {
			Actions ac2 = new Actions(driver);
			ac2.click(element).build().perform();
		}


		public static void rightclick(WebElement element) {
			Actions ac3 = new Actions(driver);
			ac3.contextClick(element).build().perform();

		}

		public static void sendkeysActions(WebElement element, String value) {
			Actions ac4 = new Actions(driver);
			ac4.sendKeys(element, value).build().perform();
		}


		public static void robotttt(WebElement element, String value) throws Exception {
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

		public void dragdrop(WebElement element1, WebElement element2) {

			Actions ac = new Actions(driver);
			ac.dragAndDrop(element1, element2).build().perform();

		}


		public void iframes(WebElement elements) {
			driver.switchTo().frame(elements);

		}


		public static void waitforvisibilityofelment(WebElement element) {

			try {
				WebDriverWait wb = new WebDriverWait(driver, 30);
				wb.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// is displayed

		public static boolean elementisDisplayed(WebElement element) {
			boolean displayed = false;

			try {
				displayed = element.isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return displayed;

		}

		// is enabled

		public static boolean elementisenabled(WebElement element) {
			boolean enabled = false;

			try {
				enabled = element.isEnabled();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return enabled;

		}

		// is selected

		public boolean elementisselected(WebElement element) {

			boolean selected = false;
			try {
				selected = element.isSelected();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return selected;
		

}


}
