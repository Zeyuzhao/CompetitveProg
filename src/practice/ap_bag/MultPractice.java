package practice.ap_bag;

public class MultPractice implements StudyPractice{
    private int firstNum;
    private int secondNum;
    public MultPractice(int a, int b)
    {
        firstNum = a;
        secondNum = b;
    }
    public void nextProblem()
    {
        secondNum++;
    }

    public String getProblem()
    {
        return String.format("%d TIMES %d", firstNum, secondNum);
    }

    public static void main(String[] args) {
        StudyPractice tester = new MultPractice(3, 2);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(tester.getProblem());
            tester.nextProblem();
        }
    }
}
