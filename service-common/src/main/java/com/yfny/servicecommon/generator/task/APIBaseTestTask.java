package com.yfny.servicecommon.generator.task;

import com.yfny.servicecommon.generator.task.base.AbstractTask;
import com.yfny.servicecommon.generator.utils.ConfigUtil;
import com.yfny.servicecommon.generator.utils.FileUtil;
import com.yfny.servicecommon.generator.utils.FreemarketConfigUtils;
import com.yfny.servicecommon.generator.utils.StringUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author GreedyStar
 * Date   2018/4/20
 */
public class APIBaseTestTask extends AbstractTask {

    public APIBaseTestTask(String className) {
        super(className);
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成APIBaseTest填充数据
        System.out.println("Generating APIBaseTest.java");
        Map<String, String> testData = new HashMap<>();
        testData.put("BasePackageName", ConfigUtil.getConfiguration().getPackageName());
        testData.put("TestPackageName", ConfigUtil.getConfiguration().getPath().getBasetest());
        testData.put("Author", ConfigUtil.getConfiguration().getAuthor());
        testData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        String filePath = FileUtil.getTestPath() + StringUtil.package2Path(ConfigUtil.getConfiguration().getPackageName()) + StringUtil.package2Path(ConfigUtil.getConfiguration().getPath().getBasetest());
        String fileName = "APIBaseTest.java";
        // 生成Controller文件
        FileUtil.generateToJava(FreemarketConfigUtils.TYPE_API_BASE_TEST, testData, filePath + fileName);
    }
}
