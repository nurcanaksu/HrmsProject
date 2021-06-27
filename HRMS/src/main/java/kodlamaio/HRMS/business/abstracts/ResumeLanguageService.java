package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;

public interface ResumeLanguageService {

	DataResult<List<ResumeLanguage>> getAll();

	DataResult<ResumeLanguage> getById(int id);

	DataResult<List<ResumeLanguage>> getAllByResume_Id(int resumeId);

	Result add(ResumeLanguage resumeLanguage);

	Result update(ResumeLanguage resumeLanguage);

	Result delete(ResumeLanguage resumeLanguage);
}
