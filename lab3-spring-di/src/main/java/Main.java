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

      // /*  Task #1  */
      // Workout workout1 = (Workout)context.getBean("workout1");
      // System.out.println("Workout1: "+ workout1);
      // Workout workout2 = (Workout)context.getBean("workout2");
      // System.out.println("Workout2: "+ workout2);

      // /*  Task #2  */
      // Workout workout3 = (Workout) context.getBean("workout3");
      // System.out.println("Workout3: "+ workout3);

      // /*  Task #3  */
      // ScheduledWorkout scheduledWorkout = (ScheduledWorkout) context.getBean("scheduled-workout");
      // System.out.println("ScheduledWorkout: "+scheduledWorkout.toString());

      // /*  Task #4  */
      // Workout workout4 = (Workout) context.getBean("spelWorkout");
      // System.out.println("Workout3: "+ workout4.toString());

      // /*  Task #5  */
      // Workout workout5 = (Workout) context.getBean("autowireWorkout1");
      // System.out.println("autowireWorkout1: "+ workout5.toString());
      // Workout workout6 = (Workout) context.getBean("autowireWorkout2");
      // System.out.println("autowireWorkout2: "+ workout6.toString());

        /*  Task #6  */
        WorkoutComplex workoutComplex1 = (WorkoutComplex) context.getBean("workoutComplexFromFactory");
        System.out.println("Factory workoutComplex: "+ workoutComplex1.toString());

        Workout workout6 = (Workout) context.getBean("workoutFromFactory");
        System.out.println("Factory workout: "+ workout6.toString());

        WorkoutFactory workoutFactory = (WorkoutFactory) context.getBean("lookupFactoryWorkout");
        System.out.println(workoutFactory.getWorkout().toString());
    }
}
