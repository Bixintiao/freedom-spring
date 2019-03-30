package justTest;

import com.hzy.modules.activiti.WorkFlowVO;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ActivitiTest {


    final static String PROCESS_DEFINITION_KEY = "process_leave_test";


    /**
     * 部署流程
     */
    @Test
    public void actDeploymentTest(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deploy = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("bpmn/"+PROCESS_DEFINITION_KEY+".bpmn")
                .deploy();

        System.out.println("**************************  deploy success  ************************");
        System.out.println("deploy id:"+deploy.getId());
        System.out.println("deploy category:"+deploy.getCategory());
        System.out.println("deploy key:"+deploy.getKey());
        System.out.println("deploy name:"+deploy.getName());
        System.out.println("deploy tenantId:"+deploy.getTenantId());
        System.out.println("deploy class:"+deploy.getClass().getName());
    }


    /**
     * 查询流程定义
     */
    @Test
    public void actQueryAllDefinition(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //ACT_RE_DEPLOYMENT
        List<Deployment> deployments = processEngine.getRepositoryService().createDeploymentQuery().list();
        System.out.println("************** deployments **************");
        deployments.forEach(deployment->{
            System.out.println("id:"+deployment.getId());
            System.out.println("key:"+deployment.getKey());
            System.out.println("name:"+deployment.getName());
            System.out.println("category:"+deployment.getCategory());
            System.out.println("tenantId:"+deployment.getTenantId());
        });

        //ACT_RE_PROCDEF
        ProcessDefinition processDefinition = processEngine.getRepositoryService().getProcessDefinition("process_leave_test:1:4");
        System.out.println("************* processDefinition *************");
        System.out.println("id:"+processDefinition.getId());
        System.out.println("key:"+processDefinition.getKey());
        System.out.println("name:"+processDefinition.getName());
        System.out.println("category:"+processDefinition.getCategory());
        System.out.println("tenantId:"+processDefinition.getTenantId());
    }


    /**
     * 启动流程实例
     */
    @Test
    public void actStartInstance(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        Map<String,Object> variables = new HashMap<String,Object>();
        WorkFlowVO workFlowVO = new WorkFlowVO();
        workFlowVO.setComment("work flow ForTest ...");
        variables.put("workFlowVO",workFlowVO);
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById("process_leave_test","1433223",variables);

        System.out.println("**************************  start success  ************************");
        System.out.println("businessKey:"+processInstance.getBusinessKey());
        System.out.println("processDefinitionId:"+processInstance.getProcessDefinitionId());
        System.out.println("processDefinitionKey:"+processInstance.getProcessDefinitionKey());
        System.out.println("processDefinitionName:"+processInstance.getProcessDefinitionName());
        System.out.println("description:"+processInstance.getDescription());
        System.out.println("startUserId:"+processInstance.getStartUserId());
    }



    /**
     * @param tasks
     * 打印多个
     */
    public static void printTask(List<Task> tasks){
        System.out.println("************************** tasks  **************************");
        tasks.forEach(task -> printTask(task));
    }

    /**
     * @param task
     * 打印任务
     */
    public static void printTask(Task task){
        System.out.println(
                "id:" + task.getId()
                        + "\t name:" + task.getName()
                        + "\t assignee:" + task.getAssignee()
                        + "\t claimTime:" + task.getClaimTime()
                        + "\t category:" + task.getCategory()
                        + "\t processInstanceId:"+task.getProcessInstanceId());
    }



}
