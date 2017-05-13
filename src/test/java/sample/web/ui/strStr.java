package sample.web.ui;

import java.util.Scanner;
public class strStr {
    static boolean findStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++) {
        	if(i+needle.length() <= haystack.length() && haystack.charAt(i) == needle.charAt(0))
        		if(haystack.substring(i, i+needle.length()).equals(needle))
        			return true;
        }
        return false;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        System.out.println(strStr.findStr(haystack, needle));
    }
}