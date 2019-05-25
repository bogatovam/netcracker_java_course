package com.netcracker.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Measurements {
    public List<Integer> repetitions = new ArrayList<Integer>();
}
