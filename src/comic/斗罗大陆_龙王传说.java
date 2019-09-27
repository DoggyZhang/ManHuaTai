package comic;

import comic.utils.HttpRequest;

public class 斗罗大陆_龙王传说 {
    private static String FOLDER = "C:\\Users\\afei5\\Desktop\\斗罗大陆-龙王传说\\";

    // 1 - 194
    private static String URL1 = "https://mhpic.isamanhua.com/comic/D/斗罗大陆3龙王传说/第%d话F1/%d.jpg-mht.middle.webp";
    // 195 -
    private static String URL2 = "https://mhpic.isamanhua.com/comic/D/斗罗大陆3龙王传说/第%d话F/%d.jpg-mht.middle.webp";

    public static void download(int from, int to) {
        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL2, folderIndex, FOLDER, 1);
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

    public static void main(String args[]){
        斗罗大陆_龙王传说.download(217, 218);
    }
}
