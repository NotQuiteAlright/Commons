package io.nqa.commons;

public class PersonalCode {

    /**
     * Verify validity of Estonian personal code.
     *
     * @param personalCode code to check
     * @return true if code looks valid
     */
    public static boolean verify(long personalCode) {
        String persCodeStr = String.valueOf(personalCode);
        if (persCodeStr.length() != 11) return false;
        int[] code = new int[persCodeStr.length()];
        for (int i = 0; i < persCodeStr.length(); i++) {
            code[i] = Integer.parseInt(persCodeStr.substring(i, i + 1));
        }
        // I step weight: 1 2 3 4 5 6 7 8 9 1
        int control = (code[0] + code[1] * 2 + code[2] * 3 + code[3] * 4 +
                code[4] * 5 + code[5] * 6 + code[6] * 7 + code[7] * 8 +
                code[8] * 9 + code[9]) % 11;
        if (control == 10) {
            // II step weight: 3 4 5 6 7 8 9 1 2 3
            control = (code[0] * 3 + code[1] * 4 + code[2] * 5 +
                    code[3] * 6 + code[4] * 7 + code[5] * 8 + code[6] * 9 +
                    code[7] + code[8] * 2 + code[9] * 3) % 11;
        }
        if (control == 10) control = 0;
        return control == code[10];
    }
}
