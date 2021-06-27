package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeJobExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeJobExperienceDao;
import kodlamaio.HRMS.entities.concretes.ResumeJobExperience;

@Service
public class ResumeJobExperienceManager implements ResumeJobExperienceService {

	private ResumeJobExperienceDao resumeJobExperienceDao;

	@Autowired
	public ResumeJobExperienceManager(ResumeJobExperienceDao resumeJobExperienceDao) {
		super();
		this.resumeJobExperienceDao = resumeJobExperienceDao;
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAll() {
		return new SuccesDataResult<List<ResumeJobExperience>>(this.resumeJobExperienceDao.findAll());
	}

	@Override
	public DataResult<ResumeJobExperience> getById(int id) {
		Optional<ResumeJobExperience> resumeJobExperience = this.resumeJobExperienceDao.findById(id);

		if (Optional.empty() != null) {
			return new ErrorDataResult<ResumeJobExperience>("CV İş Deneyimi bulunamadı");
		}

		return new SuccesDataResult<ResumeJobExperience>(resumeJobExperience.get());

	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAllByResume_Id(int resumeId) {
		return new SuccesDataResult<List<ResumeJobExperience>>(this.resumeJobExperienceDao.getAllByResume_Id(resumeId));
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDate(int resumeId) {
		return new SuccesDataResult<List<ResumeJobExperience>>(
				this.resumeJobExperienceDao.getAllByResume_IdOrderByFinishDate(resumeId));
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDateDesc(int resumeId) {
		return new SuccesDataResult<List<ResumeJobExperience>>(
				this.resumeJobExperienceDao.getAllByResume_IdOrderByFinishDateDesc(resumeId));
	}

	@Override
	public Result add(ResumeJobExperience resumeJobExperience) {
		this.resumeJobExperienceDao.save(resumeJobExperience);
		return new SuccessResult("Cv ye deneyimi eklendi");
	}

	@Override
	public Result update(ResumeJobExperience resumeJobExperience) {
		this.resumeJobExperienceDao.save(resumeJobExperience);
		return new SuccessResult("Cv ye deneyimi güncellendi");

	}

	@Override
	public Result delete(ResumeJobExperience resumeJobExperience) {
		this.resumeJobExperienceDao.delete(resumeJobExperience);
		return new SuccessResult("Cv den deneyim silindi");

	}

}
