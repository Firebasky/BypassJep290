package com.firebasky.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;

public class Urldns {
    public static Object getObject(final String url) throws Exception {
        URLStreamHandler handler = new SilentURLStreamHandler();
        HashMap ht = new HashMap();
        URL u = new URL(null, url, handler);
        ht.put(u, url);
        Reflections.setFieldValue(u, "hashCode", -1);
        return ht;
    }

    static class SilentURLStreamHandler extends URLStreamHandler {
        protected URLConnection openConnection(URL u) throws IOException {
            return null;
        }
        protected synchronized InetAddress getHostAddress(URL u) {
            return null;
        }
    }
}


