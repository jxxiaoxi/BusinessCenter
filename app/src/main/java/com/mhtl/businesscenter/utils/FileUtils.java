package com.mhtl.businesscenter.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by liuwei on 7/7/16.
 */
public class FileUtils {
    private static final String FILE_PATH = Environment.getExternalStorageDirectory() + File.separator + "yueapp" + File.separator ;

    public static void createAppFolder(){
        File file = new File(FILE_PATH);
    }
}
