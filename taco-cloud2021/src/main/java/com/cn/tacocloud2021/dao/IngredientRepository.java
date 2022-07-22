package com.cn.tacocloud2021.dao;

import com.cn.tacocloud2021.entity.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
