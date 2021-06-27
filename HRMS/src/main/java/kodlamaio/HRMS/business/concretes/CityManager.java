package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccesDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CityDao;
import kodlamaio.HRMS.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccesDataResult<List<City>>(this.cityDao.findAll(), "Şehirler listelendi");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccesDataResult<City>(this.cityDao.getById(id));
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir başarıyla eklendi");
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir başarıyla güncellendi");
	}

	@Override
	public Result delete(City city) {
		this.cityDao.delete(city);
		return new SuccessResult("Şehir başarıyla silindi");
	}

}
