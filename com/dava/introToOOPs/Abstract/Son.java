package com.dava.introToOOPs.Abstract;

public class Son extends Parent{
    @Override
    void carrer(String name) {
        System.out.println("i a gonna become a " + name );
    }

    @Override
    void partner(String name, int age) {
        System.out.println("i love " + name + "her age is " + age);
    }
}
