package io.nqa.commons;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Utils {
    private static volatile Utils utils;

    private Utils() {}

    @SuppressWarnings("InstantiationOfUtilityClass")
    private static void init() {
        if (utils == null)
            utils = new Utils();
    }

    /**
     * Check if any of multiple objects are null.
     * If you have only one object use 'obj == null' instead.
     *
     * @param objects List of objects
     * @return True if any object is null
     */
    private static boolean isNull(Object ... objects) {
        init();
        for (Object obj : objects) {
            if (obj == null)
                return true;
        }
        return false;
    }

    /**
     * Check if any of multiple strings is null or blank.
     *
     * @param args List of strings
     * @return True if any string is null or blank
     */
    public static boolean isBlank(String ... args) {
        init();
        for (String arg : args) {
            if (arg == null || arg.trim().isBlank())
                return true;
        }
        return false;
    }

    /**
     * Check if two strings match.
     *
     * @param str1 String 1
     * @param str2 String 2
     * @return True if strings match
     */
    public static boolean equals(String str1, String str2) {
        init();
        return (!isNull(str1, str2) && str1.trim().equals(str2.trim()));
    }

    /**
     * Check if any of multiple lists is null or empty
     *
     * @param lists List of lists
     * @return True if any list is null or empty
     */
    public static boolean isEmpty(List ... lists) {
        init();
        for (List list : lists) {
            if (list == null || list.isEmpty())
                return true;
        }
        return false;
    }

    /**
     * Check if input string is or looks line an email address.
     *
     * @param email Address to check
     * @return True if input matches email regex
     */
    public static boolean isStringEmail(String email) {
        init();
        if (isBlank(email))
            return false;
        String emailRegex = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        return Pattern.compile(emailRegex)
                .matcher(email)
                .matches();
    }

    /**
     * Replace multiple elements in string without using RegEx,
     * meaning it's possible to use "$username" or "[USERNAME]"
     * as placeholders in a string.
     * <p>
     * Example:
     * str = "Hello, [USERNAME] and welcome to $myApp!"
     * map = {"[USERNAME]"="Jimmy", "$myApp"="OnlyCats"}
     * expected result: "Hello, Jimmy and welcome to OnlyCats!"
     *
     * @param str Original string to change
     * @param map Map of placeholders and new values
     * @return Modified string
     */
    public static String replacePlaceholdersInString(String str, Map<String, String> map) {
        for (String key : map.keySet()) {
            str = str.replace(key, map.get(key));
        }
        return str;
    }
}
