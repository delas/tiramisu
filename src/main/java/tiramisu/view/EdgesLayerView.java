package tiramisu.view;

import tiramisu.model.Activity;
import tiramisu.model.Edge;
import tiramisu.model.ProcessLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.QuadCurve2D;
import java.util.Arrays;

public class EdgesLayerView extends JPanel {

    private ProcessLayer processLayer;

    public EdgesLayerView(ProcessLayer processLayer) {
        this.processLayer = processLayer;
        setLayout(null);
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for(Edge e : processLayer.getEdgesList()) {
            ActivityView source = e.getSource().getView();
            ActivityView target = e.getTarget().getView();

            int x1 = source.getX() + source.getWidth() / 2;
            int y1 = source.getY() + source.getHeight() / 2;
            int x2 = target.getX() + target.getWidth() / 2;
            int y2 = target.getY() + target.getHeight() / 2;

            float size = (float) (5 + e.getIntensity() * 20);

            // the line needs to be shortened to avoid the arrowhead to get over the line
            double angle = Math.atan2(y2 - y1, x2 - x1);

            int newStartX = (int) (x1 + size*2 * Math.cos(angle));
            int newStartY = (int) (y1 + size*2 * Math.sin(angle));
            int newEndX = (int) (x2 - size*2.5 * Math.cos(angle));
            int newEndY = (int) (y2 - size*2.5 * Math.sin(angle));

            int arrowEndX = (int) (x2 - size * Math.cos(angle));
            int arrowEndY = (int) (y2 - size * Math.sin(angle));


            g2.setStroke(new BasicStroke(size, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
            if (e.isDeviation()) {
                g2.setColor(Color.RED);
            } else {
                g2.setColor(Color.BLACK);
            }
            int ctrlX = (int) ((newStartX + newEndX) / 2.1);
            int ctrlY = (int) ((newStartY + newEndY) / 2.1);
            QuadCurve2D line = new QuadCurve2D.Float(newStartX, newStartY, ctrlX, ctrlY, newEndX, newEndY);
            g2.draw(line);
            drawArrowhead(g2, ctrlX, ctrlY, arrowEndX, arrowEndY, (int) (size*2));
        }
    }

    private void drawArrowhead(Graphics2D g2d, int x1, int y1, int x2, int y2, int arrowSize) {

        // Calculate the angle of the line
        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Calculate the coordinates of the arrowhead
        int x3 = (int) (x2 - arrowSize * Math.cos(angle - Math.PI / 6));
        int y3 = (int) (y2 - arrowSize * Math.sin(angle - Math.PI / 6));
        int x4 = (int) (x2 - arrowSize * Math.cos(angle + Math.PI / 6));
        int y4 = (int) (y2 - arrowSize * Math.sin(angle + Math.PI / 6));

        // Create a polygon for the arrowhead
        Path2D arrowhead = new Path2D.Double();
        arrowhead.moveTo(x2, y2);
        arrowhead.lineTo(x3, y3);
        arrowhead.lineTo(x4, y4);
        arrowhead.closePath();

        g2d.fill(arrowhead);
    }

}
