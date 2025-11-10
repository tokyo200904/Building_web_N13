package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Model.YeuCauDTO;
import BuldingWeb.example.nhom13.Service.DangTinService;
import BuldingWeb.example.nhom13.Utils.DangTinUntil;
import BuldingWeb.example.nhom13.Utils.TtNdUtil;
import BuldingWeb.example.nhom13.Utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class DangTinServiceImpl implements DangTinService {
    @Autowired
    private TtNdUtil ttNdUtil;
    @Autowired
    private UploadUtil uploadUtil;
    @Autowired
    private DangTinUntil dangTinUntil;

    public String dangTin(YeuCauDTO dto, MultipartFile anhChinh, List<MultipartFile> anhPhuList) throws Exception {
        User user = ttNdUtil.getCurrentAuthenticatedUser();

        String anh = uploadUtil.saveFile(anhChinh);
        List<String> anhphu = new ArrayList<>();
        if (anhPhuList != null && !anhPhuList.isEmpty()){
            for (MultipartFile file : anhPhuList){
                anhphu.add(uploadUtil.saveFile(file));
            }
        }
        if (user.getVaiTro() == VaiTro.ADMIN || user.getVaiTro() == VaiTro.NHANVIEN){
            dangTinUntil.taoBds(dto, anh,anhphu,user);
            return "Dang tin thanh cong";
        }
        else {
            dangTinUntil.taoYeuCauDt(dto,anh,anhphu,user);
            return "yeu cau da duoc gui dang cho duyet";
        }
    }
}
