package servlet;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet{

	@Override
	// 接收到請求, 瀏覽器只是殼透過伺服器提供, doGet是程式進入點(跟Java的main不同(還有其他的), 不同大樓不可能有一樣的門)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 生成樂透號碼
		Random random = new Random(); // 隨機數物件
		Set<Integer>numbers = new LinkedHashSet<>(); // 放樂透號碼的容器
		while (numbers.size() < 5) {
			int number = random.nextInt(39)+1; // 0~38+1
			numbers.add(number);
		}
		// 透過 resp 將資料顯示在瀏覽器
		// resp.getWriter().print(numbers);  要用JSP所以不用了
		// 2. 生成調度器(分派器)
		RequestDispatcher rd = req.getRequestDispatcher("/lottery.jsp");
		// 3. 傳遞樂透號碼
		req.setAttribute("numbers", numbers); // 裝配要傳遞的內容, setAttribute是要傳遞資料
		rd.forward(req, resp); // 傳給JSP
		// 架構由Servlet執行, 因此要從Servlet執行(用JSP會少東西)
	}
}
