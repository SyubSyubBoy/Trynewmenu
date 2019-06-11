package com.tailors.trynewmenu.infrastructure.resourcemanagement;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String upload(MultipartFile file);
}