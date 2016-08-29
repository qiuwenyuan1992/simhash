package datapark.utils;

import java.math.BigInteger;

/**
 * Created by dpliyuan on 2016/3/29.
 */
public class HashUtils {
    public static final int HASH_BITS = 64;
    public static final BigInteger FNV_64_INIT = new BigInteger("14695981039346656037");
    public static final BigInteger FNV_64_PRIME = new BigInteger("1099511628211");
    public static final BigInteger MASK_64 = BigInteger.ONE.shiftLeft(HASH_BITS).subtract(BigInteger.ONE);
    private static int hashbits = 64;

    /**
     * fnv-1 hash算法，将字符串转换为64位hash值
     *
     * @param str str
     * @return
     */
//   NO,Too much dulpicate
    public static BigInteger fnv1Hash64(String str) {
        BigInteger hash = FNV_64_INIT;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            hash = hash.multiply(FNV_64_PRIME);
            hash = hash.xor(BigInteger.valueOf(str.charAt(i)));
        }
        hash = hash.and(MASK_64);
        return hash;
    }
    //   NO,Too much dulpicate,but it is best for now

    public static BigInteger fnv1aHash64(String str) {
        BigInteger hash = FNV_64_INIT;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            hash = hash.xor(BigInteger.valueOf(str.charAt(i)));
            hash = hash.multiply(FNV_64_PRIME);
        }
        hash = hash.and(MASK_64);
        return hash;
    }

    public static long hashCode1(String str) {
        long hash = 0;
        long x = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash << 4) + str.charAt(i);
            if ((x = hash & 0xF0000000L) != 0) {
                hash ^= (x >> 24);
                hash &= ~x;
            }
        }
        return (hash & 0x7FFFFFFF);
    }

    //   NO,Too much dulpicate
    public static long hashCode2(String str) {
        long h = 1125899906842597L; // prime
        int len = str.length();

        for (int i = 0; i < len; i++) {
            h = 31 * h + str.charAt(i);
        }
        return h;
    }

    public static long BKDRHash(String str) {
        int seed = 31; /* 31 131 1313 13131 131313 etc.. */
        long hash = 0;
        int i = 0;

        for (i = 0; i < str.length(); i++) {
            hash = (hash * seed) + (str.charAt(i));
        }

        hash = Math.abs(hash);
        return hash;
    }
    /**
     * 计算Hash
     *
     * @param source
     * @return
     */
    public static BigInteger hashZHOU(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(hashbits).subtract(
                    new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }
    public static  Long pySimhash(String word){

        return 1000L;
    }
}
