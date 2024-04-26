package com.nnk.springboot.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;
  private  String moodysRating;
  private  String sandPRating;
  private  String fitchRating;
  private  Integer orderNumber;

    /*public Rating(String moodys_rating, String sand_pRating, String fitch_rating, int i) {
    }*/
}
