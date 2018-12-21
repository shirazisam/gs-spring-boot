package rest;

import model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import service.MyDesignInstanceService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class HelloController {

    @Autowired
    private MyDesignInstanceService service;

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


}