package service;

import model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import repository.MyRepository;
import util.DocumentUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by shiraz on 20/12/2018.
 */
@Component
public class MyFileInitService {

    private static final String EXT_PDF = ".pdf";
    private Path myDirectory;

    @Autowired
    private MyRepository myRepository;

    public MyFileInitService(@Value("${shiraz.files:shite/crap}") String myDirectory) throws IOException {
        this.myDirectory = Files.createDirectories(Paths.get(myDirectory));
    }

    @PostConstruct
    private void initDesignFiles() throws IOException {
        listDesignFiles().forEach(myRepository::save);
        System.out.println("Post construct complete. " + myDirectory.toString());
    }

    @PreDestroy
    private void terminate() throws Exception {
        System.out.println("The application has been terminated.");
    }

    private List<MyFile> listDesignFiles() throws IOException {
        Path dir = myDirectory;
        return Files.list(dir)
                .filter(f -> f.getFileName().toString().endsWith(EXT_PDF))
                .map(ff -> {
                    Optional<String> id = DocumentUtil.getFileNameWithoutExtension(ff.getFileName());
                    return new MyFile(id.get(), ff);
                })
                .collect(Collectors.toList());
    }

}
