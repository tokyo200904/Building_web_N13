package BuldingWeb.example.nhom13.Controller;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Model.Reponse.editbds;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Model.ctbdsDTO;
import BuldingWeb.example.nhom13.Service.BdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bds")
public class BdsController {
    @Autowired
    private BdsService bdsService;

    @GetMapping()
    public ResponseEntity<List<bdsDTO>> getAllBds() {
        List<bdsDTO> bdsDTOS = bdsService.getAllBds();
        return ResponseEntity.ok(bdsDTOS);
    }

    @GetMapping("/chitiet/{id}")
    public ResponseEntity<?> getBdsById(@PathVariable("id") Integer id) {
        ctbdsDTO dto = bdsService.getBdsById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBds(@PathVariable Integer id) {
        bdsService.deleteBds(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<editbds> updateBds(@PathVariable("id") Integer id, @ModelAttribute editbds DTO){
        editbds updatedBds = bdsService.updateBds(id, DTO);
        return ResponseEntity.ok(updatedBds);
    }
}