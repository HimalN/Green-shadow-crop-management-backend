package lk.ijse.Green_shadow_crop_management_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreenShadowCropManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenShadowCropManagementBackendApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
