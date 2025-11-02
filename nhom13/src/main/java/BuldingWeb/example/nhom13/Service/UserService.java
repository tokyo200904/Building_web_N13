package BuldingWeb.example.nhom13.Service;


import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Model.UserDkDTO;

public interface UserService {
    User createUser(UserDkDTO userDkDTO);
    String loginUser(String email, String password) throws Exception;
}
