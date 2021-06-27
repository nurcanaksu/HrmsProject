package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.Employee;

public interface EmployeeService {

	DataResult<List<Employee>> getAll();

	DataResult<Employee> getByEmail(String email);

}
