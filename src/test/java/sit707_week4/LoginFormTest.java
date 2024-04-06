package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.

 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223561446";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandriya";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	@Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null,"xyz");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null,"sandri_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("san", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("san", "xyz");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("san", "sandri_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("sandriya", null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("sandriya", "xyz");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndEmptyValCode()
    {
		LoginStatus status = LoginForm.login("sandriya", "sandri_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertFalse(LoginForm.validateCode(" "));
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode()
    {
		LoginStatus status = LoginForm.login("sandriya", "sandri_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertFalse(LoginForm.validateCode("abcd"));
    }
	
	@Test
	public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
		LoginStatus status = LoginForm.login("sandriya", "sandri_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}