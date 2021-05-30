package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HRMS.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobPositionManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccesDataResult<List<JobPosition>>(this.jobTitleDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getByTitleName(String titleName) {
		
		return new SuccesDataResult<JobPosition>(this.jobTitleDao.findByTitleName(titleName));
	}

	@Override
	public Result add(JobPosition jobPosition) {
		this.jobTitleDao.save(jobPosition);
		return new SuccessResult("İşçi pozisyonu başarıyla eklendi");
	}

	

}
