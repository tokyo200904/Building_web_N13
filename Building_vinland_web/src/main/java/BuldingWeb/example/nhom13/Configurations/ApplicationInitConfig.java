package BuldingWeb.example.nhom13.Configurations;


import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Repository.UserReponsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    // tao tai khoan admin neu chua co trong db
    @Bean
    ApplicationRunner applicationRunner(UserReponsitory userRepository) {
        return args -> {
            Optional<User> adminOpt = userRepository.findByVaiTro(VaiTro.ADMIN);
            if (adminOpt.isEmpty()) {
                User admin = new User();
                admin.setHoTen("Dinh Phuc");
                admin.setEmail("phuc@gmail.com");
                admin.setMatKhau(passwordEncoder.encode("123456"));
                admin.setSoDienThoai("0123456789");
                admin.setDiaChi("Rau ma city");
                admin.setVaiTro(VaiTro.ADMIN);
                admin.setNgayTao(LocalDateTime.now());
                admin.setAnhDaiDien("http://localhost:8081/d092483b-a88c-477f-bde0-b56299053e34.jpg");
                admin.setGioiThieu("admin 17cm");
                userRepository.save(admin);
            }
        };
    }
}
