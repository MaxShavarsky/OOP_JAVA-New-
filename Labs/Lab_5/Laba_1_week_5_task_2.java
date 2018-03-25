package com.tasks6.rle_decoder;

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
                for (int i = 0; i < str.length()-1; i++) {
                    if ((Character.isDigit(str.charAt(i))&&Character.isDigit(str.charAt(i+1))) || Character.isDigit(str.charAt(0))) {
                        return;
                    }
                    else if (str.charAt(i)==str.charAt(i+1))
                    {
                        return;
                    }
                }
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isDigit(str.charAt(i)))
                    {
                        int n = str.charAt(i) - '0';

                        for (int j = 0; j < n-1; j++) {
                            System.out.println(str.charAt(i-1));
                        }
                    }
                    else {
                        System.out.println(str.charAt(i));
                    }
                }
            }
        }
	}
}      
      
