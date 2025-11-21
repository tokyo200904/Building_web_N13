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

    @Override
    public void addNhanVienMoiGioi(Integer moiGioiId, String email) {
        MoiGioi company = moiGioiRepository.findById(moiGioiId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môi giới với ID: " + moiGioiId));

        User nhanVien = userReponsitory.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với email: " + email));
        if (nhanVien.getMoiGioi() != null) {
            throw new RuntimeException("Người dùng này đã thuộc về một công ty khác: " + nhanVien.getMoiGioi().getTenCongTy());
        }
        nhanVien.setMoiGioi(company);
        if (nhanVien.getVaiTro() == VaiTro.CUSTOMER) {
            nhanVien.setVaiTro(VaiTro.AGENT);
        }
        userReponsitory.save(nhanVien);
    }


    @Override
    public void xoaNhanVienMoiGioi(Integer moiGioiId, Integer idNhanVien) throws Exception {
        User nhanVien = userReponsitory.findById(idNhanVien)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại."));
        if (nhanVien.getMoiGioi() == null || !nhanVien.getMoiGioi().getMaMoiGioi().equals(moiGioiId)) {
            throw new RuntimeException("Nhân viên này không thuộc công này");
        }
        nhanVien.setMoiGioi(null);
        userReponsitory.save(nhanVien);
    }

}

