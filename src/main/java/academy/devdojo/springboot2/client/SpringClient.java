package academy.devdojo.springboot2.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import academy.devdojo.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringClient {
	
	public static void main(String[] args) {
		
		ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/api/v1/animes/10", Anime.class);		
		log.info(entity);
		
		Anime anime = new RestTemplate().getForObject("http://localhost:8080/api/v1/animes/10", Anime.class);
		log.info(anime);		
		
	}

}
