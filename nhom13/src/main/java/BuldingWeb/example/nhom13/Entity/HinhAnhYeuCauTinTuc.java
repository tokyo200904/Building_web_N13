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
@Table(name = "hinh_anh_yc_tt")
public class HinhAnhYeuCauTinTuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_yc_tt")
    private Integer maHinhYcTt;

    @Column(name = "duong_dan", nullable = false, length = 1024)
    private String duongDan;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_yeu_cau_tt", nullable = false)
    private YeuCauDangTinTuc yeuCauDangTinTuc;
}