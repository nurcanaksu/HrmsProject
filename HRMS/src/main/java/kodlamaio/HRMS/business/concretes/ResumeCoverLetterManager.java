package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import kodlamaio.HRMS.business.abstracts.ResumeCoverLetterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeCoverLetterDao;
import kodlamaio.HRMS.entities.concretes.ResumeCoverLetter;

@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService {

	private ResumeCoverLetterDao resumeCoverLetterDao;

	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao) {
		super();
		this.resumeCoverLetterDao = resumeCoverLetterDao;
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAll() {
		return new SuccesDataResult<List<ResumeCoverLetter>>(this.resumeCoverLetterDao.findAll());
	}

	@Override
	public DataResult<ResumeCoverLetter> getById(int id) {
		Optional<ResumeCoverLetter> resumeCoverLetter = this.resumeCoverLetterDao.findById(id);

		if (Optional.empty() != null) {
			return new SuccesDataResult<ResumeCoverLetter>(resumeCoverLetter.get());

		}
		return new ErrorDataResult<ResumeCoverLetter>("CV Ön Yazı bulunamadı");
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAllByResume_Id(int resumeId) {
		return new SuccesDataResult<List<ResumeCoverLetter>>(this.resumeCoverLetterDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.save(resumeCoverLetter);
		return new SuccessResult("CV Ön Yazı Eklendi.");
	}

	@Override
	public Result update(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.save(resumeCoverLetter);
		return new SuccessResult("CV Ön Yazı Güncellendi.");
	}

	@Override
	public Result delete(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.delete(resumeCoverLetter);
		return new SuccessResult("CV Ön Yazı Silindi.");
	}

}
