import practice.PostFix;

import java.util.*;

public class InToPost {
    private HashMap<String, Integer> PREC = new HashMap<>();

    public InToPost()
    {
        initiateMap();
    }
    public List<String> infixToPostfix(String input)
    {
        String[] symbols = input.split(" ");

        Stack<String> ops = new Stack<>();
        List<String> postFix = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++)
        {
            System.out.println("Current Sym: " + symbols[i]);
            System.out.println(ops);
            if (isAlphanumeric(symbols[i])){
                postFix.add(symbols[i]);
            } else {
                String currentSym = symbols[i];
                if (currentSym.equals("("))
                {
                    ops.push("(");
                } else
                if (currentSym.equals(")")){
                    String temp = ops.pop();
                    while (!temp.equals("(")){
                        postFix.add(temp);
                        temp = ops.pop();
                    }
                } else
                if (PREC.containsKey(currentSym)){
                    while (!ops.isEmpty() && PREC.get(ops.peek()) >= PREC.get(currentSym)){
                        postFix.add(ops.pop());
                    }
                    ops.add(currentSym);
                }
            }
        }
        while (!ops.isEmpty()){
            postFix.add(ops.pop());
        }
        return postFix;
    }
    private void initiateMap()
    {
        PREC.put("(", 0);
        PREC.put("+", 1);
        PREC.put("-", 1);
        PREC.put("*", 2);
        PREC.put("/", 2);
        PREC.put("^", 3);
    }
    //Improve alphanumeric to include negative values
    public static boolean isAlphanumeric(String a)
    {
        for (int i = 0; i < a.length(); i++)
        {
            char c = a.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.println("Expression");
            String exp = reader.nextLine();
            System.out.format("The postfix representation of [%s] is \n", exp);
            InToPost converter = new InToPost();
            List<String> postFixExp = converter.infixToPostfix(exp);
            System.out.println(Arrays.toString(postFixExp.toArray()));
            System.out.format("The value of [%s] is \n", exp);
            System.out.println(PostFix.evaluate(postFixExp));
            System.out.println("--------------------------------------");
        }
    }
}
