package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by shiraz on 20/12/2018.
 */
public class MyFile {

    private long size = -1l;
    String filename;
    Path path;

    public MyFile(String filename, Path path) {
        this.filename = filename;
        this.path = path;
        try {
            this.size = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    public long getSize() {
        return size;
    }
}
