package io.kebomusic.courseapidatastarter.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/")
    public String greeting() {
        return "Welcome";
    }

    @GetMapping("/menu")
    public String getMenu() {
        return "Menu";
    }
}
