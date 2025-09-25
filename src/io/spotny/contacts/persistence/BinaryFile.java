package io.spotny.contacts.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class BinaryFile<T> {

    private final File file;

    public BinaryFile(String path) {
        file = new File(path);
    }

    public void write(T object) {
        try {
            var fos = new FileOutputStream(file);
            var out = new ObjectOutputStream(fos);

            out.writeObject(object);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T read() {
        try {
            if (!file.exists()) {
                return null;
            }

            var fis = new FileInputStream(file);
            var in = new ObjectInputStream(fis);

            var object = (T) in.readObject();
            in.close();

            return object;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
