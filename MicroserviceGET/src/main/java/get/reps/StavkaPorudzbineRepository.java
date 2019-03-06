package get.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Porudzbina;
import get.jpa.StavkaPorudzbine;

public interface StavkaPorudzbineRepository extends JpaRepository<StavkaPorudzbine, Integer> {
	Collection<StavkaPorudzbine> findByPorudzbina(Porudzbina p);
}
