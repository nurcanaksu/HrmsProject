package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ResumeService;
import kodlamaio.HRMS.core.utilities.adapters.verification.image.ImageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeDao;
import kodlamaio.HRMS.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;

	private ImageService imageService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, ImageService imageService) {
		super();
		this.resumeDao = resumeDao;

		this.imageService = imageService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccesDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getById(int id) {
		Optional<Resume> resume = this.resumeDao.findById(id);

		if (Optional.empty() != null){
			return new SuccesDataResult<Resume>(resume.get());
		}
		return new ErrorDataResult<Resume>("CV bulunamadı");
		
	}

	@Override
	public DataResult<List<Resume>> getByCandidate_id(int candidateId) {
		Optional<List<Resume>> candidateResult = this.resumeDao.getByCandidate_id(candidateId);
		
		if (Optional.empty() != null) {

			return new SuccesDataResult<List<Resume>>(candidateResult.get(), "İş Arayanın Cv Listelendi");
		}
		return new ErrorDataResult<List<Resume>>("İş Arayanın Cv Bulunamadı");
	}

	@Override
	public Result uploadPhoto(int candidateId, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageService.uploadPhoto(file).getData();
		String url = result.get("url");
		List<Resume> resumesAddPhoto = this.getByCandidate_id(candidateId).getData();
		for (Resume resume : resumesAddPhoto) {
			resume.setImage(url);
			this.resumeDao.save(resume);
		}
		
		return new SuccessResult();
	}
	
	@Override
	public Result add(Resume resume) {
		//this.resumeDao.save(resume);
		System.out.println(resume);
		System.out.println(resume.getResumeEducations());
		return new SuccessResult("CV Eklendi.");
	}

	@Override
	public Result update(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("CV Güncellendi.");
	}

	@Override
	public Result delete(Resume resume) {
		this.resumeDao.delete(resume);
		return new SuccessResult("CV Silindi.");
	}

}
