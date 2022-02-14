package cs151Project.PinkPuffball;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.*;

import cs151Project.controllers.Handler;
import cs151Project.models.*;
import cs151Project.views.World;


public class StartGame {
    public static void main(String[] args) {
        World w = new World();
        JFrame frame = new JFrame(w.TITLE);
        frame.add(w);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.start();
    }
}