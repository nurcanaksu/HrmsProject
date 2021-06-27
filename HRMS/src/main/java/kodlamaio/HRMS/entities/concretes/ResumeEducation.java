package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="resume_educations")
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name = "resume_id")
	@ManyToOne
	private Resume resume;
	
	@NotNull
	@Size(max = 150)
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@Size(max = 150)
	@Column(name="department_name")
	private String departmentName;
	
	@NotNull
	@PastOrPresent
	@Column(name="start_date")
	private LocalDate startDate;
	
	@PastOrPresent
	@Column(name="graduation_date")
	private LocalDate graduationDate;
	
	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
	
	public String getGraduationDate() {
        if (this.graduationDate == null) {
        	return "Devam ediyor";
        }
        return this.graduationDate.toString();
    }
}
