package com.itproger.diplomsb.controllers;

import com.itproger.diplomsb.models.Reference;
import com.itproger.diplomsb.repo.ItemRepository;
import com.itproger.diplomsb.repo.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String index(@RequestParam(name = "error", defaultValue = "", required = false)
                            String error, Model model) {
        if(error.equals("shortref")) {
            model.addAttribute("error", "Такое сокращение существует");
        } else if (error.equals("empty")) {
            model.addAttribute("error", "Введите сокращение");
        }

        Iterable<Reference> references = referenceRepository.findAll();
        model.addAttribute("items", references);
        return "index";
    }

    @GetMapping("/about-us")
    public String about(@RequestParam(name = "userName", required = false, defaultValue = "World") String userName, Model model) {
        model.addAttribute("name", userName);
        return "about";
    }

    // Получаем данные из input-полей
    @PostMapping("/")
    public String store(@RequestParam String shortref, @RequestParam String fullref) {
        // Проверяем, есть ли уже такой пользователь
        if(itemRepository.findByShortref(shortref) != null) {
//            return "redirect:/about-us";
            return "redirect:/?error=shortref";
        } else if (shortref == "" || shortref == null) {
            return "redirect:/?error=empty";
        } else {
            Reference reference = new Reference(shortref, fullref);
            referenceRepository.save(reference);
            return "redirect:/";
        }
    }
}
