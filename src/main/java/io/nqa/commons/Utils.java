package io.nqa.commons;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Small collection of utility functions for quality of life improvement.
 */
public class Utils {

    /**
     * Check if any of multiple objects are null.<p>
     * If you have only one object use 'obj == null' instead.
     *
     * @param objects List of objects to test
     * @return True if any object is null
     */
    public static boolean isNull(Object ... objects) {
        if (objects == null) return true;
        try {
            for (Object obj : objects) {
                if (obj == null)
                    return true;
            }
        } catch (NullPointerException ignored) {
            return true;
        }
        return false;
    }

    /**
     * Opposite of {@link io.nqa.commons.Utils#isNull(Object...)}
     *
     * @param objects List of objects to test
     * @return True if none of provided objects is null
     * @since 1.5.1
     */
    public static boolean notNull(Object ... objects) {
        return !isNull(objects);
    }

    /**
     * Check if any of the given objects is not null.
     *
     * @param objects List of objects to test
     * @return True if any of given objects is not null
     * @since 1.6.2
     */
    public static boolean anyNotNull(Object ... objects) {
        if (objects == null) return false;
        for (Object obj : objects) {
            if (obj != null)
                return true;
        }
        return false;
    }

    /**
     * Check if any of multiple strings is null or blank.
     *
     * @param args List of strings to test
     * @return True if any string is null or blank
     */
    public static boolean isBlank(String ... args) {
        if (args == null) return true;
        for (String arg : args) {
            if (arg == null || arg.trim().isBlank())
                return true;
        }
        return false;
    }

    /**
     * Opposite of {@link io.nqa.commons.Utils#isBlank(String...)}
     *
     * @param args List of strings to test
     * @return True if none of the strings is null or blank
     * @since 1.5.1
     */
    public static boolean notBlank(String ... args) {
        return !isBlank(args);
    }

    /**
     * Check if two strings match.<p>
     * This may look like {@link String#equals(Object)}, but
     * it also checks for null and trims provided Strings
     *
     * @param str1 String 1
     * @param str2 String 2
     * @return True if strings match
     */
    public static boolean equals(String str1, String str2) {
        return (notNull(str1, str2) && str1.trim().equals(str2.trim()));
    }

    /**
     * Opposite of {@link io.nqa.commons.Utils#equals(String, String)}
     *
     * @param str1 String 1
     * @param str2 String 2
     * @return True if strings don't match
     * @since 1.5.1
     */
    public static boolean notEquals(String str1, String str2) {
        return !equals(str1, str2);
    }

    /**
     * Check if any following String matches first String.
     *
     * @param str String to compare against
     * @param args Strings to compare with
     * @return True if any strings match first string
     */
    public static boolean anyStringEquals(String str, String ... args) {
        for (String arg : args) {
            if (str.trim().equals(arg.trim())) return true;
        }
        return false;
    }

    /**
     * Opposite of {@link io.nqa.commons.Utils#anyStringEquals(String, String...)}
     *
     * @param str String to compare against
     * @param args Strings to compare with
     * @return True if none of the strings match first string
     * @since 1.5.1
     */
    public static boolean noStringEquals(String str, String ... args) {
        return !anyStringEquals(str, args);
    }

    /**
     * Check if any of multiple lists is null or empty
     *
     * @param lists List of lists
     * @return True if any list is null or empty
     */
    public static boolean isEmpty(List ... lists) {
        if (lists == null) return true;
        for (List list : lists) {
            if (list == null || list.isEmpty())
                return true;
        }
        return false;
    }

    /**
     * Opposite of {@link io.nqa.commons.Utils#isEmpty(List[])}
     *
     * @param lists List of lists
     * @return True if none of the Lists is null or empty
     * @since 1.5.1
     */
    public static boolean notEmpty(List ... lists) {
        return !isEmpty(lists);
    }

    /**
     * Check if input string is or looks line an email address.
     *
     * @param email Address to check
     * @return True if input matches email regex
     */
    public static boolean isStringEmail(String email) {
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

    /**
     * Check if text contains every string provided.
     *
     * @param text Main text to check
     * @param str List of strings that must be in text
     * @return true if text contains all strings
     */
    public static boolean textContainsAll(String text, String ... str) {
        for (String s : str)
            if (!text.contains(s))
                return false;
        return true;
    }

    /**
     * Convert integer to boolean.
     *
     * @param i integer to convert
     * @return true if i == 1
     */
    public static boolean intToBoolean(int i) {
        return i == 1;
    }

    /**
     * Convert boolean to integer.
     *
     * @param b boolean to convert
     * @return 1 if boolean = true
     */
    public static int booleanToInt(boolean b) {
        if (b) return 1;
        return 0;
    }
}
