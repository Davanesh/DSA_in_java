package com.dava.introToOOPs.lambda;

import java.util.ArrayList;

public class LambdaFun {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        arrayList.forEach((item) -> {
            System.out.println(item*2);
        });
    }
    Operations add = (a, b) -> a+b;
    Operations sub = (a, b) -> a-b;
}

interface Operations {
    int operation(int a, int b);
}
