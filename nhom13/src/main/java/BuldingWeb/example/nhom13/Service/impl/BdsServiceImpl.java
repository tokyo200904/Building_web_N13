package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.BatDongSan;
import BuldingWeb.example.nhom13.Entity.HinhAnh;
import BuldingWeb.example.nhom13.Model.HinhAnhDTO;
import BuldingWeb.example.nhom13.Model.Reponse.editbds;
import BuldingWeb.example.nhom13.Model.bdsDTO;
import BuldingWeb.example.nhom13.Model.ctbdsDTO;
import BuldingWeb.example.nhom13.Repository.BdsRepository;
import BuldingWeb.example.nhom13.Service.BdsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ctbdsDTO getBdsById(int maBds) {
        Optional<BatDongSan> batDongSanOptional = bdsRepository.findBymaBds(maBds);
        if (batDongSanOptional.isEmpty()) {
            return null;
        }
        BatDongSan b = batDongSanOptional.get();
        ctbdsDTO ctbdsDTOs = modelMapper.map(b, ctbdsDTO.class);
        ctbdsDTOs.setViTri(b.getQuanHuyen() + ", " + b.getThanhPho());
        if (b.getUser() != null){
            ctbdsDTOs.setAnhDaiDien(b.getUser().getAnhDaiDien());
            ctbdsDTOs.setHoTen(b.getUser().getHoTen());
            ctbdsDTOs.setVaiTro(b.getUser().getVaiTro());
            ctbdsDTOs.setSoDienThoai(b.getUser().getSoDienThoai());
        }
        ctbdsDTOs.setDuongDan(
                b.getHinhAnhList()
                        .stream()
                        .map(HinhAnh::getDuongDan)
                        .toList()
        );
        return ctbdsDTOs;
    }

    @Override
    public void deleteBds(int maBds) {
        bdsRepository.deleteById(maBds);
    }

    @Transactional
    @Override
    public editbds updateBds(int maBds, editbds DTO) {
        BatDongSan batDongSan = bdsRepository.findBdsBymaBds(maBds);
        if (batDongSan == null) {
            throw new RuntimeException("khoong tim thay bds");}

        modelMapper.typeMap(editbds.class, BatDongSan.class)
                .addMappings(mapper -> mapper.skip(BatDongSan::setMaBds));
        modelMapper.map(DTO, batDongSan);

        List<HinhAnh> hinhAnhs = batDongSan.getHinhAnhList();
        List<String> newDuongDans = DTO.getDuongDan();

        hinhAnhs.removeIf(img -> !newDuongDans.contains(img.getDuongDan()));

        for(String path : newDuongDans) {
            boolean exists = hinhAnhs.stream()
                    .anyMatch(img -> img.getDuongDan().equals(path));
            if (!exists) {
                HinhAnh newHinhAnh = new HinhAnh();
                newHinhAnh.setDuongDan(path);
                newHinhAnh.setBatDongSan(batDongSan);
                hinhAnhs.add(newHinhAnh);
            }
        }
        batDongSan.setHinhAnhList(hinhAnhs);
        BatDongSan savedBds = bdsRepository.save(batDongSan);

        editbds resultDTO = modelMapper.map(savedBds, editbds.class);
        resultDTO.setDuongDan(
                savedBds.getHinhAnhList()
                        .stream()
                        .map(HinhAnh::getDuongDan)
                        .toList()
        );
        return resultDTO;
    }

    @Override
    public ctbdsDTO createBds(ctbdsDTO ctbdsDTO) {
        return null;
    }
}
