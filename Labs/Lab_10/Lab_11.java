import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class lab {

    public static void main(String[] args) throws IOException {
        Console console = System.console();
        if (console == null) {
            System.err.println("ERROR_404");
            System.exit(1);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter *1* if you want read from file and enter *2* if you want to write on your own.");
        int choose=0;
        choose = sc.nextInt();
        if(choose == 1)
        {
            FileReader FW = new FileReader("File.txt");
            Scanner s = new Scanner(FW);
            String text="";
            while(s.hasNextLine())
            {
                text+=s.nextLine();
            }
            FW.close();

            while (true)
            {
                Pattern p = Pattern.compile(console.readLine("%nEnter your regex: "));
                Matcher matcher = p.matcher(text);

                boolean found = false;
                while (matcher.find())
                {
                    console.format("I found the text" +
                                    " \"%s\" starting at " +
                                    "index %d and ending at index %d.%n",
                            matcher.group(),
                            matcher.start(),
                            matcher.end());
                    found = true;
                }
                if(!found)
                {
                    console.format("No match found.%n");
                }
            }
        }
        else if(choose == 2)
        {
            while (true)
            {

                Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));

                Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

                boolean found = false;
                while (matcher.find())
                {
                    console.format("I found the text" +
                                    " \"%s\" starting at " +
                                    "index %d and ending at index %d.%n",
                            matcher.group(),
                            matcher.start(),
                            matcher.end());
                    found = true;
                }
                if(!found)
                {
                    console.format("No match found.%n");
                }
            }
        }
        else
            {
            System.err.println("Incorect input");
            System.exit(1);
            }

    }
}
