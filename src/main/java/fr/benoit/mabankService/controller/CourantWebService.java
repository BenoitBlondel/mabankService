package fr.benoit.mabankService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.benoit.mabankService.dao.CourantRepository;
import fr.benoit.mabankService.domaine.Courant;

@RestController
@RequestMapping("/courant")
public class CourantWebService {

	@Autowired
	private CourantRepository courantRepo;

	@PostMapping({ "", "/" })
	Courant create(@RequestBody Courant courant) {
		return this.courantRepo.save(courant);
	}

	@DeleteMapping("/{conseillerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer courantId) {
		this.courantRepo.deleteById(courantId);
	}

	@GetMapping({ "", "/" })
	List<Courant> list() {
		return this.courantRepo.findAll();
	}

	@GetMapping("/{conseillerId}")
	Courant read(@PathVariable Integer courantId) {
		final Optional<Courant> retour = this.courantRepo.findById(courantId);
		if (retour.isPresent()) {
			return retour.get();
		} else {
			return null;
		}
	}

	@PutMapping("/{conseillerId}")
	Courant update(@PathVariable Integer courantId, @RequestBody Courant courant) {
		if (this.courantRepo.existsById(courantId)) {
			return this.courantRepo.save(courant);
		} else {
			return null;
		}
	}
}
