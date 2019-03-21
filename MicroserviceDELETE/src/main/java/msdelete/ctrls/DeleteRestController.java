package msdelete.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import msdelete.jpa.Artikl;
import msdelete.jpa.Dobavljac;
import msdelete.jpa.Porudzbina;
import msdelete.jpa.StavkaPorudzbine;
import msdelete.reps.ArtiklRepository;
import msdelete.reps.DobavljacRepository;
import msdelete.reps.PorudzbinaRepository;
import msdelete.reps.StavkaPorudzbineRepository;

@RestController
public class DeleteRestController {
	@Autowired
	private ArtiklRepository artiklRepository;

	@Autowired
	private DobavljacRepository dobavljacRepository;

	@Autowired
	private PorudzbinaRepository porudzbinaRepository;

	@Autowired
	private StavkaPorudzbineRepository stavkaPorudzbineRepository;

	@DeleteMapping("artikl/{id}")
	public ResponseEntity<Artikl> deleteArtikl(@PathVariable("id") Integer id){
		if(artiklRepository.existsById(id)){
			artiklRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("dobavljac/{id}")
	public ResponseEntity<Dobavljac> deleteDobavljac(@PathVariable ("id") Integer id){
		if(!dobavljacRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		dobavljacRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("porudzbina/{id}")
	public ResponseEntity<Porudzbina> deletePorudzbina(@PathVariable ("id") Integer id){
		if(!porudzbinaRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		porudzbinaRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping (value = "stavkaPorudzbine/{id}")
	public ResponseEntity<StavkaPorudzbine> deleteStavkaPorudzbine(@PathVariable("id") Integer id){
		if(!stavkaPorudzbineRepository.existsById(id))
			return new ResponseEntity<StavkaPorudzbine>(HttpStatus.NO_CONTENT);
		stavkaPorudzbineRepository.deleteById(id);
		return new ResponseEntity<StavkaPorudzbine>(HttpStatus.OK);
	}
}
