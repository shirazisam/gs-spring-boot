package repository;

import model.MyFile;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shiraz on 19/12/2018.
 */
@KeySpace("myFile")
public interface MyRepository extends PagingAndSortingRepository<MyFile, String> {

}
