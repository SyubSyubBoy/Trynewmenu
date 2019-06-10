package com.tailors.trynewmenu.ui;

import com.tailors.trynewmenu.infrastructure.resourcemanagement.FileUploadResult;
import com.tailors.trynewmenu.infrastructure.resourcemanagement.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ResourceController {

    @Autowired
    FileUploadService uploadService;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public FileUploadResult upload(@RequestBody MultipartFile file) {
        String result = uploadService.upload(file);
        return new FileUploadResult(result);
    }
}
