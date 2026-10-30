package com.webDemo.controller;

import com.webDemo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file){
        log.info("name: {}, age: {}, file: {}", name, age, file.getOriginalFilename());

        try {
            String OFileName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + OFileName.substring(OFileName.lastIndexOf(".")) ;
            file.transferTo(new File("E:/upload/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result.success("上传成功");

    }
}
