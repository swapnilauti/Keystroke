
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package keystrokePackage;

import java.io.Serializable;

/**
 *
 * @author Smita
 */
public class KeyRecord implements Serializable{
    public double wlatency[],mean[],std[];
    
    public KeyRecord(int colLeng){
    
        wlatency=new double[colLeng];
        mean=new double[colLeng];
        std=new double[colLeng];        
    }
}
