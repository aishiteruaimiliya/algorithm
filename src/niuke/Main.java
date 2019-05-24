package niuke;

import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int M=0;
        int diff=0XFFF;
        while(diff!=0&&diff!=6174){
            char m[]=String.valueOf(N).toCharArray();
            char n[]=new char[m.length];
            Arrays.sort(m);
            int j=m.length-1;
            for (int i = 0; i <m.length ; i++) {
                n[i]=m[j--];
            }
            N=Integer.parseInt(String.valueOf(n));
            M=Integer.parseInt(String.valueOf(m));
            int max=Math.max(N,M);
            int min=Math.min(N,M);
            diff=max-min;
            String out="%s - %s = %s";
            String zero="";
            for(int i=0;i<4-(""+max).length();i++){
                zero+=0;
            }
            String zero1="";
            for(int i=0;i<4-(""+min).length();i++){
                zero1+=0;
            }
            System.out.println(String.format(out,zero+max,zero1+min,diff));
            if(diff==0) break;
            N=diff;
        }
    }
}