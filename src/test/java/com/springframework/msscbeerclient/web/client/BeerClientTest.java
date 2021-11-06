package com.springframework.msscbeerclient.web.client;

import com.springframework.msscbeerclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = beerClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerId(UUID.randomUUID())
                .beerName("KF")
                .build();

        URI uri = beerClient.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void UpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerId(UUID.randomUUID())
                .beerName("Corona")
                .beerStyle("WHEAT")
                .build();

        beerClient.updateBeer(beerDto);
    }

    @Test
    void deleteBeer() {
        beerClient.deleteBeer(UUID.randomUUID());
    }
}