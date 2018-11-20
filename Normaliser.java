
package feefo.examples;
import java.lang.*;
/**
 *
 * @author Dan
 */
public class Normaliser {
    //setup normalised titles
    String title1="architect", title2="Software Engineer";
    String title3="quantity surveyor", title4 = "Accountant";
    public String Normaliser(String jt){
        String title = jt;
        //get normalised title similarity scores
        int result1 = Levenshtein(title,title1), result2 = Levenshtein(title,title2);
        int result3 = Levenshtein(title,title3), result4 = Levenshtein(title,title4);
        //find title with highest similarity and return it
        if (result1<result2&&result1<result3&&result1<result4){
            return title1;
        }else
        if (result2<result1&&result2<result3&&result2<result4){
            return title2;
        }else
        if (result3<result2&&result3<result1&&result3<result4){
            return title3;
        }else    
        if (result4<result2&&result4<result3&&result4<result1){
            return title4;
        }
        else return null;
    }

    public int Levenshtein(String a, String b) {
        /*Standard Levenshtein algorithm measures the minimum number of edits
        *to convert one string into another. Credit to rosettacode.org
        */
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        System.out.println(costs[b.length()]);
        return costs[b.length()];    }

}


