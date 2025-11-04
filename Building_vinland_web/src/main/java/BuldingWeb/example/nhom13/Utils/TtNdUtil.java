package BuldingWeb.example.nhom13.Utils;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class TtNdUtil {
    @Autowired
    UserReponsitory userReponsitory;
    public User  getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return userReponsitory.findByEmail(currentPrincipalName)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin người dùng đang đăng nhập"));
    }
}
