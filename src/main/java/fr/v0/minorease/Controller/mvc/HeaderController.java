package fr.v0.minorease.Controller.mvc;

import fr.v0.minorease.entity.Parent;
import fr.v0.minorease.entity.Room;
import fr.v0.minorease.repository.ParentRepository;
import fr.v0.minorease.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class HeaderController {

    private final ParentRepository parentRepository;

    private final RoomRepository roomRepository;

    public HeaderController(ParentRepository parentRepository, RoomRepository roomRepository) {
        this.parentRepository = parentRepository;
        this.roomRepository = roomRepository;
    }


    @GetMapping("/inscriptionparent")
    public String inscriptionP() {
        return "inscriptionparent";
    }

    @GetMapping("/inscriptionenfant")
    public String inscriptionE(Model model) {
        model.addAttribute("activePage", "inscriptionenfant");
        return "inscriptionenfant";
    }


    @GetMapping("/profil")
    public String showProfil(Model model) {
        Optional<Parent> parentOptional = parentRepository.findById(1L);

        if (parentOptional.isPresent()) {
            Parent parent = parentOptional.get();
            model.addAttribute("parent", parent);
        }
        model.addAttribute("activePage", "profil");


        return "profil";
    }



    @GetMapping("/favoris")
    public String showFavoris(Model model) {
        List<Room> favoris = new ArrayList<>();

        // Récupérer les chambres favorites à partir de la base de données (exemples pour les 5 premières chambres)
        List<Long> favorisIds = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        for (Long roomId : favorisIds) {
            Optional<Room> optionalRoom = roomRepository.findById(roomId);
            if (optionalRoom.isPresent()) {
                Room room = optionalRoom.get();
                favoris.add(room);
            }
        }

        model.addAttribute("favoris", favoris);
        model.addAttribute("activePage", "favoris");


        return "favoris";
    }




}

