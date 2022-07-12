package easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelTest {

    @Test
    public void Write() {
        List<String> list = new ArrayList<>();
        List<List<String>> header = list.stream().map(Arrays::asList).collect(Collectors.toList());
        List<User> teacherList = new ArrayList<>();
        teacherList.add(new User("111", "Alex", "male", "Fuzhou", new Date()));
        teacherList.add(new User("222", "Beth", "female", "Xiamen", new Date()));
        teacherList.add(new User("333", "Jack", "male", "Fuzhou", new Date()));

        String fileLocate = "src\\main\\resources\\excel\\INFO.xlsx";
        EasyExcel.write(fileLocate, User.class)
                // 表头内容
                .head(header)
                // 表头宽度自适应
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // sheet 标签
                .sheet("info")
                // 写入内容
                .doWrite(teacherList);
    }
}
