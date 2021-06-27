package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLink;

public interface ResumeLinkService {
	
	DataResult<List<ResumeLink>> getAll();

	DataResult<ResumeLink> getById(int id);

	DataResult<List<ResumeLink>> getAllByResume_Id(int resumeId);

	Result add(ResumeLink resumeLink);

	Result update(ResumeLink resumeLink);

	Result delete(ResumeLink resumeLink);

}
