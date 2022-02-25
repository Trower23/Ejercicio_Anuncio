package Ejercicio_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnlaceController {

    @GetMapping("/enlace")
    public String enlace(Model model, @RequestParam String nenlace){
        model.addAttribute("num",nenlace);

        return "enlace_templace";
    }
    /*
    @GetMapping("/enlace/{nenlace}")
    public String enlace(Model model, @PathVariable String nenlace){
        model.addAttribute("num",nenlace);

        return "enlace_templace";
    }
    */

}
