package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeLinkService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.HRMS.entities.concretes.ResumeLink;

@Service
public class ResumeLinkManager implements ResumeLinkService {
	private ResumeLinkDao resumeLinkDao;

	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao) {
		super();
		this.resumeLinkDao = resumeLinkDao;
	}

	@Override
	public DataResult<List<ResumeLink>> getAll() {
		return new SuccesDataResult<List<ResumeLink>>(this.resumeLinkDao.findAll());
	}

	@Override
	public DataResult<ResumeLink> getById(int id) {
		Optional<ResumeLink> resumeLink = this.resumeLinkDao.findById(id);

		if (Optional.empty() != null) {
			return new ErrorDataResult<ResumeLink>("CV Link bulunamadı");
		}
		return new SuccesDataResult<ResumeLink>(resumeLink.get());
	}

	@Override
	public DataResult<List<ResumeLink>> getAllByResume_Id(int resumeId) {
		return new SuccesDataResult<List<ResumeLink>>(this.resumeLinkDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		System.out.println("resumeLink add ->" + resumeLink);
		return new SuccessResult("CV Link Eklendi.");
	}

	@Override
	public Result update(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		System.out.println("resumeLink update ->" + resumeLink);
		return new SuccessResult("CV Link Güncellendi.");
	}

	@Override
	public Result delete(ResumeLink resumeLink) {
		this.resumeLinkDao.delete(resumeLink);
		return new SuccessResult("CV Link Silindi.");
	}
}
