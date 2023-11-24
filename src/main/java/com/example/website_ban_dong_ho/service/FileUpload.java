package com.example.website_ban_dong_ho.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileUpload implements IFileUpload {
    @Autowired
    private final Cloudinary cloudinary;

    @Override
    public Map uploadFile(MultipartFile multipartFile) throws IOException {
        return cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
    }

    @Override
    public void deleteFile(String imgId) throws IOException {
        cloudinary.uploader().destroy(imgId, ObjectUtils.emptyMap());
    }

    @Override
    public Map updateFile(String imgId, MultipartFile multipartFile) throws IOException {

        return cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap(
                "public_id", imgId,
                "overwrite", true
        ));
    }


}
