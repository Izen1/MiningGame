package kr.kro.izen;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Integer> miningMap = new HashMap<>();
    private static int tryMining = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            int num = in.nextInt();
            switch (num) {
                case 1 -> mine(random);
                case 2 -> System.out.println(tryMining + " 번 채광 하였습니다 !!");
                case 3 -> miningMap.forEach((string, integer) -> System.out.println(string + " 을/를 " + integer + " 번 채굴하였습니다."));
                case 4 -> {
                    System.out.println("종료합니다 !!");
                    return;
                }
                default -> System.out.println("ERROR 올바른 숫자 [ 1, 2, 3, 4 ] 중에 입력해주세요 !!");
            }
        }
    }
    public static void mine(Random random) {
        int chance = random.nextInt(100);
        tryMining++;
        String mine;
        if (chance < 50) mine = "돌";
        else if (chance < 70) mine = "석탄";
        else if (chance < 85) mine = "철";
        else if (chance < 95) mine = "금";
        else if (chance < 99) mine = "에메랄드";
        else mine = "다이아";
        miningMap.put(mine, miningMap.getOrDefault(mine, 0) + 1);
        System.out.println(mine + " 을 채광하였습니다 !!");
    }
}