package utils;
  
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import org.testng.Assert;
import org.testng.annotations.*;

public class HousingTests {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void createPage() {
        page = browser.newPage();
        page.navigate("https://madrid.craigslist.org/"); // example URL
        page.click("//*[@id=\"langlinks\"]/a");
        page.click("//*[@id=\"hhh\"]/h3/a/span");
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    public void selectPriceHighToLow() {

        // Click dropdown
    	
    	page.click("xpath=/html/body/div[1]/main/div[1]/div[1]/div[1]/div[2]/span");
    	
      	//page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("newest")).click();
    	
       
        String selected = page.locator("button.cl-search-sort-mode-price-desc .label").innerText();
        Assert.assertEquals(selected, "£££ → £");
    }
}