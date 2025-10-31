package BuldingWeb.example.nhom13.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hinh_anh_ycbds") // Đổi tên bảng cho rõ ràng
public class HinhAnhYeuCau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_ycbds") // Đổi tên cột ID
    private Integer maHinhYcBds;

    @Column(name = "duong_dan", nullable = false, length = 1024)
    private String duongDan;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_yeu_ycbds", nullable = false)
    private YeuCauDangTin yeuCauDangTin;
}