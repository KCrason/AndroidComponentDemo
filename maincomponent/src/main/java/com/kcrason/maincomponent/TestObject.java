package com.kcrason.maincomponent;

/**
 * @author KCrason
 * @date 2018/5/25
 */
public class TestObject {

    /**
     * 空构造方法，必须实现
     */
    public TestObject() {

    }

    public int age;
    public String name;

    public TestObject(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
