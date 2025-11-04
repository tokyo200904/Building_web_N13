package BuldingWeb.example.nhom13.Entity;


import BuldingWeb.example.nhom13.Enums.HinhThucTT;
import BuldingWeb.example.nhom13.Enums.LoaiGiaoDich;
import BuldingWeb.example.nhom13.Enums.TrangThaiGiaoDich;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "giao_dich")
public class GiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_gd")
    private Integer maGd;

    @Column(name = "ngay_giao_dich")
    private LocalDateTime ngayGiaoDich;

    @Enumerated(EnumType.STRING)
    @Column(name = "loai_giao_dich")
    private LoaiGiaoDich loaiGiaoDich;

    private BigDecimal gia;

    @Enumerated(EnumType.STRING)
    @Column(name = "hinh_thuc_tt")
    private HinhThucTT hinhThucTt;

    @Enumerated(EnumType.STRING)
    private TrangThaiGiaoDich trangThai;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @UpdateTimestamp
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;

    // --- Relationships ---

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_bds")
    private BatDongSan batDongSan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nguoi_mua")
    private User nguoiMua;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nguoi_ban")
    private User nguoiBan;
}