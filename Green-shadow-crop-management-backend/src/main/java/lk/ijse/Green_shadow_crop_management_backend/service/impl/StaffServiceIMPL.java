package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.dto.StaffStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.StaffDTO;
import lk.ijse.Green_shadow_crop_management_backend.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
public class StaffServiceIMPL implements StaffService {
    @Override
    public void saveStaff(StaffDTO staffDTO) {

    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return List.of();
    }

    @Override
    public StaffStatus getStaff(String staffId) {
        return null;
    }

    @Override
    public void deleteStaff(String staffId) {

    }

    @Override
    public void updateStaff(String staffId, StaffDTO staffDTO) {

    }
}
