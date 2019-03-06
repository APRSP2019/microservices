package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Dobavljac;

public interface DobavljacRepository extends JpaRepository<Dobavljac, Integer> {
	Collection<Dobavljac> findByNazivContainingIgnoreCase (String name);
}
