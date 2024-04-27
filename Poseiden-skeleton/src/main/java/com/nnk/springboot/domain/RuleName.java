package com.nnk.springboot.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rulename")
public class RuleName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String json;
    private String template;
    private String sqlStr;
    private String sqlPart;

    /*public RuleName(String rule_name, String description, String json, String template, String sql, String sql_part) {
    }*/
}
