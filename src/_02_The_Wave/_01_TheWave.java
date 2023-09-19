package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
    	StringBuilder builder = new StringBuilder(str);
        ArrayList<String>wave = new ArrayList();
        
        for(int i = 0; i<str.length(); i++) {
        	
        	if(str.charAt(i)!=' ') {
	        	if(i>0) {
	        	String prev = String.valueOf(str.charAt(i-1)).toLowerCase();
	        	String word1 =builder.replace(i-1,i,prev).toString();
	        	}

	        	String ch = String.valueOf(str.charAt(i)).toUpperCase();
	
	        	String word1 =builder.replace(i,i+1,ch).toString();
	        	System.out.println(word1);
	        	wave.add(word1);
        	}
        	if(i>0 && str.charAt(i)==' ') {
	        	String prev = String.valueOf(str.charAt(i-1)).toLowerCase();
	        	String word1 =builder.replace(i-1,i,prev).toString();
	        	}
        	
        
        
        }
        System.out.println(wave);
        return wave;
    }
}
