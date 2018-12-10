package com.dream.medical.m;

/**
 * Created by 惜梦_ on 2018/10/6.
 */

public class Call120 {

    /**
     * code : 0
     * ambulance : {"id":1,"name":"救护车1","explain":"救护人民是我们的职责","gps":"39.937830183835885,116.50523694427966","ctime":"2018-10-06 16:37:30","utime":"2018-10-06 16:40:59"}
     */

    public int code;
    public AmbulanceBean ambulance;

    public static class AmbulanceBean {
        /**
         * id : 1
         * name : 救护车1
         * explain : 救护人民是我们的职责
         * gps : 39.937830183835885,116.50523694427966
         * ctime : 2018-10-06 16:37:30
         * utime : 2018-10-06 16:40:59
         */

        public int id;
        public String name;
        public String explain;
        public String gps;
        public String ctime;
        public String utime;

        @Override
        public String toString() {
            return "AmbulanceBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", explain='" + explain + '\'' +
                    ", gps='" + gps + '\'' +
                    ", ctime='" + ctime + '\'' +
                    ", utime='" + utime + '\'' +
                    '}';
        }
    }


}
