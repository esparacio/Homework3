/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon;

import edu.business.MathThings;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.business.User;
import edu.data.UserDB;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elena
 */
public class Calculate extends HttpServlet {
    
    private ArrayList<Double> values;
    
 @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
          
            try{
             double investAmount = Double.parseDouble(request.getParameter("investAmount"));
             double yearlyRate = Double.parseDouble(request.getParameter("yearlyRate"));
             int numYears = Integer.parseInt(request.getParameter("numYears"));
//             double futureValue = investAmount;
             double futureValue = 0; 
             
             MathThings math = new MathThings(numYears,investAmount,yearlyRate);
             futureValue = math.doMath();
             System.out.println("Hi!" + math.getArray());
             
//             ArrayList<Double> values = new ArrayList<Double>();
//            for(int i=0;i<numYears; i++){
//                futureValue = investAmount+(investAmount)*((yearlyRate)/100);
//                investAmount =futureValue;
//                values.add(futureValue);
//        }
//                Array array = new Array();
//                array.setArray(values);
//                System.out.println(array.getArray());
//             
                investAmount=Double.parseDouble(request.getParameter("investAmount"));
                User user = new User(investAmount, yearlyRate, numYears, futureValue);
              
                
                String message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
                request.setAttribute("user", user);
                request.setAttribute("message", message);
                
      ArrayList<Double> values= math.getArray();
      
      request.setAttribute("futureValue", futureValue);
      request.setAttribute("math", math);
      request.setAttribute("values", values);
      
      HttpSession session = request.getSession();
      session.setAttribute("investAmount", investAmount);
      session.setAttribute("numYears", numYears);
      session.setAttribute("yearlyRate", yearlyRate);
         
            }
            catch(NumberFormatException nfe){
                String message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            request.setAttribute("message", message);
            }
   
       
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}