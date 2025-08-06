package com.uriarte.smartsummary.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {

    Path uploadPath = Paths.get("/uploads");

    public ResponseEntity<String> uploadFile(MultipartFile file) {
        try {
            Files.createDirectories(uploadPath.getParent());
            Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok().body("File uploaded");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating directory");
        }
    }

}
