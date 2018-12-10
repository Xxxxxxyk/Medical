package com.dream.medical.interfaces;

import com.dream.medical.m.AppointDoctorBean;
import com.dream.medical.m.Bus120;
import com.dream.medical.m.Call120;
import com.dream.medical.m.DoctorBean;
import com.dream.medical.m.DoctorTime;
import com.dream.medical.m.LiveBean;
import com.dream.medical.m.LoginBean;
import com.dream.medical.m.OKBean;
import com.dream.medical.m.OrderBean;
import com.dream.medical.m.QuestionsListBean;
import com.dream.medical.m.RegisterBean;
import com.dream.medical.m.ResultBean;
import com.dream.medical.m.TestBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIDoc {

    @POST("test/getQuestionsList")
    Observable<QuestionsListBean> getTestQue();

    @FormUrlEncoded
    @POST("test/getOptionsById")
    Observable<TestBean> getTest(@Field("id") int id);

    @FormUrlEncoded
    @POST("test/getResultById")
    Observable<ResultBean> getResult(@Field("id") int id, @Field("score") int score);

    @FormUrlEncoded
    @POST("subscribe/list")
    Observable<DoctorBean> getDoctor(@Field("page") String page, @Field("limit") String limit, @Field("sidx") String sidx, @Field("order") String desc);

    @GET("appointmentdetails/list")
    Observable<DoctorTime> getDoctorTime(@Query("uId") int uId);

    @FormUrlEncoded
    @POST("member/login")
    Observable<LoginBean> login(@Field("mobile") String mobile, @Field("password") String password);

    @FormUrlEncoded
    @POST("indent/crateIndent")
    Observable<OrderBean> createOrder(@Field("scopeTime") String scopeTime, @Field("oneprice") String oneprice, @Field("doctorId") int doctorId, @Field("doctorname") String doctorName);

    @GET("indent/findIndentForUser")
    Observable<AppointDoctorBean> getAppointDoctor();

    @FormUrlEncoded
    @POST("member/register")
    Observable<RegisterBean> registerUser(@Field("mobile") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("indent/delIndent")
    Observable<OKBean> dissmissAppoint(@Field("indentId") int indentId, @Field("appointmentTime") String appointmentTime, @Field("doctorid") int doctorid);

    @GET("userInfo")
    Observable<String> getUserInfo();

    @FormUrlEncoded
    @POST("location/gps")
    Observable<Bus120> get120Info(@Field("gps") String gps);

    @FormUrlEncoded
    @POST("ambulance/get")
    Observable<Call120> call120(@Field("id") String id);

    @FormUrlEncoded
    @POST("ambulance/sendManage")
    Observable<String> sendNotice(@Field("ticker") String ticker, @Field("title") String title, @Field("text") String text);

    @FormUrlEncoded
    @POST("ambulance/getURlList")
    Observable<LiveBean> getLiveUrl(@Field("url") String url);


}
