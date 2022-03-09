import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'textQueries' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY sentences
     *  2. STRING_ARRAY queries
     */

    public static List<List<Integer>> textQueries(List<String> sentences, List<String> queries) {

        // For each query, create a list of indexes of sentences that match all words in that query
        // If no sentence matches the query, use -1 as the index
        
        // e.x.
        // sentences = ["jim likes mary", "kate likes tom", "tom does not like jim"]
        // queries = ["jim tom", "likes"]
        //
        // return:
        // [[2], [0, 1]]
        
        // Write your code here
        
        List<List<Integer>> matches = new ArrayList<List<Integer>>();

        for (int i = 0; i < queries.size(); i++) {
            
            String query = queries.get(i);
            
            if(query == null || query.trim() == "") {
                matches.add(Arrays.asList(-1));
            }
            else {
                matches.add(queryMatches(query, sentences));
            }
        }

        return matches;

    }
    
    
    private static List<Integer> queryMatches(String query, List<String> sentences) {
        
        List<Integer> queryMatches = new ArrayList<>();
        
        String[] words = query.split(" ");
        
        
        for (int j = 0; j < sentences.size(); j++) {
            Boolean matches = true;

            for (int i = 0; i < words.length; i++) {
//                System.out.println(words[i] + "---" +  sentences.get(j) + " contains?   "+ sentences.get(j).contains(words[i]));
                matches = matches && sentences.get(j).contains(words[i]);
            }
            if(matches) {
                queryMatches.add(j);
            }
        }
        
        if(queryMatches.isEmpty()){
            queryMatches.add(-1);
        }
        
        return queryMatches;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
            
        System.out.print(Result.textQueries(Arrays.asList("jim likes mary", "kate likes tom", "tom does not like jim"), Arrays.asList("jim tom", "likes")));
        
    }
}
