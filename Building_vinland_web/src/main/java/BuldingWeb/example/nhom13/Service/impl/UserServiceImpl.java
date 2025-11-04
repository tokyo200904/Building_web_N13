package BuldingWeb.example.nhom13.Service.impl;

import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Model.Reponse.UserDnReponse;
import BuldingWeb.example.nhom13.Model.UserDkDTO;
import BuldingWeb.example.nhom13.Model.UserDnDTO;
import BuldingWeb.example.nhom13.Repository.UserReponsitory;
import BuldingWeb.example.nhom13.Service.UserService;
import BuldingWeb.example.nhom13.components.jwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private jwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

        @Override
        public User createUser(UserDkDTO userDkDTO) {
            String email = userDkDTO.getEmail();
            if (userReponsitory.existsByEmail(email)) {
                throw new RuntimeException("Email da ton tai");
            }
            User newUser = User.builder()
                    .hoTen(userDkDTO.getHoTen())
                    .email(userDkDTO.getEmail())
                    .vaiTro(VaiTro.CUSTOMER)
                    .matKhau(passwordEncoder.encode(userDkDTO.getMatKhau()))
                    .build();
            return userReponsitory.save(newUser);
        }
        @Override
        public UserDnReponse loginUser(UserDnDTO userDnDTO) throws Exception {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDnDTO.getEmail(),
                            userDnDTO.getMatKhau()
                    )
            );
            User userEntity = (User) authentication.getPrincipal();

            String token = jwtTokenUtil.generateToken(userEntity);

            return UserDnReponse.builder()
                    .token(token)
                    .hoTen(userEntity.getHoTen())
                    .email(userEntity.getEmail())
                    .vaiTro(userEntity.getVaiTro())
                    .build();
        }
    }