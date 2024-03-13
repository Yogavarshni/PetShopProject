package com.example.petproject;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "petstore")
public class Petproject {

    @Id
    private String Id;

    @Field(type=FieldType.Text, name="image")
    private String image;

    @Field(type=FieldType.Text, name="breed")
    private String breed;

    @Field(type=FieldType.Text, name="type")
    private String type;
    
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        this.Id = id;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return "Petproject [Id=" + Id + ", image=" + image + ", breed=" + breed + ", type=" + type + "]";
    }
}
