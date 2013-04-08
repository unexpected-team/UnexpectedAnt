package com.unexpected.ant.doc_generator;

import java.util.ArrayList;
import java.util.List;

public class ClassInfo implements Comparable<ClassInfo> {
    private String name;
    private String comment;
    private List<MethodInfo> methods = new ArrayList<>();
    private String type;
    private List<AttributeInfo> attributes = new ArrayList<>();

    public ClassInfo() {

    }

    public ClassInfo(String name, String comment) {
        this.comment = comment;
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MethodInfo> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodInfo> methods) {
        this.methods = methods;
    }

    @Override
    public int compareTo(ClassInfo o) {
        return getName().compareTo(o.getName());
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public List<AttributeInfo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeInfo> attributes) {
        this.attributes = attributes;
    }
}
