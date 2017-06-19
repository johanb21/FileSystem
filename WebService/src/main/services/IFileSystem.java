package main.services;

import main.BeanFileSystem;

public interface IFileSystem {
	BeanFileSystem execCommand(String[] args);
}
