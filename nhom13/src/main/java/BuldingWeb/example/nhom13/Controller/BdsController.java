package BuldingWeb.example.nhom13.Controller;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Service.BdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bat-dong-san")
public class BdsController {
    @Autowired
    private BdsService bdsService;

    @GetMapping()
    public ResponseEntity<List<bdsDTO>> getAllBds(){
        List<bdsDTO> bdsDTOS = bdsService.getAllBds();
        return ResponseEntity.ok(bdsDTOS);
    }

}
