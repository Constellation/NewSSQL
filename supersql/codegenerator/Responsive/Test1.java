package supersql.codegenerator.Responsive;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

import supersql.codegenerator.Fraction;
import supersql.common.GlobalEnv;


public class Test1 {

	public static void main(String[] args) {
		//Initialization of WebDriver (Firefox)
		String driverPath = GlobalEnv.getworkingDir()+"/webdriver/geckodriver";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Initialization of WebDriver (Chrome)
//		String driverPath = GlobalEnv.getworkingDir()+"/webdriver/chromedriver";
//		System.setProperty("webdriver.chrome.driver", exePath);
//		WebDriver driver = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
        
		//LinkedHashMap for final fixes
		LinkedHashMap<String,LinkedHashMap> fixMap = new LinkedHashMap<String,LinkedHashMap>();
		
		
		//Get page of URL
        driver.get("http://localhost/dvdrental/php_movie_foreach.html?att=27");

        //lg 1200, md 992, sm 768, xs 400
        //Variables for G1 Fix Test
        int x=8;
        String G1TFE = "TFE10020";
        
        //Get G1 Element
        WebElement element = driver.findElement(By.className("TFE10020"));
        List<WebElement> elements = driver.findElements(By.className("TFE10020"));
        
        
        
        HashMap<String,Integer> G1widthMap = new HashMap<String,Integer>();
        //Get width of each display size
        driver.manage().window().setSize(new Dimension(1200,3000));
        G1widthMap.put("lg", element.getSize().width);
        
        driver.manage().window().setSize(new Dimension(992,3000));
        G1widthMap.put("md", element.getSize().width);
        
        driver.manage().window().setSize(new Dimension(768,3000));
        G1widthMap.put("sm", element.getSize().width);
                
        driver.manage().window().setSize(new Dimension(400,3000));
        G1widthMap.put("xs", element.getSize().width);
        
        //Calculate Best
        for(Map.Entry<String, Integer> e : G1widthMap.entrySet()) {
        	double minDiff=5000;
            int best = 0;
            
            LinkedHashMap<String,Fraction> G1fixMap = new LinkedHashMap<String,Fraction>();
            
        	String size = e.getKey();
        	int eachwidth = e.getValue();
        	
        	if(e.getKey()!="lg"){
	        	for(int i=0; i<x; i++){
	                double width = Math.floor( (eachwidth * x ) / ( x-i ) );
	                if (Math.abs(width-G1widthMap.get("lg")) < minDiff){
	                	minDiff = Math.abs(width-G1widthMap.get("lg"));
	                	best = x-i;
	                }
	            }
	        	System.out.println(best+"\n");
	        	
	            double fixWidth = 100.0/best;
	            BigDecimal bd =new BigDecimal(fixWidth);
	            BigDecimal bd4 = bd.setScale(3, BigDecimal.ROUND_DOWN);

	            
	        	G1fixMap.put("TFE10020", new Fraction("1/"+best));
	        	fixMap.put(size, G1fixMap);
	            System.out.println(fixMap);
        	}
        }

        //Apply CSS
        for(WebElement each : elements){
        	((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'width:100%')",each);
        }
        
//        CaptureScreenshot(driver, js);
        
        
        // Enter something to search for
//        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();

        // Check the title of the page
//        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });

        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
    }
	
	public static void CaptureScreenshot(WebDriver driver, JavascriptExecutor js){
		TakesScreenshot ts = (TakesScreenshot) new Augmenter().augment(driver);
        
	      //画面サイズで必要なものを取得
	        int innerH = Integer.parseInt(String.valueOf(js.executeScript("return window.innerHeight")));
	        int innerW =Integer.parseInt(String.valueOf(js.executeScript("return window.innerWidth")));
	        int scrollH = Integer.parseInt(String.valueOf(js.executeScript("return document.documentElement.scrollHeight")));
	        
	      //イメージを扱うための準備
	        BufferedImage img = new BufferedImage(innerW, scrollH, BufferedImage.TYPE_INT_ARGB);
	        Graphics g = img.getGraphics();
	        
	        try {
		      //スクロールを行うかの判定
		        if(innerH>scrollH){
		            BufferedImage imageParts = ImageIO.read(ts.getScreenshotAs(OutputType.FILE));
		            g.drawImage(imageParts, 0, 0, null);
		        } else {
		            int scrollableH = scrollH;
		            int i = 0;
		
		            //スクロールしながらなんどもイメージを結合していく
		            while(scrollableH>innerH){
		                BufferedImage imageParts = ImageIO.read(ts.getScreenshotAs(OutputType.FILE));
		                g.drawImage(imageParts, 0, innerH*i, null);
		                scrollableH=scrollableH - innerH;
		                i++;
		                js.executeScript("window.scrollTo(0,"+innerH*i+")");
		            }
		
		            //一番下まで行ったときは、下から埋めるように貼り付け
		            BufferedImage imageParts = ImageIO.read(ts.getScreenshotAs(OutputType.FILE));
		            g.drawImage(imageParts, 0, scrollH - innerH, null);
		        }
		
		        ImageIO.write(img, "png", new File("/Users/ryosuke/Desktop/screenshot"+ System.currentTimeMillis() +".png"));
	        } catch (WebDriverException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}

}
