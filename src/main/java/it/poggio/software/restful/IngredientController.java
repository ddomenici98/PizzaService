package it.poggio.software.restful;

import it.poggio.software.domain.Ingredient;
import it.poggio.software.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public @ResponseBody  List<Ingredient> getAllIngredients() {

        return ingredientService.getIngredients();

    }
}
