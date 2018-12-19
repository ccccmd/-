import javafx.util.Pair;

import java.util.Scanner;

public class LargeIntegerOperation {
    public static void main(String []args){
        while(true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if (s.equals("finish")) {
                return;
            }
            String[] str = new String[3];
            str = s.split(" ");
            LargeInterger li = new LargeInterger();
            String first = str[0];
            String second = str[2];
            String judge = str[1];
            if (judge.equals("sub")) {
                if (first.charAt(0)!='-'&&second.charAt(0)=='-')
                {
                    System.out.print("+");
                    li.add(first,second.substring(1,second.length()));
                }
                else if(first.charAt(0)=='-'&&second.charAt(0)!='-')
                {
                    System.out.print("-");
                    li.add(first.substring(1,first.length()),second);
                }
                else if(first.charAt(0)!='-'&&second.charAt(0)!='-')
                {
                    li.sub(first,second);
                }
                else if (first.charAt(0)=='-'&&second.charAt(0)=='-')
                {
                    li.sub(second.substring(1,first.length()),first.substring(1,first.length()));
                }
            }
            else if (judge.equals("add")) {
                if(first.charAt(0)=='-'&&second.charAt(0)=='-')
                {
                    System.out.print("-");
                    li.add(first.substring(1,first.length()), second.substring(1,second.length()));
                }else if(first.charAt(0)!='-'&&second.charAt(0)!='-')
                {
                    System.out.print("+");
                    li.add(first,second);
                }
                else if(first.charAt(0)!='-'&&second.charAt(0)=='-')
                {
                    li.sub(first,second.substring(1,second.length()));
                }
                else if(first.charAt(0)=='-'&&second.charAt(0)!='-')
                {
                    li.sub(second,first.substring(1,first.length()));
                }
            }
        }

    }


}
