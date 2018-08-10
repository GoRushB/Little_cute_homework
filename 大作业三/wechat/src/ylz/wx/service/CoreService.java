package ylz.wx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import ylz.wx.message.resp.Article;
import ylz.wx.message.resp.NewsMessage;
import ylz.wx.message.resp.TextMessage;
import ylz.wx.util.MessageUtil;

public class CoreService {
	public static String processRequest(HttpServletRequest request) {
		String respXml = null;
		String respContent = "未知消息类型!";
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String fromUserName = requestMap.get("FromUserName");
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			System.out.println("ok1");
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String eventType = requestMap.get("Event");
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					textMessage.setContent("您好！欢迎关注网址导航！ ");
					respXml = MessageUtil.messageToXml(textMessage);
				} else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				} else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");
					if (eventKey.equals("oschina")) {
						List<Article> articleList = new ArrayList<>();
						Article article = new Article();
						article.setTitle("开源中国");
						article.setDescription("开源中国社区信息。");
						article.setPicUrl("");
						article.setUrl("http://m.oschina.net");
						articleList.add(article);
						NewsMessage newsMessage = new NewsMessage();
						newsMessage.setToUserName(fromUserName);
						newsMessage.setFromUserName(toUserName);
						newsMessage.setCreateTime(new Date().getTime());
						newsMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);
					} else if (eventKey.equals("iteye")) {
						textMessage.setContent("ITeye创办于2003年9月");
						respXml = MessageUtil.messageToXml(textMessage);
					}
				}
			} else {
				textMessage.setContent("请通过菜单使用网址导航服务！");
				respXml = MessageUtil.messageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}