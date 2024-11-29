package lk.ijse.Green_shadow_crop_management_backend.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateNoteId(){
        return "FIELD-"+UUID.randomUUID();
    }
    public static String picToBase64(byte [] pic){
       return Base64.getEncoder().encodeToString(pic);
    }
}
