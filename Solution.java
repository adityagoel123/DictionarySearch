package examples;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	Scanner console = new Scanner(System.in);
       
    	
        System.out.println("Please enter Number of Words in Dictionary : ");
        int countOfWordsInDictionary = console.nextInt();
        // Cannot take duplicate words for a dictionary.
        Set<String> dictionary = new LinkedHashSet<String>(countOfWordsInDictionary);
        System.out.println("Please enter " + countOfWordsInDictionary + " words one by one :");
        
        for(int i =1;i<=countOfWordsInDictionary;i++){
        	String wordOfDictionary = console.next().trim();
        	dictionary.add(wordOfDictionary);
        }
        
       
        System.out.println("Please enter the queryString now :- ");
        String queryString = new String();
   
      //queryString = console.findInLine(".{5}");
        queryString = console.next().trim();
      
        queryString = queryString.substring(0,500);
        
        //Converting Set to Array of Strings.
         String[] strArray = dictionary.toArray(new String[dictionary.size()]);
        
 
        
        String finalAnswer = constructCorrectQueryString(strArray,queryString.trim());
        
        System.out.println("Final Query String is :- "  + finalAnswer);
        
        console.close();
    }

	private static String constructCorrectQueryString(String[] strArray, String queryString) {
		// TODO Auto-generated method stub
		for(int i = 0; i< strArray.length; i++){
			StringBuffer recentOutput = new StringBuffer();
			if(queryString.contains(strArray[i])){
				//Bifurcate the queryString Now
				recentOutput.append(strArray[i]).append(" ");
		        String queryStringLeft = queryString.replace(strArray[i], "");
		        if(queryStringLeft.isEmpty()){
		        	return recentOutput.toString(); 	
		        } else{
		        	String justGotOP = constructCorrectQueryString(strArray, queryStringLeft.trim());
		        	if(null == justGotOP){
		        		//return null;
		        		continue;
		        	} else {
		        		return recentOutput.append(justGotOP).toString();
		        	}
		        }
		        
			}
		}
		
		return null;
	}
}

/*
class OrderStringByLength implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int c = s1.length() - s2.length();
        return (c != 0) ? c : s1.compareTo(s2);
    }
}
*/
