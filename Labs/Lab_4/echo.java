public class echo extends Exp implements Exp.Command {
    private String[] Arr = new String[5];

    public echo(String[] a)
    {
 for(int i =0; i < a.length-1;i++){
    Arr[i] = a[i+1];
    }
    }
    public void execute()
    {
        for (int i = 0; i < Arr.length; i++) {
            if(Arr[i]!=null)
                System.out.print(Arr[i] + " ");
        }
    }

}
