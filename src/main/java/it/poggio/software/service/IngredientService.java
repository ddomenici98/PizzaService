package it.poggio.software.service;

import it.poggio.software.dao.IngredientRepository;
import it.poggio.software.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredients (){
        List<Ingredient> ingredients = new ArrayList<>();

        //code here

        return ingredients;
    }
}
