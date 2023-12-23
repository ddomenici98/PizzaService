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

    //customers
    public static final String INSERT_CUSTOMER = "INSERT INTO clienti(nome, citofono, telefono, indirizzo, cap, email) VALUES(:name, :intercom, :phone, :address, :postalCode, :email)";

    //order
    public static final String GET_ORDER = "SELECT *, cat.nome AS nomeCategoria FROM ordini o JOIN clienti c ON o.id_cliente=c.id JOIN carrelli car ON o.id_carrello=car.id JOIN selezioni s ON s.id_carrello=car.id JOIN pizze p ON p.id=s.id_pizza JOIN categorie cat ON p.id_categoria=cat.id JOIN aggiunte a ON s.id=a.id_selezione JOIN  ingredienti i ON i.id=a.id_ingrediente WHERE o.id=:id";
}
