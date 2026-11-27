package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/*
* 通用接口
* */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(@RequestParam("file") MultipartFile file)
            throws IOException {

        if (file.isEmpty()) {
            return Result.error("请选择要上传的文件");
        }

        // 获取原始文件名，例如：photo.jpg
        String originalName = file.getOriginalFilename();

        if (originalName == null || !originalName.contains(".")) {
            return Result.error("文件名没有后缀");
        }

        // 获取后缀，例如：.jpg
        String suffix = originalName.substring(originalName.lastIndexOf("."))
                .toLowerCase(Locale.ROOT);

        if (!Arrays.asList(".jpg", ".jpeg", ".png", ".webp").contains(suffix)) {
            return Result.error("只支持上传 JPG、PNG、WebP 图片");
        }

        // 生成新文件名，减少重名覆盖
        String newFileName = UUID.randomUUID() + suffix;

        // 确保上传目录存在
        Path uploadDir = Paths.get("E:/sky-uploads/").toAbsolutePath();
        Files.createDirectories(uploadDir);

        // 将上传文件保存到本地
        Path target = uploadDir.resolve(newFileName);
        file.transferTo(target);

        // 返回给前端用于访问图片的地址
        String imageUrl = "http://localhost:8080/uploads/" + newFileName;

        return Result.success(imageUrl);
    }
}
