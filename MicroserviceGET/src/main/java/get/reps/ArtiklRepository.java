package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Artikl;

public interface ArtiklRepository extends JpaRepository<Artikl, Integer> {
	Collection<Artikl> findByNazivContainingIgnoreCase (String name);
}
