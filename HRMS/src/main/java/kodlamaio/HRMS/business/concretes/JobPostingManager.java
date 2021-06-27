package kodlamaio.HRMS.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPostingService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPostingDao;
import kodlamaio.HRMS.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("iş ilanı eklendi");
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("iş ilanı başarıyla silindi");

	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("iş ilani başarıyla güncellendi!");
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPosting() {
		return new SuccesDataResult<List<JobPosting>>(this.jobPostingDao.getAllActiveJobAdverts());
	}

	@Override
	public DataResult<List<JobPosting>> getAllByCreationDateAsc() {
		return new SuccesDataResult<List<JobPosting>>(this.jobPostingDao.getAllByCreationDateAsc());
	}
    

	@Override
	public Result closeJobPosting(int id) {
		JobPosting jobPosting = jobPostingDao.getOne(id);

		if (jobPosting == null) {
			return new ErrorResult("böyle bir iş ilanı yok");
		}

		if (jobPosting.isActive() == false) {
			return new ErrorResult("bu iş ilanı zaten pasif");
		}

		jobPosting.setActive(false);
		update(jobPosting);
		return new SuccessResult("is ilani pasif duruma cekildi");
	}

	@Override
	public Result openJobPosting(int id) {
		JobPosting jobPosting = jobPostingDao.getOne(id);

		if (jobPosting == null) {
			return new ErrorResult("boyle bir is ilani yok");
		}

		if (jobPosting.isActive() == true) {
			return new ErrorResult("bu is ilani zaten aktif");
		}

		jobPosting.setActive(true);
		update(jobPosting);
		return new SuccessResult("is ilani aktif duruma cekildi");
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPostingByCompanyName(String companyName) {
		return new SuccesDataResult<List<JobPosting>>(
				this.jobPostingDao.getAllActiveJobPostingByEmployer_CompanyName(companyName));
	}

}
