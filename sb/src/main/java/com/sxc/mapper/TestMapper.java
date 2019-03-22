package com.sxc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
public interface TestMapper {

    @Insert("INSERT INTO sxc1.ta(uuid,oid)  values(2,2) ")
    void insert();

    @Insert("INSERT INTO sxc.ta(uuid,oid)  values(3,3) ")
    void inser();

    @Select("select * from sxc.ta ")
    Object Select();

    @Select("SELECT u.id AS 用户id, u.real_name AS 姓名, u.user_id_number AS 身份证号, u.mobile AS 电话, u.create_time AS 注册时间, b.bank_card_number AS 银行卡号 FROM yinglicai.ylc_user u LEFT JOIN yinglicai.ylc_bank_card b ON u.id = b.user_id AND b.is_delete = 1 AND b. STATUS = 1 WHERE u.is_delete = 1"
            + " and u.id>${y} ORDER BY u.id limit 0,50000 ")
    List<Map<String, Object>> queryUser(@Param("x")int x,@Param("y")int y);

    
    
    
    
    
    
    
//    @Select("SELECT o.id AS 订单id, o.order_number AS 订单编号, o.user_id AS 用户id, u.real_name AS 用户姓名, u.mobile AS 手机号, u.user_id_number AS 身份证号, p.short_title AS 标的名称, CONCAT(p.term, '', p.term_type) AS 投资期限, pb.buy_money AS 购买金额, pb.real_buy_money AS 实际支付金额, p.exp_annual_yield AS 预期年化收益率, pb.buy_comp_time AS 购买日期, CASE WHEN pb. STATUS = 1 THEN '已付款' WHEN pb. STATUS = 2 THEN '付款成功' WHEN pb. STATUS = 3 THEN '购买资金回退' WHEN pb. STATUS = 4 THEN '收益中' WHEN pb. STATUS = 5 THEN '已兑付' WHEN pb. STATUS = 6 THEN '已取消' WHEN pb. STATUS = 7 THEN '已退款' END AS 订单状态 FROM yinglicai.ylc_product_buy pb INNER JOIN yinglicai.ylc_orders o ON o.id = pb.freeze_order_id INNER JOIN yinglicai.ylc_user u ON u.id = o.user_id INNER JOIN yinglicai.ylc_product_trust pt ON pt.product_id = pb.product_id INNER JOIN yinglicai.ylc_product p ON p.id = pb.product_id WHERE pb. STATUS > 1 AND pb.is_delete = 1   limit ${x},50000")
//    List<Map<String, Object>> queryProductOrder(@org.apache.ibatis.annotations.Param("x")int x);

    @Select("SELECT * from tb_理财订单合同台账   where id>${x}   limit 50000")
    List<Map<String, Object>> tb_理财订单合同台账(@org.apache.ibatis.annotations.Param("x")int x);

    
    
    
//    @Select("SELECT o.id AS 订单id, o.order_number AS 订单编号, o.user_id AS 用户id, u.real_name AS 用户姓名, u.mobile AS 手机号, u.user_id_number AS 身份证号, ib.product_name AS 标的名称, DATEDIFF( ib.subs_call_time, ib.earn_origin_time ) AS 投资期限, ib.buy_money AS 购买金额, ib.real_pay_money AS 实际支付金额, ic.yield AS 预期年化收益率, ib.buy_comp_time AS 购买日期, CASE WHEN ib. STATUS = 1 THEN '已付款' WHEN ib. STATUS = 2 THEN '付款成功' WHEN ib. STATUS = 3 THEN '收益中' WHEN ib. STATUS = 4 THEN '已兑付' WHEN ib. STATUS = 5 THEN '已退款' END AS 订单状态 FROM yinglicai.ylc_intellect_buy ib INNER JOIN yinglicai.ylc_orders o ON o.id = ib.order_id INNER JOIN yinglicai.ylc_user u ON u.id = o.user_id LEFT JOIN yinglicai.ylc_intellect_continue ic ON ic.buy_order_id = ib.order_id AND ic.periods_num = 1 AND ic.is_delete = 1 WHERE ib. STATUS > 0 AND ib.is_delete = 1 AND ib.buy_comp_time < '2018-06-21'  limit ${x},50000")
//    List<Map<String, Object>> queryIBProductOrder(@org.apache.ibatis.annotations.Param("x")int x);

}