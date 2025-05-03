package com.example.desafios.desafios.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "pointOfInterest")
public class PointOfInterest {
  @MongoId
  private String id;
  
  private String name;
  
  @Indexed(name = "xAxis_index")
  @Field(targetType = FieldType.INT32)
  private Integer xAxis;
  
  @Indexed(name = "yAxis_index")
  @Field(targetType = FieldType.INT32)
  private Integer yAxis;
  
  public PointOfInterest(String id, String name, Integer xAxis, Integer yAxis) {
    this.id = id;
    this.name = name;
    this.xAxis = xAxis;
    this.yAxis = yAxis;
  }
  
  public PointOfInterest() {
  }
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getxAxis() {
    return xAxis;
  }

  public void setxAxis(Integer xAxis) {
    this.xAxis = xAxis;
  }

  public Integer getyAxis() {
    return yAxis;
  }

  public void setyAxis(Integer yAxis) {
    this.yAxis = yAxis;
  }

}
