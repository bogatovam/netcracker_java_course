package com.netcracker.model;

import lombok.*;

import java.util.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    private String name;
    private int complexity;
    private WorkoutComplex sourceWorkoutComplex;
    private Set<Exercise> exerciseList = new HashSet<Exercise>();
    private Map<Exercise, Measurements> exerciseMeasurementMap = new HashMap<Exercise, Measurements>();

    public Workout(WorkoutComplex sourceWorkoutComplex) {
        this.sourceWorkoutComplex = sourceWorkoutComplex;
    }

    public Workout(String name, int complexity, WorkoutComplex sourceWorkoutComplex) {
        this.name = name;
        this.complexity = complexity;
        this.sourceWorkoutComplex = sourceWorkoutComplex;

        System.out.println("I construct workout with: name=" + name
                + ", complexity=" + complexity
                + ", sourceWorkoutComplex=" + sourceWorkoutComplex.toString());
    }

    public void setName(String name) {
        System.out.println("Set name \"" + name + "\"of workout");
        this.name = name;
    }

    public void setComplexity(int complexity) {
        System.out.println("Set complexity \"" + complexity + "\"of workout");
        this.complexity = complexity;
    }

    public void setSourceWorkoutComplex(WorkoutComplex sourceWorkoutComplex) {
        System.out.println("Set sourceWorkoutComplex \"" + sourceWorkoutComplex.toString() + "\"of workout");
        this.sourceWorkoutComplex = sourceWorkoutComplex;
    }

    public void setExerciseList(Set<Exercise> exerciseList) {
        System.out.println("Set exerciseList \"" + exerciseList.toString() + "\"of workout");
        this.exerciseList = exerciseList;
    }

    public void setExerciseMeasurementMap(Map<Exercise, Measurements> exerciseMeasurementMap) {
        System.out.println("Set exerciseMeasurementMap \"" + exerciseMeasurementMap.toString() + "\"of workout");
        this.exerciseMeasurementMap = exerciseMeasurementMap;
    }
}
