package org.example.talendclouddemobank.beansjar.embedded_activemq;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.kahadb.KahaDBPersistenceAdapter;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class EmbeddedActiveMQBroker {

    /**
     * Create_Broker
     */
    public static BrokerService startBrokerService(String brokerName, String brokerHost, int brokerPort, boolean isPersistent, String persistenceDir) {
    	BrokerService brokerService = new BrokerService();
    	brokerService.setBrokerName(brokerName);

    	try {
	    	// Add connector (default tcp://localhost:61616)
	    	brokerService.addConnector("tcp://" + brokerHost + ":" + brokerPort);
	    	brokerService.addConnector("vm://localhost");
	
	    	// Persistence
	    	brokerService.setPersistent(isPersistent);
	    	if ( isPersistent ) { // If persistent, set persistence directory
	    		KahaDBPersistenceAdapter kahaDb = (KahaDBPersistenceAdapter) brokerService.getPersistenceAdapter();
	    		kahaDb.setDirectory(new java.io.File(persistenceDir));
	    	}
	
	    	// Start the broker
	    	brokerService.start();
	    	
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    	
    	return brokerService;
    }
}
