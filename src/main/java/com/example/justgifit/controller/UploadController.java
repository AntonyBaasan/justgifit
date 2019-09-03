package com.example.justgifit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

@RestController
public class UploadController {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${spring.servlet.multipart.location}")
    private String location;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)
    public String upload(
            @RequestPart("file") MultipartFile file,
            @RequestParam("start") int start,
            @RequestParam("end") int end,
            @RequestParam("speed") int speed,
            @RequestParam("repeat") boolean repeat
    ) throws IOException {
        File videoFile = new File(location + "/" + System.currentTimeMillis() + ".mp4");
        file.transferTo(videoFile);
        log.info("Saved file to {}", videoFile.getAbsoluteFile());
        return "";
    }
}
