package comic;

import comic.utils.HttpRequest;

public class 妖神记 {
    private static String FOLDER = "C:\\Users\\afei5\\Desktop\\妖神记\\";

    private static String URL1 = "https://mhpic.manhualang.com/comic/Y/妖神记/第%d话1F/%d.jpg-mht.middle.webp";
    private static String URL2 = "https://mhpic.manhualang.com/comic/Y/妖神记/第%d话2F/%d.jpg-mht.middle.webp";

    public static void download() {
        for (int folderIndex = 227; folderIndex <= 237; folderIndex++) {
            downloadComic(URL1, folderIndex, FOLDER, 1);
            downloadComic(URL2, folderIndex, FOLDER, 2);
        }
    }

    public static void download(int from, int to) {
        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL1, folderIndex, FOLDER, 1);
            downloadComic(URL2, folderIndex, FOLDER, 2);
        }
    }

    private static void downloadComic(String url, int folderIndex, String FOLDER, int separateIndex) {

        int i = 1;
        boolean success = true;
        String folderName = FOLDER + String.format("%03d", folderIndex) + "话 " + separateIndex;

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
        download(241, 242);

    }
}
