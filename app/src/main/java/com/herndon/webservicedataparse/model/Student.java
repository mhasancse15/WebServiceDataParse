package com.herndon.webservicedataparse.model;

import java.util.List;

/**
 * Created by Tan on 8/10/2015.
 */
//For Line 1 in JSON File
public class Student {
    public String name;
    public String first;
    public String last;
    public int age;
    public String sex;
    public Boolean registered;
    public List<String> interests;
    public Favorites favorites;
    public List<Skills> skills;

}