package BuldingWeb.example.nhom13.Controllers;

import BuldingWeb.example.nhom13.Model.DoiMkDTO;
import BuldingWeb.example.nhom13.Model.ProfileDTO;
import BuldingWeb.example.nhom13.Model.Reponse.ProfileReponse;
import BuldingWeb.example.nhom13.Service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("${api.prefix}/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<ProfileReponse> getMyProfile() {
        return ResponseEntity.ok(profileService.getProfile());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestBody ProfileDTO request) {
        try {
            profileService.updateProfile(request);
            return ResponseEntity.ok("Cập nhật hồ sơ thành công.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/avatar")
    public ResponseEntity<?> updateAvatar(@RequestParam("file") MultipartFile file) {
        try {
            String newUrl = profileService.updateAvatar(file);
            return ResponseEntity.ok(newUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody DoiMkDTO request) {
        try {
            profileService.changePassword(request);
            return ResponseEntity.ok("Đổi mật khẩu thành công.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
