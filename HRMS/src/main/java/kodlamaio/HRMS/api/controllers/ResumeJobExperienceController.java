package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeJobExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeJobExperience;

@RestController
@RequestMapping("/api/resumeJobExperiences")
public class ResumeJobExperienceController {

	private ResumeJobExperienceService resumeJobExperienceService;

	@Autowired
	public ResumeJobExperienceController(ResumeJobExperienceService resumeJobExperienceService) {
		super();
		this.resumeJobExperienceService = resumeJobExperienceService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ResumeJobExperience>>> getAll() {
		return ResponseEntity.ok(this.resumeJobExperienceService.getAll());
	}

	@GetMapping("/getById")
	public ResponseEntity<DataResult<ResumeJobExperience>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeJobExperienceService.getById(id));
	}
	
	

	@GetMapping("/getAllByResume_Id")
	public ResponseEntity<DataResult<List<ResumeJobExperience>>> getAllByResume_Id(@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeJobExperienceService.getAllByResume_Id(resumeId));
	}

	@GetMapping("/getAllByResume_IdOrderByFinishDate")
	public ResponseEntity<DataResult<List<ResumeJobExperience>>> getAllByResume_IdOrderByFinishDate(
			@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeJobExperienceService.getAllByResume_IdOrderByFinishDate(resumeId));
	}

	@GetMapping("/getAllByResume_IdOrderByFinishDateDesc")
	public ResponseEntity<DataResult<List<ResumeJobExperience>>> getAllByResume_IdOrderByFinishDateDesc(
			@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeJobExperienceService.getAllByResume_IdOrderByFinishDateDesc(resumeId));
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody ResumeJobExperience resumeJobExperience) {
		return ResponseEntity.ok(this.resumeJobExperienceService.add(resumeJobExperience));
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody ResumeJobExperience resumeJobExperience) {
		return ResponseEntity.ok(this.resumeJobExperienceService.update(resumeJobExperience));
	}

	@PostMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody ResumeJobExperience resumeJobExperience) {
		return ResponseEntity.ok(this.resumeJobExperienceService.delete(resumeJobExperience));
	}

}
