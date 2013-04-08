package com.unexpected.ant.doc_generator;

import java.io.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentGenerator {
    PrintStream printStream;
    private List<ClassInfo> classes = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        new DocumentGenerator(new FileOutputStream("doc.html")).generate();
    }

    public DocumentGenerator(OutputStream outputStream) {
        printStream = new PrintStream(outputStream);

    }

    public void generate() throws IOException {
        processDir("./src");
        Collections.sort(classes);
        for (ClassInfo classInfo : classes) {
            if (!classInfo.getType().equals("class")) {
                printStream.printf("<h2>%s(%s)</h2>\n%s<br><br>\n", classInfo.getName(), classInfo.getType(), classInfo.getComment());
            } else {
                printStream.printf("<h2>%s</h2>\n%s<br><br>\n", classInfo.getName(), classInfo.getComment());
            }
            Collections.sort(classInfo.getAttributes());
            for (AttributeInfo attributeInfo : classInfo.getAttributes()) {
                printStream.printf("<li><b>-%s: %s</b></li>\n", attributeInfo.getName(), attributeInfo.getType());
            }
            printStream.println("<br>");
            Collections.sort(classInfo.getMethods());
            for (MethodInfo methodInfo : classInfo.getMethods()) {
                printStream.print("<li><b>");
                if (Modifier.isPrivate(methodInfo.getModifier())) {
                    printStream.print("-");
                }
                if (Modifier.isPublic(methodInfo.getModifier())) {
                    printStream.print("+");
                }
                if (Modifier.isProtected(methodInfo.getModifier())) {
                    printStream.print("#");
                }
                String comment = methodInfo.getComment();
                if (comment == null) {
                    comment = "";
                } else {
                    comment = "- " + comment;
                }
                if (methodInfo.getReturnType() == null || methodInfo.getReturnType().equals("void")) {
                    printStream.printf("%s</b> %s</li>\n", methodInfo.getName(), comment);
                } else {
                    printStream.printf("%s: %s</b> %s</li>\n", methodInfo.getName(), methodInfo.getReturnType(), comment);
                }
            }
            printStream.println("<br><br>");

        }

    }

    public void processDir(String sDir) throws FileNotFoundException {
        File[] faFiles = new File(sDir).listFiles();
        for (File file : faFiles) {
            if (file.getName().contains(".java")) {
                ClassInfo e = processFile(file);
                if (e != null) {
                    classes.add(e);
                }
            }
            if (file.isDirectory() && !file.getName().contains("skeleton")) {
                processDir(file.getAbsolutePath());
            }
        }
    }

    private ClassInfo processFile(File file) throws FileNotFoundException {
        String content = readFile(file);
        ClassInfo classInfo = getClassInfo(content);
        return classInfo;
    }

    private ClassInfo getClassInfo(String fileContent) {
        Pattern pattern = Pattern.compile("\\Q**\\E([^@]+).*public( abstract)* (enum|class|interface) ([^\\{]+) \\{", Pattern.MULTILINE + Pattern.DOTALL);
        Matcher matcher = pattern.matcher(fileContent);
        if (!matcher.find()) {
            return null;
        }
        String comment = matcher.group(1);
        comment = comment.replace("\r\n", "").replace("*", "").replace("/", "").replaceAll("\\s+", " ").trim();
        ClassInfo classInfo = new ClassInfo(matcher.group(4), comment);
        classInfo.setType(matcher.group(3));
        classInfo.getMethods().addAll(findMethods(fileContent, classInfo));
        classInfo.getAttributes().addAll(findAttributes(fileContent, classInfo));
        return classInfo;
    }

    private List<AttributeInfo> findAttributes(String fileContent, ClassInfo classInfo) {
        Pattern pattern = Pattern.compile("(private|protected) ([, a-zA-Z0-9<>]+) ([^ =]+).*?;");
        Matcher matcher = pattern.matcher(fileContent);
        List<AttributeInfo> attributes = new ArrayList<>();
        while (matcher.find()) {
            AttributeInfo info = new AttributeInfo();
            info.setName(matcher.group(3));
            info.setModifiers(getModifier(matcher.group(1)));
            info.setType(matcher.group(2));
            attributes.add(info);
        }

        return attributes;
    }

    private List<MethodInfo> findMethods(String fileContent, ClassInfo classInfo) {
        Pattern pattern;
        if (classInfo.getType().equals("interface")) {
            pattern = Pattern.compile("(\\*\\*([^@/]+)[^/]*/\\s*)?(public)? ?([a-zA-Z0-9<>, ]+) ([^ ]+\\([^\\r]*?\\));", Pattern.MULTILINE + Pattern.DOTALL);
        } else {
            pattern = Pattern.compile("(\\*\\*([^@/]+)[^/]*/\\s*)?(public|private|protected) ?([a-zA-Z0-9<>, ]+) ([^ ]+\\([^\\r]*?\\)) \\{", Pattern.MULTILINE + Pattern.DOTALL);
        }
        Matcher matcher = pattern.matcher(fileContent);
        List<MethodInfo> returnList = new ArrayList<>();
        while (matcher.find()) {
            MethodInfo method = new MethodInfo();
            String comment = matcher.group(2);
            if (comment != null) {
                comment = comment.replace("\r\n", "").replace("*", "").replaceAll("\\s+", " ").trim();
            }
            method.setComment(comment);
            if (classInfo.getType().equals("interface")) {
                method.setModifier(Modifier.PUBLIC);
            } else {
                method.setModifier(getModifier(matcher.group(3)));
            }
            String returnType = matcher.group(4);
            if (returnType != null) {
                returnType = returnType.trim();
                if ((returnType.equals("if") || returnType.equals("for"))) {
                    continue;
                }
            }
            method.setReturnType(returnType);
            method.setName(matcher.group(5));
            returnList.add(method);
        }

        return returnList;
    }

    private int getModifier(String header) {
        if ("private".equals(header)) {
            return Modifier.PRIVATE;
        }
        if ("public".equals(header)) {
            return Modifier.PUBLIC;
        }
        if ("protected".equals(header)) {
            return Modifier.PROTECTED;
        }
        return 0;
    }

    private String readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String ret = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return ret;
    }
}
