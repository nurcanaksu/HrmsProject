package kodlamaio.HRMS.business.abstracts;

import java.util.List;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

public interface ResumeSkillService {

	DataResult<List<ResumeSkill>> getAll();

	DataResult<ResumeSkill> getById(int id);

	DataResult<List<ResumeSkill>> getAllByResume_Id(int resumeId);

	Result add(ResumeSkill resumeSkill);

	Result update(ResumeSkill resumeSkill);

	Result delete(ResumeSkill resumeSkill);

}
