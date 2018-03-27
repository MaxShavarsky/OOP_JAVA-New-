import java.util.LinkedList;
import java.util.List;

public class lab {
    public static double parse(String rpnString) {
        double res = 0;
        List<Double> stek = new LinkedList<>();
        for (int i = 0; i < rpnString.length(); i++)
        {
            if (rpnString.charAt(i)=='('|| rpnString.charAt(i)==')'|| Character.isLetter(rpnString.charAt((i)))) {
                return 0;
            }
        }
        String exp = "";
        double value = 0;
        int index = 0;
        for (int i = 0; i < rpnString.length(); i++)
        {
            if (rpnString.charAt(i)==' ')
            {
                if (Character.isDigit(rpnString.charAt(i-1)))
                {
                    for (int j = index; j < i; j++)
                    {
                        exp = exp + rpnString.charAt(j);
                    }
                    value = Double.parseDouble(exp);
                    exp = "";
                    stek.add((double)value);
                    index = i + 1;
                }
                else
                {
                    double a=0;
                    a = stek.get(stek.size()-1);
                    stek.remove(stek.size()-1);
                    double b=0;
                    b = stek.get(stek.size()-1);
                    stek.remove(stek.size()-1);
                    switch (rpnString.charAt(i-1))
                    {
                        case '+':  res = a + b;
                            index = i + 1;
                            break;
                        case '-': res = b - a;
                            index = i + 1;
                            break;
                        case '*': res = a * b;
                            index = i + 1;
                            break;
                        case '/':try{
                            res = b / a;
                            index = i + 1;
                        }catch (Exception e){
                            throw new ArithmeticException();
                        }
                            break;
                            default:
                                break;
                    }
                    stek.add(res);
                }
            }
        }
        return stek.get(stek.size()-1);

    }
    public static void main(String[] args) {
        String str = "";
        if(args.length>=1) {
            for (int i = 0; i < args.length; i++) {
                str += args[i];
            }
            System.out.println(parse(str));
        }else{
            return;
        }

    }
}

