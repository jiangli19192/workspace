package com.zjl.study.string.splitTest;


/**
 * 解析字符串XML文件内SolutionMode标签中间的值
 * 
 * ClassName : SplitXmlTagTest
 * @author 张江立
 * @date 2021年3月11日 下午5:58:39
 *
 */
public class SplitXmlTagTest {

	public static void main(String[] args) {
		System.out.println(splitSolutionModeTagValueFromXmlString());
	}
	
	private static String splitSolutionModeTagValueFromXmlString() {
		String xmlContent = "<SectionData><OutputType>Multiple cto</OutputType><SolutionMode><![CDATA[HPC and AI - LESI Solution]]></SolutionMode><MasterSlices>HPCLESI,DSSG,DSSM,LESIRACK,HPCALL</MasterSlices><SBSlices></SBSlices><UserMode></UserMode><Extra></Extra></SectionData>";
		
		String prefix = "<SolutionMode><![CDATA[", suffix = "]]></SolutionMode>";
		
		return xmlContent.substring(xmlContent.indexOf(prefix) + prefix.length(), xmlContent.lastIndexOf(suffix));
	}
}
