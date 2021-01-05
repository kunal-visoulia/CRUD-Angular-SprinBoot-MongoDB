package in.kvisoulia.CRUDMongoDB.Controller;

import in.kvisoulia.CRUDMongoDB.Exception.ResourceNotFoundException;
import in.kvisoulia.CRUDMongoDB.Model.Employee;
import in.kvisoulia.CRUDMongoDB.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    //ResponseEntity cuz employee could be found or not found
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee>  getEmployeeById(@PathVariable("id") Long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
        return ResponseEntity.ok(emp);

    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
        employeeRepository.save(emp);
        return ResponseEntity.ok(emp);
    }

    //don't want to create new emp if not exists
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee empDetails){
        Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
//        Resource not found gives
//        {
//            "timestamp": "2021-01-04T18:33:18.401+00:00",
//                "status": 404,
//                "error": "Not Found",
//                "trace": "in.kvisoulia.CRUDMongoDB.Exception.ResourceNotFoundException: Employee does not exist with id: 9\r\n\tat in.kvisoulia.CRUDMongoDB.Controller.EmployeeController.lambda$updateEmployee$1(EmployeeController.java:44)\r\n\tat java.util.Optional.orElseThrow(Optional.java:290)\r\n\tat in.kvisoulia.CRUDMongoDB.Controller.EmployeeController.updateEmployee(EmployeeController.java:44)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)\r\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1061)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)\r\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\r\n\tat org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:655)\r\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\r\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\r\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\r\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\r\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\r\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\r\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\r\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\r\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\r\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:888)\r\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1597)\r\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\r\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\r\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n\tat java.lang.Thread.run(Thread.java:748)\r\n",
//                "message": "Employee does not exist with id: 9",
//                "path": "/api/v1/employee/9"
//        }

        emp.setFirstName(empDetails.getFirstName());
        emp.setLastName(empDetails.getLastName());
        emp.setEmail(empDetails.getEmail());

        Employee updatedEmployee = employeeRepository.save(emp);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable("id") long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
        employeeRepository.delete(emp);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return ResponseEntity.ok(response);
    }


}
