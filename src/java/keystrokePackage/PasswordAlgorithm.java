/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package keystrokePackage;

import static java.lang.Math.sqrt;

/**
 *
 * @author Smita
 */
public class PasswordAlgorithm {
    public double stdDeviation[],sum,temp[],temp1[],mean[],wLatency[];
    public int plength;
/*public KeyRecord Create(int a[][],int rows)    
{
    plength=a[0].length;
KeyRecord m=new KeyRecord(plength);
m=Calculate(m,a,rows);
return m;
}*/

public KeyRecord Create(KeyRecord m,int a[][],int rows)
{
    plength=a[0].length;
    mean=new double[plength];
    stdDeviation=new double[plength];
    wLatency=new double[plength];
    temp=new double[plength];
    temp1=new double[rows];
    for(int j=0;j<plength;j++)
    {
        sum=0;
     for(int i=0;i<rows;i++)   
     {
         sum+=a[i][j];
     }
     mean[j]=sum/rows;                                              //MEAN
     sum=0;
     for(int i=0;i<rows;i++)
     {
         temp1[i]=a[i][j]-mean[j];
         temp1[i]*=temp1[i];
         sum+=temp1[i];
     }
     sum/=rows;
     sum=sqrt(sum);
     stdDeviation[j]=sum;                                   //STANDARD DEVIATION 
    }
    sum=0;
    for(int j=0;j<plength;j++)
    {
        temp[j]=mean[j]/stdDeviation[j];
        sum+=temp[j];
    }
    for(int j=0;j<plength;j++)
    {
        wLatency[j]=(temp[j]/sum)*100;                  //WEIGHTED LATENCY
    }
    
    return(Insert(m,mean,stdDeviation,wLatency));
}

KeyRecord Insert(KeyRecord n,double m[],double s[],double w[])
{
    for(int j=0;j<plength;j++)
    {
      n.mean[j]=m[j];   
      n.std[j]=s[j];
      n.wlatency[j]=w[j];
    }
    return n;
}
public int Validate(KeyRecord k,double diff[])
{
    double count=0.0;
    sum=0;
System.out.println("Validate Called");
 for(int j=0;j<diff.length;j++)
 {
     System.out.println("mean"+k.mean[j]);
     System.out.println(k.std[j]);
     
 }
 for(int j=0;j<diff.length;j++)
 {
     if((diff[j]>=(k.mean[j]-2*k.std[j]))&&(diff[j]<=(k.mean[j]+2*k.std[j])))
     {
          sum+=k.wlatency[j]; 
          count++;
          //System.out.println("Count"+count);
          //System.out.println("W"+k.wlatency[j]);
     }
 }
 // System.out.println("differnce length"+diff.length);
  System.out.println("SUM"+sum);
 double t=count/diff.length;
 t*=100;
 System.out.println("Hit Percent  "+t);
 for(int j=0;j<diff.length;j++)
 {
  //System.out.println(k.std[j]);
  count+=k.std[j];
 }
 count/=diff.length;
 System.out.println("Average std  "+count);
 if(t<60)
 {
     return 0;
     } 
 else
 {
     if(sum<50.0)
     {
         return 0;
     }
     else
     {
         //System.out.println("000000000000");
         return 1;
     }  
 }
 
}
}
 //return (((count/diff.length+1)*100)>=70)&&(sum>=60);
//}
//}

