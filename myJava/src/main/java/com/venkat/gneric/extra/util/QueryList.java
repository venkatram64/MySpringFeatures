package com.venkat.gneric.extra.util;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends QueryItem> {

    private List<T> items;

    public QueryList(List<T> items){
        this.items = items;
    }

    public List<T> getMatches(String field, String value){
        List<T> matches = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    //<T> is different from the class level type "T" , so I can use other say S
    public static <S extends QueryItem> List<S> getMatches(List<S> items,
                                                           String field, String value){
        List<S> matches = new ArrayList<>();
        for(var item : items){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
