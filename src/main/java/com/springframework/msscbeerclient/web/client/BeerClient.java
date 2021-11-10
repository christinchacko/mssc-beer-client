package com.springframework.msscbeerclient.web.client;

import com.springframework.msscbeerclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.beer", ignoreInvalidFields = false)
public class BeerClient {

    private String apihost;
    private final String BEER_PATH = "/api/v1/Beer/";

    private final RestTemplate restTemplate;

    public BeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH + uuid, BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        //return restTemplate.postForLocation(apihost + BEER_PATH, beerDto);

        return restTemplate.postForLocation(apihost + BEER_PATH, beerDto);
    }

    public void updateBeer(BeerDto beerDto){

        restTemplate.put(apihost + BEER_PATH + beerDto.getBeerId(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH + uuid);
    }
}
