package ch09.iterator;

import ch09.iterator.itnews.ITNewsSection;
import ch09.iterator.sports.SportsNewsSection;

public class Main {

    public static void main(String[] args) {
        ITNewsSection itNewsSection = new ITNewsSection();
        System.out.println(itNewsSection);
        System.out.println(itNewsSection.getFormattedNews());
        
        SportsNewsSection sportsNewsSection = new SportsNewsSection();
        System.out.println(sportsNewsSection);
        System.out.println(sportsNewsSection.getFormattedNews());
    }
}

