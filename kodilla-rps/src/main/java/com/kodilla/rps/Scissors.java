package com.kodilla.rps;

public class Scissors implements Symbol{
    public void drawSymbol() {
        for (int i = 0; i < 1; i ++) {
            System.out.println("  ❄   ❄  ");
            for (int j = 0; j < 1; j++) {
                System.out.println("   ❄ ❄   ");
                for (int k = 0; k < 1; k++) {
                    System.out.println("    ❄    ");
                    for (int n = 0; n < 1; n++) {
                        System.out.println("   ❄ ❄   ");
                    }
                    System.out.println("  ❄   ❄  ");
                }
                System.out.println(" ❄     ❄ ");
            }
            System.out.println("❄       ❄");
        }
    }
}

