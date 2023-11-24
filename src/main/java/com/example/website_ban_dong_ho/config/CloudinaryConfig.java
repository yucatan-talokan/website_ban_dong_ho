package com.example.website_ban_dong_ho.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwhyfa80s",
                "api_key", "668643833117639",
                "api_secret", "W1EsHlyKdr2266oY5OgkAlUtu-o",
                "secure",true));
    }

}
