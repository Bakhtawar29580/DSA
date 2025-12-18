package com.mycompany.karachifloodplannergui;

class IntersectionDistance implements Comparable<IntersectionDistance>{
    Intersection intersection;
    int distance;

    public IntersectionDistance(Intersection i, int d) {
        intersection = i;
        distance = d;
    }

    @Override
    public int compareTo(IntersectionDistance o) {
        return this.distance - o.distance;
    }
}

