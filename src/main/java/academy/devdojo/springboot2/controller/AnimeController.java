package academy.devdojo.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api/v1/animes")
@Log4j2
public class AnimeController {
	
	@Autowired
	private DateUtil dateUtil;
	
	@Autowired
	private AnimeService service;
	
	@GetMapping
	public ResponseEntity<List<Anime>> list(){
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
		
	}
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime){
		return new ResponseEntity<>(service.save(anime), HttpStatus.CREATED);
	}
}
