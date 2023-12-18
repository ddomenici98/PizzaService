package it.poggio.software.restful;

import it.poggio.software.domain.Ingredient;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.domain.response.IngredientListResponse;
import it.poggio.software.domain.response.IngredientResponse;
import it.poggio.software.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    //Ingredients list
    @GetMapping
    public @ResponseBody HttpEntity<IngredientListResponse> getAllIngredients(){

        HttpEntity<IngredientListResponse> httpEntity = null;

        IngredientListResponse ingredientListResponse = new IngredientListResponse();


        try {
            List<Ingredient> ingredientList = ingredientService.getIngredients();
            ingredientListResponse.setIngredientList(ingredientList);
            ingredientListResponse.setStatus(HttpStatus.OK);

            httpEntity = new HttpEntity<>(ingredientListResponse);
        }catch(CustomException ce){
            ingredientListResponse = new IngredientListResponse(ce.getHttpStatus(),ce.getMessage());
            httpEntity = new HttpEntity<>(ingredientListResponse);
        }

        return httpEntity;

    }

    @GetMapping(value="/{id}")
    public @ResponseBody HttpEntity<IngredientResponse> getIngredientById(@PathVariable Integer id){

        HttpEntity<IngredientResponse> httpEntity = null;

        IngredientResponse ingredientResponse = new IngredientResponse();


        try {
            Ingredient ingredient = ingredientService.getIngredientById(id);
            ingredientResponse.setIngredient(ingredient);
            ingredientResponse.setStatus(HttpStatus.OK);

            httpEntity = new HttpEntity<>(ingredientResponse);
        }catch(CustomException ce){
            ingredientResponse = new IngredientResponse(ce.getHttpStatus(),ce.getMessage());
            httpEntity = new HttpEntity<>(ingredientResponse);
        }

        return httpEntity;

    }
}
