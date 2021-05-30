package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.adapters.verification.mail.ValidationService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;
import lombok.var;

@Service("AuthManager")
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private ValidationService validationService;

	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService,
			ValidationService validationService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.validationService = validationService;
	}

	@Override
	public Result registerForCandidate(Candidate candidate, String passwordRepeat) {
		if (!checkPasswordRepeat(candidate.getPassword(), passwordRepeat)) {
			return new ErrorResult("Şifreler eşleşmiyor");
		}

		var result = this.candidateService.add(candidate);

		if (result.isSucces()) {
			if (validationService(candidate.getEmail())) {
				return new SuccessResult("Aday kaydoldu");
			}
		}

		return new ErrorResult(result.getMessage());
	}

	@Override
	public Result registerForEmployer(Employer employer, String passwordRepeat) {
		if (!checkPasswordRepeat(employer.getPassword(), passwordRepeat)) {
			return new ErrorResult("Şifreler Eşleşmiyor");
		}

		var result = this.employerService.add(employer);

		if (result.isSucces()) {
			if (validationService(employer.getEmail())) {
				return new SuccessResult("İşçi kayıt başarılı");
			}
		}

		return new ErrorResult(result.getMessage());
	}

	private boolean checkPasswordRepeat(String password, String passwordRepeat) {
		if (!password.equals(passwordRepeat)) {
			return false;
		}
		return true;
	}

	private boolean validationService(String email) {
		String code = this.validationService.codeGenerator(); 
		if (!this.validationService.sendVerificationCode(email, code)) { 
			return false;
		}
		return true;
	}

}
