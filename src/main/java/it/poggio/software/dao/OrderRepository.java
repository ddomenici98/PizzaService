package it.poggio.software.dao;

import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertOrder(Integer idCliente, Date date, Time time) throws CustomException {

        String sql = "INSERT INTO ordini (id_cliente, data_ordine ,orario_richiesto) VALUES (:id_cliente, :data_ordine, :orario_richiesto)";
        Map<String,Object> params = new HashMap<>();
        params.put("id_cliente",idCliente);
        params.put("data_ordine",date);
        params.put("orario_richiesto",time);

        namedParameterJdbcTemplate.update(sql,params);
    }


}
