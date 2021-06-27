package kodlamaio.HRMS.business.concretes;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeEducationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeEducationDao;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;

@Service
public class ResumeEducationManager implements ResumeEducationService {

	private ResumeEducationDao resumeEducationDao;
	
	@Autowired
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao) {
		super();
		this.resumeEducationDao = resumeEducationDao;
	}

	@Override
	public DataResult<List<ResumeEducation>> getAll() {
		return new SuccesDataResult<List<ResumeEducation>>(this.resumeEducationDao.findAll());
	}

	@Override
	public DataResult<ResumeEducation> getById(int id) {
		Optional<ResumeEducation> resumeEducation = this.resumeEducationDao.findById(id);

		if (Optional.empty() != null){

			return new SuccesDataResult<ResumeEducation>(resumeEducation.get());
		}
		return new ErrorDataResult<ResumeEducation>("CV'de Eğitim bulunamadı");
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByResume_Id(int resumeId) {
		return new SuccesDataResult<List<ResumeEducation>>(this.resumeEducationDao.getAllByResume_Id(resumeId));
	}
	@Override
	public DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDate(int resumeId) {
		return new SuccesDataResult<List<ResumeEducation>>(this.resumeEducationDao.getAllByResume_IdOrderByGraduationDate(resumeId));
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDateDesc(int resumeId) {
		return new SuccesDataResult<List<ResumeEducation>>(this.resumeEducationDao.getAllByResume_IdOrderByGraduationDateDesc(resumeId));
	}

	@Override
	public Result add(ResumeEducation resumeEducation) {
		this.resumeEducationDao.save(resumeEducation);
		return new SuccessResult("Cv'ye eğitim başarıyla eklendi");
	}

	@Override
	public Result update(ResumeEducation resumeEducation) {
		this.resumeEducationDao.save(resumeEducation);
		return new SuccessResult("CV'de eğitim alanı başarıyla güncellendi");
	}

	@Override
	public Result delete(ResumeEducation resumeEducation) {
		this.resumeEducationDao.delete(resumeEducation);
		return new SuccessResult("CV'de eğitim alanı başarıyla silindi");
	}

	


}
