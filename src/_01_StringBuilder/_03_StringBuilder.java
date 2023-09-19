package _01_StringBuilder;


public class _03_StringBuilder {
	
    public static String append(String str, char[] characters) {
    	StringBuilder builder = new StringBuilder(str);
    	str = builder.append(characters).toString();
        return str;
    }
    
    public static String reverse(String str) {
    	StringBuilder builder = new StringBuilder(str);
    	str = builder.reverse().toString();
        return str;
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder builder = new StringBuilder(str);
    	str = builder.insert(index, newChar).toString();
        return str;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder builder = new StringBuilder(str);
    	str = builder.delete(startIndex, endIndex).toString();
        return str;
    }
}