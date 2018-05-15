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

import fr.benoit.mabankService.dao.EpargneRepository;
import fr.benoit.mabankService.domaine.Epargne;

@RestController
@RequestMapping("/epargne")
public class EpargneWebService {

	@Autowired
	private EpargneRepository epargneRepo;

	@PostMapping({ "", "/" })
	Epargne create(@RequestBody Epargne epargne) {
		return this.epargneRepo.save(epargne);
	}

	@DeleteMapping("/{conseillerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer epargneId) {
		this.epargneRepo.deleteById(epargneId);
	}

	@GetMapping({ "", "/" })
	List<Epargne> list() {
		return this.epargneRepo.findAll();
	}

	@GetMapping("/{conseillerId}")
	Epargne read(@PathVariable Integer epargneId) {
		final Optional<Epargne> retour = this.epargneRepo.findById(epargneId);
		if (retour.isPresent()) {
			return retour.get();
		} else {
			return null;
		}
	}

	@PutMapping("/{conseillerId}")
	Epargne update(@PathVariable Integer epargneId, @RequestBody Epargne epargne) {
		if (this.epargneRepo.existsById(epargneId)) {
			return this.epargneRepo.save(epargne);
		} else {
			return null;
		}
	}
}
