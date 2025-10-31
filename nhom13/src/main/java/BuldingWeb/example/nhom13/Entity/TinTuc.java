package BuldingWeb.example.nhom13.Entity;

import BuldingWeb.example.nhom13.Enums.TrangThaiTinTuc;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tin_tuc")
public class TinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tin")
    private Integer maTin;

    @Column(name = "ma_cm")
    private Integer maCm; // Bạn chưa có bảng Chuyên Mục, nên tạm để là Integer

    @Column(name = "tieu_de", nullable = false)
    private String tieuDe;

    @Column(name = "duong_dan", unique = true, nullable = false)
    private String duongDan; // Slug

    @Column(name = "noi_dung", columnDefinition = "LONGTEXT")
    private String noiDung;

    @Column(name = "anh_dai_dien", length = 500)
    private String anhDaiDien;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", columnDefinition = "ENUM('nhap', 'xuat_ban', 'luu_tru') DEFAULT 'nhap'")
    private TrangThaiTinTuc trangThai;

    @Column(name = "ngay_xuat_ban")
    private LocalDateTime ngayXuatBan;

    @Column(name = "luot_xem", columnDefinition = "INT DEFAULT 0")
    private Integer luotXem;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @UpdateTimestamp
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}