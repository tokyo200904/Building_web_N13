package BuldingWeb.example.nhom13.Utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class UploadUtil {

    // Thư mục upload ngoài project
    private final String uploadDir = "D:/backendvs springboot/Building_web_N13/nhom13/upload/";

    public String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        // Tạo folder nếu chưa tồn tại
        Files.createDirectories(Paths.get(uploadDir));

        // Lấy extension file
        String originalName = file.getOriginalFilename();
        String extension = "";
        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf("."));
        }

        // Tạo file name mới
        String fileName = UUID.randomUUID().toString() + extension;

        // Lưu file
        Path filePath = Paths.get(uploadDir + fileName);
        Files.write(filePath, file.getBytes());

        // Trả về URL để frontend dùng
        return "http://localhost:8081/upload/" + fileName;
    }
}
