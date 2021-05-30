package kodlamaio.HRMS.core.utilities.adapters.verification.mernis;

import java.time.LocalDate;


public interface MernisCandidateCheckService {
	
	boolean CheckIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate birthDate);
}
