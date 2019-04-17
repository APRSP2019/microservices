package post.reps;

import org.springframework.data.jpa.repository.JpaRepository;

import post.jpa.StavkaPorudzbine;

public interface StavkaPorudzbineRepository extends JpaRepository<StavkaPorudzbine, Integer> {
//	@Query(value = "select coalesce(max(redni_broj)+1, 1) from stavka_porudzbine where porudzbina = ?1", nativeQuery = true)
//	Integer nextRBr(int porudzbinaId);

}
