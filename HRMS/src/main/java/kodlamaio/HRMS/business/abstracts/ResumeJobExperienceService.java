package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeJobExperience;

public interface ResumeJobExperienceService {

	DataResult<List<ResumeJobExperience>> getAll();

	DataResult<ResumeJobExperience> getById(int id);

	DataResult<List<ResumeJobExperience>> getAllByResume_Id(int resumeId);

	DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDate(int resumeId);

	DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDateDesc(int resumeId);

	Result add(ResumeJobExperience resumeJobExperience);

	Result update(ResumeJobExperience resumeJobExperience);

	Result delete(ResumeJobExperience resumeJobExperience);

}
