package com.kingscow.coach.strideJava.basic;


public class TypeConvert {

    public static void main(String[] args){
        String x = "1";
        String y = "2";
        System.out.println(x + y);

        String first = "Michael ";
        String last = "Fudge";
        System.out.println(first + last );

        int i = Integer.parseInt(x);
        int j = Integer.parseInt(y);
        System.out.println(i + j);

        String areYouHappy = "true";
        boolean ishappy = Boolean.parseBoolean(areYouHappy);
        System.out.println(ishappy);

        String gpa = "3.96";
        Double realgpa = Double.parseDouble(gpa);
        System.out.println(realgpa - 1.0 );

    }
}
