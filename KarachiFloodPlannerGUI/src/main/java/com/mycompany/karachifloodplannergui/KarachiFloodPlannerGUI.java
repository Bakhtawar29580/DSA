package com.mycompany.karachifloodplannergui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Karachi Flood Route Planner
 */
public class KarachiFloodPlannerGUI extends JFrame {
    
    boolean simulationStarted = false;


    // ================= DATA STRUCTURES =================
    static class Road {
        Intersection to;
        int distance;
        boolean isFlooded;

        Road(Intersection to, int distance) {
            this.to = to;
            this.distance = distance;
            this.isFlooded = false;
        }
    }

    static class Intersection {
        String name;
        int x, y;
        java.util.List<Road> roads = new ArrayList<>();

        Intersection(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        void addRoad(Road r) {
            roads.add(r);
        }
    }

    static class IntersectionDistance implements Comparable<IntersectionDistance> {
        Intersection intersection;
        int distance;

        IntersectionDistance(Intersection i, int d) {
            intersection = i;
            distance = d;
        }

        public int compareTo(IntersectionDistance o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    // ================= VARIABLES =================
    HashMap<String, Intersection> map = new HashMap<>();

    JPanel mapPanel;
    JComboBox<String> startBox, endBox;
    JTextArea infoArea;

    double scale = 1.0;
    int offsetX = 0, offsetY = 0;

    java.util.List<String> safestPath = null;

    // ================= CONSTRUCTOR =================
    public KarachiFloodPlannerGUI() {
        setTitle("Karachi Flood Route Planner");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeGraph();
        randomFlood();

        // ================= MAP PANEL =================
        mapPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawMap((Graphics2D) g);
            }
        };
        mapPanel.setBackground(Color.WHITE);
        add(mapPanel, BorderLayout.CENTER);

        // ================= TOP PANEL =================
        JPanel top = new JPanel();

        startBox = new JComboBox<>();
        endBox = new JComboBox<>();

        startBox.addItem("Select Start");
        endBox.addItem("Select Destination");

        for (String name : map.keySet()) {
            startBox.addItem(name);
            endBox.addItem(name);
        }

        JButton findBtn = new JButton("Find Safest Route");

        top.add(new JLabel("Start:"));
        top.add(startBox);
        top.add(new JLabel("End:"));
        top.add(endBox);
        top.add(findBtn);

        add(top, BorderLayout.NORTH);

        // ================= BOTTOM PANEL =================
        infoArea = new JTextArea(5, 30);
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);

        add(new JScrollPane(infoArea), BorderLayout.SOUTH);

        // ================= BUTTON ACTION =================
        findBtn.addActionListener(e -> findSafestRoute());

        setVisible(true);
    }

    // ================= GRAPH SETUP =================
    void connect(Intersection a, Intersection b, int d) {
        a.addRoad(new Road(b, d));
        b.addRoad(new Road(a, d));
    }

    void initializeGraph() {
        Intersection gulshan = new Intersection("Gulshan", 400, 200);
        Intersection pechs = new Intersection("PECHS", 600, 200);
        Intersection bahadurabad = new Intersection("Bahadurabad", 400, 400);
        Intersection saddar = new Intersection("Saddar", 600, 400);

        connect(gulshan, pechs, 5);
        connect(gulshan, bahadurabad, 7);
        connect(pechs, saddar, 6);
        connect(bahadurabad, saddar, 4);

        map.put(gulshan.name, gulshan);
        map.put(pechs.name, pechs);
        map.put(bahadurabad.name, bahadurabad);
        map.put(saddar.name, saddar);
    }

    // ================= DRAW MAP =================
    void drawMap(Graphics2D g) {
        g.setStroke(new BasicStroke(2));

        // Roads
        for (Intersection i : map.values()) {
            for (Road r : i.roads) {
                if (!simulationStarted) {
                      g.setColor(Color.LIGHT_GRAY);   // initial state
                } else if (r.isFlooded) {
                      g.setColor(Color.RED);          // flooded
                } else {
                      g.setColor(Color.YELLOW);       // normal safe road
                }

                g.drawLine(i.x, i.y, r.to.x, r.to.y);
            }
        }

        // Safest Path
        if (safestPath != null) {
            g.setColor(Color.BLUE);
            g.setStroke(new BasicStroke(4));
            for (int i = 0; i < safestPath.size() - 1; i++) {
                Intersection a = map.get(safestPath.get(i));
                Intersection b = map.get(safestPath.get(i + 1));
                g.drawLine(a.x, a.y, b.x, b.y);
            }
        }

        // Nodes
        for (Intersection i : map.values()) {
            g.setColor(Color.BLUE);
            g.fillOval(i.x - 6, i.y - 6, 12, 12);
            g.setColor(Color.BLACK);
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
        simulationStarted = true;
        randomFlood();
        safestPath = null;

        String start = (String) startBox.getSelectedItem();
        String end = (String) endBox.getSelectedItem();

        if (start.startsWith("Select") || end.startsWith("Select")) {
            infoArea.setText("Please select both start and destination.");
            repaint();
            return;
        }

        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, String> prev = new HashMap<>();
        PriorityQueue<IntersectionDistance> pq = new PriorityQueue<>();

        for (String k : map.keySet())
            dist.put(k, Integer.MAX_VALUE);

        dist.put(start, 0);
        pq.add(new IntersectionDistance(map.get(start), 0));

        while (!pq.isEmpty()) {
            Intersection u = pq.poll().intersection;
            for (Road r : u.roads) {
                if (r.isFlooded) continue;
                int nd = dist.get(u.name) + r.distance;
                if (nd < dist.get(r.to.name)) {
                    dist.put(r.to.name, nd);
                    prev.put(r.to.name, u.name);
                    pq.add(new IntersectionDistance(r.to, nd));
                }
            }
        }

        if (dist.get(end) == Integer.MAX_VALUE) {
            infoArea.setText("No safe route available. All paths flooded.");
            repaint();
            return;
        }

        safestPath = new ArrayList<>();
        for (String at = end; at != null; at = prev.get(at))
            safestPath.add(0, at);

        infoArea.setText(
                "Safest Route: " + safestPath +
                "\nTotal Distance: " + dist.get(end) + " km"
        );

        repaint();
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(KarachiFloodPlannerGUI::new);
    }
}
