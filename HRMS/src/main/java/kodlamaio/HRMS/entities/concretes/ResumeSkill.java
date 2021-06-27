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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="resume_skills")
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name = "resume_id")
	@ManyToOne
	private Resume resume;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
}