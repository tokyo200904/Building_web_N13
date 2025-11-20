package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.MoiGioi;
import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Mapper.MoiGioiMapper;
import BuldingWeb.example.nhom13.Model.MoiGioiDTO;
import BuldingWeb.example.nhom13.Repository.MoiGioiRepository;
import BuldingWeb.example.nhom13.Repository.UserReponsitory;
import BuldingWeb.example.nhom13.Service.MoiGioiService;
import BuldingWeb.example.nhom13.Utils.TtNdUtil;
import BuldingWeb.example.nhom13.Utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoiGioiServiceImpl implements MoiGioiService {
    @Autowired
    private MoiGioiRepository moiGioiRepository;
    @Autowired
    private MoiGioiMapper moiGioiMapper;
    @Autowired
    private UploadUtil uploadUtil;
    @Autowired
    private TtNdUtil ttNdUtil;
    @Autowired
    private UserReponsitory userReponsitory;
    @Override
    public List<MoiGioiDTO> getAllMoiGioi() {
        return moiGioiRepository.findAll().stream()
                .map(moiGioiMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MoiGioiDTO getMoiGioiById(Integer id) {
        MoiGioi moiGioi = moiGioiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môi giới ID: " + id));
        return moiGioiMapper.toDTO(moiGioi);
    }

    @Transactional
    @Override
    public void saveMoiGioi(MoiGioiDTO dto, MultipartFile imageFile) throws Exception {
        User currentUser = ttNdUtil.getCurrentAuthenticatedUser();
        MoiGioi entity;
        if (dto.getMaMoiGioi() != null) {
            entity = moiGioiRepository.findById(dto.getMaMoiGioi())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môi giới để cập nhật"));
        entity.setTenCongTy(dto.getTenCongTy());
        entity.setSoGiayPhep(dto.getSoGiayPhep());
        entity.setSoDienThoai(dto.getSoDienThoai());
        entity.setEmail(dto.getEmail());
        entity.setDiaChi(dto.getDiaChi());
        entity.setGioiThieu(dto.getGioiThieu());
    } else {
            if (currentUser.getVaiTro() != VaiTro.ADMIN) {
                throw new AccessDeniedException("Bạn không có quyền tạo công ty môi giới mới");
            }
            entity = moiGioiMapper.toEntity(dto);
    }
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = uploadUtil.saveFile(imageFile);
            entity.setHinhAnh(imageUrl);
        }
        moiGioiRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteMoiGioi(Integer id) {
        MoiGioi moiGioi = moiGioiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môi giới để xóa"));
        List<User> nhanViens = moiGioi.getUser();
        if (nhanViens != null) {
            for (User nv : nhanViens) {
                nv.setMoiGioi(null);
                userReponsitory.save(nv);
            }
        }
        moiGioiRepository.deleteById(id);
    }

}

