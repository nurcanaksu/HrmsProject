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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ResumeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<Resume>>> getAll() {
		return ResponseEntity.ok(this.resumeService.getAll());
	}

	@GetMapping("/getById")
	public ResponseEntity<DataResult<Resume>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeService.getById(id));
	}

	@GetMapping("/getByCandidate_id")
	public ResponseEntity<DataResult<List<Resume>>> getByCandidate_id(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.resumeService.getByCandidate_id(candidateId));
	}

	@PostMapping("/uploadPhoto")
	public Result uploadImage(@RequestParam int candidateId, @RequestBody MultipartFile file) {
		return this.resumeService.uploadPhoto(candidateId, file);
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody Resume resume) {
		return ResponseEntity.ok(this.resumeService.add(resume));
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody Resume resume) {
		return ResponseEntity.ok(this.resumeService.update(resume));
	}

	@PostMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody Resume resume) {
		return ResponseEntity.ok(this.resumeService.delete(resume));
	}

}
