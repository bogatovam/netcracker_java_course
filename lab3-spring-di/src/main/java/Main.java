import com.netcracker.model.ScheduledWorkout;
import com.netcracker.model.Workout;
import com.netcracker.model.WorkoutComplex;
import com.netcracker.model.WorkoutFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        System.out.println("\n---------------------Task #1---------------------\n");
        Workout workout1 = (Workout) context.getBean("workout1");
        System.out.println("Workout1 (constructor): " + workout1);
        Workout workout2 = (Workout) context.getBean("workout2");
        System.out.println("Workout2 (get)        : " + workout2);


        System.out.println("\n---------------------Task #2---------------------\n");
        Workout workout3 = (Workout) context.getBean("workout3");
        System.out.println("Workout3 with Collections: " + workout3);

        System.out.println("\n---------------------Task #3---------------------\n");
        ScheduledWorkout scheduledWorkout = (ScheduledWorkout) context.getBean("scheduled-workout");
        System.out.println("ScheduledWorkout (using paren bean): " + scheduledWorkout.toString());

        System.out.println("\n---------------------Task #4---------------------\n");
        Workout workout4 = (Workout) context.getBean("spelWorkout");
        System.out.println("Spel Workout: " + workout4.toString());

        System.out.println("\n---------------------Task #5---------------------\n");
        Workout workout5 = (Workout) context.getBean("autowireWorkout1");
        System.out.println("autowireWorkout ByName: " + workout5.toString());
        Workout workout6 = (Workout) context.getBean("autowireWorkout2");
        System.out.println("autowireWorkout with constructor: " + workout6.toString());

        System.out.println("\n---------------------Task #6---------------------\n");
        WorkoutComplex workoutComplex1 = (WorkoutComplex) context.getBean("workoutComplexFromFactory");
        System.out.println("Factory workoutComplex: " + workoutComplex1.toString());

        Workout workout7 = (Workout) context.getBean("workoutFromFactory");
        System.out.println("Factory workout: " + workout7.toString());

        WorkoutFactory workoutFactory = (WorkoutFactory) context.getBean("lookupFactoryWorkout");
        System.out.println("Workout from lookupFactoryWorkout: "+workoutFactory.getWorkout().toString());
    }
}
