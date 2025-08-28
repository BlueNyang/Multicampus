package com.mc.algorithm.d_datastructure.map;

import com.mc.algorithm.d_datastructure.dto.School;

public class Run {
    public static void main(String[] args) {
        MyHashMap<String, School> map = getSchoolMyHashMap();

        System.out.println("Map size: " + map.size());
        System.out.println("Get seoulUniv: " + map.get("seoulUniv"));
        System.out.println("Get yonseiUniv: " + map.get("yonseiUniv"));
        System.out.println("Get minsa: " + map.get("minsa"));
        System.out.println("Get multicampus: " + map.get("multicampus"));

        System.out.println("==========================");
        System.out.println("After removing " + map.remove("seoulUniv"));
        System.out.println("Map size: " + map.size());
        System.out.println("Get seoulUniv: " + map.get("seoulUniv"));

        System.out.println("==========================");
        System.out.println(map);
    }

    private static MyHashMap<String, School> getSchoolMyHashMap() {
        School seoulUniv = new School("Seoul University", "Gwanak-gu", "University");
        School yonseiUniv = new School("Yonsei University", "Seoul", "University");
        School minsa = new School("Minsa High School", "Daejeon", "High School");
        School multicampus = new School("Multicampus", "Yeoksam", "Academy");

        MyHashMap<String, School> map = new MyHashMap<>();
        map.put("seoulUniv", seoulUniv);
        map.put("yonseiUniv", yonseiUniv);
        map.put("minsa", minsa);
        map.put("multicampus", multicampus);
        return map;
    }
}
