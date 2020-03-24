package com.engg.java.reactive;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {
    @GetMapping
    public String sample() {

        ReqResWebClient webClient = new ReqResWebClient();

        return "<html><body><h1>Java Spring Webclient Example</h1><br><br>" +
                webClient.getResult() + "<br>" +
                webClient.getUser1() + "<br>" +
                webClient.getUser2() +
                "</body></html>";
    }
}
