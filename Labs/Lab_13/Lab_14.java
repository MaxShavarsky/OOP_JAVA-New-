import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
public class lab
{
    public static void main(String[] args) throws IOException {
      ArrayList<Integer> AL = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int choose=0;
        BufferedWriter bw= null;
        System.out.println("Function add(): ");
      for(int i = 0; i < 10;i++)
      {
          choose = sc.nextInt();
          AL.add(choose);
      }
        System.out.println("Function show(): ");
        for(int i = 0; i < AL.size();i++)
        {
            System.out.print(AL.get(i)+" ");
        }
        System.out.print("\nInput index of element you wanting to remove:");
      choose = sc.nextInt();
        System.out.println("Function remove(): ");
      AL.remove(choose);
        for(int i = 0; i < AL.size();i++)
        {
            System.out.print(AL.get(i)+" ");
        }
        System.out.print("\nInput element you wanting to find:");
        choose = sc.nextInt();
        if(AL.contains(choose)){
            System.out.println("Container contains "+ choose);
        }else{
            System.out.println("Container doesn't contain "+ choose);
        }
        System.out.println("Function sort(): ");
        Collections.sort(AL);
        for(int i = 0; i < AL.size();i++)
        {
            System.out.print(AL.get(i)+" ");
        }
        System.out.println("\nWriting data from container to file:");
        FileWriter FL = new FileWriter("Temp.txt",true);
        bw = new BufferedWriter(FL);
        for(int i = 0; i < AL.size();i++)
        {
            bw.write((AL.get(i)).toString());
        }
        System.out.println("Writing complited!");
        bw.close();

    }
}
