package model;

import org.springframework.data.annotation.Id;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

/**
 * Created by shiraz on 20/12/2018.
 */
public class MyFile {

    @Id
    private String id;
    private long size = -1l;
    Path path;
    FileTime lastModifiedTime;

    public MyFile(String filename, Path path) {
        this.id = filename;
        this.path = path;
        try {
            this.lastModifiedTime = Files.getLastModifiedTime(path);
            this.size = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public long getSize() {
        return size;
    }

    public String getTimestamp() {
        return lastModifiedTime.toString();
    }
}
