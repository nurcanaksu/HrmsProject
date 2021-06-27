package kodlamaio.HRMS.business.abstracts;


import java.util.List;


import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);
	
	DataResult<Candidate> getByNationalityId(String nationalityId);
	
	DataResult<Candidate> getByEmail(String emailAddress);
}


