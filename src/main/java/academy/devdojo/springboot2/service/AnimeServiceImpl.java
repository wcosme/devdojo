package academy.devdojo.springboot2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Anime;

@Service
public class AnimeServiceImpl implements AnimeService {
	
	private static List<Anime> animes = List.of(new Anime(1L, "DBZ"), new Anime(2L, "Bersek"));
	
	@Override
	public List<Anime> listAll() {
		
		return animes;
	}

	@Override
	public Anime findById(Long id) {
		
		return animes.stream()
				.filter(anime -> anime.getId().equals(id))
				.findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found."));
	}
	
	public Anime save(Anime anime){		
		
		return null;
		
	}
}
