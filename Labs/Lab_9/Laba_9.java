class BusStation
{
    private int size;
    private class TimeTable
    {
        private int Ftime = 9;
        private int Ltime = 23;
        private int stops = 0;
        private int sits = 0;
        private int days = 0;
        private String way = "";

        public TimeTable()
        {
            Random r = new Random();
            stops = r.nextInt(1)+5;
            sits = r.nextInt(10)+20;
            days = r.nextInt(1)+7;
        }
        public String route(boolean b)
        {
            Random r = new Random();
            String temp = "";
            int limit = Ftime;
            int time = 0;
            boolean check = false;
            temp += "Bus station:9:00.";
            for (int j = 0; j < stops; j++)
            {
                temp += "Next station:";
                for (int i = 0; i < 3; i++)
                {
                    temp += (char)(r.nextInt(25)+65);
                }
                temp += ",stop at:";
                time = r.nextInt((Ltime-limit))+(limit+1);
                if (time != Ltime)
                {
                    String str = Integer.toString(time);
                    temp += str + ":00.";
                    limit = time;
                }
                else
                {
                    String str = Integer.toString(time);
                    temp += str + ":00.";
                    check = true;
                    break;
                }
            }
            if (!check) {
                temp += "Last station:";
                for (int i = 0; i < 3; i++)
                {
                    temp += (char)(r.nextInt(25)+65);
                }
                String str = Integer.toString(time);
                temp += str + ":00.";
            }
            way = temp;
            return way;
        }
        public void showInfo(boolean b, String str) throws IOException {
            if(b == true)
            {
                String result = "Number of trip: " + this + "\n" + "Days:" + days + "\n" + "Sits:" + sits + "\n" + "Route:" + route(b) + "\n";
                FileWriter f = new FileWriter(str);
                f.write(result);
                f.close();
            }
            else
                {
                    FileReader f = new FileReader(str);
                    Scanner scan = new Scanner(f);
                    int i = 1;
                    while (scan.hasNextLine())
                    {
                        System.out.println(i + " : " + scan.nextLine());
                        i++;
                    }
                    f.close();
                }
        }
    };
    TimeTable[] tb;
    public BusStation(int size)
    {
        size = size;
        tb = new TimeTable[size];
    }
    void CurrentTB(int index, boolean b,String str) throws IOException {
        tb[index] = new TimeTable();
        tb[index].showInfo(b,str);
    }
};
public class Test {
    public static void main(String[] args) throws IOException {
        boolean w = false;
        boolean r = true;
        if(args.length == 3 && args[0].equalsIgnoreCase("w") && args[1].equals("File.txt") && Character.isDigit(args[2].charAt(0)))
        {
            System.out.println("Write in File.txt");
            w = true;
            BusStation bs = new BusStation(Integer.parseInt(args[2]));
            for (int i = 0; i < Integer.parseInt(args[2]); i++) {
                bs.CurrentTB(i,w,args[1]);
                System.out.println("\n");
            }
        }
        else if(args.length == 3 && args[0].equalsIgnoreCase("r") && args[1].equals("File.txt") && Character.isDigit(args[2].charAt(0)))
        {
            System.out.println("Read from File.txt");
            r = false;
            BusStation bs = new BusStation(Integer.parseInt(args[2]));
            for (int i = 0; i < Integer.parseInt(args[2]); i++) {
                bs.CurrentTB(i,r,args[1]);
                System.out.println("\n");
            }
        }else{
            System.out.println("ERROR_404");
        }


    }
}
