package com.example.testone;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
        if (isWifiProxy(this)) {
            Toast.makeText(this, "正在使用代理网络上网", Toast.LENGTH_LONG).show();
        }
        if (isRooted()) {
            Toast.makeText(this, "当前处于root环境下", Toast.LENGTH_LONG).show();
        }
    }

    /*
     * 判断设备 是否使用代理上网
     * */
    private boolean isWifiProxy(Context context) {
        final boolean IS_ICS_OR_LATER = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
        String proxyAddress;
        int proxyPort;
        if (IS_ICS_OR_LATER) {
            proxyAddress = System.getProperty("http.proxyHost");
            String portStr = System.getProperty("http.proxyPort");
            proxyPort = Integer.parseInt((portStr != null ? portStr : "-1"));
        } else {
            proxyAddress = android.net.Proxy.getHost(context);
            proxyPort = android.net.Proxy.getPort(context);
        }
        return (!TextUtils.isEmpty(proxyAddress)) && (proxyPort != -1);
    }


    /**
     * Is rooted boolean.
     *
     * @return the boolean
     * 安全检查 root环境
     */
    public static boolean isRooted() {
        // nexus 5x "/su/bin/"
        String[] paths = {"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/"};
        try {
            for (int i = 0; i < paths.length; i++) {
                String path = paths[i] + "su";
                if (new File(path).exists()) {
                    String execResult = exec(new String[]{"ls", "-l", path});
                    Log.d("cyb", "isRooted=" + execResult);
                    if (TextUtils.isEmpty(execResult) || execResult.indexOf("root") == execResult.lastIndexOf("root")) {
                        return false;
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String exec(String[] exec) {
        String ret = "";
        ProcessBuilder processBuilder = new ProcessBuilder(exec);
        try {
            Process process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ret += line;
            }
            process.getInputStream().close();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 通过检查classes.dex文件的CRC32摘要值来判断文件是否被篡改
     *
     * @param orginalCRC 原始classes.dex文件的CRC值
     */
    public static void apkVerifyWithCRC(Context context, String orginalCRC) {
        String apkPath = context.getPackageCodePath(); // 获取Apk包存储路径
        try {
            ZipFile zipFile = new ZipFile(apkPath);
            ZipEntry dexEntry = zipFile.getEntry("classes.dex"); // 读取ZIP包中的classes.dex文件
            String dexCRC = String.valueOf(dexEntry.getCrc()); // 得到classes.dex文件的CRC值
            if (!dexCRC.equals(orginalCRC)) { // 将得到的CRC值与原始的CRC值进行比较校验
                // Process.killProcess(Process.myPid()); // 验证失败则退出程序
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过检查apk包的MD5摘要值来判断代码文件是否被篡改
     *
     * @param orginalMD5 原始Apk包的MD5值
     */
    public static void apkVerifyWithMD5(Context context, String orginalMD5) {
        String apkPath = context.getPackageCodePath(); // 获取Apk包存储路径
        try {
            MessageDigest dexDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = new byte[1024];
            int byteCount;
            FileInputStream fis = new FileInputStream(new File(apkPath)); // 读取apk文件
            while ((byteCount = fis.read(bytes)) != -1) {
                dexDigest.update(bytes, 0, byteCount);
            }
            BigInteger bigInteger = new BigInteger(1, dexDigest.digest()); // 计算apk文件的哈希值
            String sha = bigInteger.toString(16);
            fis.close();
            if (!sha.equals(orginalMD5)) { // 将得到的哈希值与原始的哈希值进行比较校验
                //Process.killProcess(Process.myPid()); // 验证失败则退出程序
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过检查签名文件classes.dex文件的哈希值来判断代码文件是否被篡改
     *
     * @param orginalSHA 原始Apk包的SHA-1值
     */
    public static void apkVerifyWithSHA(Context context, String orginalSHA) {
        String apkPath = context.getPackageCodePath(); // 获取Apk包存储路径
        try {
            MessageDigest dexDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = new byte[1024];
            int byteCount;
            FileInputStream fis = new FileInputStream(new File(apkPath)); // 读取apk文件
            while ((byteCount = fis.read(bytes)) != -1) {
                dexDigest.update(bytes, 0, byteCount);
            }
            BigInteger bigInteger = new BigInteger(1, dexDigest.digest()); // 计算apk文件的哈希值
            String sha = bigInteger.toString(16);
            fis.close();
            if (!sha.equals(orginalSHA)) { // 将得到的哈希值与原始的哈希值进行比较校验
                // Process.killProcess(Process.myPid()); // 验证失败则退出程序
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
