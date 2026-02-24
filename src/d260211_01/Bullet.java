package d260211_01;

import java.awt.*;

public class Bullet {
    private int x, y;
    private int speed = 5;

    public Bullet(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    // 총알을 위로 이동
    public void move() {
        y -= speed;
    }

    // 총알의 위치와 크기를 나타내는 Rectangle 반환
    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 10);  // 5x10 크기의 총알
    }

    // 총알을 화면에 그리기
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 5, 10);  // 총알 그리기
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
