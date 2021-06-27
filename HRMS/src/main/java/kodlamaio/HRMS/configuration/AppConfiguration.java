package kodlamaio.HRMS.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfiguration {

	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}

	@Bean
	public Cloudinary cloudinary() {

		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dz0r9aikp", "api_key", "466178369458849", "api_secret",
				"qGITpenniU252Kc4SgksfOEKHRs"));
	}

}
