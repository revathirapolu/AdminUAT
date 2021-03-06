package com.revathi.adminuat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Revathi on 12/16/2014.
 */
public class BussinessLibrary extends BaseClass{

    static String empid;
    //Login Method
    public void login(String username,String password)
    {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
    }

    //Logout Method
    public void logout()
    {
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    public void adminCreateEmpLoginDetails(String fname,String lname,String uname,String upassword)
    {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        driver.findElement(By.id("chkLogin")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("user_name")).sendKeys(uname);
        driver.findElement(By.id("user_password")).sendKeys(upassword);
        driver.findElement(By.id("re_password")).sendKeys(upassword);
      //  new Select(driver.findElement(By.id("location"))).selectByVisibleText("ASC_London");
        Utils.selectFromDropDown(By.id("location"),"ASC_London");
        driver.findElement(By.id("btnSave")).click();
        empid = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value"); //Get the emp id
        System.out.println("Emp id is"+empid);
        driver.findElement(By.linkText("Job History")).click();
        driver.findElement(By.id("btnSave")).click();
       // new Select(driver.findElement(By.id("job_job_title"))).selectByVisibleText("Automation Tester");
        Utils.selectFromDropDown(By.id("job_job_title"),"Automation Tester");
       // new Select(driver.findElement(By.id("job_emp_status"))).selectByVisibleText("Probation");
       Utils.selectFromDropDown(By.id("job_emp_status"),"Probation");
      //  new Select(driver.findElement(By.id("job_eeo_category"))).selectByVisibleText("IT Worker");
        Utils.selectFromDropDown(By.id("job_eeo_category"),"IT Worker");
        driver.findElement(By.id("job_effective_date")).clear();
        driver.findElement(By.id("job_effective_date")).sendKeys("2014-06-01");
        driver.findElement(By.id("btnSave")).click();
    }

    public void empCheckLoginDetails()
    {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.linkText("Job History")).click();
      //  driver.findElement(By.linkText("Job History")).click();
       Select sel=new Select(driver.findElement(By.id("job_job_title")));
       String jobTitleOption = sel.getFirstSelectedOption().getText();
        Assert.assertEquals(jobTitleOption,"Automation Tester");
        Select sel1=new Select(driver.findElement(By.id("job_emp_status")));
        String jobStatusOption = sel1.getFirstSelectedOption().getText();
        Assert.assertEquals(jobStatusOption,"Probation");
    }

    public void adminChangeEmpDetails()
    {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        driver.findElement(By.id("empsearch_id")).sendKeys(empid);
        driver.findElement(By.id("searchBtn")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText(empid)).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Job History")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //new Select(driver.findElement(By.id("job_emp_status"))).selectByVisibleText("Permanent");
        Utils.selectFromDropDown(By.id("job_emp_status"),"Permanent");
        driver.findElement(By.id("job_comment")).sendKeys("Employee made permanent");
        driver.findElement(By.id("btnSave")).click();
    }
    public void empCheckChangeDetails()
    {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.linkText("Job History")).click();
        Select sel= new Select(driver.findElement(By.id("job_emp_status")));
        String jobStatusOption = sel.getFirstSelectedOption().getText();
       Assert.assertEquals(jobStatusOption,"Permanent");

    }

}
