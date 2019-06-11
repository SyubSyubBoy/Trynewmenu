package com.tailors.trynewmenu.infrastructure.resourcemanagement.s3;

import com.tailors.trynewmenu.infrastructure.resourcemanagement.FileUploadService;
import com.tailors.trynewmenu.infrastructure.resourcemanagement.UploadFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3FileService implements FileUploadService {

    @Autowired
    S3FileUploader uploader;

    @Override
    public String upload(MultipartFile file) {
        try {
            return uploader.upload(file, "image");
        } catch (IOException e) {
            throw new UploadFailedException(e);
        }
    }
}
