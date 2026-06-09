package com.melodyrent.service;
import com.cloudinary.Cloudinary; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.web.multipart.MultipartFile; import java.io.IOException; import java.util.Map;
@Service @RequiredArgsConstructor
public class CloudinaryService {
  private final Cloudinary cloudinary;
  public Map upload(MultipartFile file, String folder, String resourceType) throws IOException { return cloudinary.uploader().upload(file.getBytes(), Map.of("folder", folder, "resource_type", resourceType)); }
}
