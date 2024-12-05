package lk.ijse.Green_shadow_crop_management_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Green_shadow_crop_management_backend.customStatusCodes.SelectedStaffErrorStatus;
import lk.ijse.Green_shadow_crop_management_backend.dao.StaffDAO;
import lk.ijse.Green_shadow_crop_management_backend.dto.StaffStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.StaffDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Staff;
import lk.ijse.Green_shadow_crop_management_backend.service.StaffService;
import lk.ijse.Green_shadow_crop_management_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private Mapping staffMapping;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        Staff saveField = staffDAO.save(staffMapping.toStaffEntity(staffDTO));
        if(saveField == null){
            throw new RuntimeException("Staff not saved");
        }
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return staffMapping.asStaffDTOList(staffDAO.findAll());
    }

    @Override
    public StaffStatus getStaff(String staffId) {
        if(staffDAO.existsById(staffId)){
            var selectedStaff = staffDAO.getReferenceById(staffId);
            return staffMapping.toStaffDTO(selectedStaff);
        }else {
            return new SelectedStaffErrorStatus(404,"Selected staff not found");
        }
    }

    @Override
    public void deleteStaff(String staffId) {

    }

    @Override
    public void updateStaff(String staffId, StaffDTO staffDTO) {

    }
}
