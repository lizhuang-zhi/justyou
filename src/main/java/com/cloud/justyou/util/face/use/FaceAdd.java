package com.cloud.justyou.util.face.use;

import AuthService.AuthService;
import com.cloud.justyou.util.face.AuthService.AuthService;
import com.cloud.justyou.util.face.utils.GsonUtils;
import com.cloud.justyou.util.face.utils.HttpUtil;
import pack2.FaceVideo;
import pack2.face_regis_frame;

import java.io.File;
import java.util.*;

/**
 * 人脸注册
 */
public class FaceAdd {

    private static String user_id,user_info;

    public static String add(String filepath) {

        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            // filepath 传入BASE64的字符串
            map.put("image", filepath);
            map.put("group_id", "group_1");       //百度人脸库的用户组名
            map.put("user_id", "user1");          //用户注册id
            map.put("user_info", "user's info");      //用户注册端口
            map.put("liveness_control", "NONE");  //非活体检测
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        //前端传入图片字符串
//        String file =  ;

        FaceAdd.add(file);

    }
}