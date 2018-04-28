package other;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostFix {
    public static double evaluator(double a, double b, String op){
        switch (op){
            case "+": return a + b;

            case "-": return a - b;

            case "*": return a * b;

            case "/": return a / b;

            case "^": return Math.pow(b, a);

            case "%": return a % b;
        }
        throw new UnsupportedOperationException();
    }

    public static double evaluate(String expression)
    {
        String[] chunks = expression.split(" ");
        List<String> opList = new ArrayList<>();

        Stack<Double> expMem = new Stack<>();
        for (String item : chunks){
            try {
                double val = Double.parseDouble(item);
                expMem.push(val);
            } catch (NumberFormatException e){
                if (expMem.size() < 2){
                    throw new NumberFormatException();
                }
                double a = expMem.pop();
                double b = expMem.pop();
                expMem.push(evaluator(a, b, item));
            }
        }
        if (expMem.size() != 1){
            throw new IllegalStateException("Check your operators");
        }
        return expMem.peek();
    }
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to PostFix Eval 3000");
        String exp = reader.nextLine();
        System.out.format("The value of [%s] is \n", exp);
        System.out.println(evaluate(exp));
    }
}
