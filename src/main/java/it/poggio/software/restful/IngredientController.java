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
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value="/list")
    public ResponseEntity<IngredientListResponse> getAllIngredients(){

        ResponseEntity<IngredientListResponse> responseEntity = null;

        IngredientListResponse ingredientListResponse = new IngredientListResponse();


        try {
            List<Ingredient> ingredientList = ingredientService.getIngredients();
            ingredientListResponse.setIngredientList(ingredientList);

            responseEntity = new ResponseEntity<IngredientListResponse>(ingredientListResponse, HttpStatus.OK);
        }catch(CustomException ce){
            ingredientListResponse = new IngredientListResponse(ce.getMessage());
            responseEntity = new ResponseEntity<IngredientListResponse>(ingredientListResponse, ce.getHttpStatus());
        }

        return responseEntity;

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<IngredientResponse> getIngredientById(@PathVariable Integer id){

        ResponseEntity<IngredientResponse> responseEntity = null;

        IngredientResponse ingredientResponse = new IngredientResponse();


        try {
            Ingredient ingredient = ingredientService.getIngredientById(id);
            ingredientResponse.setIngredient(ingredient);

            responseEntity = new ResponseEntity<IngredientResponse>(ingredientResponse, HttpStatus.OK);
        }catch(CustomException ce){
            ingredientResponse = new IngredientResponse(ce.getMessage());
            responseEntity = new ResponseEntity<IngredientResponse>(ingredientResponse, ce.getHttpStatus());
        }

        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<IngredientResponse> getIngredientByName(@RequestParam String name){

        ResponseEntity<IngredientResponse> responseEntity = null;

        IngredientResponse ingredientResponse = new IngredientResponse();


        try {
            Ingredient ingredient = ingredientService.getIngredientByName(name);
            ingredientResponse.setIngredient(ingredient);

            responseEntity = new ResponseEntity<IngredientResponse>(ingredientResponse, HttpStatus.OK);
        }catch(CustomException ce){
            ingredientResponse = new IngredientResponse(ce.getMessage());
            responseEntity = new ResponseEntity<IngredientResponse>(ingredientResponse,ce.getHttpStatus());
        }

        return responseEntity;
    }
}
