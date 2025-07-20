package beans;
import org.apache.camel.Exchange; 
import org.apache.camel.Header; 
import java.util.Random;

public class processMessage {
	
	static int nbOfMsg = 0;
    
    public static void updateMessageBody(Exchange exch, @Header("Company") String company) { 
    	Random randomGenerator = new Random();
    	int randomInt = randomGenerator.nextInt(3);
    	if (randomInt == 1) {
    		exch.getIn().setBody("The first rule of "+company+" Club is: you do not talk about "+company+" Club."); 
    	} else if (randomInt == 2) { 
    		exch.getIn().setBody(company+" is going to make you an offer you can't refuse.");
    	} else {
    		exch.getIn().setBody("May "+company+" be with you!");
    	}
    } 
    
    public static void incrementMessages() {
    	nbOfMsg ++;
    	System.out.println("Message #"+nbOfMsg);
    }
}
