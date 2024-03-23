package xchart;

import java.awt.Component;
import java.awt.Container;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import java.util.ArrayList;
import java.util.List;

public class physicsFinal_20220808006 {
    // @author: ALPEREN ULUKAYA
    public static void main(String[] args) {

        System.out.println("*************** QUESTION 1 *************** ");

        System.out.println();
        long myNumber = 20220808006L;
        double initialVelocity = 44.0;
        double angle = Math.toRadians(26.0);
        double gravity = 9.8;

        double Vy = initialVelocity * Math.sin(angle);
        double Vx = initialVelocity * Math.cos(angle);

        double timOfFlight = 2 * Vy / gravity;
        double maxHeight = (Vy * Vy) / (2 * gravity);
        double range = Vx * timOfFlight;

        System.out.println("Time of Flight : " + String.format("%.2f",
                timOfFlight) + " seconds");
        System.out.println("Maximum Height : " + String.format("%.2f",
                maxHeight) + " meters");
        System.out.println("Range : " + String.format("%.2f", range) +
                " meters");

        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();

        calculateTrajectory(initialVelocity, angle, gravity, xData, yData);
        XYChart chart = createChart(xData, yData);

        new SwingWrapper<>(chart).displayChart();

        System.out.println("\n");
        Question2();
    }

    public static void calculateTrajectory(double initialVelocity,
            double angle, double gravity, List<Double> xData,
            List<Double> yData) {

        double Vy = initialVelocity * Math.sin(angle);
        double Vx = initialVelocity * Math.cos(angle);

        double timeOfFlight = 2 * Vy / gravity;

        double dt = timeOfFlight / 100;
        double t = 0;

        while (t <= timeOfFlight) {
            double x = Vx * t;
            double y = Vy * t - 0.5 * gravity * t * t;
            xData.add(x);
            yData.add(y);
            t += dt;
        }
    }

    public static XYChart createChart(List<Double> xData,
            List<Double> yData) {
        XYChart chart = new XYChartBuilder().width(800).height(600)
                .theme(org.knowm.xchart.style.Styler.ChartTheme.GGPlot2)
                .title("Projectile Motion")
                .xAxisTitle("X (meters)").yAxisTitle("Y (meters)").build();

        chart.addSeries("Projectile Motion", xData, yData);

        return chart;
    }

}
