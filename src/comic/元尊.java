package comic;

import comic.utils.HttpRequest;

public class 元尊 {

    private static String FOLDER = "C:\\Users\\afei5\\Desktop\\元尊\\";
    private static String URL1 = "https://mhpic.manhualang.com/comic/Y/元尊/%d话上GQ/%d.jpg-mht.middle.webp";
    private static String URL2 = "https://mhpic.manhualang.com/comic/Y/元尊/%d话下GQ/%d.jpg-mht.middle.webp";

    // 148~161
    private static String URL3 = "https://mhpic.manhualang.com/comic/Y/元尊/第%d话上F/%d.jpg-mht.middle.webp";
    private static String URL4 = "https://mhpic.manhualang.com/comic/Y/元尊/第%d话下F/%d.jpg-mht.middle.webp";

    public static void download() {

        for (int folderIndex = 162; folderIndex <= 166; folderIndex++) {
            downloadComic(URL3, folderIndex, FOLDER, 1);
            downloadComic(URL4, folderIndex, FOLDER, 2);
        }
    }

    public static void download(int from, int to) {

        for (int folderIndex = from; folderIndex <= to; folderIndex++) {
            downloadComic(URL3, folderIndex, FOLDER, 1);
            downloadComic(URL4, folderIndex, FOLDER, 2);
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
        download(175, 176);

    }

}
