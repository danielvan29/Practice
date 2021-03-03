package com.van.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class IDUtils {

    public static String getID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test(){
        System.out.println(getID());
    }
}
