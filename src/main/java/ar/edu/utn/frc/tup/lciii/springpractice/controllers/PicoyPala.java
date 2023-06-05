package ar.edu.utn.frc.tup.lciii.springpractice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicoyPala {
    @GetMapping("/pico")
    public String pala(){
        return "pala";
    }

}
