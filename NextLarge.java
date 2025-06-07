import java.util.*;
public class NextLarge {
    public static int count(int n)
    {
        int c=0;
        while(n>0)
        {
           int  k=n%2;
            if(k==1)
            {
               c+=1;
            }
            n=n/2;

        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=count(n);
        int f=0;
        for(int i=n+1;i<100;i++)
        {
            int z=count(i);
            if(z==c)
            {
                f=i;
                break;
            }

        }
       System.out.println(f);
        
    }
    
}
