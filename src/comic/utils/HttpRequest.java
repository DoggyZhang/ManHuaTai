package comic.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HttpRequest {

    /**
     * 发送http get请求
     *
     * @param getUrl
     * @return
     */
    public static boolean requestAndSave(String comic, String getUrl, String folderName, String fileName) {

        log("<<" + comic + ">> " + "开始下载：" + folderName + " " + fileName);

        File folder = null;
        File file = null;
        try {
            URL url = new URL(getUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setAllowUserInteraction(false);
            InputStream in = url.openStream();

            folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            while (true) {
                int read = in.read(buffer);
                if (read >= 0) {
                    out.write(buffer, 0, read);
                } else {
                    break;
                }
            }

            in.close();
            in = null;

            out.close();
            out = null;

        } catch (Exception e) {
            e.printStackTrace();
            log("--------下载失败");
            return false;
        } finally {

            file = null;
            folder = null;
        }
        log("--------下载成功");
        return true;
    }

    public static void log(String log) {
        System.out.println(log);
    }
}
