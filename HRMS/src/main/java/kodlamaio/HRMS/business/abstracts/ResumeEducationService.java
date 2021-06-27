package kodlamaio.HRMS.business.abstracts;

import java.util.List;


import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;

public interface ResumeEducationService{

	DataResult<List<ResumeEducation>> getAll();
	
	DataResult<ResumeEducation> getById(int id);
	
	DataResult<List<ResumeEducation>> getAllByResume_Id(int resumeId);

	DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDate(int resumeId); // ASC

	DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDateDesc(int resumeId);

	Result add(ResumeEducation resumeEducation);

	Result update(ResumeEducation resumeEducation);

	Result delete(ResumeEducation resumeEducation);

}
