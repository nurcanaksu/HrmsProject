package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String titleName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@OneToMany(mappedBy="jobPosition")
	private List<JobPosting> jobPostings;
	
}
