package comic;

import comic.utils.HttpRequest;

public class 神印王座 {

    public static String FOLDER = "C:\\Users\\afei5\\Desktop\\神印王座\\";
    // 1~407
    // 467~468
    public static String URL1 = "https://mhpic.manhualang.com/comic/S/神印王座拆分版/第%d话/%d.jpg-mht.middle.webp";

    // 408~466
    public static String URL2 = "https://mhpic.manhualang.com/comic/S/神印王座拆分版/第%d话GQ/%d.jpg-mht.middle.webp";

    // 469~475
    public static String URL3 = "https://mhpic.manhualang.com/comic/S/神印王座/第%d话F/%d.jpg-mht.middle.webp";

//    public static void download(int from) {
//        for (int folderIndex = 469; folderIndex <= 475; folderIndex++) {
//            for (int fileIndex = 1; fileIndex <= 15; fileIndex++) {
//                HttpRequest.requestAndSave(
//                        "神印王座",
//                        String.format(URL3, folderIndex, fileIndex),
//                        FOLDER + folderIndex + "话",
//                        FOLDER + folderIndex + "话\\" + folderIndex + "话 " + fileIndex + ".webp");
//            }
//        }
//    }

    public static void download(int from, int to) {
        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL3, folderIndex, FOLDER);
        }
    }

    private static void downloadComic(String url, int folderIndex, String FOLDER) {
        int i = 1;
        boolean success = true;
        String folderName = FOLDER + String.format("%03d", folderIndex) + "话";
        while (success && i < 100) {
            success = HttpRequest.requestAndSave(
                    "",
                    String.format(url, folderIndex, i),
                    folderName,
                    folderName + "\\" + folderIndex + "话 " + String.format("%03d", i) + ".webp");

            i++;
        }
    }

    public static void main(String [] args){
        download(476, 480);
    }
}
