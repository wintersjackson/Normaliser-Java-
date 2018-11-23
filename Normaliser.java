
package feefo.examples;
import java.lang.*;
import java.util.*;
/**
 *
 * @author Dan
 */
public class Normaliser {
    /*recieve normalised titles-assuming they are passed, otherwise would only
    be referenced*/
    public String Normaliser(String jt, String[] nt){
        String title = jt;
        String[] normTitles = nt;
        //get normalised title similarity scores(lower is better for less edits)
        //find title with highest similarity and return it
        //Following ensures Array is right length
        int[] simScores =new int[normTitles.length];
        for (int i=0;i<simScores.length;i++) {
            simScores[i]=(Levenshtein(title, normTitles[i]));
        }
        int bestScoreLocation=0;
        for(int i=0;i<simScores.length;i++){
            if (simScores[i]<simScores[bestScoreLocation]) bestScoreLocation =i;
        }
        return normTitles[bestScoreLocation];
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


