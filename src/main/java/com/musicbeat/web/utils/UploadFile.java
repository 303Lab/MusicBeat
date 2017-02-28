package com.musicbeat.web.utils;

import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.io.IOException;

import static jdk.nashorn.internal.objects.NativeDate.toTimeString;

/**
 * Created by gyz on 2017/2/20.
 */
public class UploadFile {

    public static Boolean IntertoBoolean(Integer num)
    {
        Boolean bool = false;
        if (num == 1)
        {
            bool = true;
        }
        else
        {
            bool = false;
        }
        return bool;
    }

    public static  Integer BooleantoInter( Boolean bool)
    {
        Integer num = 0;
        if (bool == true)
        {
            num = 1;
        }
        else
        {
            num = 0;
        }
        return num;
    }

    public static void buildFolder(String pathName) {
        File directory = new File(pathName);
        //如果文件夹不存在则创建
        if (!directory.exists() && !directory.isDirectory()) {
            System.out.println("//目录不存在");
            directory.mkdir();
            //System.out.println(path.getAbsolutePath());
        } else {
            System.out.println("//目录存在");
        }
    }

    public static void saveimgFile(String path,String sourcefile,String filename) {

        File file = new File(sourcefile);

        if ((file.exists()) && (file.length() != 0)) {
            try {
                FileUtils.copyFile(file, new File(path + filename + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void savelrcFile(String path, String sourcefile, String filename) {

        File file = new File(sourcefile);

        if ((file.exists()) && (file.length() != 0)) {
            try {
                FileUtils.copyFile(file, new File(path + filename + ".lrc"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void savemp3File(String path,String sourcefile,String filename) {

        File file = new File(sourcefile);

        if ((file.exists()) && (file.length() != 0)) {
            try {
                FileUtils.copyFile(file,new File(path+filename+".mp3"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }





    public static String getMusicLength(File file) {
        try {
            MP3File f = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            String time = audioHeader.getTrackLengthAsString();
            return time;
        } catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getFileNameByPath(String path) {
        if ( path != null) {
            int left = path.lastIndexOf("/");
            int right = path.lastIndexOf("\\");
            int index = left > right ? left : right;
            return path.substring(index + 1);
        }
        else
        {
            return null;
        }
    }

    public static String formatVideoTimeLength(long time) {
        long s = time % 60;
        long m = (time / 60) % 60;
        long h = time / 3600;
        return toTimeString(h) + ":" + toTimeString(m) + ":" + toTimeString(s);
    }

    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean DeleteFolder(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }

    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }




}
