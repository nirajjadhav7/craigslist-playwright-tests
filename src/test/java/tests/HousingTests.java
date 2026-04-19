package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HousingPage;

public class HousingTests extends BaseTest {

	
	/*
	    Sorting on housing page "£££ → £" (HighToLow)	 
	 */
    @Test (testName = "Sorting on housing page - £££ → £ (HighToLow)")

    public void selectPriceHighToLowTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectPriceHighToLow();

        
        String selected = housing.getSelectedSortText();

        Assert.assertEquals(selected, "£££ → £");
    }
    
    /*
         Sorting on housing page "£ → £££" (LowToHigh)	 
    */
    
    @Test (testName = "Sorting on housing page - £ → £££ (LowToHigh)")
    public void selectPriceLowToHighTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectPriceLowToHigh();

        String selected = housing.getSelectedLowToHighText();

        Assert.assertEquals(selected, "£ → £££");
    }
    
    /*
          Sorting on housing page "newest"	 
    */
    
    @Test (testName = "Sorting on housing page - newest")
    public void selectNewestTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.openSortDropdown();
        housing.selectNewest();

        String selected = housing.getSelectedNewestText();

        Assert.assertEquals(selected, "newest");
    }
    
    
      /*
            Sorting on housing page "relevance"	 
      */
    
    @Test (testName = "Sorting on housing page - relevance")
    public void selectRelevancetTest() {

        HousingPage housing = new HousingPage(page);

        housing.navigateToHousing();
        housing.searchHousing("House");
        housing.openSortDropdown();
        housing.selectRelevance();

        String selected = housing.getselectRelevanceText();

        Assert.assertEquals(selected, "relevance");
    }
    
       /*
            Sorting on housing page "upcoming"	 
       */
    
    @Test (testName = "Sorting on housing page - upcoming")
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
    
    @Test  (testName = "Sorting (price ⬆, price ⬇)")
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
          By default, sorting possibilities available: (price ⬆, price ⬇, newest)
     */
    
    @Test (testName = "By default, sorting possibilities available: (price ⬆, price ⬇, newest)")
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
               After using search, sorting possibilities available : (price ⬆, price ⬇, newest, upcoming,
               relevance)
     */
    
    
    @Test (testName = "After using search, sorting possibilities available : (price ⬆, price ⬇, newest, upcoming, relevance)")
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