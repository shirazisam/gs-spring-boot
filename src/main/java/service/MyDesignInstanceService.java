package service;

import model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.MyRepository;

/**
 * Created by shiraz on 19/12/2018.
 */
@Service
public class MyDesignInstanceService {

    @Autowired
    private MyRepository myRepository;

    public Page<MyFile> getMyFiles(Pageable pageable) {
        return myRepository.findAll(pageable);
    }
}
