package put.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import put.jpa.Artikl;
import put.jpa.Dobavljac;
import put.jpa.Porudzbina;
import put.jpa.StavkaPorudzbine;
import put.reps.ArtiklRepository;
import put.reps.DobavljacRepository;
import put.reps.PorudzbinaRepository;
import put.reps.StavkaPorudzbineRepository;

@RestController
public class PUTRestController {
	@Autowired
	private ArtiklRepository artiklRepository;
	
	@Autowired
	private DobavljacRepository dobavljacRepository;
	
	@Autowired
	private PorudzbinaRepository porudzbinaRepository;
	
	@Autowired
	private StavkaPorudzbineRepository stavkaPorudzbineRepository;

	@PutMapping("artikl")
	public ResponseEntity<Artikl> updateArtikl(@RequestBody Artikl artikl){
		if(!artiklRepository.existsById(artikl.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		artiklRepository.save(artikl);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("dobavljac")
	public ResponseEntity<Dobavljac> updateDobavljac(@RequestBody Dobavljac dobavljac){
		if(!dobavljacRepository.existsById(dobavljac.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		dobavljacRepository.save(dobavljac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("porudzbina")
	public ResponseEntity<Porudzbina> updatePorudzbina(@RequestBody Porudzbina porudzbina){
		if(!porudzbinaRepository.existsById(porudzbina.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		porudzbinaRepository.save(porudzbina);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("stavkaPorudzbine")
	public ResponseEntity<StavkaPorudzbine> updateStavkaPorudzbine(@RequestBody StavkaPorudzbine stavkaPorudzbine){
		if(!stavkaPorudzbineRepository.existsById(stavkaPorudzbine.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		stavkaPorudzbineRepository.save(stavkaPorudzbine);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
