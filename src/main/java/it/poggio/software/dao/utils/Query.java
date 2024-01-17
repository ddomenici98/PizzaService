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
    public static final String CHECK_CUSTOMER_EXISTS = "SELECT c.id, c.nome, c.citofono, c.telefono, c.indirizzo, c.cap, c.ordini_effettuati, c.email FROM clienti c WHERE 1=1";
    public static final String AND_CUSTOMER_TELEPHONE = " AND c.telefono = :phone";
    public static final String AND_CUSTOMER_EMAIL = " AND c.email = :email";
    public static final String UPDATE_CUSTOMER = "UPDATE clienti c SET c.id = :id";
    public static final String WHERE_UPDATE_CUSTOMER = " WHERE c.id = :id";
    public static final String UPDATE_CUSTOMER_NAME = ", c.nome = :name";
    public static final String UPDATE_CUSTOMER_INTERCOM = ", c.citofono = :intercom";
    public static final String UPDATE_CUSTOMER_PHONE = ", c.telefono = :phone";
    public static final String UPDATE_CUSTOMER_ADDRESS = ", c.indirizzo = :address";
    public static final String UPDATE_CUSTOMER_POSTALCODE = ", c.cap = :postalCode";
    public static final String UPDATE_CUSTOMER_ORDERS = ", c.ordini_effettuati = :orders";
    public static final String UPDATE_CUSTOMER_EMAIL = ", c.email = :email";

    //order
    public static final String INSERT_ORDER = "INSERT INTO ordini (id_cliente, data_ordine ,orario_richiesto, id_carrello) VALUES (:id_cliente, :data_ordine, :orario_richiesto, :id_carrello)";

    //cart
    public static final String INSERT_CART = "INSERT INTO carrelli (id, prezzo_totale, costo_consegna) VALUES (:id, :prezzo_totale, :costo_consegna)";
}
