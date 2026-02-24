package d260211_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

//적과 총알이 충돌할 떄 이벤트를 등록하는것이 목표
//main함수에서는 게임에 필요한 부품들을 생성
//총알,적 객체가 몇개인지 확인
public class Game extends JPanel {
    private List<Bullet> bullets;
    private List<Enemy> enemies;

    //부품의 생성되는 시점은 생성자에서 또는 set/add함수에서 생성한다.
    public Game() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        setFocusable(true);

        // 스페이스바로 총알 발사
        //Jpanel위에서 이벤트를 등록
        //스페이스 키를 누르면 총알이 이동하지만 아래의 코드는 총알 초기화, 총알을 리스트에 넣는 작업 ////////////////,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Bullet bullet = new Bullet(100, 200);  // 총알 초기 위치
                    bullets.add(bullet);
                }
            }
        });

        // 적 생성 (예시로 3개의 적을 생성)
        for (int i = 0; i < 3; i++) {
            enemies.add(new Enemy(50 + i * 100, 50));  // 100 간격으로 적을 배치
        }

        // 타이머를 사용하여 일정 시간 간격으로 게임 상태 업데이트 및 화면 갱신
        Timer timer = new Timer(16, e -> update());  // 60fps로 업데이트
        timer.start();
    }

    // 게임 상태 업데이트 및 충돌 검사
    public void update() {
        // 총알 이동
        for (Bullet bullet : bullets) {
            bullet.move();
        }

        // 적 이동
        for (Enemy enemy : enemies) {
            enemy.move();
        }

        // 충돌 검사
        checkCollisions();
        
        // 화면 갱신
        repaint();
    }

    // 충돌 검사: 총알과 적의 충돌을 체크
    public void checkCollisions() {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        List<Enemy> enemiesToRemove = new ArrayList<>();

        // 총알과 적의 충돌 체크
        for (Bullet bullet : bullets) {
            for (Enemy enemy : enemies) {
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    // 충돌 발생 시 적과 총알을 제거
                    bulletsToRemove.add(bullet);
                    enemiesToRemove.add(enemy);
                    System.out.println("충돌 발생!");
                }
            }
        }

        // 충돌된 총알과 적을 리스트에서 제거
        bullets.removeAll(bulletsToRemove);
        enemies.removeAll(enemiesToRemove);
    }

    // 화면에 게임 오브젝트 그리기
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 배경을 지우고 다시 그리기
        g.clearRect(0, 0, getWidth(), getHeight());

        // 총알 그리기
        for (Bullet bullet : bullets) {
            bullet.render(g);
        }

        // 적 그리기
        for (Enemy enemy : enemies) {
            enemy.render(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("슈팅 게임");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);  // 프레임 크기 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
