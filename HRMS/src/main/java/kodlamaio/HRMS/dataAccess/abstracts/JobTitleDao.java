package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPosition;

public interface JobTitleDao extends JpaRepository<JobPosition, Integer> {

	JobPosition findByTitleName(String titleName);
}
