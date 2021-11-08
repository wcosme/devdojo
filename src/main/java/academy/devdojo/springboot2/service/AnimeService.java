package academy.devdojo.springboot2.service;

import java.util.List;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;

public interface AnimeService {
	
	List<Anime> listAll();
	Anime findById(Long id);	
	Anime save(AnimePostRequestBody animePostRequestBody);
	void delete(Long id);
	void replace(AnimePutRequestBody requestBody);

}
