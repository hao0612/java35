package cn.xdl.Demo1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/haha")*/
public class servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respones) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 通过响应对象设置响应内容的类型以及编码格式
		respones.setContentType("text/html;charset=utf-8");
		//2. 通过响应对象 得到打印流
		PrintWriter pw = respones.getWriter();
		//3 给浏览器打印文本内容
		pw.println("<h1>你好</h1>");
	}
	
}
