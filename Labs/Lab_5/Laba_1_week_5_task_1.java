package com.tasks6.rle;

public class Application
{
	public static void main( String[] args )
	{
     String str;
        if (args.length == 1) {
            str = args[0];
            if (str.equalsIgnoreCase("")) {
                System.out.println("");
                return;
            } else {
                int count = 1;
                for (int i = 0; i < str.length() - 1; i++) {
                    if (count != 9) {
                        if (str.charAt(i) != str.charAt(i + 1)) {
                            System.out.print(str.charAt(i));
                            if (count != 1) {
                                System.out.print(count);
                                count = 1;
                            }
                        } else {
                            count++;
                        }
                    } else {
                        System.out.print(str.charAt(i));
                        System.out.print(count);
                        count = 1;
                    }
                }
                System.out.print(str.charAt(str.length() - 1));
                if (count != 1) {
                    System.out.print(count);
                }
            }
        }
	}
}      
      
