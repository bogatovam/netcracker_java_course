package com.netcracker.model;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduledWorkout extends Workout {
    private Date date = new Date();
    private String comment;
}
