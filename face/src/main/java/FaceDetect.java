import utils.Base64Util;
import utils.FileUtil;
import utils.GsonUtils;
import utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 人脸检测与属性分析
 *
 * @author yangbo
 */
class FaceDetect {

    static String detect(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", Base64Util.encode(FileUtil.readFileByBytes(filePath)));
            map.put("face_field", "age,beauty,expression,faceshape,gender,glasses,landmark,race,quality,facetype");
            map.put("image_type", "BASE64");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}