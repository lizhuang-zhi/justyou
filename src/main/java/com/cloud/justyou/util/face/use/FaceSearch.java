package com.cloud.justyou.util.face.use;

import AuthService.AuthService;

import com.besjon.pojo.JsonRootBean;
import com.besjon.pojo.User_list;
import com.cloud.justyou.util.face.json.JsonRootBean;
import com.cloud.justyou.util.face.json.User_list;
import com.cloud.justyou.util.face.utils.GsonUtils;
import pack2.FaceVideo_Deng;
import java.io.File;
import java.util.*;

/**
* 人脸搜索
*/
public class FaceSearch {

    private static String select;
    private static Double score = null;
    private static Integer num;

    public static Double getScore() {
        return score;
    }

    public static String getSelect() {
        return select;
    }

    public static String faceSearch(String filepath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", filepath);   //指定图片转Base64格式
            map.put("liveness_control", "NONE");    //不需要活体检测
            map.put("group_id_list", "group_1");    //用户组名自己定义
            map.put("image_type", "BASE64");        //图片格式为Base64
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            //System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args)
    {
        //Base64图片字符串
//        Stirng file = ;

        String resultjson = FaceSearch.faceSearch(file);
        JsonRootBean rootBean = GsonUtils.fromJson(resultjson,JsonRootBean.class);
        User_list list = rootBean.result.user_list[0];

        //获取返回的端口（管理员或者用户）和 匹配得分（100为满分）
        select = list.getUser_info();
        score = list.getScore();

    }
}