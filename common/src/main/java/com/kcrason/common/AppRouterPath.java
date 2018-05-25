package com.kcrason.common;

/**
 * @author KCrason
 * @date 2018/5/25
 */
public class AppRouterPath {

    public static class OneComponent {
        public final static String OneActivtiy = "OneComponent/OneActivity";
    }

    public static class TwoComponent {
        public final static String TwoActivtiy = "TwoComponent/TwoActivity";
    }


    public static class RouterService {
        public final static String HelloService = "RouterService/HelloService";
        public final static String SingleHelloService = "/RouterService/SingleSayHello";
    }
}
