package com.dream.medical.m;

import java.util.List;

public class AppointDoctorBean {

    /**
     * result : [{"id":41,"buyername":"admin","buyerPhone":null,"buyerid":1,"appointmentTime":"2018-09-09#20:00-21:00","doctorname":"\b王辉","doctorid":3,"oneprice":100,"totalprice":null,"r1":"d6973f44-c28b-483f-af20-1c4227fb65bb","r2":null,"r3":null},{"id":42,"buyername":"admin","buyerPhone":null,"buyerid":1,"appointmentTime":"2018-09-07#14:00-17:00","doctorname":"\b王辉","doctorid":3,"oneprice":100,"totalprice":null,"r1":"d6973f44-c28b-483f-af20-1c4227fb65bb","r2":null,"r3":null}]
     * code : 0
     */

    public int code;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * id : 41
         * buyername : admin
         * buyerPhone : null
         * buyerid : 1
         * appointmentTime : 2018-09-09#20:00-21:00
         * doctorname : 王辉
         * doctorid : 3
         * oneprice : 100
         * totalprice : null
         * r1 : d6973f44-c28b-483f-af20-1c4227fb65bb
         * r2 : null
         * r3 : null
         */

        public int id;
        public String buyername;
        public String buyerPhone;
        public int buyerid;
        public String appointmentTime;
        public String doctorname;
        public int doctorid;
        public int oneprice;
        public String totalprice;
        public String r1;
        public String r2;
        public String r3;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id=" + id +
                    ", buyername='" + buyername + '\'' +
                    ", buyerPhone='" + buyerPhone + '\'' +
                    ", buyerid=" + buyerid +
                    ", appointmentTime='" + appointmentTime + '\'' +
                    ", doctorname='" + doctorname + '\'' +
                    ", doctorid=" + doctorid +
                    ", oneprice=" + oneprice +
                    ", totalprice='" + totalprice + '\'' +
                    ", r1='" + r1 + '\'' +
                    ", r2='" + r2 + '\'' +
                    ", r3='" + r3 + '\'' +
                    '}';
        }
    }
}
