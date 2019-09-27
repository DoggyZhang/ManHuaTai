package comic;

import comic.utils.HttpRequest;

public class 武动乾坤 {

    private static String FOLDER = "C:\\Users\\afei5\\Desktop\\武动乾坤\\";

    // 245
    private static String URL = "https://mhpic.isamanhua.com/comic/W/武动乾坤/第%d话F/%d.jpg-mht.middle.webp";

    public static void download(int from, int to) {
        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL, folderIndex, FOLDER, 1);
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
        download(251, 253);

    }

}
