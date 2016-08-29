package datapark.test;

import datapark.utils.HashUtils;

import java.math.BigInteger;

/**
 * Created by dpliyuan on 2016/3/4.
 */
public class CallerClassA {
    public static void main(String[] args){
        Long val = Long.valueOf("35L");
        System.out.println(val);
        BigInteger hash = new BigInteger(val.toString().split(".")[0]);
        System.out.println(hash);
    }
}
