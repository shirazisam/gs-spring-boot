package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shiraz on 20/12/2018.
 */
public class MyFile implements Serializable {

    @Id
    private String id;
    private long size = -1l;

    @JsonIgnore
    Path path;

    @JsonIgnore
    FileTime lastModifiedTime;

    @JsonCreator
    public MyFile(@JsonProperty("id") String id, @JsonProperty("size") String size, @JsonProperty("timestamp") String ts) throws ParseException {
        this.id = id;
        this.size = Long.valueOf(size);
        System.out.println("ts = " + ts);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(ts);
        lastModifiedTime = FileTime.fromMillis(date.getTime());
    }

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
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(lastModifiedTime.toMillis());
    }
}
