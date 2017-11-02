package com.miao.car.base.util;

import org.apache.commons.codec.binary.Base64;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by karl on 2016/5/3.
 */
public class AESCoderUtil {
    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";


    /**
     * 生成密钥
     * @param password
     * @return byte[] 密钥
     */
    public static byte[] generateKey(String password) {
        //返回生成指定算法的秘密密钥的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        //AES 要求密钥长度为 128 ，192，256， 但是java默认只支持128
        kg.init(128,new SecureRandom(password.getBytes()));
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();

        return secretKey.getEncoded();
    }

    /**
     * 生成随机密钥
     *@return byte[] 密钥
     */
    public static byte[] generateKey() {
        //返回生成指定算法的秘密密钥的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        //AES 要求密钥长度为 128 ，192，256， 但是java默认只支持128
        kg.init(128,new SecureRandom());
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();

        return secretKey.getEncoded();
    }

    /**
     * 转换密钥
     *
     * @param key   二进制密钥
     * @return 密钥
     */
    public static Key toKey(byte[] key){
        //生成密钥
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    /**
     * 加密
     *
     * @param data  待加密数据
     * @param key   密钥
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,Key key) throws Exception{
        return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 加密
     *
     * @param data  待加密数据
     * @param key   二进制密钥
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
        return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }


    /**
     * 加密
     *
     * @param data  待加密数据
     * @param key   二进制密钥
     * @param cipherAlgorithm   加密算法/工作模式/填充方式
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
        Key k = toKey(key);
        return encrypt(data, k, cipherAlgorithm);
    }

    /**
     * 加密
     *
     * @param data  待加密数据
     * @param key   密钥
     * @param cipherAlgorithm   加密算法/工作模式/填充方式
     * @return byte[]   加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }



    /**
     * 解密
     *
     * @param data  待解密数据
     * @param key   二进制密钥
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
        return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data  待解密数据
     * @param key   密钥
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,Key key) throws Exception{
        return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    /**
     * 解密
     *
     * @param data  待解密数据
     * @param key   二进制密钥
     * @param cipherAlgorithm   加密算法/工作模式/填充方式
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
        //还原密钥
        Key k = toKey(key);
        return decrypt(data, k, cipherAlgorithm);
    }

    /**
     * 解密
     *
     * @param data  待解密数据
     * @param key   密钥
     * @param cipherAlgorithm   加密算法/工作模式/填充方式
     * @return byte[]   解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    public static String  getKeyStr(){
        byte[] keyArr=generateKey();
        String mikey=parseByte2HexStr(keyArr);
        return  mikey;
    }

    public static void main(String[] args){
        //芝麻请求参数模拟---
        String   orderStr="{phone:\"18682491894\",projectCode:\"HCDB097\",investMoney:\"2500\",bonusCode:\"1005500\",orderId: \"189029890\",orderDate: \"2017-02-14 10:12:45\"}";

       // String  orderStr ="{resultCode:\"300\",spId=\"0\",spProductId=\"0\",regUrl=\"http://test.wx.huochaicf.com/app/index.html#!/activityCenter/share/1/1008046/0?noMenu=true\"}";
        try {
          //生成密钥

           byte[] keyArr=generateKey("3333333");
           String mikey=parseByte2HexStr(keyArr);
           System.out.println("密钥："+mikey);
           // System.out.println(key.length());

          //双方使用公钥加密

          String password = "301AD441CC162E8AC295D2178637F992";   //密钥

          byte[] key = AESCoderUtil.parseHexStr2Byte(password);

          //------------------------加密过程----------------------------

        //  System.out.println("加密前："+orderStr);

          byte[]  str=  AESCoderUtil.encrypt(orderStr.getBytes(),key);  //对称加密字符串


          byte[] result = Base64.encodeBase64(str);     //Base64编码


          String  orderInfo=new String (result);

         System.out.println("加密后："+orderInfo);

          //------------------------解密过程----------------------------------

          //芝麻激活路径模拟
         // byte[] data_base64_decode = Base64.decodeBase64("hc8mjpPQGAuBkDnL/QWwwIh0//wrPPmR7d/RhKEDOikG2CQ8a4n3IFmjH5uWK9NtiuDawmVNKqLqY3VWNAb8nm0PcwK9ZeU4/p9upkoMxCtxvfZPDS6FyIWTWKcl9XvrLvwD7tX2bBl8YbbNcOyos388c1GLhxwamVP+q0m50Txbdt1+JLy8+rEIjGaOGusGRX5ZJ+lWlSeTXsWCkSS/IrzE+HNT9DMk+RwtiAwO1Oc=");  //Base64解密
            String  str1="CIBiFnqDELmJdHThmQ 9YhNiGKz20auTEMFBSShbI2cG2CQ8a4n3IFmjH5uWK9NtO bLSs34jyXqUnePP9GY9UJo Nnq4/IaMhVQJ9sxuNwxVgcCo9zsnre8DyybsS/ahet0BubDk0rg1rGW3molCIe2dgQyAnLIo/90dWYnrairouIVmitmd/Eq9dEUeIXQwxAdSu7KOLLFvmXx 66AmQ==".replaceAll("\\s","+");
            byte[] data_base64_decode = Base64.decodeBase64(str1);

          byte[] decryptData = AESCoderUtil.decrypt(data_base64_decode, key);  //解密字符串

          String json = new String(decryptData);

          System.out.println("解密后："+json);




      }catch (Exception e){
          e.printStackTrace();
      }


    }

}