package academy.devdojo.springboot2.service;

import java.util.List;

import academy.devdojo.springboot2.domain.Anime;

public interface AnimeService {
	
	List<Anime> listAll();

	Anime findById(Long id);
	
	Anime save(Anime anime);

}
