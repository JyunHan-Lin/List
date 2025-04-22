package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class PhonePlan {
	
	private Integer minutes; // 通話分類
	private Integer gigabyte;// 流量
	
	// 規則
	static class PhoneRule {
		private String type;
		private Integer price;
		private BiPredicate<Integer, Integer> condition;
		
		public PhoneRule(String type, Integer price, BiPredicate<Integer, Integer> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;
		}
		
		public boolean matches(Integer minutes, Integer gigabyte) {
			return condition.test(minutes, gigabyte);
		}
		
		public String getResult() {
			return type + " | $" + price;
		}
	}
	
	private static final List<PhoneRule> rules =new ArrayList<>();
	
	static {
		rules.add(new PhoneRule("商務型", 1499, (min, gb) -> min > 1000 || gb > 50));
		rules.add(new PhoneRule("一般用戶型", 600, (min, gb) -> min > 500 || gb > 10));
		rules.add(new PhoneRule("長輩節省型", 200, (min, gb) -> min < 200 || gb < 1));
	}
	
	public PhonePlan(Integer minutes, Integer gigabyte) {
		this.minutes = minutes;
		this.gigabyte = gigabyte;
	}

	public PhonePlan(String minutes, String gigabyte) {
		this(Integer.parseInt(minutes), Integer.parseInt(gigabyte));
	}
	
	public String getPhoneRule() {
		return rules.stream()		
				.filter(rule -> rule.matches(minutes, gigabyte)) // 找出符合條件的規則
				.findFirst()								// 取得第一筆匹配的
				.map(PhoneRule::getResult)
				.orElse("無法辨識的手機方案");	
	}
	
	public Integer getMinutes() {
		return minutes;
	}

	public Integer getGigabyte() {
		return gigabyte;
	}

	
	
}

