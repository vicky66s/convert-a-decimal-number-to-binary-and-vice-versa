public class DecimalBinaryConverter {
    
    // Function to convert decimal to binary
    public static String decimalToBinary(double decimal) {
        long intPart = (long) decimal;
        double fractionalPart = decimal - intPart;

        String binaryIntPart = Long.toBinaryString(intPart);
        String binaryFractionalPart = "";

        // Convert fractional part to binary
        if (fractionalPart != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            while (fractionalPart > 0) {
                fractionalPart *= 2;
                if (fractionalPart >= 1) {
                    sb.append(1);
                    fractionalPart -= 1;
                } else {
                    sb.append(0);
                }
            }
            binaryFractionalPart = sb.toString();
        }

        return binaryFractionalPart.isEmpty() ? binaryIntPart : binaryIntPart + binaryFractionalPart;
    }

    // Function to convert binary to decimal
    public static double binaryToDecimal(String binary) {
        int intPart = Integer.parseInt(binary.split("\\.")[0], 2);
        double fractionalPart = 0;
        
        if (binary.contains(".")) {
            String fraction = binary.split("\\.")[1];
            for (int i = 0; i < fraction.length(); i++) {
                if (fraction.charAt(i) == '1') {
                    fractionalPart += 1.0 / Math.pow(2, i + 1);
                }
            }
        }

        return intPart + fractionalPart;
    }

    // Sample usage of the functions
    public static void main(String[] args) {
        double decimalNumber = 10.5;
        String binaryNumber = decimalToBinary(decimalNumber);
        System.out.println("Binary equivalent of " + decimalNumber + " is: " + binaryNumber);

        String binaryString = "1010.1";
        double convertedDecimal = binaryToDecimal(binaryString);
        System.out.println("Decimal equivalent of binary " + binaryString + " is: " + convertedDecimal);
    }
}
