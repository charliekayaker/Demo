package com.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Persona {

    private String nombre;
    private List<Lugar> lugares;

    public Persona(){
        lugares = new ArrayList<>();
    }
}
