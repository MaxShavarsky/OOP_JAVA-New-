public class SquareRoot {

    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;

        //PUT YOUR CODE HERE
        double Disk = b*b - 4*a*c;
        double KDisk=Math.sqrt(Disk);
        double x1;
        double x2;
        if(a==0 && b!=0 && c!=0){
            
            
            x1=(-c)/b;
            x2=(-c)/b;
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
        }
         else if(a==0 && b==0){
        System.out.println("x1=");
        System.out.println("x2=");
        }
        else if(a==0 && c==0 && b!=0){
            x1=0;
            x2=0;
        System.out.println("x1="+x1);
        System.out.println("x2="+x2);
        }
        else if(a==0 && b==0 && c==0){
        System.out.println("x1=");
        System.out.println("x2=");
        }
        else{
            if(Disk<0){
                System.out.println("x1=");
                System.out.println("x2=");
            }
            else{
            x1=((-b)+KDisk)/(2*a);
            x2=((-b)-KDisk)/(2*a);
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
            }
        }
        //PUT YOUR CODE HERE
    }
}
