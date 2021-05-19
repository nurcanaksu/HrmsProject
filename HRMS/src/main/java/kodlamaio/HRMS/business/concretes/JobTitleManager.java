package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobTitleService;
import kodlamaio.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HRMS.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	// DataAccess tarafındaki dao ya erişelim

	private JobTitleDao jobTitleDao; //injekşın

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public List<JobTitle> getAll() {

		return this.jobTitleDao.findAll();
	}

}
