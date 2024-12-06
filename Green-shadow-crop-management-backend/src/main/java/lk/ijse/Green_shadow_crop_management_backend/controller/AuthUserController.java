package lk.ijse.Green_shadow_crop_management_backend.controller;


import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.UserDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.Role;
import lk.ijse.Green_shadow_crop_management_backend.secure.JWTAuthResponse;
import lk.ijse.Green_shadow_crop_management_backend.secure.SignIn;
import lk.ijse.Green_shadow_crop_management_backend.service.AuthService;
import lk.ijse.Green_shadow_crop_management_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/auth/")
@RestController
@RequiredArgsConstructor
public class AuthUserController {

    private final UserService userService;

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping(value = "signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> saveUser(
            @RequestPart("role") String role,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password
    ) {
        try {
            var buildUserDTO = new UserDTO();
            buildUserDTO.setRole(Role.valueOf(role));
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(passwordEncoder.encode(password));
            return ResponseEntity.ok(authService.signUp(buildUserDTO));
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn){
        return ResponseEntity.ok(authService.signIn(signIn));
    }
    @PostMapping("refresh")
    public ResponseEntity<JWTAuthResponse> refreshToken(@RequestParam ("existingToken") String existingToken) {
        return ResponseEntity.ok(authService.refreshToken(existingToken));
    }
}
