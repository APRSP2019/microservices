package get.reps;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import get.jpa.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {
	List<Porudzbina> findByPlacenoTrue();
}
