package hello;

import model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MyDesignInstanceService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class HelloController {

    @Autowired
    private MyDesignInstanceService service;

    @RequestMapping("/")
    public String indexxx() {
        return "Greetings from Shiraz Boot!";
    }


    @PostMapping(path = "/designinstance/{designinstanceid}/data/placeholder/{placeholderName}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public MyPlaceHolder createDesignInstancePlaceholder(@PathVariable("designinstanceid") String designInstanceId,
                                                         @PathVariable("placeholderName") String placeholderName,
                                                         @RequestBody MyPlaceHolder placeholder) {
        System.out.println("designInstanceId = " + designInstanceId + placeholder);

        return service.getNewPlaceholder(designInstanceId + placeholderName + placeholder.getName().toUpperCase());
    }

    @GetMapping(path = "/myfiles", produces = APPLICATION_JSON_VALUE)
    public List<MyFile> getMyFiles() {
        return service.getMyFiles();
    }
}