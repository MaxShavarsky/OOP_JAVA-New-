import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
public class lab {

    public static void main(String[] args) {
        String text,temp="",first ="",second="";
        List<Integer> limit = new LinkedList<>();
        List<String> words = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == ' '|| text.charAt(i) == '.' || text.charAt(i) == ',' || text.charAt(i) == '!' || text.charAt(i) == '?' || text.charAt(i) == ':')
            {
                limit.add(i);
            }
        }
        for (int i = 0; i < limit.size()-1; i++)
        {
            for (int j = limit.get(i)+1; j < limit.get(i+1); j++)
            {
                temp = temp + text.charAt(j);
            }
            words.add(temp);
            temp = "";
        }

        for (int i = 0; i < words.size(); i++)
        {
            first = words.get(i);
            for (int j = first.length()-1; j >= 0; j--) {
                second = second + first.charAt(j);
            }
            for (int f = 0; f < words.size(); f++)
            {
                if (second.equals(words.get(f)))
                {
                    System.out.println(first + "<-->"+second);
                    second = "";
                    break;
                }
            }
            second = "";
        }

    }
}

