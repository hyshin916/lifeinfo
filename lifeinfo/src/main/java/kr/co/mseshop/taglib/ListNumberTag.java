package kr.co.mseshop.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class ListNumberTag extends TagSupport {

    private static final long serialVersionUID = 7093148289679389642L;

    private String name;

    private boolean isAscending = true;

    public int doStartTag() throws JspTagException {
        return SKIP_BODY;
    }

    public int doEndTag() throws JspTagException {
        try {
            PageHolder pageHolder = (PageHolder) lookup(pageContext, name, "request");

            if (pageHolder == null) {
                return SKIP_BODY;
            }

            Integer currentNo = (Integer) this.pageContext.getRequest().getAttribute(
                    "kr.go.archives.taglib.ListNumberTag.no");

            if (currentNo == null) {
                int no = 0;

                if (this.isAscending == true) {
                    no = pageHolder.getLineSize() * pageHolder.getCurrentPage()
                            - pageHolder.getLineSize() + 1;
                }
                else {
                    no = pageHolder.getTotalRows()
                            - (pageHolder.getLineSize() * pageHolder.getCurrentPage() - pageHolder
                                    .getLineSize());
                }

                this.pageContext.getRequest().setAttribute("kr.go.archives.taglib.ListNumberTag.no", new Integer(no));
                pageContext.getOut().print(no);
            }
            else {
                if (this.isAscending == true) {
                    this.pageContext.getRequest().setAttribute("kr.go.archives.taglib.ListNumberTag.no",
                            new Integer(currentNo.intValue() + 1));
                    pageContext.getOut().print(currentNo.intValue() + 1);
                }
                else {
                    this.pageContext.getRequest().setAttribute("kr.go.archives.taglib.ListNumberTag.no",
                            new Integer(currentNo.intValue() - 1));
                    pageContext.getOut().print(currentNo.intValue() - 1);
                }
            }
        }
        catch (Exception e) {
            throw new JspTagException(e.toString());
        }

        return EVAL_PAGE;
    }

    protected Object lookup(PageContext pageContext, String name, String scope) throws JspTagException {
        Object bean = null;

        if (scope == null) {
            bean = pageContext.findAttribute(name);
        }
        else if (scope.equalsIgnoreCase("page")) {
            bean = pageContext.getAttribute(name, PageContext.PAGE_SCOPE);
        }
        else if (scope.equalsIgnoreCase("request")) {
            bean = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
        }
        else if (scope.equalsIgnoreCase("session")) {
            bean = pageContext.getAttribute(name, PageContext.SESSION_SCOPE);
        }
        else if (scope.equalsIgnoreCase("application")) {
            bean = pageContext.getAttribute(name, PageContext.APPLICATION_SCOPE);
        }
        else {
            throw new JspTagException("Invalid scope " + scope);
        }

        return (bean);
    }

    public void setName(String string) {
        name = string;
    }

    public void setIsAscending(boolean isAscending) {
        this.isAscending = isAscending;
    }
}
