package com.mashibing.poitest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用POI读取excel数据
 */
public class ReadProduct {
    public static void main(String[] args) {
        try {
            //传入excel文件路径
            List<Product> products = read("D:\\ColuldProduct\\Product.xlsx");
            System.out.println(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> read(String path) throws IOException {
        //取出的数据用于返回的集合
        List<Product> products = new ArrayList<>();
        //创建输入流
        FileInputStream inputStream = new FileInputStream(path);
        //在输入流中获取工作薄
        XSSFWorkbook xssfSheets = new XSSFWorkbook(inputStream);
        //在工作薄中获取目标工作表
        XSSFSheet sheetAt = xssfSheets.getSheetAt(0);
        //获取工作表中的行数
        int numberOfRows = sheetAt.getPhysicalNumberOfRows();
        //遍历所有的行，第一行标题行不获取
        for (int i = 1; i < numberOfRows; i++) {
            //获取所有行
            XSSFRow row = sheetAt.getRow(i);
            if (row!=null){
                //创建集合保存每条数据
                List<String> list = new ArrayList<>();
                //对每个单元格进行遍历输出
                for (Cell cell : row) {
                    if (cell!=null){
                        //把单元格的所有数据格式设为string
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        //获取单元格所有数据
                        String value = cell.getStringCellValue();
                        if (value!=null&&!value.equals("")){//如果单元格的数据格式正确
                            list.add(value);//将读取的数据保存到list中
                        }
                    }
                }
                //把获取到的数据封装到list中
                if (list.size()>0){
                    //将list中的数据按下角标索引依次取出，进行对应类型的转换
                 Product product = new Product(Integer.parseInt(list.get(0)),list.get(1),Double.parseDouble(list.get(2)),Integer.parseInt(list.get(3)));
                    products.add(product);
                }
            }

        }
        return products;
    }
}
