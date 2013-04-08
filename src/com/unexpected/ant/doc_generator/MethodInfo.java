package com.unexpected.ant.doc_generator;

public class MethodInfo implements Comparable<MethodInfo> {
    private int modifier;
    private String name;
    private String comment;
    private String returnType;

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    @Override
    public int compareTo(MethodInfo o) {
        return getName().compareTo(o.getName());
    }
}
