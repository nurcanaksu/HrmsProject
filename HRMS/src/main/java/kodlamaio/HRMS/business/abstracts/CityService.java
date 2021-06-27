package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();

	DataResult<City> getById(int id);

	Result add(City city);

	Result update(City city);

	Result delete(City city);
}
