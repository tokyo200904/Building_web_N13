package BuldingWeb.example.nhom13.Controllers;


import BuldingWeb.example.nhom13.Model.Reponse.tkbdsReponse;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Service.tkBdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Sửa thành ResponseEntity
import org.springframework.web.bind.annotation.GetMapping; // Sửa thành @GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
public class searchController {

    @Autowired
    private tkBdsService tkBdsService;

    @GetMapping("/search")
    public ResponseEntity<List<bdsDTO>> searchBds(tkbdsReponse tkbdsReponse){

        return ResponseEntity.ok(tkBdsService.searchBds(tkbdsReponse));
    }
}