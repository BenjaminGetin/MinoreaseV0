package fr.v0.minorease.Controller.mvc;

import fr.v0.minorease.entity.Parent;
import fr.v0.minorease.repository.ParentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HeaderController {

    private final ParentRepository parentRepository;

    public HeaderController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @GetMapping("/room/index")
    public String roomToIndex() {
        return "index";
    }

    @GetMapping("/inscriptionparent")
    public String inscriptionP() {
        return "inscriptionparent";
    }

    @GetMapping("/inscriptionenfant")
    public String inscriptionE() {
        return "inscriptionenfant";
    }


    @GetMapping("/profil")
    public String showProfil(Model model) {
        Optional<Parent> parentOptional = parentRepository.findById(1L);

        if (parentOptional.isPresent()) {
            Parent parent = parentOptional.get();
            model.addAttribute("parent", parent);
        }

        return "profil";
    }



    @GetMapping("/favoris")
    public String showFavoris() {
        return "favoris";
    }





}

