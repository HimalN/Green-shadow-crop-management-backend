package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.DataPersistException;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dao.UserDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.UserStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.UserDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.User;
import lk.ijse.Green_shadow_crop_management_backend.exception.UserNotFoundException;
import lk.ijse.Green_shadow_crop_management_backend.service.UserService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        User savedUser = userDAO.save(mapping.toUserEntity(userDTO));
        if (savedUser == null) {
            throw new DataPersistException("User not saved");
        }
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userDAO.findAll();
        return mapping.asUserDTOList(allUsers);
    }

    @Override
    public UserStatus getUser(String userId) {
        if(userDAO.existsById(userId)){
            User selectedUser = userDAO.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        }else {
            return new SelectedUserErrorStatus(2, "User with id " + userId + " not found");
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> existedUser = userDAO.findById(userId);
        if(!existedUser.isPresent()){
            throw new UserNotFoundException("User with id " + userId + " not found");
        }else {
            userDAO.deleteById(userId);
        }
    }



    @Override
    public void updateUser(UserDTO buildUserDTO) {

    }

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDAO.findByEmail(userName)
                        .orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }
}
