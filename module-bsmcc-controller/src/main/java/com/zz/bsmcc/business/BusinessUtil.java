package com.zz.bsmcc.business;

import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bsmcc.base.bo.TcgProjectBO;
import com.zz.bsmcc.core.Applications;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Administrator
 */
public class BusinessUtil {



    public static String getBasePath() {
        String basePath = Applications.getUsrDir()+ File.separator + "cg";
        ILoginUserEntity session = Applications.getLoginUserEntity();

        if(session != null ){
            basePath = basePath + File.separator + session.getId();
        }
        return basePath;
    }

    public static StringBuilder getProjectNote(TcgProjectBO projectBO) {
        String projectNote = projectBO.getProjectNote();
        StringBuilder projectNoteBuild = new StringBuilder("");
        if(StringUtils.isNotEmpty(projectNote)){
            String[] notes = projectNote.split("\n");
            projectNoteBuild.append("/**").append("\n");
            for(String note : notes ){
                projectNoteBuild.append(" * ").append(note).append("\n");
            }
            projectNoteBuild.append(" */").append("\n");
        }
        return projectNoteBuild;
    }


    /**
     * 生成文件
     * @param filePath
     * @param fileName
     * @param result
     */
    public static void buildFile(String filePath, String fileName, String result) {
        OutputStream output = null;
        try {
            if(result != null && !result.isEmpty()){
                File dir = new File(filePath);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                File f = new File(dir.getAbsolutePath() , fileName);
                output = new FileOutputStream(f);
                IOUtils.write(result , output , "UTF-8");
                output.flush();
                output.close(); output = null;
            }
        } catch (Exception e) {
            throw new BizException(e);
        }finally {
            if(output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                output = null;
            }
        }
    }

}
