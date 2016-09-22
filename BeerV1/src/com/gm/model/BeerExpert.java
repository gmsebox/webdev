package com.gm.model;

import java.util.*;

public class BeerExpert{
    public List <String> getBrands(String color){
        List <String> brands = new ArrayList<String>();
        if(color.equalsIgnoreCase("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }else if (color.equalsIgnoreCase("light")){
            brands.add("Light Ale");
            brands.add("Super light ale");
        }
        else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}