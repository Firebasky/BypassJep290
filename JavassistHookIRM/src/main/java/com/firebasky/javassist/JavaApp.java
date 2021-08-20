package com.firebasky.javassist;

import java.lang.instrument.Instrumentation;

public class JavaApp {
    public static void premain(String agentArgs, Instrumentation instru) throws Exception{
        System.out.println("hooking....");
        instru.addTransformer(new ClassTransFormer());
    }
}
