package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="resumes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumeEducations","resumeJobExperiences", "resumeLanguages","resumeCoverLetters","resumeLinks","resumeSkills"})
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name="image")
	private String image;
	
	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeEducation> resumeEducations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeJobExperience> resumeJobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeLanguage> resumeLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeCoverLetter> resumeCoverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeLink> resumeLinks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ResumeSkill> resumeSkills;
}
