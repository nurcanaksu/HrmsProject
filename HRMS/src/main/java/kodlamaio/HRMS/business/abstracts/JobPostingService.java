package kodlamaio.HRMS.business.abstracts;

import java.util.List;


import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingService {

	public Result add(JobPosting jobPosting);

	public Result delete(JobPosting jobPosting);

	public Result update(JobPosting jobPosting);

	public DataResult<List<JobPosting>> getAllActiveJobPosting();

	public DataResult<List<JobPosting>> getAllByCreationDateAsc();

	public DataResult<List<JobPosting>> getAllActiveJobPostingByCompanyName(String companyName);
 
	public Result closeJobPosting(int id);

	public Result openJobPosting(int id);

}