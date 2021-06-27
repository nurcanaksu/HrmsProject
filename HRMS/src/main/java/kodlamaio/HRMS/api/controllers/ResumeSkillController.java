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

import kodlamaio.HRMS.business.abstracts.ResumeSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

@RestController
@RequestMapping("/api/resumeSkills")
public class ResumeSkillController {

	private ResumeSkillService resumeSkillService;

	@Autowired
	public ResumeSkillController(ResumeSkillService resumeSkillService) {
		super();
		this.resumeSkillService = resumeSkillService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ResumeSkill>>> getAll() {
		return ResponseEntity.ok(this.resumeSkillService.getAll());
	}

	@GetMapping("/getById")
	public ResponseEntity<DataResult<ResumeSkill>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeSkillService.getById(id));
	}

	@GetMapping("/getAllByResume_Id")
	public ResponseEntity<DataResult<List<ResumeSkill>>> getAllByResume_Id(@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeSkillService.getAllByResume_Id(resumeId));
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody ResumeSkill resumeSkill) {
		return ResponseEntity.ok(this.resumeSkillService.add(resumeSkill));
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody ResumeSkill resumeSkill) {
		return ResponseEntity.ok(this.resumeSkillService.update(resumeSkill));
	}

	@PostMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody ResumeSkill resumeSkill) {
		return ResponseEntity.ok(this.resumeSkillService.delete(resumeSkill));
	}

}
