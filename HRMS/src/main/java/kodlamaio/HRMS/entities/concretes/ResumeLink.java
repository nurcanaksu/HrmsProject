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
@Table(name="resume_links")
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@JoinColumn(name = "resume_id")
	@ManyToOne
	private Resume resume;
	
	@NotNull
	@Column(name="link_name")
	private String linkName;
	
	@NotNull
	@Column(name="link_url")
	private String linkUrl;

	@NotNull
	@Column(name="is_active")
	private boolean isActive;
	
	@NotNull
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
}
