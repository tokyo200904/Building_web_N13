package BuldingWeb.example.nhom13.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "moi_gioi")
public class MoiGioi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_moi_gioi")
    private Integer maMoiGioi;

    @Column(name = "ten_cong_ty")
    private String tenCongTy;

    @Column(name = "so_giay_phep")
    private String soGiayPhep;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "gioi_thieu", columnDefinition = "TEXT")
    private String gioiThieu;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @CreationTimestamp
    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @UpdateTimestamp
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;


    @JsonIgnore
    @OneToMany(mappedBy = "moiGioi", fetch = FetchType.LAZY)
    private List<User> user;
}