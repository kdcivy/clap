package com.ktds.framework.common.errorMgmt;

/**
 * 공통 Util 클래스
 * @author SW기술연구소
 * @since 2013. 05. 13
 * @version 1.0
 * @see 
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자                수정내용
 *  -------    --------    ---------------------------
 *  2013.05.13 SW기술연구소              최초생성            
 *
 * </pre>
 */
public class Global {
	/**
	 * 주어진 문자열을 HTML코드로 인코딩시킨다.
	 * @author 
	 * @param aStr HTML코드로 인코딩시킬 문자열
	 * @return HTML코드로 인코딩된 문자열
	 */  
	public static String encodeHTML(String aStr) {
		String src = aStr;
		int len = src.length();
		StringBuffer dst = new StringBuffer(len);
		for (int pos=0; pos < len; ++pos) {
			char ch = src.charAt(pos);
			if (ch == '&') {
				dst.append("&amp;");
			}
			else if (ch == '<') {
				dst.append("&lt;");
			}
			else if (ch == '>') {
				dst.append("&gt;");
			}
			else if(ch == '\n')
			{
				dst.append("<br>");
			}
			else {
				dst.append(ch);
			}
		}
		return dst.toString();
	}

	/**
	 * HTML인코딩된 문자열을 화면에 보여주기 위해 변환
	 * @author :
	 * @param str HTML Decode시킬 문자
	 * @return HTML로 Decode 된 문자열
	 * */
	public static String decodeHTML(String str) {
		String s = str;

		s = replaceString(s, "<BR>", "\n");
		s = replaceString(s,"<br>","\n");

		s = replaceString(s, "&amp;", "&");
		s = replaceString(s, "&lt;", "<");
		s = replaceString(s, "&gt;", ">");
		s = replaceString(s, "&acute;", "'");
		s = replaceString(s, "&quot;", "\"");
		s = replaceString(s, "&brvbar;", "|");

		s = replaceString(s, "&nbsp;", " ");

		return s;
	}
	/**
	 * 전달된 문자열중  'From'을 'To'로 변환
	 * @param String src						전체 문자열
	 * @param String from					변환될 문자열
	 * @param String to						변환시킬 문자열
	 * @return String							변환된 전체 문자열
	 */

	static public String replaceString(String src, String from, String to){
		String s = src;
		StringBuffer res = new StringBuffer(); 
		int pos=-1;

		if ( "".equals(NullCheck(s, "")) || "".equals(NullCheck(from, "")) ) return s;
		String chkdTo = NullCheck(to, "");

		while (true) {
			if ((pos = s.indexOf(from)) == -1) {
				res.append(s);
				break;
			}
			res.append(s.substring(0, pos)).append(chkdTo);
			s = s.substring(pos + from.length());
		}

		return res.toString();
	}
	/**Null, "" String 값일경우 대치문자열로 return 해준다.
	 * @param String paramstr	check할 문자열 
	 * @param String repstr		대치할 문자열
	 * @return String							 
	 */

	public	static String NullCheck(String paramstr, String repstr){
		if (paramstr == null || paramstr.trim().equals("") || "NULL".equals(paramstr.toUpperCase()))
			return repstr;
		else
			return paramstr.trim();
	}
}
