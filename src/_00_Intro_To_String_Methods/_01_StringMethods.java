package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if (s1.length()> s2.length()) {
        	return s1;
        }
        else {
        	return s2;
        }
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	if(s.contains("underscores")) {
    		s = s.replace(' ', '_');
    	}
    	System.out.println(s);
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
        s1 = s1.trim();
        s2= s2.trim();
        s3 = s3.trim();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String[] name1 = s1.split(" "); // split on space character
        String[] name2= s2.split(" "); 
        String[] name3 = s3.split(" "); 

        
        if (name1[1].compareTo(name2[1])<0&& name1[1].compareTo(name3[1])<0) {
        	
        	return s1;
        }
        if(name2[1].compareTo(name1[1])<0&& name2[1].compareTo(name3[1])<0) {
        	
        	return s2;
        }

        else {
        	return s3;
        }
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    	for (int i = 0; i< s.length(); i++) {
    		if (Character.isDigit(s.charAt(i))) {
    			
    			int num = Integer.parseInt(s.charAt(i)+"");
    			sum += num;
    		}
    	}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	 int numOccurances = 0;
         int index = s.indexOf(substring);
         while( index != -1 ) {
             numOccurances++;
             index = s.indexOf(substring, index + substring.length());
         }
    	
        return numOccurances;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	String encrypted = Utilities.encrypt(s.getBytes(), (byte) key);
        return encrypted;
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	String decrypted = Utilities.decrypt(s, (byte) key);
    	return decrypted;
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	String[] words = s.split(" ");
    	int count = 0;
      
        for (String word : words) {
            
            if (word.endsWith(substring)) {
                count++;
            }
        }

        return count;
        
        }
        
        
    

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int firstIndex = s.indexOf(substring);
        int lastIndex = s.lastIndexOf(substring);
        if (firstIndex != -1 && lastIndex != -1) {
            int charCountBetween = lastIndex - firstIndex - substring.length();
            return charCountBetween;
        }
        
        // Handle the case where one or both occurrences were not found
        return -1; // You can choose to return a specific value or throw an exception here
    }
    

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	s=s.toLowerCase();
    	s=s.trim();
    	s=s.replace(" ", "");
    	s=s.replace(",", "");
    	s=s.replace("?", "");
    	s=s.replace(".", "");
    	s=s.replace("!", "");
    	s=s.replace("-", "");
    	s=s.replace(":", "");
    	s.toCharArray();
    	
    	String reversed = "";
    	for(int i = s.length()-1; i>=0; i--) {
    		System.out.println(i);
    		char curr = s.charAt(i);
    		System.out.println(curr);
    		reversed +=curr;
    	}
    	System.out.println(reversed);
    	System.out.println(s);
    	if(reversed.equals(s)) {
    		return true;
    	}
    	return false;
        
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
