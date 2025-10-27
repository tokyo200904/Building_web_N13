package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Repository.BdsRepository;
import BuldingWeb.example.nhom13.Service.BdsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BdsServiceImpl implements BdsService {

    @Autowired
    private BdsRepository bdsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<bdsDTO> getAllBds() {
        List<BatDongSan> batDongSans = bdsRepository.findAll();
        return batDongSans.stream()
                .map(BatDongSan -> modelMapper.map(BatDongSan, bdsDTO.class))
                .toList();
    }
}
