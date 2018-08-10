package ylz.wx.menu;

import ylz.wx.pojo.Token;
import ylz.wx.util.*;
import org.slf4j.*;

public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	private static Menu getMenu() {
		ViewButton btn10 = new ViewButton();
		btn10.setName("考试系统");
		btn10.setType("view");
		btn10.setUrl("http://c2tdzu.natappfree.cc/webProject/jsp/home.jsp");
		ViewButton btn100 = new ViewButton();
		btn100.setName("成绩管理系统");
		btn100.setType("view");
		btn100.setUrl("http://c2tdzu.natappfree.cc/studentProject/jsp/index.jsp");
		ClickButton btn11 = new ClickButton();
		btn11.setName("开源中国");
		btn11.setType("click");
		btn11.setKey("oschina");
		ClickButton btn12 = new ClickButton();
		btn12.setName("ITeye");
		btn12.setType("click");
		btn12.setKey("iteye");
		ViewButton btn13 = new ViewButton();
		btn13.setName("CocoaChina");
		btn13.setType("view");
		btn13.setUrl("http://www.iteye.com");
		ViewButton btn21 = new ViewButton();
		btn21.setName("tomcat");
		btn21.setType("view");
		btn21.setUrl("http://tomcat.apache.org");
		ViewButton btn22 = new ViewButton();
		btn22.setName("eclipse");
		btn22.setType("view");
		btn22.setUrl("https://www.eclipse.org");
		ViewButton btn23 = new ViewButton();
		btn23.setName("SQLite Studio");
		btn23.setType("view");
		btn23.setUrl("https://sqlitestudio.pl");
		ViewButton btn24 = new ViewButton();
		btn24.setName("bootstrap");
		btn24.setType("view");
		btn24.setUrl("http://www.bootcss.com");
		ViewButton btn25 = new ViewButton();
		btn25.setName("frp");
		btn25.setType("view");
		btn25.setUrl("https://github.com/fatedier/frp");
		ViewButton btn31 = new ViewButton();
		btn31.setName("4399小游戏");
		btn31.setType("view");
		btn31.setUrl("http://4399.com");
		ViewButton btn32 = new ViewButton();
		btn32.setName("7k7k小游戏");
		btn32.setType("view");
		btn32.setUrl("http://7k7k.com");
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("技术交流");
		mainBtn1.setSub_button(new Button[] { btn10, btn100, btn11, btn12,
				btn13 });
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("技术支持");
		mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("小游戏网站");
		mainBtn3.setSub_button(new Button[] { btn31, btn32 });
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
		return menu;
	}

	public static void main(String[] args) {
		String appId = "wxee0de05e17dc3519";
		String appSecret = "c520c52948eef101deb636e1830454ca";
		Token token = CommonUtil.getToken(appId, appSecret);
		if (null != token) {
			boolean result = MenuUtil.createMenu(getMenu(),
					token.getAccessToken());
			if (result)
				log.info("菜单创建成功");
			else {
				log.info("菜单创建失败");
			}
		}
	}
}