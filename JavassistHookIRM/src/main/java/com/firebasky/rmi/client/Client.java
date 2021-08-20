package com.firebasky.rmi.client;

import com.firebasky.rmi.server.Test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6666);
        Test test = ( Test ) registry.lookup("test");
        test.Firebasky("this is test");
    }
}
