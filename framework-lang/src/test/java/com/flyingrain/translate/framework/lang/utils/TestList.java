package com.flyingrain.translate.framework.lang.utils;

import java.util.List;

public class TestList {

    private String id;

    private TestModel model;

    private List<TestModel> models;

    private List<String> string;

    public TestList(String id, TestModel model, List<TestModel> models) {
        this.id = id;
        this.model = model;
        this.models = models;
    }

    public TestList(String id, TestModel model, List<TestModel> models, List<String> string) {
        this.id = id;
        this.model = model;
        this.models = models;
        this.string = string;
    }

    public List<String> getString() {
        return string;
    }

    public void setString(List<String> string) {
        this.string = string;
    }

    public TestList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TestModel getModel() {
        return model;
    }

    public void setModel(TestModel model) {
        this.model = model;
    }

    public List<TestModel> getModels() {
        return models;
    }

    public void setModels(List<TestModel> models) {
        this.models = models;
    }
}
