package BuldingWeb.example.nhom13.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:D:/backendvs springboot/Building_web_N13/nhom13/upload/");
        // Nếu thư mục upload nằm ngay cạnh thư mục gốc project
        // Hoặc dùng đường dẫn tuyệt đối nếu cần
        // .addResourceLocations("file:/C:/path/to/your/upload/");
    }
}
