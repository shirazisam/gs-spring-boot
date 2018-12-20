package repository;

import hello.MyPlaceHolder;
import model.MyFile;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiraz on 19/12/2018.
 */
// @KeySpace("designInstanceGeneration")
@Repository
public class MyRepository {

    List<MyFile> myFiles = new ArrayList<>();

    public MyPlaceHolder getPlaceHolder(String name) {
        return new MyPlaceHolder(name);
    }

    public void save(MyFile myFile) {
        System.out.println("save::myFile = " + myFile.getFilename());
        myFiles.add(myFile);
    }

    public List<MyFile> getMyFiles() {
        return myFiles;
    }
}
