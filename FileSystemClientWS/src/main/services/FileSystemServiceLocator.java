/**
 * FileSystemServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main.services;

public class FileSystemServiceLocator extends org.apache.axis.client.Service implements main.services.FileSystemService {

    public FileSystemServiceLocator() {
    }


    public FileSystemServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FileSystemServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FileSystem
    private java.lang.String FileSystem_address = "http://localhost:8080/FileSystemWS/services/FileSystem";

    public java.lang.String getFileSystemAddress() {
        return FileSystem_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FileSystemWSDDServiceName = "FileSystem";

    public java.lang.String getFileSystemWSDDServiceName() {
        return FileSystemWSDDServiceName;
    }

    public void setFileSystemWSDDServiceName(java.lang.String name) {
        FileSystemWSDDServiceName = name;
    }

    public main.services.FileSystem getFileSystem() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FileSystem_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFileSystem(endpoint);
    }

    public main.services.FileSystem getFileSystem(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.services.FileSystemSoapBindingStub _stub = new main.services.FileSystemSoapBindingStub(portAddress, this);
            _stub.setPortName(getFileSystemWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFileSystemEndpointAddress(java.lang.String address) {
        FileSystem_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.services.FileSystem.class.isAssignableFrom(serviceEndpointInterface)) {
                main.services.FileSystemSoapBindingStub _stub = new main.services.FileSystemSoapBindingStub(new java.net.URL(FileSystem_address), this);
                _stub.setPortName(getFileSystemWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FileSystem".equals(inputPortName)) {
            return getFileSystem();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.main", "FileSystemService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.main", "FileSystem"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FileSystem".equals(portName)) {
            setFileSystemEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
