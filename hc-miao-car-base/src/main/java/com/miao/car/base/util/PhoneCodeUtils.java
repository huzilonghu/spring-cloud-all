package com.miao.car.base.util;

import java.util.Random;

/**
 * Created by xsing on 2017/6/9.
 */
public class PhoneCodeUtils {
    /**
     * 产生6位数
     * @return
     */
    public static String getSixPhoneAuthCode() {

        Random rnd = new Random();
        int max = 9;
        int min = 0;
        String num = "";
        for (int i = 0; i < 6; i++) {
            int s = rnd.nextInt(max) % (max - min + 1) + min;
            num = num + s;
        }
        return num;

    }

    /**
     * 产生4位数
     * @return
     */
    public static String getFourPhoneAuthCode() {
        Random rnd = new Random();
        int max = 9;
        int min = 0;
        String num = "";
        for (int i = 0; i < 4; i++) {
            int s = rnd.nextInt(max) % (max - min + 1) + min;
            num = num + s;
        }
        return num;
    }

}
