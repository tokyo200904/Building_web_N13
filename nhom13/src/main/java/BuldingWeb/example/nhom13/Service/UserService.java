package BuldingWeb.example.nhom13.Service;


import BuldingWeb.example.nhom13.Entity.User;
import BuldingWeb.example.nhom13.Model.Reponse.UserDnReponse;
import BuldingWeb.example.nhom13.Model.UserDkDTO;
import BuldingWeb.example.nhom13.Model.UserDnDTO;

public interface UserService {
    User createUser(UserDkDTO userDkDTO);
    UserDnReponse loginUser(UserDnDTO userDnDTO) throws Exception;
}
