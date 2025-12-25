package com.mycompany.karachifloodplannergui;

class Road {
    Intersection to;
    int distance;
    boolean isFlooded = false;

    Road(Intersection to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

