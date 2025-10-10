package com.dava.DSA.dataFormatting.BigInteger;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int a = 30;
        int b = 35;
        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(44);
        int c = B.intValue(); // used to convert the bigInt to int
        BigInteger C = new BigInteger("1234567890");
        BigInteger D = new BigInteger("56781234567890");
        //constants
        BigInteger E = BigInteger.ONE;
        //adding
        BigInteger S = C.add(D);
        System.out.println(S);
        System.out.println(C);
        System.out.println(Factorial.fact(12345223));
    }
}
