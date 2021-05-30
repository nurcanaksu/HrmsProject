package kodlamaio.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.adapters.verification.mernis.MernisCandidateCheckService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private MernisCandidateCheckService candidateCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, 
			MernisCandidateCheckService candidateCheckService
			) {
		super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccesDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getByNationalityId(String nationalityId) {
		return new SuccesDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityId));
	}

	@Override
	public DataResult<Candidate> getByEmail(String emailAddress) {
		return new SuccesDataResult<Candidate>(this.candidateDao.findByEmail(emailAddress));
	}

	@Override
	public Result add(Candidate candidate) {

		if (!validationCondidate(candidate)) {
			return new ErrorResult("Eksik veri girişi.");
		}

		if (!checkIfNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("Bu kimlik numarasına kayıtlı kullanıcı zaten var");
		}

		if (!checkIfRealPerson(candidate)) {
			return new ErrorResult("Kullanıcı doğrulanamadı");
		}

		if (!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Email e sahip kullanıcı zaten var");
		}

		if (!checkEmailFormat(candidate.getEmail())) {
			return new ErrorResult("E-posta formatında olmasına dikkat edip tekrar deneyiniz.");
		}

		candidate.setCreatedDate(LocalDate.now());
		candidate.setActive(true);

		this.candidateDao.save(candidate);
		return new SuccessResult("Aday başarıyla eklendi");

	}

	private boolean checkIfNationalityId(String nationalityId) {
		if (this.candidateDao.findByNationalityId(nationalityId) != null) {
			return false;
		}
		return true;
	}

	private boolean checkIfRealPerson(Candidate candidate) {
		if (!this.candidateCheckService.CheckIfRealPerson(Long.parseLong(candidate.getNationalityId()),
				candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
				candidate.getBirthDate())) {
			return false;
		}
		return true;
	}

	private boolean validationCondidate(Candidate candidate) {
		if (candidate.getEmail() == null && candidate.getPassword() == null && candidate.getFirstName() == null
				&& candidate.getLastName() == null && candidate.getNationalityId() == null
				&& candidate.getBirthDate() == null) {
			return false;
		}
		return true;
	}

	private boolean checkIfEmailExists(String emailAddress) {
		if (this.candidateDao.findByEmail(emailAddress) != null) {
			return false;
		}
		return true;
	}

	public boolean checkEmailFormat(String message) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(message);
		return matcher.matches();
	}

}
