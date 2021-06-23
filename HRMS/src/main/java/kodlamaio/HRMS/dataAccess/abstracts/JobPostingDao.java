package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> 
{

	@Query("From JobPosting where isActive = true") //aktif iş ilanlarını listeler
	List<JobPosting> getAllActiveJobAdverts();
	
	@Query("From JobPosting where isActive = true Order By createdDate") //tarihe göre listeler
	List<JobPosting> getAllByCreationDateAsc();
	
	
	@Query("From JobPosting where isActive = true and employer.companyName=:companyName") //şirket ismine göre listeler
	List<JobPosting> getAllActiveJobPostingByEmployer_CompanyName(String companyName);
	

}
