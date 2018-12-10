package com.dream.medical.m;

import java.io.Serializable;
import java.util.List;

public class DoctorTime implements Serializable{

    /**
     * result : [{"subsDate":[],"date":"2018-09-03"},{"subsDate":[],"date":"2018-09-04"},{"subsDate":[],"date":"2018-09-05"},{"subsDate":[],"date":"2018-09-06"},{"subsDate":[{"userName":"admin","dateScope":"14:00\u201417:00","status":"已预约","flag":null}],"date":"2018-09-07"},{"subsDate":[{"userName":"admin","dateScope":"13:00\u201414:00","status":"可预约","flag":null}],"date":"2018-09-08"},{"subsDate":[{"userName":"admin","dateScope":"20:18\u201421:19","status":"可预约","flag":null}],"date":"2018-09-09"}]
     * code : 0
     */

    public int code;
    public List<ResultBean> result;

    public static class ResultBean implements Serializable{
        /**
         * subsDate : []
         * date : 2018-09-03
         */

        public String date;
        public String portrait;
        public List<UserTime> subsDate;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "date='" + date + '\'' +
                    ", subsDate=" + subsDate +
                    '}';
        }
    }

    public static class UserTime implements Serializable {
        //{
        //                    "userName": "admin",
        //                    "dateScope": "14:00—17:00",
        //                    "status": "已预约",
        //                    "flag": null
        //                }
        public String userName;
        public String dateScope;
        public String status;
        public String flag;

        @Override
        public String toString() {
            return dateScope;
        }
    }
}
