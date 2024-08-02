package io.nqa.commons;

import java.util.regex.Pattern;

/**
 * Utility class for Generated Unique Identifier.
 * Used to {@link #generate} and {@link #verify} IDs.
 *
 * @since 1.5
 * @author Kristjan Männimets
 */
public class GUID {
    private static final int DEFAULT_LENGTH = 16;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String regex = "([A-Za-z0-9])+";

    /**
     * Generate ID with default length of {@value DEFAULT_LENGTH}
     *
     * @return generated ID as {@link String}
     */
    public static String generate() {
        return generate(DEFAULT_LENGTH);
    }

    /**
     * Generate ID with provided length.
     * <p>
     * For default length of {@value DEFAULT_LENGTH} use {@link #generate()} instead.
     *
     * @param length ID length
     * @return generated ID as {@link String}
     */
    public static String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int charIndex = (int) Math.floor(Math.random() * CHARACTERS.length());
            sb.append(CHARACTERS, charIndex, charIndex+1);
        }
        return sb.toString();
    }

    /**
     * Verify GUID using regex pattern, assuming ID is {@value DEFAULT_LENGTH} characters long.
     *
     * @param guid ID to verify
     * @return true if ID matches regex pattern
     */
    public static boolean verify(String guid) {
        return verify(DEFAULT_LENGTH, guid);
    }

    /**
     * Verify GUID using regex pattern and custom length.
     *
     * @param length length that ID is supposed to be
     * @param guid ID to verify
     * @return true if ID length and regex pattern match
     */
    public static boolean verify(int length, String guid) {
        if (guid.length() != length) return false;
        return Pattern.compile(regex).matcher(guid).matches();
    }
}
