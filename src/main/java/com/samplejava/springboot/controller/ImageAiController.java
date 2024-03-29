package com.samplejava.springboot.controller;

import com.samplejava.springboot.service.ImageGenerateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageAiController {

    private final ImageGenerateService imageGenerateService;

    public ImageAiController(ImageGenerateService imageGenerateService) {
        this.imageGenerateService = imageGenerateService;
    }

    @Operation(summary = "Generate image based on instructions")
    @GetMapping("/generate")
    public ResponseEntity<Map<String, String>> generateImage(@Parameter(description = "Instructions for image generation") @RequestParam String instructions) throws Exception {
        String url = imageGenerateService.generate(instructions);
        return ResponseEntity.ok().body(Map.of("url", url));
    }
}