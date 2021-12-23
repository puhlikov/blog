package com.epam.training;
import org.apache.tools.ant.*;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildValidator extends Task {
    private String regex = "[a-zA-Z]+[-]{0,1}[a-zA-Z]";

    private boolean checkdepends;
    private boolean checkdefault;
    private boolean checknames;
    private Project newProject;

    private List<FileBuild> fileBuilds = new ArrayList<>();


public Project createProject(FileBuild fileBuild){
    this.newProject = new Project();
    ProjectHelper.configureProject(newProject, new File(fileBuild.getPosition()));
    return newProject;
}

public static  class FileBuild{
        private String position;

        FileBuild(){}

        public void setPosition(String position){
            this.position = position;
        }
        public  String getPosition() {
            return  position;
        }
    }

    @Override
    public void execute() throws BuildException {
        for (FileBuild fileBuild : fileBuilds)
            createProject(fileBuild);

        if (checkdefault) {
            defaultFound();
        }
        if (checkdepends) {
            dependsUsedInMain();
        }
        if (checknames) {
            nameCorrect();
        }
    }

    private void setCheckDefault (boolean checkDefault){
        this.checkdefault = checkDefault;
    }
    private void setCheckDepends (boolean checkDepends){
        this.checkdepends = checkDepends;
    }
    private void setCheckNames (boolean checkNames){
        this.checknames = checkNames;
    }

    private boolean defaultFound() throws BuildException {
        if (checkdefault) {
            String defaultTarget = newProject.getDefaultTarget();
            return defaultTarget != null;
        }
        return true;
    }

    private Hashtable<String,Target> getTarget() {
        return this.newProject.getTargets();
    }
    private String getDefaultTarget() {
        return newProject.getDefaultTarget();
    }


    private void nameCorrect() {
        Matcher matcher;
        Set<Map.Entry<String,Target>> targets = getTarget().entrySet();
        Pattern pattern = Pattern.compile(regex);
        for (Map.Entry<String,Target> target : targets){
            String nameTarget = target.getKey();
            matcher = pattern.matcher(nameTarget);
            if (!matcher.matches() && !nameTarget.isEmpty()){
                throw new BuildException("Name is not correct" + nameTarget);
            }
        }
        log("Names are correct.");
    }

    private void dependsUsedInMain(){
        Target targetInMain = getTarget().get(getDefaultTarget());
        boolean dependsEmpty = targetInMain.getDependencies().hasMoreElements();
        if (!dependsEmpty){
            throw new BuildException("Empty depends found.");
        }
        Set<String> targets = getTarget().keySet();
        targets.remove(getDefaultTarget());
        for (String target : targets){
            boolean dependsIs = getTarget().get(target).getDependencies().hasMoreElements();
            if (dependsIs){
                throw new BuildException("Depends not correct");
            }
        }
        log("Depends correct");
    }

}
