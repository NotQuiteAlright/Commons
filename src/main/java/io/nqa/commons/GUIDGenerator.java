package io.nqa.commons;

/**
 * Generated Unique Identifier generator
 *
 * @deprecated use {@link io.nqa.commons.GUID} instead. To be removed in 1.6
 */
@Deprecated(since = "1.5", forRemoval = true)
public class GUIDGenerator {
    private static volatile GUIDGenerator guidGenerator;
    private static final int DEFAULT_LENGTH = 16;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private GUIDGenerator() {}

    @SuppressWarnings("InstantiationOfUtilityClass")
    private static void init() {
        if (guidGenerator == null) guidGenerator = new GUIDGenerator();
    }

    public static String generate() {
        return generate(DEFAULT_LENGTH);
    }

    public static String generate(int length) {
        init();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int charIndex = (int) Math.floor(Math.random() * CHARACTERS.length());
            sb.append(CHARACTERS, charIndex, charIndex+1);
        }
        return sb.toString();
    }
}
