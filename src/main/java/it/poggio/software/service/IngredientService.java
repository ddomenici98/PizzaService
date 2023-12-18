package it.poggio.software.service;

import it.poggio.software.dao.IngredientRepository;
import it.poggio.software.domain.Ingredient;
import it.poggio.software.domain.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    //Ingredients list
    public List<Ingredient> getIngredients () throws CustomException {
            return ingredientRepository.getIngredients();
    }

    public Ingredient getIngredientById (Integer id) throws CustomException {
        return ingredientRepository.getIngredientById(id);
    }

    public Ingredient getIngredientByName (String name) throws CustomException {
        return ingredientRepository.getIngredientByName(name);
    }
}
