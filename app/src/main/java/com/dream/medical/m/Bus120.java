package com.dream.medical.m;

import java.util.List;

/**
 * Created by 惜梦_ on 2018/10/6.
 */

public class Bus120 {

    /**
     * bus : ["39.92281162576679,116.48673009495623","39.89006762550499,116.4882787387645","39.96824243349417,116.53157918852159","39.95148390365254,116.52510806104962","39.96684609366442,116.52458500682154","39.97829533046204,116.54911159337257"]
     * code : 0
     */

    public int code;
    public List<String> bus;
    /**
     * result : [{"doctype":"pdf","view_num":"34","fileInfoUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1101","wkHighlight":["gg"],"fileInfoShareUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1101","title":"投行笔记,徐子桐.pdf","doc_id":"1101"},{"doctype":"pdf","view_num":"236","fileInfoUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1802","wkHighlight":["gg","1111"],"fileInfoShareUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1802","title":"投行笔记.pdf","doc_id":"1802"},{"doctype":"pdf","view_num":"65","fileInfoUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1650","wkHighlight":["gg"],"fileInfoShareUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1650","title":"行业常用网站总结.pdf","doc_id":"1650"},{"doctype":"doc","view_num":"92","fileInfoUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1629","wkHighlight":["gg"],"fileInfoShareUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1629","title":"声明和保证-股权转让协议.doc","doc_id":"1629"},{"doctype":"pdf","view_num":"358","fileInfoUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1975","wkHighlight":["gg"],"fileInfoShareUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1975","title":"五债券融资.pdf","doc_id":"1975"},{"doctype":"pdf","view_num":"44","fileInfoUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1919","wkHighlight":["gg"],"fileInfoShareUrl":"http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1919","title":"华泰紫金月月发集合资产管理计划合同.pdf","doc_id":"1919"}]
     * total : 6
     * result_info : 调用成功
     * page_num : 1
     * result_code : 200
     * page_no : 1
     * program_rum_time : 141 ms
     */

    public int total;
    public String result_info;
    public int page_num;
    public String result_code;
    public String page_no;
    public String program_rum_time;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * doctype : pdf
         * view_num : 34
         * fileInfoUrl : http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&file_id=1101
         * wkHighlight : ["gg"]
         * fileInfoShareUrl : http://47.93.181.236:9080/app/file_info_new?keyword_c=&orkeyword_c&share&file_id=1101
         * title : 投行笔记,徐子桐.pdf
         * doc_id : 1101
         */

        public String doctype;
        public String view_num;
        public String fileInfoUrl;
        public String fileInfoShareUrl;
        public String title;
        public String doc_id;
        public List<String> wkHighlight;
    }
}
