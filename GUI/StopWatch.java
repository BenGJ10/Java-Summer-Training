import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StopWatch extends JFrame implements ActionListener {
    private JTextField h, m, s, ms;
    private JButton startStopButton, resetButton, homeButton;
    private boolean isRunning = false;
    private final AtomicInteger milliseconds = new AtomicInteger(0);
    private ScheduledExecutorService scheduler;

    public StopWatch() {
        super("Stopwatch ⏱️");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        Font font = new Font("SansSerif", Font.BOLD, 24);

        // Panel for time display
        JPanel timePanel = new JPanel(new GridLayout(2, 4, 10, 5));
        JLabel lh = new JLabel("HH", SwingConstants.CENTER);
        JLabel lm = new JLabel("MM", SwingConstants.CENTER);
        JLabel ls = new JLabel("SS", SwingConstants.CENTER);
        JLabel lms = new JLabel("MS", SwingConstants.CENTER);
        lh.setFont(font);
        lm.setFont(font);
        ls.setFont(font);
        lms.setFont(font);

        h = new JTextField("0");
        m = new JTextField("0");
        s = new JTextField("0");
        ms = new JTextField("0");
        JTextField[] fields = { h, m, s, ms };

        for (JTextField tf : fields) {
            tf.setFont(font);
            tf.setHorizontalAlignment(JTextField.CENTER);
            tf.setEditable(false);
        }

        timePanel.add(lh);
        timePanel.add(lm);
        timePanel.add(ls);
        timePanel.add(lms);
        timePanel.add(h);
        timePanel.add(m);
        timePanel.add(s);
        timePanel.add(ms);

        // Buttons Panel
        startStopButton = new JButton("Start");
        resetButton = new JButton("Reset");
        homeButton = new JButton("Home");

        JButton[] buttons = { startStopButton, resetButton, homeButton };
        for (JButton btn : buttons) {
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            btn.setPreferredSize(new Dimension(120, 40));
            btn.addActionListener(this);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(homeButton);
        buttonPanel.add(startStopButton);
        buttonPanel.add(resetButton);

        // Combine everything
        setLayout(new BorderLayout(10, 10));
        add(timePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(245, 245, 245));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == resetButton) {
            reset();
        } else if (source == startStopButton) {
            toggleStartStop();
        } else if (source == homeButton) {
            JOptionPane.showMessageDialog(this, "Home button clicked");
        }
    }

    private void toggleStartStop() {
        isRunning = !isRunning;
        startStopButton.setText(isRunning ? "Stop" : "Start");
        if (isRunning) {
            startTimer();
        } else {
            stopTimer();
        }
    }

    private void startTimer() {
        if (scheduler == null || scheduler.isShutdown()) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.scheduleAtFixedRate(() -> {
                milliseconds.incrementAndGet();
                updateDisplay();
            }, 0, 1, TimeUnit.MILLISECONDS);
        }
    }

    private void stopTimer() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }

    private void reset() {
        stopTimer();
        milliseconds.set(0);
        updateDisplay();
        startStopButton.setText("Start");
        isRunning = false;
    }

    private void updateDisplay() {
        int totalMilliseconds = milliseconds.get();
        int millis = totalMilliseconds % 1000;
        int seconds = (totalMilliseconds / 1000) % 60;
        int minutes = (totalMilliseconds / (1000 * 60)) % 60;
        int hours = totalMilliseconds / (1000 * 60 * 60);

        SwingUtilities.invokeLater(() -> {
            h.setText(String.format("%02d", hours));
            m.setText(String.format("%02d", minutes));
            s.setText(String.format("%02d", seconds));
            ms.setText(String.format("%03d", millis));
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopWatch::new);
    }
}
