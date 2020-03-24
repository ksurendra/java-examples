package com.engg.java.reactive;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import com.engg.java.reactive.reqres.User;

public class ReqResWebClient {
    private WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

    private Mono<ClientResponse> responseMono = webClient.get()
            .uri("/todos/1")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    public String getResult() {
        return ">> Result Mono<ClientResponse> = " + responseMono.flatMap(res -> res.bodyToMono(String.class)).block();
    }

    public Flux<User> listUser1() {
        return webClient.get()
                .uri("/todos/1")
                .retrieve()
                .bodyToFlux(User.class);
    }

    public String getUser1() {
        return ">> Get Flux<User> retrieve() example = " + listUser1().collectList().doOnNext(l1 -> System.out.println("PRINT 1=" + l1)).subscribe();
    }

    public Flux<User> listUser2() {
        return webClient.get()
                .uri("/todos/1")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(User.class));
    }

    public String getUser2() {
        //return ">> Get Users 2= " + listUsers2();
        return ">> Get Flux<User> exchange() example = " + listUser2().collectList().doOnNext(l2 -> System.out.println("PRINT 2=" + l2)).subscribe();
    }

}

