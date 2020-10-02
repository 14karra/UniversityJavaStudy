package Lab4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String txt = "Hello, World!";

    public static void main(String... args) throws Exception {
        executeExercise_1_and_2();
        executeExercise_7();
        executeExercise_13();
    }

    static void executeExercise_1_and_2() throws Exception {
        Point point = new Point(23.04, -99.4);

        final int[] k = {0};
        List<LabeledPoint> labeledPoints = new ArrayList<LabeledPoint>() {
            {
                add(new LabeledPoint(0.0, 31.3, "A" + k[0]));
                k[0]++;
            }
        };

        labeledPoints.toString();
    }

    static void executeExercise_7() {
        PrimaryColors blueColor = PrimaryColors.BLUE;
        PrimaryColors yellowColor = PrimaryColors.YELLOW;
    }

    static void executeExercise_13() throws Exception {
        Class ourClass = Class.forName("java.lang.System");
        Field outField = ourClass.getDeclaredField("out");
        Method println = outField.getType().getMethod("println", String.class);
        println.invoke(outField.get(null), txt);
    }

}
