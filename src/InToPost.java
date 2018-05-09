import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class InToPost {
    private HashMap<String, Integer> PREC = new HashMap<>();

    public InToPost()
    {
        initiateMap();
    }
    public String infixToPostfix(String input)
    {
        String[] symbols = input.split(" ");

        Stack<String> ops = new Stack<>();
        List<String> postFix = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++)
        {
            if (isAlphanumeric(symbols[i])){
                postFix.add(symbols[i]);
            } else {
                String currentSym = symbols[i];
                if (PREC.containsKey(currentSym))
            }
        }
        return "";
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
        System.out.println(isAlphanumeric("1234"));
    }
}
