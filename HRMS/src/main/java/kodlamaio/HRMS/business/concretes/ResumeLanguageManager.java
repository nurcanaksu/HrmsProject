package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeLanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;

@Service
public class ResumeLanguageManager implements ResumeLanguageService {

	private ResumeLanguageDao resumeLanguageDao;

	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		return new SuccesDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.findAll());
	}

	@Override
	public DataResult<ResumeLanguage> getById(int id) {
		Optional<ResumeLanguage> resumeLanguage = this.resumeLanguageDao.findById(id);

		if (Optional.empty() != null) {

			return new ErrorDataResult<ResumeLanguage>("CV Dil Bilgisi bulunamadı");
			
		}
		return new SuccesDataResult<ResumeLanguage>(resumeLanguage.get());

	}

	@Override
	public DataResult<List<ResumeLanguage>> getAllByResume_Id(int resumeId) {
		return new SuccesDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		System.out.println("resumeLanguage add ->" + resumeLanguage);
		return new SuccessResult("CV Dil Bilgisi Eklendi.");
	}

	@Override
	public Result update(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		System.out.println("resumeLanguage update ->" + resumeLanguage);
		return new SuccessResult("CV Dil Bilgisi Güncellendi.");
	}

	@Override
	public Result delete(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.delete(resumeLanguage);
		return new SuccessResult("CV Dil Bilgisi Silindi.");
	}

}
