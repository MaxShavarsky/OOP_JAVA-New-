import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
public class lab {

    public static void main(String[] args) {
        Boolean debug = false;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase( "-help") || args[0].equalsIgnoreCase("-h")) {
                System.out.println("Max Shavarsky , KN-110 , Lab 8 ,\nTask 8.\n\n" +
                        "Enter text. In the text, find all pairs of words, one of which is the turn (the word of the opposite) of another (for example: abc \"-\" cba \",\" def \"-\" fed \"). The result is displayed in the form of a table.\n Arguments:" + args[0]);
                return;
            } else if (args[0].equalsIgnoreCase( "-debug")|| args[0].equalsIgnoreCase( "-d")) {
                debug = true;
            }

                String text, temp = "", first = "", second = "";
                List<Integer> limit = new LinkedList<>();
                List<String> words = new LinkedList<>();
                Scanner sc = new Scanner(System.in);
                text = sc.nextLine();
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == ' ' || text.charAt(i) == '.' || text.charAt(i) == ',' || text.charAt(i) == '!' || text.charAt(i) == '?' || text.charAt(i) == ':') {
                        limit.add(i);
                    }
                }
                if (debug == true) {
                    for (int i = 0; i < limit.size(); i++) {
                        System.out.print(limit.get(i));
                        System.out.print(" ");
                    }
                    System.out.print("\n");
                }
                for (int i = 0; i < limit.size() - 1; i++) {
                    for (int j = limit.get(i) + 1; j < limit.get(i + 1); j++) {
                        temp = temp + text.charAt(j);
                    }
                    words.add(temp);
                    temp = "";
                }
                if (debug == true) {
                    for (int i = 0; i < words.size(); i++) {
                        System.out.print(words.get(i));
                        System.out.print(" ");
                    }
                    System.out.print("\n");
                }
                for (int i = 0; i < words.size(); i++) {
                    first = words.get(i);
                    for (int j = first.length() - 1; j >= 0; j--) {
                        second = second + first.charAt(j);
                    }
                    for (int f = 0; f < words.size(); f++) {
                        if (second.equals(words.get(f))) {
                            System.out.println(first + "<-->" + second);
                            second = "";
                            break;
                        }
                    }
                    second = "";
                }

            
        }
    }
}
