package BuldingWeb.example.nhom13.Controllers;

import BuldingWeb.example.nhom13.Model.Reponse.YeuCauDtReponse;
import BuldingWeb.example.nhom13.Model.Reponse.chitietYcDtReponse;
import BuldingWeb.example.nhom13.Service.YeuCauDtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/admin/duyettin")
@PreAuthorize("hasRole('ADMIN','NHANVIEN')")
public class DuyetTinController {
    @Autowired
    private YeuCauDtService yeuCauDtService;

    @GetMapping("/all")
    public ResponseEntity<List<YeuCauDtReponse>> getAllYeuCauDt() {
        List<YeuCauDtReponse> response = yeuCauDtService.getAllYeuCauDt();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<chitietYcDtReponse> getYeuCauDtById(@PathVariable Integer id) {
        try {
            chitietYcDtReponse response = yeuCauDtService.getYeuCauDtById(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> DuyetYeuCauDt(@PathVariable Integer id) {
        try {
            yeuCauDtService.DuyetYeuCauDt(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/tuchoi/{id}")
    public ResponseEntity<?> TuChoiYeuCauDt(@PathVariable Integer id, @RequestBody String lyDoTuChoi) {
        try {
            yeuCauDtService.TuChoiYeuCauDt(id, lyDoTuChoi);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}