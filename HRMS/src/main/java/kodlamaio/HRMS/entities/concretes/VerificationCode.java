package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="user_id")
	private int userId;
	
	@Column(name="verification_code")
	private String verificationCode;

	@Column(name="created_date")
	private LocalDate createdDate;

	@Column(name="expired_date")
	private LocalDate expiredDate;


	@Column(name="verification_date")
	private LocalDate verificationDate;

	@Column(name="is_verified")
	private boolean isVerified;
}