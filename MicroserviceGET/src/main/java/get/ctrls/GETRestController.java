package get.ctrls;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import get.jpa.Artikl;
import get.jpa.Dobavljac;
import get.jpa.Porudzbina;
import get.jpa.StavkaPorudzbine;
import get.reps.ArtiklRepository;
import get.reps.DobavljacRepository;
import get.reps.PorudzbinaRepository;
import get.reps.StavkaPorudzbineRepository;

@RestController
public class GETRestController {

	@Autowired
	private ArtiklRepository artiklRepository;
	
	@Autowired
	private DobavljacRepository dobavljacRepository;
	
	@Autowired
	private PorudzbinaRepository porudzbinaRepository;
	
	@Autowired
	private StavkaPorudzbineRepository stavkaPorudzbineRepository;

	@GetMapping("artikl")
	public Collection<Artikl> getArtikli(){
		return artiklRepository.findAll();
	}
	
	@GetMapping("artikl/{id}")
	public Artikl getArtikl(@PathVariable ("id") Integer id){
		return artiklRepository.getOne(id);
	}
	
	@GetMapping("artiklNaziv/{naziv}")
	public Collection<Artikl> getArtiklByNaziv(@PathVariable ("naziv") String naziv){
		return artiklRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("dobavljac")
	public Collection<Dobavljac> getDobavljaci(){
		return dobavljacRepository.findAll();
	}
	
	@GetMapping("dobavljac/{id}")
	public ResponseEntity<Dobavljac> getDobavljac(@PathVariable("id") Integer id){
		Dobavljac dobavljac = dobavljacRepository.getOne(id);
		return new ResponseEntity<Dobavljac>(dobavljac,HttpStatus.OK);
	}
	
	@GetMapping("dobavljacNaziv/{naziv}")
	public Collection<Dobavljac> getDobavljac(@PathVariable("naziv") String naziv){
		return dobavljacRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("porudzbina")
	public Collection<Porudzbina> getPorudzbine(){
		return porudzbinaRepository.findAll();
	}
	
	@GetMapping("porudzbina/{id}")
	public ResponseEntity<Porudzbina> getPorudzbina(@PathVariable("id") Integer id){
		Porudzbina porudzbina = porudzbinaRepository.getOne(id);
		return new ResponseEntity<Porudzbina>(porudzbina,HttpStatus.OK);
	}
	
	@GetMapping("porudzbinaPlaceno")
	public List<Porudzbina> getPlacenePorudzbine(){
		return  porudzbinaRepository.findByPlacenoTrue();
	}
	
	@RequestMapping(value = "stavkaPorudzbine", method = RequestMethod.GET)
	public Collection<StavkaPorudzbine> getStavkePorudzbine(){
		return stavkaPorudzbineRepository.findAll();
	}
	
	@RequestMapping(value = "stavkaPorudzbine/{id}", method = RequestMethod.GET)
	public ResponseEntity<StavkaPorudzbine> getStavkaPorudzbine(@PathVariable("id") Integer id){
		StavkaPorudzbine stavkaPorudzbine = stavkaPorudzbineRepository.getOne(id);
		return new ResponseEntity<StavkaPorudzbine>(stavkaPorudzbine,HttpStatus.OK);
	}
	
	@RequestMapping(value = "stavkeZaPorudzbina/{id}", method = RequestMethod.GET)
	public Collection<StavkaPorudzbine> stavkaPoPorudzbiniId(@PathVariable("id") int id){
		Porudzbina p = porudzbinaRepository.getOne(id);
		return stavkaPorudzbineRepository.findByPorudzbina(p);
	}
	
}
