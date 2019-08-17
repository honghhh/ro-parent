package com.project.utils.pwd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 非对称加密
 */
@SuppressWarnings("all")
public class Encode {

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    public static String xString[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    public static String xStringName[] = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
    private static MessageDigest _mdInst = null;
    private static char hexDigits_wl[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static String mapString[] = {"ZE", "ON", "TW", "TH", "FO", "FI", "SI", "SE", "EI",
            "NI", "BA", "BB", "BC", "BD", "BE", "BF", "B1", "B2", "B3", "B4",
            "B5", "B6", "B7", "B8", "B9", "B0", "Q1", "R1", "SK", "3T", "YU",
            "CV", "PW", "QX", "HY", "CZ", "TY", "TU", "SA", "SB", "SS", "UI",
            "VE", "ZR", "HR", "WO", "LA", "E8", "3K", "0R", "4L", "3N", "56",
            "98", "V9", "6M", "6U", "3J", "Y4", "67", "ML", "ZZ"};
    private static char mapChar[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
            'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static char mapLoginChar[] = {'A',
            'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Encode() {
    }

    /**
     *
     */
    private static final String byteArrayToHexString(byte[] byteArray) {
        StringBuffer sb = new StringBuffer();
        for (byte byt : byteArray) {
            sb.append(byteToHexString(byt));
        }
        return sb.toString();
    }

    /**
     *     */
    private static final String byteToHexString(byte byt) {
        int n = byt;
        if (n < 0)
            n = 256 + n;
        return hexDigits[n / 16] + hexDigits[n % 16];
    }

    /**
     */
    private static final String Encode(String code, String message) {
        MessageDigest md;
        String encode = null;
        try {
            md = MessageDigest.getInstance(code);
            encode = byteArrayToHexString(md.digest(message
                    .getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encode;
    }

    public static final String md5Encode(String message) {
        return Encode("MD5", message);
    }

    public static final String shaEncode(String message) {
        return Encode("SHA1", message);
    }

    public static final String sha256Encode(String message) {
        return Encode("SHA-256", message);
    }

    public static final String sha512Encode(String message) {
        return Encode("SHA-512", message);
    }

    public static String PHEncodeNum(String strNum) {
        if (strNum == null || strNum.trim().length() == 0 || strNum.trim().equals("0")) {
            return "0";
        }

        StringBuilder strResultCode = new StringBuilder();

        Double dPreCode = Double.valueOf(strNum);
        Double keyNum = 23333351.00;
        Double tempNum = keyNum / dPreCode;
        String tempStr = String.valueOf(tempNum);
        int len = 18;
        if (tempStr.length() < 18) {
            len = tempStr.length();
        }
        tempStr = tempStr.substring(0, len);

        int posLocation = tempStr.indexOf('.');
        if (posLocation < 0) {
            posLocation = 0;
        }

        if (posLocation > 0) {
            String tempStartStr = tempStr.substring(0, posLocation);
            String tempEndStr = tempStr.substring(posLocation + 1, len);
            String strPos = String.valueOf(posLocation);

            tempStr = tempStartStr + tempEndStr + strPos;
        } else {
            tempStr = tempStr + "0";
        }

        char[] tempChar = tempStr.toCharArray();

        for (int i = 0; i < tempChar.length; i++) {
            char newChar = inttoascii(17 + i + asciitoint(tempChar[i]));
            strResultCode.append(String.valueOf(newChar));
        }

        return strResultCode.toString();
    }

    /**
     * 对数据进行解密
     * @param strCode 需要解密的支付
     * @param itype 0表示返回带2位小数的数字，1表示返回整数
     * @return
     */
    public static String PHDecodeNum(String strCode, int itype) {
        if (strCode == null || strCode.trim().length() == 0 || strCode.trim().equals("0")) {
            return strCode;
        }

        char[] tempChar = strCode.toCharArray();

        StringBuilder strAfterCode = new StringBuilder();
        for (int i = 0; i < tempChar.length; i++) {
            char tempStr = inttoascii(asciitoint(tempChar[i]) - 17 - i);
            strAfterCode.append(String.valueOf(tempStr));
        }
        String midStr = strAfterCode.toString();

        String strPos = midStr.substring(midStr.length() - 1, midStr.length());
        int iPosLocation = Integer.parseInt(strPos);
        if (iPosLocation > 0) {
            String startStr = midStr.substring(0, iPosLocation);
            String endStr = midStr.substring(iPosLocation, midStr.length() - 1);

            midStr = startStr + "." + endStr;
        } else {
            midStr = midStr.substring(0, midStr.length() - 1);
        }

        Double iNum = Double.valueOf(midStr);

        iNum = 1 / (iNum / 23333351.00);

        DecimalFormat df = new DecimalFormat("0.00");
        String lastNum = String.valueOf(df.format(iNum));

        if (itype == 1) //表示返回整数
        {
            lastNum = lastNum.substring(0, lastNum.length() - 3);
        }

        return lastNum;

    }

    private static int asciitoint(char c) {
        return (int) c;
    }

    private static char inttoascii(int num) {
        return (char) num;
    }

    // 这个是用来加密的
    public static final String getEncryption(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < mapChar.length; j++) {
                if (ch[i] == mapChar[j]) {
                    sb.append(mapString[j]);
                }
            }
        }
        return sb.toString();
    }

    // 这个是解密的
    public static final String getDecryption(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            for (int j = 0; j < mapString.length; j++) {
                if (str.substring(i, i + 2).equals(mapString[j])) {
                    sb.append(mapChar[j]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取随机随机数
     * @param howNum 几位数
     * @param type 1表示纯数字  2数字字母混合 3纯字母
     * @return
     */
    public static final String getRandomNum(int howNum, int type) {
        String result = "";
        Random random = new Random();
        if (1 == type) {
            for (int i = 0; i < howNum; i++) {
                int num = random.nextInt(9);
                result += String.valueOf(num);
            }
        } else if (2 == type) {
            for (int i = 0; i < howNum; i++) {
                int num = random.nextInt(mapChar.length - 1);
                result += mapChar[num];
            }
        } else {
            for (int i = 0; i < howNum; i++) {
                int num = random.nextInt(mapLoginChar.length - 1);
                result += mapLoginChar[num];
            }
        }
        return result;
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static MessageDigest getMdInst() {
        if (_mdInst == null) {
            try {
                _mdInst = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return _mdInst;
    }

    public final static String encode(String s) {
        try {
            byte[] btInput = s.getBytes();
            // 使用指定的字节更新摘要
            getMdInst().update(btInput);
            // 获得密文
            byte[] md = getMdInst().digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits_wl[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits_wl[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Encode.getRandomNum(5, 3));
    }
}