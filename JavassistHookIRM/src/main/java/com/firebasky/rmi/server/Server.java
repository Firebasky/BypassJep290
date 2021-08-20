package com.firebasky.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception{
        Test test = new TestImpl();
        LocateRegistry.createRegistry(6666);
        String url = "rmi://127.0.0.1:6666/test";
        Naming.bind(url, test);
        System.out.println("server is running ...");
    }
}
