package com.netcracker.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutComplex {
    private String name;
    private List<Workout> workoutList = new ArrayList<Workout>();

    private static final WorkoutComplex obj = WorkoutComplex.builder().name("Workout complex from factory").build();

    public static WorkoutComplex getWorkoutComplex() {
        System.out.println("Factory method: getWorkoutComplex");
        return obj;
    }
}
