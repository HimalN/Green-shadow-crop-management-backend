package lk.ijse.Green_shadow_crop_management_backend.controller;

import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.UserStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.UserDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.Role;
import lk.ijse.Green_shadow_crop_management_backend.exception.UserNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.secure.JWTAuthResponse;
import lk.ijse.Green_shadow_crop_management_backend.service.AuthService;
import lk.ijse.Green_shadow_crop_management_backend.service.UserService;
import lk.ijse.Green_shadow_crop_management_backend.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
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
    @GetMapping(value = "/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedUser(@PathVariable("userEmail") String userEmail){
        if(!RegexProcess.userEmailMatcher(userEmail)){
            return new SelectedUserErrorStatus(1,"User ID is not valid");
        }
        return userService.getUser(userEmail);
    }
    @DeleteMapping(value = "/{userEmail}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userEmail") String userEmail){
        try {
            if(!RegexProcess.userEmailMatcher(userEmail)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            userService.deleteUser(userEmail);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
