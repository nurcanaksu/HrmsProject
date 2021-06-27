package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterService {

    DataResult<List<ResumeCoverLetter>> getAll();
	
	DataResult<ResumeCoverLetter> getById(int id);
	
	DataResult<List<ResumeCoverLetter>> getAllByResume_Id(int resumeId);
	
	Result add(ResumeCoverLetter resumeCoverLetter);
	
	Result update(ResumeCoverLetter resumeCoverLetter);
	
	Result delete(ResumeCoverLetter resumeCoverLetter);

}
