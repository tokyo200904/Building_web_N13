package BuldingWeb.example.nhom13.Model.Reponse;

import BuldingWeb.example.nhom13.Enums.VaiTro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDnReponse {
        private String token;
        private String email;
        private String hoTen;
        private VaiTro vaiTro;
        private String anhdaiDien;
}
