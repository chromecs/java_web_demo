package cn.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * @author wanzhongqiang
 * 创建一个类继承HttpServlet类
 * 创建一个Servlet类的名称为Test继承HttpServlet类同时覆写doGet方法和doPost方法。
 *
 */
public class Test extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	setResponseAccess(response);
        // 设置响应内容类型
        // 设置响应内容类型
        response.setContentType("text/json; charset=utf-8");
                PrintWriter out = response.getWriter();
                
              //创建一个json对象，相当于一个容器，当然这个容器还可以套在另外一个容器里面，这个看业务需要
				JsonObject jsonContainer =new JsonObject();
				//为当前的json对象添加键值对
				jsonContainer.addProperty("count", 5);
				jsonContainer.addProperty("status", 1);
				
				//构建json数组，数组里面也是json
				JsonArray arrayPlayer = new JsonArray();
				
				//构建json数组中的对象
				JsonObject player1 = new JsonObject();
				player1.addProperty("addr", "湖南省长沙市雨花区中意一路与湘府路交汇处");
				player1.addProperty("name", "湖南 长沙市 德思勤四季汇店");
				player1.addProperty("tel", "0731-88990501");
				
				JsonObject player2 = new JsonObject();
				player2.addProperty("addr", "浙江省杭州市临安区锦北街道农林大路99号");
				player2.addProperty("name", "浙江 杭州市 临安宝龙店");
				player2.addProperty("tel", "0571-66558052");
				
				JsonObject player3 = new JsonObject();
				player3.addProperty("addr", "广东省深圳市光明区松白路与长春路交汇处");
				player3.addProperty("name", "广东 深圳市 光明天汇城购物中心店");
				player3.addProperty("tel", "0755-22337379");
				
				JsonObject player4 = new JsonObject();
				player4.addProperty("addr", "上海市青浦区淀山湖大道899弄B区—B1-A万达茂广场");
				player4.addProperty("name", "上海 青浦万达茂店");
				player4.addProperty("tel", "021-88220228");
				
				JsonObject player5 = new JsonObject();
				player5.addProperty("addr", "广东省广州市增城区新塘镇章陂工业大道万达广场");
				player5.addProperty("name", "广东 广州市 新塘万达广场店");
				player5.addProperty("tel", "020-88838779");
				
				//将json对象添加到数组中
				arrayPlayer.add(player1);
				arrayPlayer.add(player2);
				arrayPlayer.add(player3);
				arrayPlayer.add(player4);
				arrayPlayer.add(player5);
			
				
				//最后将json数组装到jsonContainer中
				jsonContainer.add("shops", arrayPlayer);
				PrintWriter writer = response.getWriter();
				System.out.println(jsonContainer);
                 
                out.println(jsonContainer);
               
                      
                  }     
                   
            /**
             * @author wanzhongqiang
             */
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request, response);
            }
            
            private void setResponseAccess(HttpServletResponse response) {
                // 允许该域发起跨域请求
                response.setHeader("Access-Control-Allow-Origin", "*");//*允许任何域
                // 允许的外域请求方式
                response.setHeader("Access-Control-Allow-Methods", "POST, GET");
                // 在999999秒内，不需要再发送预检验请求，可以缓存该结果
                response.setHeader("Access-Control-Max-Age", "999999");
                // 允许跨域请求包含某请求头,x-requested-with请求头为异步请求
                response.setHeader("Access-Control-Allow-Headers",
                        "x-requested-with");
            }
            
        }