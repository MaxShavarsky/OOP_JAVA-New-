public class date extends Exp implements Exp.Command {
    public void execute()
    {
        System.out.println(System.currentTimeMillis());
    }

}
