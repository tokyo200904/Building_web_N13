package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Mapper.ProfileMapper;
import BuldingWeb.example.nhom13.Model.DoiMkDTO;
import BuldingWeb.example.nhom13.Model.ProfileDTO;
import BuldingWeb.example.nhom13.Model.Reponse.ProfileReponse;
import BuldingWeb.example.nhom13.Repository.UserReponsitory;
import BuldingWeb.example.nhom13.Service.ProfileService;
import BuldingWeb.example.nhom13.Utils.TtNdUtil;
import BuldingWeb.example.nhom13.Utils.UploadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private TtNdUtil ttNdUtil;
    @Autowired
    private UploadUtil uploadUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public ProfileReponse getProfile() {
        User user = ttNdUtil.getCurrentAuthenticatedUser();
        return profileMapper.mapUserToProfileDTO(user);    }

    @Transactional
    @Override
    public void updateProfile(ProfileDTO dto) {
        User user = ttNdUtil.getCurrentAuthenticatedUser();

        user.setHoTen(dto.getHoTen());
        user.setSoDienThoai(dto.getSoDienThoai());
        user.setDiaChi(dto.getDiaChi());
        user.setGioiThieu(dto.getGioiThieu());

        try {
            Map<String, String> links = new HashMap<>();

            System.out.println("Update Profile - Facebook: " + dto.getFacebookLink());
            System.out.println("Update Profile - Zalo: " + dto.getZaloLink());

            if (dto.getFacebookLink() != null && !dto.getFacebookLink().trim().isEmpty()) {
                links.put("facebook", dto.getFacebookLink().trim());
            }
            if (dto.getZaloLink() != null && !dto.getZaloLink().trim().isEmpty()) {
                links.put("zalo", dto.getZaloLink().trim());
            }

            String jsonLinks = objectMapper.writeValueAsString(links);

            user.setLienKetMxh(jsonLinks);

        } catch (Exception e) {
            e.printStackTrace();
        }

        userReponsitory.save(user);
    }

    @Transactional
    @Override
    public String updateAvatar(MultipartFile file) throws Exception {
        User user = ttNdUtil.getCurrentAuthenticatedUser();
        String avatarUrl = uploadUtil.saveFile(file);
        user.setAnhDaiDien(avatarUrl);
        userReponsitory.save(user);
        return avatarUrl;
    }

    @Override
    public void changePassword(DoiMkDTO request) {
        User user = ttNdUtil.getCurrentAuthenticatedUser();
        if (!passwordEncoder.matches(request.getMatKhauHienTai(), user.getPassword())) {
            throw new RuntimeException("Mật khẩu hiện tại không đúng.");
        }

        if (!request.getMatKhauMoi().equals(request.getXacNhanMatKhau())) {
            throw new RuntimeException("Mật khẩu xác nhận không khớp.");
        }

        user.setMatKhau(passwordEncoder.encode(request.getMatKhauMoi()));
        userReponsitory.save(user);
    }
}
