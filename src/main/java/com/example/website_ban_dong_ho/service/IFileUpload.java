package com.example.website_ban_dong_ho.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface IFileUpload {
    Map uploadFile(MultipartFile multipartFile) throws IOException;

    void deleteFile(String imgId) throws IOException;

    Map updateFile(String imgId, MultipartFile multipartFile) throws IOException;


}
