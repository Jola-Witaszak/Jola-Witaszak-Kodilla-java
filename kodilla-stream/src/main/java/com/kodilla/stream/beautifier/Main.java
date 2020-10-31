package com.kodilla.stream.beautifier;

public class Main {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println();poemBeautifier.beautify("Red lorry, yellow lorry.", text -> text + text.toUpperCase());
        poemBeautifier.beautify("Which witch is which?", text -> text + " ♥ ♦ ♣ ♠");
        poemBeautifier.beautify("Flash message: ", text -> text + " ♪♪♪♪ ♫ ♪ ♫ ♫");
        poemBeautifier.beautify("Eddie edited it.", text -> "░░░░░ " + text + "  ░░░░░");
    }
}
