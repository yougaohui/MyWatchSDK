package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 用户信息返回事件;包含身高体重等信息
 */
public class UserInfoEvent extends BaseEvent {
    private int gender; //1 表示男性，0表示女性
    private int age;//年龄
    private int height;//身高 cm
    private int weight;//体重 kg
    private int distanceUnit;//距离单位 1表示公里, 2表示英里

    public UserInfoEvent(int gender, int age, int height, int weight, int distanceUnit) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.distanceUnit = distanceUnit;
    }

    public int getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getDistanceUnit() {
        return distanceUnit;
    }

    @Override
    public String toString() {
        return "UserInfoEvent{" +
                "gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", distanceUnit=" + distanceUnit +
                '}';
    }
}
