package com.bablu.payroll_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bablu.payroll_management_system.reportmodel.Report;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import com.bablu.payroll_management_system.daoempl.ReportDAO;
import com.bablu.payroll_management_system.reportmodel.Report2;
import com.bablu.payroll_management_system.reportmodel.ReportPayHistory;
/**
 *
 * @author User
 */
@Controller
public class ReportController {
    
    @RequestMapping(value = "/reportView", method = RequestMethod.GET)
    public String loadSurveyPg(
            @ModelAttribute("reportInputForm") Report reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "report";
    }
    
    @RequestMapping(value = "/reportView", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") Report reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "netsalary";
        ReportDAO jrdao = new ReportDAO();
        Connection conn = null;
        conn = jrdao.getConnection();
        int eid = reportInputForm.getEid();
         String ename = reportInputForm.getEname();
        HashMap<String, Object> hmParams = new HashMap<String, Object>();
        hmParams.put("eid", eid);
         hmParams.put("ename", ename);
        JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);
        jrdao.generateReportPDF(response, hmParams, jasperReport, conn);
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return null;
    }
    @RequestMapping(value = "/reportView2", method = RequestMethod.GET)
    public String loadSurveyPg2(
            @ModelAttribute("report2InputForm") Report2 reportInputForm, Model model) {
        model.addAttribute("report2InputForm", reportInputForm);
        return "report2";
    }
    
    
    @RequestMapping(value = "/reportView2", method = RequestMethod.POST)
    public String generateReport2(@ModelAttribute("report2InputForm") Report2 reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "Empinfo";
        ReportDAO jrdao = new ReportDAO();
        Connection conn = null;
        conn = jrdao.getConnection();
        int empid = reportInputForm.getEmpid();
        String empname = reportInputForm.getEmpname();
        HashMap<String, Object> hmParams = new HashMap<String, Object>();
        hmParams.put("empid", empid);
         hmParams.put("empname", empname);
        JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);
        jrdao.generateReportPDF(response, hmParams, jasperReport, conn);
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return null;
    }
    @RequestMapping(value = "/reportView3", method = RequestMethod.GET)
    public String loadSurveyPg3(
            @ModelAttribute("report3InputForm") Report reportInputForm, Model model) {
        model.addAttribute("report3InputForm", reportInputForm);
        return "report3";
    }
    @RequestMapping(value = "/reportView3", method = RequestMethod.POST)
    public String generateReport3(@ModelAttribute("report3InputForm") Report2 reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "TotalMonthlySalary";
        ReportDAO jrdao = new ReportDAO();
        Connection conn = null;
        conn = jrdao.getConnection();
        int eid = reportInputForm.getEmpid();
         String ename = reportInputForm.getEmpname();
        HashMap<String, Object> hmParams = new HashMap<String, Object>();
        
        JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);
        jrdao.generateReportPDF(response, hmParams, jasperReport, conn);
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return null;
    }
    @RequestMapping(value = "/reportView4", method = RequestMethod.GET)
    public String loadSurveyPg4(
            @ModelAttribute("report4InputForm") Report2 reportInputForm, Model model) {
        model.addAttribute("report4InputForm", reportInputForm);
        return "report4";
    }
    
    
    @RequestMapping(value = "/reportView4", method = RequestMethod.POST)
    public String generateReport4(@ModelAttribute("report4InputForm") Report2 reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "Emploan";
        ReportDAO jrdao = new ReportDAO();
        Connection conn = null;
        conn = jrdao.getConnection();
        HashMap<String, Object> hmParams = new HashMap<String, Object>();
        JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);
        jrdao.generateReportPDF(response, hmParams, jasperReport, conn);
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return null;
    }
    
    @RequestMapping(value = "/reportView5", method = RequestMethod.GET)
    public String loadSurveyPg5(
            @ModelAttribute("report5InputForm") ReportPayHistory reportInputForm, Model model) {
        model.addAttribute("report5InputForm", reportInputForm);
        return "report5";
    }
    
    @RequestMapping(value = "/reportView5", method = RequestMethod.POST)
    public String generateReport5(@ModelAttribute("report5InputForm") ReportPayHistory reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "report2";
        ReportDAO jrdao = new ReportDAO();
        Connection conn = null;
        conn = jrdao.getConnection();
        int empid = reportInputForm.getEmpid();
         String empname = reportInputForm.getEmpname();
        HashMap<String, Object> hmParams = new HashMap<String, Object>();
        hmParams.put("empid", empid);
         hmParams.put("empname", empname);
        JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);
        jrdao.generateReportPDF(response, hmParams, jasperReport, conn);
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return null;
    }
}
