package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Model.Reponse.editbdsReponse;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Model.ctbdsDTO;

import java.util.List;

public interface BdsService {
    List<bdsDTO> getAllBds();
    ctbdsDTO getBdsById(int maBds);
    void deleteBds(int maBds);
    editbdsReponse updateBds(int maBds, editbdsReponse DTO);
    ctbdsDTO createBds(ctbdsDTO ctbdsDTO);
}
