/**
 * FileSystem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main.services;

public interface FileSystem extends java.rmi.Remote {
    public main.BeanFileSystem build() throws java.rmi.RemoteException;
    public main.BeanFileSystem execCommand(java.lang.String uid, java.lang.String[] args) throws java.rmi.RemoteException;
}
