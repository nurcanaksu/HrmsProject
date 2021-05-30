package kodlamaio.HRMS.core.utilities.adapters.verification.mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class MernisFakeServiceAdapters implements MernisCandidateCheckService {

	@Override
	public boolean CheckIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate birthDate) {

		return true;
	}

}
