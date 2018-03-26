public class Exp {

    public interface Command {
        public void execute();
    }

    public static void main (String[] args){
        if(args.length < 1|| args.length>2 &&!args[0].equalsIgnoreCase("echo" )) {
            System.out.println("Error");
        }else{
            if(args[0].equalsIgnoreCase("echo"))
            {
                echo e = new echo(args);
                e.execute();
            }
            else if(args[0].equalsIgnoreCase("date"))
            {
                date d = new date();
                d.execute();
            }
            else if(args[0].equalsIgnoreCase("help"))
            {
                help h = new help();
                h.execute();
            }
            else if(args[0].equalsIgnoreCase("exit"))
            {
                exit e = new exit();
                e.execute();
            }

        }
    }
}

