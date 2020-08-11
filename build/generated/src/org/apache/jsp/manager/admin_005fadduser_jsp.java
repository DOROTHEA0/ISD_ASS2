package org.apache.jsp.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fadduser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/manager/admin_menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\"/>\n");
      out.write("    <title>Management</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/public.css\"/>\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"topbar-wrap white\" width = \"\">\n");
      out.write("    <div class=\"topbar-inner clearfix\">\n");
      out.write("        <div class=\"topbar-logo-wrap clearfix\">\n");
      out.write("            <ul class=\"navbar-list clearfix\">\n");
      out.write("                <li><a class=\"on\" href=\"admin_index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"#\">Admin:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.USER_FIRST_NAME}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                <li><a href=\"/ISD_ASS2/Logout\">Exit</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"container clearfix\">\n");
      out.write("    <div class=\"sidebar-wrap\">\n");
      out.write("        <div class=\"sidebar-title\">\n");
      out.write("            <h1>Menu</h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"sidebar-content\">\n");
      out.write("            <ul class=\"sidebar-list\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">Management</a>\n");
      out.write("                    <ul class=\"sub-menu\">\n");
      out.write("                        <li><a href=\"DoUserSearch\">User</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("    <div class=\"main-wrap\">\n");
      out.write("        <div class=\"crumb-wrap\">\n");
      out.write("            <div class=\"crumb-list\"><a href=\"#\">Home</a><span class=\"crumb-step\">&gt;</span><a class=\"crumb-name\" href=\"admin_user.jsp\">User</a><span class=\"crumb-step\">&gt;</span><span>New User</span></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"result-wrap\">\n");
      out.write("            <div class=\"result-content\">\n");
      out.write("                <form action=\"/ISD_ASS2/manager/DoUserAdd\" method=\"post\">\n");
      out.write("                    <table class=\"insert-tab\" width=\"100%\">\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>User ID</th>\n");
      out.write("                            <td>\n");
      out.write("                                    <input class=\"common-text required\" id=\"title\" name=\"userId\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>First Name</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"FirstName\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>Second Name</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"SecondName\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>Password</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"Password\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>Date of Birth</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"DOB\" size=\"50\" value=\"\" type=\"date\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>Phone Number</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"Phone\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>Email</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"Email\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>Address</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"Address\" size=\"50\" value=\"\" type=\"text\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th><i class=\"require-red\">*</i>User isActive</th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"common-text required\" id=\"title\" name=\"isActive\" size=\"50\" value=\"\" type=\"text\" list=\"active-list\" autocomplete=\"off\">\n");
      out.write("                                <datalist id=\"active-list\">\n");
      out.write("                                    <option>active</option>\n");
      out.write("                                    <option>deactive</option>\n");
      out.write("                                </datalist>\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                            <th></th>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"btn btn-primary btn6 mr10\" value=\"Submit\" type=\"submit\">\n");
      out.write("                                <input class=\"btn btn6\" onClick=\"history.go(-1)\" value=\"return\" type=\"button\">\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
