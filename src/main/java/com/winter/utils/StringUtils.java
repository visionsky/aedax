package com.winter.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.util.Base64Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.http.NameValuePair;

import static com.winter.constant.Constants.API_SECRET;
import static com.winter.constant.Constants.TIMESTAMP;
import com.winter.constant.SymbolConstants;
import com.winter.model.NameObjectPair;
import java.util.Random;
/**
 * Created By Donghua.Chen on  2018/1/9
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    private static final char STUFFS[] = { 	'A','B','C','D','E','F','G','H',	'I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','1','2','3','4','5','6','7','8'};
    private static int LEN=6;
    private static int PERMUTATION = 720;
    private static int MAX_COMBINATION = 906192;
    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static byte[] buildSignSHA256Hex(List<NameValuePair> params, String secretKey, String timestamp) {
        params.sort(Comparator.comparing(NameValuePair::getName));
        NameValuePair secret = new NameObjectPair(API_SECRET, secretKey);
        params.add(secret);
        params.add(new NameObjectPair(TIMESTAMP, timestamp));
        String stringForSign = buildStringForSign(params);
        byte[] result = HmacUtils.getHmacSha256(secretKey.getBytes()).doFinal(stringForSign.getBytes());
        params.remove(secret);
        return result;
    }

    public static String base64Sha256Hex(List<NameValuePair> params, String secretKey, String timestamp) {
        return Base64Utils.encodeToString(new String(Hex.encodeHex(buildSignSHA256Hex(params, secretKey, timestamp), false)).getBytes());
    }

    /**
     * 生成用于加密的字符串
     *
     * @param params 请求参数
     * @return 用于加密的字符串
     */
    private static String buildStringForSign(List<NameValuePair> params) {
        StringBuilder res = new StringBuilder();
        List<String> paramsList = new ArrayList<>();
        for (NameValuePair pair : params) {
            paramsList.add(pair.getName() + SymbolConstants.EQUALS_SIGN + pair.getValue());
        }
        res.append(join(paramsList, SymbolConstants.AMPERSAND));
        return res.toString();
    }

    public static String buildQueryString(List<NameValuePair> params) {
        StringBuilder queryString = new StringBuilder(SymbolConstants.QUESTION_MARK);
        List<String> paramsList = new ArrayList<>();
        params.forEach(x -> paramsList.add(x.getName() + SymbolConstants.EQUALS_SIGN + x.getValue()));
        return queryString.append(StringUtils.join(paramsList, SymbolConstants.AMPERSAND))
                .toString();
    }
    public static boolean isEmpty(String str){

        return org.springframework.util.StringUtils.isEmpty(str);
    }
    public static String encode(int val) {
        int com = val / PERMUTATION;
        if(com >= MAX_COMBINATION) {
            throw new RuntimeException("id can't be greater than 652458239");	}
            int per = val % PERMUTATION;
        char[] chars = combination(com);
        chars = permutation(chars,per);
        return new String(chars);
    }
    private static char[] combination(int com){
        char[] chars = new char[LEN];
        int start = 0;	int index = 0;	while (index < LEN)
        {
                for(int s = start; s < STUFFS.length; ++s )
                {
                    //int c = combination(STUFFS.length - s - 1, LEN - index - 1);
                    int c = 2;
                    if(com >= c)
                    {
                        com -= c;
                        continue;
                    }
                    chars[index++] = STUFFS[s];
                    start = s + 1;
                    break;
                }
        }
        return chars;
    }
        //3、通过排列序号对字符进行排序
        private static char[] permutation(char[] chars,int per){
        char[] tmpchars = new char[chars.length];
        System.arraycopy(chars, 0, tmpchars, 0, chars.length);
        int[] offset = new int[chars.length];	int step = chars.length;
        for(int i = chars.length -1;i >= 0;--i) {
            offset[i] = per % step;		per /= step;		step --;	}
            for(int i = 0; i < chars.length;++i) {
                if(offset[i] == 0)
                continue;		char tmp = tmpchars[i];
                tmpchars[i] = tmpchars[i - offset[i]];
                tmpchars[i - offset[i]] = tmp;	}
                return tmpchars;
    }
    private    static final    char[] r=new        char[]{'q',     'w', 'e',          '8', 'a',  's', '2',        'd', 'z',    'x', '9',  'c', '7',   'p', '5',  'i', 'k',     '3', 'm',            'j', 'u',            'f', 'r',            '4', 'v',
            'y', 'l',            't', 'n',            '6', 'b',            'g', 'h'};

    /** (不能与自定义进制有重复) */
    private    static final    char b='o';

    /** 进制长度 */
    private    static final    int binLen=r.length;

    /** 序列最小长度 */
    private     static final    int s=6;

    /**
     * 根据ID生成六位随机码
     * @param id ID
     * @return 随机码
     */
    public   static String toSerialCode(long         id) {
        char[] buf=new       char[32];
        int
                charPos=32;

        while((id / binLen) >
                0) {
            int
                    ind=(int)(id % binLen);
            // System.out.println(num + "-->" + ind);
            buf[--charPos]=r[ind];
            id /= binLen;
        }
        buf[--charPos]=r[(int)(id % binLen)];
        // System.out.println(num + "-->" + num % binLen);
        String str=new   String(buf, charPos, (32     - charPos));
        // 不够长度的自动随机补全
        if(str.length() < s) {
            StringBuilder sb=new        StringBuilder();
            sb.append(b);
            Random rnd=new  Random();
            for(int
                i=1; i < s - str.length(); i++) {
                sb.append(r[rnd.nextInt(binLen)]);
            }
            str+=sb.toString();
        }
        return
                str;
    }

    public     static long    codeToId(String code) {
        char           chs[]=code.toCharArray();
        long             res=0L;
        for(int    i=0; i < chs.length; i++) {
            int              ind=0;
            for(int     j=0; j < binLen; j++) {
                if(chs[i] == r[j]) {
                    ind=j;
                    break;
                }
            }
            if(chs[i] == b) {
                break;
            }
            if(i >
                    0) {
                res=res * binLen + ind;
            }
            else {
                res=ind;
            }
            // System.out.println(ind + "-->" + res);
        }
        return
                res;
    }


}
