package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Resume;

public interface ResumeService {

	DataResult<List<Resume>> getAll();

	DataResult<Resume> getById(int id);

	DataResult<List<Resume>> getByCandidate_id(int candidateId);

	Result uploadPhoto(int candidateId, MultipartFile file);

	Result add(Resume resume);

	Result delete(Resume resume);

	Result update(Resume resume);

}
