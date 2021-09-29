package com.rmkshr.javanewfeatures.java8.methodreference;

public class UserImpl {

    static boolean isRealUser(_User user){
        return user.getName().startsWith("U") ? true : false;
    }

    boolean isLegalName(_User user) {
        return user.getName().endsWith("m") ? true : false;
    }
}


