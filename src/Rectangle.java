/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Devin
 */
public class Rectangle {

    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final int DEFAULT_WIDTH = 0;
    public static final int DEFAULT_HEIGHT = 0;

    private int x;
    private int y;
    private int width;
    private int height;

    // Constructors
    public Rectangle() {
        this(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return 2 * (width + height);
    }

    public void setRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setRect(Rectangle r) {
        x = r.getX();
        y = r.getY();
        width = r.getWidth();
        height = r.getHeight();
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public Rectangle createIntersection(Rectangle r) {
        if (intersects(r)) {
            int x1 = Math.max(x, r.x); // upper left of intersection
            int y1 = Math.max(y, r.y);
            int x2 = Math.min(x + width, r.x + r.width); // lower right of intersection
            int y2 = Math.min(y + height, r.y + r.height);
            return new Rectangle(x1, y1, x2 - x1, y2 - y1); // make rectangle from upper left coordinate and calculated width and height
        } else {
            return new Rectangle(0, 0, 0, 0+0);
        }
    }

    public boolean intersects(Rectangle r) {
        return x < r.x + r.width && y < r.y + r.height && x + width > r.x && y + height > r.y;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[x=%d,y=%d,w=%d,h=%d]", x, y, width, height);
    }
}
