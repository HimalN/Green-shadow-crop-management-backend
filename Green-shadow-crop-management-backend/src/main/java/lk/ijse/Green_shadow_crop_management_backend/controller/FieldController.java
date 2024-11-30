package lk.ijse.Green_shadow_crop_management_backend.controller;

import lk.ijse.Green_shadow_crop_management_backend.dto.impl.FieldDTO;
import lk.ijse.Green_shadow_crop_management_backend.entity.impl.Field;
import lk.ijse.Green_shadow_crop_management_backend.service.FieldService;
import lk.ijse.Green_shadow_crop_management_backend.util.AppUtil;
import lk.ijse.Green_shadow_crop_management_backend.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("api/V1/fields")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveField(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart("filedName") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extent") String extent,
            @RequestPart("fieldImage1")MultipartFile filedImage1,
            @RequestPart("fieldImage2")MultipartFile filedImage2
    ){
        String base64fieldImage1 = "";
        String base64fieldImage2 = "";
        try {
            byte[] imageBytes1 = filedImage1.getBytes();
            base64fieldImage1 = AppUtil.picToBase64(imageBytes1);

            byte[] imageBytes2 = filedImage2.getBytes();
            base64fieldImage2 = AppUtil.picToBase64(imageBytes2);

            if(!RegexProcess.fieldCodeMatcher(fieldCode)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.fieldNameMatcher(fieldName)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.fieldLocationMatcher(location)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (!RegexProcess.fieldExtentMatcher(extent)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            /*FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldCode(fieldCode);
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setLocation(location);
            fieldDTO.setExtent(extent);
            fieldDTO.setFieldImage1(base64fieldImage1);
            fieldDTO.setFieldImage2(base64fieldImage2);*/
            fieldService.saveField(fieldCode,fieldName,location,extent,base64fieldImage1,base64fieldImage2);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
