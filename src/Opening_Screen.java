import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Opening_Screen {

    JFrame frame;
    
    public Opening_Screen() {
        SoundManager Sound = new SoundManager();
        Sound.playBackgroundMusic();  

        showOpeningScreen();
    }

    public void showOpeningScreen() {
        if (frame != null) frame.dispose(); // agar pehle ka screen hai, hata do

        frame = new JFrame("🧠  Welcome to Sudoku! 🧩");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel("🧠  Welcome to Sudoku! 🧩", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        frame.add(title, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setFocusable(false);
        frame.add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            SoundManager s = new SoundManager();
               s.playClickSound();
                frame.dispose();
                new Sudoku(Opening_Screen.this);
            }
        });

        frame.setVisible(true);
    }
}
