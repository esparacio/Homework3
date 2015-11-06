/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elon.tags;


import edu.business.MathThings;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

/**
 *
 * @author Elena
 */
public class CurrencyFormat extends BodyTagSupport {
    private ArrayList<Double> values;
    private Iterator iterator;
    private double value;
    private int years = 1;
    
 @Override
  public int doStartTag() {
    MathThings math = (MathThings)pageContext.findAttribute("math");
    values = math.getArray();
   if (values.size() <= 0) {
     return SKIP_BODY;    } 
   else {
       return EVAL_BODY_BUFFERED;
   }
  }
  

  @Override
  public void doInitBody() throws JspException {
    iterator = values.iterator();
    if (iterator.hasNext()) {
      value = (Double) iterator.next();
      this.setValueAttributes(value);
    }
  }

  private void setValueAttributes(Double value) {
      NumberFormat formatted = NumberFormat.getCurrencyInstance();
      String formatvalue = formatted.format(value);
     pageContext.setAttribute(
     "importantValues", formatvalue);
     pageContext.setAttribute("years", years);
 
  }

  @Override
  public int doAfterBody() throws JspException {
    try {
     if (iterator.hasNext()) {
       years++;
       value = (Double) iterator.next();
       this.setValueAttributes(value);
        return EVAL_BODY_AGAIN;
      } else {
        JspWriter out = bodyContent.getEnclosingWriter();
        bodyContent.writeOut(out);
        return SKIP_BODY;
      }
    } catch (IOException ioe) {
      System.err.println("error in doAfterBody " + ioe.getMessage());
      return SKIP_BODY;
    }
  }
}