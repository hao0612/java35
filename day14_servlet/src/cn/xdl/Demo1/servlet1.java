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
		//1. ͨ����Ӧ����������Ӧ���ݵ������Լ������ʽ
		respones.setContentType("text/html;charset=utf-8");
		//2. ͨ����Ӧ���� �õ���ӡ��
		PrintWriter pw = respones.getWriter();
		//3 ���������ӡ�ı�����
		pw.println("<h1>���</h1>");
	}
	
}
