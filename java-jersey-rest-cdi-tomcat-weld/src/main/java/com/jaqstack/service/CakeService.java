package com.jaqstack.service;

import com.jaqstack.models.Cake;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 * Service that provides calculations
 *
 * @author Suren Konathala
 */
@ApplicationScoped
public class CakeService implements Serializable {

    private Cake cake;

    @PostConstruct
    public void init() {
        cake = new Cake();
    }

    public Double calculatePrice(Cake cake) {
        Double price=new Double(0);

        if (cake.getFlavor().equals("vailla")) {
            price += 10;
        } else if (cake.getFlavor().equals("choclate")) {
            price += 20;
        }

        if (cake.getModel().equals("A")) {
            price += 10;
        } else if (cake.getModel().equals("B")) {
            price += 20;
        }

        return price;
    }
}
