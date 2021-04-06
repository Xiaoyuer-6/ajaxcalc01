import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-06
 * Time: 11:41
 */
public class MyCalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String msg = "";
        int sum = 0;
        int state = -1;//-1为返回异常，200为返回正常；
        //1.从前端获取参数
        String num1 = request.getParameter("number1");
        String num2 = request.getParameter("number2");
        //非空效验
        if(num1!=null && num2!=null && !num1.equals("") && !num2.equals("")){
            //2相应业务处理
             sum = Integer.parseInt(num1) +
                    Integer.parseInt(num2);
             state = 200;
        }else {
            //非法请求
            msg = "非法请求，参数不全";
        }
        //3.返回结果给前端
        //{"state":%d,"msg":"%s","sum":%d}
        PrintWriter writer = response.getWriter();
        writer.println(String.format("{\"state\":%d,\"msg\":\"%s\",\"sum\":%d}", state,msg,sum));
    }
}
