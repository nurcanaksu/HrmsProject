package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.ResumeJobExperience;

public interface ResumeJobExperienceDao extends JpaRepository<ResumeJobExperience, Integer> {

	List<ResumeJobExperience> getAllByResume_Id(int resumeId);

	List<ResumeJobExperience> getAllByResume_IdOrderByFinishDate(int resumeId);

	List<ResumeJobExperience> getAllByResume_IdOrderByFinishDateDesc(int resumeId);
}
