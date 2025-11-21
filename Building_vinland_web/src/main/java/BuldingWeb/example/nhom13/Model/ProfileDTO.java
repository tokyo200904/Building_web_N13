package BuldingWeb.example.nhom13.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO {
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String gioiThieu;

    private String facebookLink;
    private String zaloLink;
}
