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
@Table(name="resume_job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class ResumeJobExperience { //deneyim
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@JoinColumn(name = "resume_id")
	@ManyToOne
	private Resume resume;
	
	@NotNull
	@JoinColumn(name = "job_positions_id")
	@ManyToOne
	private JobPosition jobPosition;
	
	@NotNull
	@Size(max = 150)
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@PastOrPresent
	@Column(name="start_date")
	private LocalDate startDate;
	
	@PastOrPresent
	@Column(name="finish_date")
	private LocalDate finishDate;

	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
	
	public String getFinishDate() {
        if (this.finishDate == null) {
        	return "Devam ediyor";
        }
        return this.finishDate.toString();
    }
}
