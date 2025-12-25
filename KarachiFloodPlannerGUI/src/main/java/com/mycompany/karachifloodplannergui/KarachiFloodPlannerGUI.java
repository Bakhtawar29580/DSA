package com.mycompany.karachifloodplannergui;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class KarachiFloodPlannerGUI extends JFrame {

    JComboBox<String> startBox, endBox;
    JButton findRouteBtn;
    JTextArea output;
    JPanel mapPanel;

    HashMap<String, Intersection> map = new HashMap<>();
    List<String> safestPath = null;
    boolean analyzed = false;


    public KarachiFloodPlannerGUI() {

        setTitle("Karachi Flood Route Planner");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initializeGraph();
        randomFlood();

        // ================= TITLE =================
        JLabel title = new JLabel("Karachi Flood Route Planner", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(0, 102, 204));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // ================= LEFT PANEL =================
        JPanel controlPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Route Selection"));

        startBox = new JComboBox<>();
        endBox = new JComboBox<>();

        startBox.addItem("Select Start Location");
        endBox.addItem("Select Destination");

        for (String loc : map.keySet()) {
            startBox.addItem(loc);
            endBox.addItem(loc);
        }

        findRouteBtn = new JButton("Find Safe Route");
        findRouteBtn.setBackground(new Color(0, 153, 76));
        findRouteBtn.setForeground(Color.WHITE);

        controlPanel.add(new JLabel("Start Location:"));
        controlPanel.add(startBox);
        controlPanel.add(new JLabel("Destination:"));
        controlPanel.add(endBox);
        controlPanel.add(findRouteBtn);

        add(controlPanel, BorderLayout.WEST);

        // ================= MAP PANEL =================
        mapPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawMap((Graphics2D) g);
            }
        };
        mapPanel.setBorder(BorderFactory.createTitledBorder("City Map"));
        add(mapPanel, BorderLayout.CENTER);

        // ================= BOTTOM =================
        output = new JTextArea(4, 20);
        output.setEditable(false);
        output.setBorder(BorderFactory.createTitledBorder("Output"));

        JPanel legend = new JPanel(new GridLayout(1, 3));
        legend.add(new JLabel("🟢 Safe Road"));
        legend.add(new JLabel("🔴 Flooded Road"));
        legend.add(new JLabel("🔥 Safest Route"));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JScrollPane(output), BorderLayout.CENTER);
        bottom.add(legend, BorderLayout.SOUTH);

        add(bottom, BorderLayout.SOUTH);

        // ================= BUTTON ACTION =================
        findRouteBtn.addActionListener(e -> findSafestRoute());
    }

    // ================= GRAPH =================
    void connect(Intersection a, Intersection b, int d) {
        a.roads.add(new Road(b, d));
        b.roads.add(new Road(a, d));
    }

    void initializeGraph() {

    Intersection gulshan = new Intersection("Gulshan", 250, 180);
    Intersection pechs = new Intersection("PECHS", 380, 180);
    Intersection bahadurabad = new Intersection("Bahadurabad", 250, 300);
    Intersection saddar = new Intersection("Saddar", 380, 300);
    Intersection clifton = new Intersection("Clifton", 520, 360);
    Intersection lyari = new Intersection("Lyari", 150, 350);
    Intersection korangi = new Intersection("Korangi", 550, 200);
    Intersection north = new Intersection("North Karachi", 380, 80);

    connect(gulshan, pechs, 5);
    connect(gulshan, bahadurabad, 6);
    connect(pechs, saddar, 4);
    connect(bahadurabad, saddar, 3);
    connect(saddar, clifton, 7);
    connect(lyari, saddar, 5);
    connect(gulshan, north, 6);
    connect(pechs, korangi, 8);
    connect(clifton, korangi, 4);

    map.put(gulshan.name, gulshan);
    map.put(pechs.name, pechs);
    map.put(bahadurabad.name, bahadurabad);
    map.put(saddar.name, saddar);
    map.put(clifton.name, clifton);
    map.put(lyari.name, lyari);
    map.put(korangi.name, korangi);
    map.put(north.name, north);
}


    // ================= DRAW MAP =================
    void drawMap(Graphics2D g) {

    for (Intersection i : map.values()) {
        for (Road r : i.roads) {

            if (!analyzed) {
                g.setColor(Color.LIGHT_GRAY);   // Initial state
            } 
            else if (r.isFlooded) {
                g.setColor(Color.RED);         // Flooded
            } 
            else {
                g.setColor(Color.YELLOW);       // Safe road
            }

            g.drawLine(i.x, i.y, r.to.x, r.to.y);
        }
    }

    // Safest Route
    if (safestPath != null) {
        g.setStroke(new BasicStroke(4));
        g.setColor(Color.GREEN);
        for (int i = 0; i < safestPath.size() - 1; i++) {
            Intersection a = map.get(safestPath.get(i));
            Intersection b = map.get(safestPath.get(i + 1));
            g.drawLine(a.x, a.y, b.x, b.y);
        }
        g.setStroke(new BasicStroke(1));
    }

    // Draw nodes
    for (Intersection i : map.values()) {
        g.setColor(Color.BLACK);
        g.fillOval(i.x - 5, i.y - 5, 10, 10);
        g.drawString(i.name, i.x - 30, i.y - 10);
    }
}


    // ================= LOGIC =================
    void randomFlood() {
        Random r = new Random();
        for (Intersection i : map.values())
            for (Road rd : i.roads)
                rd.isFlooded = r.nextBoolean();
    }

    void findSafestRoute() {

    analyzed = true;
    randomFlood();

    String start = (String) startBox.getSelectedItem();
    String end = (String) endBox.getSelectedItem();

    if (start.equals(end)) {
        output.setText("Start and destination cannot be same.");
        return;
    }

    HashMap<String, Integer> dist = new HashMap<>();
    HashMap<String, String> prev = new HashMap<>();
    PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

    for (String k : map.keySet())
        dist.put(k, Integer.MAX_VALUE);

    dist.put(start, 0);
    pq.add(start);

    while (!pq.isEmpty()) {
        String u = pq.poll();
        for (Road r : map.get(u).roads) {
            if (r.isFlooded) continue;
            int nd = dist.get(u) + r.distance;
            if (nd < dist.get(r.to.name)) {
                dist.put(r.to.name, nd);
                prev.put(r.to.name, u);
                pq.add(r.to.name);
            }
        }
    }

    if (dist.get(end) == Integer.MAX_VALUE) {
        safestPath = null;
        output.setText("No safe route available (all paths flooded).");
    } else {
        safestPath = new ArrayList<>();
        for (String at = end; at != null; at = prev.get(at))
            safestPath.add(0, at);

        output.setText(
            "Safest Route:\n" + safestPath +
            "\nTotal Distance: " + dist.get(end) + " km"
        );
    }

    mapPanel.repaint();
}


    // ================= MAIN =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KarachiFloodPlannerGUI().setVisible(true));
    }
}
