package kodlamaio.HRMS.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Language>> getAll()
	{
		return this.languageService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Language> getById(@RequestParam int id)
	{
		return this.languageService.getById(id);
	}

	@PostMapping("/add")
    public Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }
	
	@PostMapping("/update")
    public Result update(@RequestBody Language language){
        return this.languageService.update(language);
    }
	
	@PostMapping("/delete")
    public Result delete(@RequestBody Language language){
        return this.languageService.delete(language);
    }
}
