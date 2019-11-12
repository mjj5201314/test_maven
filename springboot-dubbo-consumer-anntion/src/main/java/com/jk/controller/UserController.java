package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.ExcelImEx;
import com.jk.util.ExcelUtils;
import com.jk.util.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("show")
    public String show(){

        return "show";
    }

    @RequestMapping("queryuser")
    @ResponseBody
    public List<User> queryuser(){

        return userService.queryuser();
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user) {

        userService.addUser(user);

        return null;
    }

    @RequestMapping("delAll")
    @ResponseBody
    public  String delAll(Integer[] ids){
        userService.delAll(ids);
        return  null;
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUserById(Integer userId){

        return userService.queryUserById(userId);
    }

    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file){
        try {

            InputStream inputStream =file.getInputStream();
            String filename = file.getOriginalFilename();
            boolean xls = ExcelUtils.isXls(filename);
            //创建excel工作薄
            Workbook wrkbook = null;
            if(xls){//03
                wrkbook = new HSSFWorkbook(inputStream);
            }else {//07
                wrkbook = new XSSFWorkbook(inputStream);
            }
            //获取sheet页
            Sheet sheet = wrkbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            List<User> list=new ArrayList<>();

            for (int i=0;i<rowNum;i++){
                Row row = sheet.getRow(i+1);
                String userId = row.getCell(0).getStringCellValue();
                String username = row.getCell(1).getStringCellValue();
                String Loginnumber = row.getCell(2).getStringCellValue();
                String userpwd = row.getCell(3).getStringCellValue();
                String sex = row.getCell(4).getStringCellValue();
                String userbirthday = row.getCell(5).getStringCellValue();
                User user=new User();

                user.setUsername(username);
                user.setLoginnumber(Loginnumber);
                user.setPassword(userpwd);
                user.setSex(sex);
                user.setBirth(userbirthday);

                list.add(user);
            }
            //批量新增
            userService.addUSers(list);
        }catch (IOException  e) {
            e.printStackTrace();
        }
        return "";
    }

    //导出
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response, String filename) throws IOException, IllegalAccessException {
        List<User> list=userService.queryuser();
        String[] titles = {"id","姓名","用户名","密码","性别","生日",};
        ExcelImEx.exportExcel(response,filename, Collections.singletonList(list),titles,"用户信息",User.class);
    }

    @RequestMapping("deriveTable")
    public void deriveTable(HttpServletResponse response,String[] val){
        List<User> ulist = new ArrayList<User>();
        try {
            ulist = userService.queryuser();

            String title = "用户";
            String[] rowname = new String[val.length+1];
            List<Object[]> dataList = new ArrayList<Object[]>();

            if(val!=null && val.length>0){
                for (User users:ulist){
                    Object[] obj = new Object[rowname.length];
                    int valindex = 1;
                    rowname[0] = "序号";
                    obj[0]=users.getUsid();
                    for (int i = 0;i<val.length;i++){
                        if(val[i].equals("1")){
                            rowname[valindex]="编号";
                            obj[valindex]=users.getUserid();
                        }
                        if(val[i].equals("2")){
                            rowname[valindex]="姓名";
                            obj[valindex]=users.getUsername();
                        }
                        if(val[i].equals("3")){
                            rowname[valindex]="用户名";
                            obj[valindex]=users.getLoginnumber();
                        }
                        if(val[i].equals("4")){
                            rowname[valindex]="性别";
                            if(users.getSex().equals("2")){
                                obj[valindex]="男";
                            }else if (users.getSex().equals("1")){
                                obj[valindex]="女";
                            }
                        }
                        if(val[i].equals("5")){
                            rowname[valindex]="生日";
                            obj[valindex]=users.getBirth();
                        }

                        valindex++;
                    }
                    dataList.add(obj);
                }
            }else {
                rowname= new String[]{"序号","编号","姓名","用户名","性别","生日"};
                for (User users:ulist){
                    Object[] obj = new Object[rowname.length];
                    obj[0] = users.getUsid();
                    obj[1] = users.getUserid();
                    obj[2] = users.getUsername();
                    obj[3] = users.getLoginnumber();
                    obj[4] = users.getPassword();
                    if (users.getSex().equals("1")){
                        obj[5] = "男";
                    }else {
                        obj[5] = "女";
                    }
                    obj[6] = users.getBirth();

                    dataList.add(obj);
                }
            }
            ExportExcel exportExcel = new ExportExcel(title,rowname,dataList,response);
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    }




