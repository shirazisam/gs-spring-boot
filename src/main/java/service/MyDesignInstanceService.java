package service;

import hello.MyPlaceHolder;
import model.MyFile;
import repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shiraz on 19/12/2018.
 */
@Service
public class MyDesignInstanceService {

    @Autowired
    private MyRepository repository;

    public MyPlaceHolder getNewPlaceholder(String name) {
        return repository.getPlaceHolder(name);
    }

    public List<MyFile> getMyFiles() {
        return repository.getMyFiles();
    }
}
