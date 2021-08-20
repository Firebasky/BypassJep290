package com.firebasky.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestImpl extends UnicastRemoteObject implements Test {
    public TestImpl() throws RemoteException {
        super();
    }
    public String Firebasky(String msg){
        System.out.println(msg);
        return msg;
    }
}