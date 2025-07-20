package routines;

import routines.system.DynamicMetadata;
import routines.system.Dynamic;

import org.apache.log4j.Logger;

import java.util.List;


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
public class DynamicDBTypeMapper {
	
	private static Logger LOG = Logger.getLogger(DynamicDBTypeMapper.class); 
	
    /**
     * mapDBTypes: Returns a Dynamic record mapped based on the input lists.
     * 
     * 
     * {talendTypes} Dynamic
     * 
     * {Category} User Defined
     * 
     * {param} Dynamic(record) input: The dynamic record to be mapped.
     * {param} List<Object>(sourceTypeList) input: The source types to map.  This is a list of Strings.
     * {param} List<Object>(sourceMinLengthList) input: The minimum field length for this mapping.  This is a list of Integers.
     * {param} List<Object>(targetTypeList) input: The target types to map.  This is a list of Strings.
     * {param} List<Object>(targetPrecisionList) input: The target precisions to map.  This is a list of Integers.
     * 
     * {example} mapDBTypes(record, sourceTypeList, sourceMinLengthList, targetTypeList, targetPrecisionList) # dynamic
     */
    public static Dynamic mapDBTypes(Dynamic record, List<Object> sourceTypeList, List<Object> sourceMinLengthList, List<Object> targetTypeList, List<Object> targetPrecisionList) {

    	
		for ( DynamicMetadata dm : record.metadatas) {
			
			for ( int i = 0; i < sourceTypeList.size(); i++ ) {
				// Read in the current mapping values
				String sourceType = (String) sourceTypeList.get(i);
				Integer sourceMinLength = (Integer) sourceMinLengthList.get(i);
				String targetType = (String) targetTypeList.get(i);
				Integer targetPrecision = (Integer) targetPrecisionList.get(i);
				
				if ( sourceMinLength != null && sourceMinLength <= dm.getLength() && sourceType.equals(dm.getDbType()) ) {
					LOG.debug("Replacing Source Type: " + sourceType + " for Target Type: " + targetType + " in column " + dm.getName());
					dm.setDbType(targetType);
					
					if ( targetPrecision != null ) {  // Set Precision
						dm.setPrecision(targetPrecision);
					}
					
				} else if ( sourceMinLength == null && sourceType.equals(dm.getDbType()) ) {
					LOG.debug("Replacing Source Type: " + sourceType + " for Target Type: " + targetType + " in column " + dm.getName());
					dm.setDbType(targetType);
					
					if ( targetPrecision != null ) {  // Set Precision
						dm.setPrecision(targetPrecision);
					}
				}	
			}
		}
		
		return record;
    }
	
}
