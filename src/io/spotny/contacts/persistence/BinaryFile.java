package io.spotny.contacts.persistence;

public abstract class BinaryFile<T> {

    private final String fileName;

    public BinaryFile(String fileName) {
        this.fileName = fileName;
    }
    

    public void write(T object){
        
    }
}
