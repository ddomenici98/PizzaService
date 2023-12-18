package it.poggio.software.dao.utils;

public class Query {

    //ingredients
    public static final String INGREDIENT_LIST= "SELECT i.id, i.nome, i.prezzo, i.disponibile FROM ingredienti i";
    public static final String INGREDIENT_BYID= "SELECT i.id, i.nome, i.prezzo, i.disponibile FROM ingredienti i WHERE i.id=:id";
    public static final String INGREDIENT_BYNAME= "SELECT i.id, i.nome, i.prezzo, i.disponibile FROM ingredienti i WHERE i.nome=:name";
    //pizze
    public static final String GET_PIZZA_FROM_ID = "SELECT p.id, p.nome, p.prezzo, p.descrizione, c.nome AS nomeCategoria  FROM pizze p JOIN categorie c ON p.id_categoria = c.id WHERE p.id = :id";
    public static final String GET_PIZZA_FROM_NAME = "SELECT p.id, p.nome, p.prezzo, p.descrizione, c.nome AS nomeCategoria  FROM pizze p JOIN categorie c ON p.id_categoria = c.id WHERE p.nome = :name";
    public static final String GET_PIZZE = "SELECT p.id, p.nome, p.prezzo, p.descrizione, c.nome AS nomeCategoria  FROM pizze p JOIN categorie c ON p.id_categoria = c.id";
}
