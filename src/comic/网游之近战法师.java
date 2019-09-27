package comic;

import comic.utils.HttpRequest;

public class 网游之近战法师 {

    public static void download() {
        String FOLDER = "C:\\Users\\afei5\\Desktop\\网游之近战法师\\175~\\";

        // 1-174
        String URL1 = "https://mhpic.manhualang.com/comic/W/网游之近战法师拆分版/第%d话/%d.jpg-mht.middle.webp";

        // 174-
        // (57-)
        String URL2_1 = "https://mhpic.manhualang.com/comic/W/网游之近战法师条漫版/%d话上GQV/%d.jpg-mht.middle.webp";
        String URL2_2 = "https://mhpic.manhualang.com/comic/W/网游之近战法师条漫版/%d话下GQ/%d.jpg-mht.middle.webp";

        // 182
        // 61
        String URL3_1 = "https://mhpic.manhualang.com/comic/W/网游之近战法师条漫版/%d话%dGQ/%d.jpg-mht.middle.webp";

        for (int folderIndex = 60; folderIndex <= 100; folderIndex++) {
            // downloadComicBySpecified(URL1, folderIndex, FOLDER, 15);

//            downloadComic(URL2_1, folderIndex, FOLDER, 1);
//            downloadComic(URL2_2, folderIndex, FOLDER, 2);

            downloadByURL3(URL3_1, folderIndex, 1, FOLDER);
            downloadByURL3(URL3_1, folderIndex, 2, FOLDER);
        }
    }

    private static void downloadByURL3(String url, int folderIndex, int separateIndex, String FOLDER) {
        int i = 1;
        boolean success = true;
        String folderName = FOLDER + String.format("%03d", folderIndex) + "话 " + separateIndex;
        while (success && i < 100) {
            success = HttpRequest.requestAndSave(
                    "",
                    String.format(url, folderIndex, separateIndex, i),
                    folderName,
                    folderName + "\\" + folderIndex + "话 " + String.format("%03d", i) + ".webp");

            i++;
        }
    }

}
