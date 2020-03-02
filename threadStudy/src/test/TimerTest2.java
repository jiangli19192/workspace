package test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 循环10秒，
 * ClassName : TimerTest2
 * @author 张江立
 * @date 2016年7月16日 下午9:10:51
 *
 */
public class TimerTest2 {

	
	public static void timer() throws InterruptedException{
		Date initDate = new Date(); // 初始化时间
		int difss = 0; // 秒数
		String interfaceState = "";
		String msg = "超时";
		while(difss < 10){ // 超过10秒退出循环
			Date curDate = new Date();
			difss = getDateDiffSS(initDate, curDate);// 当前时间与初始化时间相差秒数
			System.out.println(difss + "  秒");
			Thread.sleep(1 * 1000);
			
			//interfaceState = "3"; // 查询接口返回状态
			if(interfaceState.equals("2") || interfaceState.equals("3")){
				difss = 10;
				msg = "接口返回异常，异常信息为：";
			}
		}
		
		if(!interfaceState.equals("2")){
			System.out.println("返回接口状态成功");
		} else {
			System.out.println(msg);
		}
	}
	
	
	/**
	 * 计算两个日期相差的秒数
	 * 
	 * @param before
	 * @param after
	 * @return int 相差的秒数
	 */
	public static int getDateDiffSS(Date before, Date after) {
		if (before == null || after == null)
			return 0;
		Calendar calendar1 = new GregorianCalendar();
		Calendar calendar2 = new GregorianCalendar();
		calendar1.setTime(before);
		calendar2.setTime(after);
		int diff = (int) ((calendar2.getTime().getTime() - calendar1.getTime().getTime()) / 1000);
		return diff;
	}
	
	public static void main(String[] args) {
		try {
			TimerTest2.timer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
