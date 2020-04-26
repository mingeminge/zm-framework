package com.zm.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;

/**
 * ==================================
 *
 * @author yizuomin
 * @description:
 * @date 2020/4/26 09:59
 * ==================================
 **/
public class Base64Util {

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        b = str.getBytes(StandardCharsets.UTF_8);
        if (b.length > 0) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }


    /**
     * 解密
     *
     * @param s
     * @return
     */
    public static String getFromBase64(String s) {
        byte[] b;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
