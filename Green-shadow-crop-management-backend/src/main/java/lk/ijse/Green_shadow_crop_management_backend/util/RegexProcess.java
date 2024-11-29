package lk.ijse.Green_shadow_crop_management_backend.util;
import java.util.regex.Pattern;

public class RegexProcess {

    private static final String FIELD_CODE_PATTERN = "^F\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String FIELD_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String LOCATION_PATTERN = "^[A-Za-z0-9 ,.-]{5,100}$"; // Example: Letters, digits, and symbols, 5-100 characters
    private static final String EXTENT_PATTERN = "^[0-9]{1,5}(\\.[0-9]{1,2})?$"; // Example: Numeric, max 5 digits with optional decimal

    private static final String CROP_CODE_PATTERN = "^C\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    public static boolean fieldCodeMatcher(String fieldCode) {
        Pattern regexPattern = Pattern.compile(FIELD_CODE_PATTERN);
        return regexPattern.matcher(fieldCode).matches();
    }

    public static boolean fieldNameMatcher(String fieldName) {
        Pattern regexPattern = Pattern.compile(FIELD_NAME_PATTERN);
        return regexPattern.matcher(fieldName).matches();
    }

    public static boolean fieldLocationMatcher(String fieldLocation) {
        Pattern regexPattern = Pattern.compile(LOCATION_PATTERN);
        return regexPattern.matcher(fieldLocation).matches();
    }

    public static boolean fieldExtentMatcher(String fieldExtent) {
        Pattern regexPattern = Pattern.compile(EXTENT_PATTERN);
        return regexPattern.matcher(fieldExtent).matches();
    }

    public static boolean cropIdMatcher(String cropId) {
        Pattern regexPattern = Pattern.compile(CROP_CODE_PATTERN);
        return regexPattern.matcher(cropId).matches();
    }

    public static boolean staffIdMatcher(String staffId) {
        String regexForStaffID = "^S\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForStaffID);
        return regexPattern.matcher(staffId).matches();
    }

    public static boolean vehicleIdMatcher(String vehicleId) {
        String regexForVehicleID = "^V\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForVehicleID);
        return regexPattern.matcher(vehicleId).matches();
    }
    public static boolean equipmentIdMatcher(String equipmentId) {
        String regexForEquipmentID = "^E\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForEquipmentID);
        return regexPattern.matcher(equipmentId).matches();
    }
}
