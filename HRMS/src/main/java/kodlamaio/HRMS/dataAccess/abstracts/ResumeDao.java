package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

	Optional<List<Resume>> getByCandidate_id(int candidateId);
}
