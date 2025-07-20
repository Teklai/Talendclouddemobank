package routines;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class String_Routines {
	
	/*
	Functions include:
	
	1.  addEnclosingChar_Checked:  Returns the passed expression surrounded with the specified character, if not already in place.  Ignores case for enclosing character.
	2.  addEnclosingChars:  Returns the passed expression surrounded with the specified enclosure text.
	3.  addEnclosingQuotes_Checked:  Returns the passed expression surrounded with the specified character, if not already in place.
	4.  changeNull:  Returns null when the first expression equals the second or is already null.
	5.  ConvertString:  Converts the passed big decimal or integer to a string.
	6.  emptyInd:  Checks whether the passed expression is empty -- null or of zero length after trimming.
	7.  equalsInd:  The function checks whether the two passed arguments equal each other.
	7.  formatNumber:  Formats the passed number using the specified style.
	8.  len:  Returns the length of the passed expression -- 0 for null values.
	9.  lpad:   Left pads the passed expression with the specified character.
	10.  moveLastCharToFirst:  Potentially moves the last character of the passed expression to the first.  The character gets moved when equal to the one passed.
	11.  nullIf:  Returns the second expression when the first is empty or null.  Otherwise, returns the original (first) expression.
	12.  nvl:  Returns the second expression when the first is null.  Otherwise, returns the original (first) expression.
	13.  parseFileDateText:  Extracts the date text from the passed filename.  Typical date text format:  yyyy-MM-ddTMM-dd-yy.
	14.  parseFileDateText_Date:  Extracts the date text from the passed filename and returns a date.
	15.  parseFileFromPath:  Extracts filename from full path containing directory and filename.
	16.  removeSimilarRejectText:  Removes the similar text occurring for rejects - to prevent partial duplicates.  Only keeps text occurring before " - Line:".
	17.  replaceAll_Ext:  Replaces all instances of the specified text in the passed expression.
	18.  rpad:  Right pads the passed expression with the specified character.
	19.  split_Ext:  Splits the passed expression using the specified text.  Returns the specified word / piece number.
	20.  split_Ind:  Checks the passed expression for whether splitting can occur.
	21.  split_Once:  Splits the passed expression using the specified text.  If getting the first piece, returns text up to the separator.  If getting the second piece, returns text after the separator.
	22.  string_equals:  Returns whether the passed expressions match.  Allows for matches where both equal null.  Case-Sensitive.
	23.  substring_equals:  Returns whether the leftmost characters of the passed expression match the search phrase.  Allows for matches where both equal null.  Case-Sensitive.
	24.  substring_ext:  Extracts the first x characters from the passed expression.
	25.  substring_ext_quote:  Extracts the first x characters from the passed expression.  The procedure first removes any surrounding single quotes.  Upon completion, the single quotes get added back.
	26.  substring_Max:  Returns the shorter of the first n characters or full length of the expression.
	27.  translateText:  Checks whether the passed expression equals the from parameter.  Returns null for expressions that are already null.  Returns the to parameter when the expression matches the from.  Equality checks ARE case sensitive.
	28.  translateTextIgnoreCase:  Checks whether the passed expression equals the from parameter.  Returns null for expressions that are already null.  Returns the to parameter when the expression matches the from.  Equality checks are NOT case sensitive.
	29.  translateTextNvl:  Checks whether the passed expression equals the from parameter.  Returns the last (nvl) parameter for expressions that are already null.  Returns the to parameter when the expression matches the from.  Equality checks ARE case sensitive.
	30.  translateTextNvl_IgnoreCase:  Checks whether the passed expression equals the from parameter.  Returns the last (nvl) parameter for expressions that are already null.  Returns the to parameter when the expression matches the from.  Equality checks are NOT case sensitive.
	31.  translateText_Flag:  Checks whether the passed expression equals true or false.  Returns null for expressions that are already null.  Returns Y for true and N for false, ignoring case.  Otherwise, the procedure returns the original expression.
	32.  translateText_TwoItems:  Checks whether the passed expression equals any of the from parameters.  Returns null for expressions that are already null.  Returns the first to parameter matching the from.  Otherwise, returns the original expression.  Equality checks ARE case sensitive.
	33.  translateText_TwoItems_IgnoreCase:  Checks whether the passed expression equals any of the from parameters.  Returns null for expressions that are already null.  Returns the first to parameter matching the from.  Otherwise, returns the original expression.  Equality checks are NOT case sensitive.
	34.  translateTextNvl_TwoItems:  Checks whether the passed expression equals any of the from parameters.  Returns the last (nvl) parameter for expressions that are already null.  Returns the first to parameter matching the from.  Otherwise, returns the original expression.  Equality checks ARE case sensitive.
	35.  translateTextNvl_TwoItems_IgnoreCase:  Checks whether the passed expression equals any of the from parameters.  Returns the last (nvl) parameter for expressions that are already null.  Returns the first to parameter matching the from.  Otherwise, returns the original expression.  Equality checks are NOT case sensitive.
	36.  trimBoth:  Trims the specified text from both sides of the passed expression.
	37.  trimBoth_Replace:  Trims the specified character from both sides of the passed expression.  Then, performs the specified (character) replacement.
	38.  trimEnd:  Trims the specified character from the right of the passed expression.
	39.  trimExcelQuotes:  Removes formula text (as in Excel) from the passed expression.
	40.  trimFront:  Trims the specified character from the left of the passed expression.
	41.  trimQuotes:  Removes double quotes (") that surround the passed expression.
	42.  trimQuotes_RemoveCommas:  Removes double quotes (") that surround the passed expression along with any commas.
	43.  tryClob2String:  Converts a CLOB to a String.
	*/
	
	/**
     * The procedure returns the passed expression surrounded with the specified
     * character, if not already in place.  Ignores case for enclosing
     * character.
	 *
     * Examples for use:
     * result = String_Routines.addEnclosingChar_Checked("Hello World", 'x');
     * Returns Hello World surrounded with x on each side.
     * Returns xHello Worldx.
     *
     * result = String_Routines.addEnclosingChar_Checked("Hello World", 'H');
     * Returns Hello World surrounded with H on each side.
     * Returns Hello WorldH.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to enclose.
	 * 
     * {param} char('x') chrEnclose: Character to use to enclose text.
     * 
     * {example} addEnclosingChars("Hello World", 'x') # "xHello Worldx"
     * 
     */
    public static String addEnclosingChar_Checked (String strExpression, 
      char chrEnclose)
    
    {
    // The procedure returns the passed expression surrounded with the specified
    // character, if not already in place.  Ignores case for enclosing
    // character.
    //
    // Examples for use:
    //
    // result = String_Routines.addEnclosingChar_Checked("Hello World", 'x');
    // Returns Hello World surrounded with x on each side.
    // Returns xHello Worldx.
    //
    // result = String_Routines.addEnclosingChar_Checked("Hello World", 'H');
    // Returns Hello World surrounded with H on each side.
    // Returns Hello WorldH.
    
    String strChar; // Character passed, converted to a string.
    String strReturn; // Value to return.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
        
      {
      // Expression null or empty.
          
      // Return null.
      return null;
      }
        
    else
        	
      {
      // Expression contains text.
      
      // Convert passed character to a string.
      strChar = String.valueOf(chrEnclose);
      
      // If desired character found on left side of expression, then...
      if (strExpression.charAt(0) == chrEnclose)
      
        {
        // Desired character found on left side of expression.
        strReturn = strExpression;
        }
      
      // Otherwise, ... -- Desired character NOT found on left side of expression.
      else
          
        {
        // Desired character NOT found on left side of expression.
        
        // Add character to left side of expression.
        strReturn = strChar + strExpression;
        }
      
      // If desired character found on right side of expression, then...
      if (strExpression.charAt(strExpression.length() - 1) == chrEnclose)
      
        {
        // Desired character found on right side of expression.
        }
      
      else
          
        {
        // Desired character NOT found on right side of expression.
        
        // Add character to right side of expression.
        strReturn += strChar;
        }
    
      // Return expression with desired surrounding character.
      return strReturn;
      }
    
    }
    
	/**
     * The procedure returns the passed expression surrounded with the specified
     * enclosure text.
	 *
     * Example for use:
     * result = String_Routines.addEnclosingChars("Hello World", "x");
     * Returns "Hello World" enclosed with "x" on each side.
     * Returns "xHello Worldx".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to enclose.
	 * 
     * {param} String("x") strEncloseText: Text to use when enclosing expression.
     * 
     * {example} addEnclosingChars("Hello World", "x") # "xHello Worldx"
     * 
     */
    public static String addEnclosingChars (String strExpression, String strEncloseText)
      
    {
    // The procedure returns the passed expression surrounded with the specified
    // enclosure text.
    //
    // Example for use:
    //
    // result = String_Routines.addEnclosingChars("Hello World", "x");
    // Returns "Hello World" enclosed with "x" on each side.
    // Returns "xHello Worldx".
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Return shorter of first n characters or entire length of expression.
      return strEncloseText + strExpression + strEncloseText;
      }
    
    }
	
	/**
     * The procedure returns the passed expression surrounded with the specified
     * character, if not already in place.
	 *
     * Example for use:
     * result = String_Routines.addEnclosingQuotes_Checked("Hello World");
     * Returns Hello World surrounded with single quotes (') on each side.
     * Returns 'Hello World'.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to enclose.
     * 
     * {example} addEnclosingQuotes_Checked # 'Hello World'
     * 
     */
    public static String addEnclosingQuotes_Checked (String strExpression)
    
    {
    // The procedure returns the passed expression surrounded with the specified
    // character, if not already in place.
    //
    // Example for use:
    //
    // result = String_Routines.addEnclosingQuotes_Checked("Hello World");
    // Returns Hello World surrounded with single quotes (') on each side.
    // Returns 'Hello World'.
    
    String strReturn; // Value to return.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
        
      {
      // Expression null or empty.
          
      // Return null.
      return null;
      }
        
    else
        	
      {
      // Expression contains text.
      
      // If desired character found on left side of expression, then...
      if (strExpression.charAt(0) == '\'')
      
        {
        // Desired character found on left side of expression.
        strReturn = strExpression;
        }
      
      // Otherwise, ... -- Desired character NOT found on left side of expression.
      else
          
        {
        // Desired character NOT found on left side of expression.
        
        // Add character to left side of expression.
        strReturn = "'" + strExpression;
        }
      
      // If desired character found on right side of expression, then...
      if (strExpression.charAt(strExpression.length() - 1) == '\'')
      
        {
        // Desired character found on right side of expression.
        }
      
      else
          
        {
        // Desired character NOT found on right side of expression.
        
        // Add character to right side of expression.
        strReturn += "'";
        }
    
      // Return expression with desired surrounding character.
      return strReturn;
      }
    
    }
	
    /**
     * The procedure checks whether the first expression equals the second.
     * If the first is null, returns null.
     * If the first equals the second, returns null.
     * Otherwise, returns first parameter.
     *
     * Example for use:
     *
     * result = String_Routines.changeNull("Not assigned", "Not assigned");
     * Returns null.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Not assigned") strExpression: Text to check whether null or matches second parameter.
     * 
     * {param} String("Not assigned") strCheckText: Text to check matches first parameter.
     * 
     * {example} changeNull("Not assigned", "Not assigned") # null
     * 
     */
    public static String changeNull (String strExpression, String strCheckText)
    
    {
    // The procedure checks whether the first expression equals the second.
    // If the first is null, returns null.
    // If the first equals the second, returns null.
    // Otherwise, returns first parameter.
    //
    // Example for use:
    //
    // result = String_Routines.changeNull("Not assigned", "Not assigned");
    // Returns null.
    
    // If expression is null, then...
    if (Relational.ISNULL(strExpression))
      
      {
      // Expression is null.
          
      // Return null.
      return null;
      }
        
    else if (strExpression.equalsIgnoreCase(strCheckText))
        	
      {
      // Expression contains text that matches second parameter.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text does not NOT match second parameter.
      
      // Return original expression.
      return strExpression;
      }
    
    }
    
	/**
     * The procedure converts the passed BigDecimal to a String.
     * The procedure returns null when the expression equals null.
	 *
     * Example for use:
     * result = String_Routines.ConvertString(126.53);
     * Converts 126.53 from big decimal to string.
     * Returns "126.53".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} BigDecimal(126.53) bgExpression: Big decimal to convert to a string.
     * 
     * {example} ConvertString(126.53) # "126.53"
     * 
     */
    public static String ConvertString (BigDecimal bgExpression)
    
    {
    // The procedure converts the passed big decimal to a string.
    // The procedure returns null when the expression equals null.
    //
    // Example for use:
    // result = String_Routines.ConvertString(126.53);
    // Converts 126.53 from big decimal to string.
    // Returns "126.53".
    
	DecimalFormat df; // Decimal format to use when returning value.  Example:  #.##.
	
	// Set decimal format.
	df = new DecimalFormat("#.###############");
	
    // If passed in value is null, then...
    if (Relational.ISNULL(bgExpression))
      
      {
      // Passed in value is null.  Return null.
      return null;
      }
    	
    else
    	
      {
      // Passed in value is not null.
      
      // Convert passed in (big decimal) value to string.
      return df.format(bgExpression.doubleValue());
      } // End ... Passed in value is not null.
    
    } // End ... Procedure -- ConvertString
	
    /**
     * The procedure converts the passed integer to a String.
	 *
     * Example for use:
     * result = String_Routines.ConvertString(126);
     * Converts 126 from integer to string.
     * Returns "126".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} int(126) intExpression: Integer to convert to a string.
     * 
     * {example} ConvertString(126) # "126"
     * 
     */
    public static String ConvertString (int intExpression)
    
    {
    // The procedure converts the passed integer to a string.
    //
    // Example for use:
    // result = String_Routines.ConvertString(126);
    // Converts 126 from integer to string.
    // Returns "126".
      
    // Convert passed in (integer) value to string.
    return String.valueOf(intExpression);
    
    } // End ... Procedure -- ConvertString
    
	/**
     * The procedure checks whether the passed expression is empty.
     * The procedure considers the following as empty:
     * 1.  Expressions that are null.
     * 2.  Expressions that are of zero length.
     * 3.  Expressions that are of zero length after trimming spaces and tabs.
     *
     * The procedure returns boolean (true or false).
	 *
     * Example for use:
     * result = String_Routines.emptyInd("");
     * Returns whether "" is an empty string.
     * Returns true.
     * 
     * {talendTypes} boolean | Boolean
     * 
     * {Category} String_Routines
     * 
     * {param} String("") strExpression: Text to check whether empty (or null).
     * 
     * {example} emptyInd("") # true
     * 
     */
    public static boolean emptyInd (String strExpression)
    
    {
    // The procedure checks whether the passed expression is empty.
    // The procedure considers the following as empty:
    // 1.  Expressions that are null.
    // 2.  Expressions that are of zero length.
    // 3.  Expressions that are of zero length after trimming spaces and tabs.
    //
    // The procedure returns boolean (true or false).
    //
    // Example for use:
    // result = String_Routines.emptyInd("");
    // Returns whether "" is an empty string.
    // Returns true.
    
    // Return whether expression is empty (after trimming spaces and tabs) or null.
    return Relational.ISNULL(strExpression) ? true : 
      (StringHandling.TRIM(strExpression).length() == 0 ? true : false);
    }
	
	/**
     * The procedure checks whether the passed expression is empty.
     * The procedure considers the following as empty:
     * 1.  Expressions that are null.
     * 2.  Expressions that are of zero length.
     * 3.  Expressions that are of zero length after trimming spaces and tabs.
     * 4.  Expressions matching the value in the parameter, strNullText.
     *
     * The procedure returns boolean (true or false).
	 *
     * Examples for use:
     * result = String_Routines.emptyInd("", "<null>");
     * Returns whether "" is an empty string.
     * Returns true.
	 *
     * result = String_Routines.emptyInd("<null>", "<null>");
     * Returns whether "" is an empty string.
     * Returns true.
     * 
     * {talendTypes} boolean | Boolean
     * 
     * {Category} String_Routines
     * 
     * {param} String("") strExpression: Text to check whether empty (or null).
	 * 
     * {param} String("<null>") strNullText: Text to consider as null.
     * 
     * {example} emptyInd("", "<null>") # true
     * 
     */
    public static boolean emptyInd (String strExpression, String strNullText)
      
    {
    // The procedure checks whether the passed expression is empty.
    // The procedure considers the following as empty:
    // 1.  Expressions that are null.
    // 2.  Expressions that are of zero length.
    // 3.  Expressions that are of zero length after trimming spaces and tabs.
    // 4.  Expressions matching the value in the parameter, strNullText.
    //
    // The procedure returns boolean (true or false).
    //
    // Examples for use:
    //
    // result = String_Routines.emptyInd("", "<null>");
    // Returns whether "" is an empty string.
    // Returns true.
    //
    // result = String_Routines.emptyInd("<null>", "<null>");
    // Returns whether "" is an empty string.
    // Returns true.
    
    // Return whether expression is empty (after trimming spaces and tabs) or null.
    return Relational.ISNULL(strExpression) ? true : 
      (StringHandling.TRIM(strExpression).length() == 0 ? true : 
      (strExpression.equals(strNullText) ? true : false));
    }
	
    /**
     * The function checks whether the two passed arguments equal each other.
     * The function optionally uses checks for equality use case sensitivity.
     *
     * Example for use:
     * result = String_Routines.equalsInd("ABC", "ABC", false);
     * Returns "Y", since the two passed arguments equal one another.
     * 
     * {talendTypes} boolean | Boolean
     * 
     * {Category} String_Routines
     * 
     * {param} String("ABC") strExpression: Text to check for equality to second parameter.
	 * 
     * {param} String("DEF") strEquals: Text to check for equality to first parameter.
     * 
     * {param} boolean(false) blnCaseSensitive: Whether to use case sensitivity in text equality check.
     * 
     * {example} equalsInd("ABC", "ABC", false) # true
     * 
     */
    public static boolean equalsInd (String strExpression, String strEquals, 
      boolean blnCaseSensitive)
    
    {
    // The function checks whether the two passed arguments equal each other.
    // The function optionally uses checks for equality use case sensitivity.
    //
    // Example for use:
    // result = String_Routines.equalsInd("ABC", "ABC");
    // Returns "Y", since the two passed arguments equal one another.
    
    // If both parameters are null, then...
    if (Relational.ISNULL(strExpression) && Relational.ISNULL(strEquals))
    
      {
      // Both parameters are null.
    	
      // Return true, since parameters equal one another.
      return true;
      }
    	
    // Otherwise, if one parameter is null and the other is not, then...
    else if ((Relational.ISNULL(strExpression) && !Relational.ISNULL(strEquals)) ||
      (!Relational.ISNULL(strExpression) && Relational.ISNULL(strEquals)))
    
      {
      // Return false, since one parameter is null and the other is not.
      return false;
      }
    	
    // Otherwise, if the two parameters contain the same text 
    // (based upon passed case sensitive flag), then...
    else if (strExpression.equals(strEquals) || 
      (!blnCaseSensitive && strExpression.equalsIgnoreCase(strEquals)))
    	
      {
      // Parameters contain the same text -- based on passed case sensitive flag.
        
      // Return true, since parameters equal one another.
      return true;
      }
    
    else
    	
      {
      // Parameters contain different text.
      return false;
      }
    
    }
    
    /**
     * The function formats the passed number using the specified style.
     * The function returns a text version of the passed number.
     * The procedure returns null for expressions that are already null.
     *
     * Example for use:
     * result = String_Routines.formatNumber(5, "00");
     * Returns "05" - "5" left padded with "0", to meet format of "00".
     * Returns "05".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} Integer(5) intExpression: Number (Integer) to format.
	 * 
     * {param} String("00") strFormat: Numeric format to use.
     * 
     * {example} formatNumber(5, "00") # "05"
     * 
     */
    public static String formatNumber (Integer intExpression, String strFormat)
    
    {
    // The function formats the passed number using the specified style.
    // The function returns a text version of the passed number.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.formatNumber(5, "00");
    // Returns "05" - "5" left padded with "0", to meet format of "00".
    // Returns "05".
    
    NumberFormat nf; // Number format object.
    
    // If passed number is null, then...
    if (Relational.ISNULL(intExpression))
    
      {
      // Passed number is null.
    	
      // Return null.
      return null;
      }
    	
    else
    	
      {
      // Passed number is not null.
    	
      // Set numeric format.
      nf = new DecimalFormat(strFormat);
        
      // Return number converted to specified format.
      return nf.format(intExpression);
      }
    
    }
    
    /**
     * The function formats the passed number using the specified style.
     * The function returns a text version of the passed number.
     * The procedure returns null for expressions that are already null.
     *
     * Example for use:
     * result = String_Routines.formatNumber(5d, "00");
     * Returns "05" - "5" left padded with "0", to meet format of "00".
     * Returns "05".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} double(5) dblExpression: Number (double) to format.
	 * 
     * {param} String("00") strFormat: Numeric format to use.
     * 
     * {example} formatNumber(5d, "00") # "05"
     * 
     */
    public static String formatNumber (double dblExpression, String strFormat)
    
    {
    // The function formats the passed number using the specified style.
    // The function returns a text version of the passed number.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.formatNumber(5d, "00");
    // Returns "05" - "5" left padded with "0", to meet format of "00".
    // Returns "05".
    
    NumberFormat nf; // Number format object.
    
    // If passed number is null, then...
    if (Relational.ISNULL(dblExpression))
    
      {
      // Passed number is null.
    	
      // Return null.
      return null;
      }
    	
    else
    	
      {
      // Passed number is not null.
    	
      // Set numeric format.
      nf = new DecimalFormat(strFormat);
        
      // Return number converted to specified format.
      return nf.format(dblExpression);
      }
    
    }
    
    /**
     * The procedure returns the length of the passed expression.
     * The procedure returns 0 for nulls.
     *
     * Example for use:
     * result = String_Routines.len("200478298");
     * Returns 9.
     * 
     * {talendTypes} Integer
     * 
     * {Category} String_Routines
     * 
     * {param} String("200478298") strExpression: Text for which to determine length.
     * 
     * {example} len("200478298") # 9
     * 
     */
    public static Integer len (String strExpression)
      
    {
    // The procedure returns the length of the passed expression.
    // The procedure returns 0 for nulls.
    //
    // Example for use:
    // result = String_Routines.len("200478298");
    // Returns 9.
    
    // If expression is null, then...
    if (Relational.ISNULL(strExpression))
    
      {
      // Expression is null.
      
      // Return 0.
      return 0;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Return length of passed expression.
      return strExpression.length();
      }
    	
    }
    
	/**
     * The procedure left pads the passed expression with the specified character.
	 *
     * Example for use:
     * result = String_Routines.lpad("200478298", 12, '0');
     * Returns "200478298", left padded with 0, to reach twelve characters in length.
     * Returns "000200478298".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("200478298") strExpression: Text to pad on the left.
	 * 
     * {param} Integer(12) intNumChar: Number of characters to include in returned value.
	 * 
     * {param} char('0') chrPad: Character to pad expression.
     * 
     * {example} lpad("200478298", 12, '0') # "000200478298"
     * 
     */
    public static String lpad (String strExpression, Integer intNumChar, char chrPad)
      
    {
    // The procedure left pads the passed expression with the specified character.
    //
    // Example for use:
    // result = String_Routines.lpad("200478298", 12, '0');
    // Returns "200478298", left padded with 0, to reach twelve characters in length.
    // Returns "000200478298".
    
    String strRepeatText; // Text with repeating characters.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Set repeating text.
      strRepeatText = new String(new char[intNumChar]).replace("\0", 
        String.valueOf(chrPad));
      
      // Return left padded text.
      return strRepeatText.substring(strExpression.length()) + strExpression;
      }
    	
    }
	
    /**
     * The procedure (potentially) moves the last character of the passed expression
     * to the first.
     * The character gets moved when equal to the one passed.
     *
     * Example for use:
     * result = String_Routines.moveLastCharToFirst("1127.00-", '-');
     * Returns "-1127.00", the expression with the dash moved from the last
     * character to the first.
     * Returns "-1127.00".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("1127.00-") strExpression: Text in which to move character.
	 * 
     * {param} char('-') chrCharacter: Character to move from last to first.
     * 
     * {example} moveLastCharToFirst("1127.00-", '-') # "-1127.00"
     * 
     */
    public static String moveLastCharToFirst (String strExpression, char chrCharacter)
      
    {
    // The procedure (potentially) moves the last character of the passed expression
    // to the first.
    // The character gets moved when equal to the one passed.
    //
    // Example for use:
    // result = String_Routines.moveLastCharToFirst("1127.00-", '-');
    // Returns "-1127.00", the expression with the dash moved from the last
    // character to the first.
    // Returns "-1127.00".
    
    String strReturn; // Value to return.
    Integer intLength; // Length of passed expression.    
        
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
    
      // Get length of passed expression.
      intLength = strExpression.length();
      intLength--;
        
      // If last character of expression matches specified character, then...
      if (strExpression.substring(intLength).equals(Character.toString(chrCharacter)))
        
        {
        // Last character of expression matches specified character.
              
        // Move last character to first.
        strReturn = chrCharacter + strExpression.substring(0, intLength);
        }
        
      else
            
        {
        // Last character of expression does not match specified character.
              
        // Return original passed expression.
        strReturn = strExpression;  
        }
            
      // Return (possibly) adjusted expression.
      return strReturn;
      }
      
    }
    
    /**
     * The procedure returns the second expression when the first is empty or null.
     * Otherwise, the procedure returns the original (first) expression.
     *
     * Example for use:
     * result = String_Routines.nullIf("", "Apple");
     * Returns "Apple" since "" is empty.
     * Returns "Apple".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("xyz") strExpression: Text to check whether null or empty ("").
     * 
     * {param} String("xyz") strTo: Text to return when first expression is null or empty ("").
     * 
     * {example} nullIf("", "Apple") # "Apple"
     * 
     */
    public static String nullIf (String strExpression, String strTo)
    
    {
    // The procedure returns the second expression when the first is empty or null.
    // Otherwise, the procedure returns the original (first) expression.
    //
    // Example for use:
    // result = String_Routines.nullIf("", "Apple");
    // Returns "Apple" since "" is empty.
    // Returns "Apple".
	
    // If passed in value is empty or null, then...
    if (emptyInd(strExpression))
      
      {
      // Passed in value is empty or null.  Return second expression.
      return strTo;
      }
    	
    else
    	
      {
      // Passed in value is not empty or null.
      
      // Return first expression.
      return strExpression;
      } // End ... Passed in value is not empty or null.
    
    } // End ... Procedure -- nullIf
    
    /**
     * The procedure returns the second expression when the first is null.
     * Otherwise, the procedure returns the original (first) expression.
     *
     * Example for use:
     * result = String_Routines.nvl(null, "Apple");
     * Returns "Apple" since null is empty.
     * Returns "Apple".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("xyz") strExpression: Text to check whether null.
     * 
     * {param} String("xyz") strTo: Text to return when first expression is null.
     * 
     * {example} nvl(null, "Apple") # "Apple"
     * 
     */
    public static String nvl (String strExpression, String strTo)
    
    {
    // The procedure returns the second expression when the first is null.
    // Otherwise, the procedure returns the original (first) expression.
    //
    // Example for use:
    // result = String_Routines.nvl(null, "Apple");
    // Returns "Apple" since null is null.
    // Returns "Apple".
	
    // If passed in value is null, then...
    if (Relational.ISNULL(strExpression))
      
      {
      // Passed in value is null.  Return second expression.
      return strTo;
      }
    	
    else
    	
      {
      // Passed in value is not null.
      
      // Return first expression.
      return strExpression;
      } // End ... Passed in value is not null.
    
    } // End ... Procedure -- nvl
    
    /**
     * The procedure extracts the date text from the passed filename.
     * Typical date text format:  yyyy-MM-ddTHH:mm:ss.
     *
     * Example for use:
     * result = String_Routines.parseFileDateText("OneMillionCookies_2016-06-30T08-11-16 JUN.txt");
     * Returns the date text.
     * Returns "2016-06-30T08-11-16".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("OneMillionCookies_2016-06-30T08-11-16 JUN.txt") strExpression: Filename without directory.
     * 
     * {example} parseFileDateText("OneMillionCookies_2016-06-30T08-11-16 JUN.txt") # "2016-06-30T08-11-16"
     * 
     */
    public static String parseFileDateText (String strExpression)
    
    {
    // The procedure extracts the date text from the passed filename.
    // Typical date text format:  yyyy-MM-ddTHH:mm:ss.
    //
    // Example for use:
    // result = String_Routines.parseFileDateText("OneMillionCookies_2016-06-30T08-11-16 JUN.txt");
    // Returns the date text.
    // Returns "2016-06-30T08-11-16".
    
    int intPos; // Position of first occurring in passed text -- either last space or character.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Get position of last space in passed expression.
      intPos = strExpression.lastIndexOf(" ");
      
      // If NO space found in expression, then...
      if (intPos == -1)
          
        {
        // NO space found in expression.
            
        // Get length of expression.
        intPos = strExpression.length();
        }
          
      // Return date text contained within filename.
      // Assumes date text starts after last "_" and ends before last " ".
      // Typical date text format:  yyyy-MM-ddTMM-dd-yy.
      return strExpression.substring(strExpression.lastIndexOf("_") + 1, 
        intPos);
      }
    
    }
    
    /**
     * The procedure extracts the date text from the passed filename.
     * The procedure returns a date.
     * The procedure returns null when empty text passed or an invalid date present.
     * Typical date text format:  yyyy-MM-ddTHH:mm:ss.
     *
     * Example for use:
     * result = String_Routines.parseFileDateText_Date("OneMillionCookies_2016-06-30T08-11-16 JUN.txt");
     * Returns the date.
     * Returns #06/30/2016 08:11:16#.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("OneMillionCookies_2016-06-30T08-11-16 JUN.txt") strExpression: Filename without directory.
     * 
     * {example} parseFileDateText_Date("OneMillionCookies_2016-06-30T08-11-16 JUN.txt") # "06/30/2016 08:11:16"
     * 
     */
    public static Date parseFileDateText_Date (String strExpression)
    
    {
    // The procedure extracts the date text from the passed filename.
    // The procedure returns a date.
    // The procedure returns null when empty text passed or an invalid date present.
    // Typical date text format:  yyyy-MM-ddTHH:mm:ss.
    //
    // Example for use:
    // result = String_Routines.parseFileDateText_Date("OneMillionCookies_2016-06-30T08-11-16 JUN.txt");
    // Returns the date.
    // Returns #06/30/2016 08:11:16#.
    
    int intPos; // Position of first occurring in passed text -- either last space or character.
    String strDateCheck; // Whether filename contains a valid date.  Y or N.
    String strDateText; // Date extracted from filename.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Get position of last space in passed expression.
      intPos = strExpression.lastIndexOf(" ");
      
      // If NO space found in expression, then...
      if (intPos == -1)
          
        {
        // NO space found in expression.
            
    	// Get position of last period.
        intPos = strExpression.lastIndexOf(".");
    	
        // If NO period found in expression, then...
        if (intPos == -1)
        
          {
          // NO period found in expression.
          
          // Get length of expression.
          intPos = strExpression.length();
          }
        
        }
      
      // Store date extracted from filename.
      strDateText = strExpression.substring(strExpression.lastIndexOf("_") + 1, 
        intPos);
      
      // Determine whether date extracted from filename is valid.
      strDateCheck = Date_Routines.isDate(strDateText, "yyyy-MM-dd'T'HH-mm-ss");
      
      // If date extracted from filename is valid, then...
      if (strDateCheck.equalsIgnoreCase("Y"))
      
        {
    	// Date extracted from filename is valid.
    	return TalendDate.parseDate("yyyy-MM-dd'T'HH-mm-ss", strDateText);
        }
      
      else
    	  
        {
    	// Date extracted from filename is invalid.
    	return null;
        }
      
      }
    
    }
    
    /**
     * The procedure extracts the filename from the passed full path, 
     * which contains the directory and file.
     *
     * Example for use:
     * result = String_Routines.parseFileFromPath("C:\Input Files\xyz.txt");
     * Returns the filename without the path.
     * Returns "xyz.txt".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("C:\Input Files\xyz.txt") strExpression: Full path, including directory and filename.
	 * 
     * {example} parseFileFromPath("C:\Input Files\xyz.txt") # "xyz.txt"
     * 
     */
    public static String parseFileFromPath (String strExpression)
    
    {
    // The procedure extracts the filename from the passed full path, 
    // which contains the directory and file.
    //
    // Example for use:
    // result = String_Routines.parseFileFromPath("C:\Input Files\xyz.txt");
    // Returns the filename without the path.
    // Returns "xyz.txt".
    
    int intLastPos; // Position of last separator in full filename (with path).
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Get last position of separator in current filename.
      intLastPos = strExpression.lastIndexOf('/') == -1 ? 
        strExpression.lastIndexOf('\\') : strExpression.lastIndexOf('/');
      intLastPos++;
      
      // Return filename without directory information.
      return strExpression.substring(intLastPos, strExpression.length());
      }
    
    }
    
    /**
     * The procedure removes the similar text occurring for rejects - to prevent partial
     * duplicates.  The procedure only keeps text occurring before " - Line:".
     *
     * Example for use:
     * result = String_Routines.removeSimilarRejectText("SNAPSHOT_DTM:java.text.ParseException: Unparseable date: Thu Aug 11 11:34:53 EDT 2016 - Line: 1987");
     * Returns the text on the right side of the passed expression, starting with " - Line:".
     * Returns "SNAPSHOT_DTM:java.text.ParseException: Unparseable date: Thu Aug 11 11:34:53 EDT 2016".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("SNAPSHOT_DTM:java.text.ParseException: Unparseable date: "Thu Aug 11 11:34:53 EDT 2016") strExpression: Reject text - error message.
	 * 
     * {example} removeSimilarRejectText("SNAPSHOT_DTM:java.text.ParseException: Unparseable date: Thu Aug 11 11:34:53 EDT 2016 - Line: 1987") # "SNAPSHOT_DTM:java.text.ParseException: Unparseable date: Thu Aug 11 11:34:53 EDT 2016"
     * 
     */
    public static String removeSimilarRejectText(String strExpression)
    
    {
	// The procedure removes the similar text occurring for rejects - to prevent partial
    // duplicates.  The procedure only keeps text occurring before " - Line:".
    //
    // Example for use:
    // result = String_Routines.removeSimilarRejectText("SNAPSHOT_DTM:java.text.ParseException: Unparseable date: \"Thu Aug 11 11:34:53 EDT 2016\" - Line: 1987");
    // Returns the text on the right side of the passed expression, starting with " - Line:".
    // Returns SNAPSHOT_DTM:java.text.ParseException: Unparseable date: "Thu Aug 11 11:34:53 EDT 2016".
    
    Integer intPos; // Position of last instance of " - Line:" in passed expression.
    
    // Get position of last instance of " - Line:" in passed expression.
    intPos = strExpression.lastIndexOf(" - Line:");
    
    // If - Line: found, then.
    if (intPos > -1)
    
      {
      // Text found:  - Line:.
      
      // Return text occurring before " - Line:" in passed expression.
      return strExpression.substring(0, intPos);
      }
    
    else
        
      {
      // Text not found:  - Line:.
          
      // Return passed expression.
      return strExpression;
      }
    
    }
    
    /**
     * The procedure replaces all instances of the specified text in the passed expression.
     *
     * Example for use:
     * result = String_Routines.replaceAll_Ext("Hello World", "World", "Mars");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to modify with replacement(s).
	 * 
	 * {param} String("World") strFrom: Text for which to search.
	 *
	 * {param} String("Mars") strTo: Text to use in replacement.
	 * 
     * {example} replaceAll_Ext("Hello World", "World", "Mars") # "Hello Mars"
     * 
     */
    public static String replaceAll_Ext (String strExpression, String strFrom, String strTo)
    
    {
    // The procedure replaces all instances of the specified text in the passed expression.
    //
    // Example for use:
    // result = String_Routines.replaceAll_Ext("Hello World", "World", "Mars");
    // Returns "Hello Mars".
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Return replaced text.
      return strExpression.replaceAll(strFrom, strTo);
      }
    	
    }
    
	/**
     * The procedure right pads the passed expression with the specified character.
	 *
     * Example for use:
     * result = String_Routines.rpad("200478298", 12, '0');
     * Returns "200478298", right padded with 0, to reach twelve characters in length.
     * Returns "200478298000".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("200478298") strExpression: Text to pad on the right.
	 * 
     * {param} Integer(12) intNumChar: Number of characters to include in returned value.
	 * 
     * {param} char('0') chrPad: Character to pad expression.
     * 
     * {example} rpad("200478298", 12, '0') # "200478298000"
     * 
     */
    public static String rpad (String strExpression, Integer intNumChar, char chrPad)
      
    {
    // The procedure right pads the passed expression with the specified character.
    //
    // Example for use:
    // result = String_Routines.rpad("200478298", 12, '0');
    // Returns "200478298", right padded with 0, to reach twelve characters in length.
    // Returns "200478298000".
    
    String strRepeatText; // Text with repeating characters.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Set repeating text.
      strRepeatText = new String(new char[intNumChar]).replace("\0", 
        String.valueOf(chrPad));
      
      // Return right padded text.
      return strExpression + strRepeatText.substring(strExpression.length());
      }
    	
    }
    
	/**
     * The procedure splits the passed expression using the specified text.
     * The procedure returns the specified word / piece number.
	 *
     * Example for use:
     * result = String_Routines.split_Ext("Hello World", 2, " ");
     * Returns second word in "Hello World".
     * Returns "World".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("") strExpression: Text for which to get a piece, using separator.
	 * 
     * {param} Integer("<null>") intWord: Word / piece number.  Base 1.
	 * 
     * {param} String("<null>") strSeparator: Text to use to split expression.
     * 
     * {example} split_Ext("Hello World", 2, " ") # "World"
     * 
     */
    public static String split_Ext (String strExpression, Integer intWord, 
      String strSeparator)
    
    {
    // The procedure splits the passed expression using the specified text.
    // The procedure returns the specified word / piece number.
    //
    // Example for use:
    // result = String_Routines.split_Ext("Hello World", 2, " ");
    // Returns second word in "Hello World".
    // Returns "World".
    
    String[] strParts; // Array holding pieces of text.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    	
    // Otherwise, if expression contains separator, then...
    else if (strExpression.contains(strSeparator))
    
      {
      // Expression contains separator.
    	
      // Store pieces of text in array.
      strParts = strExpression.split(strSeparator);
      
      // Return desired piece of text.
      return strParts[intWord - 1];
      }
    
    // Otherwise, if requesting first word, then...
    else if (intWord == 1)
    	
      {
      // Expression does not contain separator.
      // Requesting first word.
    	
      // Return original text.
      return strExpression;
      }
    
    // Otherwise, ...
    else
    	
      {
      // Text does not contain separator.
      // Requesting second or later word.
    	
      // Return null.
      return null;
      }
    	
    }
    
	/**
     * The procedure checks the passed expression for whether splitting can occur.
     * The procedure returns Y for null and empty values (including when trimmed).
     * The procedure returns Y or N.
	 *
     * Example for use:
     * result = String_Routines.split_Ind("Hello World", " ");
     * Returns whether "Hello World" can be split using " ".
     * Returns "Y".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check whether splitting can occur.
	 * 
     * {param} String(" ") strSeparator: Text to use to split expression.
     * 
     * {example} split_Ind("Hello World", " ") # "Y"
     * 
     */
    public static String split_Ind (String strExpression, String strSeparator)
      
    {
    // The procedure checks the passed expression for whether splitting can occur.
    // The procedure returns Y for null and empty values (including when trimmed).
    // The procedure returns Y or N.
    //
    // Example for use:
    // result = String_Routines.split_Ind("Hello World", " ");
    // Returns whether "Hello World" can be split using " ".
    // Returns "Y".
    
    Integer intPos; // Position of separator in expression.
    
    // Store position of separator in expression.
    intPos = strExpression.indexOf(strSeparator);
    
    // Return whether expression blank or separator exists at
    // appropriate position within.
    return emptyInd(strExpression) ? "Y" : intPos > 0 && intPos < 
      strExpression.length() - 2 ? "Y" : "N";
    }
    
	/**
     * The procedure splits the passed expression using the specified text.
     * If getting the first piece, returns text up to the separator.
     * If getting the second piece, returns text after the separator.
	 *
     * Example for use:
     * result = String_Routines.split_Once("Hello World Apple", 2, " ");
     * Returns second piece in "Hello World Apple".
     * Returns "World Apple".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World Apple") strExpression: Text for which to get a piece, using separator.
	 * 
     * {param} Integer(2) intWord: Word / piece number.  Base 1.
	 * 
     * {param} String(" ") strSeparator: Text to use to split expression.
     * 
     * {example} split_Once("Hello World Apple", 2, " ") # "World Apple"
     * 
     */
    public static String split_Once (String strExpression, Integer intWord, 
      String strSeparator)
      
    {
    // The procedure splits the passed expression using the specified text.
    // If getting the first piece, returns text up to the separator.
    // If getting the second piece, returns text after the separator.
    //
    // Example for use:
    // result = String_Routines.split_Once("Hello World Apple", 2, " ");
    // Returns second piece in "Hello World Apple".
    // Returns "World Apple".
    
    Integer intPos; // Position of separator in expression.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    	
    else
    	
      {
      // Expression contains text.
    
      // Get position of separator in expression.
      intPos = strExpression.indexOf(strSeparator);
    	
      // If separator found in expression, then...
      if (intPos > -1)
      
        {
    	// Separator found in expression.
    	  
    	// If requesting first piece, then...
        if (intWord == 1)
        	  
          {
          // Requesting first piece.
        	  
          // Return text up to, but not including, the separator.
          return strExpression.substring(0, strExpression.indexOf(strSeparator));
          }
          
        else
        	  
          {
          // Requesting second piece.
        	  
          // Return text following, but not including, the separator.
          return strExpression.substring(strExpression.indexOf(strSeparator) + 
            strSeparator.length(), strExpression.length());
          }
    	  
        } // Separator found in expression.
    	
      else
    	  
        {
    	// Separator not found in expression.
    	  
    	// If requesting first piece, then...
        if (intWord == 1)
          	  
          {
          // Requesting first piece.
          	  
          // Return expression.
          return strExpression;
          }
            
        else
          	  
          {
          // Requesting second piece.
          	  
          // Return null.
          return null;
          }
    	  
        } // Separator not found in expression.
      
      } // Expression contains text.
    
    }
	
	/**
     * The procedure returns whether the passed expressions match.
     * Allows for matches where both equal null.  Case-Sensitive.
     *
     * Returns boolean (true or false).
	 *
     * Example for use:
     * result = String_Routines.string_equals("Hello World", "Hello World");
     * Checks whether "Hello World" equal to "Hello World".
     * Returns true, since "Hello World" = "Hello World".
     * 
     * {talendTypes} boolean | Boolean
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strSearchPhrase: Text for which to search.
     * 
     * {example} substring_equals("Hello World", "Hello World") # true
     * 
     */
    public static boolean string_equals (String strExpression, 
      String strSearchPhrase)
      
    {
    // The procedure returns whether the passed expressions match.
    // Allows for matches where both equal null.  Case-Sensitive.
    //
    // Returns true or false.
    //
    // Example for use:
    //
    // result = String_Routines.string_equals("Hello World", "Hello World");
    // Checks whether "Hello World" equal to "Hello World".
    // Returns true, since "Hello World" = "Hello World".
    
    // Return whether passed expressions match.
    return Relational.ISNULL(strExpression) ? 
      (Relational.ISNULL(strSearchPhrase) ? true : false) : 
      (strExpression.equals(strSearchPhrase) ? true : false);
    }
	
	/**
     * The procedure returns whether the leftmost characters of the passed
     * expression match the search phrase.  Allows for matches where both
     * equal null.  Case-Sensitive.
     *
     * Returns boolean (true or false).
	 *
     * Example for use:
     * result = String_Routines.substring_equals("Hello World", "Hello");
     * Extracts the leftmost characters from "Hello World" and checks
     * whether matches to "Hello".
     * Returns true, since first five characters of "Hello World" = "Hello".
     * 
     * {talendTypes} boolean | Boolean
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check leftmost characters for match.
	 * 
     * {param} String("Hello") strSearchPhrase: Text for which to search (on the left side of the first expression).
     * 
     * {example} substring_equals("Hello World", "Hello") # true
     * 
     */
    public static boolean substring_equals (String strExpression, 
      String strSearchPhrase)
      
    {
    // The procedure returns whether the leftmost characters of the passed
    // expression match the search phrase.  Allows for matches where both
    // equal null.  Case-Sensitive.
    //
    // Returns boolean (true or false).
    //
    // Example for use:
    //
    // result = String_Routines.substring_equals("Hello World", "Hello");
    // Extracts the leftmost characters from "Hello World" and checks
    // whether matches to "Hello".
    // Returns true, since first five characters of "Hello World" = "Hello".
    	
    // Return first x characters from the passed expression (or null replacement).
    return Relational.ISNULL(strExpression) ? 
      (Relational.ISNULL(strSearchPhrase) ? true : false) : 
      (substring_ext(strExpression, strSearchPhrase.length(), 
        "").equals(strSearchPhrase) ? true : false);
    }
	
	/**
     * The procedure extracts the first x characters from the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.substring_ext("Hello World", 7);
     * Extracts the first seven characters from "Hello World".
     * Returns "Hello W", the first seven characters of the expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to limit to x characters.
	 * 
     * {param} Integer(7) intNbrChars: Number of characters to take from left side of expression.  Base 1.
     * 
     * {example} substring_ext("Hello World", 7) # "Hello W"
     * 
     */
    public static String substring_ext (String strExpression, Integer intNbrChars)
      
    {
    // The procedure extracts the first x characters from the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.substring_ext("Hello World", 7);
    // Extracts the first seven characters from "Hello World".
    // Returns "Hello W", the first seven characters of the expression.
    
    // Return first x characters from the passed expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      strExpression.substring(0, Math.min(strExpression.length(), intNbrChars));
    }
    
	/**
     * The procedure extracts the first x characters from the passed expression.
     * The procedure returns the second passed text value for null expressions.
	 *
     * Example for use:
     * result = String_Routines.substring_ext("Hello World", 7, "");
     * Extracts the first seven characters from "Hello World".
     * Returns "Hello W", the first seven characters of the expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to limit to x characters.
	 * 
     * {param} Integer(7) intNbrChars: Number of characters to take from left side of expression.  Base 1.
	 * 
     * {param} String("") strNullReplace: Text to use as replacement for null.
     * 
     * {example} substring_ext("Hello World", 7, "") # "Hello W"
     * 
     */
    public static String substring_ext (String strExpression, Integer intNbrChars,
      String strNullReplace)
      
    {
    // The procedure extracts the first x characters from the passed expression.
    // The procedure returns the second passed text value for null expressions.
    //
    // Examples for use:
    //
    // result = String_Routines.substring_ext("Hello World", 7, "");
    // Extracts the first seven characters from "Hello World".
    // Returns "Hello W", the first seven characters of the expression.
    //
    // result = String_Routines.substring_ext(null, 7, "");
    // Returns "", since the value is null.
    	
    // Return first x characters from the passed expression (or null replacement).
    return Relational.ISNULL(strExpression) ? strNullReplace : 
      strExpression.substring(0, Math.min(strExpression.length(), intNbrChars));
    }
	
	/**
     * The procedure extracts the first x characters from the passed expression.
     * The procedure first removes any surrounding single quotes.
     * Upon completion, the single quotes get added back.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.substring_ext_quote("'Hello World'", 7);
     * Extracts the first seven characters from the text in "'Hello World'".
     * Returns "'Hello W'", the first seven characters of the text in the expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("'Hello World'") strExpression: Text from which to extract the first x characters (on the left), specified in the second parameter.
	 * 
     * {param} Integer(7) intNbrChars: Number of characters to take from left side of expression.  Base 1.
     * 
     * {example} substring_ext_quote("'Hello World'", 7) # "'Hello W'"
     * 
     */
    public static String substring_ext_quote (String strExpression, Integer intNbrChars)
      
    {
    // The procedure extracts the first x characters from the passed expression.
    // The procedure first removes any surrounding single quotes.
    // Upon completion, the single quotes get added back.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.substring_ext_quote("'Hello World'", 7);
    // Extracts the first seven characters from the text in "'Hello World'".
    // Returns "'Hello W'", the first seven characters of the text in the expression.
    
    // Return first x characters from the passed expression, surrounded with single quotes,
    // (or null).
    return Relational.ISNULL(strExpression) ? null : 
      "'" + strExpression.substring(0, 
      Math.min(trimBoth(strExpression, '\'').length(), intNbrChars)) + "'";
    }
	
	/**
     * The procedure returns the shorter of the first n characters or full length
     * of the expression.
	 *
     * Examples for use:
     * result = String_Routines.substring_Max("Hello World", 2);
     * Returns the first two characters of "Hello World".
     * Returns "He".
     *
     * result = String_Routines.substring_Max("Hello World", 50);
     * Returns the entire text of "Hello World", since fifty exceeds its length.
     * Returns "Hello World".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text from which to extract characters from the left side.
	 * 
     * {param} Integer(2) intLength: Number of characters to extract from left side of expression.  Base 1.
     * 
     * {example} substring_Max("Hello World", 2) # "He"
     * 
     */
    public static String substring_Max (String strExpression, Integer intLength)
      
    {
    // The procedure returns the shorter of the first n characters or full length
    // of the expression.
    //
    // Examples for use:
    //
    // result = String_Routines.substring_Max("Hello World", 2);
    // Returns the first two characters of "Hello World".
    // Returns "He".
    //
    // result = String_Routines.substring_Max("Hello World", 50);
    // Returns the entire text of "Hello World", since fifty exceeds its length.
    // Returns "Hello World".
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    
      {
      // Expression null or empty.
      
      // Return null.
      return null;
      }
    
    else
    	
      {
      // Expression contains text.
      
      // Return shorter of first n characters or entire length of expression.
      return strExpression.substring(0, Math.min(intLength, strExpression.length()));
      }
    
    }
	
	/**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the original expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateText("Hello World", "Hello World", "Hello Mars");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {example} translateText("Hello World", "Hello World", "Hello Mars") # "Hello Mars"
     * 
     */
    public static String translateText (String strExpression, String strFrom, String strTo)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText("Hello World", "Hello World", "Hello Mars");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equals(strFrom) ? strTo : strFrom);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the else expression.
     * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateText("Hello World", "Hello World", "Hello Mars", "Else");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {example} translateText("Hello World", "Hello World", "Hello Mars", "Else") # "Hello Mars"
     * 
     */
    public static String translateText (String strExpression, String strFrom, String strTo, String strElse)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText("Hello World", "Hello World", "Hello Mars", "Else");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equals(strFrom) ? strTo : strElse);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the original expression.
     * 
     * Equality checks are NOT case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextIgnoreCase("Hello World", "Hello World", "Hello Mars");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {example} translateTextIgnoreCase("Hello World", "Hello World", "Hello Mars") # "Hello Mars"
     * 
     */
    public static String translateTextIgnoreCase (String strExpression, String strFrom, String strTo)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateTextIgnoreCase("Hello World", "Hello World", "Hello Mars");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equalsIgnoreCase(strFrom) ? strTo : strFrom);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the else expression.
     * 
     * Equality checks are NOT case sensitive.
     *
     * Example for use:
     * result = String_Routines.translateTextIgnoreCase("Hello World", "Hello World", "Hello Mars", "Else");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {example} translateTextIgnoreCase("Hello World", "Hello World", "Hello Mars", "Else") # "Hello Mars"
     * 
     */
    public static String translateTextIgnoreCase (String strExpression, String strFrom, String strTo, String strElse)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateTextIgnoreCase("Hello World", "Hello World", "Hello Mars", "Else");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equalsIgnoreCase(strFrom) ? strTo : strElse);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the original expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl("Hello World", "Hello World", "Hello Mars", "Unknown");
     * Returns "Hello Mars".
     * 
     * Example for use:
     * result = String_Routines.translateTextNvl(null, "Hello World", "Hello Mars", "Unknown");
     * Returns "Unknown".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     * 
     * {example} translateTextNvl("Hello World", "Hello World", "Hello Mars", "xyz") # "Hello Mars"
     * 
     */
    public static String translateTextNvl (String strExpression, String strFrom, String strTo, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateTextNvl("Hello World", "Hello World", "Hello Mars", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equals(strFrom) ? strTo : strFrom);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the else expression.
     * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl("Hello World", "Hello World", "Hello Mars", "Else", "Unknown");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     * 
     * {example} translateTextNvl("Hello World", "Hello World", "Hello Mars", "Else", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl (String strExpression, String strFrom, String strTo, String strElse, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateTextNvl("Hello World", "Hello World", "Hello Mars", "Else", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equals(strFrom) ? strTo : strElse);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the original expression.
	 *
	 * Equality checks are NOT case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl_IgnoreCase("Hello World", "Hello World", "Hello Mars", "Unknown");
     * Returns "Hello Mars".
     * 
     * Example for use:
     * result = String_Routines.translateTextNvl_IgnoreCase(null, "Hello World", "Hello Mars", "Unknown");
     * Returns "Unknown".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     * 
     * {example} translateTextNvl_IgnoreCase("Hello World", "Hello World", "Hello Mars", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl_IgnoreCase (String strExpression, String strFrom, String strTo, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateTextNvl_IgnoreCase("Hello World", "Hello World", "Hello Mars", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equalsIgnoreCase(strFrom) ? strTo : strFrom);
    }
    
    /**
     * The procedure checks whether the passed expression equals the from parameter.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the to parameter when the expression matches the from.
     * Otherwise, the procedure returns the else expression.
     *
     * Equality checks are NOT case sensitive.
     *
     * Example for use:
     * result = String_Routines.translateTextNvl_IgnoreCase("Hello World", "Hello World", "Hello Mars", "Else", "Unknown");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to check for match.
	 * 
     * {param} String("Hello World") strFrom: Text for which to search.
	 * 
     * {param} String("Hello Mars") strTo: Text to use in replacement when parameters match.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     * 
     * {example} translateTextNvl_IgnoreCase("Hello World", "Hello World", "Hello Mars", "Else", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl_IgnoreCase (String strExpression, String strFrom, String strTo, String strElse, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals the from parameter.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the to parameter when the expression matches the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateTextNvl_IgnoreCase("Hello World", "Hello World", "Hello Mars", "Else", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equalsIgnoreCase(strFrom) ? strTo : strElse);
    }
    
	/**
     * The procedure checks whether the passed expression equals true or false.
     * The procedure returns null for expressions that are already null.
     * The procedure returns Y for true and N for false, ignoring case.
     * Otherwise, the procedure returns the original expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Examples for use:
     * result = String_Routines.translateText_Flag("Hello World");
     * Returns "Hello World".
     *
     * result = String_Routines.translateText_Flag("true");
     * Returns "Y".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("true") strExpression: Text to check whether equal to "true" or "false".
     * 
     * {example} translateText_Flag("true") # "Y"
     * 
     */
    public static String translateText_Flag (String strExpression)
      
    {
    // The procedure checks whether the passed expression equals true or false.
    // The procedure returns null for expressions that are already null.
    // The procedure returns Y for true and N for false, ignoring case.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Examples for use:
    // result = String_Routines.translateText_Flag("Hello World");
    // Returns "Hello World".
    //
    // result = String_Routines.translateText_Flag("true");
    // Returns "Y".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equalsIgnoreCase("true") ? "Y" : 
      (strExpression.equalsIgnoreCase("false") ? "N" : strExpression));
    }
	
	/**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the original expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateText_TwoItems("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {example} translateText_TwoItems("Hello World", "John", "Kennedy", "Hello World", "Hello Mars") # "Hello Mars"
     * 
     */
    public static String translateText_TwoItems (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2)
      
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equals(strFrom1) ? strTo1 : 
      (strExpression.equals(strFrom2) ? strTo2 : strExpression));
    }
	
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the else expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateText_TwoItems("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars", "Else");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {example} translateText_TwoItems("Hello World", "John", "Kennedy", "Hello World", "Hello Mars", "Jupiter") # "Hello Mars"
     * 
     */
    public static String translateText_TwoItems (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2, String strElse)
      
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars", "Else");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equals(strFrom1) ? strTo1 : 
      (strExpression.equals(strFrom2) ? strTo2 : strElse));
    }
    
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the original expression.
	 *
	 * Equality checks are NOT case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {example} translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", "Hello World", "Hello Mars") # "Hello Mars"
     * 
     */
    public static String translateText_TwoItems_IgnoreCase (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2)
      
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equalsIgnoreCase(strFrom1) ? strTo1 : 
      (strExpression.equalsIgnoreCase(strFrom2) ? strTo2 : strExpression));
    }
    
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns null for expressions that are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the else expression.
	 *
	 * Equality checks are NOT case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars", "Else");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {example} translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", "Hello World", "Hello Mars", "Else") # "Hello Mars"
     * 
     */
    public static String translateText_TwoItems_IgnoreCase (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2, String strElse)
      
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns null for expressions that are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars", "Else");
    // Returns "Hello Mars".
    
    // Return translated expression (or null).
    return Relational.ISNULL(strExpression) ? null : 
      (strExpression.equalsIgnoreCase(strFrom1) ? strTo1 : 
      (strExpression.equalsIgnoreCase(strFrom2) ? strTo2 : strElse));
    }
    
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the original expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl_TwoItems("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars", "Unknown");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     *
     * {example} translateText_TwoItemsNvl("Hello World", "John", "Kennedy", "Hello World", "Hello Mars", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl_TwoItems (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equals(strFrom1) ? strTo1 : 
      (strExpression.equals(strFrom2) ? strTo2 : strExpression));
    }
    
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the else expression.
	 * 
     * Equality checks ARE case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl_TwoItems("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars", "Else", "Unknown");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     *
     * {example} translateText_TwoItemsNvl("Hello World", "John", "Kennedy", "Hello World", "Hello Mars", "Else", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl_TwoItems (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2, String strElse, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks ARE case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars", "Else", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equals(strFrom1) ? strTo1 : 
      (strExpression.equals(strFrom2) ? strTo2 : strElse));
    }
    
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the original expression.
	 *
	 * Equality checks are NOT case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars", "Unknown");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     *
     * {example} translateText_TwoItemsNvl_IgnoreCase("Hello World", "John", "Kennedy", "Hello World", "Hello Mars", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl_TwoItems_IgnoreCase (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the original expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equalsIgnoreCase(strFrom1) ? strTo1 : 
      (strExpression.equalsIgnoreCase(strFrom2) ? strTo2 : strExpression));
    }
    
    /**
     * The procedure checks whether the passed expression equals any of the from parameters.
     * The procedure returns the nvl expression (last parameter) for expressions that
     * are already null.
     * The procedure returns the first to parameter matching the from.
     * Otherwise, the procedure returns the else expression.
	 *
	 * Equality checks are NOT case sensitive.
	 *
     * Example for use:
     * result = String_Routines.translateTextNvl_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
     *   "Hello World", "Hello Mars", "Else", "Unknown");
     * Returns "Hello Mars".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to evaluate and potentially change.
	 * 
     * {param} String("John") strFrom1: First value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Kennedy") strTo1: First value to which to change.  Replaces entire expression.
	 * 
     * {param} String("Hello World") strFrom2: Second value from which to change -- checked for in match.  Must match entire variable.
	 * 
     * {param} String("Hello Mars") strTo2: Second value to which to change.  Replaces entire expression.
     * 
     * {param} String("Else") strElse: Text to use in replacement when parameters do not match.
     * 
     * {param} String("Unknown") strNvl: Text to use in replacement when first (from) parameter is null.
     *
     * {example} translateText_TwoItemsNvl_IgnoreCase("Hello World", "John", "Kennedy", "Hello World", "Hello Mars", "Else", "Unknown") # "Hello Mars"
     * 
     */
    public static String translateTextNvl_TwoItems_IgnoreCase (String strExpression, String strFrom1, 
      String strTo1, String strFrom2, String strTo2, String strElse, String strNvl)
    
    {
    // The procedure checks whether the passed expression equals any of the from parameters.
    // The procedure returns the nvl expression (last parameter) for expressions that
    // are already null.
    // The procedure returns the first to parameter matching the from.
    // Otherwise, the procedure returns the else expression.
    //
    // Equality checks are NOT case sensitive.
    //
    // Example for use:
    // result = String_Routines.translateText_TwoItems_IgnoreCase("Hello World", "John", "Kennedy", 
    //   "Hello World", "Hello Mars", "Else", "Unknown");
    // Returns "Hello Mars".
    
    // Return translated expression.
    return Relational.ISNULL(strExpression) ? strNvl : 
      (strExpression.equalsIgnoreCase(strFrom1) ? strTo1 : 
      (strExpression.equalsIgnoreCase(strFrom2) ? strTo2 : strElse));
    }
    
	/**
     * The procedure trims the specified text from both sides of the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimBoth("Hello World", "He", "rld");
     * Trims the "He" from the left and "rld" from the right of "Hello World".
     * Returns "llo Wo", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to trim.
     * 
	 * {param} String("He") strRemoveLeft: Text to remove from left of expression.
	 * 
	 * {param} String("rld") strRemoveRight: Text to remove from right of expression.
     * 
     * {example} trimBoth("Hello World", "He", "rld") # "llo Wo"
     * 
     */
    public static String trimBoth (String strExpression, String strRemoveLeft, 
      String strRemoveRight)
    
    {
    // The procedure trims the specified text from both sides of the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimBoth("Hello World", "He", "rld");
    // Trims the "He" from the left and "rld" from the right of "Hello World".
    // Returns "llo Wo", the trimmed expression.
    
    // Return the expression with the specified text trimmed from both sides.
    return trimEnd(trimFront(strExpression, strRemoveLeft), strRemoveRight);
    }
	
	/**
     * The procedure trims the specified character from both sides of the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimBoth("Hello olleH", 'H');
     * Trims the 'H' from both sides "Hello olleH".
     * Returns "ello olle", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello olleH") strExpression: Text to trim.
	 * 
     * {param} char('H') chrCharacter: Character to remove.
     * 
     * {example} trimBoth("Hello olleH", 'H') # "ello olle"
     * 
     */
    public static String trimBoth (String strExpression, char chrCharacter)
    
    {
    // The procedure trims the specified character from both sides of the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimBoth("Hello olleH", 'H');
    // Trims the 'H' from both sides "Hello olleH".
    // Returns "ello olle", the trimmed expression.
    
    // Return the expression with the specified character trimmed from both sides.
    return trimEnd(trimFront(strExpression, chrCharacter), chrCharacter);
    }
	
	/**
     * The procedure trims the specified character from both sides of the passed expression.
     * The procedure then performs the specified (character) replacement.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimBoth_Replace("Hello olleH", 'H', "o", "x");
     * Trims the 'H' from both sides "Hello olleH" and replaces "o" with "x".
     * Returns "ellx xlle", the trimmed and substituted expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello olleH") strExpression: Text to trim.
	 * 
     * {param} char('H') chrCharacter: Character to remove.
	 * 
     * {param} String("o") strFrom: Text to replace (from).
	 * 
     * {param} String("x") strTo: Text to replace (to).
     * 
     * {example} trimBoth_Replace("Hello olleH", 'H', "o", "x") # "ellx xlle"
     * 
     */
    public static String trimBoth_Replace (String strExpression, char chrCharacter,
      String strFrom, String strTo)
    
    {
    // The procedure trims the specified character from both sides of the passed expression.
    // The procedure then performs the specified (character) replacement.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimBoth_Replace("Hello olleH", 'H', "o", "x");
    // Trims the 'H' from both sides "Hello olleH" and replaces "o" with "x".
    // Returns "ellx xlle", the trimmed and substituted expression.
    
    // If expression null or empty, then...
    if (emptyInd(strExpression))
    	
      {
      // Expression null or empty.
    	
      // Return null.
      return null;
      }
    	
    else
    	
      {
      // Expression contains text.
    	
      // Return the expression with the specified character trimmed from both sides and
      // the specified replacement.
      return trimEnd(trimFront(strExpression, chrCharacter), 
        chrCharacter).replaceAll(strFrom, strTo);
      }
    
    }
	
	/**
     * The procedure trims the specified character from the right of the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimEnd("Hello World", 'd');
     * Trims the 'd' from "Hello World".
     * Returns "Hello Worl", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to trim (on the left).
     * 
	 * {param} char("Hel") chrCharacter: Character to remove.
     * 
     * {example} trimEnd("Hello World", 'd') # "Hello Worl"
     * 
     */
    public static String trimEnd (String strExpression, char chrCharacter)
    
    {
    // The procedure trims the specified character from the right of the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimEnd("Hello World", 'd');
    // Trims the 'd' from "Hello World".
    // Returns "Hello Worl", the trimmed expression.
    
    int intIndex = 0; // Used to loop through first n characters of expression.
    
    // If expression is null, then...
    if (Relational.ISNULL(strExpression))
    	
      {
      // Expression is null.
    	
      // Return null.
      return null;
      }
    
    // Otherwise (expression is not null)...
    else
    	
      {
      // Expression is not null.
    
      // Get index of last character, base 0.
      intIndex = strExpression.length() - 1;
      
      // Loop through characters at end of expression that match the one specified. 
      while (strExpression.charAt(intIndex) == chrCharacter) 
        {
    	  
    	// If beginning of expression reached, then...
        if (--intIndex < 0) 
          {
          // Beginning of expression reach.
        	
          // Return empty string.
          return "";
          }
        
        }
      
      // Return expression with specified character trimmed from the right.
      return strExpression.substring(0, intIndex + 1).trim();
      }
    
    }
    
	/**
     * The procedure trims the specified text from the right of the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimEnd("Hello World", "rld");
     * Trims the "rld" from "Hello World".
     * Returns "Hello Wo", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to trim (on the right).
     * 
	 * {param} String("rld") strToRemove: Text to remove.
     * 
     * {example} trimEnd("Hello World", "rld") # "Hello Wo"
     * 
     */
    public static String trimEnd (String strExpression, String strToRemove)
      
    {
    // The procedure trims the specified text from the right of the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimEnd("Hello World", "rld");
    // Trims the "rld" from "Hello World".
    // Returns "Hello Wo", the trimmed expression.
    
    int intExpressionLength; // Length of expression.
    int intLength; // Length of text to remove.
    
    // If expression is null, then...
    if (Relational.ISNULL(strExpression))
    	
      {
      // Expression is null.
    	
      // Return null.
      return null;
      }
    
    // Otherwise (expression is not null)...
    else
    	
      {
      // Expression is not null.
    
      // Get length of expression.
      intExpressionLength = strExpression.length();
        
      // Get length of text to remove.
      intLength = strToRemove.length();
    	
      // If expression longer than or equal in length to text to remove, then...
      if (intExpressionLength >= intLength)
    	
        {
    	// Expression longer than or equal in length to text to remove.
    	  
    	// Return expression with desired text removed from the right.
    	return strExpression.substring(intExpressionLength - intLength, 
    	  intExpressionLength).equals(strToRemove) ? 
    	  strExpression.substring(0, intExpressionLength - intLength) :
    	  strExpression;
        }
      
      else
    	  
        {
        // Expression is shorter than text to remove.
    	return strExpression;
        }
      
      } // Expression is not null.
    
    }
	
	/**
     * The procedure removes formula text (as in Excel) from the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimExcelQuotes("=\"040116E1\"");
     * Trims the =" from the left and " from the right of ="040116E1".
     * Returns "040116E1", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("=\"040116E1\"") strExpression: Expression from which to remove =" and ".
     * 
     * {example} trimExcelQuotes("=\"040116E1\"") # "040116E1"
     * 
     */
	public static String trimExcelQuotes (String strExpression)
    
    {
    // The procedure removes formula text (as in Excel) from the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimExcelQuotes("=\"040116E1\"");
    // Trims the =" from the left and " from the right of ="040116E1".
    // Returns "040116E1", the trimmed expression.
    
    // Return the expression with the Excel formula text removed.
    return trimEnd(trimFront(strExpression, "=\""), "\"");
    }
	
	/**
     * The procedure trims the specified character from the left of the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimFront("Hello World", 'H');
     * Trims the 'H' from "Hello World".
     * Returns "ello World", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to trim (on the left).
     * 
	 * {param} char('H') chrCharacter: Character to remove.
     * 
     * {example} trimFront("Hello World", 'H') # "ello World"
     * 
     */
    public static String trimFront (String strExpression, char chrCharacter)
      
    {
    // The procedure trims the specified character from the left of the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimFront("Hello World", 'H');
    // Trims the 'H' from "Hello World".
    // Returns "ello World", the trimmed expression.
    	
    int intIndex = 0; // Used to loop through first n characters of expression.
    
    // If expression is null, then...
    if (Relational.ISNULL(strExpression))
    	
      {
      // Expression is null.
    	
      // Return null.
      return null;
      }
    
    // Otherwise (expression is not null)...
    else
    	
      {
      // Expression is not null.
    
      // Count number of characters to trim from left of expression.
      while (strExpression.charAt(intIndex) == chrCharacter) 
        {
    	intIndex++;
        }
      
      // Return expression with specified character trimmed from the left.
      return strExpression.substring(intIndex).trim();
      }
    
    }
    
	/**
     * The procedure trims the specified text from the left of the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimFront("Hello World", "Hel");
     * Trims the "Hel" from "Hello World".
     * Returns "lo World", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("Hello World") strExpression: Text to trim (on the left).
     * 
	 * {param} String("Hel") strToRemove: Text to remove.
     * 
     * {example} trimFront("Hello World", "Hel") # "lo World"
     * 
     */
    public static String trimFront (String strExpression, String strToRemove)
      
    {
    // The procedure trims the specified text from the left of the passed expression.
    // The procedure returns null for expressions that are already null.
    //
    // Example for use:
    // result = String_Routines.trimFront("Hello World", "Hel");
    // Trims the "Hel" from "Hello World".
    // Returns "lo World", the trimmed expression.
    
    int intExpressionLength; // Length of expression.
    int intLength; // Length of text to remove.
    
    // If expression is null, then...
    if (Relational.ISNULL(strExpression))
    	
      {
      // Expression is null.
    	
      // Return null.
      return null;
      }
    
    // Otherwise (expression is not null)...
    else
    	
      {
      // Expression is not null.
    
      // Get length of expression.
      intExpressionLength = strExpression.length();
        
      // Get length of text to remove.
      intLength = strToRemove.length();
    	
      // If expression longer than or equal in length to text to remove, then...
      if (intExpressionLength >= intLength)
    	
        {
    	// Expression longer than or equal in length to text to remove.
    	  
    	// Return expression with desired text removed from beginning.
        return strExpression.substring(0, intLength).equals(strToRemove) ? 
          strExpression.substring(intLength, intExpressionLength) : strExpression;    	  
        }
      
      else
    	  
        {
        // Expression is shorter than text to remove.
    	return strExpression;
        }
      
      } // Expression is not null.
    
    }
    
    /**
     * The procedure removes double quotes (") that surround the passed expression.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimQuotes("\"040116E1\"");
     * Trims the " from the left and right of "040116E1".
     * Returns "040116E1", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("\"040116E1\"") strExpression: Expression from which to remove " from both sides.
     * 
     * {example} trimQuotes("\"040116E1\"") # "040116E1"
     * 
     */
	public static String trimQuotes (String strExpression)
    
    {
    // The procedure removes double quotes (") that surround the passed expression.
	// The procedure returns null for expressions that are already null.
	//
	// Example for use:
	// result = String_Routines.trimQuotes("\"040116E1\"");
	// Trims the " from the left and right of "040116E1".
	// Returns "040116E1", the trimmed expression.
    
    // Return the expression with the quotes removed from the beginning and end.
    return trimEnd(trimFront(strExpression, "\""), "\"");
    }
    
	/**
     * The procedure removes double quotes (") that surround the passed expression and any commas.
     * The procedure returns null for expressions that are already null.
	 *
     * Example for use:
     * result = String_Routines.trimQuotes("\"040116E1\"");
     * Trims the " from the left and right of "040116E1".
     * Returns "040116E1", the trimmed expression.
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} String("\"040116E1\"") strExpression: Expression from which to remove " from both sides.
     * 
     * {example} trimQuotes("\"040116E1\"") # "040116E1"
     * 
     */
	public static String trimQuotes_RemoveCommas (String strExpression)
    
    {
    // The procedure removes double quotes (") that surround the passed expression and any commas.
	// The procedure returns null for expressions that are already null.
	//
	// Example for use:
	// result = String_Routines.trimQuotes("\"040116E1\"");
	// Trims the " from the left and right of "040116E1".
	// Returns "040116E1", the trimmed expression.
    
    // Return the expression with the quotes removed from the beginning and end.
    return trimEnd(trimFront(replaceAll_Ext(strExpression, ",", ""), "\""), "\"");
    }
	
    /**
     * The procedure converts a CLOB to a String.
     * A lot of the Oracle metadata fields store information in CLOB form.
	 *
     * Example for use:
     * result = String_Routines.tryClob2String(objClob1);
     * Converts the passed CLOB variable to a String.
     * Assuming the CLOB contains the text, "Hello World", ...
     * Returns "Hello World".
     * 
     * {talendTypes} String
     * 
     * {Category} String_Routines
     * 
     * {param} Object("[CLOB]") objExpression: CLOB object to convert to String.
     * 
     * {example} tryClob2String(objClob1) # "Hello World"
     * 
     */
    public static final String tryClob2String(final Object objExpression)

    {
    // The procedure converts a CLOB to a String.
    // A lot of the Oracle metadata fields store information in CLOB form.
    // 
   	// See http://stackoverflow.com/questions/2169732/most-efficient-solution-for-reading-clob-to-string-and-string-to-clob-in-java/13794689 for more information.
    //
    // Example for use:
    // result = String_Routines.tryClob2String(objClob1);
    // Converts the passed CLOB variable to a String.
    // Assuming the CLOB contains the text, "Hello World", ...
    // Returns "Hello World".
    	
    final long clobLength; // Length of the CLOB.
    final java.sql.Clob clobValue; // Passed in object converted to a java.sql.Clob datatype.
    String result; // Return value.
    
    // Set defaults.
    result = null;
    
    // Store the passed in object converted to a java.sql.Clob datatype.
    clobValue = (java.sql.Clob) objExpression;
    
    // Try to check the length of the CLOB.
    try
      {
      // Get the length of the CLOB.
      clobLength = clobValue.length();

      // If CLOB length less or greater than minimum / maximum for integers, then...
      if (clobLength < Integer.MIN_VALUE || clobLength > Integer.MAX_VALUE)
        {
    	// CLOB length less or greater than minimum / maximum for integers.
    	  
    	// Store results -- warning about CLOB size.
        result = "CLOB size too big for String!";
        }
      
      // Otherwise -- CLOB size fits within integer limits...
      else
        {
    	// CLOB size fits within integer limits.
    	  
    	// Store results -- convert CLOB to a String.
        result = clobValue.getSubString(1, (int) clobValue.length());
        }
      
      }
    
    // If an error occurred during CLOB operations, then...
    catch (SQLException e)
      {
      // An error occurred during CLOB operations.
    	
      // Store results -- warning about CLOB error.
      result = "tryClob2String ERROR:  " + e;
      }

    // Return results.
    return result;
    }
    
}