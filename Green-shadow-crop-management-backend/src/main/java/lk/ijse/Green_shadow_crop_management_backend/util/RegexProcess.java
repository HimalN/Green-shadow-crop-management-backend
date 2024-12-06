package lk.ijse.Green_shadow_crop_management_backend.util;
import java.util.regex.Pattern;

public class RegexProcess {
    private static final String FIELD_CODE_PATTERN = "^F\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String FIELD_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String LOCATION_PATTERN = "^[A-Za-z0-9 ,.-]{5,100}$"; // Example: Letters, digits, and symbols, 5-100 characters
    private static final String EXTENT_PATTERN = "^[0-9]{1,5}(\\.[0-9]{1,2})?$"; // Example: Numeric, max 5 digits with optional decimal

    private static final String CROP_CODE_PATTERN = "^C\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String CROP_COMMON_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String CROP_SCIENTIFIC_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String CROP_CATEGORY_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String CROP_SEASON_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String CROP_FIELD_CODE_PATTERN = "^F\\d{3}$";   // Example: Letters and spaces, 3-50 characters

    private static final String STAFF_ID_PATTERN = "^S\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String STAFF_FIRST_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_LAST_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_DESIGNATION_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_GENDER_PATTERN = "\\b[A-Z0-9]{2,}\\b";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_JOINED_DATE_PATTERN = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_DOB_PATTERN = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d";   // Example: 12/12/2000
    private static final String STAFF_ADDRESS_1_NO_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_ADDRESS_2_STREET_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_ADDRESS_3_CITY_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_ADDRESS_4_STATE_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_ADDRESS_5_POSTAL_PATTERN = "^\\d{0,6}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_CONTACT_NO_PATTERN = "^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_ROLE_PATTERN = "\\b[A-Z0-9]{2,}\\b";   // Example: Letters and spaces, 3-50 characters
    private static final String STAFF_FIELD_CODE_PATTERN = "^F\\d{3}$";   // Example: Letters and spaces, 3-50 characters

    private static final String VEHICLE_ID_PATTERN = "^V\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String VEHICLE_CATEGORY_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String VEHICLE_FUEL_TYPE_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String VEHICLE_LICENSE_PLATE_PATTERN = "^([a-zA-Z]{1,3}|([0-9]{1,3}))-[0-9]{4}";   // Example: Letters and spaces, 3-50 characters
    private static final String VEHICLE_STATUS_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String VEHICLE_REMARKS_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String VEHICLE_STAFF_PATTERN = "^S\\d{3}$";   // Example: Letters and spaces, 3-50 characters

    private static final String EQUIPMENT_ID_PATTERN = "^E\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String EQUIPMENT_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String EQUIPMENT_STATUS_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String EQUIPMENT_TYPE_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String EQUIPMENT_STAFF_PATTERN = "^S\\d{3}$";   // Example: Letters and spaces, 3-50 characters
    private static final String EQUIPMENT_FIELD_CODE_PATTERN = "^F\\d{3}$";   // Example: Letters and spaces, 3-50 characters

    private static final String LOG_ID_PATTERN = "^L\\d{3}$"; // Example: Alphanumeric, 3-10 characters
    private static final String LOG_DATE_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String LOG_STAFF_PATTERN = "^S\\d{3}$";   // Example: Letters and spaces, 3-50 characters
    private static final String LOG_FIELD_CODE_PATTERN = "^F\\d{3}$";   // Example: Letters and spaces, 3-50 characters
    private static final String LOG_CROP_CODE_PATTERN = "^C\\d{3}$";   // Example: Letters and spaces, 3-50 characters
    private static final String LOG_DETAILS_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters

    private static final String USER_NAME_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters
    private static final String USER_EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";   // Example: Letters and spaces, 3-50 characters
    private static final String USER_PASSWORD_PATTERN = "^[A-Za-z ]{3,50}$";   // Example: Letters and spaces, 3-50 characters

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

    public static boolean cropNameMatcher(String cropName) {
        Pattern regexPattern = Pattern.compile(CROP_COMMON_NAME_PATTERN);
        return regexPattern.matcher(cropName).matches();
    }

    public static boolean cropScientificNameMatcher(String cropScientificName) {
        Pattern regexPattern = Pattern.compile(CROP_SCIENTIFIC_NAME_PATTERN);
        return regexPattern.matcher(cropScientificName).matches();
    }

    public static boolean cropCategoryMatcher(String cropCategory) {
        Pattern regexPattern = Pattern.compile(CROP_CATEGORY_PATTERN);
        return regexPattern.matcher(cropCategory).matches();
    }

    public static boolean cropSeasonMatcher(String cropSeason) {
        Pattern regexPattern = Pattern.compile(CROP_SEASON_PATTERN);
        return regexPattern.matcher(cropSeason).matches();
    }

    public static boolean cropFieldCodeMatcher(String cropFieldCode) {
        Pattern regexPattern = Pattern.compile(CROP_FIELD_CODE_PATTERN);
        return regexPattern.matcher(cropFieldCode).matches();
    }

    public static boolean staffIdMatcher(String staffId) {
        Pattern regexPattern = Pattern.compile(STAFF_ID_PATTERN);
        return regexPattern.matcher(staffId).matches();
    }

    public static boolean staffFirstNameMatcher(String staffFirstName) {
        Pattern regexPattern = Pattern.compile(STAFF_FIRST_NAME_PATTERN);
        return regexPattern.matcher(staffFirstName).matches();
    }

    public static boolean staffLastNameMatcher(String staffLastName) {
        Pattern regexPattern = Pattern.compile(STAFF_LAST_NAME_PATTERN);
        return regexPattern.matcher(staffLastName).matches();
    }

    public static boolean staffGenderMatcher(String staffGender) {
        Pattern regexPattern = Pattern.compile(STAFF_GENDER_PATTERN);
        return regexPattern.matcher(staffGender).matches();
    }

    public static boolean staffDesignationMatcher(String staffDesignation) {
        Pattern regexPattern = Pattern.compile(STAFF_DESIGNATION_PATTERN);
        return regexPattern.matcher(staffDesignation).matches();
    }

    public static boolean staffJoinedDateMatcher(String staffJoinedDate) {
        Pattern regexPattern = Pattern.compile(STAFF_JOINED_DATE_PATTERN);
        return regexPattern.matcher(staffJoinedDate).matches();
    }

    public static boolean staffDobMatcher(String staffDob) {
        Pattern regexPattern = Pattern.compile(STAFF_DOB_PATTERN);
        return regexPattern.matcher(staffDob).matches();
    }

    public static boolean staffAddress1Matcher(String staffAddress) {
        Pattern regexPattern = Pattern.compile(STAFF_ADDRESS_1_NO_PATTERN);
        return regexPattern.matcher(staffAddress).matches();
    }

    public static boolean staffAddress2Matcher(String staffAddress) {
        Pattern regexPattern = Pattern.compile(STAFF_ADDRESS_2_STREET_PATTERN);
        return regexPattern.matcher(staffAddress).matches();
    }

    public static boolean staffAddress3Matcher(String staffAddress) {
        Pattern regexPattern = Pattern.compile(STAFF_ADDRESS_3_CITY_PATTERN);
        return regexPattern.matcher(staffAddress).matches();
    }

    public static boolean staffAddress4Matcher(String staffAddress) {
        Pattern regexPattern = Pattern.compile(STAFF_ADDRESS_4_STATE_PATTERN);
        return regexPattern.matcher(staffAddress).matches();
    }

    public static boolean staffAddress5Matcher(String staffAddress) {
        Pattern regexPattern = Pattern.compile(STAFF_ADDRESS_5_POSTAL_PATTERN);
        return regexPattern.matcher(staffAddress).matches();
    }

    public static boolean staffContactNoMatcher(String staffContactNo) {
        Pattern regexPattern = Pattern.compile(STAFF_CONTACT_NO_PATTERN);
        return regexPattern.matcher(staffContactNo).matches();
    }

    public static boolean staffRoleMatcher(String staffRole) {
        Pattern regexPattern = Pattern.compile(STAFF_ROLE_PATTERN);
        return regexPattern.matcher(staffRole).matches();
    }

    public static boolean staffEmailMatcher(String staffEmail) {
        Pattern regexPattern = Pattern.compile(STAFF_EMAIL_PATTERN);
        return regexPattern.matcher(staffEmail).matches();
    }

    public static boolean staffFieldCodeMatcher(String staffFieldCode) {
        Pattern regexPattern = Pattern.compile(STAFF_FIELD_CODE_PATTERN);
        return regexPattern.matcher(staffFieldCode).matches();
    }

    public static boolean vehicleIdMatcher(String vehicleId) {
        Pattern regexPattern = Pattern.compile(VEHICLE_ID_PATTERN);
        return regexPattern.matcher(vehicleId).matches();
    }

    public static boolean vehicleCategoryMatcher(String vehicleType) {
        Pattern regexPattern = Pattern.compile(VEHICLE_CATEGORY_PATTERN);
        return regexPattern.matcher(vehicleType).matches();
    }

    public static boolean vehicleFuelTypeMatcher(String vehicleFuelType) {
        Pattern regexPattern = Pattern.compile(VEHICLE_FUEL_TYPE_PATTERN);
        return regexPattern.matcher(vehicleFuelType).matches();
    }

    public static boolean vehicleLicensePlateMatcher(String vehicleFuelType) {
        Pattern regexPattern = Pattern.compile(VEHICLE_LICENSE_PLATE_PATTERN);
        return regexPattern.matcher(vehicleFuelType).matches();
    }

    public static boolean vehicleStatusMatcher(String vehicleStatus) {
        Pattern regexPattern = Pattern.compile(VEHICLE_STATUS_PATTERN);
        return regexPattern.matcher(vehicleStatus).matches();
    }

    public static boolean vehicleRemarksMatcher(String vehicleRemarks) {
        Pattern regexPattern = Pattern.compile(VEHICLE_REMARKS_PATTERN);
        return regexPattern.matcher(vehicleRemarks).matches();
    }
    public static boolean vehicleStaffMatcher(String vehicleStaff) {
        Pattern regexPattern = Pattern.compile(VEHICLE_STAFF_PATTERN);
        return regexPattern.matcher(vehicleStaff).matches();
    }



    public static boolean equipmentIdMatcher(String equipmentId) {
        Pattern regexPattern = Pattern.compile(EQUIPMENT_ID_PATTERN);
        return regexPattern.matcher(equipmentId).matches();
    }

    public static boolean equipmentNameMatcher(String equipmentName) {
        Pattern regexPattern = Pattern.compile(EQUIPMENT_NAME_PATTERN);
        return regexPattern.matcher(equipmentName).matches();
    }

    public static boolean equipmentTypeMatcher(String equipmentType) {
        Pattern regexPattern = Pattern.compile(EQUIPMENT_TYPE_PATTERN);
        return regexPattern.matcher(equipmentType).matches();
    }

    public static boolean equipmentStatusMatcher(String equipmentStatus) {
        Pattern regexPattern = Pattern.compile(EQUIPMENT_STATUS_PATTERN);
        return regexPattern.matcher(equipmentStatus).matches();
    }

    public static boolean equipmentStaffMatcher(String equipmentStaff) {
        Pattern regexPattern = Pattern.compile(EQUIPMENT_STAFF_PATTERN);
        return regexPattern.matcher(equipmentStaff).matches();
    }
    public static boolean equipmentFieldMatcher(String equipmentField) {
        Pattern regexPattern = Pattern.compile(EQUIPMENT_FIELD_CODE_PATTERN);
        return regexPattern.matcher(equipmentField).matches();
    }

    public static boolean logIdMatcher(String logId) {
        Pattern regexPattern = Pattern.compile(LOG_ID_PATTERN);
        return regexPattern.matcher(logId).matches();
    }

    public static boolean logDateMatcher(String logDate) {
        Pattern regexPattern = Pattern.compile(LOG_DATE_PATTERN);
        return regexPattern.matcher(logDate).matches();
    }

    public static boolean logDetailsMatcher(String logDetails) {
        Pattern regexPattern = Pattern.compile(LOG_DETAILS_PATTERN);
        return regexPattern.matcher(logDetails).matches();
    }

    public static boolean logFieldCodeMatcher(String logFieldCode) {
        Pattern regexPattern = Pattern.compile(LOG_FIELD_CODE_PATTERN);
        return regexPattern.matcher(logFieldCode).matches();
    }

    public static boolean logCropCodeMatcher(String logCropCode) {
        Pattern regexPattern = Pattern.compile(LOG_CROP_CODE_PATTERN);
        return regexPattern.matcher(logCropCode).matches();
    }

    public static boolean logStaffIdMatcher(String logStaffId) {
        Pattern regexPattern = Pattern.compile(LOG_STAFF_PATTERN);
        return regexPattern.matcher(logStaffId).matches();
    }

    public static boolean userEmailMatcher(String userEmail) {
        Pattern regexPattern = Pattern.compile(USER_EMAIL_PATTERN);
        return regexPattern.matcher(userEmail).matches();
    }

    public static boolean userNameMatcher(String userName) {
        Pattern regexPattern = Pattern.compile(USER_NAME_PATTERN);
        return regexPattern.matcher(userName).matches();
    }

    public static boolean userPasswordMatcher(String userPassword) {
        Pattern regexPattern = Pattern.compile(USER_PASSWORD_PATTERN);
        return regexPattern.matcher(userPassword).matches();
    }

}
