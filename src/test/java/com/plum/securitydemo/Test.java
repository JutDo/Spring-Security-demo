package com.plum.securitydemo;

import java.security.MessageDigest;

public class Test {
    public String encode(String str) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            result = md.digest();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return parseByte2HexStr(result);
    }

    /**
     * 将二进制转换成十六进制
     *
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
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

    public static void main(String[] args) {
        Test md5=new Test();
        String content = "123";
        String content1 = "123456";
        String content2 = "123456789";
        System.out.println(md5.encode(content));
        System.out.println(md5.encode(content1));
        System.out.println(md5.encode(content2));
    }
}
