package lk.ijse.Green_shadow_crop_management_backend.service;

import lk.ijse.Green_shadow_crop_management_backend.dto.LogStatus;
import lk.ijse.Green_shadow_crop_management_backend.dto.impl.LogDTO;

import java.util.List;

public interface LogService {
    void saveLog(LogDTO logDTO);
    List<LogDTO> getAllLogs();
    LogStatus getLog(String logId);
    void deleteLog(String logId);
    void updateLog(String logId, LogDTO logDTO);
}
