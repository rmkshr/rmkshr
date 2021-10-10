package com.rmkshr.javanewfeatures.java15;

// The permitted class has to be nin-sealed or final. Only then the compiler will accept the implementation for compilation.

public non-sealed class SampleImplementation implements SealedClass {

    public static void main(String[] args) {
        SealedClass sealedClass = new SampleImplementation();
        System.out.println(sealedClass.dataSet);
    }
}
