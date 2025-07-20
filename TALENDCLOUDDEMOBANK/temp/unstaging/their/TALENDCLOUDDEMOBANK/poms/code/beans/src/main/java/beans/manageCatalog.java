package beans;
import org.apache.camel.Exchange; 
import org.apache.camel.Header; 

public class manageCatalog {

	private static int USID = 10009374;
	private static int EUID = 20008105;
	private static int UKID = 30006247;
	
    public static void addNewProduct(Exchange exch, @Header("productID") String productID, @Header("price") String price, @Header("title") String title, @Header("countryCode") String countryCode) {
    	String currency = "$";
    	int newID = 0;
    	if (countryCode.equals("US")) {
    		newID = ++ USID;
    	} else if (countryCode.equals("EU")) {
    		newID = ++ EUID;
    		currency = "€";
    	} else if (countryCode.equals("UK")) {
    		newID = ++ UKID;
    		currency = "£";
    	}
    	System.out.println("*** CATALOG UPDATE ***\nNew product added to the "+countryCode+" catalog: "+title+", "+currency+price+" with ID #"+newID+"\n");
    }
}
