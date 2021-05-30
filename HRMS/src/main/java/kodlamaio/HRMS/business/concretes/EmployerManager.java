package kodlamaio.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {

		if (!validationEmployer(employer)) {
			return new ErrorResult("Eksik veri girişi.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Email e sahip kullanıcı zaten var");
		}

		if (!checkEmailFormat(employer.getEmail())) {
			return new ErrorResult("E-mail formatında olmasına dikkat edip tekrar deneyiniz.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
			return new ErrorResult("web sitesi ile aynı domaine sahip e-posta olduğundan emin olunuz");
		}

		employer.setCreatedDate(LocalDate.now());
		employer.setActive(true);

		this.employerDao.save(employer);
		return new SuccessResult("İşçi başarıyla eklendi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccesDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {

		return new SuccesDataResult<Employer>(this.employerDao.findByEmail(email));
	}

	private boolean validationEmployer(Employer employer) {
		if (employer.getEmail() == null && employer.getPassword() == null && employer.getCompanyName() == null
				&& employer.getWebAddress() == null) { 
			return false;
		}
		return true;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.employerDao.findByEmail(email) != null) {
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

	private boolean checkIfEqualEmailAndDomain(String email, String website) {

		String[] webAdressKeywords = { "www", "http://www", "https://www" };

		String[] emailDomain = email.split("@", 2);

		String domain = "";
		String[] websiteDomain = website.split("\\.", 2);
		if (Arrays.asList(webAdressKeywords).contains(websiteDomain[0])) {
			domain = websiteDomain[1];
		} else {
			domain = website;
		}

		if (!emailDomain[1].equals(domain)) {
			System.out.println("Domain hatası");
			return false;
		}
		return true;
	}

}
