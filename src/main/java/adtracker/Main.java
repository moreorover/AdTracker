package adtracker;

import adtracker.model.Ad;
import adtracker.parser.jsoup.AutoPlius.page.front.AutoPliusFrontPageService;
import adtracker.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualPageService;
import adtracker.report.ReportGeneratorImpl;
import adtracker.report.comparator.AdsListedComparator;
import adtracker.report.reports.r01.R01ReportItem;
import adtracker.storage.db.DataBaseFactory;
import adtracker.storage.db.GsonDataBaseImpl;

import java.util.List;


public class Main {

    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

    public static void main(String[] args){
        Main main = new Main();
//        main.parseFront(50);
//        main.parseIndividualAds(0, 6);
//        main.checkDb();
        main.genReport();
    }

    private void parseFront(int numOfPages) {
        AutoPliusFrontPageService frontPageService = new AutoPliusFrontPageService();
        frontPageService.parseXManyPages(numOfPages);
    }

    private void parseIndividualAds(int howOldDays, int howOldHours) {
        AutoPliusIndividualPageService autoPliusIndividualPageService = new AutoPliusIndividualPageService();
        autoPliusIndividualPageService.updateAdsInDatabase(howOldDays, howOldHours);
    }

    private void checkDb() {
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

//        for (Ad ad : localJsonStorage.getAll()) {
//            if (ad.getCar().getMake() == null) {
//                localJsonStorage.delete(ad);
//            }
//        }
//
//        localJsonStorage.commit();

        for (Ad ad : localJsonStorage.getAll()) {
            if (ad.getCar().getMake() == null) {
                System.out.println(ad);
            }
        }
    }

    private void genReport() {
        List<R01ReportItem> r01ReportItems = ReportGeneratorImpl.genReport01(localJsonStorage.getAll());
        r01ReportItems.sort(new AdsListedComparator(false));
        for (R01ReportItem r : r01ReportItems) {
            System.out.println(r);
        }
    }
}