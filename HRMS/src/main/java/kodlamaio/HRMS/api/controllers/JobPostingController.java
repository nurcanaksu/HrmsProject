package kodlamaio.HRMS.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HRMS.business.abstracts.JobPostingService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return jobPostingService.add(jobPosting);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobPosting jobPosting) {
		return jobPostingService.update(jobPosting);
	}
	
	@GetMapping("/getAllActiveJobPosting")
	public DataResult<List<JobPosting>> getAllActiveJobAdvert(){
		return jobPostingService.getAllActiveJobPosting();
	}
	
	@GetMapping("/getAllByCreationDateAsc")
	public DataResult<List<JobPosting>> getAllByCreationDateAsc(){
		return jobPostingService.getAllByCreationDateAsc();
	}
	
	@GetMapping("/getByIsActiveTrueAndEmployer_CompanyName")
	public DataResult<List<JobPosting>> getByIsActiveTrueAndEmployer_CompanyName( String companyName){
		return this.jobPostingService.getAllActiveJobPostingByCompanyName(companyName);
	}
	
	@PostMapping("/closeJobPosting")
	public Result closeJobAdvert(@RequestParam("id") int id) {
		return jobPostingService.closeJobPosting(id);
	}
	
	@PostMapping("/openJobPosting")
	public Result openJobAdvert(@RequestParam("id") int id) {
		return jobPostingService.openJobPosting(id);
	}
	
	
}
