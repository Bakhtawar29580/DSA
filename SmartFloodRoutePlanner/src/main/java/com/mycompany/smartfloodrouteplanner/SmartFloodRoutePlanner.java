package com.mycompany.smartfloodrouteplanner;

import java.util.*;
import java.io.*;

/**
 * Smart Flood Route Planner
 * - Graph with weighted edges and "blocked" flag
 * - BFS for reachability
 * - Dijkstra for shortest safe path
 */

public class SmartFloodRoutePlanner {

    // -----------------------------
    // EDGE CLASS
    // -----------------------------
    public static class Edge {
        public final String to;
        public final double weight;
        public boolean blocked;

        public Edge(String to, double weight) {
            this.to = to;
            this.weight = weight;
            this.blocked = false;
        }

        @Override
        public String toString() {
            return String.format("%s(%.1f%s)", to, weight, blocked ? ",B" : "");
        }
    }

    // -----------------------------
    // GRAPH CLASS
    // -----------------------------
    public static class Graph {

        private final Map<String, List<Edge>> adj = new HashMap<>();

        public void addVertex(String v) { adj.putIfAbsent(v, new ArrayList<>()); }

        public void addEdge(String u, String v, double weight) {
            addVertex(u); addVertex(v);
            adj.get(u).add(new Edge(v, weight));
            adj.get(v).add(new Edge(u, weight)); // undirected
        }

        public List<Edge> neighbors(String v) {
            return adj.getOrDefault(v, Collections.emptyList());
        }

        public Set<String> vertices() { return adj.keySet(); }

        // -------------------------
        // BLOCK / UNBLOCK EDGE
        // -------------------------
        public boolean setEdgeBlocked(String u, String v, boolean blocked) {
            boolean changed = false;
            for (Edge e : neighbors(u)) {
                if (e.to.equals(v)) { e.blocked = blocked; changed = true; }
            }
            for (Edge e : neighbors(v)) {
                if (e.to.equals(u)) { e.blocked = blocked; changed = true; }
            }
            return changed;
        }

        // -------------------------
        // BFS reachability
        // -------------------------
        public boolean bfsReachable(String source, String target) {
            if (!adj.containsKey(source) || !adj.containsKey(target)) return false;

            Queue<String> q = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            q.add(source); visited.add(source);

            while (!q.isEmpty()) {
                String u = q.poll();
                if (u.equals(target)) return true;

                for (Edge e : neighbors(u)) {
                    if (e.blocked) continue;
                    if (!visited.contains(e.to)) {
                        visited.add(e.to);
                        q.add(e.to);
                    }
                }
            }
            return false;
        }

        // -------------------------
        // DIJKSTRA SHORTEST PATH
        // -------------------------
        public List<String> dijkstraShortestPath(String source, String target) {
            if (!adj.containsKey(source) || !adj.containsKey(target))
                return Collections.emptyList();

            Map<String, Double> dist = new HashMap<>();
            Map<String, String> prev = new HashMap<>();
            for (String v : vertices()) dist.put(v, Double.POSITIVE_INFINITY);
            dist.put(source, 0.0);

            PriorityQueue<String> pq =
                new PriorityQueue<>(Comparator.comparingDouble(dist::get));
            pq.add(source);

            while (!pq.isEmpty()) {
                String u = pq.poll();
                if (u.equals(target)) break;

                double du = dist.get(u);
                if (Double.isInfinite(du)) break;

                for (Edge e : neighbors(u)) {
                    if (e.blocked) continue;
                    double alt = du + e.weight;
                    if (alt < dist.get(e.to)) {
                        dist.put(e.to, alt);
                        prev.put(e.to, u);
                        pq.remove(e.to);
                        pq.add(e.to);
                    }
                }
            }

            if (!prev.containsKey(target) && !source.equals(target))
                return Collections.emptyList();

            LinkedList<String> path = new LinkedList<>();
            String cur = target;
            path.addFirst(cur);
            while (prev.containsKey(cur)) {
                cur = prev.get(cur);
                path.addFirst(cur);
            }
            return path;
        }

        // -------------------------
        // PRINT GRAPH
        // -------------------------
        public void printGraph() {
            System.out.println("Graph adjacency list:");
            for (String u : adj.keySet()) {
                List<String> outs = new ArrayList<>();
                for (Edge e : adj.get(u)) {
                    outs.add(e.to + String.format("(%.1f%s)", e.weight, e.blocked ? ",B" : ""));
                }
                System.out.println(u + " -> " + String.join(", ", outs));
            }
        }

        // -------------------------
        // RANDOM FLOOD
        // -------------------------
        public void randomFlood(int n) {
            List<String[]> edges = new ArrayList<>();

            for (String u : vertices()) {
                for (Edge e : neighbors(u)) {
                    if (u.compareTo(e.to) < 0) {
                        edges.add(new String[]{u, e.to});
                    }
                }
            }

            Collections.shuffle(edges);
            int blocked = 0;

            for (int i = 0; i < Math.min(n, edges.size()); i++) {
                String[] p = edges.get(i);
                if (setEdgeBlocked(p[0], p[1], true)) blocked++;
            }

            System.out.println("Randomly blocked " + blocked + " edges.");
        }
    }

    // -----------------------------
    // BUILD SAMPLE GRAPH
    // -----------------------------
    public static Graph buildSampleGraph() {
        Graph g = new Graph();
        g.addEdge("A", "B", 5);
        g.addEdge("A", "C", 3);
        g.addEdge("B", "C", 2);
        g.addEdge("B", "D", 6);
        g.addEdge("C", "D", 7);
        g.addEdge("C", "E", 4);
        g.addEdge("D", "E", 2);
        return g;
    }

    // -----------------------------
    // MAIN PROGRAM LOOP
    // -----------------------------
    public static void main(String[] args) throws IOException {

        Graph g = buildSampleGraph();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Smart Flood Route Planner Demo");
        System.out.println("Type HELP for commands. Nodes: A, B, C, D, E.");

        while (true) {
            System.out.print("cmd> ");
            String line = br.readLine();
            if (line == null) break;

            line = line.trim();
            if (line.isEmpty()) continue;

            String[] tok = line.split("\\s+");
            String cmd = tok[0].toUpperCase();

            switch (cmd) {

                case "HELP":
                    System.out.println("Commands:");
                    System.out.println("LIST - show graph");
                    System.out.println("BLOCK u v - block edge");
                    System.out.println("UNBLOCK u v - unblock edge");
                    System.out.println("RUN_BFS src dst - reachability");
                    System.out.println("RUN_DIJKSTRA src dst - shortest safe path");
                    System.out.println("RANDOM_FLOOD [n] - randomly block n edges");
                    System.out.println("EXIT | QUIT - exit");
                    break;

                case "LIST":
                    g.printGraph();
                    break;

                case "BLOCK":
                    if (tok.length < 3) {
                        System.out.println("Usage: BLOCK u v");
                        break;
                    }
                    if (g.setEdgeBlocked(tok[1], tok[2], true))
                        System.out.println("Blocked " + tok[1] + " <-> " + tok[2]);
                    else
                        System.out.println("Edge not found.");
                    break;

                case "UNBLOCK":
                    if (tok.length < 3) {
                        System.out.println("Usage: UNBLOCK u v");
                        break;
                    }
                    if (g.setEdgeBlocked(tok[1], tok[2], false))
                        System.out.println("Unblocked " + tok[1] + " <-> " + tok[2]);
                    else
                        System.out.println("Edge not found.");
                    break;

                case "RUN_BFS":
                    if (tok.length < 3) {
                        System.out.println("Usage: RUN_BFS src dst");
                        break;
                    }
                    System.out.println("Reachable: " + g.bfsReachable(tok[1], tok[2]));
                    break;

                case "RUN_DIJKSTRA":
                    if (tok.length < 3) {
                        System.out.println("Usage: RUN_DIJKSTRA src dst");
                        break;
                    }
                    List<String> path = g.dijkstraShortestPath(tok[1], tok[2]);
                    if (path.isEmpty())
                        System.out.println("No safe path found.");
                    else
                        System.out.println("Shortest safe path: " + String.join(" -> ", path));
                    break;

                case "RANDOM_FLOOD":
                    int n = 1;
                    if (tok.length >= 2) {
                        try { n = Integer.parseInt(tok[1]); } catch (Exception ignored) {}
                    }
                    g.randomFlood(n);
                    break;

                case "EXIT":
                case "QUIT":
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Unknown command. Type HELP.");
                    break;
            }
        }
    }
}
