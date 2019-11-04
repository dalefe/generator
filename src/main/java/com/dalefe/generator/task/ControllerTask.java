package com.dalefe.generator.task;

import com.dalefe.generator.task.base.AbstractTask;
import com.dalefe.generator.utils.ConfigUtil;
import com.dalefe.generator.utils.FileUtil;
import com.dalefe.generator.utils.FreemarketConfigUtils;
import com.dalefe.generator.utils.StringUtil;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author GreedyStar
 * Date   2018/4/20
 */
public class ControllerTask extends AbstractTask {

    public ControllerTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成Controller填充数据
        System.out.println("Generating " + className + "Controller.java");
        Map<String, String> controllerData = new HashMap<>();
        controllerData.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        controllerData.put("ControllerPackageName", ConfigUtil.getConfiguration().getPath().getController());
        if (StringUtil.isBlank(ConfigUtil.getConfiguration().getPath().getInterf())) {
            controllerData.put("ServicePackageName", ConfigUtil.getConfiguration().getPath().getService());
        } else {
            controllerData.put("ServicePackageName", ConfigUtil.getConfiguration().getPath().getInterf());
        }

        controllerData.put("EntityPackageName", ConfigUtil.getConfiguration().getPath().getEntity());
        controllerData.put("Author", ConfigUtil.getConfiguration().getAuthor());
        try {
//            controllerData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        controllerData.put("ClassName", className);
        controllerData.put("EntityName", StringUtil.firstToLowerCase(className));
        System.out.println("controllerDate构建成功");
        try {
//            String filePath = FileUtil.getSourcePath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getController());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        String filePath = "com.dalefe.test.Controller";
        System.out.println("构建filePath成功");
        String fileName = className + "Controller.java";
        // 生成Controller文件
        System.out.println(filePath + "." + fileName);
        FileUtil.getSourcePath();
        try {
            FileUtil.generateToJava(FreemarketConfigUtils.TYPE_CONTROLLER, controllerData, filePath + "." + fileName);
        } catch (Throwable e) {
            System.out.println("gugiuggu");
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_CONTROLLER, controllerData, filePath +"."+ fileName);

        }

        System.out.println(filePath + "." + fileName);
    }
}