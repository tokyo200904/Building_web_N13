package BuldingWeb.example.nhom13.Controllers;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Model.Reponse.UserDnReponse;
import BuldingWeb.example.nhom13.Model.Reponse.UserReponse;
import BuldingWeb.example.nhom13.Model.UserDkDTO;
import BuldingWeb.example.nhom13.Model.UserDnDTO;
import BuldingWeb.example.nhom13.Service.UserService;
import BuldingWeb.example.nhom13.Utils.TtNdUtil;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
public class UserController {
    @Data
    static class RoleUpdateRequest { private String newRole; }
    @Autowired
    private UserService userService;

    @Autowired
    private TtNdUtil ttNdUtil;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/user")
    public ResponseEntity<?> getUser(@RequestParam("role") String roleString,
                                     @RequestParam(value = "search", required = false) String search){
        try {
            VaiTro role = VaiTro.valueOf(roleString.toUpperCase());
            List<UserReponse> users = userService.findUsersByRoleAndSearch(role,search);
            return ResponseEntity.ok(users);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Vai trò không hợp lệ");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        try {
            UserReponse user = userService.findUserDTOById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/admin/user/{id}/role")
    public ResponseEntity<?> updateUserRole(
            @PathVariable("id") Integer targetUserId,
            @RequestBody RoleUpdateRequest request) {
        try {
            User adminUser = ttNdUtil.getCurrentAuthenticatedUser();
            userService.updateUserRole(adminUser.getUserId(), targetUserId, request.getNewRole());
            return ResponseEntity.ok().body("Cập nhật vai trò thành công.");
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/user/{id}/ban")
    public ResponseEntity<?> banUser(@PathVariable Integer id) {
        try {
            User adminUser = ttNdUtil.getCurrentAuthenticatedUser();
            userService.banUser(adminUser.getUserId(), id);
            return ResponseEntity.ok().body("Đã cấm tài khoản.");
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/user/{id}/unban")
    public ResponseEntity<?> unbanUser(@PathVariable Integer id) {
        try {
            userService.unbanUser(id);
            return ResponseEntity.ok().body("Đã bỏ cấm tài khoản.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/dangKy")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDkDTO userDkDTO, BindingResult result){
        try {
            if(result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            userService.createUser(userDkDTO);
            return ResponseEntity.ok("dang ky tk thanh cong");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/dangnhap")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserDnDTO userDnDTO,
                                       BindingResult result){
        try{
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            UserDnReponse userDnReponse = userService.loginUser(userDnDTO);
            return ResponseEntity.ok(userDnReponse);
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("sai email hoac mk");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
