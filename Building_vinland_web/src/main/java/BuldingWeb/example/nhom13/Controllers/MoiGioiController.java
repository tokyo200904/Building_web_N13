package BuldingWeb.example.nhom13.Controllers;

import BuldingWeb.example.nhom13.Model.MoiGioiDTO;
import BuldingWeb.example.nhom13.Service.MoiGioiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/moigioi")
public class MoiGioiController {

    @Autowired
    private MoiGioiService moiGioiService;

    @GetMapping
    public ResponseEntity<List<MoiGioiDTO>> getAll() {
        return ResponseEntity.ok(moiGioiService.getAllMoiGioi());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoiGioiDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(moiGioiService.getMoiGioiById(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveMoiGioi(
            @Valid
            @RequestPart("data") MoiGioiDTO dto,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
        try {
            moiGioiService.saveMoiGioi(dto, imageFile);
            return ResponseEntity.ok("Lưu thông tin môi giới thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteMoiGioi(@PathVariable Integer id) {
        try {
            moiGioiService.deleteMoiGioi(id);
            return ResponseEntity.ok("Xóa môi giới thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/{companyId}/them")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNhanVien(@PathVariable Integer companyId, @RequestBody Map<String, String> request) {
        try {
            String email = request.get("emailNhanVien");
            moiGioiService.addNhanVienMoiGioi(companyId, email);
            return ResponseEntity.ok("Thêm nhân viên thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{companyId}/xoa/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> xoaNhanVien(@PathVariable Integer companyId, @PathVariable Integer userId) {
        try {
            moiGioiService.xoaNhanVienMoiGioi(companyId, userId);
            return ResponseEntity.ok("Xóa nhân viên khỏi công ty thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
