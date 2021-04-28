package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;
import javafx.scene.canvas.GraphicsContext;

public class Sierpinski extends Fractal {
		private int length;

		/** Creates an object that handles Koch's fractal.
		 * @param length the length of the triangle side
		 */
		public Sierpinski(int length) {
			super();
			this.length = length;
		}

		/**
		 * Returns the title.
		 * @return the title
		 */
		public String getTitle() {
			return "Sierpinski triangel";
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
			triangle( turtle, (turtle.getWidth()-10)/2, 20, turtle.getWidth()-40, turtle.getHeight()-20, 40, turtle.getHeight() -20, order);

		}

		/*
		 * Recursive method: Draws a recursive line of the triangle.
		 */
		private void fractalLine(TurtleGraphics turtle, int order, double length, int alpha) {
			//TODO
			if (order==0){
				turtle.setDirection(alpha);
				turtle.forward(length);
			} else {
				fractalLine(turtle,order-1, length/3, alpha);
				fractalLine(turtle,order-1, length/3, alpha-60);
				fractalLine(turtle,order-1, length/3, alpha+60);
				fractalLine(turtle,order-1, length/3, alpha);
			}
		}

		public void triangle(TurtleGraphics turtle, double x1, double y1, double x2, double y2, double x3, double y3, int order)
		{


			//if statement base case
			//midpoint = (x1 + x2 / 2), (y1 + y2/ 2)
			//if(Math.sqrt((double)(Math.pow(x2-x1, 2)) + (double)(Math.pow(y2-y1, 2))) > 2)
			if(order==0)
			{
				//window.drawLine(x1, y1, x2, y2);
				 turtle.moveTo(x1, y1);
				 turtle.forwardTo(x2, y2);
				//window.drawLine(x2, y2, x3, y3);
				 turtle.moveTo(x2, y2);
				 turtle.forwardTo(x3, y3);
				//window.drawLine(x3, y3, x1, y1);
				 turtle.moveTo(x3, y3);
				 turtle.forwardTo(x1, y1);
			} else {

				double xa, ya, xb, yb, xc, yc;   // make 3 new triangles by connecting the midpoints of
				xa = (x1 + x2) / 2;             //. the previous triangle
				ya = (y1 + y2) / 2;
				xb = (x1 + x3) / 2;
				yb = (y1 + y3) / 2;
				xc = (x2 + x3) / 2;
				yc = (y2 + y3) / 2;


				triangle(turtle, x1, y1, xa, ya, xb, yb, order - 1);   // recursively call the function using the 3 triangles
				triangle(turtle, xa, ya, x2, y2, xc, yc, order - 1);
				triangle(turtle, xb, yb, xc, yc, x3, y3, order - 1);
			}
		}
	}
