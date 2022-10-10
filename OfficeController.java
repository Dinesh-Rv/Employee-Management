import com.ideas2it.model.EmployeeProjects;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.LeaveRecordsService;
import com.ideas2it.service.EmployeeProjectsService;
import com.ideas2it.service.EmployeeServiceImpl;
import com.ideas2it.service.LeaveRecordsServiceImpl;
import com.ideas2it.service.EmployeeProjectsServiceImpl;

import com.ideas2it.constants.Constants;

import com.ideas2it.utils.ValidationUtils;

import com.ideas2it.model.Employee;
import com.ideas2it.model.LeaveRecords;

import com.ideas2it.enums.EmployeeRole;
import com.ideas2it.enums.EmployeeGender;
import com.ideas2it.enums.LeaveType;

import com.ideas2it.exceptions.MoreCharacterException;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * Implementing Controller for Employee Operations in an office
 * </p>
 *
 * @author Dinesh Kumar R
 * 
 * @modified 21.09.2022
 *
 */
public class OfficeController {							  

    private EmployeeService employeeServiceImpl = new EmployeeServiceImpl();
    private LeaveRecordsService leaveRecordsServiceImpl = new LeaveRecordsServiceImpl();
    private EmployeeProjectsService employeeProjectsServiceImpl = new EmployeeProjectsServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) {	
        OfficeController officeController = new OfficeController();		
        crudLoop:
        while(true) { 	
            String crudChoice = officeController.crudOperation();
            switch (crudChoice) {
            case Constants.EXIT_OPERATION:
	        System.out.println("==================Program terminated succesfully==================");
		break crudLoop;

            case Constants.CREATE_ELEMENT: 												
                officeController.createElement();	
                break;

            case Constants.READ_ELEMENT:
                officeController.readElement();
                break;	

            case Constants.UPDATE_ELEMENT:
                officeController.updateElement(); 
                break;

	    case Constants.DELETE_ELEMENT:
		officeController.deleteElement();
	   	break;

            default:
                System.out.println("+============+Enter a valid choice+===========+");
            } 
        } 
    }

    /**
     *<p>
     * get choice from the user for making crud operations
     *</p>
     *
     * @return the choice the user inputs in crud operation which consists
of create read update and delete
     *       if user enters 1 it returns crudChoice as 1 i.e to create employee details       
     */
    private String crudOperation() {
        String userCrudChoice = null;
        StringBuilder crudChoice = new StringBuilder("+===+========You wanted to?===============+"
                                                      + "\n| 1 |       CREATE Elements               |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 2 |        READ Elements                |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 3 |       UPDATE Elements               |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 4 |       DELETE Elements               |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 0 |   TERMINATE PROGRAM  ! Caution      |"
                                                      + "\n+===+=====================================+");
        System.out.println(crudChoice);
        try {
        userCrudChoice = scanner.nextLine();
        checkUserChoice(userCrudChoice);
        
        } catch (MoreCharacterException e) {
            System.out.println("exception :" + e);
        }

        return userCrudChoice;
    } 	

     /**
     * <p>
     * Throws an exception when a user enters more
than one characted for main crud choice(Custom exception)
     * </p>
     *     
     * @param userChoice
     *        Choice for the main crud   
     */
    public void checkUserChoice(String userChoice) throws MoreCharacterException {
     
        if(userChoice.length() > 1) {
            throw new MoreCharacterException("More than one char isn't supported");
        } 
    }

    public String getValidChoice() {
        int userChoice = 0;
        System.out.println("========Enter the choice========");
        try {
            userChoice = Integer.parseInt(scanner.nextLine());
            if(userChoice <= 9 && userChoice != 0) {
            } else {
                userChoice = 0;
            }
        } catch(NumberFormatException n) {
            System.out.println("========Only Number Choices Are Accepted========");
        }
        return Integer.toString(userChoice);
    }

    public void createElement() {
        Employee validEmployee = null;
        StringBuilder createChoice = new StringBuilder("+===+========You wanted to?============+"
                                                      + "\n| 1 |    CREATE Employee Details       |"
                                                      + "\n+===+==================================+"
                                                      + "\n| 2 |    CREATE Leave Records          |"
                                                      + "\n+===+==================================+"
                                                      + "\n| 3 |   CREATE Employee Projects       |"
                                                      + "\n+===+==================================+"
                                                      + "\n|any|    except above to go back       |"   
                                                      + "\n+===+==================================+");
        System.out.println(createChoice);
        String userChoice = getValidChoice();
        switch(userChoice) {
        case Constants.EXIT_OPERATION:
            System.out.println("Backing");
            break;  
        case Constants.CREATE_EMPLOYEE:
            createEmployee();
            break;
        case Constants.CREATE_LEAVE_RECORD:
            validEmployee = getValidEmployee();
            if(validEmployee != null) {
                createLeaveRecords(validEmployee);
            } else 
                System.out.println("Employee Not Found");
            break;
        case Constants.CREATE_EMPLOYEE_PROJECT:
            validEmployee = getValidEmployee();
            if(validEmployee != null) {
                createEmployeeProject(validEmployee);
            } else 
                System.out.println("Employee Not Found");
            break;
        default:
            System.out.println("An Error Ocurred");
        }
    }

     /**
     * <p>
     * Creates a employee by asking his/her each details
     * </p>
     *        
     */
    public void createEmployee() {

        String employeeRole = getValidRole().toString();

        System.out.println("Enter Employee name: ");
        String employeeName = getValidName();

        String employeeGender = getValidGender().toString();

        System.out.println("Enter Employee Department: ");
        String employeeDepartment = getValidDept();

        System.out.println("Enter Employee Phone Number: ");
        String employeePhoneNumber = getValidPhoneNumber();

        System.out.println("Enter Employee Date Of Birth: ");
        String employeeDateOfBirth = getValidDateOfBirth();

        System.out.println("Enter Employee Email Id: ");
        String employeeEmail = getValidEmail();

        String employeeId = createId();

        String createdAt = currentDateTime();
        String modifiedAt = currentDateTime();
        Employee newEmployeeDetails = new Employee(employeeName, employeeRole, employeeDepartment, employeePhoneNumber,
                                                   employeeDateOfBirth, employeeGender, employeeEmail, employeeId, 
                                                   createdAt, modifiedAt);
        if(employeeServiceImpl.addEmployee(newEmployeeDetails) != null) {
            System.out.println("Employee Addition Unsuccessfull");
        } else {
            System.out.println("Employee Added succesfully");
        }
    }

    /**
     * <p>
     * creates an leave record for employee
     * </p>
     *
     */ 
    public void createLeaveRecords(Employee employee) {

        System.out.println("Leave alloted From: ");
        String fromDate = getValidLeaveDate();

        System.out.println("Leave period ends on: ");
        String toDate = getValidLeaveDate();

        String leaveType = getValidLeaveType().toString();
        String createdAt = currentDateTime();
        String modifiedAt = currentDateTime();
        LeaveRecords record = new LeaveRecords(employee, fromDate, toDate, leaveType, createdAt, modifiedAt);

        int newLeaveId = leaveRecordsServiceImpl.addLeaveRecord(record);
        if(newLeaveId != 0) {
            System.out.println("Absense for " + leaveType + " Recorded succesfully reference leaveId: " + newLeaveId);
        } else {
            System.out.println("Leave record unsuccesfull");
        }
    }

    /**
     * <p>
     * creates an project record for employee
     * </p>
     *
     */ 
    public void createEmployeeProject(Employee employee) {
        
        System.out.println("Project Name: ");
        String projectName = scanner.nextLine();

        System.out.println("Project manager: ");
        String projectManager = scanner.nextLine();

        System.out.println("client Name: ");
        String clientName = scanner.nextLine();

        System.out.println("Start Date: ");
        String startDate = scanner.nextLine();
    
        String createdAt = currentDateTime();
        String modifiedAt = currentDateTime();

        EmployeeProjects record = new EmployeeProjects(projectName, projectManager, clientName,
                                                       startDate, createdAt, modifiedAt);

        if(employeeProjectsServiceImpl.addEmployeeProject(record, employee)) {
            System.out.println("Project record  Successfull");
        } else {
            System.out.println("Project record Unsuccessfull");
        }
    }   

    

    /**
     *<p>
     * Gets the input for the employeeRole and checks if its valid
     *</p>
     *
     * @return role of the employee
     */
    private EmployeeRole getValidRole() {
        EmployeeRole role;
        for(;;) {
            StringBuilder roleChoice = new StringBuilder();
	        roleChoice.append("=============Enter Employee Role================="
                              + "\n1 Trainer"
                              + "\n2 Trainee"
                              + "\n==============================");
            System.out.println(roleChoice);
            int userChoice = Integer.parseInt(getValidChoice());
            if (userChoice <= 2 && userChoice != 0) {
                EmployeeRole employeeRole = EmployeeRole.getEmployeeRole(userChoice);
                if (employeeRole != null) {
                    role = employeeRole;
                    break;
                } else {
                    System.out.println("Please enter a valid choice for Role");
                }
            }
        } 
        return role;
    }

    /**
     *<p>
     * gets the input for gender and checks the gender is valid
     *</p>
     *
     * @return gender of the employee
     */
    private EmployeeGender getValidGender() {
        EmployeeGender gender;     
        for(;;) {
            StringBuilder genderChoice = new StringBuilder();
            genderChoice.append("+===+==Enter Employee Gender==+"
                    + "\n| 1 |          Male           |"
                    + "\n+===+=========================+"
                    + "\n| 2 |         Female          |"
                    + "\n+===+=========================+"
                    + "\n| 3 |       Undefined         |"
                    + "\n==============================+");
            System.out.println(genderChoice);
            int userChoice = Integer.parseInt(getValidChoice());
            if (userChoice <= 3 && userChoice != 0) {
                EmployeeGender employeeGender = EmployeeGender.getEmployeeGender(userChoice);
                if (employeeGender != null) {
                    gender = employeeGender;
                    break;
                } else {
                    System.out.println("Please enter a valid Choice for Gender");
                }
            }
        }
        return gender;
    }

    /**
     * <p>
     * Method to generate an id when an employee is created
     * </p>
     *
     * @return String employeeId
     */ 
    public String createId() {
        int idNumber = 1;
        String lastId = employeeServiceImpl.getEmployeeId();
        try {
            String[] splitId = lastId.split("T");
            idNumber = Integer.parseInt(splitId[1]) + 1;
        } catch (NullPointerException n) {
            System.out.println("First Entry");
        }
	return "I2IT" + idNumber;
    }

    public void readElement() {
        Employee validEmployee = null;
        StringBuilder readChoice = new StringBuilder("+===+========You wanted to?===============+"
                                                      + "\n| 1 |----to READ Employee Details         |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 2 |----to READ Leave Records            |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 3 |----to READ Employee Projects        |"
                                                      + "\n+===+=====================================+"
                                                      + "\n|any|----except above choices to go back  |"   
                                                      + "\n+===+=====================================+");
        System.out.println(readChoice);
        String userChoice = getValidChoice();
        switch(userChoice) {
        case Constants.EXIT_OPERATION:
            System.out.println("Backing");
            break;
        case Constants.READ_EMPLOYEE:
            readEmployee();
            break;
        case Constants.READ_LEAVE_RECORD:
            validEmployee = getValidEmployee();
            if(validEmployee != null) {
                System.out.println(validEmployee.getLeaveRecords());
            } else 
                System.out.println("Employee Not Found");
            break;
        case Constants.READ_EMPLOYEE_PROJECT:
            validEmployee = getValidEmployee();
            if(validEmployee != null) {
                System.out.println(employeeProjectsServiceImpl.getEmployeeProject(validEmployee.getEmployeeId()));
            } else 
                System.out.println("Employee Not Found");
            break;
        default:
            System.out.println("An error occurred"); 
        }
    }

    /**
     * <p>
     * asks the choice in which method to read details
     * </p>
     *
     */
    private void readEmployee() {
        StringBuilder readOptions = new StringBuilder();
        readOptions.append("+===+=========READ EMPLOYEE DETAILS==========+"
                         + "\n| 1 |      Print All Employee Details        |" 
                         + "\n+===+========================================+"
                         + "\n| 2 |     Get Employee Details using id      |"
                         + "\n+===+========================================+"
                         + "\n|any|    except above choices to go back     |"
                         + "\n+===+========================================+");
        System.out.println(readOptions);
        switch(scanner.nextLine()) {
        case Constants.DISPLAY_ALL_EMPLOYEE_DETAILS:
            System.out.println(employeeServiceImpl.getEmployees());
            break;
        case Constants.DISPLAY_EMPLOYEE_DETAILS:
            System.out.println(getValidEmployee());
            break;
        default:
            System.out.println("Backing");
        }
    }

    public void updateElement() {
        StringBuilder updateChoice = new StringBuilder("+===+========You wanted to?===============+"
                                                      + "\n| 1 |       UPDATE Employee Details       |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 2 |       UPDATE Leave Records          |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 3 |       UPDATE Employee Projects      |"
                                                      + "\n+===+=====================================+"
                                                      + "\n|any|  except above choices to go back    |"   
                                                      + "\n+===+=====================================+");
        System.out.println(updateChoice);
        String userChoice = getValidChoice();
        if(!userChoice.equals(Constants.EXIT_OPERATION)) {
            Employee validEmployee = getValidEmployee();
            switch(userChoice) {
            case Constants.CREATE_EMPLOYEE:
                updateEmployee(validEmployee);
                break;
            case Constants.CREATE_LEAVE_RECORD:
                updateLeaveRecords(validEmployee);
                break;
            case Constants.CREATE_EMPLOYEE_PROJECT:
                updateEmployeeProjects(validEmployee);
                break;
            default:
                System.out.println("Choice isn't valid");
            }
        } else 
            System.out.println("backing");
    }

    /**
     * <p>
     * Output statement for showing options for update elements
     * </p>
     *
     */
    private void updateStatement() {
        StringBuilder updateOptions = new StringBuilder();
	updateOptions.append("+===+=========UPDATE ELEMENTS=============+"
                           + "\n| 1 |. To Update Employee Name            |"
                           + "\n+===+=====================================+"
                           + "\n| 2 |. To Update Employee Phone Number    |"
                           + "\n+===+=====================================+"
                           + "\n| 3 |. To Update Employee Department      |"
                           + "\n+===+=====================================+"
                           + "\n| 4 |. To Update Employee Date Of Birth   |"
                           + "\n+===+=====================================+"
                           + "\n| 5 |. To Update Employee Email           |"
                           + "\n+===+=====================================+"
                           + "\n| 6 |. To update Employee Role            |"
                           + "\n+===+=====================================+"
                           + "\n| 7 |. To Update Employee Gender          |"
                           + "\n+===+=====================================+"
                           + "\n| 8 |. To Save & Exit                     |"
                           + "\n+===+====================================+"
                           + "\n|any|. To Exit without saving ! CAUTION   |"
                           + "\n+===+=====================================+");
        System.out.println(updateOptions);
    }
    
    /**
     * <p>
     * Update each details of a employee
     * </p>
     *
     */ 
    public void updateEmployee(Employee employee) {
    for(;;) {			
                System.out.println("UPDATE PORTAL FOR EMPLOYEE ID: " + employee.getEmployeeId());
                System.out.println(employee);
		updateStatement();
                String updateElement = scanner.nextLine();
				
	        if (updateElement.equals(Constants.EDIT_NAME)) {	
                    employee.setEmployeeName(editName());
                    employee.setModifiedAt(currentDateTime());

		} else if (updateElement.equals(Constants.EDIT_PHONE_NUMBER))  {
                    employee.setEmployeePhoneNumber(editPhoneNumber()); 
                    employee.setModifiedAt(currentDateTime());

                } else if (updateElement.equals(Constants.EDIT_DEPARTMENT)) {	
                    employee.setEmployeeDepartment(editDepartment());
                    employee.setModifiedAt(currentDateTime());

                } else if (updateElement.equals(Constants.EDIT_DOB)) {	
                    employee.setEmployeeDateOfBirth(editDateOfBirth());
                    employee.setModifiedAt(currentDateTime());

                } else if (updateElement.equals(Constants.EDIT_EMAIL)) {
                    employee.setEmployeeEmail(editEmail());
                    employee.setModifiedAt(currentDateTime());

                } else if (updateElement.equals(Constants.EDIT_ROLE)) {
                    employee.setEmployeeRole(getValidRole().toString());
                    employee.setModifiedAt(currentDateTime());

                } else if (updateElement.equals(Constants.EDIT_GENDER)) {
                    employee.setEmployeeGender(getValidGender().toString());
                    employee.setModifiedAt(currentDateTime());

                } else if (updateElement.equals(Constants.FINISH_UPDATING)) {
                    employeeServiceImpl.updateEmployee(employee);
                    break;     

                } else {
                    System.out.println("Exited without saving");
                    break;
                }
            }  
    }

    /**
     *<p>
     * output statement for leave records update
     *</p>
     *
     */
    public void leaveRecordsUpdateStatement() {
        StringBuilder updateOptions = new StringBuilder();
	updateOptions.append("+===+===UPDATE ELEMENTS=======+"
                           + "\n| 1 |    Update From Date     |"
                           + "\n| 2 |    Update Till Date     |"
                           + "\n| 3 |    Update Leave Type    |"
                           + "\n| 4 |     Save and Exit       |"
                           + "\n| 5 |   Exit without Saving   |"
                           + "\n+===+=========================+");
        System.out.println(updateOptions);
    }

    /**
     * <p>
     * Updates leave record for employee
     * </p>
     *
     */ 
    public void updateLeaveRecords(Employee employee) {
        System.out.println(employee.getLeaveRecords());
        int userLeaveRecordId = Integer.parseInt(scanner.nextLine()); 
        LeaveRecords leaveRecord = leaveRecordsServiceImpl.getLeaveRecordById(userLeaveRecordId);

        if(leaveRecord != null) {
            for(;;) {			
                System.out.println(leaveRecord);
                leaveRecordsUpdateStatement();
                int updateElement = Integer.parseInt(scanner.nextLine());
				
	        if (updateElement == 1) {	
                    leaveRecord.setFromDate(scanner.nextLine());
                    leaveRecord.setModifiedAt(currentDateTime());
                
                } else if (updateElement == 2)  {
                    leaveRecord.setToDate(getValidLeaveDate()); 
                    leaveRecord.setModifiedAt(currentDateTime());

                } else if (updateElement == 3) {	
                    leaveRecord.setLeaveType(getValidLeaveType().toString());
                    leaveRecord.setModifiedAt(currentDateTime());
                    
                } else  if (updateElement == 4) {
                    if (leaveRecordsServiceImpl.updateLeaveRecords(leaveRecord)) {
                        System.out.println("Update is successfull");
                    }
                    break;
                } else if (updateElement == 5) {
                    break;
                }
            }
        }
    }

    /**
     * <p>
     * Updates employee project
     * </p>
     *
     */ 
    public void updateEmployeeProjects(Employee employee) {
        /*EmployeeProjects employeeProjects = employeeProjectsServiceImpl.getEmployeeProject(employee); 
    
        for(;;) {			
            System.out.println(employeeProjects);
            leaveRecordsUpdateStatement();
            int updateElement = scanner.nextInt();
				
	    if (updateElement == 1) {	
                employeeProjects.setProjectName(scanner.nextLine());
                employeeProjects.setModifiedAt(currentDateTime());
                employeeProjectsServiceImpl.updateEmployeeProjects(employeeProjects);

	    } else if (updateElement == 2)  {
                employeeProjects.setProjectManager(scanner.nextLine()); 
                employeeProjects.setModifiedAt(currentDateTime());
                employeeProjectsServiceImpl.updateEmployeeProjects(employeeProjects);

            } else if (updateElement == 3) {	
                employeeProjects.setClientName(scanner.nextLine());
                employeeProjects.setModifiedAt(currentDateTime());
                employeeProjectsServiceImpl.updateEmployeeProjects(employeeProjects);

            } else if (updateElement == 4) {	
                employeeProjects.setStartDate(scanner.nextLine());
                employeeProjects.setModifiedAt(currentDateTime());
                employeeProjectsServiceImpl.updateEmployeeProjects(employeeProjects);

            } else {
                System.out.println("Backing");
            }
        }*/ 
    }    

    public void deleteElement() {
        StringBuilder updateChoice = new StringBuilder("+===+======YOU WANT TO DELETE?============+"
                                                      + "\n| 1 |         Employee Details            |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 2 |          Leave Records              |"
                                                      + "\n+===+=====================================+"
                                                      + "\n| 3 |        Employee Projects            |"
                                                      + "\n+===+=====================================+"
                                                      + "\n|any|  except above choices to go back    |"   
                                                      + "\n+===+=====================================+");
        System.out.println(updateChoice);
        String userChoice = getValidChoice();
        if(!userChoice.equals(Constants.EXIT_OPERATION)) {
            Employee validEmployee = getValidEmployee();
            switch(userChoice) {
            case Constants.CREATE_EMPLOYEE:
                deleteEmployee(validEmployee);
                break;
            case Constants.CREATE_LEAVE_RECORD:
                //deleteLeaveRecords(validEmployee);
                break;
            case Constants.CREATE_EMPLOYEE_PROJECT:
                //deleteEmployeeProjects(validEmployee);
                break;
            default:
                System.out.println("Choice isn't valid");
            }
        } else 
            System.out.println("backing");
    }

    /**
     * <p>
     * deletes an employee
     * </p>
     *
     */ 
    public void deleteEmployee(Employee employee) {
        StringBuilder updateChoice = new StringBuilder   ("+===+====YOU ARE DELETING AN EMPLOYE======+"
                                                      + "\n+===+==========Id: " + employee.getEmployeeId() + "==================+"
                                                      + "\n+===+========Are you sure?================+"
                                                      + "\n| 1 |      YES (Data will be lost)        |"
                                                      + "\n+===+=====================================+"
                                                      + "\n|any|           NO (Retract)              |"
                                                      + "\n+===+=====================================+");
        System.out.println(updateChoice);
        switch(getValidChoice()) {
        case Constants.YES:
            if (employeeServiceImpl.removeEmployee(employee) > 0) {
                System.out.println("============Employee Deleted==================");
            } else {
                System.out.println("An Error Occured: While Deleting Employee");
            }
        default:
            System.out.println("Backing");
        }
    }

    /**
     * <p> 
     * checks the employee is present in the
employee List
     * </p>
     *
     * @param employeeId
     *        id of the employee received from the user for checking
     *
     * @return boolen value
     *         true if the employee is present
     */
    public boolean isEmployeeValid(String employeeId) {
        boolean isValid = false;

        Employee employee = employeeServiceImpl.getEmployeeById(employeeId); 
	if(employee != null) {
            isValid = true;
        } 
        return isValid;
    }

    public Employee getValidEmployee() {
        System.out.println("Enter Employee Id");
        String employeeId = scanner.nextLine();
 
        Employee employee = employeeServiceImpl.getEmployeeById(employeeId);
        if(employee != null) {
            return employee;
        }
        return null;
    }

    /**
     * <p> 
     * gets the input for the name of the employee to get
them updated
     * </p>
     *
     */
    public String editName() {
        System.out.println("Change Name to? "); 
        return getValidName();
    }

    /**
     * <p> 
     * gets the input for the Phone Number of the employee to get
them updated
     * </p>
     *
     */
    public String editPhoneNumber() {
        System.out.println("Change Employee phone number to? ");
        return getValidPhoneNumber();
    }

    /**
     * <p> 
     * gets the input for the Date Of Birth of the employee to get
them updated
     * </p>
     *
     */
    public String editDepartment() {
        System.out.println("Change Department to?");  
        return getValidDept();
    }

    /**
     * <p> 
     * gets the input for the Date Of Birth of the employee to get
them updated
     * </p>
     *
     */
    public String editDateOfBirth() {
        System.out.println("Change Date of birth to?");  
        return getValidDateOfBirth();
    }

    /**
     * <p> 
     * gets the input for the Gender of the employee to get
them updated
     * </p>
     *
     */
    public EmployeeGender editGender() {
        System.out.println("Change Gender to?");  
        return getValidGender();
    } 

    /**
     * <p> 
     * gets the input for the Email of the employee to get
them updated
     * </p>
     *
     */
    public String editEmail() {
        System.out.println("Change Email to?");  
        return getValidEmail();
    }

    /**
     *<p>
     * gets the input for Leave Type and checks the Leave type is valid
     *</p>
     *
     * @return Type of leave alloted for the employee
     */
    private LeaveType getValidLeaveType() {
        LeaveType leaveType;     
        for(;;) {
            StringBuilder leaveTypeChoice = new StringBuilder();
	    leaveTypeChoice.append("=============Enter Employee Gender================="
                              + "\n1 Sick leave"
                              + "\n2 Casual leave"
                              + "\n==============================");
            System.out.println(leaveTypeChoice);
            int userChoice = Integer.parseInt(scanner.nextLine());
            leaveType = LeaveType.getLeaveType(userChoice);
            if(leaveType != null) {
                leaveType = leaveType; 
                break;
            } else {
                System.out.println("Please enter a valid Choice for Leave Type");
            }
        } 
        return leaveType;
    }

    /**
     *<p>
     * current date and time for createdAt and modifiedAt feature
     *</p>
     *
     * @return Type of leave alloted for the employee
     */
    public String currentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return localDateTime.format(dateTime);
    }

     /**
     *<p>
     * output statement for employee projects update
     *</p>
     *
     */
    public void employeeProjectsUpdateStatement() {
        StringBuilder updateOptions = new StringBuilder();
	updateOptions.append("====================UPDATE ELEMENTS========================="
                           + "\n1.To Update Project Name"
                           + "\n2.To Update Project Manager"
                           + "\n3.To Update Client Name"
                           + "\n4.To Update Start Date"
                           + "\n=========================================================");
        System.out.println(updateOptions);
    }

    /**
     * <p>
     * To validate user name input
     * </p>
     * 
     * @return the name if the entered name is valid
     */
    public String getValidName() {
        ValidationUtils validationUtils = new ValidationUtils();
        String name;
        for(;;) {
            name = scanner.nextLine();
            if(validationUtils.nameValidation(name)) {
                break;
            }  else {
                System.out.println("Enter a valid name");
            }
        }
        return name;
    } 

    /**
     * <p>
     * To validate user phone Number input
     * </p>
     * 
     * @return the phone number if the entered phone number is valid
     */
    public String getValidPhoneNumber() {
        ValidationUtils validationUtils = new ValidationUtils();
        String phoneNumber;
        for(;;) {
            phoneNumber = scanner.nextLine();
            if(validationUtils.phoneNumberValidation(phoneNumber)) {
                break;
            }  else {
                System.out.println("Enter a valid Phone Number");
            }
        }
        return phoneNumber;
    }    

    /**
     * <p>
     * To validate user email input
     * </p>
     * 
     * @return the phone number if the entered phone number is valid
     */
    public String getValidEmail() {
        ValidationUtils validationUtils = new ValidationUtils();
        String emailId;
        for(;;) {
            emailId = scanner.nextLine();
            if(validationUtils.emailValidation(emailId)) {
                break;
            }  else {
                System.out.println("Enter a valid Email ID (ex abc123@gmail.com)");
            }
        }
        return emailId;
    } 
   
    /**
     * <p>
     * To get valid date of birth from the user
     * </p>
     *
     * @return the valid date of birth
     */ 
    public String getValidDateOfBirth() { 
    ValidationUtils validationUtils = new ValidationUtils();
    String userDate;
        for(;;) {
            userDate = scanner.nextLine();
            if(validationUtils.dateValidation(userDate)) {
                int age = dateDifference(userDate);
                if(age!= 0 && age>=18) {
                    break;
                } 
            }
            System.out.println("Enter a valid date:");
        }
        return userDate;
    }

    /**
     * <p>
     * To validate date input from the user, can be used for
both date of birth and date of joining input
     * </p>
     *
     * @return the date 
     */ 
    public String getValidLeaveDate() { 
    ValidationUtils validationUtils = new ValidationUtils();
    String userDate;
        for(;;) {
            userDate = scanner.nextLine();
            if(validationUtils.dateValidation(userDate)) {
                if(daysDifference(userDate)!= 0) {
                    break;
                } 
            }
            System.out.println("Enter a valid date:");
        }
        return userDate;
    }        

    /**
     * <p>
     * finds the difference between  date of birth and current date, 
can be used for date of birth
     * </p>
     * @param userDate
     *        contains the date the user inputs
     * @return the difference between current year and the year the user enters
     */ 
    public int dateDifference(String userDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        int difference = 0;
        try {
            for(;;) {
                Date currentDate = new Date();
                Date date = dateFormat.parse(userDate);
                Calendar currentCalendar = Calendar.getInstance();

                Calendar dateCalendar = Calendar.getInstance();
                dateCalendar.setTime(date); 

                if(dateCalendar.get(Calendar.YEAR) < (currentCalendar.get(Calendar.YEAR))) {
                    difference = currentCalendar.get(Calendar.YEAR) - dateCalendar.get(Calendar.YEAR);
                    break;
                } else {
                    return 0; 
                }   
            }
        } catch (ParseException e) {
            System.out.println(e);
        }
        return difference;
    }

    /**
     * <p>
     * finds the difference between from date and to date for
leave records
     * </p>
     * @param userDate
     *        contains the date the user inputs
     * @return the difference between current year and the year the user enters
     */ 
    public int daysDifference(String userDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        int difference = 0;
        try {
            for(;;) {
                Date currentDate = new Date();
                Date date = dateFormat.parse(userDate);
                Calendar currentCalendar = Calendar.getInstance();

                Calendar dateCalendar = Calendar.getInstance();
                dateCalendar.setTime(date); 

                if(dateCalendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)) {
                    if(dateCalendar.get(Calendar.MONTH) == currentCalendar.get(Calendar.MONTH)) {
                        difference = currentCalendar.get(Calendar.DATE) - dateCalendar.get(Calendar.DATE);
                    }
                    break;
                } else {
                    return 0; 
                }   
            }
        } catch (ParseException e) {
            System.out.println(e);
        }
        return difference;
    }
    /**
     * <p>
     * To validate user name input
     * </p>
     * 
     * @return the name if the entered name is valid
     */
    public String getValidDept() {
        ValidationUtils validationUtils = new ValidationUtils();
        String department;
        for(;;) {
            department = scanner.nextLine();
            if(validationUtils.nameValidation(department)) {
                break;
            }  else {
                System.out.println("Enter a valid department");
            }
        }
        return department;
    } 
}       