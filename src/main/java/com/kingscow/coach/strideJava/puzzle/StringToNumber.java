package com.kingscow.coach.strideJava.puzzle;

//converting string to number without using any library function by using ascii code
public class StringToNumber {
    private static int convertStringToInt(String num){
        int result=0;
        int zeroAscii=48;
        int nineAscii=57;
        for(char c: num.toCharArray()){
            if(c>=zeroAscii && c<=nineAscii){
                result=result*10+(c-zeroAscii);
            }else
                return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertStringToInt("peak"));
        System.out.println(convertStringToInt("8848"));
    }
}
