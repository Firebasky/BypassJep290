package com.firebasky.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Test extends Remote {
    public String Firebasky(String msg) throws RemoteException;
}
