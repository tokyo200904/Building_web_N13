package BuldingWeb.example.nhom13.Entity;

import BuldingWeb.example.nhom13.Enums.VaiTro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table(name = "user")
    public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Integer userId;

        @Column(unique = true, nullable = false)
        private String email;

        @JsonIgnore // Không bao giờ trả mật khẩu ra API
        @Column(name = "mat_khau", nullable = false)
        private String matKhau;

        @Enumerated(EnumType.STRING)
        @Column(name = "vai_tro", nullable = false)
        private VaiTro vaiTro;

        @Column(name = "ho_ten")
        private String hoTen;

        @Column(name = "so_dien_thoai")
        private String soDienThoai;

        @Column(name = "dia_chi", columnDefinition = "TEXT")
        private String diaChi;

        @Column(name = "anh_dai_dien")
        private String anhDaiDien;

        @Column(name = "gioi_thieu", columnDefinition = "TEXT")
        private String gioiThieu;

        @Column(name = "lien_ket_mxh", columnDefinition = "JSON")
        private String lienKetMxh; // Lưu dưới dạng String JSON

        @CreationTimestamp
        @Column(name = "ngay_tao", updatable = false)
        private LocalDateTime ngayTao;

        @UpdateTimestamp
        @Column(name = "ngay_cap_nhat")
        private LocalDateTime ngayCapNhat;



        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<BatDongSan> batDongSanList;

        @JsonIgnore
        @OneToOne(mappedBy = "user")
        private MoiGioi moiGioi;

        @JsonIgnore
        @OneToMany(mappedBy = "nguoiMua")
        private List<GiaoDich> danhSachMua;

        @JsonIgnore
        @OneToMany(mappedBy = "nguoiBan")
        private List<GiaoDich> danhSachBan;

        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private Set<YeuThich> yeuThichList;

        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<ThongBao> thongBaoList;

        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<TinTuc> tinTucList;

        //moi
        @JsonIgnore
        @OneToMany(mappedBy = "userGuiYeuCau")
        private List<YeuCauDangTin> yeuCauBdsGuiList;

        @JsonIgnore
        @OneToMany(mappedBy = "userDuyet")
        private List<YeuCauDangTin> yeuCauBdsDuyetList;

        @JsonIgnore
        @OneToMany(mappedBy = "userGuiYeuCau")
        private List<YeuCauDangTinTuc> yeuCauTinTucGuiList;

        @JsonIgnore
        @OneToMany(mappedBy = "userDuyet")
        private List<YeuCauDangTinTuc> yeuCauTinTucDuyetList;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + getVaiTro().toString().toUpperCase()));
            return authorities;
        }

        @Override
        public String getPassword() {
            return "";
        }

        @Override
        public String getUsername() {
            return "";
        }

        @Override
        public boolean isAccountNonExpired() {
            return UserDetails.super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return UserDetails.super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return UserDetails.super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
            return UserDetails.super.isEnabled();
        }
    }

