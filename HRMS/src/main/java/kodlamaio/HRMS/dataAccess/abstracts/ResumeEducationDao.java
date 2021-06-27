package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.ResumeEducation;

public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer> {

	List<ResumeEducation> getAllByResume_Id(int resumeId); // eğitim bilgileri

	List<ResumeEducation> getAllByResume_IdOrderByGraduationDate(int resumeId); // mezuniyet tarihleri çoktan aza

	List<ResumeEducation> getAllByResume_IdOrderByGraduationDateDesc(int resumeId); // tam tersi
}
