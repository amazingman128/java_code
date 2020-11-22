package com.example.demo.demo;

public class Migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况");
        printMap(map);

        setWay(map, 1, 1);
        System.out.println("地图的情况");
        printMap(map);

    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean setWay(int[][] map, int x, int y) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                if (setWay(map, x + 1, y)) {
                    return true;
                } else if (setWay(map, x, y + 1)) {
                    return true;
                } else if (setWay(map, x - 1, y)) {
                    return true;
                } else if (setWay(map, x, y - 1)) {
                    return true;
                } else {
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
