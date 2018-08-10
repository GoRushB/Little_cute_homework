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
		String respContent = "δ֪��Ϣ����!";
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
					textMessage.setContent("���ã���ӭ��ע��ַ������ ");
					respXml = MessageUtil.messageToXml(textMessage);
				} else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				} else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");
					if (eventKey.equals("oschina")) {
						List<Article> articleList = new ArrayList<>();
						Article article = new Article();
						article.setTitle("��Դ�й�");
						article.setDescription("��Դ�й�������Ϣ��");
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
						textMessage.setContent("ITeye������2003��9��");
						respXml = MessageUtil.messageToXml(textMessage);
					}
				}
			} else {
				textMessage.setContent("��ͨ���˵�ʹ����ַ��������");
				respXml = MessageUtil.messageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}