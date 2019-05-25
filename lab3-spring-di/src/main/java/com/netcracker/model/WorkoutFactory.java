package com.netcracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WorkoutFactory {
    public Workout getWorkout(){
        System.out.println("Create workout with factory!");
        return Workout.builder().name("Workout from factory").complexity(4).build();
    }
}
