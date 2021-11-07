package academy.devdojo.springboot2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;

@SpringBootApplication
public class Springboot2EssentialsApplication implements CommandLineRunner {
	
	@Autowired
	private AnimeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Springboot2EssentialsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Anime anime1 = new Anime(null, "DBZ");
		Anime anime2 = new Anime(null, "ThunderCat");
		
		repository.saveAll(Arrays.asList(anime1, anime2));
		
	}

}
