package Tags;import javax.servlet.jsp.JspException;import javax.servlet.jsp.JspWriter;import javax.servlet.jsp.tagext.TagSupport;import java.io.IOException;public class LogTag extends TagSupport {    @Override    public int doStartTag() throws JspException {        String html = "<form method=\"get\">\n" +                "    <label>Mail:\n" +                "        <br/>\n" +                "        <input type=\"text\" name=\"mail\"/>\n" +                "    </label>\n" +                "    <br/>\n" +                "    <label>Пароль:\n" +                "        <br/>\n" +                "        <input type=\"text\" name=\"password\"/>\n" +                "    </label>\n" +                "    <br/>\n" +                "    <button type=\"submit\" onclick=\"location.href='/users'\">Войти</button>\n" +                "</form>";        try{            JspWriter out = pageContext.getOut();            out.write(html);        } catch (IOException e) {            throw new JspException(e.getMessage());        }        return  SKIP_BODY;    }}