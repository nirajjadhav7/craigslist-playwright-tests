package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HousingPage;

public class HousingTests extends BaseTest {

    @Test
    public void selectPriceHighToLowTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectPriceHighToLow();

        
        String selected = housing.getSelectedSortText();

        Assert.assertEquals(selected, "£££ → £");
    }
    
    
    @Test
    public void selectPriceLowToHighTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectPriceLowToHigh();

        String selected = housing.getSelectedLowToHighText();

        Assert.assertEquals(selected, "£ → £££");
    }
    
    
    
    @Test
    public void selectNewestTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectNewest();

        String selected = housing.getSelectedNewestText();

        Assert.assertEquals(selected, "newest");
    }
    
    
    @Test
    public void selectRelevancetTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.searchHousing("House");
        housing.openSortDropdown();
        housing.selectRelevance();

        String selected = housing.getselectRelevanceText();

        Assert.assertEquals(selected, "relevance");
    }
    
    
    @Test
    public void selectUpcomingtTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectUpcoming();

        String selected = housing.getselectUpcomingText();

        Assert.assertEquals(selected, "upcoming");
     
        
      
        Assert.assertEquals(housing.getNoResultsText().trim(), "no results found");
        
    }
    
     /*
              Sorting (price ⬆, price ⬇)
      */
    
    @Test 
    public void SortingPrice() {
    	
        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectPriceHighToLow();

        
        String selected = housing.getSelectedSortText();
        Assert.assertEquals(selected, "£££ → £");
        
        
        housing.openSortDropdown();
        housing.selectPriceLowToHigh();
        
        String selected1 = housing.getSelectedLowToHighText();
        Assert.assertEquals(selected1, "£ → £££");
    	
    	
    }
    
    
    /*
          By default, such sorting possibilities are available (price ⬆, price ⬇, newest)
     */
    
    @Test
    public void ByDefaultSortingPossibilities() {
    	
        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectPriceHighToLow();

        
        String selected = housing.getSelectedSortText();
        Assert.assertEquals(selected, "£££ → £");
        
        
        housing.openSortDropdown();
        housing.selectPriceLowToHigh();
        
        String selected1 = housing.getSelectedLowToHighText();
        Assert.assertEquals(selected1, "£ → £££");
        
        
        housing.openSortDropdown();
        housing.selectNewest();
       

        String selected2 = housing.getSelectedNewestText();
        Assert.assertEquals(selected2, "newest");
    	
    	
    }
    
    
    
    /*
               After using search such sorting possibilities are available (price ⬆, price ⬇, newest, upcoming,
               relevant)
     */
    
    
    @Test
    public void AfterUsingSearchSortingPossibilities() {

        HousingPage housing = new HousingPage(page);
        
        

        housing.navigateToHousing();
        housing.searchHousing("House");
        housing.openSortDropdown();
        housing.selectNewest();
       

        String selected = housing.getSelectedNewestText();

        Assert.assertEquals(selected, "newest");
        
      
        
        housing.openSortDropdown();
        housing.selectPriceHighToLow();
        
      String selected1 = housing.getSelectedSortText();

      Assert.assertEquals(selected1, "£££ → £");
   
      
      
      housing.openSortDropdown();
      housing.selectPriceLowToHigh();
      
      String selected2 = housing.getSelectedLowToHighText();

      Assert.assertEquals(selected2, "£ → £££");
       
      
      
      housing.openSortDropdown();
      housing.selectRelevance();

      String selected3 = housing.getselectRelevanceText();

      Assert.assertEquals(selected3, "relevance");
      
      
      housing.openSortDropdown();
      housing.selectUpcoming();

      String selected4 = housing.getselectUpcomingText();

      Assert.assertEquals(selected4, "upcoming");
      

   
        
        
    }
    
    
}