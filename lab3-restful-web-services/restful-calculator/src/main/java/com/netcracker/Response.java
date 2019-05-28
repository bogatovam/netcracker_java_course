package com.netcracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Response {
    public static enum Operations {
        ADD,
        SUB,
        MULT,
        DIV
    }
    List<Double> numbers;
    Operations ops;
    Double result;
}
