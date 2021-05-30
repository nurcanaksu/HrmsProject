package kodlamaio.HRMS.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {

	private JobPositionService jobTitleService;

	@Autowired
	public JobTitlesController(JobPositionService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobTitleService.getAll();
	}
	
	
	
}
