package calculator;

public class Calculate {
    public static int calculate(int num1, int num2, String oper) {
        int res = 0;

        switch (oper) {
            case "+":
                res = (num1 + num2);
                break;
            case "-":
                res = (num1 - num2);
                break;
            case "*":
                res = (num1 * num2);
                break;
            case "/":
                try {
                    res = (num1 / num2);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("You cannot divide by zero");
                    throw new ArithmeticException();
                }

        }

        return res;
    }
}
