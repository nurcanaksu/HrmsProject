package kodlamaio.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/addedoperations")
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerforemployer")
    public Result registerForEmployer(@RequestBody Employer employer, String passwordRepeat) {
        return authService.registerForEmployer(employer, passwordRepeat);
    }

    @PostMapping("/registerforcandidate")
    public Result registerForCandidate(@RequestBody Candidate candidate, String passwordRepeat) {
        return authService.registerForCandidate(candidate, passwordRepeat);
    }
	
}
