package com.venkat.gneric.mymap;

public class MyMain {
    public static void main(String[] args) {
        var nationalUSParks = new Park[]{
            new Park("Yellowstone", "44.4882, -110.5916"),
            new Park("Yellowstone", "44.4882, -110.5916"),
            new Park("Yosemite", "37.8855, -119.5360")
        };
        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers = new River[]{
            new River("Mississippi", "47.2160, -95.2348","29.1566, -89.2495","35.1556, -90.0659"),
                new River("Missouri", "45.9239, -111.4983","38.8146, -90.1218")
        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);
        riverLayer.addElements(
                new River("Colorado", "40.4708, -105.2348","31.1566, -114.2495"),
                new River("Delaware", "42.2026, -75.00836","39.4955, -75.5592")
        );
        riverLayer.renderLayer();
    }
}
