package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getData() throws IOException {
	    String path = System.getProperty("user.dir")+ "//testData//UserTestData.xlsx"; // Taking xl file from testData

	    ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for XLUtility

	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);

	    String apidata[][] = new String[totalrows][totalcols]; // Created for two-dimensional array to store the data

	    for (int i = 1; i <= totalrows; i++) { // Read the data from xl storing in two-dimensional array
	        for (int j = 0; j < totalcols; j++) { // i is rows, j is columns
	        	apidata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
	        }
	    }
	    return apidata; // Returning two-dimensional array
	}

	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
	    String path = System.getProperty("user.dir")+ "//testData//UserTestData.xlsx"; // Taking xl file from testData
	    ExcelUtility xlutil = new ExcelUtility(path); // Creating an object for XLUtility

	    int rownum = xlutil.getRowCount("Sheet1");
	     String apidata[] = new String[rownum];
	    for (int i = 1; i <= rownum; i++) { 
	        	apidata[i - 1] = xlutil.getCellData("Sheet1", i, 1); // 1,0

	    }
	    return apidata; // Returning two-dimensional array
	}

}
