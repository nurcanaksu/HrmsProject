package kodlamaio.HRMS.core.utilities.adapters.verification.image;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.results.DataResult;

public interface ImageService {

	DataResult<?> uploadPhoto(MultipartFile file);
}
