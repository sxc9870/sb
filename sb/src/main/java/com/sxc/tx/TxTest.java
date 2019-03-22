package com.sxc.tx;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxc.mapper.TestMapper;

import sb.sb.RedisUtil;

@Service
public class TxTest {

    @org.springframework.beans.factory.annotation.Autowired
    private com.sxc.mapper.TestMapper testMapper;
    @org.springframework.beans.factory.annotation.Autowired
    private TxTest2 TxTest2;

    @Transactional(propagation = Propagation.REQUIRED)
    public void doSigleBook() {
        // testMapper.Select();
        // testMapper.Select();
        // testMapper.inser();
        // TxTest2.doSigleBook3();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSigleBook2() {
        testMapper.inser();
    }

    @Transactional(propagation = Propagation.NESTED)
    public void doSigleBook3() {
        testMapper.inser();
    }
   
    @org.springframework.beans.factory.annotation.Autowired
    private RedisUtil redisUtil;
    public void queryUser() throws IOException {
        // int max=7566052;
        int y=5216279;
    
        redisUtil.set("queryUser", 5216279);
        
        String fname="";
        for (int i = 100; i < Integer.MAX_VALUE; i++) { 
            System.out.println("开始" + i+":y="+y);
            int z=i+1;
            fname="user\\平台出借人明细"+((z)<10?"0"+z:z)+".xls";
            java.io.File f=new java.io.File("d:\\output\\"+fname);
            if (f.exists()) {
                continue;
            }
            y=Integer.valueOf(redisUtil.get("queryUser").toString()); 
            List<java.util.Map<String, Object>> maps = testMapper.queryUser(i * 50000,y);
            if (maps.size() == 0) {
                System.out.println("out");
                break;
            }
            redisUtil.set("queryUser", maps.get(maps.size()-1).get("用户id"));
      
            System.out.println("查询结束:"+i);
            xxx("用户id,姓名,身份证号,电话,注册时间,银行卡号",f, maps);
            System.out.println("结束" + i);
            System.out.println("---------------");
        }
    }
    
    

    public void queryProductOrder() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String key="queryProductOrder";
        core(key,"order\\理财订单（合同）台账【多盈理财部分】",
                "订单id,订单编号,用户id,用户姓名,手机号,身份证号,标的名称,投资期限,购买金额,实际支付金额,预期年化收益率 购买日期,订单状态","id"
                ,TestMapper.class.getMethod("tb_理财订单合同台账", int.class));
    }
   
    
    
    
    
    
    
    
    
    

    private void core(String key,String fnameBase,String title,String ycol,Method m) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
     
        System.out.println(m.getName());
        
        Integer y=null;
        for (int i = 0; i < Integer.MAX_VALUE; i++) { 
            int z=i+1;
            y=(Integer) redisUtil.get(key);
            y=y==null?0:y;
            File f=new java.io.File("d:\\output\\"+fnameBase+((z)<10?"0"+z:z)+".xls");
            if (f.exists()) {
                continue;
            }
            System.out.println("开始" + i+",y="+y);
            List<java.util.Map<String, Object>> maps =(List<Map<String, Object>>) m.invoke( testMapper, y);
            if (maps.size() == 0) {
                System.out.println("out");
                break;
            }
            System.out.println("查询结束:"+i);
            xxx(title,f, maps);
            redisUtil.set(key, maps.get(maps.size()-1).get(ycol));
            System.out.println("结束" + i);
            System.out.println("---------------");
        }
        
    }

    public void xxx(String head,File f, List<java.util.Map<String, Object>> list) throws IOException {
        f.createNewFile();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow titleRow = sheet.createRow(0);
        StringBuilder sb=new StringBuilder(head);
        sb.append("\r\n");
        String[] headsCol=head.split(",");
        
        int i=0;
        for (String string : headsCol) {
            titleRow.createCell(i++).setCellValue(string);
         }
        
        int y=1;
        HSSFRow row = null;
        for (Map<String,Object> map : list) {
            i=0;
            row = sheet.createRow(y++);
            for (String string : headsCol) {
                row.createCell(i++).setCellValue(map.get(string)==null?"":map.get(string).toString());
            }
        }
        wb.write(f);  
       
    }
    
    
    
    
    
    
}
