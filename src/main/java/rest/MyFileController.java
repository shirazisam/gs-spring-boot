package rest;

import model.MyFile;
import model.MyFileSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return discoveryClient.getInstances(applicationName);
    }

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

    @GetMapping(path = "/myfile/{id}", produces = APPLICATION_JSON_VALUE)
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