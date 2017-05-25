package com.github.mszarlinski.webflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "orderOffer")
public class Movie {

    @Id
    private String id;

    @Field("orderId")
    private String name;

    public Movie(String name) {
        this.name = name;
    }
}
