package org.mai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showMapPage() {
        return "map"; // map.html в /templates
    }
}

