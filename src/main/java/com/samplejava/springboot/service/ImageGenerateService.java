package com.samplejava.springboot.service;

import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.stereotype.Service;

@Service
public class ImageGenerateService {
    private final ImageClient imageClient;

    public ImageGenerateService(ImageClient imageClient) {
        this.imageClient = imageClient;
    }

    public String generate(String instructions) throws Exception {
        try {
            var options = ImageOptionsBuilder.builder()
                    .withHeight(1024).withWidth(1024)
                    .withResponseFormat("url")
                    .withModel("dall-e-3")
                    .build();
            ImagePrompt imagePrompt = new ImagePrompt(instructions, options);
            ImageResponse imageResponse = imageClient.call(imagePrompt);
            return imageResponse.getResult().getOutput().getUrl();
        } catch (Exception e) {
            throw new Exception("Failed to generate image", e);
        }
    }
}