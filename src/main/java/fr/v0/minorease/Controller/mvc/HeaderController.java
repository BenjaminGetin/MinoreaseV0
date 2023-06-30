package fr.v0.minorease.Controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderController {

    @GetMapping("/room/index")
    public String roomToIndex() {
        return "index";
    }

    @GetMapping("/inscriptionparent")
    public String inscriptionP() {
        return "inscriptionparent";
    }

}

