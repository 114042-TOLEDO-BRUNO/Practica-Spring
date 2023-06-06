package ar.edu.utn.frc.tup.lciii.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicoyPalaController {
    @GetMapping("/pico")
    public String pala(){
        return "pala";
    }

}
