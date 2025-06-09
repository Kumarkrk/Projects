import java.util.*;
 class Set{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int brr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            brr[i]=sc.nextInt();
        }
        HashSet<Integer> s=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            //((Object) s).insert(arr[i]);
            s.add(arr[i]);
            s.add(brr[i]);
        }
        System.out.println(s);
    }
}