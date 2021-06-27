package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.LanguageDao;
import kodlamaio.HRMS.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	
	private LanguageDao languageDao;
	
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccesDataResult<List<Language>>(this.languageDao.findAll(), "Diller listelendi");
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccesDataResult<Language>(this.languageDao.getById(id),"Id sine sahip dil getirildi");
	}

	@Override
	public Result add(Language language) {
		language.setActive(true);
		this.languageDao.save(language);
		return new SuccessResult("Dil başarıyla eklendi");
	}

	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil başarıyla güncellendi");
	}

	@Override
	public Result delete(Language language) {
		this.languageDao.delete(language);
		return new SuccessResult("Dil başarıyla silindi");
	}

	
}
