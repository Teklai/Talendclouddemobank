package org.example.talendclouddemobank.beansjar.aggregationstrategies;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;


public class JSONArrayAggStrategy implements AggregationStrategy {
	

public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
	
	StringBuilder sb = new StringBuilder();
	
    if (oldExchange == null) { // Add the starting array bracket
  	  sb.append("[\n")
  	    .append(newExchange.getIn().getBody(String.class));
  	  
  	  newExchange.getIn().setBody(sb.toString(), String.class);
        return newExchange;
    }

    // Combine the two payloads with a comma/newline to separate JSON array objects
    sb.append(oldExchange.getIn().getBody(String.class))
    	.append(",\n")
    	.append(newExchange.getIn().getBody(String.class));
    
    oldExchange.getIn().setBody(sb.toString(), String.class);
    
    return oldExchange;
	}
	
	@Override
		public void onCompletion(Exchange exchange) {
			// Put the ending bracket on the JSON object array
			StringBuilder sb = new StringBuilder();
			sb.append(exchange.getIn().getBody(String.class))
			  .append("\n]");
		
			exchange.getIn().setBody(sb.toString());
	}
}
