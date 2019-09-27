package comic;

import comic.utils.HttpRequest;

public class 斗破苍穹 {
    private static String FOLDER = "C:\\Users\\afei5\\Desktop\\斗破苍穹\\";

    private static String URL1 = "https://mhpic.manhualang.com/comic/D/斗破苍穹拆分版/%d话GQ/%d.jpg-mht.middle.webp";

    public static void download(int from, int to) {

        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL1, folderIndex, FOLDER);
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
}
