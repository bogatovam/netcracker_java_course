package com.netcracker.model;

import lombok.Data;

@Data
public class DefaultWorkout {
    private String name = "SpEL name";
    private int complexity = 5;
    private WorkoutComplex sourceWorkoutComplex = WorkoutComplex.builder()
            .name("spelworkoutComplex").build();
}
