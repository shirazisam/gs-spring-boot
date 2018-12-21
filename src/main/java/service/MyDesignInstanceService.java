package service;

import exception.NotFoundException;
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

    public MyFile createNewFileEntry(MyFile entry) {
        return myRepository.save(entry);
    }

    public MyFile deleteMyFile(String fileId) {
        MyFile toDelete = myRepository.findOne(fileId);
        if (toDelete == null) {
            throw new NotFoundException();
        }
        myRepository.delete(toDelete);
        return toDelete;
    }

    public MyFile getMyFile(String fileId) {
        MyFile myFile = myRepository.findOne(fileId);
        if (myFile == null) {
            throw new NotFoundException();
        }
        return myFile;
    }
}
