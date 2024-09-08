package com.liehuhw.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RequestMapping("/upload")
@CrossOrigin
@RestController
public class UploadController {
    public static String OUT_PATH = "E:\\";

    @PostMapping("/single")
    public boolean single(@RequestParam("uploadedFile") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        File outFile = new File(OUT_PATH + filename);
        file.transferTo(outFile);
        return true;
    }

    @PostMapping("/multiple")
    public String multiple(@RequestParam("username") String username, @RequestParam("files") MultipartFile[] files) throws IOException {
        if(files != null && files.length > 0){
            for(MultipartFile file : files){
                String filename = file.getOriginalFilename();
                File outFile = new File(OUT_PATH + filename);
                file.transferTo(outFile);
            }
        }
        return username;
    }


}
