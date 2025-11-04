package BuldingWeb.example.nhom13.Service;


import BuldingWeb.example.nhom13.Model.Reponse.tkbdsReponse;
import BuldingWeb.example.nhom13.Model.bdsDTO;

import java.util.List;

public interface tkBdsService {
    List<bdsDTO>  searchBds(tkbdsReponse dto);

}
