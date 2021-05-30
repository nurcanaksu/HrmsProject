package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;

public interface AuthService {

	Result registerForCandidate(Candidate candidate, String passwordRepeat);
	Result registerForEmployer(Employer employer, String passwordRepeat);
}