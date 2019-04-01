package com.divinkas.example.daggertextproj.viewModel;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<MenuViewModel> getList(){
        List<MenuViewModel> list = new ArrayList<>();

        MenuViewModel item1 = new MenuViewModel();
        item1.setId(1);
        item1.setName("Salmon Teriyaki");
        item1.setDescription("Roasted salon dumped in soa sauce and mint");
        item1.setPrice(140);
        item1.setThumbnail("https://api.androidhive.info/images/food/1.jpg");

        MenuViewModel item2 = new MenuViewModel();
        item2.setId(2);
        item2.setName("Grilled Mushroom and Vegetables");
        item2.setDescription("Spcie grills mushrooms, cucumber, apples and lot more");
        item2.setPrice(150);
        item2.setThumbnail("https://api.androidhive.info/images/food/2.jpg");

        MenuViewModel item3 = new MenuViewModel();
        item3.setId(3);
        item3.setName("Chicken Overload Meal");
        item3.setDescription("Grilled chicken & tandoori chicken in masala curry");
        item3.setPrice(165);
        item3.setThumbnail("https://api.androidhive.info/images/food/3.jpg");

        list.add(item1);
        list.add(item2);
        list.add(item3);

        return list;
    }
}
