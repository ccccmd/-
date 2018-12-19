import javafx.util.Pair;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;
import static sun.swing.MenuItemLayoutHelper.max;

public class LargeInterger {
    public LargeInterger(){

    }
    public void add(String first,String second)
    {

        if(first.length()>second.length())
        {
           add_first_longer(first,second);
        }
        else {
            add_first_longer(second,first);
        }
    }
    public void sub(String first,String second)
    {
        if(first.length()>second.length())
        {
            System.out.print("+");
            sub_first_larger(first, second);
        }
        else if(first.length()<second.length())
        {
            System.out.print("-");
            sub_first_larger(second,first);
        }
        else {
            int flag = 0;
            for(int i =0;i<first.length();i++)
            {
                if (first.charAt(i)<second.charAt(i))
                {
                    flag = 1;
                    break;
                }
                if(first.charAt(i)>second.charAt(i))
                {
                    flag = 2;
                    break;
                }
            }
            if(flag == 0)
            {
                System.out.println(0);
            }
            else if(flag == 1)
            {
                System.out.print("-");
                sub_first_larger(second,first);
            }
            else
                {
                    System.out.print("+");
                    sub_first_larger(first,second);
            }
        }
    }
    public void add_first_longer(String first,String second)
    {
        int []a = new int[first.length()];
        for(int i = 0;i < first.length();i++)
        {
            a[i] = charToDecimal(first.charAt(i));
        }
        int []b = new int[second.length()];
        for(int i = 0;i < second.length();i++)
        {
            b[i] = charToDecimal(second.charAt(i));
        }
        int []c = new int[first.length()+1];
        for(int i = 0;i<first.length()+1;i++)
        {
            c[i] = 0;
        }
        for(int i = first.length()-1,j = second.length()-1;i>=0&&j>=0;i--,j--)
        {
            if(a[i]+b[j]<16)
            {
                c[i+1] = a[i]+b[j];
            }
            else {
                c[i+1] = a[i]+b[j]-16;
                c[i]++;
            }
        }
        for(int i = 0;i<first.length()-second.length();i++)
        {
            c[i+1] += a[i];
        }
        for(int i = 0;i<=first.length();i++)
        {
            System.out.print(decimalToChar(c[i]));
        }
        System.out.println();
    }
    public void sub_first_larger(String first,String second){
        int []a = new int[first.length()];
        for(int i = 0;i < first.length();i++)
        {
            a[i] = charToDecimal(first.charAt(i));
        }
        int []b = new int[second.length()];
        for(int i = 0;i < second.length();i++)
        {
            b[i] = charToDecimal(second.charAt(i));
        }
        int []c = new int[first.length()+1];
        for(int i = 0;i<first.length()+1;i++)
        {
            c[i] = 0;
        }
        for(int i = first.length()-1,j = second.length()-1;i>=0&&j>=0;i--,j--)
        {
            if(a[i]-b[j]>=0)
            {
                c[i] = a[i]-b[j];
            }
            else {
                c[i] = a[i]-b[j]+16;
                c[i-1]--;
            }
        }
        for(int i = 0;i<first.length()-second.length();i++)
        {
            c[i] += a[i];
        }
        for(int i = 0;i<first.length();i++)
        {
            System.out.print(decimalToChar(c[i]));
        }
        System.out.println();
    }


    public static int charToDecimal(char c){ //字符（’0’~’9’，’a’~’z’）转换成整数
        int decimal = c;
        if (decimal <= 57) //0~9
            decimal -= 48;
        else //a~f
            decimal -= 87;
        return decimal;
    }
    public static char decimalToChar(int decimal){//整数（0~15）转换成字符
        if (decimal < 10){ //0~9
            decimal += 48;
            return (char)decimal;
        }
        else{ //a~f
            decimal += 87;
            return (char)decimal;
        }
    }
    public static Pair add3Char(char first, char second, char third){ //三个字符相加
        int iFirst = charToDecimal(first);
        int iSecond = charToDecimal(second);
        int iThird = charToDecimal(third);
        int sum = iFirst + iSecond + iThird;
        int quotient = sum / 16;
        int residual = sum % 16;
        char cQuotient = decimalToChar(quotient);
        char cResidual = decimalToChar(residual);
        return new Pair(cQuotient, cResidual);
    }

}
