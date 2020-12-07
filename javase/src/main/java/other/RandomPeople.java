package other;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * 随机生成个人信息
 *
 * @author YangBo
 * @date 2019/03/03
 */
public class RandomPeople {

    /**
     * 姓
     */
    static String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈",
            "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶",
            "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
            "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费",
            "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于",
            "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧",
            "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴",
            "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席",
            "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟", "徐",
            "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢",
            "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪",
            "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀",
            "羊", "于", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段",
            "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班",
            "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘",
            "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲",
            "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能",
            "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦",
            "雍", "却", "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "浦", "尚", "农", "温",
            "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾", "鱼", "容", "向", "古",
            "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文",
            "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂",
            "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养",
            "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖",
            "益", "桓", "公", "仉", "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归", "海", "晋", "楚",
            "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "篁", "年",
            "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭",
            "密", "敬", "揭", "舜", "楼", "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥",
            "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦", "召", "仪", "风", "介", "巨", "木", "京", "狐",
            "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端", "鲜", "皇", "亓", "老",
            "是", "秘", "畅", "邝", "还", "宾", "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯",
            "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正", "濮阳", "淳于", "单于",
            "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空",
            "兀官", "司寇", "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋",
            "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生", "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪",
            "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门", "毋丘", "贺兰",
            "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"};

    /**
     * 名
     */
    private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

    /**
     * 身份证性别编号
     */
    private static final String[] girlCode = {"1", "3", "5", "7", "9"};
    private static final String[] boyCode = {"0", "2", "4", "6", "8"};

    /**
     * 户籍所在地及区域编号
     */
    private static final Map<String, Integer> registerLocation = new HashMap<>();

    static {
        registerLocation.put("北京市", 110000);
        registerLocation.put("东城区", 110101);
        registerLocation.put("西城区", 110102);
        registerLocation.put("崇文区", 110103);
        registerLocation.put("宣武区", 110104);
        registerLocation.put("朝阳区", 110105);
        registerLocation.put("丰台区", 110106);
        registerLocation.put("石景山区", 110107);
        registerLocation.put("海淀区", 110108);
        registerLocation.put("门头沟区", 110109);
        registerLocation.put("房山区", 110111);
        registerLocation.put("通州区", 110112);
        registerLocation.put("顺义区", 110113);
        registerLocation.put("昌平区", 110114);
        registerLocation.put("大兴区", 110115);
        registerLocation.put("怀柔区", 110116);
        registerLocation.put("平谷区", 110117);
        registerLocation.put("通县", 110200);
        registerLocation.put("密云县", 110228);
        registerLocation.put("延庆县", 110229);
        registerLocation.put("天津市", 120000);
        registerLocation.put("市辖区", 120100);
        registerLocation.put("和平区", 120101);
        registerLocation.put("河东区", 120102);
        registerLocation.put("河西区", 120103);
        registerLocation.put("南开区", 120104);
        registerLocation.put("河北区", 120105);
        registerLocation.put("红桥区", 120106);
        registerLocation.put("东丽区", 120110);
        registerLocation.put("西青区", 120111);
        registerLocation.put("津南区", 120112);
        registerLocation.put("北辰区", 120113);
        registerLocation.put("武清区", 120114);
        registerLocation.put("宝坻区", 120115);
        registerLocation.put("湖县", 120200);
        registerLocation.put("宁河县", 120221);
        registerLocation.put("静海县", 120223);
        registerLocation.put("蓟县", 120225);
    }

    /**
     * 电话开头
     */
    private static String[] telFirst = {"134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159", "130", "131", "132", "155", "156", "133", "153"};

    /**
     * 邮箱
     */
    private static String[] emailLast = {"@qq.com", "@163.com", "@firefox.com"};


    private static final Random random = new Random();

    /**
     * 获取随机数
     *
     * @param start 起
     * @param end   终
     * @return 起-终 的随机数
     */
    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }


    /**
     * 获取手机号
     *
     * @return 手机号
     */
    public static String getTel() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    /**
     * 获取姓名
     *
     * @return 姓名
     */
    public static String getInfoName() {
        int index = random.nextInt(Surname.length - 1);

        // 获得一个随机的姓氏
        String name = Surname[index];

        // 男女比例
        int i = random.nextInt(3);

        // 1/3 的比例为女生
        if (i == 2) {
            int j = random.nextInt(girl.length() - 2);
            name = j % 2 == 0 ? name + girl.substring(j, j + 2) : name + girl.charAt(j);

        } else {
            int j = random.nextInt(boy.length() - 2);
            name = j % 2 == 0 ? name + boy.substring(j, j + 2) : name + boy.charAt(j);
        }
        return name;
    }

    /**
     * 获取姓名和性别
     *
     * @return 姓名和性别
     */
    public static String getInfoNameAndGender() {
        int index = random.nextInt(Surname.length - 1);

        // 获得一个随机的姓氏
        String name = Surname[index];

        // 男女比例
        int i = random.nextInt(3);

        // 1/3 的比例为女生
        if (i == 2) {
            int j = random.nextInt(girl.length() - 2);
            name = j % 2 == 0 ? name + girl.substring(j, j + 2) : name + girl.charAt(j);
            name += "-女";
        } else {
            int j = random.nextInt(boy.length() - 2);
            name = j % 2 == 0 ? name + boy.substring(j, j + 2) : name + boy.charAt(j);
            name += "-男";
        }
        return name;
    }

    /**
     * 获取详细信息
     *
     * @return 姓名-性别-年龄-地区-身份证号-电话-邮箱
     */
    public static String getInfoDetail() {
        int index = random.nextInt(Surname.length);
        int num = random.nextInt(5);
        int email = random.nextInt(emailLast.length);
        // 获得一个随机的姓氏
        String info = Surname[index];

        // 男女比例
        int i = random.nextInt(3);
        int j;
        if (i == 2) {
            j = random.nextInt(girl.length() - 2);
            // 姓名
            info += j % 2 == 0 ? girl.substring(j, j + 2) : girl.charAt(j);
            // 性别
            info += "-女";
            // 年龄-地区-身份证号
            info += "-" + getIdCardDetail(girlCode[num]);
        } else {
            j = random.nextInt(boy.length() - 2);
            // 姓名
            info += j % 2 == 0 ? boy.substring(j, j + 2) : boy.charAt(j);
            // 性别
            info += "-男";
            // 年龄-地区-身份证号
            info += "-" + getIdCardDetail(boyCode[num]);
        }

        // 电话
        info += "-" + getTel();
        // 邮箱
        info += "-" + getNum(100, 2000) + emailLast[email];
        return info;


    }

    /**
     * 获取身份证号码
     *
     * @return
     */
    public static String getIdCardNumber(String code) {
        // 身份证号
        StringBuilder card = new StringBuilder();

        // 区号
        card.append(randomLocationCode().split("-")[1]);

        // 出生日期
        card.append(randomBirthday());

        // 15,16位
        card.append(randomCode());

        // 17位(性别）
        card.append(code);

        // 18位
        card.append(verificationCode(card.toString()));

        return card.toString();
    }

    /**
     * 身份证详细信息
     *
     * @param code 性别
     * @return 年龄-地区-身份证号
     */
    public static String getIdCardDetail(String code) {
        StringBuilder info = new StringBuilder();
        // 年龄
        String age = randomBirthday();
        info.append(2021 - Integer.parseInt(age.substring(0, 4))).append("-");

        // 地区
        String[] location = randomLocationCode().split("-");
        info.append(location[0]).append("-");

        // 区号
        info.append(location[1]);
        // 出生日期
        info.append(age);

        // 15,16位
        info.append(randomCode());

        // 17位(性别）
        info.append(code);

        // 18位
        info.append(verificationCode(info.toString().split("-")[2]));

        return info.toString();
    }

    /**
     * 获取区号
     *
     * @return
     */
    private static String randomLocationCode() {
        int index = (int) (Math.random() * registerLocation.size());
        if (index == 0) {
            index += 1;
        }
        Collection<Integer> values = registerLocation.values();
        Iterator<Integer> it = values.iterator();
        int i = 0;
        int locationCode = 0;
        while (i <= index && it.hasNext() && index != 0) {
            i++;
            it.next();
            if (i == index) {
                locationCode = it.next();
            }
        }
        String locationName = "";
        for (String key : registerLocation.keySet()) {
            if (registerLocation.get(key).equals(locationCode)) {
                locationName = key;
            }
        }
        return locationName + "-" + locationCode;
    }

    /**
     * 随机获取落户派出所代码(第15、16位)
     *
     * @return
     */
    public static String randomCode() {
        int code = (int) (Math.random() * 100);
        if (code < 10) {
            return "0" + code;
        } else {
            return "" + code;
        }
    }

    /**
     * 随机获取出生日期
     *
     * @return
     */
    public static String randomBirthday() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, (int) (Math.random() * 60) + 1950);
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));

        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        builder.append(date);
        return builder.toString();
    }

    /**
     * 计算得到身份证号的第18位：
     * <p>
     * 身份证校验码的计算方法：
     * 将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7－9－10－5－8－4－2－1－6－3－7－9－10－5－8－4－2
     * 将这17位数字和系数相乘的结果相加。
     * 用加出来和除以11，看余数是多少？
     * 余数只可能有0－1－2－3－4－5－6－7－8－9－10这11个数字。
     * <p>
     * 其分别对应的最后一位身份证的号码为1－0－X－9－8－7－6－5－4－3－2。
     */
    private static String verificationCode(String str17) {
        char[] chars = str17.toCharArray();
        if (chars.length < 17) {
            return " ";
        }
        // 前十七位分别对应的系数
        int[] coefficient = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 最后应该取得的第十八位的验证码
        char[] resultChar = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int[] numberArr = new int[17];
        int result = 0;
        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = Integer.parseInt(chars[i] + "");
        }
        for (int i = 0; i < numberArr.length; i++) {
            result += coefficient[i] * numberArr[i];
        }
        return String.valueOf(resultChar[result % 11]);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            String q = getInfoDetail();
            System.out.println(q);
        }
    }
}
