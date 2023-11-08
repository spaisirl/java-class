package ex03;


public void TabAndThreadEx() {
private void TabAndThreadEx() {
    label.setOpaque(true);
    label.setBackground(Color.ORANGE);
    label.setBounds(50, 50, 400, 50);

    // Create a panel for the North section
    JPanel pnlNorth = new JPanel();
    pnlNorth.setLayout(new BorderLayout());
    pnlNorth.add(label, BorderLayout.CENTER);
    con.add(pnlNorth, BorderLayout.NORTH);
    
    con.setFocusable(true);
    con.requestFocus();

    con.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            synchronized (label) {
                if (label.barSize == 400) {
                    return;
                }
                label.barSize++;
                label.repaint();
                label.notify();
            }
        }
    });

    // Create a separate thread for the progress bar animation
    Thread animationThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                synchronized (label) {
                    if (label.barSize == 400) {
                        try {
                            label.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    label.barSize++;
                    label.repaint();
                }

                try {
                    Thread.sleep(100); // Adjust the sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

 }
}
