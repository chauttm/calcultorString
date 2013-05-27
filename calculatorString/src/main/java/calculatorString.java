import com.sun.org.apache.xalan.internal.res.XSLTErrorResources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 5/21/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class calculatorString {

    //pass string to method add(String text) ,return sum of numbers ,return 0 if empty string
    public static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        } else {
            text = getText(text);
            String regex = "[\\^$.|?*//;+\\n,%*(). ]";
            String str[] = text.split(regex);
            return returnSum(str);
        }
    }

    //replace [ or ]  to space
    public static String getText(String text) {
        if (text.contains("[") || text.contains("]")) {
            text = text.replaceAll("\\[", " ");
            text = text.replaceAll("\\]", " ");
        }
        return text;
    }

    //pass String arr[] ,return sum of number
    private static int returnSum(String str[]) {
        int sum = 0;
        int count = 0;
        for (String num : str) {
            if (!num.isEmpty() && toInt(num) >= 0 && toInt(num) <= 1000) {
                sum += toInt(num);
            } else if (!num.isEmpty() && toInt(num) < 0) {
                throw new NumberFormatException("Negative is not allowed");
            }
        }
        return sum;
    }

    //convert string to int
    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

}
