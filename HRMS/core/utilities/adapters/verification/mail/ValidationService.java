package kodlamaio.HRMS.core.utilities.adapters.verification.mail;

public interface ValidationService {
	
	boolean sendVerificationCode(String emailAddress, String code);

	String codeGenerator();

}
