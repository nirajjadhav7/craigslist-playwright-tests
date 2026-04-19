package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HousingPage {

    private Page page;

    public HousingPage(Page page) {
        this.page = page;
    }

    // Navigate to housing page
    public void navigateToHousing() {
        page.navigate("https://madrid.craigslist.org/");
        page.locator("#langlinks a").click();
        page.click("//*[@id=\"hhh\"]/h3/a/span");
      
    }

    // Click sorting drop-down
    public void openSortDropdown() {
    
    	page.locator("div.cl-search-sort-mode").click();
    }

    // Select price high to low 
    public void selectPriceHighToLow() {
    	
        page.locator("button.cl-search-sort-mode-price-desc").click();
        
    }

    // Get selected label high to low
    public String getSelectedSortText() {
    	
        return page.locator("button.cl-search-sort-mode-price-desc .label").innerText();
        
    }
    
    
   // Select price low to high
    public void selectPriceLowToHigh() {
        page.locator("button.cl-search-sort-mode-price-asc").click();
     
    }

    // Get selected label for low → high
    public String getSelectedLowToHighText() {
   
        return page.locator("button.cl-search-sort-mode-price-asc .label").innerText();
    }
    
    
    // Select Newest Drop-down
    public void selectNewest() {
    	
            page.locator("button.cl-search-sort-mode-newest").first().click();
               
    }

    // Get selected label for Newest
    public String getSelectedNewestText() {
        return page.locator("button.cl-search-sort-mode-newest .label").innerText();
    }
    
    
     // Search Under Search Housing Field   
    public HousingPage searchHousing(String keyword) {
        Locator searchBox = page.getByPlaceholder("Search housing");
        searchBox.fill(keyword);
        page.locator("button.cl-exec-search").first().click();

        page.waitForLoadState(LoadState.NETWORKIDLE);
        return this;
    }
    
    // Select Relevance Drop-down
    public void selectRelevance() {
    	
            page.locator("button.cl-search-sort-mode-relevance").first().click();
                     
    }

    // Get selected label for Relevance
    public String getselectRelevanceText() {
        return page.locator("button.cl-search-sort-mode-relevance .label").innerText();
    }
    
    
    
    
    // Select Upcoming Drop-down
    public void selectUpcoming() {
    	
            page.locator("button.cl-search-sort-mode-upcoming").first().click();
       
    }

    // Get selected label for Upcoming
    public String getselectUpcomingText() {
        return page.locator("button.cl-search-sort-mode-upcoming .label").innerText();
    }
    
    
    // No Result Text from Upcoming Page
    public String getNoResultsText() {
        return page.locator("p.no-results-title").innerText();
    }

 
    
}