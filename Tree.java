package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;
import javafx.scene.canvas.GraphicsContext;

public class Tree extends Fractal {
    private int length;
    private java.util.Random random;
    /** Creates an object that handles Koch's fractal.
     * @param length the length of the triangle side
     */
    public Tree(int length) {
        super();
        this.length = length;
    }

    /**
     * Returns the title.
     * @return the title
     */
    public String getTitle() {
        return "Tree Branches";
    }

    /** Draws the fractal.
     * @param turtle the turtle graphic object
     */
    public void draw(TurtleGraphics turtle, GraphicsContext gc) {
        turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0,
                turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
        //fractalLine(turtle, order,length,0);
        //fractalLine(turtle, order,length,120);
        //fractalLine(turtle, order,length,240);
        random = new java.util.Random();
        drawbranch( turtle, turtle.getWidth()/2, turtle.getHeight()-20,90,turtle.getHeight()*.3, order);

    }

    /*
     * Recursive method: Draws a recursive Branch of the tree.
     */
    private void fractalLine(TurtleGraphics turtle, int order, double length, int alpha) {
        //TODO
        if (order==0){
            //turtle.setDirection(alpha);
            //turtle.forward(length);
            return;
        }
            fractalLine(turtle,order-1, length/3, alpha);
            fractalLine(turtle,order-1, length/3, alpha-60);
            fractalLine(turtle,order-1, length/3, alpha+60);
            fractalLine(turtle,order-1, length/3, alpha);

    }

    public void drawbranch(TurtleGraphics turtle, double x1, double y1, double ort, double leng, int order)
    {

         turtle.setDirection(ort);
         turtle.moveTo(x1, y1);


        double rnd = random.nextDouble();
        double leng2 = leng;
        if (order <2) {leng2 = (random.nextInt(25)+75)*leng/100 ;}
        turtle.forward(leng2);
        double x2 = turtle.getX();
        double y2 = turtle.getY();

        if(order>0){
            drawbranch(turtle, x2, y2, ort-40, leng * .7, order - 1);
            drawbranch(turtle, x2, y2, ort, leng * .6, order - 1);
            drawbranch(turtle, x2, y2, ort+40, leng * .7, order - 1);
        }
    }
}
