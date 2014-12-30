package com.revathi.adminuat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Revcathi on 12/16/2014.
 */
public class UatTestSuiteAdmin extends BaseTest {

//--------------------------Test Data------------------------------
    String adminUsername="admin", adminPassword="Insoft12";
    String empUname="rmuppidi"+Utils.generateRandomNo();
    String empPassword="qwerty12";
    String empFname="Revathi",empLname="Muppidi";

    BussinessLibrary blib = new BussinessLibrary();

    @Test
    public void empProbationEnds(){
        blib.login(adminUsername,adminPassword); //Admin Login01
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin")); //checkpoint
        blib.adminCreateEmpLoginDetails(empFname, empLname, empUname, empPassword);
        blib.logout(); //Admin Logout
        blib.login(empUname,empPassword); //Employee login
        blib.empCheckLoginDetails();  //Employee checks the details
        blib.logout(); //Employee Logout
        blib.login(adminUsername,adminPassword); //Admin Login
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin")); //checkpoint
        blib.adminChangeEmpDetails();  //Admin makes Emp Permanent
        blib.logout(); //Admin Logout
        blib.login(empUname,empPassword); //Employee login
        blib.empCheckChangeDetails();
        blib.logout(); //Employee Logout
    }



}
