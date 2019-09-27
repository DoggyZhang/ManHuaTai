package comic.utils;

import java.io.File;

public class Rename {


    public static void main(String args[]) throws Exception {
        String folderName = "C:\\Users\\afei5\\Desktop\\video.video\\c96b030f4e32c596da761f7049fb1ded";

        File folder = new File(folderName);

        if (!folder.exists()) {
            System.out.println("文件夹不存在");
        } else {
            System.out.println("文件夹: " + folder);
            for (File file : folder.listFiles()) {
                rename(file);
            }
        }
    }

    private static void rename(File file) {
        if (file.isDirectory()) {
            System.out.println("文件夹: " + file.getName());
            for (File f : file.listFiles()) {
                rename(f);
            }
        } else {
            file.renameTo(new File(file.getParent() + "\\" + file.getName() + ".ts"));
        }
    }

}
