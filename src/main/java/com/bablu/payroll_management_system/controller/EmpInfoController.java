/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.DepartmentService;
import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.dao.JobTypeService;
import com.bablu.payroll_management_system.model.EmpInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.DepthTest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpInfoController {
    
    @Autowired
    EmpInfoService eis;
    @Autowired
    JobTypeService jts;
    @Autowired
    DepartmentService ds;
    @Autowired
    JobTitleService jtls;
    @Autowired
    private ServletContext servletContext;
    
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "joiningdate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    @RequestMapping("/showempinfopage")
    public ModelAndView showempinfopage() {
        String empinfolist = eis.viewEmpInfo();
        String jobtypegsonlist = jts.viewJobType();
        String departmentlist = ds.viewDepartment();
        String jobtitlelist = jtls.viewJobTitle();

        ModelAndView mv = new ModelAndView("addempinfo", "newempinfoObject", new EmpInfo());
        mv.addObject("empinfolist", empinfolist);
        mv.addObject("departmentlist", departmentlist);
        mv.addObject("jobtypemodelobject", jobtypegsonlist);
        mv.addObject("jobtitlemodelobject", jobtitlelist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/empinfoadd", params = "Add")
    public String addempinfopage(@ModelAttribute("newempinfoObject") EmpInfo empinfo, HttpServletRequest request) {
        eis.insertEmpInfo(empinfo);
        String path = servletContext.getRealPath("/");
        System.out.println(path);
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        
        String p = targetcut + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(empinfo.getEmpid()) + "" + ".jpg";
         System.out.println(p);
        MultipartFile filedet = empinfo.getEmpimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
        return "redirect:/showempinfopage";
    }
    @RequestMapping(value = "/empinfoadd", params = "Edit")
    public String editempinfo(@ModelAttribute("newempinfoObject") EmpInfo empinfo, HttpServletRequest request) {
        eis.updateEmpInfo(empinfo.getEmpid(), empinfo);
        String path = servletContext.getRealPath("/");
        String projectcut = path.substring(0, path.lastIndexOf("\\"));
        String targetcut = projectcut.substring(0, projectcut.lastIndexOf("\\"));
        String targetcut1 = targetcut.substring(0, targetcut.lastIndexOf("\\"));
//        path = path + String.valueOf(product.getProductid()) + "" + ".jpg";
        String p = targetcut1 + "\\src\\main\\webapp\\resources\\pimage\\" + String.valueOf(empinfo.getEmpid()) + "" + ".jpg";
        MultipartFile filedet = empinfo.getEmpimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                File f = new File(p);
                if (f.exists()) {
                    f.delete();
                    FileOutputStream fos = new FileOutputStream(f);
                    BufferedOutputStream bs = new BufferedOutputStream(fos);
                    bs.write(bytes);
                    bs.close();
                    fos.close();
                    Thread.sleep(10000);
                    System.out.println("File Uploaded Successfully");
                }
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
        return "redirect:/showempinfopage";
    }
    @RequestMapping("/editempinfo")
    public ModelAndView editempinfopage(@RequestParam("getpid") int pid) {
        String departmentlist = ds.viewDepartment();
        String jobtypegsonlist = jts.viewJobType();
        String empinfolist = eis.viewEmpInfo();
        String jobtitlelist = jtls.viewJobTitle();
        
        ModelAndView mv = new ModelAndView("addempinfo", "newempinfoObject", eis.viewOneEmpInfo(pid));
        mv.addObject("empinfolist", empinfolist);
        mv.addObject("departmentlist", departmentlist);
        mv.addObject("jobtypemodelobject", jobtypegsonlist);
        mv.addObject("jobtitlemodelobject", jobtitlelist);
        mv.addObject("check", "false");
        return mv;
    }
     @RequestMapping("removingempinfo/{empinfoId}")
    public String removeproduct(@PathVariable("empinfoId") int empinfoid) {
        eis.deleteEmpInfo(empinfoid);
        return "redirect:/showempinfopage";
    }
}
