package calculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1, num2;
        int numResult;

        System.out.println(" Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");

        while (true) {
            String userInput = reader.readLine();
            if (userInput.toLowerCase().contains("end")) {
                break;
            }

            String[]strOperands = userInput.split("[+\\-*/]");
            String operators = userInput.substring(strOperands[0].length(), strOperands[0].length() + 1);

            if (isNumber(strOperands[0]) && isNumber(strOperands[1])) {
                num1 = Integer.parseInt(strOperands[0]);
                num2 = Integer.parseInt(strOperands[1]);

                if (!isInRange(num1, num2)) {
                    throw new IllegalArgumentException("Числа должны быть от 0 до 10");
                }

                numResult = Calculate.calculate(num1, num2, operators);
                System.out.println(numResult);

            } else {
                num1 = Converter.romanToArabic(strOperands[0]);
                num2 = Converter.romanToArabic(strOperands[1]);
                numResult = Calculate.calculate(num1, num2, operators);
                System.out.println(Converter.arabicToRoman(numResult));
            }
        }
    }

    private static boolean isNumber(final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }

    private static boolean isInRange(int num1, int num2) {

        return !(num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10);
    }

}
