import java.io.*;
import java.util.Scanner;
public class solution 
{
    public static void main(String args[]){
     Scanner sc= new Scanner(System.in);
     
     int i=sc.nextInt();
     int j=sc.nextInt();
      
     int originalI= i;
     int originalJ= j;
     
     if (i>j){
       int temp= i;
        i=j;
        j=temp;
     }
     
    int max=0;
     
    for(int num=i;num<=j;num++){
        long n=num;
        int count=1;
        
        while(n!=1){
            if(n%2==0)
            {n=n/2;
            }
            else{
                n=n*3+1;
            }
            count++;
        }
        if (count>max){
        max=count;}
    }
     
     System.out.println(originalI+ " " +originalJ+ " " +max);
     sc.close();
     
     
}}
