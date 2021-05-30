package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
public class Employer extends User {

	@Column(name="company_name")
	private String companyName;

	@Column(name="web_address")
	private String webAddress;

}