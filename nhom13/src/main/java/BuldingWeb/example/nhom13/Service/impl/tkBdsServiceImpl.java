package BuldingWeb.example.nhom13.Service.impl;


import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Filters.BDSSpecification;
import BuldingWeb.example.nhom13.Model.Reponse.tkbdsReponse;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Repository.tkBdsRepository;
import BuldingWeb.example.nhom13.Service.tkBdsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class tkBdsServiceImpl implements tkBdsService {

    @Autowired
    private tkBdsRepository tkBdsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<bdsDTO> searchBds(tkbdsReponse dto) {
        List<BatDongSan> batDongSans = tkBdsRepository.findAll(BDSSpecification.filter(dto));
        return batDongSans.stream()
                .map(entity-> modelMapper.map(entity,bdsDTO.class))
                .collect(Collectors.toList());
    }
}
