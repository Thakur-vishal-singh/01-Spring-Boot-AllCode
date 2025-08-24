package tech.vishal.skyview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tech.vishal.skyview.dto.SkyImageRequestDto;
import tech.vishal.skyview.service.SkyImageService;

@Controller
public class SkyImageController {

    @Autowired
    private SkyImageService skyImageService;

    @GetMapping("/")   
    public String showForm(Model model) {
        model.addAttribute("skyImageRequest", new SkyImageRequestDto());
        return "index";
    }

    @PostMapping("/get-image")
    public String getSkyImage(@ModelAttribute("skyImageRequest") SkyImageRequestDto requestDTO, Model model) {
        model.addAttribute("location", requestDTO.getLocation());
        return "result";
    }

    @GetMapping(value = "/sky-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getSkyImage(@RequestParam String location) {
        byte[] image = skyImageService.fetchSkyImage(location);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
    
 
    
}
