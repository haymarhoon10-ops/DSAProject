/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.campussystem;

import com.mycompany.campussystem.service.DataLoader;

/**
 * Entry point for the Smart Campus Navigation and Resource Management system.
 * For now it only loads the campus data and prints a summary.
 *
 * @author Durra
 */
public class CampusSystem {

    public static void main(String[] args) {
        DataLoader data = new DataLoader();
        System.out.println("Smart Campus (Bahrain Polytechnic) loaded:");
        System.out.println("  Buildings: " + data.getBuildings().size());
        System.out.println("  Pathways:  " + data.getPathways().size());
        System.out.println("  Rooms:     " + data.getRooms().size());
        System.out.println("  Courses:   " + data.getCourses().size());
    }
}
