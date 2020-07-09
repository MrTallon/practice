package utils;

import java.util.Base64;

/**
 * 原生Base64工具类
 *
 * sun.misc.BASE64Decoder/BASE64Encoder
 * 原生Base64和上述的区别：
 * Base64依赖于简单的编码和解码算法，使用65个字符的US-ASCII子集，其中前64个字符中的每一个都映射到等效的6位二进制序列，第65个字符（=）用于将Base64编码的文本填充到整数大小。后来产生了3个变种：
 * RFC 4648：Basic， 此变体使用RFC 4648和RFC 2045的Base64字母表进行编码和解码。编码器将编码的输出流视为一行; 没有输出行分隔符。解码器拒绝包含Base64字母表之外的字符的编码。
 * RFC 2045：MIME ，此变体使用RFC 2045提供的Base64字母表进行编码和解码。编码的输出流被组织成不超过76个字符的行; 每行（最后一行除外）通过行分隔符与下一行分隔。解码期间将忽略Base64字母表中未找到的所有行分隔符或其他字符。
 * RFC 4648：Url， 此变体使用RFC 4648中提供的Base64字母表进行编码和解码。字母表与前面显示的字母相同，只是-替换+和_替换/。不输出行分隔符。解码器拒绝包含Base64字母表之外的字符的编码。
 *
 * JDK官方的Base64和sun的base64是不兼容的！不要替换！
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-06-09 16:07
 */
public class Base64Utils {
    public static final Base64.Decoder DECODER = Base64.getDecoder();
    public static final Base64.Encoder ENCODER = Base64.getEncoder();

    public static String encodeToString(byte[] textByte) {
        return ENCODER.encodeToString(textByte);
    }

    public static byte[] decode(String str) {
        return DECODER.decode(str);
    }
}
