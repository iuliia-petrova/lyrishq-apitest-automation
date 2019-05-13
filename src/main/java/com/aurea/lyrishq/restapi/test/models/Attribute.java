package com.aurea.lyrishq.restapi.test.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Attribute {
    private String name;
    private String[] options;
    private String state;
    private String type;
    private String tcolumn;
    private String trow;
}
