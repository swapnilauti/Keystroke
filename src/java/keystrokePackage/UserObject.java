/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package keystrokePackage;

import java.io.Serializable;

/**
 *
 * @author mehul
 */
public class UserObject implements Serializable {
 public double mean[][],std[][],x[][][];
 public int filled[][];
 public boolean flag[][];
 public int index[][];

 public UserObject()
 {
    filled=new int[9][9];
    x=new double[9][9][10];
    mean=new double[9][9];
    std=new double[9][9];
    flag=new boolean[9][9];
    index=new int[9][9];
 }   
}
