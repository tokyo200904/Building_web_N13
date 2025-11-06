package BuldingWeb.example.nhom13.Controllers;

import BuldingWeb.example.nhom13.Model.Reponse.UserDnReponse;
import BuldingWeb.example.nhom13.Model.UserDkDTO;
import BuldingWeb.example.nhom13.Model.UserDnDTO;
import BuldingWeb.example.nhom13.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
public class UserController {
    @Autowired
    private UserService userService;

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
