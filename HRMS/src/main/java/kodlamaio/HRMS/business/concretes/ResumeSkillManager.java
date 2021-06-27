package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

@Service
public class ResumeSkillManager implements ResumeSkillService {

	private ResumeSkillDao resumeSkillDao;

	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccesDataResult<List<ResumeSkill>>(this.resumeSkillDao.findAll());
	}

	@Override
	public DataResult<ResumeSkill> getById(int id) {
		Optional<ResumeSkill> resumeSkill = this.resumeSkillDao.findById(id);

		if (Optional.empty() != null) {
			return new ErrorDataResult<ResumeSkill>("CV Beceri bulunamadı");
		}
		return new SuccesDataResult<ResumeSkill>(resumeSkill.get());
	}

	@Override
	public DataResult<List<ResumeSkill>> getAllByResume_Id(int resumeId) {
		return new SuccesDataResult<List<ResumeSkill>>(this.resumeSkillDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("CV Beceri Eklendi.");
	}

	@Override
	public Result update(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("CV Beceri Güncellendi.");
	}

	@Override
	public Result delete(ResumeSkill resumeSkill) {
		this.resumeSkillDao.delete(resumeSkill);
		return new SuccessResult("CV Beceri Silindi.");
	}

}
