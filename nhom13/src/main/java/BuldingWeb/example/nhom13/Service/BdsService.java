package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Model.Reponse.editbds;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Model.ctbdsDTO;

import java.util.List;

public interface BdsService {
    List<bdsDTO> getAllBds();
    ctbdsDTO getBdsById(int maBds);
    void deleteBds(int maBds);
    editbds updateBds(int maBds, editbds DTO);
    ctbdsDTO createBds(ctbdsDTO ctbdsDTO);
}
