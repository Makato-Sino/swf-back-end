package com.sysu.swfbackend.controller;

import com.sysu.swfbackend.SecurityUtil;
import com.sysu.swfbackend.bean.UserInfoBean;
import com.sysu.swfbackend.util.AjaxResponse;
import com.sysu.swfbackend.util.GlobalConfig;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipInputStream;

@RestController
@RequestMapping("/processDefinition")
public class ProcessDefinitionController {

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private RepositoryService repositoryService;

    /**
     * 上传BPMN文件并部署
     * @param userInfoBean
     * @param multipartFile
     * @param processName
     * @return
     */
//    @PostMapping(value = "/uploadStreamAndDeployment")
//    @RequestMapping(value = "/uploadStreamAndDeployment", method = RequestMethod.POST)
//    public AjaxResponse uploadStreamAndDeployment(@AuthenticationPrincipal UserInfoBean userInfoBean,
//                                                  @RequestParam("processFile") MultipartFile multipartFile,
//                                                  @RequestParam("processName") String processName) {
//        try {
//
//            // 获取文件名
//            String fileName = multipartFile.getOriginalFilename();
//            // 获取文件扩展名
//            String extension = FilenameUtils.getExtension(fileName);
//            // 获取文件字节流对象
//            InputStream fileInputStream = multipartFile.getInputStream();
//
//            Deployment deployment = null;
//            if (extension.equals("zip")) {
//                ZipInputStream zip = new ZipInputStream(fileInputStream);
//                deployment = repositoryService.createDeployment()
//                        .addZipInputStream(zip)
//                        .name(processName)
//                        .tenantId(userInfoBean.getUsername())
//                        .deploy();
//            } else {
//                deployment = repositoryService.createDeployment()
//                        .addInputStream(fileName, fileInputStream)
//                        .name(processName)
//                        .tenantId(userInfoBean.getUsername())
//                        .deploy();
//            }
//
//            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(),
//                                    GlobalConfig.ResponseCode.SUCCESS.getDesc(),
//                                    deployment.getId() + ";" + fileName
//            );
//        } catch (Exception e) {
//            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
//        }
//    }

    @RequestMapping(value = "/uploadStreamAndDeployment", method = RequestMethod.POST)
    public AjaxResponse uploadStreamAndDeployment(@RequestParam("username") String username,
                                                  @RequestParam("processFile") MultipartFile multipartFile,
                                                  @RequestParam("processName") String processName) {
        try {

            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            // 获取文件扩展名
            String extension = FilenameUtils.getExtension(fileName);
            // 获取文件字节流对象
            InputStream fileInputStream = multipartFile.getInputStream();

            Deployment deployment = null;
            if (extension.equals("zip")) {
                ZipInputStream zip = new ZipInputStream(fileInputStream);
                deployment = repositoryService.createDeployment()
                        .addZipInputStream(zip)
                        .name(processName)
                        .tenantId(username)
                        .deploy();
            } else {
                deployment = repositoryService.createDeployment()
                        .addInputStream(fileName, fileInputStream)
                        .name(processName)
                        .tenantId(username)
                        .deploy();
            }

            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(),
                    GlobalConfig.ResponseCode.SUCCESS.getDesc(),
                    deployment.getId() + ";" + fileName
            );
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 获取流程定义列表
     * @return
     */
    @GetMapping(value = "/getDefinitions")
    public AjaxResponse getDefinitions() {
        try {
            List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();

            List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();

            for (ProcessDefinition pd : list) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", pd.getName());
                hashMap.put("key", pd.getKey());
                hashMap.put("resourceName", pd.getResourceName());
                hashMap.put("deploymentID", pd.getDeploymentId());
                hashMap.put("version", pd.getVersion());
                listMap.add(hashMap);
            }
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), listMap);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 获取流程部署列表
     * @return
     */
    @GetMapping(value = "/getDeployments")
    public AjaxResponse getDeployments() {
        try {
            List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();

            List<Deployment> list = repositoryService.createDeploymentQuery().list();
            for (Deployment dep : list) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("Id", dep.getId());
                hashMap.put("Name", dep.getName());
                hashMap.put("DeploymentTime", dep.getDeploymentTime());
                hashMap.put("Username", dep.getTenantId());
//                hashMap.put("Key", dep.getKey());
                listMap.add(hashMap);
            }
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), listMap);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 删除流程定义
     * @param pdID
     * @return
     */
    @GetMapping(value = "/delDefinition")
    public AjaxResponse delDefinition(@RequestParam("pdID") String pdID) {
        try {
            repositoryService.deleteDeployment(pdID, true);
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), null);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }
}
