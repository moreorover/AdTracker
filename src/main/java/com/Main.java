package com;

import com.parser.jsoup.AutoPlius.page.front.AutoPliusFrontPageService;
import com.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualPageService;


public class Main {

    public static void main(String[] args){
        Main main = new Main();
        main.parseFront(50);
        main.parseIndividualAds();
    }

    private void parseFront(int numOfPages) {
        AutoPliusFrontPageService frontPageService = new AutoPliusFrontPageService();
        frontPageService.parseXManyPages(numOfPages);
    }

    private void parseIndividualAds() {
        AutoPliusIndividualPageService autoPliusIndividualPageService = new AutoPliusIndividualPageService();
        autoPliusIndividualPageService.updateAdsInDatabase();
    }
}
