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

import kodlamaio.HRMS.business.abstracts.ResumeLanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;

@RestController
@RequestMapping("/api/resumeLanguages")
public class ResumeLanguageController {
	private ResumeLanguageService resumeLanguageService;

	@Autowired
	public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
		super();
		this.resumeLanguageService = resumeLanguageService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ResumeLanguage>>> getAll() {
		return ResponseEntity.ok(this.resumeLanguageService.getAll());
	}

	@GetMapping("/getById")
	public ResponseEntity<DataResult<ResumeLanguage>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeLanguageService.getById(id));
	}

	@GetMapping("/getAllByResume_Id")
	public ResponseEntity<DataResult<List<ResumeLanguage>>> getAllByResume_Id(@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeLanguageService.getAllByResume_Id(resumeId));
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody ResumeLanguage resumeLanguage) {
		return ResponseEntity.ok(this.resumeLanguageService.add(resumeLanguage));
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody ResumeLanguage resumeLanguage) {
		return ResponseEntity.ok(this.resumeLanguageService.update(resumeLanguage));
	}

	@PostMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody ResumeLanguage resumeLanguage) {
		return ResponseEntity.ok(this.resumeLanguageService.delete(resumeLanguage));
	}

}
