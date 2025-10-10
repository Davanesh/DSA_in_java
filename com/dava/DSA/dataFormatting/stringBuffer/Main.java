package com.dava.DSA.dataFormatting.stringBuffer;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //constructor 1
        StringBuffer sb1 = new StringBuffer();
        //constructor 2
        StringBuffer sb2 = new StringBuffer("dava");
        //constructor 3
        StringBuffer sb3 = new StringBuffer(30);
        sb1.append("hello");
        sb1.append(" world");
        String str = sb1.toString();
        System.out.println(str);

        int n = 20;
        String name = RandomString.generate(n);
        System.out.println(name);

        //remove whitespace
        String sentence = "we ert rty ty";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        //split
        String arr = "Davanesh Saminathan";
        String[] names = arr.split(" ");
        System.out.println(Arrays.toString(names));

        //rounding off
        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(4.4));
    }
}
