package BuldingWeb.example.nhom13.Service;


import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Enums.VaiTro;
import BuldingWeb.example.nhom13.Model.Reponse.UserDnReponse;
import BuldingWeb.example.nhom13.Model.Reponse.UserReponse;
import BuldingWeb.example.nhom13.Model.UserDkDTO;
import BuldingWeb.example.nhom13.Model.UserDnDTO;

import java.util.List;

public interface UserService {
    User createUser(UserDkDTO userDkDTO);
    UserDnReponse loginUser(UserDnDTO userDnDTO) throws Exception;
    UserReponse findUserDTOById(Integer userId);
    void updateUserRole(Integer adminUserId, Integer targetUserId, String newRoleString) throws Exception;
    void banUser(Integer adminUserId, Integer targetUserId) throws Exception;
    void unbanUser(Integer targetUserId) throws Exception;
    List<UserReponse> findUsersByRoleAndSearch(VaiTro role, String search);
}
