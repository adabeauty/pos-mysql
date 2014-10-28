package com.thoughtworks.mysql.Dao;

import com.thoughtworks.mysql.module.Item;
import com.thoughtworks.mysql.module.Promotion;

import java.util.ArrayList;

/**
 * Created by wanghuan on 14-10-26.
 */
public interface PromotionImple {
    Item getPromotionByType(int type);

    void insertPromotion(Promotion promotion);

    void deletePromotion(int type);

    void updatePromotion(int type);

    ArrayList<Item> getPromotion();
}
