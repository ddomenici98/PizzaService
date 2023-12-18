package it.poggio.software.restful;

import it.poggio.software.domain.Ingredient;
import it.poggio.software.domain.exception.CustomException;
import it.poggio.software.domain.exception.response.IngredientListResponse;
import it.poggio.software.domain.exception.response.IngredientResponse;
import it.poggio.software.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    //Ingredients list
    @GetMapping
    public @ResponseBody HttpEntity<IngredientListResponse> getAllIngredients(){

        HttpEntity<IngredientListResponse> httpEntity = null;

        IngredientListResponse ingredientListResponse = new IngredientListResponse();


        try {
            List<Ingredient> ingredientList = ingredientService.getIngredients();
            ingredientListResponse.setIngredientList(ingredientList);

            httpEntity = new HttpEntity<>(ingredientListResponse);
        }catch(CustomException ce){
            ingredientListResponse = new IngredientListResponse(ce.getHttpStatus(),ce.getMessage());
            httpEntity = new HttpEntity<>(ingredientListResponse);
        }

        return httpEntity;

    }
}
