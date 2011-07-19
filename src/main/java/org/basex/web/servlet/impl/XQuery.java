package org.basex.web.servlet.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.basex.query.item.map.Map;
import org.basex.web.servlet.PrepareParamsServlet;
import org.basex.web.xquery.BaseXContext;

/**
 * This class parses complete XQuery files or modules and returns their result.
 *
 * @author BaseX Team 2005-11, BSD License
 * @author Michael Seiferle <ms@basex.org>
 */
public class XQuery extends PrepareParamsServlet {

  /** This is me, your version. */
  private static final long serialVersionUID = -7694236920689548933L;

  @Override
  public final void
      get(final HttpServletResponse response, final HttpServletRequest req,
          final File f, final Map get, final Map post) throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().write(BaseXContext.query(f, get, post, response, req));
  }
}
