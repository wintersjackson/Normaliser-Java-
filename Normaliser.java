/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feefo.examples;
import java.lang.*;
/**
 *
 * @author Dan
 */
public class Normaliser {
    String title1="architect", title2="Software Engineer";
    String title3="quantity surveyor", title4 = "Accountant";
    public String Normaliser(String jt){
        String title = jt;
        int result1 = Math.abs(title.compareTo(title1));
        int result2 = Math.abs(title.compareTo(title2));
        int result3 = Math.abs(title.compareTo(title3));
        int result4 = Math.abs(title.compareTo(title4));
        if (result1<result2||result1<result3||result1<result4){
            return title1;
        }else
        if (result2<result1||result2<result3||result2<result4){
            return title2;
        }else
        if (result3<result2||result3<result1||result3<result4){
            return title3;
        }else    
        if (result4<result2||result4<result3||result4<result1){
            return title4;
        }
        else return null;
    }
        
}
