package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;
import javafx.scene.canvas.GraphicsContext;

import java.awt.image.BufferedImage;

public class Julia extends Fractal {
    private int length;
    private java.util.Random random;
    private final int maxIter = 30;
    private final double zoom = 1;
    private double cY, cX;
    float curi = 0;
    /** Creates an object that handles Koch's fractal.
     * @param length the length of the triangle side
     */
    public Julia(int length) {
        super();
        this.length = length;
    }

    /**
     * Returns the title.
     * @return the title
     */
    public String getTitle() {
        return "Julia set";
    }

    /** Draws the fractal.
     * @param turtle the turtle graphic object
     */
    public void draw(TurtleGraphics turtle, GraphicsContext gc) {
        int w = (int) turtle.getWidth();
        int h = (int) turtle.getHeight();

        cX = -0.7;
        cY = 0.27015;
        double moveX = 0, moveY = 0;
        double zx, zy;

        BufferedImage image = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < w; x++) {
            StringBuilder s = new StringBuilder();
            for (int y = 0; y < h; y++) {
                zx = 1.5 * (x - w / 2) / (0.5 * zoom * w) + moveX;
                zy = (y - h / 2) / (0.5 * zoom * h) + moveY;
                float i = maxIter;
                curi = i;
                turtle.moveTo(x, y);
                recursepxl (turtle,gc, zx,  zy,  i);
                /*
                while (zx * zx + zy * zy < 4 && i > 0) {
                    double tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    i--;
                }


                 */

                //i = curi;
                //s.append(i); s.append(",");
                //int c = Color.HSBtoRGB((maxIter / i) % 1, 1, i > 0 ? 1 : 0);

            }
            //System.out.println(s);
        }
        //gc.setFill(Color.BLACK);

    }

    private void recursepxl (TurtleGraphics turtle, GraphicsContext gc, double zx, double zy, float i){
        if (zx * zx + zy * zy < 4 && i > 0) {
            double tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            //i--;
            recursepxl (turtle,gc, zx,  zy,  i-1);
        }
        if (i<4) {
            //image.setRGB(x, y, c);
            //double colr = ((((zx * zx + zy * zy)*254) % 254)+1)/255;
            //gc.setFill(Color.GREEN);
            turtle.forward(1);
            //gc.strokeLine(zx, zy, zx+1, zy);
        };
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
