package BuldingWeb.example.nhom13.Service;

import BuldingWeb.example.nhom13.Model.DoiMkDTO;
import BuldingWeb.example.nhom13.Model.ProfileDTO;
import BuldingWeb.example.nhom13.Model.Reponse.ProfileReponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    public ProfileReponse getProfile();
    public void updateProfile(ProfileDTO dto);
    public String updateAvatar(MultipartFile file) throws Exception;
    public void changePassword(DoiMkDTO request);
}
