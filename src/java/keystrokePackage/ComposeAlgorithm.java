/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package keystrokePackage;
import static java.lang.Math.*;
/**
 *
 * @author mehul
 */
public class ComposeAlgorithm {
    double time[];
    int code[];
    int size;
    UserObject O;
 private int check(int row,int col,double diff)
 {
     
     double t1=O.mean[row][col]-(5*O.std[row][col]);
     double t2=O.mean[row][col]+(5*O.std[row][col]);
     System.out.println(t1+"    "+diff+"    "+t2);
     if((diff>=(t1))&&(diff<=(t2)))
     {
      System.out.println("HITTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
         return 1;
     }
     return 0;
     
 }
 public UserObject updatel(double time1[],int code1[],int size1,UserObject O1)
 {
     double diff;
     time=time1;
    code=code1;
    size=size1;
    O=O1;
     for(int i=0;i<size-1;i++)
     {
         int r=code[i]-1;
         int c=code[i+1]-1;
         if(r!=-1||c!=-1)
         {
         diff = abs(time[i]-time[i+1]);
         inserti(r,c,diff);             
         }
     }
     return calculate();  
 }
 private void inserti(int row,int col,double diff)
 {    
     int t=O.index[row][col];
     O.x[row][col][t]=diff;
     O.index[row][col]=(t+1)%(10);     
     O.filled[row][col]++;
     O.flag[row][col]=true;
     
 }
 private UserObject calculate()
 {
     int k;
     double temp1[],sum;
     for(int i=0;i<8;i++)
     {
         for(int j=0;j<8;j++)
         {
            sum=0;
            if(O.flag[i][j])
            {
             for(k=0;k<O.filled[i][j]&&k<10;k++)   
             {
              sum+=O.x[i][j][k];
             }
             O.mean[i][j]=sum/k;                                              //MEAN
             sum=0;
             temp1=new double[k];
             for(int l=0;l<k;l++)
             {
              temp1[l]=O.x[i][j][l]-O.mean[i][j];
              temp1[l]*=temp1[l];
              sum+=temp1[l];
             }
             sum/=k;
             O.std[i][j]=sqrt(sum);                                   //STANDARD DEVIATION 
             O.flag[i][j]=false;
            }     
         }
     }   
     return O;

 }
 
 
public boolean Validate(double time1[],int code1[],int size1,UserObject O1)
{
    time=time1;
    code=code1;
    size=size1;
    O=O1;
    int r,c;
    float sum=0,total=0;
     double diff;
    /* if(O.flag==true)
     {
         System.out.print("User is entering for the first time");
         update();
         O.flag=false;
         return ;
     }*/
     //System.out.print("User is EXPERIENCED");
     for(int i=0;i<size-1;i++)
     {
         r=code[i]-1;
         c=code[i+1]-1;
         diff=abs(time[i]-time[i+1]);
         if(O.mean[r][c]!=0)                                                    //if record for that particular cell is not present
         {
          total++;
          sum+=check(r,c,diff);                      
          System.out.println("total"+total);
          System.out.println("sum"+sum);
         }
     }
     if(total==0)
         return false;
     else if(((sum/total)*100)>50)
             return true;
         else
             return false;    
 }
}