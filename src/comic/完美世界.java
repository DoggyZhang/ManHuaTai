package comic;

import comic.utils.HttpRequest;

public class 完美世界 {

    public static String FOLDER = "C:\\Users\\afei5\\Desktop\\完美世界\\";

    // 1-257
    public static String URL1 = "https://mhpic.manhualang.com/comic/W/完美世界拆分版/第%d话/%d.jpg-mht.middle.webp";
    // 258-
    public static String URL2 = "https://mhpic.manhualang.com/comic/W/完美世界/第%d话F/%d.jpg-mht.middle.webp";

    public static void download(int from, int to) {
        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL2, folderIndex, FOLDER);
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
        download(267, 272);
    }
}
