package kodlamaio.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeEducationService;

import java.util.List;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;

@RestController
@RequestMapping("/api/resumeEducations")
public class ResumeEducationController {
	private ResumeEducationService resumeEducationService;

	@Autowired
	public ResumeEducationController(ResumeEducationService resumeEducationService) {
		super();
		this.resumeEducationService = resumeEducationService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ResumeEducation>>> getAll() {
		return ResponseEntity.ok(this.resumeEducationService.getAll());

	}

	@GetMapping("/getById")
	public ResponseEntity<DataResult<ResumeEducation>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeEducationService.getById(id));
	}
	
	@GetMapping("/getAllByResume_Id")
	public ResponseEntity<DataResult<List<ResumeEducation>>> getAllByResume_Id(@RequestParam int resumeId)
	{
		return ResponseEntity.ok(this.resumeEducationService.getAllByResume_Id(resumeId));
	}
	
	@GetMapping("/getAllByResume_IdOrderByGraduationDate")
	public ResponseEntity<DataResult<List<ResumeEducation>>> getAllByResume_IdOrderByGraduationDate(@RequestParam int resumeId)
	{
		return ResponseEntity.ok(this.resumeEducationService.getAllByResume_IdOrderByGraduationDate(resumeId));
	}
	
	@GetMapping("/getAllByResume_IdOrderByGraduationDateDesc")
	public ResponseEntity<DataResult<List<ResumeEducation>>> getAllByResume_IdOrderByGraduationDateDesc(@RequestParam int resumeId)
	{
		return ResponseEntity.ok(this.resumeEducationService.getAllByResume_IdOrderByGraduationDate(resumeId));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody ResumeEducation resumeEducation)
	{
		return ResponseEntity.ok(this.resumeEducationService.add(resumeEducation));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody ResumeEducation resumeEducation)
	{
		return ResponseEntity.ok(this.resumeEducationService.update(resumeEducation));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody ResumeEducation resumeEducation)
	{
		return ResponseEntity.ok(this.resumeEducationService.delete(resumeEducation));
	}
	
	
	
	
	
	
	
}
