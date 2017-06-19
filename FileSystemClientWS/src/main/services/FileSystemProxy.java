package main.services;

public class FileSystemProxy implements main.services.FileSystem {
  private String _endpoint = null;
  private main.services.FileSystem fileSystem = null;
  
  public FileSystemProxy() {
    _initFileSystemProxy();
  }
  
  public FileSystemProxy(String endpoint) {
    _endpoint = endpoint;
    _initFileSystemProxy();
  }
  
  private void _initFileSystemProxy() {
    try {
      fileSystem = (new main.services.FileSystemServiceLocator()).getFileSystem();
      if (fileSystem != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fileSystem)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fileSystem)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fileSystem != null)
      ((javax.xml.rpc.Stub)fileSystem)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.services.FileSystem getFileSystem() {
    if (fileSystem == null)
      _initFileSystemProxy();
    return fileSystem;
  }
  
  public main.BeanFileSystem execCommand(String[] args) throws java.rmi.RemoteException{
    if (fileSystem == null)
      _initFileSystemProxy();
    return fileSystem.execCommand(args);
  }
  
  
}