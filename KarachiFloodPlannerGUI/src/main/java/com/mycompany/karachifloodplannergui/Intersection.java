package com.mycompany.karachifloodplannergui;

import java.util.ArrayList;
import java.util.List;

class Intersection {
    String name;
    int x, y;
    List<Road> roads = new ArrayList<>();

    Intersection(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}