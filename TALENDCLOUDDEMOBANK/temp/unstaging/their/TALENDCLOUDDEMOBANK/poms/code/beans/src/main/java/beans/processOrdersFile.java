package beans;
import org.apache.camel.Exchange; 
import org.apache.camel.Header; 

public class processOrdersFile {

    public static void defineRouteSequence(Exchange exch, @Header("discount") String discount) {
        int discountValue = Integer.parseInt(discount);
    	if (discountValue > 0) {
            exch.getIn().setHeader("routeSequence", "direct:startProcess, direct:infoStock,direct:applyDiscount,direct:billCustomer");
        } else {
        	exch.getIn().setHeader("routeSequence", "direct:startProcess, direct:infoStock,direct:billCustomer");
        }
    }
}
