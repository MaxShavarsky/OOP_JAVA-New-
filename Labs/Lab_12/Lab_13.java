import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ticker implements Runnable
{
    private ArrayList arr;
    private String function;
    public Ticker(ArrayList arr,String funtion)
    {
        this.arr = arr;
        this.function = funtion;
    }
    public static Integer Min(ArrayList arr)
    {
        int min = arr.indexOf(0);

        for(int i = 0; i < arr.size();i++)
        {
            if(min > arr.indexOf(i))
            {
                min = arr.indexOf(i);
            }
        }

        return min;
    }
    public static Integer Max(ArrayList arr)
    {
        int max = arr.indexOf(0);

            for (int i = 0; i < arr.size(); i++) {
                if (max < arr.indexOf(i)) {
                    max = arr.indexOf(i);
                }
            }

        return max;
    }
    public static Integer Sum(ArrayList arr)
    {
        int sum=0;

        for(int i = 0; i < arr.size();i++)
        {
            sum+= arr.indexOf(i);
        }
        return sum;
    }
    @Override
    public void run() {
        switch (function){
            case "Min":
                System.out.println(function +": " + Min(this.arr));
                break;
            case "Max":System.out.println(function +": " + Max(this.arr));
                break;
            case "Sum":System.out.println(function +": " + Sum(this.arr));
                break;
            default:
                System.out.println("Incorrect input.");
                break;
        }
    }
}
public class lab
{
    public static void main(String[] args)
    {
        long ls1,en1,ls2,en2;
         ArrayList<Integer> al = new ArrayList();
         for (int i =0; i < 1000;i++)
         {
             al.add(1 +(int)( Math.random() * 1000));
         }
         Ticker first = new Ticker(al,"Min");
        Ticker second = new Ticker(al,"Max");
        Ticker thierd = new Ticker(al,"Sum");
        ls1 = System.nanoTime();
        ExecutorService ES = Executors.newFixedThreadPool(3);
        ES.submit(first);
        ES.submit(second);
        ES.submit(thierd);
        en1 = System.nanoTime();
        System.out.println("\nParallel executing time: "+(en1-ls1));
        ls2= System.nanoTime();
        first.Min(al);
        second.Max(al);
        thierd.Sum(al);
        en2 = System.nanoTime();
        System.out.println("Successively executing time: "+(en2-ls2));
    }
}
