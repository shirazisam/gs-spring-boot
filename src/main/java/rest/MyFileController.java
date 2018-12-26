package rest;

import model.MyFile;
import model.MyFileSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import service.MyFileService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MyFileController {

    @Autowired
    private MyFileService service;

    @RequestMapping("/")
    public String indexxx() {
        return "Greetings from Shiraz Boot!";
    }


//    @PostMapping(path = "/designinstance/{designinstanceid}/data/placeholder/{placeholderName}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public MyPlaceHolder createDesignInstancePlaceholder(@PathVariable("designinstanceid") String designInstanceId,
//                                                         @PathVariable("placeholderName") String placeholderName,
//                                                         @RequestBody MyPlaceHolder placeholder) {
//        System.out.println("designInstanceId = " + designInstanceId + placeholder);
//
//        return service.getNewPlaceholder(designInstanceId + placeholderName + placeholder.getName().toUpperCase());
//    }

    @GetMapping(path = "/myfiles", produces = APPLICATION_JSON_VALUE)
    public Page<MyFile> getMyFiles(Pageable pageable) {
        return service.getMyFiles(pageable);
    }

    @GetMapping(path = "/myfileslist", produces = APPLICATION_JSON_VALUE)
    public List<MyFile> getMyFilesList(Pageable pageable) {
        return service.getMyFilesList(pageable);
    }

    @PostMapping(path = "/myfile")
    public MyFile createNewDocumentDesign(@RequestBody MyFile entry) {
        return service.createNewFileEntry(entry);
    }

    @GetMapping(path = "/myfile/{id}")
    public MyFile getMyFile(@PathVariable("id") String fileId) {
        return service.getMyFile(fileId);
    }

    @DeleteMapping(path = "/myfile/{id}")
    public MyFile deleteMyFile(@PathVariable("id") String fileId) {
        return service.deleteMyFile(fileId);
    }

    @GetMapping(path = "/myfilesummary", produces = APPLICATION_JSON_VALUE)
    public MyFileSummary getMyfileSummary() {
        return service.getMyfilesSummary(null);
    }

}