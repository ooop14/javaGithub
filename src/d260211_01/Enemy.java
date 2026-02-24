package d260211_01;

import java.awt.*;

public class Enemy {
    private int x, y;
    private int speed = 2;

    public Enemy(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    // 적을 아래로 이동
    public void move() {
        y += speed;
    }

    // 적의 위치와 크기를 나타내는 Rectangle 반환
    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);  // 30x30 크기의 적
    }

    // 적을 화면에 그리기
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 30, 30);  // 적 그리기
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
