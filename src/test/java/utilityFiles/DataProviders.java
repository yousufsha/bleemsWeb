package utilityFiles;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	 @DataProvider(name = "searchData")
	    public Object[] getData() {

	        return new Object[] {
	                "Bint Al Jannah",
	                "Holy Month Cake Painting",
	                "White Shaped Bowl",
	                "Rise Of Love 1",
	                "Perfect Iaso Hand"
	        };
	    }
}