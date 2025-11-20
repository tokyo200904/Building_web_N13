package BuldingWeb.example.nhom13.Model;

import BuldingWeb.example.nhom13.Enums.TrangThaiTinTuc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TinTucDetailDTO {
    private Integer maTin;
    private String tieuDe;
    private String noiDung;
    private String anhDaiDien;
    private String tenNguoiDang;
    private LocalDateTime ngayTao;
    private LocalDateTime ngayXuatBan;
    private TrangThaiTinTuc trangThai;
    private Integer luotXem;

}
