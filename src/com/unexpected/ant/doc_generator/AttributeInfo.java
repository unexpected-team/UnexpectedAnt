package com.unexpected.ant.doc_generator;

public class AttributeInfo implements Comparable<AttributeInfo> {
    private String name;

    private int modifiers;

    private String type;

    public int getModifiers() {
        return modifiers;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(AttributeInfo o) {
        return getName().compareTo(o.getName());
    }
}
