package com.kingscow.coach.strideJava.puzzle;


public class StringReverse {
    private static String reverse(String word) {
        char[] chs = word.toCharArray();
        int i=0, j=chs.length-1;
        while (i < j) {
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
            i++; j--;
        }
        return String.valueOf(chs);
    }

    //Reverse the String by java function without recursion
    private static String reverseWithoutRecursion(String str){
        if(str==null || str.length()==1)
            return str;
        int ii = str.length();
        char[] reverse = new char[ii];
        for(int i=0;i<ii;i++) {
            reverse[i]= str.charAt(ii-i-1);
        }
        return new String(reverse);
    }

    //Reverse the String by java function  with Recursive Function
    private static String reverseWithRecursion(String str) {
        System.out.print(str+"->");
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverseWithRecursion(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String original = "Go Ashton";
        System.out.println(original);

        System.out.println(reverse(original));
        System.out.println(reverseWithoutRecursion(original));
        System.out.println(reverseWithRecursion(original));

    }
}
