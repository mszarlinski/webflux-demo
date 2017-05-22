package com.github.mszarlinski.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document
public class Movie {

//    @Id
    private String id;

    private String name;
}
