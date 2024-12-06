package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import lk.ijse.Green_shadow_crop_management_backend.dao.UserDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.UserDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.User;
import lk.ijse.Green_shadow_crop_management_backend.secure.JWTAuthResponse;
import lk.ijse.Green_shadow_crop_management_backend.secure.SignIn;
import lk.ijse.Green_shadow_crop_management_backend.service.AuthService;
import lk.ijse.Green_shadow_crop_management_backend.service.JWTService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDAO userDao;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var user =   userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO signUp) {
        signUp.setPassword(signUp.getPassword());
        User user = mapping.toUserEntity(signUp);
        if (userDao.existsById(signUp.getEmail())) throw new UsernameNotFoundException("user Alrady Exsist");
        userDao.save(user);
        var jwtToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();

    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        //extract user name
        var userName = jwtService.extractUserName(accessToken);
        //check the user availability in the DB
        var findUser = userDao.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(findUser);
        return JWTAuthResponse.builder().token(refreshToken).build();
    }
}
