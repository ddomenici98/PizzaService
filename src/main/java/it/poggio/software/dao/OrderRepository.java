package it.poggio.software.dao;

import it.poggio.software.dao.mapper.CustomerMapper;
import it.poggio.software.dao.mapper.OrderMapper;
import it.poggio.software.domain.Order;
import it.poggio.software.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static it.poggio.software.dao.utils.Query.GET_ORDER;

@Slf4j
@Repository
public class OrderRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertOrder(Order order) throws CustomException {

        String sql = "INSERT INTO ordini (id_cliente, data_ordine ,orario_richiesto) VALUES (:id_cliente, :data_ordine, :orario_richiesto)";
        Map<String,Object> params = new HashMap<>();
        params.put("id_cliente",order.getCustomer().getId());
        params.put("data_ordine",order.getDate());
        params.put("orario_richiesto",order.getRequestedTime());

        namedParameterJdbcTemplate.update(sql,params);
    }

    public Order getOrder(Integer id){
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);

        Order order = namedParameterJdbcTemplate.queryForObject(GET_ORDER, params, new OrderMapper());

        return order;
    }


}
