package com.cn.tacocloud2021.dao;

import com.cn.tacocloud2021.entity.Ingredient;
import com.cn.tacocloud2021.entity.Taco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/30 18:43
 **/
@Repository
public class JdbcTacoRepository implements TacoRepository {
    private JdbcTemplate jdbc;
    public JdbcTacoRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    @Override
    public Taco save(Taco taco) {
        //返回tacoId
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for(Ingredient ingredient : taco.getIngredients()){
            saveIngredientToTaco(ingredient,tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco){
        taco.setCreatedAt(new Date());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                        "insert into Taco(name,createdAt) values(?,?)",
                        Types.VARCHAR,Types.TIMESTAMP
                ).newPreparedStatementCreator(Arrays.asList(taco.getName(),
                                new Timestamp(taco.getCreatedAt().getTime())));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc,keyHolder);
        return keyHolder.getKey().longValue();
    }
    //保存Taco_Ingredients表
    private void saveIngredientToTaco(Ingredient ingredient,long tacoId){
        jdbc.update("insert into Taco_Ingredients values(?,?)",
                tacoId,ingredient.getId());
    }
}
