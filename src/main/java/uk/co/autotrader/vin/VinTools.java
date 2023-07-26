package uk.co.autotrader.vin;

public class VinTools {
    private static final int[] WEIGHTS = {
            8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2
    };

    public static boolean validCheckDigit(StandardVin vin) {
        return calculateCheckDigit(vin) == vin.vds().checkDigit();
    }

    public static char calculateCheckDigit(StandardVin vin) {
        String vinText = vin.vinText();
        int sum = 0;
        for (int i = 0; i < vinText.length(); i++) {
            int x = transliterate(vinText.charAt(i)) * WEIGHTS[i];
            sum += x;
        }
        int checkDigit = sum % 11;

        if (checkDigit == 10) {
            return 'X';
        } else {
            return String.valueOf(checkDigit).charAt(0);
        }
    }

    private static int transliterate(char a) {
        return switch (a) {
            case '1', 'A', 'J' -> 1;
            case '2', 'B', 'K', 'S' -> 2;
            case '3', 'C', 'L', 'T' -> 3;
            case '4', 'D', 'M', 'U' -> 4;
            case '5', 'E', 'N', 'V' -> 5;
            case '6', 'F', 'W' -> 6;
            case '7', 'G', 'P', 'X' -> 7;
            case '8', 'H', 'Y' -> 8;
            case '9', 'R', 'Z' -> 9;
            default -> 0;
        };
    }
}
