package post.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import post.FeignRepository;
import post.jpa.Artikl;
import post.jpa.Dobavljac;
import post.jpa.Porudzbina;
import post.jpa.StavkaPorudzbine;
import post.reps.ArtiklRepository;
import post.reps.DobavljacRepository;
import post.reps.PorudzbinaRepository;
import post.reps.StavkaPorudzbineRepository;

@RestController
public class PostRestController {
	@Autowired
	private FeignRepository feign;
	
	@Autowired
	private ArtiklRepository artiklRepository;

	@Autowired
	private DobavljacRepository dobavljacRepository;

	@Autowired
	private PorudzbinaRepository porudzbinaRepository;

	@Autowired
	private StavkaPorudzbineRepository stavkaPorudzbineRepository;

	@PostMapping("artikl")
	public ResponseEntity<Artikl> insertArtikl(@RequestBody Artikl artikl) {
		if (artiklRepository.existsById(artikl.getId()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		artiklRepository.save(artikl);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("dobavljac")
	public ResponseEntity<Dobavljac> insertDobavljac(@RequestBody Dobavljac dobavljac) {
		if (dobavljacRepository.existsById(dobavljac.getId()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		dobavljacRepository.save(dobavljac);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("porudzbina")
	public ResponseEntity<Porudzbina> insertPorudzbina(@RequestBody Porudzbina porudzbina) {
		if (porudzbinaRepository.existsById(porudzbina.getId()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		porudzbinaRepository.save(porudzbina);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("stavkaPorudzbine")
	public ResponseEntity<StavkaPorudzbine> insertStavkaPorudzbine(@RequestBody StavkaPorudzbine stavkaPorudzbine) {
		if (stavkaPorudzbineRepository.existsById(stavkaPorudzbine.getId()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		stavkaPorudzbine.setRedniBroj(feign.redniBroj(stavkaPorudzbine.getPorudzbinaBean().getId()));
		stavkaPorudzbineRepository.save(stavkaPorudzbine);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
