package com.customClassloader;

/**
 * Created by pjai60 on 11/24/2017.
 */
public class CustomClassLoader extends ClassLoader{
    public static void main(String[] args) {

    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
