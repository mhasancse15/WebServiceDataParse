package com.herndon.webservicedataparse;

import com.herndon.webservicedataparse.model.Student;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface StudentService {
  //  /So these are the list available in our WEB API and the methods look straight forward

    @GET("/Array.txt")
    public void getArray(Callback<List<String>> items);

    @GET("/ArrayWithObjects.txt")
    public void getArrayWithObjects(Callback<List<Student>> callback);

    @GET("/Object.txt")
    public void getObject(Callback<Student> student);

    @GET("/ObjectWithNestedArray.txt")
    public void getObjectWithNestedArray(Callback<Student> student);

    @GET("/ObjectWithNestedObject.txt")
    public void getObjectWithNestedObject(Callback<Student> student);

    @GET("/ObjectWithNestedArraysAndObject.txt")
    public void getObjectWithNestedArraysAndObject(Callback<Student> student);
}
