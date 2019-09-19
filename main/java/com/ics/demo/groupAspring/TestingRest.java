package com.ics.demo.groupAspring;

import com.ics.demo.groupAspring.models.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TestingRest implements CommandLineRunner {

    private final FeignRestClient feignRestClient;
    public TestingRest(FeignRestClient feignRestClient){

        this.feignRestClient = feignRestClient;
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Movie>> response = restTemplate.exchange(
                "http://10.51.10.111:9090/movies",
                HttpMethod.GET,
                null,
        new ParameterizedTypeReference<List<Movie>>(){});
        List<Movie> movies = response.getBody();
        System.out.println(movies.toString());

        Movie newMovie = new Movie("We wacha bana", "1900");
        newMovie = feignRestClient.createMovie(newMovie);
        System.out.println("Created movie:"+newMovie.toString());

        newMovie.setName("Ranguloz");
        feignRestClient.updateMovie(newMovie.getId(),newMovie);

        Movie movie = restTemplate.getForObject("http://10.51.10.111:9090/movies/3",Movie.class);
        System.err.println(movie.toString());

        String url = "http://10.51.10.111:9090/movies/search?name="+movie.getName();
        Movie movieByName = restTemplate.getForObject(url,Movie.class);
        System.err.println(movieByName.toString());

        movies = feignRestClient.getAllMovies();
        System.err.println(movies.toString());
    }


}
