package lk.ijse.Green_shadow_crop_management_backend.service;


import lk.ijse.Green_shadow_crop_management_backend.dto.impl.UserDTO;
import lk.ijse.Green_shadow_crop_management_backend.secure.JWTAuthResponse;
import lk.ijse.Green_shadow_crop_management_backend.secure.SignIn;

public interface AuthService {
   JWTAuthResponse signIn(SignIn signIn);
   JWTAuthResponse signUp(UserDTO userDTO);
   JWTAuthResponse refreshToken(String accessToken);
}
