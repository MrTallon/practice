import models.Face;
import models.JsonModel;
import utils.GsonUtils;

/**
 * 人脸描述
 *
 * @author yangbo
 * @date 2018/07/19
 */
public class FaceDesc {
    public static void main(String[] agrs) {
        String results = FaceDetect.detect("face/img/hepburn.jpeg");
        JsonModel model = GsonUtils.fromJson(results, JsonModel.class);
        Face face = model.result.face_list[0];

        System.out.println(" 人脸置信度 ：" + (int) (face.face_probability * 100) + "%");
        System.out.println(" 颜值 ：" + (int) face.beauty + " 分");
        System.out.println(" 表情 : " + face.expression.type);
        System.out.println(" 表情置信度 ： " + (int) (face.expression.probability * 100) + "%");
        System.out.println(" 脸型 ：" + face.face_shape.type);
        System.out.println(" 脸型置信度 ： " + (int) (face.face_shape.probability * 100) + "%");
        System.out.println(" 年龄 ：" + face.age + " 岁");
        System.out.println(" 性别 ：" + face.gender.type);
        System.out.println(" 性别置信度 ： " + (int) (face.gender.probability * 100) + "%");
        System.out.println(" 眼镜 ：" + face.glasses.type);
        System.out.println(" 眼镜置信度 ： " + (int) (face.glasses.probability * 100) + "%");
        System.out.println(" 人种 ：" + face.race.type);
        System.out.println(" 人种置信度 ： " + (int) (face.race.probability * 100) + "%");
//        System.out.println(" 关键点坐标 " + Arrays.toString(face.landmark));
    }
}
