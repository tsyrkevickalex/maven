package org.example.io.xlsx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String model;
    private double price;
    private Date date;

}
