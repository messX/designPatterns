package org.example.proxy;

public class App {
    public static void main(String[] args){
        Internet proxyInternet = new PoxyInternet();
        proxyInternet.connect("abc.com");
        proxyInternet.connect("csd.com");
    }
}
