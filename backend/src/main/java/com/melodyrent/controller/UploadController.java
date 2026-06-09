package com.melodyrent.controller;
import com.melodyrent.service.CloudinaryService; import lombok.RequiredArgsConstructor; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile; import java.io.IOException; import java.util.Map;
@RestController @RequestMapping("/uploads") @RequiredArgsConstructor
public class UploadController { private final CloudinaryService cloudinary; @PostMapping @PreAuthorize("hasAnyRole('OWNER','ADMIN')") Map upload(@RequestParam MultipartFile file, @RequestParam(defaultValue="melodyrent") String folder, @RequestParam(defaultValue="auto") String resourceType) throws IOException { return cloudinary.upload(file, folder, resourceType); } }
